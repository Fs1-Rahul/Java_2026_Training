class Car {
    String model; // default access
}

public class Default_Modifier {
    
    public static void main(String[] args){
        
        Car c = new Car();
        c.model = "Tesla"; // accessible within the same package
        System.out.println(c.model);
    }
}