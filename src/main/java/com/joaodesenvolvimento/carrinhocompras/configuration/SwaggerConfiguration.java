package com.joaodesenvolvimento.carrinhocompras.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.joaodesenvolvimento.carrinhocompras"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        String titulo ="Carrinho de compras";
        String descricao = "Sistema desenvolvido para teste de desenvolvedor junior";
        String versao = "1.0";
        String termosServico = "";
        String license = "Apache License Version 2.0";
        String licenseUrl = "https://www.apache.org/licesen.html";
        springfox.documentation.service.Contact contato =
                new springfox.documentation.service.Contact("João Carlos Moreira Serra Abreu",
                        "www.linkedin.com/in/joao-cmsa-desenvolvedor",
                        "joaocmsabreu@gmail.com");

        ApiInfo apiInfo = new ApiInfo(titulo, descricao, versao, termosServico, contato,
                license, licenseUrl,  new ArrayList<VendorExtension>());

        return apiInfo;
    }
}
