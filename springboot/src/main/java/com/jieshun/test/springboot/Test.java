package com.jieshun.test.springboot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	protected static String readTxtFile(String path) {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder();
		
		try{
			File file = new File(path);
			if(file.isFile() && file.exists()){
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null ;
				while((lineTxt = br.readLine()) != null){
					if(!isNumber(lineTxt)){
						result.append(lineTxt+"\n");
					}
				}
				br.close();
			}else{
				System.out.println("文件不存在。");
			}
		}catch(Exception e){
			System.out.println("文件读取错误。");
		}
		return result.toString();
	}


	public static boolean isNumber(String str){
		Pattern pattern = Pattern.compile("^(\\d+)(.*)");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {//数字开头
			
			return true;
			
		}
		return false;
	}

	
//	public static void main(String[] args) {
//		
//		//System.out.println(readTxtFile("F:\\宁化东测试\\C-M5314684058-1.txt"));
//		Test t = new Test();
//		while (true){
//			try {
//				System.out.println("--------------------");
//				t.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		}
//	}
}
