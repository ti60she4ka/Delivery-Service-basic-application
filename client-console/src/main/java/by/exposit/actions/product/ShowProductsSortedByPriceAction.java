package by.exposit.actions.product;

import by.exposit.actions.Action;
import by.exposit.controllers.ArticleController;
import by.exposit.model.entities.Article;
import by.exposit.model.enums.sort.SortType;
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
