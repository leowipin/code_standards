import java.util.Scanner;

public class main {
//CHECKSTYLE:ON
	private static final int COST = 1000;
    public static void main(String[] args) {
//CHECKSTYLE:OFF

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the destination: ");
        String destination = scanner.nextLine();
        System.out.println("Enter the number of travelers: ");
        int travelers = scanner.nextInt();
        System.out.println("Enter the duration of the vacation in days: ");
        int duration = scanner.nextInt();
        scanner.close();

        int cost = calculateCost(destination, travelers, duration);
        if (cost == -1) {
            System.out.println("Invalid input data");
        } else {
            System.out.println("The total cost of the vacation "
            + "package is $" + cost);
        }
    }
    /**
     * Calculates the cost of a vacation package based on the destination,
     * the number of travelers, and the duration of the vacation in days.
     *
     * @param destination the destination of the vacation
     * @param travelers the number of travelers
     * @param duration the duration of the vacation in days
     * @return the total cost of the vacation package
     */
    public static int calculateCost
    (String destination, int travelers, int duration) {

    	if (travelers > 80) {
            return -1;
        }

        int cost = COST;
        if (destination.equals("Paris")) {
            cost += 500;
        } else if (destination.equals("New York City")) {
            cost += 600;
        }

        if (travelers > 4 && travelers < 10) {
            cost -= cost * 0.1;
        } else if (travelers >= 10) {
            cost -= cost * 0.2;
        }

        if (duration < 7) {
            cost += 200;
        } else if (duration > 30 || travelers == 2) {
            cost -= 200;
        }

        return cost * travelers;
    }
}
