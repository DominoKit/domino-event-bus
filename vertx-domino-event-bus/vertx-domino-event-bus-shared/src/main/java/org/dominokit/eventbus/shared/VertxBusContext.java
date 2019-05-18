package org.dominokit.eventbus.shared;


import org.dominokit.domino.api.shared.extension.EventContext;

public interface VertxBusContext extends EventContext {

    public static final String EVENT_BUS_STORE = "event-bus";

    String DEFAULT_EVENTBUS_PATH = "/eventbus/*";
    String DEFAULT_SOCKJS_ADDRESS = "domino-frontend-address";

    <T> void registerMessageHandler(String address, EventBusMessageHandler<T> handler);

    void registerEventBusCloseHandler(EventBusCloseHandler handler);

    @FunctionalInterface
    interface EventBusMessageHandler<T> {
        void handle(T message);
    }

    @FunctionalInterface
    interface EventBusCloseHandler {
        void handle(Object error);
    }
}
