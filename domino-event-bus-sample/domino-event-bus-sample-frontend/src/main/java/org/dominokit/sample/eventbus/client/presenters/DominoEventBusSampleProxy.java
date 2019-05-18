package org.dominokit.sample.eventbus.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.eventbus.shared.VertxBusContext;
import org.dominokit.eventbus.shared.VertxBusEvent;
import org.dominokit.sample.eventbus.client.views.DominoEventBusSampleView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter.DOCUMENT_BODY;

@PresenterProxy
@AutoRoute
@Slot(DOCUMENT_BODY)
@AutoReveal
public class DominoEventBusSampleProxy extends ViewBaseClientPresenter<DominoEventBusSampleView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DominoEventBusSampleProxy.class);

    @OnReveal
    public void startListening(){
        StoreRegistry.INSTANCE.<VertxBusContext>consumeData(VertxBusContext.EVENT_BUS_STORE, vertxBusContext -> {
            vertxBusContext.registerMessageHandler(VertxBusContext.DEFAULT_SOCKJS_ADDRESS, (VertxBusContext.EventBusMessageHandler<Number>) message -> {
                view.showNumber(message);
            });
        });
    }

}