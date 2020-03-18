package org.phoenix.speed;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class SpeedApplication {

	private static Logger logger= LoggerFactory.getLogger(SpeedApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application=SpringApplication.run(SpeedApplication.class, args);
		Environment env = application.getEnvironment();
		logger.error("\n----------------------------------------------------------\n\t" +
						"Welcome to Speed! \n\t" +
						"Access URLs:\n\t" +
						"Local: \t\thttp://127.0.0.1:{}\n\t" +
						"External: \thttp://{}:{}\n"+
						"----------------------------------------------------------",
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"));
	}

}
