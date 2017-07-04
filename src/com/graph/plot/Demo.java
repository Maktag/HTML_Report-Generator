package com.graph.plot;

public class Demo {
	
	
	//Mendatory for the report.
	static Status state= new Status();
	static Reporter report = new Reporter();
	
	public static void main(String[] args) 
	{
		//Basic details for the report.
		 Config.LogoPath="http://cdn.ndtv.com/tech/images/google_logo_redesign_2015_elements.png";//Local Path or URL of your logo. 
		 Config.ProjectName="Google Search";
		 Config.AuthorName="Pradeep Tyagi";
		 Config.OrganizationName="Google INC.";
		 Config.OrganizationWebURL="https://www.google.co.in/";
		 Config.Designation="Sr. Quality Engineer";
		 Config.AboutTheTesting="We are performing a very basic search test case in it.";
		 Config.main(null);
		 

		 //This is the event when the test case passes. 
		 state.PassCase("TC_ID_001", "Browser launched successfully.", true);
		 state.FailCase("TC_ID_002", "Search box element not found.", true);
		 state.SkipCase("TC_ID_003", "Skip search Test case.", true);
		 state.ErrorCase("Network error.", true);
		 state.InfoCase("This functionality is not working.", true);
		 
		 
		 //It will create the report with given version.
		 report.CreateReport("SignUpTest","v0.0.2");
	}

}
