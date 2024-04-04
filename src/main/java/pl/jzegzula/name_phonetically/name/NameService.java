package pl.jzegzula.name_phonetically.name;

import org.springframework.stereotype.Service;

@Service
public class NameService {

    private final WordEquivalents wordEquivalents;


    public NameService(WordEquivalents wordEquivalents) {
        this.wordEquivalents = wordEquivalents;
    }



}
