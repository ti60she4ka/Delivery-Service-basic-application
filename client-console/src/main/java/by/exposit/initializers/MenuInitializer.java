package by.exposit.initializers;

import by.exposit.actions.menu.ExitProgramAction;
import by.exposit.actions.menu.GoToPreviousMenuAction;
import by.exposit.actions.menu.GoToSubmenuAction;
import by.exposit.actions.order.CreateNewOrderAction;
import by.exposit.actions.order.ShowAllOrdersAction;
import by.exposit.actions.product.CreateNewProductAction;
import by.exposit.actions.product.DeleteProductAction;
import by.exposit.actions.product.EditProductAction;
import by.exposit.actions.product.ShowAllProductsAction;
import by.exposit.actions.product.ShowProductsByAttributesAction;
import by.exposit.actions.product.ShowProductsByCategoriesAction;
import by.exposit.actions.product.ShowProductsSortedByPriceAction;
import by.exposit.actions.shop.AddProductToShopAction;
import by.exposit.actions.shop.CreateNewShopAction;
import by.exposit.actions.shop.DeleteShopAction;
import by.exposit.actions.shop.EditShopAction;
import by.exposit.actions.shop.ShowAllShopsAction;
import by.exposit.actions.shop.UpdateProductInfoInShopAction;
import by.exposit.actions.user.CreateNewUserAction;
import by.exposit.actions.user.DeleteUserAction;
import by.exposit.actions.user.EditUserAction;
import by.exposit.actions.user.ShowAllClientsAction;
import by.exposit.controllers.ArticleController;
import by.exposit.controllers.OrderController;
import by.exposit.controllers.ProductController;
import by.exposit.controllers.ShopController;
import by.exposit.controllers.UserController;
import by.exposit.filemanager.FileManager;
import by.exposit.menu.Menu;
import by.exposit.menu.MenuContext;
import by.exposit.menu.MenuItem;
import by.exposit.model.enums.sort.SortType;
import by.exposit.storages.OrderDataStorage;
import by.exposit.storages.ProductDataStorage;
import by.exposit.storages.ShopDataStorage;
import by.exposit.storages.UserDataStorage;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuInitializer implements Initializer {

  @Autowired
  private FileManager fileManager;
  @Autowired
  private UserDataStorage userDataStorage;
  @Autowired
  private OrderDataStorage orderDataStorage;
  @Autowired
  private ShopDataStorage shopDataStorage;
  @Autowired
  private ProductDataStorage productDataStorage;
  @Autowired
  private UserController userController;
  @Autowired
  private OrderController orderController;
  @Autowired
  private ShopController shopController;
  @Autowired
  private ProductController productController;
  @Autowired
  private ArticleController articleController;

  public void init() {
    initializeRootMenu();
  }

  private void initializeRootMenu() {
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
        null, new ExitProgramAction(fileManager, userDataStorage, productDataStorage,
        shopDataStorage, orderDataStorage));
    MenuContext.getMenu().getMenuItems().add(exitProgram);
  }

  private Menu initializeClientServiceMenu(Menu previousMenu) {
    Menu clientServiceMenu = new Menu();
    clientServiceMenu.setMenuItems(new ArrayList<>());
    clientServiceMenu.setPreviousMenu(previousMenu);

    MenuItem addNewClient = new MenuItem("Add a new client.",
        null, new CreateNewUserAction(userController));
    clientServiceMenu.getMenuItems().add(addNewClient);

    MenuItem showAllClients = new MenuItem("Show all clients.",
        null, new ShowAllClientsAction(userController));
    clientServiceMenu.getMenuItems().add(showAllClients);

    MenuItem deleteClient = new MenuItem("Delete client.",
        null, new DeleteUserAction(userController));
    clientServiceMenu.getMenuItems().add(deleteClient);

    MenuItem editClient = new MenuItem("Edit client.",
        null, new EditUserAction(userController));
    clientServiceMenu.getMenuItems().add(editClient);

    MenuItem backToPreviousMenu = new MenuItem("Back.",
        null, new GoToPreviousMenuAction());
    clientServiceMenu.getMenuItems().add(backToPreviousMenu);

    return clientServiceMenu;
  }

  private Menu initializeShopServiceMenu(Menu previousMenu) {
    Menu shopServiceMenu = new Menu();
    shopServiceMenu.setMenuItems(new ArrayList<>());
    shopServiceMenu.setPreviousMenu(previousMenu);

    MenuItem addNewShop = new MenuItem("Add a new shop.",
        null, new CreateNewShopAction(shopController));
    shopServiceMenu.getMenuItems().add(addNewShop);

    MenuItem showAllShops = new MenuItem("Show all shops.",
        null, new ShowAllShopsAction(shopController));
    shopServiceMenu.getMenuItems().add(showAllShops);

    MenuItem deleteShop = new MenuItem("Delete shop.",
        null, new DeleteShopAction(shopController));
    shopServiceMenu.getMenuItems().add(deleteShop);

    MenuItem editShop = new MenuItem("Edit shop.",
        null, new EditShopAction(shopController));
    shopServiceMenu.getMenuItems().add(editShop);

    MenuItem addProductToShop = new MenuItem("Add product to shop.",
        null, new AddProductToShopAction(shopController, productController));
    shopServiceMenu.getMenuItems().add(addProductToShop);

    MenuItem upgradeProductInfo = new MenuItem("Upgrade product info in shop.",
        null, new UpdateProductInfoInShopAction(shopController));
    shopServiceMenu.getMenuItems().add(upgradeProductInfo);

    MenuItem backToPreviousMenu = new MenuItem("Back.",
        null, new GoToPreviousMenuAction());
    shopServiceMenu.getMenuItems().add(backToPreviousMenu);

    return shopServiceMenu;
  }

  private Menu initializeProductServiceMenu(Menu previousMenu) {
    Menu productServiceMenu = new Menu();
    productServiceMenu.setMenuItems(new ArrayList<>());
    productServiceMenu.setPreviousMenu(previousMenu);

    MenuItem addNewProduct = new MenuItem("Add a new product.",
        null, new CreateNewProductAction(productController));
    productServiceMenu.getMenuItems().add(addNewProduct);

    MenuItem showAllProducts = new MenuItem("Show all products.",
        null, new ShowAllProductsAction(productController));
    productServiceMenu.getMenuItems().add(showAllProducts);

    MenuItem deleteProduct = new MenuItem("Delete product.",
        null, new DeleteProductAction(productController));
    productServiceMenu.getMenuItems().add(deleteProduct);

    MenuItem editProduct = new MenuItem("Edit product.",
        null, new EditProductAction(productController));
    productServiceMenu.getMenuItems().add(editProduct);

    MenuItem backToPreviousMenu = new MenuItem("Back.",
        null, new GoToPreviousMenuAction());
    productServiceMenu.getMenuItems().add(backToPreviousMenu);

    return productServiceMenu;
  }

  private Menu initializeProductSearchServiceMenu(Menu previousMenu) {
    Menu productSearchServiceMenu = new Menu();
    productSearchServiceMenu.setMenuItems(new ArrayList<>());
    productSearchServiceMenu.setPreviousMenu(previousMenu);

    MenuItem showProductsByCategory = new MenuItem("Show products by categories.",
        null, new ShowProductsByCategoriesAction(articleController));
    productSearchServiceMenu.getMenuItems().add(showProductsByCategory);

    MenuItem showProductsByAttributes = new MenuItem("Show products by attributes.",
        null, new ShowProductsByAttributesAction(articleController, shopController));
    productSearchServiceMenu.getMenuItems().add(showProductsByAttributes);

    MenuItem showProductsSortedByPrice = new MenuItem("Show products sorted by price.",
        null, new ShowProductsSortedByPriceAction(articleController, SortType.ASCENDING));
    productSearchServiceMenu.getMenuItems().add(showProductsSortedByPrice);

    MenuItem showProductsSortedByPriceDesc = new MenuItem(
        "Show products sorted by price (descending).",
        null, new ShowProductsSortedByPriceAction(articleController, SortType.DESCENDING));
    productSearchServiceMenu.getMenuItems().add(showProductsSortedByPriceDesc);

    MenuItem backToPreviousMenu = new MenuItem("Back.",
        null, new GoToPreviousMenuAction());
    productSearchServiceMenu.getMenuItems().add(backToPreviousMenu);

    return productSearchServiceMenu;
  }

  private Menu initializeOrderServiceMenu(Menu previousMenu) {
    Menu orderServiceMenu = new Menu();
    orderServiceMenu.setMenuItems(new ArrayList<>());
    orderServiceMenu.setPreviousMenu(previousMenu);

    MenuItem createNewOrder = new MenuItem("Create new order.",
        null, new CreateNewOrderAction(orderController));
    orderServiceMenu.getMenuItems().add(createNewOrder);

    MenuItem showAllOrders = new MenuItem("Show all orders.",
        null, new ShowAllOrdersAction(orderController));
    orderServiceMenu.getMenuItems().add(showAllOrders);

    MenuItem backToPreviousMenu = new MenuItem("Back.",
        null, new GoToPreviousMenuAction());
    orderServiceMenu.getMenuItems().add(backToPreviousMenu);

    return orderServiceMenu;
  }
}