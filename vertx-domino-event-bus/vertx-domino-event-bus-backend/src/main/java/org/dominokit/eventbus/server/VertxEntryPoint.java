package org.dominokit.eventbus.server;

import org.dominokit.domino.api.server.entrypoint.VertxContext;

public interface VertxEntryPoint {
    void onVertxStartup(VertxContext vertxContext);
}
