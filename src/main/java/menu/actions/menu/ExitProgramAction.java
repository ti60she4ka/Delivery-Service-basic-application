package menu.actions.menu;

import menu.actions.Action;
import storages.*;
import filemanager.FileManager;

import java.io.IOException;

public class ExitProgramAction implements Action {
    @Override
    public void doAction(int index) {
        save();
        System.exit(0);
    }

    private void save(){
        try {
            FileManager.serialize(UserDataStorage.getInstance(),
                    "src/main/java/files/UserDataStorage.json", AbstractDataStorage.class);

            FileManager.serialize(ProductDataStorage.getInstance(),
                    "src/main/java/files/ProductDataStorage.json", AbstractDataStorage.class);

            FileManager.serialize(ShopDataStorage.getInstance(),
                    "src/main/java/files/ShopDataStorage.json", AbstractDataStorage.class);

            FileManager.serialize(OrderDataStorage.getInstance(),
                    "src/main/java/files/OrderDataStorage.json", AbstractDataStorage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
