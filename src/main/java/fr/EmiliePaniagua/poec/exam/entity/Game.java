package fr.EmiliePaniagua.poec.exam.entity;


import fr.EmiliePaniagua.poec.exam.entity.interfaces.SluggerInterface;
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

public class Game implements SluggerInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    private LocalDate publishedAt;

    private String image;

    private String slug;

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

    @ManyToOne
    private Moderator moderator;

    public void addPlatform(Platform platform) {
        platforms.add(platform);
    }

    @Override
    public String getField() {
        return name;
    }
}
