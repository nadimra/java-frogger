package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LevelCreator {

    private String fileName = "src/resources/";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
	enum ActorTypes {
		  LogBig,
		  LogMedium,
		  LogSmall,
		  TruckBig,
		  TruckSmall,
		  EndBlock,
		  WetTurtle,
		  NormalTurtle
	}
    
	MyStage background;

    public LevelCreator(MyStage background, int levelNum) throws FileNotFoundException {
		this.background = background;
    	loadLevelFile(levelNum);
    }
    
    private void loadLevelFile(int levelNum) throws FileNotFoundException {
    	
    	List<List<String>> records = new ArrayList<>();
    	try (Scanner scanner = new Scanner(new File(fileName + "level" + levelNum + ".txt"));) {
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
    		int laneNum = Integer.parseInt(record.get(0));
    		if(laneNum == 2) {
	    		ActorTypes actor = ActorTypes.valueOf(record.get(1));	
	    		int numActors = Integer.parseInt(record.get(2));
	    		new Lane(background,laneNum,actor,numActors);
	    		System.out.println("testest end");
    		}
    		
    		// These lanes have to have 6 parameters
    		if(laneNum >2 && laneNum < 9) {
	    		double speed = Double.parseDouble(record.get(1));
	    		ActorTypes actor = ActorTypes.valueOf(record.get(2));	
	    		int numActors = Integer.parseInt(record.get(3));
	    		int xStartPos = Integer.parseInt(record.get(4));
	    		int offset = Integer.parseInt(record.get(5));
	    		new Lane(background,laneNum,speed,actor,numActors,xStartPos,offset);
    		}

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
    	    		new Lane(background,laneNum,speed,actor,numActors,xStartPos,offset);
    			}
    		}
    	}
    }


}
