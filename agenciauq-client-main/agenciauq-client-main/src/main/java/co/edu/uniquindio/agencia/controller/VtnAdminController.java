package co.edu.uniquindio.agencia.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class VtnAdminController {

    @FXML
    private AnchorPane PanelBotones;

    @FXML
    private Button btnDestinos;

    @FXML
    private Button btnEstadisticas;

    @FXML
    private Button btnGuias;

    @FXML
    private Button btnPaqTuristicos;

    @FXML
    private AnchorPane panelVentanas;
    private Stage stage;
    private VtnInicioSesionController vtnInicioSesionController;
    public void init(Stage stage, VtnInicioSesionController vtnInicioSesionController) {
        this.stage=stage;
        this.vtnInicioSesionController=vtnInicioSesionController;
    }

    public void mostrarVentanaDestinos(ActionEvent event) {
        try {
            // Cargar la segunda ventana desde su archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VtnGestDestino.fxml"));
            Parent root = loader.load();

            // Crear un nuevo escenario para la segunda ventana
            Stage VentanaDestinosStage = new Stage();
            VentanaDestinosStage.setTitle("Ventana Destinos");
            VentanaDestinosStage.setScene(new Scene(root));

            // Cerrar la ventana actual (primera ventana)
            Stage VtnAdmin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VtnAdmin.close();

            // Mostrar la segunda ventana
            VentanaDestinosStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mostrarVentanaPaquetes(ActionEvent event) {
        try {
            // Cargar la segunda ventana desde su archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VtnGestPaquetes.fxml"));
            Parent root = loader.load();

            // Crear un nuevo escenario para la segunda ventana
            Stage VtnGestPaquetesStage = new Stage();
            VtnGestPaquetesStage.setTitle("Ventana Gestionar Paquetes");
            VtnGestPaquetesStage.setScene(new Scene(root));

            // Cerrar la ventana actual (primera ventana)
            Stage primeraVentanaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VtnGestPaquetesStage.close();

            // Mostrar la segunda ventana
            VtnGestPaquetesStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaGuias(ActionEvent event) {
        try {
            // Cargar la segunda ventana desde su archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VtnGestiGuias.fxml"));
            Parent root = loader.load();

            // Crear un nuevo escenario para la segunda ventana
            Stage VtnGestiGuiasStage = new Stage();
            VtnGestiGuiasStage.setTitle("Ventana Guias");
            VtnGestiGuiasStage.setScene(new Scene(root));

            // Cerrar la ventana actual (primera ventana)
            Stage primeraVentanaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VtnGestiGuiasStage.close();

            // Mostrar la segunda ventana
            VtnGestiGuiasStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void mostrarSegundaVentana() {
        try {
            // Cargar la segunda ventana desde su archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VtnEstadisticas.fxml"));
            Parent root = loader.load();

            // Crear un nuevo escenario para la segunda ventana
            Stage VtnEstadisticasStage = new Stage();
            VtnEstadisticasStage.setTitle("Ventana Estadisticas");
            VtnEstadisticasStage.setScene(new Scene(root));

            // Mostrar la segunda ventana
            VtnEstadisticasStage.show();

            // Cerrar la ventana actual (primera ventana)
            Stage VtnAdminStage = (Stage) btnEstadisticas.getScene().getWindow();
            VtnAdminStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







