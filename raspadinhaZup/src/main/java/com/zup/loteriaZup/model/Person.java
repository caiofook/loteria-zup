package com.zup.loteriaZup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Person {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (unique = true, nullable = false)
	@NotBlank @Email
	private String email;

	@OneToMany(mappedBy = "person")
	private List<Bet> betList;

	@Deprecated
	protected Person () { }

	public Person (@NotBlank @Email String email) {
		this.email = email;
		this.betList = new ArrayList<>();
	}

	public List<Bet> getBetList () {
		return Collections.unmodifiableList(betList);
	}
}
