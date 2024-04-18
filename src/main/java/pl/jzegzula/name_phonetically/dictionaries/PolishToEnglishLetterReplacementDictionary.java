package pl.jzegzula.name_phonetically.dictionaries;

import java.util.Map;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PolishToEnglishLetterReplacementDictionary {

  private final Map<String, String> polishDictionary =
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
          Map.entry("ch", "h"),
          Map.entry("w", "v"));
}
