package com.graph.plot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;

public class Index 
{

	private String defaultFile;

	public Index(String FileName) {
		this.defaultFile = FileName;
	}
	
	public void PrepIndex()
    {
		
		String FolderName = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
		String FileName = "Index.html";
		String projectPath = System.getProperty("user.dir");
        try {
        	
        	//define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
            File folder = new File(projectPath+"/reports/"+FolderName);
    		File[] listOfFiles = folder.listFiles();

    		 Arrays.sort(listOfFiles, Collections.reverseOrder());
    		 
    		 htmlStringBuilder.append("<!DOCTYPE html>");
    		 htmlStringBuilder.append("<html>");
    		 htmlStringBuilder.append("<head>");
    		 htmlStringBuilder.append("<meta charset='ISO-8859-1'>");
    		 htmlStringBuilder.append("<title>Report</title>");
    		 htmlStringBuilder.append("</head>");
    		 htmlStringBuilder.append("<style>");
    		 htmlStringBuilder.append(".cr{margin:-10px -10px 10px;");
    		 htmlStringBuilder.append("position: fixed;");
    		 htmlStringBuilder.append("height:20px; ");
    		 htmlStringBuilder.append("width:99%; ");
    		 htmlStringBuilder.append("background-color: #2196F3!important;");
    		 htmlStringBuilder.append("color: white;");
    		 htmlStringBuilder.append("font-family: Montserrat, sans-serif;");
    		 htmlStringBuilder.append("font-style: normal;");
    		 htmlStringBuilder.append("font-weight: 400;");
    		 htmlStringBuilder.append("-webkit-font-smoothing: antialiased;");
    		 htmlStringBuilder.append("-moz-osx-font-smoothing: grayscale;");
    		 htmlStringBuilder.append("float: left;");
    		 htmlStringBuilder.append("padding: 15px 15px;");
    		 htmlStringBuilder.append("font-size: 18px;");
    		 htmlStringBuilder.append("}");
    		 htmlStringBuilder.append("</style>");
    		 htmlStringBuilder.append("<body>");

    		 htmlStringBuilder.append("<div class='cr'> <a href='"+Config.OrganizationWebURL+"'> <img style='float:left;' src='"+Config.LogoPath+"' alt='Logo' height='30' width='80'>"
    		 		+ "<div style='float:left; margin-top: -15px; padding-left: 8px; color: white; font-family: Montserrat, sans-serif; font-style: normal; font-weight:400; -webkit-font-smoothing: antialiased; -moz-osx-font-smoothing: grayscale;'>"
    		 		+ "<p>"+Config.OrganizationName+"</p></div></a>"
    		 		+ "</div>");
    		 htmlStringBuilder.append("<div style='margin-top: 45px; position:fixed; width:100%;'>");
    		 htmlStringBuilder.append("<div  style=' width: 20%; float: left; color: white; font-family: Montserrat, sans-serif;'>");
    		 htmlStringBuilder.append("<div style='background-color: #27ae60; height:50px; width:98%; border: none;color: white; padding: 0px 0px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px; margin: 0px 0px;'>");
    		 htmlStringBuilder.append("<p style='font-family: Montserrat, sans-serif; font-style: normal; font-weight: 400; font-size: 18px; line-height: 1; -webkit-font-smoothing: antialiased; -moz-osx-font-smoothing: grayscale; padding-top: 0px; padding-left: 0px;'>Tests</p>");
    		 htmlStringBuilder.append("</div>");
    		 htmlStringBuilder.append("<iframe style='width: 100%; height: 83vh; border: none;text-decoration: none;' src='menu.html'></iframe>");
    		 htmlStringBuilder.append("</div>");
    		 if (listOfFiles.length>2) 
    		 {
    		 	 htmlStringBuilder.append("<iframe id='demo' style='width: 79%; height: 91vh; border: none;text-decoration: none;' src='"+defaultFile+".html"+"' name='iframe_a'></iframe>");
    		 }
    		 else {
//    			 htmlStringBuilder.append("<iframe id='demo' style='width: 79%; height: 91vh; border: none;text-decoration: none;' src='"+listOfFiles[1].getName()+"' name='iframe_a'></iframe>");
//    			 System.out.println("This is less than 2 condition.");
    		 }
    		 
    		 htmlStringBuilder.append("</div>");
    		 htmlStringBuilder.append("</body>");
    		 htmlStringBuilder.append("</html>");
    		 
    		 
    		 
    		 
    		 
                       
            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),FileName, FolderName);
            System.out.println("#--------------------------------Now you can access your project report.--------------------------#");
            System.out.println("#-------------------------Go to reports-> Select date folder-> index.html.------------------------#");
            System.out.println("#-----------Please refresh your project, if you are trying to open report from your IDE.----------#");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void WriteToFile(String fileContent, String fileName, String folderName) throws IOException {
        String projectPath = System.getProperty("user.dir");
//        String tempFile = projectPath+"/reports" + File.separator+fileName;
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
