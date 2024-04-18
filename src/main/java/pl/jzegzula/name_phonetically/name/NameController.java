package pl.jzegzula.name_phonetically.name;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.jzegzula.name_phonetically.response.NameRequest;

@RestController
@RequestMapping("${api.url}/name")
public class NameController {

  private final NameService service;

  public NameController(NameService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<?> handleName(
      @RequestBody @Valid NameRequest name, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(bindingResult.getAllErrors().getFirst().getDefaultMessage());
    }
    return ResponseEntity.status(200).body(service.translateNamePhonetically(name.name()));
  }
}
