package com.graph.plot;

import java.io.File;

public class TempFolderRecovery 
{	
		
		public void Setup(String FolderName, String Location) {
        	
			String projectPath = System.getProperty("user.dir");

			File folder = new File(projectPath+"/reports/"+Location+"/");
			
			File oldName = new File(folder+"/_img");
		    File newName = new File(folder+"/"+FolderName);
			
//		    System.out.println(oldName);
//		    System.out.println(newName);		    

			File[] listOfFiles = folder.listFiles();
			
    		for (int i = 0; i < listOfFiles.length; i++) {
    			if (listOfFiles[i].isDirectory()) {
					
    				if (listOfFiles[i].getName().equalsIgnoreCase(FolderName)) {
//						System.out.println("Folder with "+FolderName+" already exist.");
						deleteDir(newName);
						
						if(oldName.renameTo(newName)) {
//					         System.out.println("renamed");
					         
					      } else {
//					         System.out.println("Error");
					      }
						
						}

//    				System.out.println(listOfFiles[i].getName());	
					if (listOfFiles[i].getName().equalsIgnoreCase("_img")) {
//						System.out.println(listOfFiles[i].getName());
						 if(oldName.renameTo(newName)) {
//					         System.out.println("renamed");
					         
					      } else {
//					         System.out.println("Error");
					      }
						
//						System.out.println();
					}
				}
    			else{
    			
    			}
			}
		}

		void deleteDir(File file) {
		    File[] contents = file.listFiles();
		    if (contents != null) {
		        for (File f : contents) {
		            deleteDir(f);
		        }
		    }
		    file.delete();
		}
}