import java.util.Scanner;

            // Mauricio Ferrato
            // Quaterback Passer Rating for the NFL
public class QBRating {
	
		public static void main(String[] args) {
			
			java.util.Scanner input = new Scanner(System.in);
			
			// Number of passing attempts
			System.out.print("Passes Attempted? ");
			double ATT = input.nextDouble();

			// Number of completed passes
			System.out.print("Passes Completed? ");
			double COMP = input.nextDouble();

			// Passing yards
			System.out.print("Total Passing Yards? ");
			double YDS = input.nextDouble();

			// Touchdown passes
			System.out.print("Number of Touchdown Passes? ");
			double TD = input.nextDouble();
			
			// Interceptions
			System.out.print("Total Interceptions? ");
			double INT = input.nextDouble();
			
			input.close();
			
			double calculation = PasserRatingFunction(ATT, COMP, YDS, TD, INT);

			// Result
			System.out.printf("Passer Rating (NFL): " + "%.1f", calculation);
		}
		
		//Range of QBRating Equations max(0, min(x, 2.375))
		public static double mm(double x){
			
			if (x < 0){
			  // if the x value is less than 0 then return 0
				return 0;
			} else if (x > 2.375){
				  // if the x value is more than 2.375 then return 2.375
				return 2.375;
			} else {
				  // otherwise return x
				return x;
			}
		}
		
		// Method that calculates the Passer Rating
		public static double PasserRatingFunction(double ATT, double COMP, double YDS, double TD, double INT){
			
			// Variables
			double a = ((COMP/ATT) - .3) * 5;
			double b = ((YDS/ATT) - 3) * .25;
			double c = (TD/ATT) * 20;
			double d = 2.375 - ((INT/ATT) * 25);
			
			//Passer Rating formula
			double PasserRating = ((mm(a)+mm(b)+mm(c)+mm(d)) / 6) * 100;
			return PasserRating; 
		}
}