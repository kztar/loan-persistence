package tech.kztar.persistence.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "borrowers")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Setter
	@Column
	private String name;

	@Setter
	@Column(name = "phone_no")
	private String phoneNo;

	@Setter
	@Column
	private String address;

	@Setter
	@Column(name = "postal_code")
	private String postalCode;

	@Setter
	@Column(name = "guarantor_id")
	private UUID guarantorId;

	@Transient
	private Set<IdentificationInfo> identifications = new HashSet<IdentificationInfo>();

	@Setter
	@Transient
	private Borrower guarantor;

	@Transient
	private Set<BorrowerBankDetails> bankDetailsSet = new HashSet<BorrowerBankDetails>();

	/**
	 * Constructor with {@link #id}
	 * 
	 * @param id
	 */
	public Borrower(UUID id) {
		this.id = id;
	}

	/**
	 * Constructor with borrower's {@link #name}
	 * 
	 * @param name
	 */
	public Borrower(String name) {
		this.name = name;
	}

	@PrePersist
	void doBeforePersist() {
		// Set borrowerId to the guarantor
		// Make sure the guarantor has already been persisted prior to this
		if (guarantor != null && guarantor.getId() != null) {
			this.guarantorId = guarantor.getId();
		}
	}

	/*
	 * Helper methods below
	 */

	public boolean hasAnyIdentifications() {
		return !identifications.isEmpty();
	}

	public boolean addIdentification(IdentificationInfo identificationInfo) {
		return identifications.add(identificationInfo);
	}

	/**
	 * 
	 * @return a new list of existing {@link IdentificationInfo}
	 */
	public List<IdentificationInfo> getIdentifications() {
		return new LinkedList<IdentificationInfo>(identifications);
	}

	public boolean hasAnyBankDetails() {
		return !bankDetailsSet.isEmpty();
	}

	public boolean addBankDetails(BorrowerBankDetails bankDetails) {
		return bankDetailsSet.add(bankDetails);
	}

	/**
	 * 
	 * @return a new list of exiting {@link BorrowerBankDetails}
	 */
	public List<BorrowerBankDetails> getBankDetailsList() {
		return new LinkedList<BorrowerBankDetails>(bankDetailsSet);
	}

}
