package com.flow.practice.morning;

import com.flow.practice.morning.vehicle.*;
import java.util.*;

public class RailroadMain {

    private String[] arguments;
    private ArrayList<Train> trains = new ArrayList<>();
    private int iterator = 0;

    private int createFreightTrain() {
        HashMap<String, Object> options = getFreightTrainOptions();
        Train freightTrain = new FreightTrain((String) options.get("start"), (String) options.get("destination"), (int) options.get("distance"),
                (int) options.get("speed"), (String) options.get("product"), (int) options.get("weight"));
        trains.add(freightTrain);
        iterator += 7;
        return iterator;
    }

    private int createPassengerTrain() {
        HashMap<String, Object> options = getPassengerTrainOptions();
        Train passengerTrain = new PassengerTrain((String) options.get("start"), (String) options.get("destination"), (int) options.get("distance"),
                (int) options.get("speed"), (int) options.get("numberOfStops"));
        trains.add(passengerTrain);
        iterator += 6;
        return iterator;
    }

    private boolean isFreight() {
        return arguments[iterator].equals("freight");
    }

    private boolean isPassenger() {
        return arguments[iterator].equals("passenger");
    }

    private void setArguments(String[] array) {
        arguments = array;
    }

    private HashMap<String, Object> getFreightTrainOptions() {
        HashMap<String, Object> freightMap = new HashMap<>();
        freightMap.put("start", arguments[iterator + 1]);
        freightMap.put("destination", arguments[iterator + 2]);
        freightMap.put("distance", Integer.parseInt(arguments[iterator + 3]));
        freightMap.put("speed", Integer.parseInt(arguments[iterator + 4]));
        freightMap.put("product", arguments[iterator + 5]);
        freightMap.put("weight", Integer.parseInt(arguments[iterator + 6]));

        return  freightMap;
    }

    private HashMap<String, Object> getPassengerTrainOptions() {
        HashMap<String, Object> passengerMap = new HashMap<>();
        passengerMap.put("start", arguments[iterator + 1]);
        passengerMap.put("destination", arguments[iterator + 2]);
        passengerMap.put("distance", Integer.parseInt(arguments[iterator + 3]));
        passengerMap.put("speed", Integer.parseInt(arguments[iterator + 4]));
        passengerMap.put("numberOfStops", Integer.parseInt(arguments[iterator + 5]));

        return passengerMap;
    }

    private void iterateArguments() {
        while (iterator < arguments.length) {
            createTrain();
        }
    }

    private void createTrain() {
        if (isFreight()) {
            iterator = createFreightTrain();
        }
        else if (isPassenger()) {
            iterator = createPassengerTrain();
        }
    }

    public static void main(String[] args) {

        RailroadMain railRoad = new RailroadMain();
        railRoad.setArguments(args);
        railRoad.iterateArguments();

        Collections.sort(railRoad.trains);
        System.out.println("Fastest traint:\n" + railRoad.trains.get(railRoad.trains.size()-1) + "\nTime:\n" + railRoad.trains.get(railRoad.trains.size()-1).timeToReachDestination() + " h");
    }
}
