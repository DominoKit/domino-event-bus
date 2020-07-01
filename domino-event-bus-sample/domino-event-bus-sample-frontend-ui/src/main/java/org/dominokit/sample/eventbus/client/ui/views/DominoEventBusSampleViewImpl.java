package org.dominokit.sample.eventbus.client.ui.views;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.sample.eventbus.client.presenters.DominoEventBusSampleProxy;
import org.dominokit.sample.eventbus.client.views.DominoEventBusSampleView;

@UiView(presentable = DominoEventBusSampleProxy.class)
public class DominoEventBusSampleViewImpl extends BaseElementView<HTMLDivElement> implements DominoEventBusSampleView {

    private DominoElement<HTMLDivElement> root = DominoElement.div();

    @Override
    public void showNumber(Number message) {
        root.appendChild(TextNode.of(message + ""));
    }

    @Override
    protected HTMLDivElement init() {
        return root.element();
    }
}