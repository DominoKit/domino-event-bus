package org.dominokit.eventbus.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="DominoEventBus")
public class DominoEventBusClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DominoEventBusClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing DominoEventBus frontend module ...");
		new ModuleConfigurator().configureModule(new DominoEventBusModuleConfiguration());
	}
}
