import java.util.Scanner;

public class main {
//CHECKSTYLE:ON
	private static final int COST = 1000;
    private static final int ALL_INCLUSIVE = 200;
    private static final int ADVENTURE_ACTIVITIES = 150;
    private static final int SPA_WELLNESS = 100;

    public static void main(String[] args) {
//CHECKSTYLE:OFF

    	final Scanner scanner = new Scanner(System.in); //NOPMD
        System.out.println("Enter the destination: ");
        final String destination = scanner.nextLine();
        System.out.println("Enter the number of travelers: ");
        final int travelers = scanner.nextInt();
        System.out.println("Enter the duration of the vacation in days: ");
        final int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Would you like to add the "
        		+ "All-Inclusive Package? (yes/no)");
        final String allInclusive = scanner.nextLine();
        System.out.println("Would you like to add the Adventure "
        		+ "Activities Package? (yes/no)");
        final String adventureActivities = scanner.nextLine();
        System.out.println("Would you like to add the Spa and "
        		+ "Wellness Package? (yes/no)");
        final String spaWellness = scanner.nextLine();
        scanner.close();
        final int cost = calculateCost(destination, travelers, duration, allInclusive,
        		adventureActivities, spaWellness);
        if (cost == -1) {
            System.out.println("Invalid input data");
        } else {
            System.out.println("The total cost of "
            		+ "the vacation package is $" + cost);
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
    public static int calculateCost(final String destination, final int travelers, final int duration,
            final String allInclusive, final String adventureActivities, final String spaWellness) {
		if (travelers > 80) {
			return -1;
		}

		int cost = COST;
		if ("Paris".equals(destination)) {
			cost += 500;
		} else if ("New York City".equals(destination)) {
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

		if ("yes".equalsIgnoreCase(allInclusive)) {
			cost += ALL_INCLUSIVE;
		}

		if ("yes".equalsIgnoreCase(adventureActivities)) {
			cost += ADVENTURE_ACTIVITIES;
		}

		if ("yes".equalsIgnoreCase(spaWellness)) {
			cost += SPA_WELLNESS;
		}

		return cost * travelers;
    }
}