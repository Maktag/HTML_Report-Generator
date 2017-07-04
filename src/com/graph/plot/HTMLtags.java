package com.graph.plot;

public class HTMLtags 
{

private String MyName;

public HTMLtags(String name) 
{
	this.MyName = name;
}

public static void main(String[] args) 
{
HTMLtags txt = new HTMLtags("Pradeep Tyagi");
txt.Example();
}

public void Example()
{
	System.out.println(MyName);	
}

}