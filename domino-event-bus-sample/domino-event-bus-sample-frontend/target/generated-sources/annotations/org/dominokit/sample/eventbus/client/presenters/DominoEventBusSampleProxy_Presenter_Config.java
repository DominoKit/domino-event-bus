package org.dominokit.sample.eventbus.client.presenters;

import java.lang.Override;
import java.util.function.Supplier;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.mvp.ViewablePresenterConfig;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenterSupplier;
import org.dominokit.sample.eventbus.client.views.DominoEventBusSampleView;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
public class DominoEventBusSampleProxy_Presenter_Config implements ViewablePresenterConfig<DominoEventBusSampleProxy_Presenter, DominoEventBusSampleView> {
  private static ViewablePresenterSupplier<DominoEventBusSampleProxy_Presenter, DominoEventBusSampleView> presenterSupplier;

  private static Supplier<DominoEventBusSampleView> viewSupplier;

  public void setPresenterSupplier(ViewablePresenterSupplier<DominoEventBusSampleProxy_Presenter, DominoEventBusSampleView> presenterSupplier) {
    DominoEventBusSampleProxy_Presenter_Config.presenterSupplier = presenterSupplier;
  }

  @Override
  public ViewablePresenterSupplier<DominoEventBusSampleProxy_Presenter, DominoEventBusSampleView> getPresenterSupplier() {
    return DominoEventBusSampleProxy_Presenter_Config.presenterSupplier;
  }

  public void setViewSupplier(Supplier<DominoEventBusSampleView> viewSupplier) {
    DominoEventBusSampleProxy_Presenter_Config.viewSupplier = viewSupplier;
  }

  @Override
  public Supplier<DominoEventBusSampleView> getViewSupplier() {
    return DominoEventBusSampleProxy_Presenter_Config.viewSupplier;
  }
}
