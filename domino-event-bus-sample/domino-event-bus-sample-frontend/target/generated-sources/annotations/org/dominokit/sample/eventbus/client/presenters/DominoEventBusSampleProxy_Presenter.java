package org.dominokit.sample.eventbus.client.presenters;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.Presenter;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.api.shared.extension.DominoEvent;
import org.dominokit.domino.api.shared.extension.DominoEventListener;
import org.dominokit.eventbus.shared.VertxBusEvent;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@Presenter
@AutoRoute(
    token = "",
    routeOnce = false,
    reRouteActivated = true
)
@AutoReveal
@Slot("document-body")
public class DominoEventBusSampleProxy_Presenter extends DominoEventBusSampleProxy {
  @Override
  public String revealSlot() {
    return "document-body";
  }

  @Override
  protected Map<Class<? extends DominoEvent>, DominoEventListener> getListeners() {
    Map<Class<? extends DominoEvent>, DominoEventListener> listenersMap = new HashMap<>();
    listenersMap.put(VertxBusEvent.class, new org.dominokit.sample.eventbus.client.listeners.DominoEventBusSampleProxy_PresenterListenForVertxBusEvent(this));
    return listenersMap;
  }
}
