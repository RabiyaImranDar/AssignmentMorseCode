package AssignmentAlphabetsAndMorsekod;

import org.junit.Test;

import static org.junit.Assert.*;
public class TestConverter {

    // Testfall nr.1 ----------------Testing text to Morse-code
@Test
public void testTextToCode(){
// Arrange-----> objekt från logik-klass + testdata + expected
ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
// testdata
    String testdata = "KATT";
    String expected= "-*- *- - -";
// Act--------> actual (calling method)
String actual = converterMorsekodAlphabets.getCode(testdata);
// Assert-----> jämförelse (expected, actual)
assertEquals(expected,actual);
}

// Testfall nr.2 -------------Testing Morse-code to text
@Test
public void testCodeToText(){
// Arrange-----> objekt från logik-klass + testdata + expected
    ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
// testdata
    String testdata = "-*- *- - -";
    String expected= "KATT";
// Act--------> actual (calling method)
    String actual = converterMorsekodAlphabets.getText(testdata);
// Assert-----> jämförelse (expected, actual)
    assertEquals(expected,actual);
}

// Testfall nr.3 -------------Testing Digits/Symbols to Morse-code
    @Test
    public void testDigitsToCode(){
// Arrange-----> objekt från logik-klass + testdata + expected
        ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
// testdata
        String testdata = "197";
        String expected= "*---- ----* --***";
// Act--------> actual (calling method)
        String actual = converterMorsekodAlphabets.getCode(testdata);
// Assert-----> jämförelse (expected, actual)
        assertEquals(expected,actual);
    }

    // Testfall nr.4 -------------Testing Small Alphabets to Morse-code
    @Test
    public void testSmallAlphabetsToMorseCode(){
// Arrange-----> objekt från logik-klass + testdata + expected
        ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
// testdata
        String testdata = "ASaa";
        String expected= "*- *** *- *-";
// Act--------> actual (calling method)
        String actual = converterMorsekodAlphabets.getCode(testdata);
// Assert-----> jämförelse (expected, actual)
        assertEquals(expected,actual);
    }
    // Testfall nr.5 -------------Testing Words to Morse-code with / as a separator
    @Test
    public void testWordsToMorseCodeWithSeparator(){
// Arrange-----> objekt från logik-klass + testdata + expected
        ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
// testdata
        String testdata = "An Apple";
        String expected= "*- -* / *- *--* *--* *-** *";
// Act--------> actual (calling method)
        String actual = converterMorsekodAlphabets.getCode(testdata);
// Assert-----> jämförelse (expected, actual)
        assertEquals(expected,actual);
    }

    // Felfall nr.1
  //-------------Testing Incorrect Morse-code to Error-message (Felfall nr.1)
  @Test
  public void testIncorrectCodeToErrMsg(){
// Arrange-----> objekt från logik-klass + testdata + expected
      ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
// testdata
      String testdata = "-*}*";
      String expected= "Invalid Input";
// Act--------> actual (calling method)
      String actual = converterMorsekodAlphabets.getText(testdata);
// Assert-----> jämförelse (expected, actual)
      assertEquals(expected,actual);
  }

    // Felfall nr.2
//-------------Testing Incorrect English,digits,symbols to Error-message
    @Test
    public void testIncorrectTextToErrMsg(){
// Arrange-----> objekt från logik-klass + testdata + expected
        ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
// testdata
        String testdata = "ÄÖ>>";
        String expected= "Invalid Input";
// Act--------> actual (calling method)
        String actual = converterMorsekodAlphabets.getCode(testdata);
// Assert-----> jämförelse (expected, actual)
        assertEquals(expected,actual);
    }
    // Felfall nr.3
//-------------Testing only spaces to Error-message
    @Test
    public void testSpacesToErrMsg(){
// Arrange-----> objekt från logik-klass + testdata + expected
        ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
// testdata
        String testdata = "   ";
        String expected= "Invalid Input";
// Act--------> actual (calling method)
        String actual = converterMorsekodAlphabets.getCode(testdata);
// Assert-----> jämförelse (expected, actual)
        assertEquals(expected,actual);
    }
}
