package by.exposit.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = "by.exposit.web")
@EnableSwagger2
public class DeliveryServiceWebAutoConfiguration {

}
