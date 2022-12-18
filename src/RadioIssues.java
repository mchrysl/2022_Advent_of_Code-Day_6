import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RadioIssues {


    public static void main(String[] args){

        String inputBuffer = "";
        try {
            //Read in the string of characters
            Scanner inputReader = new Scanner(new File("inputDay6Short.txt"));
            while(inputReader.hasNextLine()){
                inputBuffer = inputBuffer + inputReader.nextLine();
            }

            String possibleMarker = "";
            String possibleMarkerComp = "";
            int markerStartIndex = 0;
            int markerEndIndex = 3;
            int markerDuplicateIndex = -1;
            char compChar = 9;

            while(markerEndIndex <= inputBuffer.length()){
                //pull the 4 characters that are the possible start marker
                for(int i = 0; i < 4; i++){
                    possibleMarker = possibleMarker + inputBuffer.charAt(markerStartIndex+i);
                }
                //see if there are duplicates in possibleMarker
                for(int mc = 0; mc < 4; mc++) {
                    compChar = possibleMarker.charAt(mc);
                    //compare to possibleMarker string minus the compChar (replace with 0)
                    if(mc == 0){
                        possibleMarkerComp = "0" + possibleMarker.substring(mc+1);
                    }else {
                        possibleMarkerComp = possibleMarker.substring(0, mc + 1) + "0" + possibleMarker.substring(mc + 1);
                    }
                    System.out.println("possibleMarkerComp string: " + possibleMarkerComp);
                    /*
                    markerDuplicateIndex = possibleMarker.indexOf(compChar);    //note: -1 means does not exist
                    if (markerDuplicateIndex > -1) {  //duplicate is found
                        //increment markerStartIndex & markerEndIndex by 1, reset the other variables
                        markerStartIndex++;
                        markerEndIndex++;
                        possibleMarker = "";
                        possibleMarkerComp = "";
                        compChar = 9;
                    } else {      //duplicate not found ==> this is the marker
                        System.out.println("First marker after character: " + markerEndIndex);
                    }
                    
                     */
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
