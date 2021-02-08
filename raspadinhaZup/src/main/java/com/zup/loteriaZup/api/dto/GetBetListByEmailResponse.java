package com.zup.loteriaZup.api.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect (fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GetBetListByEmailResponse {

	private List<Long> number;
	public GetBetListByEmailResponse (List<Long> number) {
		this.number = number;
	}
}
