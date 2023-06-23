import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Building {
    final int numOfElevators;
    private ArrayList<Thread> elevators = new ArrayList<>();
    GUI gui;
    HashMap<Integer, Elevator> elevatorMap = new HashMap<>();
    public Building(int numOfElevators,GUI gui) {
        this.gui = gui;
        this.numOfElevators = numOfElevators;
        for (int i = 0; i < numOfElevators; i++) {
            Elevator elevator = new Elevator(0, this, i);
            elevatorMap.put(i,elevator);
            Thread thread = new Thread(elevator);
            elevators.add(thread);
            thread.start();
        }
    }

    public void handleExternalRequest(int floor) {
        int minTime = 16;
        int minElevatorIndex = 0;
        int direction = 0;
        for(Map.Entry<Integer,Elevator> entry: elevatorMap.entrySet()){
            if (floor - entry.getValue().currentFloor >= 0){
                if (minTime > floor - entry.getValue().currentFloor && entry.getValue().direction == 1){
                    minElevatorIndex = entry.getKey();
                    minTime = floor - entry.getValue().currentFloor;
                    direction = 1;
                }else if (minTime == floor - entry.getValue().currentFloor && entry.getValue().direction == 1){
                    minElevatorIndex = entry.getKey();
                    minTime = floor - entry.getValue().currentFloor;
                    direction = 1;
                }else if (minTime >= ((entry.getValue().currentFloor - entry.getValue().minF) + (floor - entry.getValue().minF)) && entry.getValue().direction == -1){
                    minElevatorIndex = entry.getKey();
                    minTime = (entry.getValue().currentFloor - entry.getValue().minF) + (floor - entry.getValue().minF);
                    direction = 1;
                }
            }
            else if (entry.getValue().currentFloor - floor >= 0) {
                if (minTime > entry.getValue().currentFloor - floor && entry.getValue().direction == -1){
                    minElevatorIndex = entry.getKey();
                    minTime = entry.getValue().currentFloor - floor;
                    direction = -1;
                }else if (minTime == entry.getValue().currentFloor - floor && entry.getValue().direction == -1){
                    minElevatorIndex = entry.getKey();
                    minTime = entry.getValue().currentFloor - floor;
                    direction = -1;
                }
                else if (minTime > (entry.getValue().maxF - entry.getValue().currentFloor) + (entry.getValue().maxF - floor) && entry.getValue().direction == 1){
                    minElevatorIndex = entry.getKey();
                    minTime = (entry.getValue().maxF - entry.getValue().currentFloor) + (entry.getValue().maxF - floor);
                    direction = -1;
                }
            }
        }
        elevatorMap.get(minElevatorIndex).addRequest(floor,direction);
    }
    public void handleInternalRequest(int floor, int elevatorIndex) {

        if (elevatorMap.get(elevatorIndex).currentFloor > floor) elevatorMap.get(elevatorIndex).addRequest(floor, -1);
        else if (elevatorMap.get(elevatorIndex).currentFloor < floor) elevatorMap.get(elevatorIndex).addRequest(floor, 1);
        else if (elevatorMap.get(elevatorIndex).currentFloor == floor && elevatorMap.get(elevatorIndex).direction == 1)
            elevatorMap.get(elevatorIndex).addRequest(floor, 1);
        else if (elevatorMap.get(elevatorIndex).currentFloor == floor && elevatorMap.get(elevatorIndex).direction == -1)
            elevatorMap.get(elevatorIndex).addRequest(floor, -1);
    }
    public void showFloor(int currentFloor, boolean stop, int num) {
        gui.showFloor(currentFloor, stop, num);
    }
}