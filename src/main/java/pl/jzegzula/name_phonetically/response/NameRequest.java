package pl.jzegzula.name_phonetically.response;

import jakarta.validation.constraints.NotBlank;

public record NameRequest(@NotBlank(message = "Name cannot be empty") String name) {}
