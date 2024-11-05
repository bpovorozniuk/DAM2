module com.dam2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.dam2 to javafx.fxml;
    exports com.dam2;
}
