package ru.otus.ageev.hw06jpa.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
@ToString
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String genreName;
}
