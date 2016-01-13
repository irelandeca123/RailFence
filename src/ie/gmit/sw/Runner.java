package ie.gmit.sw;

import java.io.IOException;
import java.util.Scanner;

public class Runner
{
	private static String input; 
	private static String file;
	private static String text;
	private static FileReader fileReader = new FileReader(); //create instance of FileReader
			
	public static void main(String[] args)
	{
		QuadGramMap.setMap(); //call setMap method from QuadGramMap class
		Scanner console = new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("1: Cyphertext decryption.");
		System.out.println("2: File decryption. ");
		
		input = console.nextLine(); 
		
		if(input.equals("2")){ 
			 
			try
			{
				System.out.println("Enter File Name (.txt):");
				file = console.nextLine();
				file=fileReader.readFile(file); 
				new CypherBreaker(file); 
			} catch (IOException e)
			{
				System.out.println("Could not find specified file (Dont forget to add .txt)");
			
			}
		}
		
		else if (input.equals("1")){
			System.out.println("Enter text to encrypt:");
			text = console.nextLine();
			new CypherBreaker(text); 
		}
		
		
		else{
			System.out.println("Wrong input!");
			
		}
			
		console.close();
	}
}
