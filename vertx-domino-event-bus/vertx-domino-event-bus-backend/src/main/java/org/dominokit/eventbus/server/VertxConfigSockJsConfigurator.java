package org.dominokit.eventbus.server;

import com.google.auto.service.AutoService;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.handler.CSRFHandler;
import io.vertx.ext.web.handler.CookieHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import org.dominokit.domino.api.server.config.VertxConfiguration;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.eventbus.shared.VertxBusContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample configurations
 * <p>
 * "sockjs.configurator" : "com.progressoft.brix.domino.vertxbus.server.entrypoint.VertxConfigSockJsConfigurator",
 * "domino.eventbus.sockjs" : {
 * "CSRF.protected" : true,
 * "CSRFSecret" : "valid-secret",
 * "allowed.origins" : [ "*" ],
 * "addresses" : {
 * "inbound" : [ {"address" : "someaddress"
 * }, {
 * "address" : "otheraddress",
 * "required.authority" : "write"
 * } ],
 * "outbound" : [ {
 * "address" : "someaddress",
 * "required.authority" : "read"
 * }, {
 * "address" : "otheraddress"
 * } ]
 * }
 * }
 */
@AutoService(EventBusSockJsConfigurator.class)
public class VertxConfigSockJsConfigurator implements EventBusSockJsConfigurator {

    private static final String CONFIG_KEY = "domino.eventbus.sockjs";
    private static final String CSRF_PROTECTED = "CSRF.protected";
    private static final String CSRF_SECRET = "CSRFSecret";
    private static final String EMPTY_CSRF_SECRET = "";
    private static final String ADDRESS = "address";
    private static final String ADDRESSES = "addresses";
    private static final String INBOUND = "inbound";
    private static final String OUTBOUND = "outbound";
    private static final String ALLOWED_ORIGINS = "allowed.origins";
    private static final String REQUIRED_AUTHORITY = "required.authority";


    @Override
    public SockJSHandler configure(VertxContext vertxContext) {
        VertxConfiguration config = (VertxConfiguration) vertxContext.config();
        JsonObject sockJsConfig = config.getJsonObject(CONFIG_KEY, makeDefaultConfig());

        BridgeOptions bridgeOptions = configureBridgeOptions(sockJsConfig);

        SockJSHandler sockJSHandler = configureSockJsHandler(vertxContext, bridgeOptions, sockJsConfig);
        boolean CSRFProteceted = sockJsConfig.getBoolean(CSRF_PROTECTED, false);
        if (CSRFProteceted) {
            if (config.getString(CSRF_SECRET, EMPTY_CSRF_SECRET).isEmpty() || config.getString(CSRF_SECRET,
                    EMPTY_CSRF_SECRET).length() < 12)
                throw new CsrfProtectionEnabledBuInvalidSecretProvided();
            vertxContext.router().route().path(VertxBusContext.DEFAULT_EVENTBUS_PATH).handler(CookieHandler.create());
            vertxContext.router().route().path(VertxBusContext.DEFAULT_EVENTBUS_PATH).handler(
                    CSRFHandler.create(config.getString(CSRF_SECRET, EMPTY_CSRF_SECRET)));
        }
        return sockJSHandler;
    }

    private JsonObject makeDefaultConfig() {
        JsonObject defaultConfig = new JsonObject();
        defaultConfig.put(CSRF_PROTECTED, false);
        List<String> originsList = new ArrayList<>();
        originsList.add(ALLOW_ALL);
        defaultConfig.put(ALLOWED_ORIGINS, new JsonArray(originsList));

        JsonArray outbound = new JsonArray();
        outbound.add(new JsonObject().put(ADDRESS, VertxBusContext.DEFAULT_SOCKJS_ADDRESS));


        JsonArray inbound = new JsonArray();
        inbound.add(new JsonObject().put(ADDRESS, VertxBusContext.DEFAULT_SOCKJS_ADDRESS));

        defaultConfig.put(ADDRESSES, new JsonObject().put(INBOUND, inbound).put(OUTBOUND, outbound));

        return defaultConfig;
    }

    private SockJSHandler configureSockJsHandler(VertxContext vertxContext, BridgeOptions bridgeOptions,
                                                 JsonObject config) {
        SockJSHandler sockJSHandler = SockJSHandler.create(vertxContext.vertx());
        sockJSHandler.bridge(bridgeOptions, event -> event.complete(true));
        JsonArray jsonArray = config.getJsonArray(ALLOWED_ORIGINS, new JsonArray().add("*"));

        sockJSHandler.socketHandler(event -> jsonArray.forEach(o -> event.headers().set(ACCESS_CONTROL_ALLOW_ORIGIN, (String) o)));
        return sockJSHandler;
    }

    private BridgeOptions configureBridgeOptions(JsonObject config) {
        BridgeOptions bridgeOptions = new BridgeOptions();
        JsonObject addresses = config.getJsonObject(ADDRESSES);

        JsonArray outbounds = addresses.getJsonArray(OUTBOUND);
        JsonArray inbounds = addresses.getJsonArray(INBOUND);

        outbounds.forEach(o -> addOutboundPermitted(bridgeOptions, (JsonObject) o));
        inbounds.forEach(i -> addInboundPermitted(bridgeOptions, (JsonObject) i));
        return bridgeOptions;
    }


    private void addOutboundPermitted(BridgeOptions bridgeOptions, JsonObject outbound) {
        PermittedOptions permittedOptions = new PermittedOptions();

        permittedOptions.setAddress(outbound.getString(ADDRESS));

        String authority = outbound.getString(REQUIRED_AUTHORITY, EMPTY_CSRF_SECRET);
        if (!authority.isEmpty())
            permittedOptions.setRequiredAuthority(authority);

        bridgeOptions.addOutboundPermitted(permittedOptions);
    }

    private void addInboundPermitted(BridgeOptions bridgeOptions, JsonObject inbound) {
        PermittedOptions permittedOptions = new PermittedOptions();

        permittedOptions.setAddress(inbound.getString(ADDRESS));

        String authority = inbound.getString(REQUIRED_AUTHORITY, EMPTY_CSRF_SECRET);
        if (!authority.isEmpty())
            permittedOptions.setRequiredAuthority(authority);

        bridgeOptions.addInboundPermitted(permittedOptions);
    }

    class CsrfProtectionEnabledBuInvalidSecretProvided extends RuntimeException {
        CsrfProtectionEnabledBuInvalidSecretProvided() {
            super("secret length is less than 12.");
        }
    }
}
