package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.Clientes;
import co.edu.uniquindio.agencia.model.GuiasTuristicos;
import co.edu.uniquindio.agencia.model.PaqueteTuristico;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class VtnReservarController {
    @FXML
    private DatePicker DateInicio;

    @FXML
    private Spinner<Integer> txtNumPersonas;

    @FXML
    private TextArea txtGuia;

    @FXML
    private ComboBox<GuiasTuristicos> boxGuia;

    @FXML
    private Label lblPrecio;

    private AnchorPane panelVentanas;
    private PaqueteTuristico paquete;
    private Clientes cliente;


    public void init(AnchorPane panelVentana, PaqueteTuristico paqueteSeleccionado, Clientes cliente) {
        this.cliente=cliente;
        this.panelVentanas=panelVentana;
        this.paquete=paqueteSeleccionado;

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
                1, Integer.MAX_VALUE, 1); // Rango y valor inicial
        txtNumPersonas.setValueFactory(valueFactory);

        lblPrecio.setText(String.valueOf(paquete.getPrecio()));

        // Agregar un ChangeListener al Spinner
        txtNumPersonas.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                // Actualizar el texto del Label cuando cambia el valor del Spinner
                lblPrecio.setText(String.valueOf(paquete.getPrecio()*newValue));
            }
        });
    }
}
