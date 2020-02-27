package com.example.demo2.service;

import org.springframework.stereotype.Service;

@Service
public interface StringService {

	public String GetIndividualString(String srcString, String[] dic);
	
	public String[] CombineInputDic(String[] originDic, String[] customDic);
}
