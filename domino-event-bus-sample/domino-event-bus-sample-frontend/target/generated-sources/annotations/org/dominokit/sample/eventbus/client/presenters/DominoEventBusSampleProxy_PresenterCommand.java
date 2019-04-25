package org.dominokit.sample.eventbus.client.presenters;

import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.presenter.Command;
import org.dominokit.domino.api.client.request.PresenterCommand;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@Command
public class DominoEventBusSampleProxy_PresenterCommand extends PresenterCommand<DominoEventBusSampleProxy_Presenter> {
  public DominoEventBusSampleProxy_PresenterCommand() {
    configure(new DominoEventBusSampleProxy_Presenter_Config());
  }
}
