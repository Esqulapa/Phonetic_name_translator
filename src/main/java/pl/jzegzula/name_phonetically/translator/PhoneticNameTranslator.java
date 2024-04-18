package pl.jzegzula.name_phonetically.translator;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneticNameTranslator {

  private final Map<String, String> languageToLanguageLetterReplacementsDictionary;

  public PhoneticNameTranslator(Map<String, String> dictionary) {
    this.languageToLanguageLetterReplacementsDictionary = dictionary;
  }

  public String replaceLetters(String input) {
    Matcher matcher =
        createMatcher(input.toLowerCase(), languageToLanguageLetterReplacementsDictionary);

    StringBuilder result = new StringBuilder();
    while (matcher.find()) {
      matcher.appendReplacement(
          result, languageToLanguageLetterReplacementsDictionary.get(matcher.group()));
    }
    matcher.appendTail(result);

    return capitalizeWordsAccordingToOriginal(input, result.toString());
  }

  private Matcher createMatcher(String input, Map<String, String> dictionary) {
    String regex = createRegexFromDictionary(dictionary);
    Pattern pattern = Pattern.compile(regex);
    return pattern.matcher(input);
  }

  private static String createRegexFromDictionary(Map<String, String> dictionary) {
    StringBuilder regexBuilder = new StringBuilder();
    dictionary.keySet().forEach(key -> regexBuilder.append(key).append("|"));
    return regexBuilder.deleteCharAt(regexBuilder.length() - 1).toString();
  }

  public String capitalizeWordsAccordingToOriginal(String original, String translated) {
    List<String> fromOriginal = Arrays.stream(original.split("\\s+")).toList();
    List<String> fromTranslated = Arrays.stream(translated.split("\\s+")).toList();

    return IntStream.range(0, fromTranslated.size())
        .mapToObj(
            i -> capitalizeStringIfOriginalIsCapital(fromOriginal.get(i), fromTranslated.get(i)))
        .collect(Collectors.joining(" "));
  }

  public String capitalizeStringIfOriginalIsCapital(String original, String translated) {
    char firstTranslatedChar = translated.charAt(0);
    char firstOriginalChar = original.charAt(0);

    if (!Character.isUpperCase(firstOriginalChar)) {
      return translated;
    } else return Character.toUpperCase(firstTranslatedChar) + translated.substring(1);
  }
}
