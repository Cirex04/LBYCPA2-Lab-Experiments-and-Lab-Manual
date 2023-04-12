module sorting.visualization.labact4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens sorting.visualization.labact4 to javafx.fxml;
    exports sorting.visualization.labact4;
}