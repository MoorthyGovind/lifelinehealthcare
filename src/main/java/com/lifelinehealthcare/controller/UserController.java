package com.lifelinehealthcare.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifelinehealthcare.constant.AppConstant;
import com.lifelinehealthcare.dto.DoctorDto;
import com.lifelinehealthcare.dto.SearchRequestDto;
import com.lifelinehealthcare.dto.UserSearchResponseDto;
import com.lifelinehealthcare.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Get the user functionalities rest api's of search users based on the doctor
 * name and category.
 * 
 * @author Govindasamy.C
 * @since 12-02-2020
 * @version V1.1
 *
 */
@RestController
@RequestMapping("/users")
@Slf4j
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<UserSearchResponseDto> getUsersBySearchValue(
			@Valid @RequestBody SearchRequestDto searchRequestDto) {
		log.info("get users by user name and category...");
		List<DoctorDto> doctors = userService.getUsersBySearchValue(searchRequestDto);
		UserSearchResponseDto userSearchResponseDto = new UserSearchResponseDto();
		userSearchResponseDto.setUsers(doctors);
		userSearchResponseDto.setStatusCode(HttpStatus.OK.value());
		userSearchResponseDto.setMessage(AppConstant.SUCCESS_MESSAGE);
		return new ResponseEntity<>(userSearchResponseDto, HttpStatus.OK);

	}
}
