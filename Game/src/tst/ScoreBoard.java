package tst;

/** Allen Liao
 * Gotta have some competitive aspect in the game, shall we?
**/ 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.ArrayList;

public class ScoreBoard
{
	private String path;
	private int maxPlayers;
	private ArrayList<PlayerScore> players;

	/**
	 * Constructor for ScoreBoard.
	 * @param path the file path of ScoreBoard.txt.
	 * @param max Maximum scores to be recorded.
	 **/
	public ScoreBoard(String path, int max)
	{
		this.path = path;
		maxPlayers = max;
		players = getPlayers();
	}

	/**
	 * Read the score board from a text file.
	 * @return the score board.
	 **/
	public String read()
	{
		String board = "";
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = "";

			while((line = reader.readLine()) != null) {
				board += line+"\n";
			}
			reader.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return board;
	}

	/**
	 * Read a line from the score board.
	 * @param num the line to be read.
	 * @return a line in the score board.
	 **/
	public String readLine(int num)
	{
		String line = null;
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			int count = 0;

			while((line = reader.readLine()) != null)
			{
				count++;
				if(num == count)
				{
					break;
				}
			}
			reader.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return line;
	}

	/**
	 * Get a list of PlayerScore.
	 * @return a list of PlayerScore.
	 **/
	public ArrayList<PlayerScore> getPlayers()
	{
		ArrayList<PlayerScore> scores = new ArrayList<>();
		String line = "";
		int count = 1;

		while((line = readLine(count)) != null)
		{
			//System.out.println(line);
			String name = "";
			String[] player = line.split(" ");
			if(line.equals(""))
				break;

			int place = Integer.parseInt(player[0].substring(0,1));
			int score = Integer.parseInt(player[1]);

			for(int j = 2; j < player.length; j++)
			{
				name += j == player.length-1 ? player[j] : player[j]+" ";
			}

			scores.add(new PlayerScore(place, score, name));
			count++;
		}
		return scores;
	}

	/**
	 * Write the modified list of PlayerScores to a score board.
	 * @param players the modified PlayerScores.
	 **/
	public void write(ArrayList<PlayerScore> players)
	{
		try
		{
			PrintWriter out = new PrintWriter(new FileWriter(path));

			//Sort the players
			Collections.sort(players, (PlayerScore ps1, PlayerScore ps2) ->
				ps1.getScore() > ps2.getScore() ? -1 : (ps1.getScore() < ps2.getScore()) ? 1 : ps1.getName().compareTo(ps2.getName()));

			//Take out 11th place and up
			if(players.size() > maxPlayers)
				

			//Write to text file
			for(int i = 0; i < players.size(); i++)
			{
				PlayerScore player = players.get(i);
				player.setPlace(i+1);
				out.println(player.getPlace()+". "+player.getScore()+" "+player.getName());
			}
		  	out.close();
		}
		catch (IOException ex)
		{
		  System.out.println("Invalid score document!");
		  ex.printStackTrace();
		}
		this.players = players;
	}
}
