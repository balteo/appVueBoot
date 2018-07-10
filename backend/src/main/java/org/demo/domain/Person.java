package org.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String ssNumber;
    private String email;
    private String password;
}
