class Vehicle {
    protected int speed; // protected member
}

class Bike extends Vehicle {
    void setSpeed(int s)
    {
        speed = s; // accessible in subclass
    }

    int getSpeed()
    {
        return speed; // accessible in subclass
    }
}

public class ProtectedModifier {
    public static void main(String[] args){
        
        Bike b = new Bike();
        b.setSpeed(100);
        System.out.println("Access via subclass method: "+ b.getSpeed());

        Vehicle v = new Vehicle();
        System.out.println(v.speed);
    }
}