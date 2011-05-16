import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSNews extends DefaultHandler {
	private StringBuffer buffer;
	private boolean item;

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
		}
		buffer.setLength(0);
	}
	

	public void characters(char[] ch, int start, int length) throws SAXException {
		buffer.append(ch, start, length);
	}
	
	public void endElement(String uri, 
			String localName, 
			String qName) throws SAXException {
		if (item) {
			if (qName.equals("title") ||
			    qName.equals("link") ||
			    qName.equals("description")) {
				System.out.println(buffer);
			    }
		}

		if (qName.equals("item"))
			item = false;
	}
	
	public static void main(String[] args){
		RSSNews spe = new RSSNews();
		spe.parseDocument(args[0]);
	}
	
}
