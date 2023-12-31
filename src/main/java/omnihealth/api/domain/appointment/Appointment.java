package omnihealth.api.domain.appointment;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import omnihealth.api.domain.doctor.Doctor;
import omnihealth.api.domain.patient.Patient;

@Table(name = "appointments")
@Entity(name = "Appointment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	private LocalDateTime date;

	private Boolean active;

	@Column(name = "cancellation_reason")
	@Enumerated(EnumType.STRING)
	private CancellationReason cancellationReason;

	public void delete(CancellationReason reason) {
		this.active = false;
		this.cancellationReason = reason;
	}

}
