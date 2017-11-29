package com.gft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gft.service.LogServices;

@Controller
public class LogController {
	@Autowired
	LogServices logServices;
}
