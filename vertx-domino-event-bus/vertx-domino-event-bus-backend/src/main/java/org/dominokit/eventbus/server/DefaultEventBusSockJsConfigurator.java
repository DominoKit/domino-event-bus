package org.dominokit.eventbus.server;

import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.eventbus.shared.VertxBusContext;

public class DefaultEventBusSockJsConfigurator implements EventBusSockJsConfigurator {
    @Override
    public SockJSHandler configure(VertxContext vertxContext) {
        BridgeOptions bridgeOptions = new BridgeOptions();
        bridgeOptions.addOutboundPermitted(new PermittedOptions().setAddress(VertxBusContext.DEFAULT_SOCKJS_ADDRESS));

        SockJSHandler sockJSHandler = SockJSHandler.create(vertxContext.vertx());
        sockJSHandler.bridge(bridgeOptions, event -> event.complete(true));

        sockJSHandler.socketHandler(event -> event.headers().set(ACCESS_CONTROL_ALLOW_ORIGIN, ALLOW_ALL));
        return sockJSHandler;
    }
}
