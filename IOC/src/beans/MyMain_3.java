package beans;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MyMain_3 {

	public static void main(String[] args) {
		try {
		
			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			File inputFile=new File("src/beans/conf.xml");
			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
			Document doc=dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root Element :"+doc.getDocumentElement().getNodeName());
			NodeList nList=doc.getElementsByTagName("bean");
			System.out.println("----------------------");
			
			int len=nList.getLength();
			for(int i=0;i<len;i++) {
				org.w3c.dom.Node nNode=nList.item(i);
				System.out.println("\nCurrent Element :"+nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement=(Element) nNode;
					System.out.println("Name :"+eElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Class :"+eElement.getElementsByTagName("class").item(0).getTextContent());
					System.out.println("DependsOn :"+eElement.getElementsByTagName("depends-on").item(0).getTextContent());
					System.out.println("--------------------------------");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
