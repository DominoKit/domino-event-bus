package org.dominokit.eventbus.client.presenters;

import org.dominokit.eventbus.client.vertx.VertxEventBus;
import org.dominokit.eventbus.shared.VertxBusContext;

import java.util.HashSet;
import java.util.Set;

public class DefaultVertxBusContext implements VertxBusContext {

    private final VertxEventBus vertxEventBus;
    private final Set<VertxBusContext.EventBusCloseHandler> closeHandlers = new HashSet<>();

    DefaultVertxBusContext(VertxEventBus vertxEventBus) {
        this.vertxEventBus = vertxEventBus;
        vertxEventBus.connectionClosed = e -> closeHandlers.forEach(handler -> handler.handle(e));
    }

    @Override
    public <T> void registerMessageHandler(String address, EventBusMessageHandler<T> handler) {
        vertxEventBus.<T>registerHandler(address, (error, message) -> handler.handle(message.body));
    }

    @Override
    public void unregisterMessageHandler(String address) {
        vertxEventBus.unregisterHandler(address, (error, message) -> {
        });
    }

    public void registerEventBusCloseHandler(EventBusCloseHandler handler) {
        closeHandlers.add(handler);
    }

}
