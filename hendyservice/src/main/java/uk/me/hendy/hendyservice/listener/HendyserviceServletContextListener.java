package uk.me.hendy.hendyservice.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.me.hendy.hendyservice.utility.RepositoryUtility;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

public class HendyserviceServletContextListener implements
		ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(HendyserviceServletContextListener.class);

	//private com.mysql.jdbc.Driver mySQLDriver = null;
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("servlet context being initialised");
		
		/*try {
			this.mySQLDriver = new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		RepositoryUtility.start();

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
		
		logger.info("sleeping for a bit to wait for thread shutdown");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	

}
