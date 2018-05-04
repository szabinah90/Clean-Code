package com.flow.practice.morning.vehicle;

public class Train implements Comparable<Train>{
    protected String departure;
    protected String destination;
    protected float distanceKM;
    protected int avgSpeedKMpH;


    // Constructor
    public Train(String departure, String destination, int distanceKM, int avgSpeedKMpH) {
        this.departure = departure;
        this.destination = destination;
        this.distanceKM = distanceKM;
        this.avgSpeedKMpH = avgSpeedKMpH;
    }

    public Train() {

    }

    //Getters and setters
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getDistanceKM() {
        return distanceKM;
    }

    public void setDistanceKM(float distanceKM) {
        this.distanceKM = distanceKM;
    }

    public int getAvgSpeedKMpH() {
        return avgSpeedKMpH;
    }

    public void setAvgSpeedKMpH(int avgSpeedKMpH) {
        this.avgSpeedKMpH = avgSpeedKMpH;
    }

    // Methods
    public float timeToReachDestination() {
        return distanceKM / avgSpeedKMpH;
    }

    @Override
    public int compareTo(Train train) {
        if (timeToReachDestination() == train.timeToReachDestination()) {
            return 0;
        } else if (timeToReachDestination() < train.timeToReachDestination()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return departure + " – " + destination + " (" +
                distanceKM + " km), " + avgSpeedKMpH + " km/h";
    }
}
