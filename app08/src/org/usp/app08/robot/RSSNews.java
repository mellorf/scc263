package org.usp.app08.robot;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.usp.app08.core.*;

// Parser SAX
public class RSSNews extends DefaultHandler {
	private StringBuffer buffer;
	private boolean item;
	private News news;

	public RSSNews(){ }
	
	public void parseDocument(String filename) {
		
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
		
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			
			//parse the file and also register this class for call backs
			sp.parse(filename, this);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void startDocument(){ 
		this.item = false; 
		this.buffer = new StringBuffer();
	}

	public void endDocument(){ }

	//Event Handlers
	public void startElement(String uri, 
			String localName, 
			String qName, 
			Attributes attributes) throws SAXException {

		if (qName.equals("item")) {
			item = true;
			news = new News();
		}
		buffer.setLength(0); // zerar, esvaziar
	}
	

	public void characters(char[] ch, int start, int length) throws SAXException {
		buffer.append(ch, start, length);
	}
	
	public void endElement(String uri, 
			String localName, 
			String qName) throws SAXException {
		if (item) {
		// estou dentro de uma noticia?
		    try {
			if (qName.equals("title")) {
				news.setHeadline(buffer.toString());
			} else if (qName.equals("link")) {

			} else if (qName.equals("description")) {
				news.setBody(buffer.toString());
			}
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}

		if (qName.equals("item")) {
			item = false;
			System.out.println(news.getHeadline()+", "+
					news.getBody());
			news.setTmsp("2011-04-11 10:30:00");
			news.setEmail("teste@teste.com");
			try {
				news.insert();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		RSSNews spe = new RSSNews();
		spe.parseDocument(args[0]);
	}
	
}
