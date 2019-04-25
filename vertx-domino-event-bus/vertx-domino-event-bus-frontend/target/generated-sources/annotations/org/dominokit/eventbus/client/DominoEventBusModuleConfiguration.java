package org.dominokit.eventbus.client;

import java.lang.Override;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.InitialTaskRegistry;
import org.dominokit.domino.api.client.ModuleConfiguration;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenterSupplier;
import org.dominokit.eventbus.client.presenters.VertxBusProxy_Presenter;
import org.dominokit.eventbus.client.presenters.VertxBusProxy_Presenter_Config;
import org.dominokit.eventbus.client.routing.VertxBusProxy_PresenterHistoryListenerTask;
import org.dominokit.eventbus.client.views.VertxBusView;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.ClientModuleAnnotationProcessor")
public class DominoEventBusModuleConfiguration implements ModuleConfiguration {
  @Override
  public void registerPresenters() {
    VertxBusProxy_Presenter_Config vertxBusProxy_Presenter_Config = new VertxBusProxy_Presenter_Config();
    vertxBusProxy_Presenter_Config.setPresenterSupplier(new ViewablePresenterSupplier<VertxBusProxy_Presenter, VertxBusView>(false, ()-> new VertxBusProxy_Presenter()));

  }

  @Override
  public void registerInitialTasks(InitialTaskRegistry registry) {
    registry.registerInitialTask(new VertxBusProxy_PresenterHistoryListenerTask());
  }
}
