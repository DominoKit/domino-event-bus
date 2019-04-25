package org.dominokit.sample.eventbus.client;

import java.lang.Override;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.ModuleConfiguration;
import org.dominokit.sample.eventbus.client.presenters.DominoEventBusSampleProxy_Presenter_Config;
import org.dominokit.sample.eventbus.client.ui.views.DominoEventBusSampleViewImpl;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.ClientModuleAnnotationProcessor")
public class DominoEventBusSampleUIModuleConfiguration implements ModuleConfiguration {
  @Override
  public void registerViews() {
    DominoEventBusSampleProxy_Presenter_Config dominoEventBusSampleProxy_Presenter_Config = new DominoEventBusSampleProxy_Presenter_Config();
    dominoEventBusSampleProxy_Presenter_Config.setViewSupplier(()-> new DominoEventBusSampleViewImpl());
  }
}
