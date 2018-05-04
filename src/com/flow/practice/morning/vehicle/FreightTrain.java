package com.flow.practice.morning.vehicle;

public class FreightTrain extends Train{
    private String cargo;
    private int cargoQty;

    // Constructor
    public FreightTrain(String departure, String destination, int distanceKM, int avgSpeedKMpH, String cargo, int cargoQty) {
        super(departure, destination, distanceKM, avgSpeedKMpH);
        this.cargo = cargo;
        this.cargoQty = cargoQty;
    }

    // Getters and setters

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCargoQty() {
        return cargoQty;
    }

    public void setCargoQty(int cargoQty) {
        this.cargoQty = cargoQty;
    }

    @Override
    public String toString() {
        return "Freight train: " + cargo + " (" + cargoQty + " t), "
                + super.toString();
    }
}
