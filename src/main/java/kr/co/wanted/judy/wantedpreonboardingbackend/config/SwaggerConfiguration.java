package kr.co.wanted.judy.wantedpreonboardingbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Server;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableOpenApi
public class SwaggerConfiguration {
    @Bean
    public Docket api(){
        Server serverLocal = new Server("local", "http://localhost:8080", "for local usages", Collections.emptyList(), Collections.emptyList());

        return new Docket(DocumentationType.OAS_30)
                .servers(serverLocal)
                .groupName("api")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("kr.co.wanted.judy.wantedpreonboardingbackend.controller"))
                .paths(PathSelectors.ant("/api/v1/**"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Recruit Sever API")
                .description("프리온보딩 과제 Recruit API에 대한 연동문서 Documentation 입니다.")
                .version("1.0.0")
                .build();
    }
}
