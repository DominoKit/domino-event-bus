package org.dominokit.eventbus.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.eventbus.client.vertx.VertxEventBus;
import org.dominokit.eventbus.client.views.VertxBusView;
import org.dominokit.eventbus.shared.VertxBusContext;
import org.dominokit.eventbus.shared.VertxBusEvent;

@PresenterProxy
@AutoRoute(routeOnce = true)
@DependsOn(@EventsGroup(MainDominoEvent.class))
public class VertxBusProxy extends ViewBaseClientPresenter<VertxBusView> {

    private VertxEventBus vertxEventBus;
    private VertxBusContext vertxBusContext;

    @OnRouting
    public void onRouting() {
        vertxEventBus = new VertxEventBus(view.getHostUrl() + "eventbus", new Object());
        vertxEventBus.connectionOpened = () -> {
            vertxBusContext = new DefaultVertxBusContext(vertxEventBus);
            fireEvent(VertxBusEvent.class, () -> vertxBusContext);
        };
    }
}