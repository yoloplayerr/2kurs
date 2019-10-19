package lab5;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class XMLHandler extends DefaultHandler {
	ArrayList<Sportsman> sList = new ArrayList<>();
	Sportsman s;

	public ArrayList<Sportsman> getsList() {
		return sList;
	}

	private String lastElementName;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		lastElementName = qName;

		if (qName.equals("sportsman")) {
			s = new Sportsman(attributes.getValue("name"), attributes.getValue("birthday"), attributes.getValue("s"));
			sList.add(s);
		}
		if (qName.equals("event")) {
			s.setPlace(attributes.getValue("place"));
			s.setYear(attributes.getValue("year"));

		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String information = new String(ch, start, length);

		information = information.replace("\n", "").trim();

		if (!information.isEmpty()) {
			if (lastElementName.equals("award"))
				s.setAward(information);
			if (lastElementName.equals("result")) {
				s.setResult(information);
			}

		}
	}

}
