module social.net.labact3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens social.net.labact3 to javafx.fxml;
    exports social.net.labact3;
}