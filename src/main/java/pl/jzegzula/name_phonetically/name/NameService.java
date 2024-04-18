package pl.jzegzula.name_phonetically.name;

import org.springframework.stereotype.Service;
import pl.jzegzula.name_phonetically.dictionaries.PolishToEnglishLetterReplacementDictionary;
import pl.jzegzula.name_phonetically.response.NameBadge;
import pl.jzegzula.name_phonetically.translator.PhoneticNameTranslator;

@Service
public class NameService {

  private final PolishToEnglishLetterReplacementDictionary dictionary;

  public NameService(PolishToEnglishLetterReplacementDictionary dictionary) {
    this.dictionary = dictionary;
  }

  public NameBadge translateNamePhonetically(String name) {
    PhoneticNameTranslator translator =
        new PhoneticNameTranslator(dictionary.getPolishDictionary());
    String translatedName = translator.replaceLetters(name);

    return NameBadge.of(name, translatedName);
  }
}
