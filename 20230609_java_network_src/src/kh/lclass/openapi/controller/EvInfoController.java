package kh.lclass.openapi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import kh.lclass.openapi.model.service.EvInfoService;

public class EvInfoController {
	public void getEvIfoAll() {
		EvInfoService service = new EvInfoService();
		service.start();

//		byte[] barr = new byte[1000];
//		String a = new String(barr);
//		
//		String str = new String("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList");
//		str +="?serviceKey=VAARBT4XyaVP%2FNXilJAmNADcc%2FQ4NcYxp0Io6XZM%2F49Ui%2Ft0IKsVC4gLxbjPyt%2BxTqAWdWUnYI0SHk1OAUNg3A%3D%3D";
//		str +="&pageNo=1";
//		str += "&numOfRows=10";
//		str +="&addr"+URLEncoder.encode("전라남도 나주시 빛가람동 120","UTF-8");
//		System.out.println(str);
//		System.out.println("======================");
		
	}
}
		


