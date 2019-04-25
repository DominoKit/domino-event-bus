package org.dominokit.sample.eventbus.server;

import com.google.auto.service.AutoService;
import org.dominokit.domino.api.server.entrypoint.ServerAppEntryPoint;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.eventbus.shared.VertxBusContext;

import java.util.Random;

@AutoService(ServerAppEntryPoint.class)
public class SampleEventBusEntryPoint implements ServerAppEntryPoint<VertxContext> {
    @Override
    public void onModulesLoaded(VertxContext vertxContext) {
        vertxContext.vertx().setPeriodic(1000, event -> vertxContext.vertx().eventBus().publish(VertxBusContext.DEFAULT_SOCKJS_ADDRESS, new Random().nextInt()));
    }
}
