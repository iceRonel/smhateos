package org.rk.smhateos.institutions.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@RequiredArgsConstructor

public class PersonModel extends RepresentationModel<PersonModel> {

    private final @Getter/*(onMethod = @__(@JsonIgnore)) */Person person;



    @JsonIgnore
    private boolean lastname(){
       return person.isActive();
    }
}
