package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.Clima;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class VtnEditarDestinosController {

    @FXML
    private ComboBox<Clima> boxClima;

    @FXML
    private Button btnCargarImagenes;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnRegresar;

    @FXML
    private ImageView imagen1;

    @FXML
    private ImageView imagen2;

    @FXML
    private ImageView imagen3;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtImagen1;

    @FXML
    private TextField txtImagen2;

    @FXML
    private TextField txtImagen3;

    @FXML
    private TextField txtNombre;

    private AnchorPane panel;
    public void init(AnchorPane panel) {
        this.panel=panel;
    }

    public void regresar(){
        try {
            // Cargar el FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/VtnConsulDestinos.fxml"));
            Pane nuevaVentana = loader.load();
            VtnConsulDestinosController consulDestinosController=loader.getController();
            consulDestinosController.init(panel);


            // Limpiar el contenido anterior y establecer el nuevo contenido
            panel.getChildren().clear();
            panel.getChildren().add(nuevaVentana);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
