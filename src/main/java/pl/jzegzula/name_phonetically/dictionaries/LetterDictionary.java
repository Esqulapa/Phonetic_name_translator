package pl.jzegzula.name_phonetically.dictionaries;


import java.util.Map;

public class LetterDictionary implements Dictionary {


  private final Map<String, String> words;

  public LetterDictionary(Dictionary dictionary) {

    this.words = dictionary.words();
  }

  public static LetterDictionary of(Dictionary dictionary){
   return new LetterDictionary(dictionary);
  }

  @Override
  public Map<String, String> words() {
    return words;
  }
}

