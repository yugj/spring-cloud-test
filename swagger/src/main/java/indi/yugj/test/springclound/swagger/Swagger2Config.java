//package indi.yugj.test.springclound.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * Description:
// * Created by yugj on 18/6/13 17:52.
// */
//@Configuration
//@EnableSwagger2
//public class Swagger2Config {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("indi.yugj"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("sop api online")
//                .description("sop 接口文档")
//                .termsOfServiceUrl("https://yugj.indi/")
//                .contact("yugj@hotmail.com")
//                .version("1.0")
//                .build();
//    }
//}
