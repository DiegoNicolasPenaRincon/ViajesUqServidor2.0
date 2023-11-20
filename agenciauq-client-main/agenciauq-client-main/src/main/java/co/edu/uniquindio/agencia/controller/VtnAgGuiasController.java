package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.exceptions.CampoObligatorioException;
import co.edu.uniquindio.agencia.exceptions.IgualesException;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.model.Clima;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class VtnAgGuiasController {
    @FXML
    public ImageView JboxIdiomas;
    @FXML
    public TextField TxtId;
    @FXML
    public TextField TxtNombre;
    @FXML
    public TextField TxtExperiencia;
    @FXML
    public Button btnAgregar;
    @FXML
    public Button btnRegresar;
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();
    @FXML
    public CheckBox Espanol;
    @FXML
    public CheckBox Ingles;
    @FXML
    public CheckBox Portugues;
    @FXML
    public CheckBox Frances;
    @FXML
    public CheckBox Aleman;
    @FXML
    public TextField TxtIdentificacion;

    private AnchorPane panel;

    public void init(AnchorPane panel) {
        this.panel = panel;

    }

    public void agregarGuia() {
        List<String> lenguajes=List.of(Espanol.getText(),Ingles.getText(),Portugues.getText(),Frances.getText(),Aleman.getText());
        try
        {
            agenciaViajes.agregarGuiaTuristico(TxtNombre.getText(),TxtIdentificacion.getText(), (ArrayList<String>) lenguajes,TxtExperiencia.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Se ha creado el nuevo guia.");
            alert.setHeaderText(null);
            alert.show();
        }
        catch (CampoObligatorioException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText(null);
            alert.show();
        }
        catch (IgualesException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText(null);
            alert.show();
        }
    }

}
