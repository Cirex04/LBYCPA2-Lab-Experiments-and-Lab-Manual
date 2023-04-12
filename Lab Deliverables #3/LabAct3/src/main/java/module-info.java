module quiz.queue.labact3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens quiz.queue.labact3 to javafx.fxml;
    exports quiz.queue.labact3;
}