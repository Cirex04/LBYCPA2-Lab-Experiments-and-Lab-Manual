module minimax.tictactoe.labact4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    exports minimax.tictactoe.labact4;
    opens minimax.tictactoe.labact4 to javafx.fxml;
}