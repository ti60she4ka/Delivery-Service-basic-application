package by.exposit.client.actions.product;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.ArticleController;
import by.exposit.core.model.entities.Article;
import by.exposit.core.model.entities.Category;
import by.exposit.client.utilities.ConsoleUtility;
import java.util.ArrayList;
import java.util.List;

public class ShowProductsByCategoriesAction implements Action {

  private final ArticleController articleController;

  public ShowProductsByCategoriesAction(ArticleController articleController) {
    this.articleController = articleController;
  }

  @Override
  public void doAction(int index) {
    List<Category> allCategories = new ArrayList<>();
    List<Category> categories = new ArrayList<>();

    while (true) {
      printCategories(allCategories);
      System.out.println((allCategories.size() + 1) + ". Finish the selection");
      System.out.print("Select a category: ");
      int categoryIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

      if (categoryIndex == allCategories.size() + 1) {
        break;
      }

      categories.add(allCategories.get(categoryIndex - 1));
      System.out.println();
    }

    List<Article> productStorages = (List<Article>) articleController.getAll();

    printProductStorages(productStorages);
  }

  private void printCategories(List<Category> categories) {
    for (int i = 0; i < categories.size(); i++) {
      System.out.println((i + 1) + ". " + categories.get(i).getName());
    }
  }

  private void printProductStorages(List<Article> productStorages) {
    System.out.println();
    for (Article productStorage : productStorages) {
      System.out.println(productStorage);
    }
    System.out.println();
  }
}
