import java.util.*;
import java.util.concurrent.TimeUnit;

public class Elevator implements Runnable {
    private final int num;
    public int currentFloor;
    public int direction;
    public PriorityQueue<Integer> up;
    public PriorityQueue<Integer> down;
    public int maxF = -1;
    public int minF = 16;
    Building building;
    public Elevator(int startingFloor, Building building, int num) {
        this.num = num;
        this.building = building;
        this.currentFloor = startingFloor;
        direction = 1;
        up = new PriorityQueue<Integer>();
        down = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) return 1;
                else if(o1 > o2) return -1;
                return 1;
            }
        });
    }

    @Override
    public void run(){
        while (true){
            while (up.isEmpty() && down.isEmpty()){
                System.out.printf("");
            }
            direction = setDirection();
            if(direction == 1){
                System.out.println("Moving Up");
                move(up);
                up.clear();
            }
            else if(direction == -1){
                System.out.println("Moving Down");
                move(down);
                down.clear();
            }
        }
    }

    private int setDirection() {
        if (up.isEmpty() && !down.isEmpty()) return -1;
        if (down.isEmpty() && !up.isEmpty()) return  1;
        if (currentFloor == up.peek() && direction == 1) return 1;
        if (currentFloor == down.peek() && direction == -1) return -1;
        if (Math.abs(up.peek() - currentFloor) > Math.abs(down.peek() - currentFloor))  return 1;
        if (Math.abs(up.peek() - currentFloor) < Math.abs(down.peek() - currentFloor)) return -1;
        if (up.size() > down.size()) return 1;
        else return 0;
    }


    public void addRequest(int floor, int dir) {
        if (maxF < floor) maxF = floor;
        if (minF > floor) minF = floor;
        if (dir == 1) up.add(floor);
        else if (dir == -1) down.add(floor);
        else up.add(floor);
    }
    private void move(PriorityQueue<Integer> queue){
        while (!queue.isEmpty()){
            System.out.println("["+ num + "]" + "Floor is: "+ currentFloor);
            if (currentFloor != queue.peek()) currentFloor += direction;
            if (currentFloor == queue.peek()) {
                System.out.println("["+ num + "]" + "Floor is: "+ currentFloor+ " STOP!");
                building.showFloor(currentFloor, true, num);
                queue.poll();
                while (!queue.isEmpty() && currentFloor == queue.peek()){
                    queue.poll();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else building.showFloor(currentFloor, false, num);
            if (queue.isEmpty()) return;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
