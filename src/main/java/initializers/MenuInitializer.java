package initializers;

import menu.Menu;
import menu.MenuContext;
import menu.MenuItem;
import menu.actions.user.CreateNewUserAction;
import menu.actions.user.DeleteUserAction;
import menu.actions.user.EditUserAction;
import menu.actions.user.ShowAllClientsAction;
import menu.actions.menu.ExitProgramAction;
import menu.actions.menu.GoToPreviousMenuAction;
import menu.actions.menu.GoToSubmenuAction;
import menu.actions.order.CreateNewOrderAction;
import menu.actions.order.ShowAllOrdersAction;
import menu.actions.product.*;
import menu.actions.shop.*;
import model.enums.sort.SortType;

import java.util.ArrayList;

public class MenuInitializer implements Initializer{
    public void init(){
        initializeRootMenu();
    }

    private static void initializeRootMenu(){
        MenuContext.getMenu().setMenuItems(new ArrayList<>());

        MenuItem clientService = new MenuItem("Client service.",
                initializeClientServiceMenu(MenuContext.getMenu()), new GoToSubmenuAction());
        MenuContext.getMenu().getMenuItems().add(clientService);

        MenuItem shopService = new MenuItem("Shop service.",
                initializeShopServiceMenu(MenuContext.getMenu()), new GoToSubmenuAction());
        MenuContext.getMenu().getMenuItems().add(shopService);

        MenuItem productService = new MenuItem("Product service.",
                initializeProductServiceMenu(MenuContext.getMenu()), new GoToSubmenuAction());
        MenuContext.getMenu().getMenuItems().add(productService);

        MenuItem productSearchService = new MenuItem("Product search service.",
                initializeProductSearchServiceMenu(MenuContext.getMenu()), new GoToSubmenuAction());
        MenuContext.getMenu().getMenuItems().add(productSearchService);

        MenuItem orderService = new MenuItem("Order service.",
                initializeOrderServiceMenu(MenuContext.getMenu()), new GoToSubmenuAction());
        MenuContext.getMenu().getMenuItems().add(orderService);

        MenuItem exitProgram = new MenuItem("Exit.",
                null, new ExitProgramAction());
        MenuContext.getMenu().getMenuItems().add(exitProgram);
    }

    private static Menu initializeClientServiceMenu(Menu previousMenu){
        Menu clientServiceMenu = new Menu();
        clientServiceMenu.setMenuItems(new ArrayList<>());
        clientServiceMenu.setPreviousMenu(previousMenu);

        MenuItem addNewClient = new MenuItem("Add a new client.",
                null, new CreateNewUserAction());
        clientServiceMenu.getMenuItems().add(addNewClient);

        MenuItem showAllClients = new MenuItem("Show all clients.",
                null, new ShowAllClientsAction());
        clientServiceMenu.getMenuItems().add(showAllClients);

        MenuItem deleteClient = new MenuItem("Delete client.",
                null, new DeleteUserAction());
        clientServiceMenu.getMenuItems().add(deleteClient);

        MenuItem editClient = new MenuItem("Edit client.",
                null, new EditUserAction());
        clientServiceMenu.getMenuItems().add(editClient);

        MenuItem backToPreviousMenu = new MenuItem("Back.",
                null, new GoToPreviousMenuAction());
        clientServiceMenu.getMenuItems().add(backToPreviousMenu);

        return clientServiceMenu;
    }

    private static Menu initializeShopServiceMenu(Menu previousMenu){
        Menu shopServiceMenu = new Menu();
        shopServiceMenu.setMenuItems(new ArrayList<>());
        shopServiceMenu.setPreviousMenu(previousMenu);

        MenuItem addNewShop = new MenuItem("Add a new shop.",
                null, new CreateNewShopAction());
        shopServiceMenu.getMenuItems().add(addNewShop);

        MenuItem showAllShops = new MenuItem("Show all shops.",
                null, new ShowAllShopsAction());
        shopServiceMenu.getMenuItems().add(showAllShops);

        MenuItem deleteShop = new MenuItem("Delete shop.",
                null, new DeleteShopAction());
        shopServiceMenu.getMenuItems().add(deleteShop);

        MenuItem editShop = new MenuItem("Edit shop.",
                null, new EditShopAction());
        shopServiceMenu.getMenuItems().add(editShop);

        MenuItem addProductToShop = new MenuItem("Add product to shop.",
                null, new AddProductToShopAction());
        shopServiceMenu.getMenuItems().add(addProductToShop);

        MenuItem upgradeProductInfo = new MenuItem("Upgrade product info in shop.",
                null, new UpdateProductInfoInShopAction());
        shopServiceMenu.getMenuItems().add(upgradeProductInfo);

        MenuItem backToPreviousMenu = new MenuItem("Back.",
                null, new GoToPreviousMenuAction());
        shopServiceMenu.getMenuItems().add(backToPreviousMenu);

        return shopServiceMenu;
    }

    private static Menu initializeProductServiceMenu(Menu previousMenu){
        Menu productServiceMenu = new Menu();
        productServiceMenu.setMenuItems(new ArrayList<>());
        productServiceMenu.setPreviousMenu(previousMenu);

        MenuItem addNewProduct = new MenuItem("Add a new product.",
                null, new CreateNewProductAction());
        productServiceMenu.getMenuItems().add(addNewProduct);

        MenuItem showAllProducts = new MenuItem("Show all products.",
                null, new ShowAllProductsAction());
        productServiceMenu.getMenuItems().add(showAllProducts);

        MenuItem deleteProduct = new MenuItem("Delete product.",
                null, new DeleteProductAction());
        productServiceMenu.getMenuItems().add(deleteProduct);

        MenuItem editProduct = new MenuItem("Edit product.",
                null, new EditProductAction());
        productServiceMenu.getMenuItems().add(editProduct);

        MenuItem backToPreviousMenu = new MenuItem("Back.",
                null, new GoToPreviousMenuAction());
        productServiceMenu.getMenuItems().add(backToPreviousMenu);

        return productServiceMenu;
    }

    private static Menu initializeProductSearchServiceMenu(Menu previousMenu){
        Menu productSearchServiceMenu = new Menu();
        productSearchServiceMenu.setMenuItems(new ArrayList<>());
        productSearchServiceMenu.setPreviousMenu(previousMenu);

        MenuItem showProductsByCategory = new MenuItem("Show products by categories.",
                null, new ShowProductsByCategoriesAction());
        productSearchServiceMenu.getMenuItems().add(showProductsByCategory);

        MenuItem showProductsByAttributes = new MenuItem("Show products by attributes.",
                null, new ShowProductsByAttributesAction());
        productSearchServiceMenu.getMenuItems().add(showProductsByAttributes);

        MenuItem showProductsSortedByPrice = new MenuItem("Show products sorted by price.",
                null, new ShowProductsSortedByPriceAction(SortType.ASCENDING));
        productSearchServiceMenu.getMenuItems().add(showProductsSortedByPrice);

        MenuItem showProductsSortedByPriceDesc = new MenuItem("Show products sorted by price (descending).",
                null, new ShowProductsSortedByPriceAction(SortType.DESCENDING));
        productSearchServiceMenu.getMenuItems().add(showProductsSortedByPriceDesc);

        MenuItem backToPreviousMenu = new MenuItem("Back.",
                null, new GoToPreviousMenuAction());
        productSearchServiceMenu.getMenuItems().add(backToPreviousMenu);

        return productSearchServiceMenu;
    }

    private static Menu initializeOrderServiceMenu(Menu previousMenu){
        Menu orderServiceMenu = new Menu();
        orderServiceMenu.setMenuItems(new ArrayList<>());
        orderServiceMenu.setPreviousMenu(previousMenu);

        MenuItem createNewOrder = new MenuItem("Create new order.",
                null, new CreateNewOrderAction());
        orderServiceMenu.getMenuItems().add(createNewOrder);

        MenuItem showAllOrders = new MenuItem("Show all orders.",
                null, new ShowAllOrdersAction());
        orderServiceMenu.getMenuItems().add(showAllOrders);

        MenuItem backToPreviousMenu = new MenuItem("Back.",
                null, new GoToPreviousMenuAction());
        orderServiceMenu.getMenuItems().add(backToPreviousMenu);

        return orderServiceMenu;
    }
}