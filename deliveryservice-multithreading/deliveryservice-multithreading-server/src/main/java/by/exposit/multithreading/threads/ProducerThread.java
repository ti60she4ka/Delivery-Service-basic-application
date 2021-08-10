package by.exposit.multithreading.threads;

import by.exposit.core.filemanager.FileManager;
import by.exposit.web.requests.ArticleRequest;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ProducerThread {

  private final BlockingQueue<ArticleRequest> queue;

  public ProducerThread(BlockingQueue<ArticleRequest> queue){
    this.queue = queue;
  }

  public void run(String path, FileManager fileManager){
    Type listType = new TypeToken<ArrayList<ArticleRequest>>(){}.getType();
    List<ArticleRequest> list = (List<ArticleRequest>) fileManager.deserialize(path, listType);
    queue.addAll(list);
  }
}
