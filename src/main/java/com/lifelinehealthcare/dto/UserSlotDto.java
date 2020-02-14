package com.lifelinehealthcare.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSlotDto {

	private Integer slotId;
	private LocalDate slotDate;
	private String slotTimeFrom;
	private String slotTimeTo;
	private String hospitalDetail;
	private String patientName;
	private Long patientPhoneNumber;
	private String diseaseDetail;
}
