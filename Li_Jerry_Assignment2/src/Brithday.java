/**
 * @author jerry
 * @version 1
 * class Birthday is a Driver class
 * The Birthday class will interact with the user for user input
 * and money transactions.
 * 
 */
import java.util.Random;
import javax.swing.JOptionPane;

public class Brithday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		boolean repeat = true;
		
		//create count variable to calculate the final cost of all gifts
		double count = 0;
		
		
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for young children.");
		
		//This do-while loop is for repeating the whole process if the user wants to buy another gift
		do {
		
		//declare name and age for user to input
			
		String name = JOptionPane.showInputDialog("What is your name? ");
		String age = JOptionPane.showInputDialog("What is your age? ");
		//convert string to integer
		int Age = Integer.parseInt(age);
		
		String choice = JOptionPane.showInputDialog("Choose a toy: " + 
		"a plushie, blocks, or a book?");
		
		//create a new object
		Toy toy = new Toy(choice, Age);
		
		boolean t = toy.ageOK();
		//The do-while loop is for repeating the input if the age and gift do not match
		do {
		if(t == false) {
		
			String input = JOptionPane.showInputDialog("The toy is not age appropriate. Enter yes to cancel, and no to continue");
			
			//if the user types yes, repeat the input process, else cotinue by ignoring age appropriation.
			if(input.equalsIgnoreCase("yes")) {
				name = JOptionPane.showInputDialog("What is your name? ");
				age = JOptionPane.showInputDialog("What is your age? ");
				Age = Integer.parseInt(age);
				choice = JOptionPane.showInputDialog("Choose a toy: " + 
						"a plushie, blocks, or a book?");
				toy = new Toy(choice, Age);
				 t = toy.ageOK();
			}
			else {
				t = true;
				toy = new Toy(choice, Age);
			}
			
		}
		}while(t == false);
		
		String extra1 = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
		String extra2 = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
		
		toy.addCard(extra1);
		toy.addBalloon(extra2);
		
		String ask = JOptionPane.showInputDialog("Do you want another toy? Yes or No");
		if(ask.equalsIgnoreCase("yes")) {
			repeat = true;
			
		}
		else if (ask.equalsIgnoreCase("no")){
			repeat = false;
			
		}
		System.out.println("The gift for " + name + " " + Age + " years old is " + choice +" $ " + toy.getCost());
		
		count +=toy.getCost();
		
		}while(repeat);
		
		//keep the random number range between 5 digits
		int randomNumber = rand.nextInt(100000)+9999;
		
		System.out.println("The total cost of your order is $" + count + ". Order number is " + randomNumber);
		System.out.println("Programmer: Jerry Li");
		
		
	
		
		System.exit(0);
	}

}
