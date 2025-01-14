module com.example.currencyexchange {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires okhttp3;
    requires com.google.gson;

    opens com.example.currencyexchange to javafx.fxml;
    exports com.example.currencyexchange;
}