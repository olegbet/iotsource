package com.iot.IotSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class IotSourceApplication {

	private static final long SOURCE_RUN_TIME = 15*60*1000;
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx=
				SpringApplication.run(IotSourceApplication.class, args);
				Thread.sleep(SOURCE_RUN_TIME);
				ctx.close();
	}
}
