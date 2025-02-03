package com.example.taller1aruitectura.Sensor;

import android.util.Log;

import org.zeromq.ZMQ;

public class SensorServ {

    private String tipo;
    private SensorData valor;

    public SensorData getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public SensorServ(TipoSensor tipo, SensorData valor){
        this.valor = valor;
        this.tipo = tipo.name();
    }

    public static void conectarseABroker(SensorServ sensor) {
        Log.i("mandar publisher", "en conectarseABroker");
        try (ZMQ.Context context = ZMQ.context(1);
             ZMQ.Socket publisher = context.socket(ZMQ.PUB)) {

            publisher.connect("tcp://localhost:5555");
            Log.i("mandar publisher", "intentando mandar");

            // Wait for subscribers to connect
            Thread.sleep(500);  // Add a short delay (500ms)

            while (!Thread.currentThread().isInterrupted()) {
                publisher.send(sensor.getTipo() + " " + sensor.getValor());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("error", "catch");
        }
    }
}
