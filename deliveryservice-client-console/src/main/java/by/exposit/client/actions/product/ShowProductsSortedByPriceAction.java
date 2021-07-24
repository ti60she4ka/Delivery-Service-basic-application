package by.exposit.client.actions.product;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.ArticleController;
import by.exposit.core.model.entities.Article;
import by.exposit.core.model.enums.sort.SortType;
import java.util.List;

public class ShowProductsSortedByPriceAction implements Action {

  private final ArticleController articleController;
  private final SortType sortType;

  public ShowProductsSortedByPriceAction(ArticleController articleController, SortType sortType) {
    this.articleController = articleController;
    this.sortType = sortType;
  }

  @Override
  public void doAction(int index) throws Exception {
    List<Article> productStorages = (List<Article>) articleController.getAll();

    if (productStorages.size() == 0) {
      System.out.println("The product list is empty.\n");
    }

    printProductStorages(productStorages);
  }

  private void printProductStorages(List<Article> productStorages) {
    for (Article productStorage : productStorages) {
      System.out.println(productStorage + " in " + productStorage.getProduct().getName());
    }
    System.out.println();
  }
}
