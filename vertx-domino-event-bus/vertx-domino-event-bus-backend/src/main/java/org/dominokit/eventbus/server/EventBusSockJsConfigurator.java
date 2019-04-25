package org.dominokit.eventbus.server;


import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import org.dominokit.domino.api.server.entrypoint.VertxContext;

@FunctionalInterface
public interface EventBusSockJsConfigurator {

    String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    String ALLOW_ALL = "*";

    SockJSHandler configure(VertxContext vertxContext);
}
