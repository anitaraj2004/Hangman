package Arrays;

import TurtleGraphics.KeyboardReader;

public class HangmanMain 
{

	public static void main(String[] args) 
	{
		KeyboardReader reader = new KeyboardReader();
		HangmanMethods object = new HangmanMethods();
		
		String word;
		
		System.out.print("Enter word to be guessed: ");
		word=reader.readLine();
		
		// clear screen
		for(int i=0; i<=40; i++)
		{
			System.out.println("");
		}
		
		object.HangmanGame(word);
	}

}