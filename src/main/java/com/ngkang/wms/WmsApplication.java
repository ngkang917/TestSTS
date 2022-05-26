package com.ngkang.wms;

import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication(scanBasePackages="com.ngkang.wms")
public class WmsApplication implements ApplicationRunner {

	final static Logger logger = LoggerFactory.getLogger(WmsApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WmsApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Start REST API server!!!");

		Iterator<String> iter = args.getOptionNames().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Object value = args.getOptionValues(key);
			logger.info("{}={}", key, value);
		}
	}
}