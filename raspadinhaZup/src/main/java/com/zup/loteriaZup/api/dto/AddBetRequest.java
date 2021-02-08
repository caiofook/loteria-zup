package com.zup.loteriaZup.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AddBetRequest {

	@NotBlank @Email
	private String email;

	public String getEmail () {
		return email;
	}

}
