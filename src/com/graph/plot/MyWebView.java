package com.graph.plot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;


public class MyWebView extends Status
{
	static String ModuleName = "";
	static String ProjectName = "";
	
	public void WebPage(Float Pass, Float Fail, Float Skip, Float Error, String FolderName, String Filename)
    {
		
		GetCommentList().get(0);
		
		@SuppressWarnings("unchecked")
		ArrayList<Object> PassList = (ArrayList<Object>) GetCommentList().get(0);
		@SuppressWarnings("unchecked")
		ArrayList<Object> FailList = (ArrayList<Object>) GetCommentList().get(1);
		@SuppressWarnings("unchecked")
		ArrayList<Object> SkipList = (ArrayList<Object>) GetCommentList().get(2);
		@SuppressWarnings("unchecked")
		ArrayList<Object> ErrorList = (ArrayList<Object>) GetCommentList().get(3);
		@SuppressWarnings("unchecked")
		ArrayList<Object> InfoList = (ArrayList<Object>) GetCommentList().get(4);
		
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Object> PassIdsList = (ArrayList<Object>) GetTestCaseIdList().get(0);
		@SuppressWarnings("unchecked")
		ArrayList<Object> FailIdsList = (ArrayList<Object>) GetTestCaseIdList().get(1);
		@SuppressWarnings("unchecked")
		ArrayList<Object> SkipIdsList = (ArrayList<Object>) GetTestCaseIdList().get(2);
		
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
//		This the name of the report file. 
//		String FileName = timeStamp+""+ModuleName+".html";
		String FileName = Filename+".html";
//		HTMLtags.FeedImage(Filename);
		
        try {
        	
        	//define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
        	
        	htmlStringBuilder.append("<!DOCTYPE html> <html lang='en'> <head> <title>MyWebView</title> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1'> "
        			+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'> "
        			+ "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>"
        			+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script> "
        			+ "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script> "  			
        			+ "<style> /* Remove the navbar's default margin-bottom and rounded borders */ "
        			+ ".navbar { margin-bottom: 0; border-radius: 0; } "
        			+ "/* Set height of the grid so .sidenav can be 100% (adjust as needed) */ .row.content {height: 450px} "
        			+ "/* Set gray background color and 100% height */ .sidenav { padding-top: 20px; background-color: #ffffff; height: 100%; border-right: 2.5px #2196F3 solid; } "
        			+ "/* Set black background color, white text and some padding */ footer { background-color: #555; color: white; padding: 15px; } "
        			+ "/* On small screens, set height to 'auto' for sidenav and grid */ @media screen and (max-width: 767px) { .sidenav { height: auto; padding: 15px; } .row.content {height:auto;} } "
        			+ "body { position: relative; } "
        			+ "#section1 {padding-top:20px; color: #fff; background-color: #3498db;} "
        			+ "#section2 {padding-top:20px; color: #fff; background-color: #e74c3c;} "
        			+ "#section3 {padding-top:20px; color: #fff; background-color: #f1c40f;} "
        			+ "#section4 {padding-top:20px; color: #fff; background-color: #c0392b;} "
        			+ "#section5 {padding-top:20px; color: #fff; background-color: #009688;} "
    
        			+ ".imgnav { height: 100%; width: 0; position: fixed; z-index: 1; top: 0; left: 0; background-color: #111; overflow-x: hidden; transition: 0.5s; padding-top: 60px; text-align:center; } "
        			+ ".imgnav a { padding: 8px 8px 8px 32px; text-decoration: none; font-size: 25px; color: #818181; display: block; transition: 0.3s; } "
        			+ ".imgnav a:hover{ color: #f1f1f1; } "
        			+ ".imgnav .closebtn { position: absolute; top: 0; right: 25px; font-size: 36px; margin-left: 50px; } "
        			+ "@media screen and (max-height: 450px) { .imgnav {padding-top: 15px;} .imgnav a {font-size: 18px;} } "
        			
        			
        			+ "</style> "
        			
        			+ "<script> function OpenImage(src) { document.getElementById('myimgnav').style.width = '100%'; document.getElementById('one').src = src; }"
        			+ "function closeNav() { document.getElementById('myimgnav').style.width = '0'; } </script>"
        			
        			+ "</head> "
        			+ "<body> "
        			
        			+ "<div id='myimgnav' class='imgnav' onclick='closeNav()'> <a href='javascript:void(0)' class='closebtn' onclick='closeNav()'>&times;</a> <img id='one' src='' class='img-rounded' alt='ScreenShot' style='max-width:100%; height:auto'> </div>"
        			
        			+ "<nav class='navbar navbar-inverse' style='background-color: #2196F3!important; border: none;'> "
        			+ "<div class='container-fluid'> "
        			+ "<div class='navbar-header'> "
        			+ "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#myNavbar'> "
        			+ "<span class='icon-bar'></span> "
        			+ "<span class='icon-bar'></span> "
        			+ "<span class='icon-bar'></span> "
        			+ "</button> <a class='navbar-brand glyphicon' style='color: white; font-family: Montserrat, sans-serif; cursor:default;' href='#'>"
        			+ Config.ProjectName+"</a> "
        			+ "</div> "
        			+ "</div> "
        			+ "</nav> "
        			+ "<div class='container-fluid text-center'> "
        			+ "<div class='row content'> ");
        	
        	htmlStringBuilder.append("<div style='padding-right:50px; padding-left:50px; width:100%;' class='col-sm-10 text-left'> "
        			+ "<div style='box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);transition: 0.3s;width: 100%; margin-bottom: 20px;margin-top: 20px;'><div style='padding: 2px 16px;'>"
//        			+ "<h4><b>"+Config.ProjectName+"</b></h4>"
					+ "<h4><b>About:</b></h4>"
					+ "<p>"+Config.AuthorName+"</p>"
        			+ "<p>"+Config.OrganizationName+"</p>"
        			+ "<p>"+Config.Designation+"</p>"
        			+ "<p>"+Config.AboutTheTesting+"</p>"
        			
        			+ "<h4><b>Environment:</b></h4>"
        			+ "<p> <b>OS Name:</b> "+Config.OperationSystemName+"</p>"
        			+ "<p> <b>OS Version:</b> "+Config.OperationSystemVersion+"</p>"
        			
        			+ "</div>"
        			+ "</div>"
        			+ "<p>Status bars:</p> "

        			+ "<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='40' aria-valuemin='0' aria-valuemax='100' style='background-color: #3498db; width:"+Pass+"%'> "+Pass+" % Pass (success)</div> </div> "
        			+ "<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='50' aria-valuemin='0' aria-valuemax='100' style='background-color: #e74c3c; width:"+Fail+"%'> "+Fail+"% %Fail (failure) </div> </div> "
        			+ "<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='60' aria-valuemin='0' aria-valuemax='100' style='background-color: #f1c40f; width:"+Skip+"%'> "+Skip+"% Skip (warning) </div> </div> "
        			+ "<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='70' aria-valuemin='0' aria-valuemax='100' style='background-color: #c0392b; width:"+Error+"%'> "+Error+"% Error (danger) </div> </div> "
        			+ "</div> "
        			+ "</div> "
        			+ "</div> "
        			+ "<div> "
        			+ "<nav class='navbar navbar-inverse '> "
        			+ "<div class='container-fluid'> "
        			+ "<div class='navbar-header'> "
        			+ "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#myNavbar'> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a class='navbar-brand' href='#'>Details of Execution</a> </div> "
        			+ "<div> <div class='collapse navbar-collapse' id='myNavbar'> <ul class='nav navbar-nav'> "
        			+ "<li><a href='#section1'>Pass</a></li> "
        			+ "<li><a href='#section2'>Fail</a></li> "
        			+ "<li><a href='#section3'>Skip</a></li> "
        			+ "<li><a href='#section4'>Error</a></li> "
        			+ "<li><a href='#section5'>Info</a></li> "
        			+ "</ul> "
        			+ "</div> "
        			+ "</div> "
        			+ "</div> "
        			+ "</nav> "
        			+ "</div> "
        			+ "<div id='section1' class='container-fluid'> "
	        		+"<div><i class='fa fa-check' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
        				+ "<h4> Pass Scenarios</h4></div> "
		        			+ "<table class='table'> "
			        			+ "<thead> "
			        			+ "<tr> "
			        			+ "<th style='width: 2px;'>TC Id</th> "
			        			+ "<th>Description</th> "
			        			+ "</tr> "
			        			+ "</thead> "
				        			+ "<tbody> ");
				        			
					    		for (int i = 0; i < PassList.size(); i++) {
					    		  //System.out.println(PassList.get(i));
					    			htmlStringBuilder.append("<tr> "
						        			+ "<td>"+PassIdsList.get(i)+"</td> "
						        			+ "<td>"+PassList.get(i));
						        			
						        			if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename,PassIdsList.get(i).toString())) 
						        			{
						        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+"/"+PassIdsList.get(i).toString()+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
											}
						        			else
						        			{
						        				
						        			}
						        			htmlStringBuilder.append( "</tr> ");
					    		}	
        						
					    		if (PassList.size()==0) {
			        				htmlStringBuilder.append("<tr> "
						        			+ "<td></td> "
						        			+ "<td>No Record Found.</td> "
						        			+ "</tr> ");
								}
				        			
				        			htmlStringBuilder.append( "</tbody> "
	        			+ "</table> "
        			+ "</div> "
        			+ "<div id='section2' class='container-fluid'> "
        			+"<div><i class='fa fa-bug' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
	        			+ "<h4>Fail Scenarios</h4></div> "
	        			+ "<table class='table'> "
		        			+ "<thead> "
		        			+ "<tr> "
		        			+ "<th style='width: 3px;'>TC Id</th> "
		        			+ "<th>Description</th> "
		        			+ "</tr> "
		        			+ "</thead> "
			        			+ "<tbody> ");
		        			
				        			for (int i = 0; i < FailList.size(); i++) {
							    		  //System.out.println(FailList.get(i));
							    			htmlStringBuilder.append("<tr> "
								        			+ "<td>"+FailIdsList.get(i)+"</td> "
								        			+ "<td>"+FailList.get(i));
							    			if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename,FailIdsList.get(i).toString())) 
						        			{
						        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+"/"+FailIdsList.get(i).toString()+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
											}
						        			else
						        			{
						        				
						        			}
						        			htmlStringBuilder.append( "</tr> ");
								        			
							    		}
				        			
				        			if (FailList.size()==0) {
				        				htmlStringBuilder.append("<tr> "
							        			+ "<td></td> "
							        			+ "<td>No Record Found.</td> "
							        			+ "</tr> ");
									}
			        			
			        			htmlStringBuilder.append("</tbody> "
			        	+ "</table> "
        			+ "</div> "
	        		+ "<div id='section3' class='container-fluid'> "
	        		+"<div><i class='fa fa-random' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
	        			+ "<h4> Skip Scenarios</h4> </div>"
	        			+ "<table class='table'> "
		        			+ "<thead> "
		        			+ "<tr> "
		        			+ "<th style='width: 2px;'>TC Id</th> "
		        			+ "<th>Description</th> "
		        			+ "</tr> "
		        			+ "</thead> "
			        			+ "<tbody> ");
		        			
			        			
			        			for (int i = 0; i < SkipList.size(); i++) {
						    		  //System.out.println(SkipList.get(i));
						    			htmlStringBuilder.append("<tr> "
							        			+ "<td>"+SkipIdsList.get(i)+"</td> "
							        			+ "<td>"+SkipList.get(i));
						    			if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename,SkipIdsList.get(i).toString())) 
					        			{
					        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+"/"+SkipIdsList.get(i).toString()+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
										}
					        			else
					        			{
					        				
					        			}
					        			htmlStringBuilder.append( "</tr> ");
			        			}		
			        			
			        			if (SkipList.size()==0) {
			        				htmlStringBuilder.append("<tr> "
						        			+ "<td></td> "
						        			+ "<td>No Record Found.</td> "
						        			+ "</tr> ");
								}
			        			
			        htmlStringBuilder.append("</tbody> "
			        	+ "</table> "
        			+ "</div> "
        			+ "<div id='section4' class='container-fluid'> "
        			+"<div><i class='fa fa-remove' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
        			+ "<h4> Error Scenarios</h4></div> "
        			+ "<table class='table'> "
	        			+ "<thead> "
	        			+ "<tr> "
	        			+ "<th style='width: 2px;'>S.No</th> "
	        			+ "<th>Description</th> "
	        			+ "</tr> "
	        			+ "</thead> "
		        			+ "<tbody> ");
	        			
		        			for (int i = 0; i < ErrorList.size(); i++) {
					    		  //System.out.println(ErrorList.get(i));
					    			int Elist = i+1;
					    			String ElistId = Integer.toString(Elist);
		        					htmlStringBuilder.append("<tr> "
						        			+ "<td>"+ElistId+"</td> "
						        			+ "<td>"+ErrorList.get(i));
		        					
		        					if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename,"error"+ElistId)) 
				        			{
				        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+"/"+"error"+ElistId+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
									}
				        			else
				        			{
				        				
				        			}
				        			htmlStringBuilder.append( "</tr> ");
		        					
					    		}
		        		
		        			if (ErrorList.size()==0) {
		        				htmlStringBuilder.append("<tr> "
					        			+ "<td></td> "
					        			+ "<td>No Record Found.</td> "
					        			+ "</tr> ");
							}
		        			
		        	htmlStringBuilder.append("</tbody> "
		        	+ "</table> "
		        	+ "</div> "
		        	+ "<div id='section5' class='container-fluid'> "
		        	+"<div><i class='fa fa-info' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
        			+ "<h4> Info Scenarios</h4></div> "
        			+ "<table class='table'> "
	        			+ "<thead> "
	        			+ "<tr> "
	        			+ "<th style='width: 2px;'>S.No</th> "
	        			+ "<th>Description</th> "
	        			+ "</tr> "
	        			+ "</thead> "
		        			+ "<tbody> ");
	        			
		        	
		        			for (int i = 0; i < InfoList.size(); i++) {
					    		  //System.out.println(InfoList.get(i));
		        				int Ilist= i+1;
		        				String IlistId= Integer.toString(Ilist);
					    			htmlStringBuilder.append("<tr>"
						        			+ "<td>"+IlistId+"</td>"
						        			+ "<td>"+InfoList.get(i));
					    			if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename,"info"+IlistId)) 
				        			{
				        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+"/"+"info"+IlistId+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
									}
				        			else
				        			{
				        				
				        			}
				        			htmlStringBuilder.append( "</tr> ");
					    		}
		        		
		        			if (InfoList.size()==0) {
		        				htmlStringBuilder.append("<tr> "
					        			+ "<td></td> "
					        			+ "<td>No Record Found.</td> "
					        			+ "</tr> ");
							}
		        			
		        			
		        			htmlStringBuilder.append("</tbody> "
		        	+ "</table> "
		        	+ "</div> "
        			+ "<footer class='container-fluid text-center'> <p>Footer Text</p> </footer> </body> </html>");

            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),FileName, FolderName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void WebPage(Float Pass, Float Fail, Float Skip, Float Error, String FolderName, String Filename, String Version)
    {
		
		GetCommentList().get(0);
		
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Object> PassList = (ArrayList<Object>) GetCommentList().get(0);
		@SuppressWarnings("unchecked")
		ArrayList<Object> FailList = (ArrayList<Object>) GetCommentList().get(1);
		@SuppressWarnings("unchecked")
		ArrayList<Object> SkipList = (ArrayList<Object>) GetCommentList().get(2);
		@SuppressWarnings("unchecked")
		ArrayList<Object> ErrorList = (ArrayList<Object>) GetCommentList().get(3);
		@SuppressWarnings("unchecked")
		ArrayList<Object> InfoList = (ArrayList<Object>) GetCommentList().get(4);
		
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Object> PassIdsList = (ArrayList<Object>) GetTestCaseIdList().get(0);
		@SuppressWarnings("unchecked")
		ArrayList<Object> FailIdsList = (ArrayList<Object>) GetTestCaseIdList().get(1);
		@SuppressWarnings("unchecked")
		ArrayList<Object> SkipIdsList = (ArrayList<Object>) GetTestCaseIdList().get(2);
		
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
//		This the name of the report file. 
//		String FileName = timeStamp+""+ModuleName+".html";
		String FileName = Filename+Version+".html";
		
        try {
        	
        	//define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
        	
        	htmlStringBuilder.append("<!DOCTYPE html> <html lang='en'> <head> <title>MyWebView</title> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1'> "
        			+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'> "
        			+ "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>"
        			+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script> "
        			+ "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script> "  			
        			+ "<style> /* Remove the navbar's default margin-bottom and rounded borders */ "
        			+ ".navbar { margin-bottom: 0; border-radius: 0; } "
        			+ "/* Set height of the grid so .sidenav can be 100% (adjust as needed) */ .row.content {height: 450px} "
        			+ "/* Set gray background color and 100% height */ .sidenav { padding-top: 20px; background-color: #ffffff; height: 100%; border-right: 2.5px #2196F3 solid; } "
        			+ "/* Set black background color, white text and some padding */ footer { background-color: #555; color: white; padding: 15px; } "
        			+ "/* On small screens, set height to 'auto' for sidenav and grid */ @media screen and (max-width: 767px) { .sidenav { height: auto; padding: 15px; } .row.content {height:auto;} } "
        			+ "body { position: relative; } "
        			+ "#section1 {padding-top:20px; color: #fff; background-color: #3498db;} "
        			+ "#section2 {padding-top:20px; color: #fff; background-color: #e74c3c;} "
        			+ "#section3 {padding-top:20px; color: #fff; background-color: #f1c40f;} "
        			+ "#section4 {padding-top:20px; color: #fff; background-color: #c0392b;} "
        			+ "#section5 {padding-top:20px; color: #fff; background-color: #009688;} "
    
        			+ ".imgnav { height: 100%; width: 0; position: fixed; z-index: 1; top: 0; left: 0; background-color: #111; overflow-x: hidden; transition: 0.5s; padding-top: 60px; text-align:center; } "
        			+ ".imgnav a { padding: 8px 8px 8px 32px; text-decoration: none; font-size: 25px; color: #818181; display: block; transition: 0.3s; } "
        			+ ".imgnav a:hover{ color: #f1f1f1; } "
        			+ ".imgnav .closebtn { position: absolute; top: 0; right: 25px; font-size: 36px; margin-left: 50px; } "
        			+ "@media screen and (max-height: 450px) { .imgnav {padding-top: 15px;} .imgnav a {font-size: 18px;} } "
        			
        			
        			+ "</style> "
        			
        			+ "<script> function OpenImage(src) { document.getElementById('myimgnav').style.width = '100%'; document.getElementById('one').src = src; }"
        			+ "function closeNav() { document.getElementById('myimgnav').style.width = '0'; } </script>"
        			
        			+ "</head> "
        			+ "<body> "
        			
        			+ "<div id='myimgnav' class='imgnav' onclick='closeNav()'> <a href='javascript:void(0)' class='closebtn' onclick='closeNav()'>&times;</a> <img id='one' src='' class='img-rounded' alt='Screen Shot' style='max-width:100%; height:auto'> </div>"
        			
        			+ "<nav class='navbar navbar-inverse' style='background-color: #2196F3!important; border: none;'> "
        			+ "<div class='container-fluid'> "
        			+ "<div class='navbar-header'> "
        			+ "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#myNavbar'> "
        			+ "<span class='icon-bar'></span> "
        			+ "<span class='icon-bar'></span> "
        			+ "<span class='icon-bar'></span> "
        			+ "</button> <a class='navbar-brand glyphicon' style='color: white; font-family: Montserrat, sans-serif; cursor:default;' href='#'>"
        			+ Config.ProjectName+"</a> "
        			+ "</div> "
        			+ "</div> "
        			+ "</nav> "
        			+ "<div class='container-fluid text-center'> "
        			+ "<div class='row content'> ");
        	
        	htmlStringBuilder.append("<div style='padding-right:50px; padding-left:50px; width:100%;' class='col-sm-10 text-left'> "
        			+ "<div style='box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);transition: 0.3s;width: 100%;margin-bottom: 20px;margin-top: 20px;'><div style='padding: 2px 16px;'>"
//        			+ "<h4><b>"+Config.ProjectName+"</b></h4>"
					+ "<h4><b>About:</b></h4>"
        			+ "<p>"+Config.AuthorName+"</p>"
        			+ "<p>"+Config.OrganizationName+"</p>"
        			+ "<p>"+Config.Designation+"</p>"
        			+ "<p>"+Config.AboutTheTesting+"</p>"
        			
        			+ "<h4><b>Environment:</b></h4>"
        			+ "<p> <b>OS Name:</b> "+Config.OperationSystemName+"</p>"
        			+ "<p> <b>OS Version:</b> "+Config.OperationSystemVersion+"</p>"
        			
        			+ "</div>"
        			+ "</div>"
        			+ "<p>Status bars:</p> "
        			+ "<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='40' aria-valuemin='0' aria-valuemax='100' style='background-color: #3498db; width:"+Pass+"%'> "+Pass+" % Pass (success)</div> </div> "
        			+ "<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='50' aria-valuemin='0' aria-valuemax='100' style='background-color: #e74c3c; width:"+Fail+"%'> "+Fail+"% %Fail (failure) </div> </div> "
        			+ "<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='60' aria-valuemin='0' aria-valuemax='100' style='background-color: #f1c40f; width:"+Skip+"%'> "+Skip+"% Skip (warning) </div> </div> "
        			+ "<div class='progress'> <div class='progress-bar' role='progressbar' aria-valuenow='70' aria-valuemin='0' aria-valuemax='100' style='background-color: #c0392b; width:"+Error+"%'> "+Error+"% Error (danger) </div> </div> "
        			+ "</div> "
        			+ "</div> "
        			+ "</div> "
        			+ "<div> "
        			+ "<nav class='navbar navbar-inverse '> "
        			+ "<div class='container-fluid'> "
        			+ "<div class='navbar-header'> "
        			+ "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#myNavbar'> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a class='navbar-brand' href='#'>Details of Execution</a> </div> "
        			+ "<div> <div class='collapse navbar-collapse' id='myNavbar'> <ul class='nav navbar-nav'> "
        			+ "<li><a href='#section1'>Pass</a></li> "
        			+ "<li><a href='#section2'>Fail</a></li> "
        			+ "<li><a href='#section3'>Skip</a></li> "
        			+ "<li><a href='#section4'>Error</a></li> "
        			+ "<li><a href='#section5'>Info</a></li> "
        			+ "</ul> "
        			+ "</div> "
        			+ "</div> "
        			+ "</div> "
        			+ "</nav> "
        			+ "</div> "
        			+ "<div id='section1' class='container-fluid'> "
	        		+"<div><i class='fa fa-check' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
        				+ "<h4> Pass Scenarios</h4></div> "
		        			+ "<table class='table'> "
			        			+ "<thead> "
			        			+ "<tr> "
			        			+ "<th style='width: 2px;'>TC Id</th> "
			        			+ "<th>Description</th> "
			        			+ "</tr> "
			        			+ "</thead> "
				        			+ "<tbody> ");
				        			
					    		for (int i = 0; i < PassList.size(); i++) {
					    		  //System.out.println(PassList.get(i));
					    			htmlStringBuilder.append("<tr> "
						        			+ "<td>"+PassIdsList.get(i)+"</td> "
						        			+ "<td>"+PassList.get(i));
						        			
						        			if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename+Version,PassIdsList.get(i).toString())) 
						        			{
						        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+Version+"/"+PassIdsList.get(i).toString()+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
//						        				System.out.println("src='"+Filename+Version+"/"+PassIdsList.get(i).toString()+".png");
						        			}
						        			else
						        			{
						        				
						        			}
						        			htmlStringBuilder.append( "</tr> ");
					    		}	
        						
					    		if (PassList.size()==0) {
			        				htmlStringBuilder.append("<tr> "
						        			+ "<td></td> "
						        			+ "<td>No Record Found.</td> "
						        			+ "</tr> ");
								}
				        			
				        			htmlStringBuilder.append( "</tbody> "
	        			+ "</table> "
        			+ "</div> "
        			+ "<div id='section2' class='container-fluid'> "
        			+"<div><i class='fa fa-bug' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
	        			+ "<h4>Fail Scenarios</h4></div> "
	        			+ "<table class='table'> "
		        			+ "<thead> "
		        			+ "<tr> "
		        			+ "<th style='width: 3px;'>TC Id</th> "
		        			+ "<th>Description</th> "
		        			+ "</tr> "
		        			+ "</thead> "
			        			+ "<tbody> ");
		        			
				        			for (int i = 0; i < FailList.size(); i++) {
							    		  //System.out.println(FailList.get(i));
							    			htmlStringBuilder.append("<tr> "
								        			+ "<td>"+FailIdsList.get(i)+"</td> "
								        			+ "<td>"+FailList.get(i));
							    			if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename+Version,FailIdsList.get(i).toString())) 
						        			{
						        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+Version+"/"+FailIdsList.get(i).toString()+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
											}
						        			else
						        			{
						        				
						        			}
						        			htmlStringBuilder.append( "</tr> ");
								        			
							    		}
				        			
				        			if (FailList.size()==0) {
				        				htmlStringBuilder.append("<tr> "
							        			+ "<td></td> "
							        			+ "<td>No Record Found.</td> "
							        			+ "</tr> ");
									}
			        			
			        			htmlStringBuilder.append("</tbody> "
			        	+ "</table> "
        			+ "</div> "
	        		+ "<div id='section3' class='container-fluid'> "
	        		+"<div><i class='fa fa-random' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
	        			+ "<h4> Skip Scenarios</h4> </div>"
	        			+ "<table class='table'> "
		        			+ "<thead> "
		        			+ "<tr> "
		        			+ "<th style='width: 2px;'>TC Id</th> "
		        			+ "<th>Description</th> "
		        			+ "</tr> "
		        			+ "</thead> "
			        			+ "<tbody> ");
		        			
			        			
			        			for (int i = 0; i < SkipList.size(); i++) {
						    		  //System.out.println(SkipList.get(i));
						    			htmlStringBuilder.append("<tr> "
							        			+ "<td>"+SkipIdsList.get(i)+"</td> "
							        			+ "<td>"+SkipList.get(i));
						    			if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename+Version,SkipIdsList.get(i).toString())) 
					        			{
					        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+Version+"/"+SkipIdsList.get(i).toString()+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
										}
					        			else
					        			{
					        				
					        			}
					        			htmlStringBuilder.append( "</tr> ");
			        			}		
			        			
			        			if (SkipList.size()==0) {
			        				htmlStringBuilder.append("<tr> "
						        			+ "<td></td> "
						        			+ "<td>No Record Found.</td> "
						        			+ "</tr> ");
								}
			        			
			        htmlStringBuilder.append("</tbody> "
			        	+ "</table> "
        			+ "</div> "
        			+ "<div id='section4' class='container-fluid'> "
        			+"<div><i class='fa fa-remove' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
        			+ "<h4> Error Scenarios</h4></div> "
        			+ "<table class='table'> "
	        			+ "<thead> "
	        			+ "<tr> "
	        			+ "<th style='width: 2px;'>S.No</th> "
	        			+ "<th>Description</th> "
	        			+ "</tr> "
	        			+ "</thead> "
		        			+ "<tbody> ");
	        			
		        			for (int i = 0; i < ErrorList.size(); i++) {
					    		  //System.out.println(ErrorList.get(i));
					    			int Elist = i+1;
					    			String ElistId = Integer.toString(Elist);
		        					htmlStringBuilder.append("<tr> "
						        			+ "<td>"+ElistId+"</td> "
						        			+ "<td>"+ErrorList.get(i));
		        					
		        					if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename+Version,"error"+ElistId)) 
				        			{
				        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+Version+"/"+"error"+ElistId+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
									}
				        			else
				        			{
				        				
				        			}
				        			htmlStringBuilder.append( "</tr> ");
		        					
					    		}
		        		
		        			if (ErrorList.size()==0) {
		        				htmlStringBuilder.append("<tr> "
					        			+ "<td></td> "
					        			+ "<td>No Record Found.</td> "
					        			+ "</tr> ");
							}
		        			
		        	htmlStringBuilder.append("</tbody> "
		        	+ "</table> "
		        	+ "</div> "
		        	+ "<div id='section5' class='container-fluid'> "
		        	+"<div><i class='fa fa-info' style='font-size:20px;color:white; float: left; padding-right: 10px;'></i>"
        			+ "<h4> Info Scenarios</h4></div> "
        			+ "<table class='table'> "
	        			+ "<thead> "
	        			+ "<tr> "
	        			+ "<th style='width: 2px;'>S.No</th> "
	        			+ "<th>Description</th> "
	        			+ "</tr> "
	        			+ "</thead> "
		        			+ "<tbody> ");
	        			
		        	
		        			for (int i = 0; i < InfoList.size(); i++) {
					    		  //System.out.println(InfoList.get(i));
		        				int Ilist= i+1;
		        				String IlistId= Integer.toString(Ilist);
					    			htmlStringBuilder.append("<tr>"
						        			+ "<td>"+IlistId+"</td>"
						        			+ "<td>"+InfoList.get(i));
					    			if (CheckImageAvailability.CheckExistance("/reports/"+FolderName+"/"+Filename+Version,"info"+IlistId)) 
				        			{
				        				htmlStringBuilder.append("<p style='float:right;'><img onclick='OpenImage(this.src)' src='"+Filename+Version+"/"+"info"+IlistId+".png' class='img-rounded' alt='ScreenShot' width='70' height='70'></p></td>");
									}
				        			else
				        			{
				        				
				        			}
				        			htmlStringBuilder.append( "</tr> ");
					    		}
		        		
		        			if (InfoList.size()==0) {
		        				htmlStringBuilder.append("<tr> "
					        			+ "<td></td> "
					        			+ "<td>No Record Found.</td> "
					        			+ "</tr> ");
							}
		        			
		        			
		        			htmlStringBuilder.append("</tbody> "
		        	+ "</table> "
		        	+ "</div> "
        			+ "<footer class='container-fluid text-center'> <p></p> </footer> </body> </html>");

            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),FileName, FolderName);
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
    }

	
//	This will write the file 
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
