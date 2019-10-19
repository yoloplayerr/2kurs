package lab5;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class MainContactsXmlSAX {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		XMLHandler handler = new XMLHandler();
        parser.parse(new File("text2.xml"), handler);

        for (Sportsman s: handler.getsList()) {
           System.out.print(s);
        }
        JSONFileWriter.jsonWriter(handler.getsList());
    }

}
