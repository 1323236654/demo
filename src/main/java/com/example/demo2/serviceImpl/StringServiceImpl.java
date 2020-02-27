package com.example.demo2.serviceImpl;

import org.springframework.stereotype.Component;

import com.example.demo2.service.StringService;

@Component
public class StringServiceImpl implements StringService {

	@Override
	public String GetIndividualString(String srcString, String[] dic) {
		// TODO Auto-generated method stub
		String tempString = srcString;
		String resString = "";
		for(int i = 0; i < dic.length; i++) {
			if(dic[i] != null && srcString.indexOf(dic[i]) != -1) {
				String subString = srcString.substring(0, srcString.indexOf(dic[i])+dic[i].length());
				if(subString.equals(dic[i])) {
					resString += subString + " ";
					srcString = srcString.substring(subString.length());
				}else{
					resString +=  subString.substring(0, subString.lastIndexOf(dic[i])) + " ";
					resString +=  subString.substring(subString.lastIndexOf(dic[i])) + " ";
					srcString = srcString.substring(subString.length());
					//continue;
				}
			}
		}
		resString += "	 :	";
		srcString = tempString;
		String[] strArray = new String[srcString.length()];
		int count = 0;
		for(int i = dic.length - 1; i >= 0; i--) {
			if(dic[i] != null && srcString.indexOf(dic[i]) != -1) {
				String temString = srcString.substring(srcString.lastIndexOf(dic[i]));
				if(temString.equals(dic[i])) {
					strArray[count] = temString;
					count++;
					srcString = srcString.substring(0, srcString.lastIndexOf(dic[i]));
				}else {
					strArray[count++] = temString.substring(temString.lastIndexOf(dic[i])+dic[i].length());
					strArray[count++] = temString.substring(0, dic[i].length());
					srcString = srcString.substring(0, srcString.lastIndexOf(dic[i]));
					//continue;
				}
			}
		}
		for(int i = strArray.length - 1; i >= 0; i--) {
			if(strArray[i] != null) {
				resString += strArray[i] + " ";
			}
		}
		return resString;
	}

	@Override
	public String[] CombineInputDic(String[] originDic, String[] customDic) {
		// TODO Auto-generated method stub
		String[] resStrings = new String[originDic.length];
		int count = 0;
		for(int i = 0; i < originDic.length; i ++) {
			for(int j = 0; j < customDic.length; j ++) {
				if(originDic[i].contentEquals(customDic[j])) {
					resStrings[count] = originDic[i];
					count++;
				}
			}
		}
		return resStrings;
	}

}
