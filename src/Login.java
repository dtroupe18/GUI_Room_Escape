/*
 * Created by Dave on 2/14/17.
 */

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {

    private static boolean loggedIn;
    private static String user = "admin";
    private static String pw = "admin";

    public static boolean displayLogin() {
        Stage loginWindow = new Stage();
        loginWindow.setTitle("Login Screen");

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));

        //Hbox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20, 20, 20, 30));

        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20, 20, 20, 20));
        gp.setHgap(5);
        gp.setVgap(5);

        Label username = new Label("Username");
        final TextField usernameText = new TextField();

        Label password = new Label("Password");
        final PasswordField passwordText = new PasswordField();

        Button loginButton = new Button("Login");
        final Label message = new Label();

        // add everything
        gp.add(username, 0, 0);
        gp.add(usernameText, 1, 0);
        gp.add(password, 0, 1);
        gp.add(passwordText, 1, 1);
        gp.add(loginButton, 2, 1);
        gp.add(message, 1, 2);

        // Reflection for GP
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7f);
        gp.setEffect(reflection);

        //Drop Shadow
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        Text text = new Text("Login");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);

        hb.getChildren().add(text);

        loginButton.setOnAction(e -> {
            if (usernameText.getText().equals(user) && passwordText.getText().equals(pw)) {
                message.setText("You are logged in");
                message.setTextFill(Color.AQUA);
                loggedIn = true;
                loginWindow.close();

            }

            else {
                message.setText("Incorrect username or password");
                message.setTextFill(Color.RED);
                loggedIn = false;
            }
        });

        bp.setTop(hb);
        bp.setCenter(gp);

        Scene scene = new Scene(bp);
        loginWindow.setScene(scene);
        loginWindow.showAndWait();

        return loggedIn;
    }
}
