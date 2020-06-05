package tst;

import java.util.ArrayList;
import java.util.Scanner;

public class Game1{
	private TestFrame1 window;
	
	public Game1() {
		window = new TestFrame1(this);
		
		WordMasterMind mind = new WordMasterMind(2,1);
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter you name:");
		String name = in.nextLine();
		System.out.println("\nGame loading...");

		ScoreBoard board = new ScoreBoard("src/tst/ScoreBoard.txt", 10);
		ArrayList<PlayerScore> players = board.getPlayers();

		for(int i = 0; i < 10; i++)
		{
			try
			{
				System.out.println("Guess#"+(i+1));
				String guess = in.nextLine();
				String result = mind.entry(new StringBuilder(guess)).toString();

				if(result.equals("XXXX"))
				{
					mind.addScore(100-((i+1)*10)+10);
					break;
				}

				System.out.println(result + " Score: "+mind.getScore());
			}
			catch (Exception ex)
			{
				System.out.println(ex.getMessage());
				i--;
				continue;
			}
		}

		String word = mind.getWord();
		int score = mind.getScore();
		System.out.println("The correct word was: "+mind.getWord()+" Final Score: "+mind.getScore()+"\n");

		players.add(new PlayerScore(1, score, name));

		System.out.println(name+", would you like to see the top ten list?");

		if(in.nextLine().toLowerCase().contains("y") || in.nextLine().toLowerCase().contains("sure"))
			System.out.println(board.read());
	}

	public void play() {		
		window.gameScreen();
	}
	
	public void stop() {
		window.startScreen();
	}

}
