package com.example.taller1aruitectura.ConexionSockets.ServerSide;

import java.io.IOException;

public class StartServidor {


    public static void start() throws IOException
    {
        Servidor serv = new Servidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
    }
}
