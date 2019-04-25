package org.dominokit.eventbus.client.presenters;

import java.lang.Class;
import java.lang.Override;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.Presenter;
import org.dominokit.domino.api.shared.extension.DominoEvent;
import org.dominokit.domino.api.shared.extension.DominoEventListener;

/**
 * This is generated class, please don't modify
 */
@Generated("org.dominokit.domino.apt.client.processors.module.client.presenters.PresenterProcessor")
@Presenter
@AutoRoute(
    token = "",
    routeOnce = true,
    reRouteActivated = true
)
public class VertxBusProxy_Presenter extends VertxBusProxy {
  @Override
  protected Map<Class<? extends DominoEvent>, DominoEventListener> getListeners() {
    Map<Class<? extends DominoEvent>, DominoEventListener> listenersMap = new HashMap<>();
    return listenersMap;
  }
}
