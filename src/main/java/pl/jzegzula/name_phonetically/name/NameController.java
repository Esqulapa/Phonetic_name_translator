package pl.jzegzula.name_phonetically.name;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.url}/name")
public class NameController {

    @PostMapping
    public ResponseEntity<String> handleName(String name,String lastName)
    {
       return ResponseEntity.ok().body(name.concat(lastName));
    }

}
