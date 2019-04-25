package org.dominokit.eventbus.client.ui.views;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.eventbus.client.presenters.VertxBusProxy;
import org.dominokit.eventbus.client.views.VertxBusView;

import static com.google.gwt.core.client.GWT.getModuleBaseURL;

@UiView(presentable = VertxBusProxy.class)
public class VertxBusViewImpl implements VertxBusView {

    @Override
    public String getHostUrl() {
        return getModuleBaseURL().replace("static/", "");
    }
}