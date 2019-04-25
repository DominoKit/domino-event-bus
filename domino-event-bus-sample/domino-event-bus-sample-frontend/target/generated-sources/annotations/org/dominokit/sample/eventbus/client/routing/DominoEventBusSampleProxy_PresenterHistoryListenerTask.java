package org.dominokit.sample.eventbus.client.routing;

import java.lang.Override;
import java.util.Arrays;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.StartupTask;
import org.dominokit.domino.api.client.events.DefaultEventAggregator;
import org.dominokit.domino.api.client.startup.BaseRoutingStartupTask;
import org.dominokit.domino.api.shared.history.DominoHistory;
import org.dominokit.domino.api.shared.history.TokenFilter;
import org.dominokit.sample.eventbus.client.presenters.DominoEventBusSampleProxy_PresenterCommand;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@StartupTask
public class DominoEventBusSampleProxy_PresenterHistoryListenerTask extends BaseRoutingStartupTask {
  public DominoEventBusSampleProxy_PresenterHistoryListenerTask() {
    super(Arrays.asList(new DefaultEventAggregator()));
  }

  @Override
  protected TokenFilter getTokenFilter() {
    return TokenFilter.any();
  }

  @Override
  protected void onStateReady(DominoHistory.State state) {
     new DominoEventBusSampleProxy_PresenterCommand().onPresenterReady(presenter -> {
      bindPresenter(presenter);
      if(!presenter.isActivated()) {
        presenter.reveal();
      }
    } ).send();
  }
}
