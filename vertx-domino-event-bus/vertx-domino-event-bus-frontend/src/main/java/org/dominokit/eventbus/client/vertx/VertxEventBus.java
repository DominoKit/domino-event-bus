package org.dominokit.eventbus.client.vertx;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "EventBus", namespace = JsPackage.GLOBAL)
public class VertxEventBus {

    @JsProperty(name = "onopen")
    public ConnectionOpened connectionOpened;

    @JsProperty(name = "onclose")
    public ConnectionClosed connectionClosed;

    public native void enableReconnect(boolean enable);

    public VertxEventBus(String url, Object options) {
    }

    public native <T> void registerHandler(String address, Handler<T> handler);

    public native <T> void unregisterHandler(String address, Handler<T> handler);
}
