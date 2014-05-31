package fr.jojal.widget.radial.app;

import fr.jojal.widget.radial.menu.RadialMenu;
import fr.jojal.widget.radial.menu.RadialMenuContainer;
import fr.jojal.widget.radial.menu.RadialMenuItem;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class RadialMenuMain extends Application {

    public static void main(String... args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        RadialMenu radialMenu = new RadialMenu(60, 120, 360, 5);


        RadialMenuContainer firstContainer = new RadialMenuContainer();
        firstContainer.setText("Container");
        firstContainer.setChildrenCenterOnParent(true);
        RadialMenuContainer secondContainer = new RadialMenuContainer();
        secondContainer.setText("Container");
        secondContainer.setChildrenCenterOnParent(true);
        RadialMenuContainer thirdContainer = new RadialMenuContainer();
        thirdContainer.setText("Container");
        RadialMenuItem fourthItem = new RadialMenuItem();
        fourthItem.setText("Item");
        RadialMenuItem sixthItem = new RadialMenuItem();
        sixthItem.setText("Item");

        RadialMenuItem firstContainerSecondStage = new RadialMenuItem();
        firstContainerSecondStage.setText("Item");
        RadialMenuItem firstContainerSecondStage2 = new RadialMenuItem();
        firstContainerSecondStage2.setText("Item");
        RadialMenuItem firstContainerSecondStage3 = new RadialMenuItem();
        firstContainerSecondStage3.setText("Item");
        RadialMenuItem firstContainerSecondStage4 = new RadialMenuItem();
        firstContainerSecondStage4.setText("Item");
        firstContainer.addItem(firstContainerSecondStage);
        firstContainer.addItem(firstContainerSecondStage2);
        firstContainer.addItem(firstContainerSecondStage3);
        firstContainer.addItem(firstContainerSecondStage4);

        RadialMenuItem secondContainerSecondStage = new RadialMenuItem();
        secondContainerSecondStage.setText("Item");
        RadialMenuItem secondContainerSecondStage2 = new RadialMenuItem();
        secondContainerSecondStage2.setText("Item");
        RadialMenuItem secondContainerSecondStage3 = new RadialMenuItem();
        secondContainerSecondStage3.setText("Item");
        RadialMenuItem secondContainerSecondStage4 = new RadialMenuItem();
        secondContainerSecondStage4.setText("Item");
        secondContainer.addItem(secondContainerSecondStage);
        secondContainer.addItem(secondContainerSecondStage2);
        secondContainer.addItem(secondContainerSecondStage3);
        secondContainer.addItem(secondContainerSecondStage4);

        RadialMenuItem thirdContainerSecondStage = new RadialMenuItem();
        thirdContainerSecondStage.setText("Item");
        RadialMenuItem thirdContainerSecondStage2 = new RadialMenuItem();
        thirdContainerSecondStage2.setText("Item");
        RadialMenuItem thirdContainerSecondStage3 = new RadialMenuItem();
        thirdContainerSecondStage3.setText("Item");
        RadialMenuItem thirdContainerSecondStage4 = new RadialMenuItem();
        thirdContainerSecondStage4.setText("Item");
        thirdContainer.addItem(thirdContainerSecondStage);
        thirdContainer.addItem(thirdContainerSecondStage2);
        thirdContainer.addItem(thirdContainerSecondStage3);
        thirdContainer.addItem(thirdContainerSecondStage4);

        radialMenu.addRootItem(firstContainer);
        radialMenu.addRootItem(secondContainer);
        radialMenu.addRootItem(thirdContainer);
        radialMenu.addRootItem(fourthItem);
        radialMenu.addRootItem(sixthItem);

        Group group = new Group();
        Scene scene = new Scene(group, 800, 600);
        scene.getStylesheets().add(getClass().getResource("radialmenu.css").toExternalForm());

        radialMenu.setLayoutX(400);
        radialMenu.setLayoutY(300);

        group.getChildren().add(radialMenu);

        stage.setScene(scene);
        stage.show();
    }
}
