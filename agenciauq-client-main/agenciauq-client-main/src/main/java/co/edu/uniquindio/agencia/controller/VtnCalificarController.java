package co.edu.uniquindio.agencia.controller;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class VtnCalificarController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    void initialize() {
        comboBox.getItems().addAll("Muy Recomendado", "Recomendado", "No recomendado");
    }

}
