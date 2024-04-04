package pl.jzegzula.name_phonetically.person;

import lombok.Getter;

@Getter
public class Person {

    private String name;
    private String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }



}
