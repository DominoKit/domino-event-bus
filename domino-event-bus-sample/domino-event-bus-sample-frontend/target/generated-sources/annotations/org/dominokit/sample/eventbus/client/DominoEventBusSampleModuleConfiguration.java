package org.dominokit.sample.eventbus.client;

import java.lang.Override;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.InitialTaskRegistry;
import org.dominokit.domino.api.client.ModuleConfiguration;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenterSupplier;
import org.dominokit.sample.eventbus.client.presenters.DominoEventBusSampleProxy_Presenter;
import org.dominokit.sample.eventbus.client.presenters.DominoEventBusSampleProxy_Presenter_Config;
import org.dominokit.sample.eventbus.client.routing.DominoEventBusSampleProxy_PresenterHistoryListenerTask;
import org.dominokit.sample.eventbus.client.views.DominoEventBusSampleView;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.ClientModuleAnnotationProcessor")
public class DominoEventBusSampleModuleConfiguration implements ModuleConfiguration {
  @Override
  public void registerPresenters() {
    DominoEventBusSampleProxy_Presenter_Config dominoEventBusSampleProxy_Presenter_Config = new DominoEventBusSampleProxy_Presenter_Config();
    dominoEventBusSampleProxy_Presenter_Config.setPresenterSupplier(new ViewablePresenterSupplier<DominoEventBusSampleProxy_Presenter, DominoEventBusSampleView>(false, ()-> new DominoEventBusSampleProxy_Presenter()));

  }

  @Override
  public void registerInitialTasks(InitialTaskRegistry registry) {
    registry.registerInitialTask(new DominoEventBusSampleProxy_PresenterHistoryListenerTask());
  }
}
