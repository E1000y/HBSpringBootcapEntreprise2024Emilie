package fr.EmiliePaniagua.poec.exam.entity;

import fr.EmiliePaniagua.poec.exam.entity.interfaces.NomenclatureInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Platform implements NomenclatureInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "platforms")
    private List<Game> games = new ArrayList<>();

}
