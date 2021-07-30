package by.exposit.web;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "by.exposit.web")
@ConfigurationPropertiesScan(basePackages = "by.exposit.web")
public class DeliveryServiceWebAutoConfiguration {

}
