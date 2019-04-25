package org.dominokit.eventbus.client.presenters;

import java.lang.Override;
import java.util.function.Supplier;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.mvp.ViewablePresenterConfig;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenterSupplier;
import org.dominokit.eventbus.client.views.VertxBusView;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
public class VertxBusProxy_Presenter_Config implements ViewablePresenterConfig<VertxBusProxy_Presenter, VertxBusView> {
  private static ViewablePresenterSupplier<VertxBusProxy_Presenter, VertxBusView> presenterSupplier;

  private static Supplier<VertxBusView> viewSupplier;

  public void setPresenterSupplier(ViewablePresenterSupplier<VertxBusProxy_Presenter, VertxBusView> presenterSupplier) {
    VertxBusProxy_Presenter_Config.presenterSupplier = presenterSupplier;
  }

  @Override
  public ViewablePresenterSupplier<VertxBusProxy_Presenter, VertxBusView> getPresenterSupplier() {
    return VertxBusProxy_Presenter_Config.presenterSupplier;
  }

  public void setViewSupplier(Supplier<VertxBusView> viewSupplier) {
    VertxBusProxy_Presenter_Config.viewSupplier = viewSupplier;
  }

  @Override
  public Supplier<VertxBusView> getViewSupplier() {
    return VertxBusProxy_Presenter_Config.viewSupplier;
  }
}
