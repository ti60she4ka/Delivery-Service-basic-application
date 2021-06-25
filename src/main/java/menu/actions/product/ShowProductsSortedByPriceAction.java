package menu.actions.product;

import api.services.ProductService;
import controllers.ShopController;
import menu.actions.Action;
import model.entities.ProductStorage;

import java.util.List;

public class ShowProductsSortedByPriceAction implements Action {
    @Override
    public void doAction(int index) throws Exception {
        List<ProductStorage> productStorages = ShopController.getInstance().getAllProductStoragesOrderByPrice();

        if(productStorages.size() == 0){
            System.out.println("The product list is empty");
            System.out.println();
        }

        printProductStorages(productStorages);
    }

    private void printProductStorages(List<ProductStorage> productStorages){
        for (ProductStorage productStorage : productStorages) {
            System.out.println(productStorage + " in " + productStorage.getProduct().getNameOfShop());
        }
        System.out.println();
    }
}
