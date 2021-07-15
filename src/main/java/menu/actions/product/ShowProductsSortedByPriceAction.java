package menu.actions.product;

import controllers.ArticleController;
import menu.actions.Action;
import model.entities.Article;
import model.enums.sort.SortType;

import java.util.List;

public class ShowProductsSortedByPriceAction implements Action {
    private final SortType sortType;

    public ShowProductsSortedByPriceAction(SortType sortType){
        this.sortType = sortType;
    }

    @Override
    public void doAction(int index) throws Exception {
        List<Article> productStorages = ArticleController.getInstance().getAll();

        if(productStorages.size() == 0){
            System.out.println("The product list is empty.\n");
        }

        printProductStorages(productStorages);
    }

    private void printProductStorages(List<Article> productStorages){
        for (Article productStorage : productStorages) {
            System.out.println(productStorage + " in " + productStorage.getProduct().getName());
        }
        System.out.println();
    }
}
