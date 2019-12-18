package model;

import java.util.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

/**
* This class manages the highscores for each level, class is a singleton
* 
* @author Nadim Rahman
* 
*/
public class HighscoreManagerSingleton {

	private static HighscoreManagerSingleton SINGLE_INSTANCE = null;
    private ArrayList<Highscore> scores;
    
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    private String fileName = "src/resources/highscores.txt";

    /**
    * Initialises the highscore list
    */
    private HighscoreManagerSingleton() {
    	scores = new ArrayList<Highscore>();
    }

    /**
    * Method makes sure class is only created once
    * 
    */
    public static HighscoreManagerSingleton getInstance() {
    	if(SINGLE_INSTANCE == null) {
    		SINGLE_INSTANCE = new HighscoreManagerSingleton();
    	}
		return SINGLE_INSTANCE;
    }
    
    /**
    * @return an observable list of all the scores
    * @throws FileNotFoundException
    */
    public ObservableList<Highscore> getScores() throws FileNotFoundException {
    	//First load the file and update the collection list
        loadScoreFile();
        //Convert the list into an observable list
        ObservableList<Highscore> observableScores = FXCollections.observableArrayList(scores);

        return observableScores;
    }
    
    /**
     * Checks if the user score is in the top 10 scores
     * @param userScore
     * @return boolean to decide if score in top 10
    */
    public boolean checkTopTen(int userScore) throws FileNotFoundException {
        loadScoreFile();
        IntegerProperty userScoreIntProperty = new SimpleIntegerProperty(userScore);

        // Compares the last score in the file with the new score
        IntegerProperty lastScore = scores.get(scores.size() - 1).getScore() ;
        if(userScoreIntProperty.getValue() > lastScore.getValue()) {
        	return true;
        }
		return false;
    }
    
    /**
     * Returns the top score in the highscore list
     * @return top score
     * @throws FileNotFoundException
     */
    public int getTopScore() throws FileNotFoundException {
        loadScoreFile();
        IntegerProperty topScore = scores.get(0).getScore() ;
        return topScore.getValue();
    }
    
    /**
     * Sorts the scores list using the highscore comparator
    */
    private void sort() {
    	HighscoreComparator comparator = new HighscoreComparator();
        Collections.sort(scores, comparator);
    }
    
    /**
     * Add score to the highscore
     * @param name
     * @param score
     * @throws FileNotFoundException
    */
    public void addScore(String name, int score) throws FileNotFoundException {
        loadScoreFile();
        //Remove the last score and add the new score to the file
        scores.remove(scores.size() - 1 );
        scores.add(new Highscore(name, score));
        sort();
        //Update the file with the new score list
        updateScoreFile();
    }
    
    /**
     * Loads the score file and scans each line
     * @throws FileNotFoundException
    */
    public void loadScoreFile() throws FileNotFoundException {
    	List<List<String>> records = new ArrayList<>();
    	try (Scanner scanner = new Scanner(new File(fileName));) {
    	    while (scanner.hasNextLine()) {
    	        records.add(getRecordFromLine(scanner.nextLine()));
    	    }
    	}
    	convertRecords(records);
    }
    
    /**
     * This method converts a text line from the text file and converts it into a list
     * @param line from highscore file
     * @return a list of string values of that line
     */
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
    
    /**
     * Converts each record into a highscore
     * @param records
    */
    private void convertRecords(List<List<String>> records) {
    	scores.clear();
    	for(List<String> record : records) {
    		String name = record.get(0);
    		int score = Integer.parseInt(record.get(1));
    		Highscore hs = new Highscore(name,score);
    		//add to the scores list
    		scores.add(hs);
    	}
    }
    
    /**
     * Method updates the text file with the new score
    */
    public void updateScoreFile() {
    	FileWriter fileWriter = null;
        
        try {
            fileWriter = new FileWriter(fileName);
              
            //Write a new score object list to the text file
            for (Highscore hs : scores) {
            	
                fileWriter.append(hs.getName().getValue());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(hs.getScore().getValue()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
                          
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
        }
     }        
    
}