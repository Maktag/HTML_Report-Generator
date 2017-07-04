package com.graph.plot;

//Reports are of two Types Version and without Version 
public class Reporter extends Status
{

	public void CreateReport(String FileName) 
		{
			float pass = PassPercent();
			float fail = FailPercent();
			float skip = SkipPercent();
			float error = ErrorPercent();
			
			TempFolderRecovery tr = new TempFolderRecovery();
			tr.Setup(FileName,FolderName);
			
			MyWebView mwv = new MyWebView();
			mwv.WebPage(pass, fail, skip, error, FolderName, FileName);
			
			Menu objMenu = new Menu();
			objMenu.PrepMenu();
			
			Index indObj = new Index(FileName);
			indObj.PrepIndex();
		}
	
	public void CreateReport(String FileName, String Version) 
		{
			float pass = PassPercent();
			float fail = FailPercent();
			float skip = SkipPercent();
			float error = ErrorPercent();
		
			TempFolderRecovery tr = new TempFolderRecovery();
			tr.Setup(FileName+Version,FolderName);
			
			MyWebView mwv = new MyWebView();
			mwv.WebPage(pass, fail, skip, error, FolderName, FileName, Version);
			
			Menu objMenu = new Menu();
			objMenu.PrepMenu();
			
			Index indObj = new Index(FileName+Version);
			indObj.PrepIndex();
		}
	
	public float PassPercent()
		{
			int total = Status.passCount+Status.failCount+Status.skipCount+Status.errorCount;
			float passpercent = 0;
			try {
				passpercent = Status.passCount*100/total;	
			} catch (Exception e) {
				System.out.println("Nothing run.");
			}
			//System.out.println("class PlotGraph "+passpercent);
			return passpercent;
		}
	
	public float FailPercent()
		{
			int total = Status.passCount+Status.failCount+Status.skipCount+Status.errorCount;
			float failpercent = 0;
			try {
				failpercent = Status.failCount*100/total;	
			} catch (Exception e) {
				System.out.println("Nothing run.");
			}
			//System.out.println("class PlotGraph "+failpercent);
			return failpercent;
		}
	
	public float SkipPercent()
		{
			int total = Status.passCount+Status.failCount+Status.skipCount+Status.errorCount;
			float skippercent = 0;
			try {
				skippercent = Status.skipCount*100/total;	
			} catch (Exception e) {
				System.out.println("Nothing run.");
			}
		  //System.out.println("class PlotGraph "+skippercent);
			return skippercent;
		}
	
	public float ErrorPercent()
		{
			int total = Status.passCount+Status.failCount+Status.skipCount+Status.errorCount;
			float errorpercent = 0;
			try {
				errorpercent = Status.errorCount*100/total;	
			} catch (Exception e) {
				System.out.println("Nothing run.");
			}
		  //System.out.println("class PlotGraph "+errorpercent);
			return errorpercent;
		}
	
	
}
