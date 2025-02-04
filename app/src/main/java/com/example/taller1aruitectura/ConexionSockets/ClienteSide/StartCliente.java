package com.example.taller1aruitectura.ConexionSockets;

import com.example.taller1aruitectura.Sensor.SensorData;

import java.io.IOException;

public class StartCliente {

    private String tipo;
    private SensorData valor;

    public StartCliente(String tipo, SensorData valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public SensorData getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public static void star(StartCliente startCliente) throws IOException
    {
        Cliente cli = new Cliente(startCliente.getTipo(), startCliente.getValor()); //Se crea el cliente

        System.out.println("Iniciando cliente\n");
        cli.startClient(); //Se inicia el cliente
    }
}
