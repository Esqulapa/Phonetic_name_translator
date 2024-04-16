package pl.jzegzula.name_phonetically.dictionaries;

import java.util.Map;

public class PolishToEnglishLetterReplacementDictionary implements Dictionary{

   private static final Map<String,String> polishDictionary = Map.ofEntries(
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

   @Override
   public Map<String, String> words() {
      return polishDictionary;
   }
}
