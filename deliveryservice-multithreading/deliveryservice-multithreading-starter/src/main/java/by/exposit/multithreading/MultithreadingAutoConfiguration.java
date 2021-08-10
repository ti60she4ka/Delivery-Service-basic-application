package by.exposit.multithreading;

import by.exposit.core.filemanager.FileManager;
import by.exposit.multithreading.properties.FileScanProperties;
import by.exposit.multithreading.services.MultithreadingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.exposit.multithreading")
@ConfigurationPropertiesScan(basePackages = "by.exposit.multithreading.properties")
@ConditionalOnProperty(prefix = "file-scan", name = "enabled", havingValue = "true")
public class MultithreadingAutoConfiguration {

  @Bean
  public MultithreadingService multithreadingService(FileScanProperties fileScanProperties, FileManager fileManager){
    return new MultithreadingService(fileScanProperties, fileManager);
  }
}
