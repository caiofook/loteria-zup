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
public class GetBetController {

	private final EntityManager entityManager;

	public GetBetController (EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@GetMapping ("/{email}")
	public GetBetListByEmailResponse getBetsByEmail (@PathVariable String email) {
		String sql = "SELECT b FROM Person p INNER JOIN p.betList b WHERE p.email = :email";
		TypedQuery<Bet> query = this.entityManager.createQuery(sql, Bet.class);
		query.setParameter("email", email);

		List<Bet> betListFound = query.getResultList();

		List<Long> betNumbersList = betListFound.stream().map(Bet::getNumber).collect(Collectors.toList());
		return new GetBetListByEmailResponse(betNumbersList);
	}
}
