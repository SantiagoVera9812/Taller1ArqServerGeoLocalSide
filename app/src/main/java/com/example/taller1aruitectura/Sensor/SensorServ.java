package com.example.taller1aruitectura.Sensor;

import com.example.taller1aruitectura.ConexionSockets.ClienteSide.StartCliente;

import java.io.IOException;

public class SensorServ {

    private String tipo;
    private SensorData valor;

    private StartCliente startCliente;

    public SensorData getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public SensorServ(TipoSensor tipo, SensorData valor) throws IOException {
        this.valor = valor;
        this.tipo = tipo.name();
        this.startCliente = new StartCliente(this.tipo, this.valor);
    }

    public static void envioCliente(SensorServ sensorServ) throws IOException {
        StartCliente.star(sensorServ.startCliente);

    }

    public void closeClient() {
        startCliente.closeClient();
    }

}
