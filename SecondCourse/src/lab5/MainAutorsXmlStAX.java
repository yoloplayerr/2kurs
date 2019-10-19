package lab5;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainAutorsXmlStAX {
	public static void main(String[] args) {

		List<Autor> persList = new ArrayList<>();
		Autor pers = null;
		ArrayList<String> bookName=new ArrayList<String>();
		
		ArrayList<String> pages=new ArrayList<>();;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			// инициализируем reader и скармливаем ему xml файл
			XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("text1.xml"));

			// проходим по всем элементам xml файла
			while (reader.hasNext()) {
				if(bookName.size()==2 && pages.size()==2) {
					pages=new ArrayList<>();
					bookName=new ArrayList<String>();
				}
				// получаем событие (элемент) и разбираем его
				XMLEvent xmlEvent = reader.nextEvent();
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("author")) {
							
						pers = new Autor();
						// Получаем атрибуты для каждого элемента Student
						Attribute persAttr = startElement.getAttributeByName(new QName("name"));
						if (persAttr != null) {
							pers.setAutorName(persAttr.getValue());
						}

					} if (startElement.getName().getLocalPart().equals("book")) {
						Attribute persAttr = startElement.getAttributeByName(new QName("name"));
						if (persAttr != null) {
							bookName.add(persAttr.getValue());
							pers.setBookName(bookName);

						}

					} else if (startElement.getName().getLocalPart().equals("pages")) {
						xmlEvent = reader.nextEvent();
						pages.add((xmlEvent.asCharacters().getData()));
						pers.setPages(pages);

					}

				}
				// если цикл дошел до закрывающего элемента Autor,
				// то добавляем считанного из файла персонажа в список
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("author")) {
						persList.add(pers);
					}
				}
			}

		} catch (FileNotFoundException | XMLStreamException exc) {
			exc.printStackTrace();
		}
		for (Autor c : persList)

			System.out.println(c);
	}
}
