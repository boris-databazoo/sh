package com.databazoo.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Superhero business object.
 */
@Setter
@Getter
@Entity
@Table(name = "superhero")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pseudonym", nullable = true)
    private String pseudonym;

    @ManyToOne(/*targetEntity = Publisher.class,*/ fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name="skill_to_superhero",
            joinColumns=@JoinColumn(name="superhero_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="skill_id", referencedColumnName="id"))
    private List<Skill> skills = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="allies",
            joinColumns=@JoinColumn(name="superhero_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="ally_id", referencedColumnName="id"))
    private List<Superhero> allies = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "first_appeared")
    private Calendar firstAppeared;

    public Superhero() {
    }

    public Superhero(String name) {
        this.name = name;
    }
}
