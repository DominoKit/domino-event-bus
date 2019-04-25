package org.dominokit.eventbus.client.vertx;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface ConnectionOpened {
    void onOpen();
}
