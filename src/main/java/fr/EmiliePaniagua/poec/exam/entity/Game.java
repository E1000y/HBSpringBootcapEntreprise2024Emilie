package fr.EmiliePaniagua.poec.exam.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate publishedAt;

    private String image;

    @ManyToOne
    private BusinessModel businessModel;

    @ManyToOne
    private Classification classification;

    @OneToMany(mappedBy= "game")
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Platform> platforms = new ArrayList<>();





}
