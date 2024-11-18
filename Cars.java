//Mussab Ahmed Khan (27140), OOP Assignment # 01
import java.util.ArrayList;

public class Cars {
    static final ArrayList<String> carNames = new ArrayList<>();
    static final ArrayList<String> carColors = new ArrayList<>();
    static final ArrayList<Double> carPrices = new ArrayList<>();
    
    private static double total_amount;
    
    public static void addAmount(double amount) {
        total_amount += amount;
    }
    
    public static double returnAmount() {
        return total_amount;
    }
    
    String carName;
    String carColor;

    void display() {
        System.out.println("You have successfully bought a car!");
        System.out.println("The Car Name is: " + carName);
        System.out.println("The Car Color is: " + carColor);
    }

    public static void showItems() {
        System.out.println("\n");
        System.out.println("Available Cars:");
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " - " + carColors.get(i) + " - $" + carPrices.get(i));
        }
    }

    public static int getTotalCars() {
        return carNames.size();
    }

    public Cars(String carName, String carColor) {
        this.carName = carName;
        this.carColor = carColor;
    }

     static {
        total_amount = 60000;
        carNames.add("Nissan");
        carNames.add("Bugatti");
        carNames.add("Ferrari");
        carNames.add("Toyota");

        carColors.add("Red");
        carColors.add("Blue");
        carColors.add("Yellow");
        carColors.add("White");

        carPrices.add(48000.0);
        carPrices.add(50000.0);
        carPrices.add(60000.0);
        carPrices.add(30000.0);
    }
}
