module com.example.mealmotive {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.mealmotive to javafx.fxml;
    exports com.example.mealmotive;
}