package org.dominokit.eventbus.server;

import com.google.auto.service.AutoService;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import org.dominokit.domino.api.server.config.ServerConfiguration;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.eventbus.shared.VertxBusContext;

import java.util.Iterator;
import java.util.ServiceLoader;

@AutoService(VertxEntryPoint.class)
public class SockJsEntryPoint implements VertxEntryPoint {

    public static final String SOCKJS_CONFIGURATOR_CONFIG_KEY = "sockjs.configurator";

    @Override
    public void onVertxStartup(VertxContext vertxContext) {
        if (vertxContext.config().getBoolean("enable.default.sockjs", true)) {
            ServerConfiguration serverConfiguration = vertxContext.config();
            if (serverConfiguration.getString(SOCKJS_CONFIGURATOR_CONFIG_KEY, "").isEmpty())
                configureDefault(vertxContext);
            else
                configureWithConfigurator(vertxContext, serverConfiguration);
        }
    }

    private void configureWithConfigurator(VertxContext vertxContext,
                                           ServerConfiguration serverConfiguration) {
        ServiceLoader<EventBusSockJsConfigurator> configurators = ServiceLoader.load(EventBusSockJsConfigurator.class);
        String targetConfigurator = serverConfiguration.getString(SOCKJS_CONFIGURATOR_CONFIG_KEY);
        Iterator<EventBusSockJsConfigurator> configuratorIterator = configurators.iterator();
        while (configuratorIterator.hasNext()) {
            EventBusSockJsConfigurator configurator = configuratorIterator.next();
            if (configurator.getClass().getName().equals(targetConfigurator)) {
                SockJSHandler sockJSHandler = configurator.configure(vertxContext);
                vertxContext.router().route().path(VertxBusContext.DEFAULT_EVENTBUS_PATH).handler(sockJSHandler);
                return;
            }
        }

        throw new SockJsConfiguratorNotFoundInClassPathException(targetConfigurator);
    }

    private void configureDefault(VertxContext vertxContext) {
        SockJSHandler sockJSHandler = new DefaultEventBusSockJsConfigurator().configure(vertxContext);
        vertxContext.router().route().path(VertxBusContext.DEFAULT_EVENTBUS_PATH).handler(sockJSHandler);
    }

    public static class SockJsConfiguratorNotFoundInClassPathException extends RuntimeException {
        public SockJsConfiguratorNotFoundInClassPathException(
                String targetConfigurator) {
            super(targetConfigurator);
        }
    }
}
