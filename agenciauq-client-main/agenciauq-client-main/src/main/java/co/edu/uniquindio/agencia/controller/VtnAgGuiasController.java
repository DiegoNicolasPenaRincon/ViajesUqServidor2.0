package co.edu.uniquindio.agencia.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class VtnAgGuiasController {

    private AnchorPane panel;
    public void init(AnchorPane panel) {
        this.panel=panel;
    }

    public void regresar(){
        try {
            // Cargar el FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/VtnGestiGuias.fxml"));
            Pane nuevaVentana = loader.load();
            VtnGestiGuiasController gestiGuiasController=loader.getController();
            gestiGuiasController.init(panel);


            // Limpiar el contenido anterior y establecer el nuevo contenido
            panel.getChildren().clear();
            panel.getChildren().add(nuevaVentana);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}