package pl.jzegzula.name_phonetically.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testShouldCreatePerson(){
        //given
        String name = "Bohdan";
        String lastName = "Smolen";


        //when
        Person person = new Person(name, lastName);

        //then
        assertEquals(person.getName(),name);
        assertEquals(person.getLastName(), lastName);
    }
}
