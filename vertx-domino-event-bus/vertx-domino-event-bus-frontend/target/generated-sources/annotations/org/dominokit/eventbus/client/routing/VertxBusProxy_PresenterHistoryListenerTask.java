package org.dominokit.eventbus.client.routing;

import java.lang.Override;
import java.util.Arrays;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.StartupTask;
import org.dominokit.domino.api.client.events.BaseRoutingAggregator;
import org.dominokit.domino.api.client.startup.BaseRoutingStartupTask;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.api.shared.history.DominoHistory;
import org.dominokit.domino.api.shared.history.TokenFilter;
import org.dominokit.eventbus.client.presenters.VertxBusProxy_PresenterCommand;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@StartupTask
public class VertxBusProxy_PresenterHistoryListenerTask extends BaseRoutingStartupTask {
  public VertxBusProxy_PresenterHistoryListenerTask() {
    super(Arrays.asList(new EventsAggregator_0()));
  }

  @Override
  protected TokenFilter getTokenFilter() {
    return TokenFilter.any();
  }

  @Override
  protected void onStateReady(DominoHistory.State state) {
     new VertxBusProxy_PresenterCommand().onPresenterReady(presenter -> {
      bindPresenter(presenter);
      presenter.onRouting();
    } ).send();
  }

  @Override
  protected boolean isRoutingOnce() {
    return true;
  }

  private static class EventsAggregator_0 extends BaseRoutingAggregator {
    private EventsAggregator_0() {
      super(Arrays.asList(MainDominoEvent.class));
    }
  }
}
