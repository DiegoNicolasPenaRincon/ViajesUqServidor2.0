package co.edu.uniquindio.agencia.app;

import co.edu.uniquindio.agencia.controller.VtnInicioSesionController;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.socket.HiloCliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AgenciaApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int puerto =1234;

        AgenciaViajes agenciaViajes=AgenciaViajes.getInstance();

        try(ServerSocket serverSocket=new ServerSocket(puerto)){
            System.out.println(("Esperando conexión"));
            while(true){
                Socket clienteSocket=serverSocket.accept();
                System.out.println("Cliente conectado");

                HiloCliente hilo=new HiloCliente(clienteSocket, agenciaViajes);
                new Thread(hilo).start();
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        launch( AgenciaApp.class, args );


    }
}
