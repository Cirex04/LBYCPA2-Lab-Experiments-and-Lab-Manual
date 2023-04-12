module data_structure.labact4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens data_structure.labact4 to javafx.fxml;
    exports data_structure.labact4;
}