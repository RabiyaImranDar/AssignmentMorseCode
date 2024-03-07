package AssignmentAlphabetsAndMorsekod;
//Logik class

//import org.junit.jupiter.params.provider.NullSource;
//import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import java.util.HashMap;

public class ConverterMorsekodAlphabets {
    private String ivInput = "Invalid Input";
    private HashMap<String, String> alphaVsKod;
    private HashMap<String, String> kodVsAlpha;
    public ConverterMorsekodAlphabets(){
        alphaVsKod = new HashMap<>();
        kodVsAlpha = new HashMap<>();
        alphaVsKod.put("A","*-");
        alphaVsKod.put("B","-***");
        alphaVsKod.put("C","-*-*");
        alphaVsKod.put("D","-**");
        alphaVsKod.put("E","*");
        alphaVsKod.put("F","**-*");
        alphaVsKod.put("G","--*");
        alphaVsKod.put("H","****");
        alphaVsKod.put("I","**");
        alphaVsKod.put("J","*---");
        alphaVsKod.put("K","-*-");
        alphaVsKod.put("L","*-**");
        alphaVsKod.put("M","--");
        alphaVsKod.put("N","-*");
        alphaVsKod.put("O","---");
        alphaVsKod.put("P","*--*");
        alphaVsKod.put("Q","--*-");
        alphaVsKod.put("R","*-*");
        alphaVsKod.put("S","***");
        alphaVsKod.put("T","-");
        alphaVsKod.put("U","**-");
        alphaVsKod.put("V","***-");
        alphaVsKod.put("W","*--");
        alphaVsKod.put("X","-**-");
        alphaVsKod.put("Y","-*--");
        alphaVsKod.put("Z","--**");
        alphaVsKod.put("1","*----");
        alphaVsKod.put("2","**---");
        alphaVsKod.put("3","***--");
        alphaVsKod.put("4","****-");
        alphaVsKod.put("5","*****");
        alphaVsKod.put("6","-****");
        alphaVsKod.put("7","--***");
        alphaVsKod.put("8","---**");
        alphaVsKod.put("9","----*");
        alphaVsKod.put("0","-----");
        alphaVsKod.put(".","*-*-*-");
        alphaVsKod.put(",","--**--");
        alphaVsKod.put("?","**--**");
    // kodvVsAlpha
        for(String value :alphaVsKod.keySet())

    {
        String morseKodKey = alphaVsKod.get(value);
        kodVsAlpha.put(morseKodKey, value);
    }

}
    public String getCode(String engText) {
        StringBuilder code = new StringBuilder();

        String[] words = engText.split(" ");
        int k = 0; // counter to check the last word
        int j = words.length - 1; // index for the last words array
        try {
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    char alph = word.toUpperCase().charAt(i);
                    if ((Character.toString(alph).equals("")) || Character.toString(alph).equals(" ")){
                        throw new IllegalArgumentException();
                    }
                    String alphabet = alphaVsKod.get(Character.toString(alph));
                    if ((alphabet==null)||(alphabet.equals(" "))||(alphabet.equals("")) ){
                        throw new IllegalArgumentException();
                    }
                    if (i != word.length() - 1) {
                        code.append(alphabet + " ");
                    } else code.append(alphabet);
                }
                if (k != j) // counter checks if its not the last word!!
                {
                        code.append(" / "); // to add separator btw words!!
                }
                k++;
            }
            if (code.toString().equals("")){
                throw new IllegalArgumentException(); // if only spaces are given without a word!!
            }
            return code.toString();
        }// try ends
        catch (IllegalArgumentException e) {
            System.out.println("InValid Input other than A-Z, " +
                    "0-9 or symbols {. , ?} or just spaces given");
            return ivInput;
        }
      //  return code.toString();
    }

    // Morse-code to text and digits or symbols!!
    public String getText(String morseText) {
        StringBuilder engCode = new StringBuilder();
        String[] morseWord = morseText.split(" ");
        try {
            for (String morseWord1 : morseWord) {
                String alphadigit = kodVsAlpha.get(morseWord1);
                if (alphadigit == null) {
                    throw new IllegalArgumentException();
                }
                engCode.append(alphadigit);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("InValid Morse-code or input other than * or - signs");
            return ivInput;
        }
        return engCode.toString();
    }
}

