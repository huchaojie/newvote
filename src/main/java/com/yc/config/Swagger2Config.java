package com.yc.config;


//swagger2的配置文件，在项目的启动类的同级文件建立

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2的配置文件
 * @author 何翔
 * @date 2018/3/14
 *
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
	//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				//为当前包路径
				.apis(RequestHandlerSelectors.basePackage("com.yc"))
				.paths(PathSelectors.any())
				.build();
	}

	//构建 api文档的详细信息函数,注意这里的注解引用的是哪个
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//页面标题
				.title("sprintboot利用swagger构建api文档")
				.description("http://blog.csdn.net/saytime")
				.termsOfServiceUrl("http://blog.csdn.net/saytime")
				//创建人
				.contact("何翔")
				//版本号
				.version("1.0")
				//描述
				.description("Api 描述")
				.build();
	}
}
