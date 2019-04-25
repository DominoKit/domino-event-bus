package org.dominokit.eventbus.client;

import java.lang.Override;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.ModuleConfiguration;
import org.dominokit.eventbus.client.presenters.VertxBusProxy_Presenter_Config;
import org.dominokit.eventbus.client.ui.views.VertxBusViewImpl;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.ClientModuleAnnotationProcessor")
public class DominoEventBusUIModuleConfiguration implements ModuleConfiguration {
  @Override
  public void registerViews() {
    VertxBusProxy_Presenter_Config vertxBusProxy_Presenter_Config = new VertxBusProxy_Presenter_Config();
    vertxBusProxy_Presenter_Config.setViewSupplier(()-> new VertxBusViewImpl());
  }
}
