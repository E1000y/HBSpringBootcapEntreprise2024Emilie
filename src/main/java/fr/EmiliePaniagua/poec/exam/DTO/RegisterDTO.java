package fr.EmiliePaniagua.poec.exam.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegisterDTO {

    @Column(nullable= false)
    private String email;

    @Column(nullable=false)
    private String nickname;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String checkPassword;

    @Column(nullable= false)
    private LocalDate birthAt;



}
