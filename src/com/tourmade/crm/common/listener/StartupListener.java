package com.tourmade.crm.common.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tourmade.crm.common.framework.util.SpringUtil;

public class StartupListener extends ContextLoaderListener implements ServletContextListener {

	protected transient Logger logger = Logger.getLogger(getClass());

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ServletContext servletContext = event.getServletContext();

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);

		SpringUtil.setApplicationContext(applicationContext);
		getEnvFromProfile(servletContext);

	}

	private void getEnvFromProfile(ServletContext servletContext) {

	}

	public static Properties getFileProperties(String fileName) {
		try {
			InputStream is = null;
			File propFile = new File(fileName);
			if (!propFile.exists()) {
				if (!propFile.isAbsolute()) {
					is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
					if (is == null) {
						is = StartupListener.class.getResourceAsStream(fileName);
					}
					if (is == null) {
						URL url = StartupListener.class.getResource(fileName);
						if (url != null) {
							fileName = url.getPath();
							propFile = new File(fileName);
						}

					}
				}
			}
			if (is == null)
				is = new FileInputStream(propFile);

			Properties props = new Properties();

			try {
				props.load(is);
			} finally {
				is.close();
			}

			return props;
		} catch (Exception exc) {
			// exc.printStackTrace();
			return null;
		}
	}

}
