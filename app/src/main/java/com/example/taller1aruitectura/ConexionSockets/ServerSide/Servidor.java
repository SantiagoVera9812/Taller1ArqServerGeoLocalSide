package com.example.taller1aruitectura.ConexionSockets.ServerSide;

import com.example.taller1aruitectura.Bridge.Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Servidor extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
    public Servidor() throws IOException {super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer() throws IOException//Método para iniciar el servidor
    {

        System.out.println("Esperando..."); //Esperando conexión

        cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

        System.out.println("Cliente en línea");

        //Se obtiene el flujo de salida del cliente para enviarle mensajes

        //Se le envía un mensaje al cliente usando su flujo de salida
        //Se obtiene el flujo entrante desde el cliente
        BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        out.println("Petición recibida y aceptada");
        String mensajeCliente = "";
        String datos="";

        while ((mensajeCliente = entrada.readLine()) != null) {
            if (mensajeCliente.equals("FIN")) {
                break;
            }
            datos += mensajeCliente;
        }

        System.out.println("El mensaje del cliente: " + datos);


        out.println(datos);

        System.out.println("Fin de la conexión");

        ss.close();//Se finaliza la conexión con el cliente
    }
}
