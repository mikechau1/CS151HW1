package mikechau.hw1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Demo");

        // Create a VBox layout for the scene
        VBox vbox = new VBox(10);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-padding: 20px;");
        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        // Create a Label
        Label nameLabel = new Label("Enter your name:");

        // Create a TextField for user input
        TextField nameField = new TextField();
        nameField.setPromptText("Your name");

        // Create a Button
        Button submitButton = new Button("Submit");

        // Create a Label for displaying a welcome message
        Label welcomeLabel = new Label();

        // Add the form elements to the VBox layout
        vbox.getChildren().addAll(nameLabel, nameField, submitButton, welcomeLabel);

        // Define an animation for the welcome label
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), welcomeLabel);
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);

        // Event handler for the Submit button
        submitButton.setOnAction(event -> {
            String name = nameField.getText().trim();

            if (!name.isEmpty()) {
                welcomeLabel.setText("Welcome, " + name + "!");
                nameField.clear();

                // Play the welcome animation
                scaleTransition.playFromStart();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter your name.");
                alert.showAndWait();
            }
        });

        // Create the scene
        Scene scene = new Scene(vbox, 400, 300);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
}