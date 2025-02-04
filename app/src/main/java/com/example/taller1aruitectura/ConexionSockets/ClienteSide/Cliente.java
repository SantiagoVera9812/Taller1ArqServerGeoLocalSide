package com.example.taller1aruitectura.ConexionSockets;

import com.example.taller1aruitectura.Sensor.SensorData;

import java.io.*;
import java.net.ConnectException;
import java.util.Random;

public class Cliente extends Conexion
{

    private String tipo;
    private SensorData valor;

    public Cliente(String tipo, SensorData valor) throws IOException{super("cliente");

    this.tipo = tipo;
    this.valor = valor;} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        Random random = new Random();
        try
        {
            //Flujo de datos hacia el servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);


                out.println(this.tipo + " " + this.valor);
                System.out.println(this.tipo + " " + this.valor);


            out.println("FIN");

            String resultado = in.readLine();

            System.out.println("Resultado de la suma: " + resultado);

            cs.close();//Fin de la conexión
        }
        catch (ConnectException e2){
            System.out.println("No hay un servidor disponible");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}