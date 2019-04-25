package org.dominokit.sample.eventbus.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;

public interface DominoEventBusSampleView extends ContentView {
    void showNumber(Number message);
}