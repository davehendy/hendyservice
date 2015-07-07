package uk.me.hendy.hendyservice.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.me.hendy.repository.RepositoryApplication;
import uk.me.hendy.repository.RepositoryApplicationFactory;

public class RepositoryUtility {
	private static final Logger logger = LoggerFactory.getLogger(RepositoryUtility.class);
	//private static RepositoryApplicationFactory fact = new RepositoryApplicationFactory();
	private static RepositoryApplication app;
	
	public static RepositoryApplication start(){
		logger.info("Starting RepositoryApplication");
		app = RepositoryApplicationFactory.getInstance();
		return app;
	}
	
	public static void stop() {
		logger.info("Stopping RepositoryApplication");
		RepositoryApplicationFactory.closeApplication();
	}

}
