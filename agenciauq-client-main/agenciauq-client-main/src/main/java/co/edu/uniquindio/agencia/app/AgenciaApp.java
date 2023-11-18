package co.edu.uniquindio.agencia.app;

import co.edu.uniquindio.agencia.controller.VtnInicioSesionController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AgenciaApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader( AgenciaApp.class.getResource("/Ventanas/VtnInicioSesion.fxml") );
        Parent parent= loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Agencia de Viajes UQ");
        VtnInicioSesionController controller =loader.getController();
        controller.setStage(stage);
        stage.show();

    }

    public static void main(String[] args) {
        launch( AgenciaApp.class, args );
    }

}
