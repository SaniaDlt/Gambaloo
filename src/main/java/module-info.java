module ir.gambaloo {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
            
    opens ir.gambaloo to javafx.fxml;
    exports ir.gambaloo;
    exports ir.gambaloo.controller;
    opens ir.gambaloo.controller to javafx.fxml;
    exports ir.gambaloo.server;
    opens ir.gambaloo.server to javafx.fxml;
}