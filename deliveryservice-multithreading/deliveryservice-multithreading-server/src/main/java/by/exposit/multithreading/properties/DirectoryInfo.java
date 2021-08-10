package by.exposit.multithreading.properties;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectoryInfo {

  private String path;
  private LocalDateTime time;

  public void setTime(String time) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    this.time= LocalDateTime.parse(time, formatter);
  }
}
