package tst;

/** AlienIdeology
 * When a bunch of players mix together with strange names, you need this.
**/

public class PlayerScore
{
	private int place;
	private int score;
	private String name;

	public PlayerScore(int p, int s, String n)
	{
		place = p;
		score = s;
		name = n;
	}

	public int getPlace()
	{
		return place;
	}

	public void setPlace(int place)
	{
		this.place = place;
	}

	public int getScore()
	{
		return score;
	}

	public String getName()
	{
		return name;
	}
}
