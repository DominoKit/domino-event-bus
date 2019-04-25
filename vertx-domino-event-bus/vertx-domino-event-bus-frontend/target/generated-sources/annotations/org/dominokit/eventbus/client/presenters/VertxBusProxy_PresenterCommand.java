package org.dominokit.eventbus.client.presenters;

import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.presenter.Command;
import org.dominokit.domino.api.client.request.PresenterCommand;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@Command
public class VertxBusProxy_PresenterCommand extends PresenterCommand<VertxBusProxy_Presenter> {
  public VertxBusProxy_PresenterCommand() {
    configure(new VertxBusProxy_Presenter_Config());
  }
}
