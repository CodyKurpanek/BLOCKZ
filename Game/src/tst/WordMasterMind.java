package tst;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class WordMasterMind
{
	private final String path;
	private String word;
	private int score;
	private final int correctScore, partScore;

	/**
	 * Constructor for WordMasterMind.
	 * @param corScore for the correct number's score.
	 * @param parScore for the partial correc number's score.
	 **/
	public WordMasterMind(int corScore, int parScore)
	{
		path = "src/tst/Words.txt";
		correctScore = corScore;
		partScore = parScore;
		selectWord();
	}

	/**
	 * Automatically select a word from the word bank.
	 * @return WordMasterMind for easier chaining.
	 **/
	public WordMasterMind selectWord()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			int random = (int) (Math.random() * 50 + 1), count = 0;
			String line = "";

			while((line = reader.readLine()) != null)
			{
				count++;
				if(random == count)
				{
					word = line;
					break;
				}
			}
			reader.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return this;
	}

	/**
	 * Enter a word into the game machine.
	 * @param guess for the word guessed.
	 * @throws NullPointerException for null guessed words.
	 * @throws IllegalArgumentException for invalid guessed words.
	 * @return StringBuilder for the result String
	 **/
	public StringBuilder entry(StringBuilder guess)
	{
		if(guess == null)
			throw new NullPointerException("Please enter a word!");
		else if(guess.length() != 4)
			throw new IllegalArgumentException("Please enter a four letters word!");
		else if(!Pattern.compile("^[a-zA-Z]+$").matcher(guess).find())
			throw new IllegalArgumentException("Please enter a word that only contains letters!");

		StringBuilder origWord = new StringBuilder(word), origGuess = new StringBuilder(guess);
		StringBuilder changedWord = new StringBuilder(word), result = new StringBuilder();
		int count = 0;

		while(guess.length()!= 0)
		{
			String letter = guess.substring(0,1);
			if(changedWord.toString().contains(letter.toString()))
			{
				if(isExact(origWord, origGuess, count))
					result.append("X");
				else
					result.append("O");

				changedWord.deleteCharAt(changedWord.indexOf(letter));
			}
			guess.deleteCharAt(0);
			count++;
		}
		autoScore(result.toString());
		return result;
	}

	private boolean isExact(StringBuilder origW, StringBuilder origG, int index)
	{
		return origW.substring(index,index+1).equals(origG.substring(index,index+1));
	}

	private void autoScore(String XnOs)
	{
		for(int i = 0; i < XnOs.length(); i++)
		{
			int score = XnOs.substring(i,i+1).equals("X") ? correctScore : (XnOs.substring(i,i+1).equals("O") ? partScore : 0);
			addScore(score);
		}
	}

	public void addScore(int score)
	{
		this.score += score;
	}

	public String getWord()
	{
		return word.toString();
	}

	public int getScore()
	{
		return score;
	}
}
