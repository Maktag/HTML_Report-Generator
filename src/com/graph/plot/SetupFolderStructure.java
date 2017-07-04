package com.graph.plot;

import java.io.File;

public class SetupFolderStructure 
{
	
//	This will create folder
	public void CreateNewFolder(String FolderName, String WhereToCreate)
	{
		File theDir = new File(WhereToCreate+"/"+FolderName);
//		System.out.println("This one "+WhereToCreate+"/"+FolderName);
		
		// if the directory does not exist, create it
		if (!theDir.exists()) {
//		    System.out.println("creating directory: " + theDir.getName() + " in "+ theDir.getAbsolutePath());
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        //handle it
		    }        
		    if(result) {    
//		        System.out.println("DIR created");  
		    }
		}
		else {
//			System.out.println("Dir already exist.");
		}
	}
	
}
