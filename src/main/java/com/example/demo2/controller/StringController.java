package com.example.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.model.InputModel;
import com.example.demo2.service.StringService;

@RestController
public class StringController {

	@Autowired
	public InputModel input;
	@Autowired
	public StringService service;
	
	@RequestMapping(value="/first")
	public String First() {
		String resString =  service.GetIndividualString(input.inputStr1, input.originDic);
		String resString2 =  service.GetIndividualString(input.inputStr2, input.originDic);
		return resString + "  \\\\\\  " + resString2;
	}
	
	@RequestMapping(value="/second")
	public String Second() {
		String resString =  service.GetIndividualString(input.inputStr1, input.customDic);
		String resString2 =  service.GetIndividualString(input.inputStr2, input.customDic);
		return resString + "  \\\\\\  " + resString2;
	}
	
	@RequestMapping(value="/third")
	public String Three() {
		String[] combineDic = service.CombineInputDic(input.originDic, input.customDic); 
		String resString =  service.GetIndividualString(input.inputStr1, combineDic);
		String resString2 =  service.GetIndividualString(input.inputStr2, combineDic);
		return resString + "  \\\\\\  " + resString2;
	}
}
