package org.dominokit.eventbus.client.vertx;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Message<T> {

    @JsProperty
    public T body;
}
