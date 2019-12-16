package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import sprites.Actor;

/**
 * This class reads a text file and creates the level on the screen
 * @author Nadim Rahman
 *
 */
public class LevelCreator {

    private String fileName = "src/resources/";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    private ArrayList<Lane> lanesCollection;
    
    // Different type of objects in the level
	public static enum  ActorTypes {
		  LogBig,
		  LogMedium,
		  LogSmall,
		  TruckBig,
		  TruckSmall,
		  Ambulance,
		  EndBlock,
		  WetTurtle,
		  NormalTurtle
	}
    
	MyStage background;
	private int numEnds;

	/**
	 * Initialises variables
	 * @param background
	 * @throws FileNotFoundException
	 */
    public LevelCreator(MyStage background) throws FileNotFoundException {
    	lanesCollection = new ArrayList<Lane>();
		this.background = background;
    }
    
    /**
     * Loads the correct level text file
     * @param levelNum is the numbered level stage that the user will play
     * @throws FileNotFoundException
     */
    public void loadLevelFile(int levelNum) throws FileNotFoundException {
    	//clearLevel();
    	List<List<String>> records = new ArrayList<>();
    	try (Scanner scanner = new Scanner(new File(fileName + "level" + levelNum + ".txt"));) {
    	    while (scanner.hasNextLine()) {
    	        records.add(getRecordFromLine(scanner.nextLine()));
    	    }
    	}
    	convertRecords(records);
    }
    
    /**
     * Converts each text line in the text file into a list of strings
     * @param line
     * @return a list a strings from the line
     */
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
        	// Separate the line with commas
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
    
    /**
     * Convert each line into the specified objects and add this to the screen
     * @param list of strings which represent the lane
     */
    private void convertRecords(List<List<String>> records) {
    	for(List<String> record : records) {
    		int laneNum = Integer.parseInt(record.get(0));
    		
    		// Check if the lane is the 'end' lane
    		// These lanes have 4 parameters
    		if(laneNum == 2) {
	    		ActorTypes actor = ActorTypes.valueOf(record.get(1));	
	    		int numActors = Integer.parseInt(record.get(2));
	    		numEnds = numActors;
	    		lanesCollection.add(new Lane(background,laneNum,actor,numActors));
    		}
    		
    		// Check if the lane is the 'water' lanes
    		// These lanes have to have 6 parameters, they must contain objects
    		if(laneNum >2 && laneNum < 9) {
	    		double speed = Double.parseDouble(record.get(1));
	    		ActorTypes actor = ActorTypes.valueOf(record.get(2));	
	    		int numActors = Integer.parseInt(record.get(3));
	    		int xStartPos = Integer.parseInt(record.get(4));
	    		int offset = Integer.parseInt(record.get(5));
	    		lanesCollection.add(new Lane(background,laneNum,speed,actor,numActors,xStartPos,offset));
    		}

    		// Check if the lane is the 'road' lanes
    		// These lanes have 6 parameters and don't have to contain anything
    		if(laneNum > 9 && laneNum < 15) {
    			if(record.size()==1) {
    				//Nothing in this lane
    			}
    			else {
    	    		double speed = Double.parseDouble(record.get(1));
    	    		ActorTypes actor =  ActorTypes.valueOf(record.get(2));	
    	    		int numActors = Integer.parseInt(record.get(3));
    	    		int xStartPos = Integer.parseInt(record.get(4));
    	    		int offset = Integer.parseInt(record.get(5));
    	    		lanesCollection.add(new Lane(background,laneNum,speed,actor,numActors,xStartPos,offset));
    			}
    		}
    	}
    	
    }
    
    /**
     * @return the number of 'ends' that are contained in this level
     * 
     */
    public int getNumEnds() {
    	return numEnds;
    }
    
    /**
     * Checks each lane and removes the objects
     */
    public void clearLevel() {
    	for(Lane lane:lanesCollection) {
    		ArrayList<Actor> itemCollection = lane.getItemCollection();
    		for(Actor item: itemCollection) {
    			background.remove(item);
    		}

    	}
    }
    
    
    /**
     * Checks if the lane needs updating on the screen
     * @return true if the level needs updating, false otherwise
     */
    public boolean needUpdateAdditions() {
    	for(Lane lane:lanesCollection) {
    		if(lane.needToAdd()) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Add all the items in the list and update the screen
     */
    public void addItem() {
    	for(Lane lane:lanesCollection) {
    		if(lane.needToAdd()){
    			ArrayList<Actor> actorsToAdd = lane.getAddedLaneItems();
    			for(Actor item:actorsToAdd) {
    				background.add(item);
    			}
    			lane.clearAddedLaneItems();
    		}
    	}	
    }

}
