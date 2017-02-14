/*
 * Created by Dave on 2/10/17.
 */

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    private static boolean answer;

    public static boolean display() {
        Stage window = new Stage();

        // user can only interact with alert box window
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Quit");
        window.setMaxWidth(250);

        Label label = new Label();
        label.setText("Are you sure you want to quit?");

        // create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: red");

        Scene scene = new Scene(layout);
        window.setScene(scene);

        window.showAndWait();

        return answer;
    }
}
