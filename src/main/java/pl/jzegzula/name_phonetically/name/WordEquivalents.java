package pl.jzegzula.name_phonetically.name;

import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class WordEquivalents {

  public static final Map<String, String> words =
      Map.ofEntries(
          Map.entry("sz", "sh"),
          Map.entry("cz", "ch"),
          Map.entry("ć", "ch"),
          Map.entry("ż", "zh"),
          Map.entry("ń", "ny"),
          Map.entry("ł", "w"),
          Map.entry("ą", "on"),
          Map.entry("rz", "zh"),
          Map.entry("ść", "shch"),
          Map.entry("ę", "en"),
          Map.entry("dź", "j"),
          Map.entry("dż", "j"),
          Map.entry("czk", "ch-k"),
          Map.entry("trz", "tsh"),
          Map.entry("w", "v"));

  public String findWordEquivalent(String word) {
    if (words.containsKey(word)) {
      return words.get(word);
    } else {
      throw new NoSuchElementException("There is no equivalent for " + word);
    }
  }

  public static String replacePolishCharactersWithItsEnglishEquivalents(String word) {
    Set<String> characterAndItsIndex = findCharacterAndItsIndex(word);


    for (String key : characterAndItsIndex) {

      String englishEquivalent = words.get(key);

      String[] split = word.split(key);

      word = String.join(englishEquivalent, split);

    }
    return word;
  }

  public static Map<Integer, String> findCharacterAndItsIndex3(String word) {
    Map<Integer, String> stringMap = new HashMap<>();

    for (String key : words.keySet()) {
      if (word.contains(key)) {
        int i = word.indexOf(key);
        stringMap.put(i, key);
      }
    }

    return stringMap;
  }

  public static Set<String> findCharacterAndItsIndex(String word) {

    return words.keySet().stream().filter(word::contains).collect(Collectors.toSet());



  }
}

