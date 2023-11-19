package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.stream.Collectors;

public class VtnReservasController {
    private final AgenciaViajes agenciaViajes=AgenciaViajes.getInstance();
    @FXML
    private TextField TxtBuscar;

    @FXML
    private Button btnCalificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnbuscar;

    @FXML
    private TableColumn<Reservas, String> colEstado;

    @FXML
    private TableColumn<Reservas, String> colGuia;

    @FXML
    private TableColumn<Reservas, String> colPaquete;

    @FXML
    private TableColumn<Reservas, String> colPersonas;

    @FXML
    private TableColumn<Reservas, String> colPrecio;

    @FXML
    private TableView<Reservas> tablaReservas;

    private AnchorPane panelVentana;
    private Clientes cliente;

    public void init(AnchorPane panelVentana, Clientes cliente) {
        this.panelVentana=panelVentana;
        this.cliente=cliente;

        colEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().name()));
        colPaquete.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaquete().getNombre()));
        colPersonas.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getNumPersonas())));
        colGuia.setCellValueFactory(cellData -> {
            GuiasTuristicos guia = cellData.getValue().getGuiaTuristico();
            String guiaNombre = (guia != null) ? guia.getNombre() : "No";
            return new SimpleStringProperty(guiaNombre);
        });
        colPrecio.setCellValueFactory((cellData->new SimpleStringProperty(Double.toString(cellData.getValue().getPrecioTotal()))));

        ObservableList<Reservas> reservasCliente = FXCollections.observableArrayList(
                agenciaViajes.getListaReservas());
        tablaReservas.setItems(reservasCliente);

    }
}
