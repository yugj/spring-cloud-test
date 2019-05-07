package indi.yugj.test.springcloud.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description:
 * Created by yugj on 18/6/13 16:56.
 */
@SpringBootApplication
@EnableSwagger2
public class SwaggerStart {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerStart.class, args);
    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("indi.yugj"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("sop api online")
                .description("sop 接口文档")
                .termsOfServiceUrl("https://yugj.indi/")
                .contact("yugj@hotmail.com")
                .version("1.0")
                .build();
    }
}
