package by.exposit.multithreading.properties;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "file-scan.info")
public class FileScanProperties {

  List<DirectoryInfo> directoryInfoList;
}
