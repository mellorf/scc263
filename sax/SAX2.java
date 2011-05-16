import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX2 extends DefaultHandler {
	private StringBuffer buffer;

	public SAX2(){ }
	
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

	public void startDocument(){ System.out.println("startDocument"); }
	public void endDocument(){ System.out.println("endDocument"); }

	//Event Handlers
	public void startElement(String uri, 
			String localName, 
			String qName, 
			Attributes attributes) throws SAXException {
		System.out.println("startElement: "+qName);
		buffer = new StringBuffer();
	}
	

	public void characters(char[] ch, int start, int length) throws SAXException {
		//System.out.println("characters: "+start+" "+length);
		buffer.append(ch, start, length);
	}
	
	public void endElement(String uri, 
			String localName, 
			String qName) throws SAXException {
		System.out.println("endElement: "+qName+" : "+buffer);
	}
	
	public static void main(String[] args){
		SAX2 spe = new SAX2();
		spe.parseDocument(args[0]);
	}
	
}
