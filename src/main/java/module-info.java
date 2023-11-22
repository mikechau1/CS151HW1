module edu.sjsu {
    requires javafx.controls;
    requires javafx.fxml;

    opens mikechau.hw1 to javafx.fxml;
    exports mikechau.hw1;
}
