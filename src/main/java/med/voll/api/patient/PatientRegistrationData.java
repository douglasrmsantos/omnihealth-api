package med.voll.api.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.address.AddressData;

public record PatientRegistrationData(@NotBlank String name,

		@NotBlank @Email String email,

		@NotBlank String telephone,

		@Pattern(regexp = "\\d{11}") String cpf,

		@NotNull @Valid AddressData address

) {

}