package org.dominokit.eventbus.client.vertx;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface Handler<T> {
    void onMessageReceived(Object error, Message<T> message);
}
