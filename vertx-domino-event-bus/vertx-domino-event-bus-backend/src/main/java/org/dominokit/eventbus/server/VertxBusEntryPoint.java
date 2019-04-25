package org.dominokit.eventbus.server;

import com.google.auto.service.AutoService;
import org.dominokit.domino.api.server.entrypoint.ServerAppEntryPoint;
import org.dominokit.domino.api.server.entrypoint.VertxContext;

import java.util.ServiceLoader;

@AutoService(ServerAppEntryPoint.class)
public class VertxBusEntryPoint implements ServerAppEntryPoint<VertxContext> {

    @Override
    public void onModulesLoaded(VertxContext vertxContext) {
        ServiceLoader.load(VertxEntryPoint.class).forEach(e -> e.onVertxStartup(vertxContext));
    }
}
