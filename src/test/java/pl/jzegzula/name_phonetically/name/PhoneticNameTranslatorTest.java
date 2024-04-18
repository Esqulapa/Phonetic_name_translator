package pl.jzegzula.name_phonetically.name;

import org.junit.jupiter.api.Test;
import pl.jzegzula.name_phonetically.dictionaries.PolishToEnglishLetterReplacementDictionary;
import pl.jzegzula.name_phonetically.translator.PhoneticNameTranslator;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PhoneticNameTranslatorTest {


  PolishToEnglishLetterReplacementDictionary dictionary = new PolishToEnglishLetterReplacementDictionary();
  


  @Test
  void replacePolishLetters() {
    
    PhoneticNameTranslator phoneticNameTranslator = new PhoneticNameTranslator(dictionary.getPolishDictionary());
    String string = "Marzena won Trzaskowska";
    String stringExpected = "Mazhena von Tshaskovska";

    String s1 = phoneticNameTranslator.replaceLetters(string);

    assertEquals(stringExpected,s1);

    System.out.println(s1);

  }

  @Test
  void shouldCheckUpperCaseOccurrencesInOriginalAndPutItIntoChangedString(){
    //given
    PhoneticNameTranslator phoneticNameTranslator = new PhoneticNameTranslator(dictionary.getPolishDictionary());
    String string = "Marzena wan Trzaskowska";
    String stringChanged = "mazhena van tshaskovska";
    //when
    String changed = phoneticNameTranslator.capitalizeWordsAccordingToOriginal(string, stringChanged);
    String s = phoneticNameTranslator.capitalizeStringIfOriginalIsCapital(string, stringChanged);

    // then
    System.out.println(s);
    System.out.println(changed);


  }
}


