import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
void setup(){
  System.out.println(pigLatin("try"));
  System.out.println(pigLatin("at"));
  System.out.println(pigLatin("question"));
  System.out.println(pigLatin("ball"));
  System.out.println(pigLatin("Child"));
}
public int findFirstVowel(String sWord) {
  for (int i = 0; i < sWord.length(); i += 1){
    if(sWord.substring(i, i + 1).equals("a") || sWord.substring(i, i + 1).equals("e") || sWord.substring(i, i + 1).equals("i") || sWord.substring(i, i + 1).equals("o") || sWord.substring(i, i + 1).equals("u") ){
      //System.out.println(i);
      return i;
    }
  }
  return -1;
}
public String pigLatin(String sWord) {
  String piece1 = new String(sWord.substring(0, 1));
  String pieceQU = new String(sWord.substring(0, 2));
  String piece2 = new String(sWord.substring(1, sWord.length()));
  String newString = new String(piece2 + piece1);
  // if it starts with vowel
  if (piece1.equals("a") || piece1.equals("e") || piece1.equals("i")|| piece1.equals("o")|| piece1.equals("u")){
    return sWord + "way";
  }
  // if it starts with qu
  if (pieceQU.equals("qu")){
    String newQUstring = new String(sWord.substring(2, sWord.length()) + pieceQU + "ay");
    return newQUstring;
  }
  // if it starts with a consonant
  if(findFirstVowel(sWord) > 0 ) {
      String consonantCluster = sWord.substring(0, findFirstVowel(sWord)); // Extract cluster
      String restOfWord = sWord.substring(findFirstVowel(sWord));          // Extract the rest
      return restOfWord + consonantCluster + "ay";                  // Move cluster to the end
    }
 
return sWord + "ay";
}
}//end PigLatin class
