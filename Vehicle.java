
/**
 *
 * @author taylorcroix
 */


public class Vehicle {
    private int currentSpeed;
    private int currentDirection;
    private String ownerName;
    private int carID;
    private static int ncarID = 0;
    public static final String TURN_LEFT = "Turn Left";
    public static final String TURN_RIGHT = "Turn Right";
    public Vehicle(){
        this.carID = ncarID++;
    }
    public Vehicle(String on){
        this.ownerName = on;
        this.carID = ncarID++;
    }
    public int getSpeed() {
        return currentSpeed;
    }
    public int getDirection() {
        return currentDirection;
    }
    public String getName() {
        return ownerName;
    }
    public int getID() {
        return carID;
    }
    public void setSpeed(int newSpeed){
        this.currentSpeed = newSpeed;
    }
    public void setDirection(int newDirection){
        this.currentDirection = newDirection;
    }
    public void setName(String newName){
        this.ownerName = newName;
    }
    public static int highest(){
        return ncarID-1;
    }
    public String toString(){
        return ownerName.toString()+"-"+currentSpeed+" mph-"+currentDirection+" degrees-"+carID;
    }
    public void changeSpeed(int newSpeed){
        this.currentSpeed = newSpeed;
    }
    public void stop(){
        this.currentSpeed = 0;
    }
    public void turn(int degree){
        this.currentDirection += degree;
    }
    public void turn(String der){
        if(der.compareTo(TURN_RIGHT)==0){
            this.currentDirection += 90;
        }
        else if(der.compareTo(TURN_LEFT)==0){
            this.currentDirection -= 90;
        }
        else {
            System.out.println("Error");
        }
    }
}
class VehicleTestP4{
    Vehicle one = new Vehicle();
    Vehicle two = new Vehicle();
    Vehicle three = new Vehicle();
    Vehicle four = new Vehicle();
    Vehicle five = new Vehicle();
    public void main(String args[]) {
        one.setSpeed(1);
        one.setDirection(1);
        one.setName("One");
        two.setSpeed(2);
        two.setDirection(2);
        two.setName("Two");
        three.setSpeed(3);
        three.setDirection(3);
        three.setName("Three");
        four.setSpeed(4);
        four.setDirection(4);
        four.setName("Four");
        five.setSpeed(5);
        five.setDirection(5);
        five.setName("Five");
        System.out.printf("Vehicle 1: Speed = ", one.getSpeed(), ", Direction = ", one.getDirection(), ", Name = ", one.getName(), ", ID = ", one.getID(), "\n");
        System.out.printf("Vehicle 2: Speed = ", two.getSpeed(), ", Direction = ", two.getDirection(), ", Name = ", two.getName(), ", ID = ", two.getID(), "\n");
        System.out.printf("Vehicle 3: Speed = ", three.getSpeed(), ", Direction = ", three.getDirection(), ", Name = ", three.getName(), ", ID = ", three.getID(), "\n");
        System.out.printf("Vehicle 4: Speed = ", four.getSpeed(), ", Direction = ", four.getDirection(), ", Name = ", four.getName(), ", ID = ", four.getID(), "\n");
        System.out.printf("Vehicle 5: Speed = ", five.getSpeed(), ", Direction = ", five.getDirection(), ", Name = ", five.getName(), ", ID = ", five.getID(), "\n");
    }
}
    class VehicleTest{
    Vehicle one = new Vehicle("One");
    Vehicle two = new Vehicle("Two");
    Vehicle three = new Vehicle("Three");
    Vehicle four = new Vehicle("Four");
    Vehicle five = new Vehicle("Five");
    public void main(String args[]) {
        one.setSpeed(1);
        one.setDirection(1);
        two.setSpeed(2);
        two.setDirection(2);
        three.setSpeed(3);
        three.setDirection(3);
        four.setSpeed(4);
        four.setDirection(4);
        five.setSpeed(5);
        five.setDirection(5);
        System.out.printf("Vehicle 1: Speed = ", one.getSpeed(), ", Direction = ", one.getDirection(), ", Name = ", one.getName(), ", ID = ", one.getID(), "\n");
        System.out.printf("Vehicle 2: Speed = ", two.getSpeed(), ", Direction = ", two.getDirection(), ", Name = ", two.getName(), ", ID = ", two.getID(), "\n");
        System.out.printf("Vehicle 3: Speed = ", three.getSpeed(), ", Direction = ", three.getDirection(), ", Name = ", three.getName(), ", ID = ", three.getID(), "\n");
        System.out.printf("Vehicle 4: Speed = ", four.getSpeed(), ", Direction = ", four.getDirection(), ", Name = ", four.getName(), ", ID = ", four.getID(), "\n");
        System.out.printf("Vehicle 5: Speed = ", five.getSpeed(), ", Direction = ", five.getDirection(), ", Name = ", five.getName(), ", ID = ", five.getID(), "\n");
        System.out.printf("Highest Identification Number: ", Vehicle.highest());
        System.out.printf("Vehicle 1 information: ", one.toString());
        one.changeSpeed(20);
        System.out.printf("Vehicle 1: Changed Speed = ", one.getSpeed());
        one.stop();
        System.out.printf("Vehicle 1 Stopped. Speed now = ", one.getSpeed());
        System.out.printf("Vehicle 5 Current Direction = ", five.getDirection());
        five.turn(60);
        System.out.printf("After turning 60 degrees, Vehicle 5 Current Direction = ", five.getDirection());
        five.turn("Turn Right");
        System.out.printf("After turning right, Vehicle 5 Current Direction = ", five.getDirection());
        five.turn("Turn Left");
        System.out.printf("After turning left, Vehicle 5 Current Direction = ", five.getDirection());
        
        
    }
}
