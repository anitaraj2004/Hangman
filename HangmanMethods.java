package Arrays;

import TurtleGraphics.KeyboardReader;

public class HangmanMethods 
{
	public void HangmanGame(String word)
	{	
		KeyboardReader reader = new KeyboardReader();
		
		char[] answer = word.toCharArray();
		int length=answer.length;
		
		char[] display = new char [length];
		char[] previousguesses = new char [26];
		char correct='f', guess;
		String wordguess;
		
		int index=0, counter=0, letterGuess=0, lettersCorrect=0, repeat=0, guessIndex=0, drawCounter=0;
		
		System.out.print("Word is: ");
		
		// print out all initial dashes for length of word
		for(int i=1; i<=length; i++)
		{
			display[index]='-';
			System.out.print(display[index]);
			index++;
		}
		
		System.out.println("");
		
		// use boolean such that if answer continues to be false, loop
		while(correct=='f')
		{
			System.out.println("Your letter ($ to guess the word)? ");
			guess=reader.readChar();
			counter++;
			
			// if user wants to guess the whole word
			if(guess=='$')
			{
				System.out.print("Your guess? ");
				wordguess=reader.readLine();
				
				// user enters entire word correctly
				if(wordguess.equals(word))
				{
					System.out.println("Correct! You took "+counter+" tries.");
					correct='t';
				}
				
				// user guesses entire word wrong, continues guessing letters
				else
				{
					System.out.println("Sorry, that's the wrong word.");
					drawCounter++;
					Draw(drawCounter);
					
				}
			}
			
			// if user wants to guess a single letter
			else
			{
				// check to see if the guess matches a previous guess the user had
				index=0;
				for(int x=1; x<=previousguesses.length; x++)
				{
					if(previousguesses[index]==guess)
					{
						repeat++;
					}
					
					index++;
				}
				
				// check to see if guess matches a letter in the answer word
				index=0;
				for(int j=1; j<=length; j++)
				{
					if(answer[index]==guess)
					{
						display[index]=guess;
						letterGuess++;
					}
					
					index++;
				}
				
				// if guess doesn't match a letter in the word
				if(letterGuess==0)
				{
					// and the user hasn't guessed this letter before
					if(repeat==0)
					{
						// store new guess in array of previous guesses
						previousguesses[guessIndex]=guess;
						guessIndex++;
						
						System.out.print("Sorry, there are no "+guess+"'s.");
						System.out.println("");
						
						drawCounter++;
						Draw(drawCounter);
					}
					// or the user has guessed this letter before
					else if(repeat!=0)
					{
						System.out.println("Sorry, you guessed "+guess+" already. Try again.");
						repeat=0;
						
						drawCounter++;
						Draw(drawCounter);
					}
					
					repeat=0;
				}
				
				// if guess does match a letter in the word
				else if(letterGuess!=0)
				{
					// and the user hasn't guessed this letter before
					if(repeat==0)
					{
						// store new guess in array of previous guesses
						previousguesses[guessIndex]=guess;
						guessIndex++;
						letterGuess=0;
						
						System.out.print("Word is: ");
						
						// display the letters that have been guessed of the word so far
						index=0;
						for(int i=1; i<=length; i++)
						{
							System.out.print(display[index]);
							index++;
						}
						
						letterGuess=0;
						
						System.out.println("");
						
						// check how much of the display matches the answer (how much the user has guessed correctly)
						for(index=0; index<=(length-1); index++)
						{	
							if(display[index]==answer[index])
							{
								lettersCorrect++;
							}
						}
						
						// user guessed whole word if every letter has been guessed
						if(lettersCorrect==length)
						{
							System.out.println("Correct! You took "+counter+" tries.");
							correct='t';
						}
						
						lettersCorrect=0;
						
						Draw(drawCounter);
					}
					// or the user has guessed this letter before
					if(repeat!=0)
					{
						System.out.println("Sorry, you guessed "+guess+" already. Try again.");
						repeat=0;
						letterGuess=0;
						
						drawCounter++;
						Draw(drawCounter);
					}
				}
			}
			
			// when the image reaches 6 parts, the user lost the game
			if(drawCounter==6)
			{
				System.out.println("You lost! You guessed "+counter+" times. The answer was "+word+".");
				break;
			}
		}
	}
	
	public void Draw(int drawCounter)
	{
		if(drawCounter==0)
		{
			System.out.println(" |");
		}
		if(drawCounter==1)
		{
			System.out.println(" |");
			System.out.println(" o");
		}
		else if(drawCounter==2)
		{
			System.out.println(" |");
			System.out.println(" o");
			System.out.print("/");
			System.out.println("");
		}
		else if(drawCounter==3)
		{
			System.out.println(" |");
			System.out.println(" o");
			System.out.print("/");
			System.out.print("|");
			System.out.println("");
		}
		else if(drawCounter==4)
		{
			System.out.println(" |");
			System.out.println(" o");
			System.out.print("/");
			System.out.print("|");
			System.out.print("\\");
			System.out.println("");
		}
		else if(drawCounter==5)
		{
			System.out.println(" |");
			System.out.println(" o");
			System.out.print("/");
			System.out.print("|");
			System.out.print("\\");
			System.out.println("");
			System.out.print("/");
			System.out.println("");
		}
		else if(drawCounter==6)
		{
			System.out.println(" |");
			System.out.println(" o");
			System.out.print("/");
			System.out.print("|");
			System.out.print("\\");
			System.out.println("");
			System.out.print("/");
			System.out.print(" \\");
			System.out.println("");
		}
	}
}