package co.edu.uniquindio.agencia.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class VtnGestiGuiasController {


    @FXML
    public Button btnAgGuias;

    private AnchorPane panel;

    public void mostrarVentanaAgregarGuias() {
        try
        {
            // Cargar el FXML en el AnchorPane derecho
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/VtnAgGuias.fxml"));
            Pane nuevaVentana = loader.load();

            // Limpiar el contenido anterior y establecer el nuevo contenido
            panel.getChildren().clear();
            panel.getChildren().add(nuevaVentana);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
