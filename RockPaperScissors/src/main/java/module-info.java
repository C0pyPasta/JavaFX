module com.example.rockpaperscissors {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;

    opens com.example.rockpaperscissors to javafx.fxml;
    exports com.example.rockpaperscissors;
}