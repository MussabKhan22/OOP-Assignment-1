import java.util.Scanner;

/**
 *
 * @author OOP Theory Assignment 1, Mussab Ahmed Khan (27140)
 */
public class Main {
        public static void main(String[] args) {
        int carIndex;
        double balance = 100000;
        Cars[] myCars = new Cars[4]; 
        int operation = 100;
        int i = 0; 
        String input;
        String[] myInputArray;
        Scanner sc = new Scanner(System.in);

        while (operation != 0) {
            System.out.println("\n");
            System.out.print("Enter your Operation\n1 -> Show Vehicle Details \n2 -> Total Number of Cars \n3 -> Buy a Vehicle \n4 -> Show Total Money\n0 -> Exit: ");
            operation = sc.nextInt(); // Read the operation

            sc.nextLine(); 

            if (i == 4) {
                System.out.println("Sorry, We are sold out! Thank you for buying!");
                break;
            }

            switch (operation) {
                case 1 -> Cars.showItems();
                case 2 -> System.out.println("\nTotal number of Cars is: " + Cars.getTotalCars());
                case 3 -> {
                    System.out.print("Enter the Name and Color of the Car (separate by ', '): ");
                    input = sc.nextLine();  
                    myInputArray = input.split(", ");

                    if (myInputArray.length == 2) {
                        // Check if car exists in the available list
                        carIndex = Cars.carNames.indexOf(myInputArray[0]);
                        if (carIndex != -1) {
                            // Car exists, process the purchase
                            if (Cars.carNames.get(carIndex) != null) {
                                if(balance > Cars.carPrices.get(carIndex)) {
                                myCars[i] = new Cars(myInputArray[0], myInputArray[1]);
                                balance -= Cars.carPrices.get(carIndex);  // Deduct the price
                                myCars[i].display();
                                Cars.addAmount(Cars.carPrices.get(carIndex));
                                System.out.println("The price of "+Cars.carPrices.get(carIndex)+" has been deducted from your total balance and your new balance is: "+balance);

                                // Remove the car from the available lists
                                Cars.carNames.remove(carIndex);
                                Cars.carColors.remove(carIndex);
                                Cars.carPrices.remove(carIndex);
                                i++; // Increment the index after successfully buying a car
                                } else {
                                    System.out.println("Sorry, you have insufficient funds");
                                }
                            } else {
                                System.out.println("Sorry, this car has already been sold.");
                            }
                        } else {
                            System.out.println("Invalid car name.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter both name and color, separated by a comma.");
                    }
                }
                case 4 -> {
                    System.out.println("\nThe Total Money in the Storage is: "+Cars.returnAmount());
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid operation. Please choose a valid option.");
            }
        }
        sc.close();
    }

    
}
