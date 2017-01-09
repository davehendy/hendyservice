package uk.me.hendy.hendyservice.listener;

import java.io.File;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.me.hendy.hendyservice.utility.RepositoryUtility;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

public class HendyserviceServletContextListener implements
		ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(HendyserviceServletContextListener.class);

	//private com.mysql.jdbc.Driver mySQLDriver = null;
	public void contextInitialized(ServletContextEvent sce) {
		//log4j init
		ServletContext context = sce.getServletContext();
        String log4jConfigFile = context.getInitParameter("log4j-config-location");
        String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
        logger.debug("log4j config=" + fullPath); 
        DOMConfigurator.configure(fullPath);
        //PropertyConfigurator.configure(fullPath);
        //logger.ROOT_LOGGER_NAME
		
		logger.info("servlet context being initialised");
		
		/*try {
			this.mySQLDriver = new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		RepositoryUtility.getInstance();

	}

	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("servlet context being destroyed");
		
		logger.info("Stopping repository");	
		RepositoryUtility.stop();
		
		logger.info("get rid of abandoned cleanup threads");
		logger.debug("mysql active count=" + AbandonedConnectionCleanupThread.activeCount());
		try {
			
			AbandonedConnectionCleanupThread.shutdown();
			
		} catch (InterruptedException e) {
			logger.error("AbandonedConnectionCleanupThread shutdown failure");
			e.printStackTrace();
		}
		
		
		logger.debug("mysql active count=" + AbandonedConnectionCleanupThread.activeCount());
		
		
		logger.info("closing drivers");
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			if (driver.getClass().getClassLoader() == cl) {
				logger.debug("deregistering driver " + driver.getClass() + " - loaded by " + driver.getClass().getClassLoader());
				try {
					DriverManager.deregisterDriver(driver);
				} catch (SQLException e) {
					logger.debug("Error deregistering driver");
					e.printStackTrace();
				}
			} else {
				logger.debug("Not deregistered driver " + driver.getClass() + " loaded by " + driver.getClass());
			}
		}
		
		System.gc();
		
		logger.info("sleeping for a bit to wait for thread shutdown");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error("thread sleep error", e.getMessage());
			e.printStackTrace();
		}
		logger.info("awake and continuing shutdown");
		

	}
	

	

}
