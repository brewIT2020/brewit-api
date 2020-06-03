package pl.brewit.dictionary.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class BaseDictionary {

    private UUID id;
    @NotBlank @Size(max = 100) private String name;

    public BaseDictionary(UUID id, @NotBlank @Size(max = 100) String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
