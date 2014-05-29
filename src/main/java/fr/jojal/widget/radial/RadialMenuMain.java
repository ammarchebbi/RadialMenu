package fr.jojal.widget.radial;

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
        RadialMenuContainer secondContainer = new RadialMenuContainer();
        RadialMenuContainer thirdContainer = new RadialMenuContainer();
        RadialMenuItem fourthItem = new RadialMenuItem();
        RadialMenuItem sixthItem = new RadialMenuItem();

        RadialMenuItem firstContainerSecondStage = new RadialMenuItem();
        RadialMenuItem firstContainerSecondStage2 = new RadialMenuItem();
        RadialMenuItem firstContainerSecondStage3 = new RadialMenuItem();
        RadialMenuItem firstContainerSecondStage4 = new RadialMenuItem();
        firstContainer.addItem(firstContainerSecondStage);
        firstContainer.addItem(firstContainerSecondStage2);
        firstContainer.addItem(firstContainerSecondStage3);
        firstContainer.addItem(firstContainerSecondStage4);

        RadialMenuItem secondContainerSecondStage = new RadialMenuItem();
        RadialMenuItem secondContainerSecondStage2 = new RadialMenuItem();
        RadialMenuItem secondContainerSecondStage3 = new RadialMenuItem();
        RadialMenuItem secondContainerSecondStage4 = new RadialMenuItem();
        secondContainer.addItem(secondContainerSecondStage);
        secondContainer.addItem(secondContainerSecondStage2);
        secondContainer.addItem(secondContainerSecondStage3);
        secondContainer.addItem(secondContainerSecondStage4);

        RadialMenuItem thirdContainerSecondStage = new RadialMenuItem();
        RadialMenuItem thirdContainerSecondStage2 = new RadialMenuItem();
        RadialMenuItem thirdContainerSecondStage3 = new RadialMenuItem();
        RadialMenuItem thirdContainerSecondStage4 = new RadialMenuItem();
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
        radialMenu.setLayoutX(400);
        radialMenu.setLayoutY(300);

        group.getChildren().add(radialMenu);

        stage.setScene(scene);
        stage.show();
    }
}
