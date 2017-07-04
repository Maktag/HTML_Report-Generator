package com.graph.plot;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

public class Menu 
{

	public void PrepMenu()
    {
		String FolderName = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
		String FileName = "menu.html";
		String projectPath = System.getProperty("user.dir");
		
        try {
        	
        	//define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
            File folder = new File(projectPath+"/reports/"+FolderName);

    		File[] listOfFiles = folder.listFiles((FileFilter) FileFileFilter.FILE);


    		Arrays.sort(listOfFiles, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
    		
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  
		    	  if(!listOfFiles[i].getName().equalsIgnoreCase("menu.html") & !listOfFiles[i].getName().equalsIgnoreCase("index.html") & listOfFiles[i].getName().contains(".html"))
		    	  {  
		    		  htmlStringBuilder.append("<div style='width:98%; border: none; padding: 0px 0px; text-align: center; text-decoration: none;display: inline-block;font-size: 16px; margin: 4px 2px; cursor: pointer; border-bottom: 2px solid #27ae60;'><p style=' font-family: Montserrat, sans-serif; font-style: normal; font-weight: 400;padding-top: 0px; padding-left: 0px;'><a style='text-decoration: none; color:#27ae60; word-wrap: break-word; ' href='"+listOfFiles[i].getName()+"' target='iframe_a'>"+listOfFiles[i].getName().replaceAll(".html", "")+"</a></p></div>");
		    	  }
		      } else if (listOfFiles[i].isDirectory()) {
//		        System.out.println(listOfFiles[i].getName());
		      }
		    }
            
            
            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),FileName, FolderName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void WriteToFile(String fileContent, String fileName, String folderName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath+"/reports/"+folderName+"" + File.separator+fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
//        if (file.exists()) {
//            try {
//                File newFileName = new File(projectPath + File.separator+ "backup_"+fileName);
//                file.renameTo(newFileName);
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }
	
}
