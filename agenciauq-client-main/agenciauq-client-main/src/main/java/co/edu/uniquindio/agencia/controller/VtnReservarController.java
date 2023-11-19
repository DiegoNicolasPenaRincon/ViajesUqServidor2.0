package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.exceptions.CampoObligatorioException;
import co.edu.uniquindio.agencia.exceptions.MalaFechaException;
import co.edu.uniquindio.agencia.exceptions.ValorInvalidoException;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.model.Clientes;
import co.edu.uniquindio.agencia.model.GuiasTuristicos;
import co.edu.uniquindio.agencia.model.PaqueteTuristico;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class VtnReservarController {

    private final AgenciaViajes agenciaViajes=AgenciaViajes.getInstance();
    @FXML
    private DatePicker DateInicio;

    @FXML
    private Spinner<Integer> txtNumPersonas;

    @FXML
    private TextArea txtGuia;

    @FXML
    private ComboBox<String> boxGuia;

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

        ObservableList<String> opciones = FXCollections.observableArrayList();
        opciones.add("No");
        for (GuiasTuristicos guia : agenciaViajes.getListaGuias()) {
            opciones.add(guia.getNombre());
        }
        boxGuia.setItems(opciones);
        boxGuia.getSelectionModel().select(0);
    }

    public void regresar(){
        try {
            // Cargar el FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/VtnPtesCliente.fxml"));
            Pane nuevaVentana = loader.load();
            VtnPtesClienteController ptesClienteController=loader.getController();
            ptesClienteController.init(panelVentanas, cliente);


            // Limpiar el contenido anterior y establecer el nuevo contenido
            panelVentanas.getChildren().clear();
            panelVentanas.getChildren().add(nuevaVentana);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearReserva(){
        try{
        agenciaViajes.crearReserva(
                cliente,
                paquete,
                DateInicio.getValue(),
                String.valueOf(txtNumPersonas.getValue()),
                boxGuia.getValue(),
                lblPrecio.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Nueva Reserva Creada.");
            alert.setHeaderText(null);
            alert.show();
            regresar();
        }catch(CampoObligatorioException | MalaFechaException | ValorInvalidoException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText(null);
            alert.show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


}
