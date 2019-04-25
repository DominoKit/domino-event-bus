package org.dominokit.sample.eventbus.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="DominoEventBusSampleUI")
public class DominoEventBusSampleUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DominoEventBusSampleUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing DominoEventBusSample frontend UI module ...");
		new ModuleConfigurator().configureModule(new DominoEventBusSampleUIModuleConfiguration());
	}
}
