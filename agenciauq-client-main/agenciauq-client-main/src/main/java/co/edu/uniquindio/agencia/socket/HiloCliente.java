package co.edu.uniquindio.agencia.socket;

import co.edu.uniquindio.agencia.exceptions.CampoObligatorioException;
import co.edu.uniquindio.agencia.exceptions.IgualesException;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.model.Clientes;
import lombok.extern.java.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

@Log
public class HiloCliente implements Runnable{
    private final Socket socket;
    private final AgenciaViajes agencia;

    public HiloCliente(Socket socket, AgenciaViajes agencia){
        this.socket=socket;
        this.agencia=agencia;
    }

    @Override
    public void run(){
        try{
            ObjectInputStream in=new ObjectInputStream((socket.getInputStream()));
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());

            Mensaje mensaje=(Mensaje)in.readObject();

            String tipo= mensaje.getTipo();

            Object contenido=mensaje.getContenido();
            switch(tipo){
                case "cargarClientes":
                    cargarClientes(out);
                    break;
                case "cargarAdmins":
                    cargarAdmins(out);
                    break;
                case "cargarDestinos":
                    cargarDestinos(out);
                    break;
                case "cargarPaquetesTuristicos":
                    cargarPaquetesTuristicos(out);
                    break;
                case "cargarGuiasTuristicos":
                    cargarGuiasTuristicos(out);
                    break;
                case "cargarReservas":
                    cargarReservas(out);
                    break;
                case "registrarCliente":
                    registrarCliente((Clientes) contenido, out);
                    break;
                case "verificarInicio":
                    break;
            }

            socket.close();
        }catch(IOException | ClassNotFoundException e){
            log.severe(e.getMessage());
            throw new RuntimeException(e);
        } catch (IgualesException e) {
            throw new RuntimeException(e);
        } catch (CampoObligatorioException e) {
            throw new RuntimeException(e);
        }
    }

    public void cargarClientes(ObjectOutputStream out) throws IOException {
        out.writeObject(agencia.cargarClientes());
    }

    public void cargarAdmins(ObjectOutputStream out)throws IOException {
        out.writeObject(agencia.cargarAdmins());
    }

    public void cargarDestinos(ObjectOutputStream out)throws IOException {
        out.writeObject(agencia.cargarDestinos());
    }
    public void cargarPaquetesTuristicos(ObjectOutputStream out)throws IOException {
        out.writeObject(agencia.cargarPaquetesTuristicos());
    }

    public void cargarGuiasTuristicos(ObjectOutputStream out)throws IOException {
        out.writeObject(agencia.cargarGuiasTuristicos());
    }

    public void cargarReservas(ObjectOutputStream out)throws IOException {
        out.writeObject(agencia.cargarReservas());
    }

    public void registrarCliente(Clientes cliente, ObjectOutputStream out) throws IOException, IgualesException, CampoObligatorioException {
        try {
            agencia.registrarCliente(cliente.getNombre(),
                    cliente.getCedula(),
                    cliente.getContrasena(),
                    cliente.getTelefono(),
                    cliente.getCorreo(),
                    cliente.getCedula());
            out.writeObject(cliente);
        } catch(IOException e){
            out.writeObject(e.getMessage());
        } catch (IgualesException | CampoObligatorioException e) {
            throw e;
        }

    }

}
