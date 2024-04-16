package pl.jzegzula.name_phonetically.name;

import pl.jzegzula.name_phonetically.dictionaries.Dictionary;
import pl.jzegzula.name_phonetically.dictionaries.LetterDictionary;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneticNameTranslator {
  private final LetterDictionary languageToLanguageLetterReplacementsDictionary;

  public PhoneticNameTranslator(Dictionary dictionary) {
    this.languageToLanguageLetterReplacementsDictionary =
            LetterDictionary.of(dictionary);
  }

  public String replaceLetters(String input) {
    Matcher matcher =
        createMatcher(input.toLowerCase(), languageToLanguageLetterReplacementsDictionary);

    StringBuilder result = new StringBuilder();
    while (matcher.find()) {
      matcher.appendReplacement(
          result, languageToLanguageLetterReplacementsDictionary.words().get(matcher.group()));
    }
    matcher.appendTail(result);

    return capitalizeWordsAccordingToOriginal(input,result.toString());
  }

  private Matcher createMatcher(String input, LetterDictionary dictionary) {
    String regex = createRegexFromDictionary(dictionary);
    Pattern pattern = Pattern.compile(regex);
    return pattern.matcher(input);
  }

  private static String createRegexFromDictionary(LetterDictionary dictionary) {
    StringBuilder regexBuilder = new StringBuilder();
    dictionary.words().keySet().forEach(key -> regexBuilder.append(key).append("|"));
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

  public String capitalizeEveryWord(String str) {

    return Arrays.stream(str.split("\\s+"))
        .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
        .collect(Collectors.joining(" "));
  }
}
