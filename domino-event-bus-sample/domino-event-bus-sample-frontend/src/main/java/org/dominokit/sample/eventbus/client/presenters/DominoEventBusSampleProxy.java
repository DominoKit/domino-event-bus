package org.dominokit.sample.eventbus.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
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

    @ListenTo(event = VertxBusEvent.class)
    public void onEventBusReady(VertxBusContext context) {
        context.registerMessageHandler(VertxBusContext.DEFAULT_SOCKJS_ADDRESS, (VertxBusContext.EventBusMessageHandler<Number>) message -> {
            view.showNumber(message);
        });
    }
}