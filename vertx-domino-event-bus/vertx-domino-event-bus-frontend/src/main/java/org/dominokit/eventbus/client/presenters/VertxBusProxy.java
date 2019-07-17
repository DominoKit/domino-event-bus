package org.dominokit.eventbus.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.Store;
import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.eventbus.client.vertx.VertxEventBus;
import org.dominokit.eventbus.client.views.VertxBusView;
import org.dominokit.eventbus.shared.VertxBusContext;

@PresenterProxy
@AutoRoute(routeOnce = true)
@DependsOn(@EventsGroup(MainDominoEvent.class))
public class VertxBusProxy extends ViewBaseClientPresenter<VertxBusView> {

    private VertxEventBus vertxEventBus;
    private VertxBusContext vertxBusContext;

    @OnRouting
    public void onRouting() {
        vertxEventBus = new VertxEventBus(view.getHostUrl() + "eventbus", new Object());
        vertxEventBus.enableReconnect(true);
        vertxEventBus.connectionOpened = () -> {
            vertxBusContext = new DefaultVertxBusContext(vertxEventBus);
            StoreRegistry.INSTANCE.registerStore(VertxBusContext.EVENT_BUS_STORE, new Store<>(vertxBusContext));
        };
    }
}