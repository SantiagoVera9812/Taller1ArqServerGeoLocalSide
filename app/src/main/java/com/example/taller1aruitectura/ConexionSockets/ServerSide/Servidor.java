package com.example.taller1aruitectura.ConexionSockets.ServerSide;

import com.example.taller1aruitectura.Bridge.Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servidor extends Conexion {

    public Servidor() throws IOException {
        super("servidor");
    }

    public void startServer() throws IOException {
        System.out.println("Servidor iniciado. Esperando conexiones...");

        // aceptar continuamente la conexion de un cliente
        while (true) {
            // aceptar conexion
            Socket clientSocket = ss.accept();
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

            // hilo para cada cliente
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            out.println("Petición recibida y aceptada");

            String mensajeCliente;
            StringBuilder datos = new StringBuilder();

            // Read data from the client
            while ((mensajeCliente = entrada.readLine()) != null) {
                if (mensajeCliente.equals("FIN")) {
                    break;
                }
                datos.append(mensajeCliente);
            }

            System.out.println("El mensaje del cliente: " + datos.toString());

            // mandar data a el cliente
            out.println(datos.toString());

            System.out.println("Fin de la conexión con el cliente: " + clientSocket.getInetAddress());
        } catch (IOException e) {
            System.out.println("Error al manejar el cliente: " + e.getMessage());
        } finally {
            try {
                clientSocket.close(); // cerrar el socket del cliente
            } catch (IOException e) {
                System.out.println("Error al cerrar el socket del cliente: " + e.getMessage());
            }
        }
    }

    public void closeServer() throws IOException {
        ss.close();
        System.out.println("Servidor cerrado.");
    }
}
