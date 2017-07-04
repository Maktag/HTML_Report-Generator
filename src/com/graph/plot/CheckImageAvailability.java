package com.graph.plot;

import java.io.File;

public class CheckImageAvailability 
{
	static String projectPath = System.getProperty("user.dir");
	
//	public static void main(String[] args) 
//		{		
//			System.out.println(CheckExistance(projectPath+"/reports/2017.06.18/SignUpTest/", "1"));
//		}
	
	public static boolean CheckExistance(String Location, String FileName)
	{
		boolean check = new File(projectPath+Location,FileName+".png").exists();
//		System.out.println(Location);
//		System.out.println(FileName+".png");
		return check;
	}
}
