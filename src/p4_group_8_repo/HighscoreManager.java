package p4_group_8_repo;

import java.util.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class HighscoreManager {
    // An arraylist of the type "score" we will use to work with the scores inside the class
    private ArrayList<Highscore> scores;
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private String fileName = "src/resources/highscores.txt";



    public HighscoreManager() {
        //initialising the scores-arraylist
        scores = new ArrayList<Highscore>();
    }
    
    public ObservableList<Highscore> getScores() throws FileNotFoundException {
        loadScoreFile();
        ObservableList<Highscore> observableScores = FXCollections.observableArrayList(scores);
        return observableScores;
    }
    
    public boolean checkTopTen(int userScore) throws FileNotFoundException {
        loadScoreFile();
        IntegerProperty userScoreIntProperty = new SimpleIntegerProperty(userScore);

        IntegerProperty lastScore = scores.get(scores.size() - 1).getScore() ;
        if(userScoreIntProperty.getValue() > lastScore.getValue()) {
        	return true;
        }
		return false;
    }
    
    private void sort() {
    	HighscoreComparator comparator = new HighscoreComparator();
        Collections.sort(scores, comparator);
    }
    
    public void addScore(String name, int score) throws FileNotFoundException {
        loadScoreFile();
        scores.remove(scores.size() - 1 );
        scores.add(new Highscore(name, score));
        sort();
        updateScoreFile();
    }
    
    public void loadScoreFile() throws FileNotFoundException {
    	
    	List<List<String>> records = new ArrayList<>();
    	try (Scanner scanner = new Scanner(new File(fileName));) {
    	    while (scanner.hasNextLine()) {
    	        records.add(getRecordFromLine(scanner.nextLine()));
    	    }
    	}
    	convertRecords(records);
    }
    
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
    
    private void convertRecords(List<List<String>> records) {
    	for(List<String> record : records) {
    		String name = record.get(0);
    		int score = Integer.parseInt(record.get(1));
    		Highscore hs = new Highscore(name,score);
    		scores.add(hs);
    	}
    }
    
    public void updateScoreFile() {
    	FileWriter fileWriter = null;
        
        try {
            fileWriter = new FileWriter(fileName);
 
             
            //Write a new student object list to the CSV file
            for (Highscore hs : scores) {
            	
                fileWriter.append(hs.getName().getValue());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(hs.getScore()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
 
             
             
            System.out.println("CSV file was created successfully !!!");
             
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
             
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
             
        }
     }        
    
    public void getHighscoreString() throws FileNotFoundException {

        ObservableList<Highscore> scores;
        scores = getScores();

        for(Highscore hs: scores) {
        	System.out.println(hs.getName().getValue());
        }
    }
}