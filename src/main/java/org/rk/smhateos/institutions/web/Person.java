package org.rk.smhateos.institutions.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor

public class Person {

    private @Getter String firstname;
    private @Getter String lastname;
    private @Getter boolean active;

    public Person(String firstname, String lastname, boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.active = active;
    }
}
