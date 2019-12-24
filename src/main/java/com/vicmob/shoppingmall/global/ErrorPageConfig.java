
package com.vicmob.shoppingmall.global;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * 
 * @author vicmob
 *
 */
@SpringBootConfiguration
public class ErrorPageConfig {

	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> containerCustomizer() {
		return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
			@Override
			public void customize(ConfigurableWebServerFactory container) {
				// 页面在src/main/webapp路径下
				// 以错误码跳转到指定异常页面
				ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
				// 以Exception异常跳转到指定异常页面
				ErrorPage errorExcep = new ErrorPage(Exception.class, "/500.html");
				// 注册自定义异常页面
				container.addErrorPages(error404,errorExcep);
			}
		};
	}
}
