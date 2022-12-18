import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RadioIssues {


    public static void main(String[] args){

        String inputBuffer = "";
        try {
            //Read in the string of characters
            Scanner inputReader = new Scanner(new File("inputDay6.txt"));
            while(inputReader.hasNextLine()){
                inputBuffer = inputBuffer + inputReader.nextLine();
            }

            //Note: Part one requires 4 consecutive unique characters, Part two requires 14
            String possibleMarker = "";
            String possibleMarkerComp = "";
            int markerStartIndex = 0;
            int markerEndIndex = 13;
            int markerDuplicateIndex = -1;
            char compChar = 9;
            boolean duplicateFound = false;

            while(markerEndIndex <= inputBuffer.length()){
                System.out.println("Top of loop: markerStartIndex=" + markerStartIndex + " markerEndIndex=" + markerEndIndex);
                //pull the 4 characters that are the possible marker of the start
                if(markerEndIndex == inputBuffer.length()){
                    possibleMarker = inputBuffer.substring(markerStartIndex);
                }else {
                    possibleMarker = inputBuffer.substring(markerStartIndex, markerEndIndex + 1);
                }
                System.out.println("possibleMarker: " + possibleMarker);
                //see if there are duplicates in possibleMarker
                for(int mc = 0; mc < 14; mc++) {
                    compChar = possibleMarker.charAt(mc);
                    System.out.println("compChar: " + compChar);
                    //compare to possibleMarker string minus the compChar (replace with 0)
                    if(mc == 0){
                        possibleMarkerComp = "0" + possibleMarker.substring(mc+1);
                    }else {
                        possibleMarkerComp = possibleMarker.substring(0, mc) + "0" + possibleMarker.substring(mc + 1);
                    }
                    System.out.println("possibleMarkerComp string: " + possibleMarkerComp);

                    markerDuplicateIndex = possibleMarkerComp.indexOf(compChar);    //note: -1 means dup does not exist
                    System.out.println("markerDuplicateIndex=" + markerDuplicateIndex);
                    if (markerDuplicateIndex > -1) {  //duplicate found
                        duplicateFound = true;
                        break;
                    }
                }//end for

                if(duplicateFound == true){
                    //increment start/end index and reset duplicateFound to false
                    markerStartIndex++;
                    markerEndIndex++;
                    duplicateFound = false;
                }else{
                    System.out.println("**************************************************");
                    System.out.println("First marker after character: " + (markerEndIndex+1));
                    System.out.println("**************************************************");
                    System.exit(10);
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
