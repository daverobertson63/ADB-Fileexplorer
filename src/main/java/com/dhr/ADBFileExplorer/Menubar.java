package com.dhr.ADBFileExplorer;

import java.awt.CheckboxMenuItem;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URISyntaxException;


public class Menubar extends MenuBar 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1647687440250180882L;
	private Menu language;

	public Menubar()
	{
		super();
		
		
		language = new Menu("Language");
		
		CheckboxMenuItem english = new CheckboxMenuItem("English");
		english.addItemListener(new LanguageItemListener("english"));
		
		CheckboxMenuItem german = new CheckboxMenuItem("German");
		german.addItemListener(new LanguageItemListener("german"));
		
		CheckboxMenuItem slovak = new CheckboxMenuItem("Slovak");
		slovak.addItemListener(new LanguageItemListener("slovak"));
		
		language.add(english);
		language.add(german);
		language.add(slovak);
		
		
		
		Menu about = new Menu("About");
		
		MenuItem info = new MenuItem("Info");
		
		info.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) 
			{
				new AboutDiaglog();
			}
		});
		about.add(info);
		
		
		this.add(language);
		this.add(about);
	}
	
	
	private class LanguageItemListener implements ItemListener
	{
		private String languageString;
		public LanguageItemListener(String languageString)
		{
			this.languageString = languageString;
		}
		

		public void itemStateChanged(ItemEvent e) 
		{
			DataReciever.setLanguageString(new LanguageStrings(languageString));
			
			try 
			{
				App.restartApplication();
			} 
			catch (URISyntaxException e1) 
			{}
			catch (IOException e1) 
			{}
			
		}
		
	}

	public void setItemState(String languageString)
	{
		for(int i = 0; i < language.getItemCount(); i++)
		{
			if(language.getItem(i) instanceof CheckboxMenuItem && language.getItem(i).getLabel().toLowerCase() == languageString.toLowerCase())
			{
				CheckboxMenuItem item = (CheckboxMenuItem)language.getItem(i);
				item.setState(true);
			}
		}
	}

}
