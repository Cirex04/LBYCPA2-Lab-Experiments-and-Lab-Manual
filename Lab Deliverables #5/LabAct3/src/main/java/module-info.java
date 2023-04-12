module tree.visualization.labact3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens tree.visualization.labact3 to javafx.fxml;
    exports tree.visualization.labact3;
}