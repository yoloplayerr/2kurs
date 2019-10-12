package lab3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Lab3 {

	public static void main(String[] args) {
//getFirst();
		getThird();

	}

	public static void getFirst() {
		try {
			File fXmlFile = new File("text1.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Node root = doc.getDocumentElement();
			NodeList nList = root.getChildNodes();

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.hasAttributes())
					System.out.println(
							"Автор произведения: " + node.getAttributes().getNamedItem("name").getTextContent());
				NodeList nList1 = node.getChildNodes();
				for (int j = 0; j < nList1.getLength(); j++) {
					Node node1 = nList1.item(j);
					if (node1.hasAttributes())
						System.out.println(
								"Название книги: " + node1.getAttributes().getNamedItem("name").getTextContent());
					if (node1.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node1;
						System.out.println("количество страниц: "
								+ element.getElementsByTagName("pages").item(0).getTextContent());
					}
				}

				System.out.println("------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getThird() {
		ArrayList<Sportsman> smList = new ArrayList<>();
		try {
			File fXmlFile = new File("text2.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Node root = doc.getDocumentElement();
			NodeList nList = root.getChildNodes();

			for (int i = 0; i < nList.getLength(); i++) {

				Node node = nList.item(i);
				if (node.getNodeType() != Node.TEXT_NODE) {
					Sportsman sm = new Sportsman();
					if (node.hasAttributes()) {
						sm.setName(node.getAttributes().getNamedItem("name").getTextContent());
						sm.setS(node.getAttributes().getNamedItem("s").getTextContent());
						sm.setBirthday(node.getAttributes().getNamedItem("birthday").getTextContent());
					}
					NodeList nodeList1 = node.getChildNodes();
					for (int j = 0; j < nodeList1.getLength(); j++) {
						Node node1 = nodeList1.item(j);
						if (node1.getNodeType() != Node.TEXT_NODE) {
							if (node1.hasAttributes()) {
								sm.setPlace(node1.getAttributes().getNamedItem("place").getTextContent());
								sm.setYear(node1.getAttributes().getNamedItem("year").getTextContent());
							}
							if (node1.getNodeType() == Node.ELEMENT_NODE) {
								Element element = (Element) node1;
								sm.setResult(element.getElementsByTagName("result").item(0).getTextContent());
								sm.setAward(element.getElementsByTagName("award").item(0).getTextContent());

							}
						}

					}
					smList.add(sm);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scanner c=new Scanner(System.in);
		Sportsman s=new Sportsman();
		System.out.println("Медаль");
			s.setAward(c.next());
			System.out.println("День рождения");
			s.setBirthday(c.next());
			System.out.println("Имя");
			s.setName(c.next());
			System.out.println("место");
			s.setPlace(c.next());
			System.out.println("Результаты");
			s.setResult(c.next());
			System.out.println("Пол");
			s.setS(c.next());
			System.out.println("Год");
			s.setYear(c.next());
			smList.add(s);
		for (Sportsman sm : smList) {

			if (sm.getS().equals("м")) {
				System.out.println("Имя: " + sm.getName() + " Дата рождения: " + sm.getBirthday());
			} else {
				if (Integer.valueOf(sm.getBirthday().substring(0, 4)) > 1985) {
					System.out.println("Имя: " + sm.getName() + " Дата рождения: " + sm.getBirthday()
							+ " Количество медалей: " + sm.getAward());
				}
			}
			if (Integer.valueOf(sm.getBirthday().substring(0, 4)) == 2002) {
				System.out.println("Имя: " + sm.getName() + " Дата рождения: " + sm.getBirthday() + "Результаты : "
						+ sm.getResult());
			}
		}
		

	}
	
}