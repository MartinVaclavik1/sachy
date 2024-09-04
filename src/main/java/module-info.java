module com.example.sachy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sachy to javafx.fxml;
    exports com.example.sachy;
}