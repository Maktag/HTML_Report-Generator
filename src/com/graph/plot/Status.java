package com.graph.plot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Status {
	
	
	//This is the name of a folder in which the reports will get saved. Name will be execution Date.
	String FolderName = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	
	//It will check that the folder is exist in which the file will get created.
	SetupFolderStructure SFS = new SetupFolderStructure();
	
	//Save Screen Shot class call
	SaveScreenShot SSS = new SaveScreenShot();
	
	public Status()
		{	
			Config.main(null);
		
			SFS.CreateNewFolder(FolderName, "reports");
			
			SFS.CreateNewFolder("_img", "reports/"+FolderName);
			
		}
	
	static int passCount = 0;
	static int failCount = 0;
	static int skipCount = 0;
	static int errorCount = 0;
	static int infoCount = 0;
		
	static ArrayList<Object> AllCommentList = new ArrayList<>();	
	static ArrayList<String> PassCommentlist = new ArrayList<>();
	static ArrayList<String> FailCommentlist = new ArrayList<>();
	static ArrayList<String> SkipCommentlist = new ArrayList<>();
	static ArrayList<String> ErrorCommentlist = new ArrayList<>();
	static ArrayList<String> InfoCommentlist = new ArrayList<>();
	
	static ArrayList<Object> TestCaseIdCommentList = new ArrayList<>();
	static ArrayList<String> PassTestCaseIdlist = new ArrayList<>();
	static ArrayList<String> FailTestCaseIdlist = new ArrayList<>();
	static ArrayList<String> SkipTestCaseIdlist = new ArrayList<>();

	public ArrayList<Object> GetTestCaseIdList()
	{
		TestCaseIdCommentList.add(PassTestCaseIdlist);
		TestCaseIdCommentList.add(FailTestCaseIdlist);
		TestCaseIdCommentList.add(SkipTestCaseIdlist);
		
		return TestCaseIdCommentList;
	}
	
	public ArrayList<Object> GetCommentList()
	{
		AllCommentList.add(PassCommentlist);
		AllCommentList.add(FailCommentlist);
		AllCommentList.add(SkipCommentlist);
		AllCommentList.add(ErrorCommentlist);
		AllCommentList.add(InfoCommentlist);
		
		return AllCommentList;

//		System.out.println("Pass comments are:"+AllCommentList.get(0));
//		System.out.println("Fail comments are:"+AllCommentList.get(1));
//		System.out.println("Skip comments are:"+AllCommentList.get(2));
//		System.out.println("Error comments are:"+AllCommentList.get(3));
//		System.out.println("Info comments are:"+AllCommentList.get(4));
//		
//		ArrayList<Object> alist = (ArrayList<Object>) AllCommentList.get(0);
//		System.out.println(alist);
//		for (int i = 0; i < alist.size(); i++) {
//			System.out.println(alist.get(i));
//		}
	}
	
    public void PassCase(String TestCaseId, String Comment, Boolean Variable) {
    	  passCount++;
    	  PassCommentlist.add(Comment);
    	  PassTestCaseIdlist.add(TestCaseId);
    	  
    	  
    	  if (Variable) 
    	  {
    		  try {
				SSS.captureScreen("reports/"+FolderName+"/_img/"+TestCaseId+".png");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  }
    	  
    }

    public void FailCase(String TestCaseId, String Comment, Boolean Variable) {
  	  	  failCount++;
  	  	  FailCommentlist.add(Comment);
  	  	  FailTestCaseIdlist.add(TestCaseId);
    	  if (Variable) 
    	  {
    		  try {
				SSS.captureScreen("reports/"+FolderName+"/_img/"+TestCaseId+".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	  }
    }
    
    public void SkipCase(String TestCaseId, String Comment, Boolean Variable) {
  	      skipCount++;
  	      SkipCommentlist.add(Comment);
  	      SkipTestCaseIdlist.add(TestCaseId);
    	  if (Variable) 
    	  {
    		  try {
				SSS.captureScreen("reports/"+FolderName+"/_img/"+TestCaseId+".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	  }
    }
    
    public void ErrorCase(String Comment, Boolean Variable) {
  	      errorCount++;
  	      ErrorCommentlist.add(Comment);
    	  if (Variable) 
    	  {
    		  try {
				SSS.captureScreen("reports/"+FolderName+"/_img/error"+errorCount+".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	  }
    }
    
    public void InfoCase(String Comment, Boolean Variable) {
		infoCount++;  
    	InfoCommentlist.add(Comment);
  	  if (Variable) 
  	  { 
  		  try {
				SSS.captureScreen("reports/"+FolderName+"/_img/info"+infoCount+".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
  	  }
    }
    

}
