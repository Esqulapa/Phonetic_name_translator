package pl.jzegzula.name_phonetically.response;

public record NameBadge(String originalName, String translatedName) {

  public static NameBadge of(String originalName, String translatedName) {
    return new NameBadge(originalName, translatedName);
  }
}
