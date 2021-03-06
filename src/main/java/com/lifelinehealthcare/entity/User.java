package com.lifelinehealthcare.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.lifelinehealthcare.common.LifeLineHealthEnum.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String name;
	@Column(unique = true)
	private Long phoneNumber;
	private String password;
	private String emailAddress;
	@Enumerated(EnumType.STRING)
	private Role role;
	private String category;
	private Integer rating;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "user")
    private UserDetail userDetail;
}
