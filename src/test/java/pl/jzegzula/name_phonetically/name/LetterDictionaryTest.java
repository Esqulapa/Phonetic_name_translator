package pl.jzegzula.name_phonetically.name;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import pl.jzegzula.name_phonetically.dictionaries.LetterDictionary;
import pl.jzegzula.name_phonetically.dictionaries.PolishToEnglishLetterReplacementDictionary;

class LetterDictionaryTest {

  @Test
  void shouldPrintDictionaryElements() {
    // given
    LetterDictionary letterDictionary = new LetterDictionary(new PolishToEnglishLetterReplacementDictionary());
    Map<String, String> words = letterDictionary.words();
    // when then
    assertEquals(15, words.size());
  }

  @Test
  public void chujwieco(){

    String polishName = "Jarosław";
    String englishRepresentation = "Jaroswav";


    int indexOfŁ = polishName.indexOf("ł");
    int lengthOfŁ = 1;

    String result = replaceSubstringAt(indexOfŁ,lengthOfŁ,polishName);

    System.out.println(result);
  }
  public String replaceSubstringAt(int index,int letterLength,String polishName){
    String substring = polishName.substring(0, index);
    String substring2 = polishName.substring(index + letterLength);
    return  substring + "w" + substring2;


  }

//  @Test
//  public void shouldReturnCharacterIndexAndCharacterToBeSwapped(){
//    WordEquivalents wordEquivalents = new WordEquivalents();
//    //given
//    String word = "Jarosław";
//    Map<Integer, String> sh = Map.of(5, "ł",7,"w");
//
//    //when
//    Map<Integer, String> characterAndItsIndex = wordEquivalents.findCharacterAndItsIndex(word);
//
//    //then
//    assertEquals(sh,characterAndItsIndex);
//
//  }
}
