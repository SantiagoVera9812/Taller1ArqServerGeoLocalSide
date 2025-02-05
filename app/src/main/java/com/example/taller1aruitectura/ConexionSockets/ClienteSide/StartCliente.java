package com.example.taller1aruitectura.ConexionSockets.ClienteSide;

import com.example.taller1aruitectura.ConexionSockets.ServerSide.StartServidor;
import com.example.taller1aruitectura.Sensor.SensorData;

import java.io.IOException;

public class StartCliente {

    private String tipo;
    private SensorData valor;

    private Cliente cliente;

    public StartCliente(String tipo, SensorData valor) throws IOException {
        this.tipo = tipo;
        this.valor = valor;
        this.cliente = new Cliente(tipo, valor);
    }

    public SensorData getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public static void star(StartCliente startCliente) throws IOException
    {
        System.out.println("Iniciando cliente\n");
        startCliente.cliente.startClient();

    }

    public void closeClient() {
        cliente.closeClient();
    }
}
