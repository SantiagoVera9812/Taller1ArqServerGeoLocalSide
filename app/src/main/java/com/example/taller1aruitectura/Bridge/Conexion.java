package com.example.taller1aruitectura.Bridge;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion
{
    protected final int PUERTO = 1234; //Puerto para la conexión
    private final int PUERTO2 = 1235;
    private final int PUERTO3 = 1236;
    protected final String HOST = "localhost"; //Host para la conexión
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente

    protected ServerSocket ss1; //Socket del servidor operación
    protected Socket cs1; //Socket del servidor a so1
    protected ServerSocket ss2; //Socket del servidor operación
    protected Socket cs2; //Socket del servidor a so1

    //protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conexion(String tipo) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            cs = new Socket(); //Socket para el cliente
        } else if(tipo.equalsIgnoreCase("servidorop1")){
            ss1= new ServerSocket(PUERTO2);
            cs1 = new Socket();
        } else if(tipo.equalsIgnoreCase("servidorop2")){
            ss2= new ServerSocket(PUERTO3);
            cs2 = new Socket();
        }
    }
}
