package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.model.Destino;
import co.edu.uniquindio.agencia.model.PaqueteTuristico;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class VtnEditarPaquetesController {

    private final AgenciaViajes agenciaViajes=AgenciaViajes.getInstance();
    @FXML
    private DatePicker DateFinal;

    @FXML
    private DatePicker DateInicio;

    @FXML
    private TableView<Destino> TableDestinos;

    @FXML
    private TextField TxtPrecio;

    @FXML
    private Button btnAgDestinos;

    @FXML
    private Button btnAgDestinos1;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Destino, String> colCiudad;

    @FXML
    private TableColumn<Destino, String> colClima;

    @FXML
    private TableColumn<Destino, String> colNombre;

    @FXML
    private TextField txtCaracteristicas;

    @FXML
    private TextField txtCupo;

    @FXML
    private Spinner<Integer> txtDuracion;

    @FXML
    private TextField txtNombre;

    private AnchorPane panel;
    private PaqueteTuristico paquete;

    private String nombreAntiguo;

    public void init(PaqueteTuristico paquete, AnchorPane panel) {
        this.paquete=paquete;
        this.panel=panel;
        this.nombreAntiguo=paquete.getNombre();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
                1, Integer.MAX_VALUE, paquete.getDuracion()); // Rango y valor inicial
        txtDuracion.setValueFactory(valueFactory);

        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCiudad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCiudad()));
        colClima.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getClima().name()));

        ObservableList<Destino> listaDestinos = FXCollections.observableArrayList(agenciaViajes.getListaDestinos());
        TableDestinos.setItems(listaDestinos);

        txtNombre.setText(paquete.getNombre());
        txtCaracteristicas.setText(paquete.getServicios());
        txtCupo.setText(String.valueOf(paquete.getCupoMaximo()));
        TxtPrecio.setText(String.valueOf(paquete.getPrecio()));



    }
    /*public void editarPaquete(){
        agenciaViajes.modificarPaquete(
                nombreAntiguo,
                txtNombre.getText(),
                txtCaracteristicas.getText(),
                TxtPrecio.getText()


        )
    }

     */
}



