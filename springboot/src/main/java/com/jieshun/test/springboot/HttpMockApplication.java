package com.jieshun.test.springboot;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HttpMockApplication {
	

	
	public static void main(String[] args) {

		//加载缓存
		new DispatcherHandler();

		//启动Springboot
		SpringApplication.run(HttpMockApplication.class, args);
	}
	
	  @Bean
      public EmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() throws IOException {
          TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
          tomcat.addAdditionalTomcatConnectors(httpConnector());
          return tomcat;
      }

      public Connector httpConnector() throws IOException {
          Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
          Http11NioProtocol http11NioProtocol = (Http11NioProtocol) connector.getProtocolHandler();
          connector.setPort(8081);
          http11NioProtocol.setMaxConnections(2000);
          //设置最大线程数
          http11NioProtocol.setMaxThreads(500);
          //设置初始线程数  最小空闲线程数
          http11NioProtocol.setMinSpareThreads(20);
          //设置超时
          http11NioProtocol.setConnectionTimeout(6000);
          	
          return connector;
      }
      




}