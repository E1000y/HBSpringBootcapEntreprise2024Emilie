package fr.EmiliePaniagua.poec.exam.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    @NotBlank
    private String birthAt;

}
