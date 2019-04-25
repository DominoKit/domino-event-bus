package org.dominokit.sample.eventbus.client.listeners;

import java.lang.Override;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.presenter.Listener;
import org.dominokit.domino.api.shared.extension.DominoEventListener;
import org.dominokit.eventbus.shared.VertxBusEvent;
import org.dominokit.sample.eventbus.client.presenters.DominoEventBusSampleProxy_Presenter;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@Listener
public class DominoEventBusSampleProxy_PresenterListenForVertxBusEvent implements DominoEventListener<VertxBusEvent> {
  private final DominoEventBusSampleProxy_Presenter presenter;

  public DominoEventBusSampleProxy_PresenterListenForVertxBusEvent(DominoEventBusSampleProxy_Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void onEventReceived(VertxBusEvent event) {
    this.presenter.onEventBusReady(event.context());
  }
}
