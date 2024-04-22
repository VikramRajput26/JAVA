package javaPractice;

public class commandLineArgs{

	public static void main(String[] args) {
		// Check if any arguments are passed
		if (args.length == 0) {
			System.out.println("No arguments provided.");
		} else {
			System.out.println("Arguments passed:");
			// Loop through each argument and print it
			for (int i = 0; i < args.length; i++) {
				System.out.println("Argument " + (i+1) + ": " + args[i]);
			}
		}
	}
}
