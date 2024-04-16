package pl.jzegzula.name_phonetically.name;

import org.springframework.stereotype.Service;
import pl.jzegzula.name_phonetically.dictionaries.LetterDictionary;

@Service
public class NameService {

    private final LetterDictionary letterDictionary;


    public NameService(LetterDictionary letterDictionary) {
        this.letterDictionary = letterDictionary;
    }



}
