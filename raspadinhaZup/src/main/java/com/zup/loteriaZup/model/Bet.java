package com.zup.loteriaZup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
public class Bet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull @Positive
    private Long number;

    @ManyToOne(optional = false)
    private Person person;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    protected Bet() { }

    public Bet (Person person) {
        this.number = this.getRandomNumber();
        this.person = person;
    }

    private Long getRandomNumber () {
        int min = 1;
        int max = 60;
        double randomDouble = Math.random() * (max - min + 1) + min;
        return (long) randomDouble;
    }

    public void setPerson (Person person) {
        this.person = person;
    }

    public Long getNumber () {
        return number;
    }
}
