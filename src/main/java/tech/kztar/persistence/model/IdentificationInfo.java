package tech.kztar.persistence.model;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "identification_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class IdentificationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Setter
	@Column(name = "identification_no", nullable = false)
	private String identificationNo;

	@Setter
	@Column(name = "identification_type", nullable = false)
	private String identificationType;

	@Setter
	@Column(name = "borrower_id", nullable = false)
	private UUID borrowerId;

	public IdentificationInfo(String identificationNo, String identificationType) {
		this.identificationNo = identificationNo;
		this.identificationType = identificationType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		IdentificationInfo idInfo = (IdentificationInfo) obj;
		return identificationNo.equals(idInfo.getIdentificationNo())
				&& identificationType.equals(idInfo.getIdentificationType());
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificationNo, identificationType);
	}

}
