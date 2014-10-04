import java.util.Scanner;


public class Game 
{
	public  static char[] colors = {'R','G','B','Y','O','P'}; 	//set colors
	public static int codeLength = 4; 							//set code length
	public static int numGuesses = 12; 							//set guesses allowed
	
	//Guess and feedback history
	Code[] history = new Code[numGuesses];
	feedback[] history2 = new feedback[numGuesses];
	
	//what mode to run the game in (debug with printed answers or normal)
	boolean mode;
	public Game(boolean m)
	{
		mode = m;
	}
	Scanner reader = new Scanner(System.in);
	
	//run the game
	public void run()
	{
		Code answer = new Code(codeLength, colors);
		
		for(int i=numGuesses;i>0;i--)
		{
			if(this.mode)
			{
				System.out.print("The answer is: "); 		//give answer for debug mode
				answer.print();
				System.out.println("");
			}
			System.out.print("\nYou have "+i+" guess");		//print guesses left
			if(i>1)
			{
				System.out.print("es");
			}
			System.out.print(" left.\nWhat is your next guess?\nType in the characters for your guess and press enter.\nEnter guess: ");	//print prompt
			String g = reader.nextLine();
			Code guess = new Code(g);
			if(g.equals("history")) 		//check if history is requested
			{
				System.out.println();
				i++;
				for(int n = 0;n<numGuesses; n+=1)
				{
					if(history[n]!=null)
					{
						System.out.print("Guess "+(n+1)+": ");
						history[n].print();
						history2[n].print();
						System.out.println();
					}
				}
			}
			else if(!guess.isValid(codeLength, colors))		//check if guess is valid
			{
				System.out.println("");
				guess.print();
				System.out.println(" -> INVALID GUESS\n");
				i++;
				
			}
			else 			//if win
			{
				feedback f;
				f=guess.getFeedback(answer);
				history[numGuesses-i] = guess;
				history2[numGuesses-i] = f;
				guess.print();
				f.print();
				if(f.getBlack() == codeLength)
				{
					System.out.println(" - You win!!\n"); 		//win message
					System.out.print("Are you ready for another game (Y/N): ");
					return;
				}
				System.out.println("");
			}
		}
		System.out.print("Game Over. The answer was: "); 		//game over messages
		answer.print();
		System.out.print(". \nWould you like to play again (Y/N)");
	}
	
	
	public static void main(String args[])
	{
				//intro message
		System.out.print("Welcome to Mastermind.  Here are the rules.\n\n"
				+ "This is a text version of the classic board game Mastermind.\n"
				+"The computer will think of a secret code. The code consists of 4 colored pegs.\n"
				+"The pegs MUST be one of six colors: blue, green, orange, purple, red, or yellow. A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in.   After you make a valid guess the result (feedback) will be displayed. \n"
				+"The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  For each peg in the guess that is the correct color, but is out of position, you get a white peg.  For each peg, which is fully incorrect, you get no feedback. \n\n"
				+"Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n"
				+"When entering guesses you only need to enter the first character of each color as a capital letter.\n\n"
				+"You have "+numGuesses+" guesses to figure out the secret code or you lose the game.  Are you ready to play? (Y/N):");
		

		Scanner reader = new Scanner(System.in);	//read input when asked if ready to play
		String input="";
		while(!input.equals("N"))		//for no
		{
			
			input = reader.nextLine();
			if(input.equals("Y"))		//for yes
			{
				Game g = new Game(false);
				g.run();
			}
			else if(input.equals("debug"))	//for debug mode
			{
				Game g = new Game(true);
				g.run();
			}
			else
			{
				System.out.print("Are you ready to play? (Y/N): ");	//keeps asking if ready to play
			}
		}
				
		
	}

}
