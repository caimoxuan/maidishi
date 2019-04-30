package com.mds.matrix.common.config;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author cmx
 * @date 2019/4/16
 */
@Slf4j
@Configuration
@EnableSwagger2
@Profile(value = {"dev", "local"})
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select() //返回一个ApiSelectorBuilder实例，用来控制哪些接口暴露给Swagger来展现，默认扫描制定包路径下所有Controller定义的API（除了@ApiIgnore）
                .apis(RequestHandlerSelectors.basePackage("com.mds.matrix"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("mds平台API")
                .description("mds平台后台API")
                .version("1.0")
                .contact(new Contact("caimx", "", "000@000.com"))
                .build();
    }

    @Bean
    public SimpleUrlHandlerMapping swaggerUi(ApplicationContext var1) throws Exception {
        SimpleUrlHandlerMapping var2;
        (var2 = new SimpleUrlHandlerMapping()).setOrder(-2147483648);
        ResourceHttpRequestHandler var3;
        (var3 = new ResourceHttpRequestHandler()).setLocations(Collections.singletonList(new ClassPathResource("META-INF/resources/swagger-ui.html")));
        var3.setCacheSeconds(2147483647);
        ResourceHttpRequestHandler var4;
        (var4 = new ResourceHttpRequestHandler()).setLocations(Collections.singletonList(new ClassPathResource("META-INF/resources/webjars/")));
        var3.setCacheSeconds(2147483647);
        if (var1 != null && var1 instanceof WebApplicationContext) {
            var3.setApplicationContext(var1);
            var3.setServletContext(((WebApplicationContext)var1).getServletContext());
            var4.setApplicationContext(var1);
            var4.setServletContext(((WebApplicationContext)var1).getServletContext());
        } else {
            log.error("Documentation is only available in Web application.");
        }

        var3.afterPropertiesSet();
        var4.afterPropertiesSet();
        var2.setUrlMap(ImmutableMap.of("/swagger-ui.html", var3, "/webjars/**", var4));
        return var2;
    }
}
