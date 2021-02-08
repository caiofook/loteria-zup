package com.zup.loteriaZup.api.controller;

import com.zup.loteriaZup.api.dto.AddBetRequest;
import com.zup.loteriaZup.api.dto.GetBetListByEmailResponse;
import com.zup.loteriaZup.model.Bet;
import com.zup.loteriaZup.model.Person;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping ("api/v1/bet")
@RestController
public class AddBetController {

	private final EntityManager entityManager;

	public AddBetController (EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@PostMapping
	@Transactional
	public Long addBet (@Valid @RequestBody AddBetRequest addBetRequest) {
		String email = addBetRequest.getEmail();
		Person person = this.getOrCreatePerson(email);

		Bet bet = new Bet(person);

		this.entityManager.persist(person);
		this.entityManager.persist(bet);

		return bet.getNumber();
	}

	private Person getOrCreatePerson (String email) {

		String sql = "SELECT p FROM Person p WHERE p.email = :email";
		TypedQuery<Person> query = this.entityManager.createQuery(sql, Person.class);
		query.setParameter("email", email);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return new Person(email);
		}
	}
}
