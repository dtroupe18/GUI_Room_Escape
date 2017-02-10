/*
 * Created by Dave on 2/10/17.
 */

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();

        // user can only interact with alert box window
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(250);

        Label label = new Label();
        label.setText(message);

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

        Scene scene = new Scene(layout);
        window.setScene(scene);

        window.showAndWait();

        return answer;
    }
}
