package by.exposit.multithreading.threads;

import by.exposit.web.requests.ArticleRequest;
import java.util.concurrent.BlockingQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class ConsumerThread {

  private final BlockingQueue<ArticleRequest> queue;

  public ConsumerThread(BlockingQueue<ArticleRequest> queue){
    this.queue = queue;
  }

  public void run(){
    RestTemplate restTemplate = new RestTemplate();
    for (ArticleRequest articleRequest : queue){
      String url = "http://localhost:8080/articles";
      HttpEntity<ArticleRequest> entity = new HttpEntity<>(articleRequest, new HttpHeaders());
      log.info("Sending a POST request to {} with te body: {}", url, articleRequest);
      restTemplate.postForLocation("http://localhost:8080/articles", entity);

      queue.remove(articleRequest);
    }
  }
}
