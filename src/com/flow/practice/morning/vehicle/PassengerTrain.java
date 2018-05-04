package com.flow.practice.morning.vehicle;

public class PassengerTrain extends Train{
    private int numberOfStops;

    public PassengerTrain(String departure, String destination, int distanceKM, int avgSpeedKMpH, int numberOfStops) {
        super(departure, destination, distanceKM, avgSpeedKMpH);
        this.numberOfStops = numberOfStops;
    }

    // Getters and setters
    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        if (numberOfStops < 2) {
            System.out.println("There must be at least 2 stops.");
        } else {
            this.numberOfStops = numberOfStops;
        }
    }

    @Override
    public float timeToReachDestination() {
        return super.timeToReachDestination() + (getNumberOfStops() - 2) * 0.1f;
    }

    @Override
    public String toString() {
        return "Passenger train: " + numberOfStops + " stops, " +
                super.toString();
    }
}
