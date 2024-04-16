package pl.jzegzula.name_phonetically.name;

import org.junit.jupiter.api.Test;
import pl.jzegzula.name_phonetically.dictionaries.LetterDictionary;
import pl.jzegzula.name_phonetically.dictionaries.PolishToEnglishLetterReplacementDictionary;

class PhoneticNameTranslatorTest {

  LetterDictionary polish = LetterDictionary.of(new PolishToEnglishLetterReplacementDictionary());

  LetterDictionary dictionary  = LetterDictionary.of(new PolishToEnglishLetterReplacementDictionary());



  @Test
  void replacePolishLetters() {
    PhoneticNameTranslator phoneticNameTranslator = new PhoneticNameTranslator(polish);
    String string = "Marzena won Trzaskowska";
    String s1 = phoneticNameTranslator.replaceLetters(string);

    System.out.println(s1);
  }

  @Test
  void shouldCheckUpperCaseOccurrencesInOriginalAndPutItIntoChangedString(){
    //given
    PhoneticNameTranslator phoneticNameTranslator = new PhoneticNameTranslator(polish);
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


