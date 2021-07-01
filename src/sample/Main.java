package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader root = new FXMLLoader(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Temperature Converter Tool");

        Pane rootNode = root.load();
        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene =  new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        newItem.setOnAction(actionEvent -> System.out.println("Create new file"));
        MenuItem saveItem = new MenuItem("Save");
        fileMenu.getItems().addAll(newItem,separatorMenuItem1,saveItem);

        Menu moreMenu = new Menu("More");
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(actionEvent -> aboutApp());
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
        moreMenu.getItems().addAll(aboutItem,separatorMenuItem2,exitItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, moreMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About My Desktop App");
        alert.setContentText("This is my first desktop application!");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(yes,no);
        alert.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
