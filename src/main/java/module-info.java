module com.example.fxtableviewjava18 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxtableviewjava18 to javafx.fxml;
    exports com.example.fxtableviewjava18;
}