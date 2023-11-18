package co.edu.uniquindio.agencia.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Clientes {

    private String nombre;
    private String cedula;
    private String contrasena;
    private String telefono;
    private String correo;
    private String direccion;

}
