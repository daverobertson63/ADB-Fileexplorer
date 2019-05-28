package com.dhr.ADBFileExplorer;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;




public class App 
{
	
	public static void main(String[] args)
	{	

		Explorer explorer = new Explorer();
	
	}
	
	
	
	public static void restartApplication() throws URISyntaxException, IOException
	{
	  final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
	  final File currentJar = new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI());


	  if(!currentJar.getName().endsWith(".jar"))
	    return;

	  final ArrayList<String> command = new ArrayList<String>();
	  command.add(javaBin);
	  command.add("-jar");
	  command.add(currentJar.getPath());

	  final ProcessBuilder builder = new ProcessBuilder(command);
	  builder.start();
	  System.exit(0);
	}

}

