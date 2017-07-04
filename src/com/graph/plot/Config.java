package com.graph.plot;

public class Config 
{
	
//	About the Project and Author
	public static String LogoPath; 
	public static String ProjectName;
	public static String AuthorName="Pradeep Tyagi";
	public static String OrganizationName;
	public static String OrganizationWebURL;
	public static String Designation;
	public static String AboutTheTesting;
	
//	Color codes for the Status of Test Cases
//	static String PassColor="";
//	static String FailColor="";
//	static String SkipColor="";
//	static String ErrorColor="";
//	static String ForYourInfo="";
	
//	About the Testing Environment
	static String OperationSystemName=System.getProperty("os.name");
	static String OperationSystemVersion=System.getProperty("os.version");
	static String BrowserName="";
	static String BrowserVersion="";
	

	static SetupFolderStructure SFS = new SetupFolderStructure();
	
	public static void main(String[] args) {
		SFS.CreateNewFolder("reports", System.getProperty("user.dir"));
	}
}
