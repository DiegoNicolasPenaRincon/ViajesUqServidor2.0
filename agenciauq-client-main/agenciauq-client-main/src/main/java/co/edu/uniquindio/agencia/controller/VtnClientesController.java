package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.Clientes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class VtnClientesController {

    private Stage stage;
    private VtnInicioSesionController vtnInicioSesionController;

    private Clientes cliente;
    @FXML
    private Button btnPaqTristicos;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnRecomendaciones;

    @FXML
    private Button btnReservas;

    @FXML
    private AnchorPane panelBotones;

    @FXML
    private AnchorPane panelVentana;

    public void init(Stage stage, VtnInicioSesionController vtnInicioSesionController, Clientes cliente) {
        this.stage = stage;
        this.vtnInicioSesionController = vtnInicioSesionController;
        this.cliente = cliente;
    }


    public void mostrarVentanaPerfil(ActionEvent event) {
        try {
            // Cargar la segunda ventana desde su archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VtnPerfil.fxml"));
            Parent root = loader.load();

            // Crear un nuevo escenario para la segunda ventana
            Stage VtnPerfilStage = new Stage();
            VtnPerfilStage.setTitle("Ventana Perfil");
            VtnPerfilStage.setScene(new Scene(root));

            // Cerrar la ventana actual (primera ventana)
            Stage VtnclientesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VtnclientesStage.close();

            // Mostrar la segunda ventana
            VtnPerfilStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPaquetes(ActionEvent event) {
        try {
            // Cargar la segunda ventana desde su archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VtnPtesCliente.fxml"));
            Parent root = loader.load();

            // Crear un nuevo escenario para la segunda ventana
            Stage VtnPtesClienteStage = new Stage();
            VtnPtesClienteStage.setTitle("Ventana Paquetes");
            VtnPtesClienteStage.setScene(new Scene(root));

            // Cerrar la ventana actual (primera ventana)
            Stage VtnclientesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VtnclientesStage.close();

            // Mostrar la segunda ventana
            VtnPtesClienteStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarRecomendaciones(ActionEvent event) {
        try {
            // Cargar la segunda ventana desde su archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VtnRecomendaciones.fxml"));
            Parent root = loader.load();

            // Crear un nuevo escenario para la segunda ventana
            Stage VtnRecomendacionesStage = new Stage();
            VtnRecomendacionesStage.setTitle("Ventana recomendaciones");
            VtnRecomendacionesStage.setScene(new Scene(root));

            // Cerrar la ventana actual (primera ventana)
            Stage VtnclientesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VtnclientesStage.close();

            // Mostrar la segunda ventana
            VtnRecomendacionesStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mostrarReservas(ActionEvent event) {
        try {
            // Cargar la segunda ventana desde su archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VtnReservas.fxml"));
            Parent root = loader.load();

            // Crear un nuevo escenario para la segunda ventana
            Stage VtnReservasStage = new Stage();
            VtnReservasStage.setTitle("Ventana Reservas");
            VtnReservasStage.setScene(new Scene(root));

            // Cerrar la ventana actual (primera ventana)
            Stage VtnclientesStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VtnclientesStage.close();

            // Mostrar la segunda ventana
            VtnReservasStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
