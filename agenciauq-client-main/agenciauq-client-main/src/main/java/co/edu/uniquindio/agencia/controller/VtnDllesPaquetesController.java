package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.Destino;
import co.edu.uniquindio.agencia.model.PaqueteTuristico;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class VtnDllesPaquetesController {

    @FXML
    private TableView<Destino> Destino;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Destino, String> colCiudad;

    @FXML
    private TableColumn<Destino, String> colClima;

    @FXML
    private TableColumn<Destino, String> colDescripcion;

    @FXML
        private TableColumn<PaqueteTuristico, String> colNombre;

    @FXML
    private Label lblCaracteristicas;

    @FXML
    private Label lblFinal;

    @FXML
    private Label lblInicio;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblPrecio;

    private AnchorPane panelVentana;
    private PaqueteTuristico paqueteSeleccionado;

    public void init(AnchorPane panelVentana, PaqueteTuristico paqueteSeleccionado){
        this.panelVentana=panelVentana;
        this.paqueteSeleccionado=paqueteSeleccionado;

        lblNombre.setText(paqueteSeleccionado.getNombre());
        lblCaracteristicas.setText(paqueteSeleccionado.getServicios());
        lblInicio.setText(paqueteSeleccionado.getFechaInicio().toString());
        lblFinal.setText(paqueteSeleccionado.getFechaFin().toString());
        lblPrecio.setText(String.valueOf(paqueteSeleccionado.getPrecio()));


    }
}
