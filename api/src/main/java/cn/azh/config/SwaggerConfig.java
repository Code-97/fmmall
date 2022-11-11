package cn.azh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /**
     * 封装接口文档信息
     * @return
     */
    @Bean
    public Docket getDocket(){


        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("fmmall api doc")
                .description("for api descricption")
                .version("1.0.0")
                .contact(new Contact("code97","www.baidu.com","597262603@qq.com"));
        ApiInfo build = apiInfoBuilder.build();//定义封面信息


        //指定生成策略
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(build)
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("cn.azh.controller"))
                        .paths(PathSelectors.any())
                        .build();

        return docket;

    }
}
