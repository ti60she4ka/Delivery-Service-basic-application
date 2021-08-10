package by.exposit.multithreading.services;

import by.exposit.core.filemanager.FileManager;
import by.exposit.multithreading.properties.DirectoryInfo;
import by.exposit.multithreading.properties.FileScanProperties;
import by.exposit.multithreading.threads.ConsumerThread;
import by.exposit.multithreading.threads.ProducerThread;
import by.exposit.web.requests.ArticleRequest;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class MultithreadingService implements ApplicationRunner {

  private final FileScanProperties properties;
  private final FileManager fileManager;

  public MultithreadingService(FileScanProperties properties, FileManager fileManager){
    this.properties = properties;
    this.fileManager = fileManager;
  }

  @Override
  public void run(ApplicationArguments args) {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(25);

    for(DirectoryInfo directoryInfo : properties.getDirectoryInfoList()) {
      File directory = new File(directoryInfo.getPath());

      if(directory.listFiles() == null){
        continue;
      }

      for(File file : directory.listFiles()){
        BlockingQueue<ArticleRequest> queue = new LinkedBlockingQueue<>();
        long delay = Duration.between(LocalDateTime.now(), directoryInfo.getTime()).getSeconds();

        executorService.schedule(() ->
            new ProducerThread(queue).run(file.getPath(), fileManager), delay, TimeUnit.SECONDS);

        executorService.schedule(() -> new ConsumerThread(queue).run(), delay + 5, TimeUnit.SECONDS);
      }
    }
  }
}
