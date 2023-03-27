module com.example.javalabsv2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.javalabsv2 to javafx.fxml;
    exports com.example.javalabsv2;
}