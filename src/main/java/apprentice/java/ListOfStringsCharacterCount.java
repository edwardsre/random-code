package apprentice.java;

import java.util.ArrayList;
import java.util.List;

public class ListOfStringsCharacterCount {

  public static void main(String[] args) {
    long characterCount = 0;

    final List<String> stringList = new ArrayList<>();
    try {
      for (int i = 0; ; i++) {
        final String aString = Integer.toString(i);
        if (stringList.add(aString)) {
          characterCount += aString.length();
        }
      }
    }
    catch (OutOfMemoryError e) {
      System.out.println("Number of characters added to list when out of memory error occurred: " + characterCount);
    }
  }
}
