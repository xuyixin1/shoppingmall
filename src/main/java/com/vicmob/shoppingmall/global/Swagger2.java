package com.vicmob.shoppingmall.global;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author cardinfolink
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	private static final String splitor = ";";

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(basePackage("com.vicmob.shoppingmall.web.distribution.controller" + splitor + "com.vicmob.shoppingmall.web.goods.controller"+ splitor + "com.vicmob.shoppingmall.web.goodsAPI.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//页面标题
				.title("Swagger2 构建RESTful API")
				//版本号
				.version("1.0")
				//描述
				.description("API 描述")
				.build();
	}

	public static Predicate<RequestHandler> basePackage(final String basePackage) {
		return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
	}

	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
		return input -> {
			// 循环判断匹配
			for (String strPackage : basePackage.split(splitor)) {
				boolean isMatch = input.getPackage().getName().startsWith(strPackage);
				if (isMatch) {
					return true;
				}
			}
			return false;
		};
	}

	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
	}

}
