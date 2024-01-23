package fr.EmiliePaniagua.poec.exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createdAt;

    private float rating;

    private LocalDateTime moderatedAt;

    @ManyToOne
    private Gamer gamer;

    @ManyToOne
    private Moderator moderator;

    @ManyToOne(optional = false)
    private Game game;

}
