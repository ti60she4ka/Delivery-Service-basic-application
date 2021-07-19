package actions.product;

import actions.Action;
import controllers.ArticleController;
import java.util.List;
import model.entities.Article;
import model.enums.sort.SortType;

public class ShowProductsSortedByPriceAction implements Action {

  private final SortType sortType;

  public ShowProductsSortedByPriceAction(SortType sortType) {
    this.sortType = sortType;
  }

  @Override
  public void doAction(int index) throws Exception {
    List<Article> productStorages = (List<Article>) ArticleController.getInstance().getAll();

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
