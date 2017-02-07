/*
 * Created by Dave on 2/7/17.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GUI_Room_Escape extends Application {

    Stage window;
    Scene scene1, scene2, scene3, fail, win;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label question1 = new Label("You are in a spooky classroom with lots of students\n " +
                "do you teach or run for the hills?");
        Button button1 = new Button("Teach");
        Button button2 = new Button("Run For It");

        button1.setOnAction(e -> window.setScene(fail));
        button2.setOnAction(e -> window.setScene(scene2));

        // Center everything
        VBox initialScreen = new VBox(10);
        initialScreen.getChildren().addAll(question1, button1, button2);
        StackPane view1 = new StackPane();
        view1.getChildren().add(initialScreen);
        StackPane.setAlignment(initialScreen, Pos.CENTER);

        scene1 = new Scene(view1, 400, 400);
        view1.setStyle("-fx-background-color: #F0591E;");

        // CREATE FAIL SCENE
        Label failed = new Label("You Lose");
        Button button3 = new Button("Start Over");
        button3.setOnAction(e -> window.setScene(scene1));

        VBox failScreen = new VBox(5);
        failScreen.getChildren().addAll(failed, button3);
        StackPane failedView = new StackPane();
        failedView.getChildren().add(failScreen);
        StackPane.setAlignment(failScreen, Pos.CENTER);
        fail = new Scene(failedView, 400, 400);
        failedView.setStyle("-fx-background-color: chartreuse");

        // CREATE SCENE2
        Label question2 = new Label("Are you smart?");
        Button button4 = new Button("YES!");
        Button button5 = new Button("Maybe?");
        button4.setOnAction(e -> window.setScene(fail));
        button5.setOnAction(e -> window.setScene(scene3));

        VBox secondScene = new VBox(5);
        secondScene.getChildren().addAll(question2, button4, button5);
        StackPane secondView = new StackPane();
        secondView.getChildren().add(secondScene);
        StackPane.setAlignment(secondScene, Pos.CENTER);
        scene2 = new Scene(secondView, 400, 400);
        secondView.setStyle("-fx-background-color: darksalmon");


        // CREATE SCENE 3
        Label question3 = new Label("lil wayne is the best rapper alive");
        Button button6 = new Button("TRUE");
        Button button7 = new Button("FALSE");

        button6.setOnAction(e -> window.setScene(fail));
        button7.setOnAction(e -> window.setScene(win));

        VBox thirdScene = new VBox(5);
        thirdScene.getChildren().addAll(question3, button6, button7);
        StackPane thirdView = new StackPane();
        thirdView.getChildren().add(thirdScene);
        StackPane.setAlignment(thirdScene, Pos.CENTER);
        scene3 = new Scene(thirdView, 400, 400);
        thirdView.setStyle("-fx-background-color: deeppink");

        // CREATE WIN SCENE
        Label youWin = new Label("You WIN!");
        Button button8 = new Button("Play Again");
        button8.setOnAction(e -> window.setScene(scene1));


        VBox winScreen = new VBox(5);
        winScreen.getChildren().addAll(youWin, button8);
        StackPane winView = new StackPane();
        winView.getChildren().add(winScreen);
        StackPane.setAlignment(winScreen, Pos.CENTER);
        win = new Scene(winView, 400, 400);
        winView.setStyle("-fx-background-color: khaki");


        // how do we know what scene to display by default?
        window.setScene(scene1);
        window.setTitle("Room Escape");
        window.show();

    }
}
