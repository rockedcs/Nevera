module mikita.kishkevich.nevera {
    requires javafx.controls;
    requires javafx.fxml;
    requires Fitxers;


    opens mikita.kishkevich.nevera to javafx.fxml;
    exports mikita.kishkevich.nevera;
}