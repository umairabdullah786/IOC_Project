package ioc;

import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class IOC{
	static IOC ioc=null;
	static String propertypath;
	private IOC() { }
	
	public static IOC getContainer(String pkg) {
		propertypath=pkg;
		if(ioc==null) {
			ioc=new IOC();
		}
		return ioc;
	}
	public HashMap<String, Object> manager() {
		HashMap<String, Object> pool=null;
		try{
			
			//3rd Method using xml parsing 1 or more than 1 class
			
			HashMap<String,ArrayList<String>> hm=new HashMap<String,ArrayList<String>>();
			ArrayList<String> al=new ArrayList<String>();
			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
			propertypath="src."+propertypath;
			StringBuilder path=new StringBuilder(propertypath);
			for(int i=0;i<path.length();i++) {
				if(path.charAt(i)=='.') {
					path.replace(i, i+1, "/");
				}
			}
			path.append(".xml");
			File inputFile=new File(path.toString());
			Document doc=dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			Element root=doc.getDocumentElement();
			NodeList nList=doc.getElementsByTagName("bean");
			
			int len=nList.getLength();
			for(int i=0;i<len;i++) {
				org.w3c.dom.Node nNode=nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement=(Element) nNode;
					if(!eElement.getElementsByTagName("depends-on").item(0).getTextContent().equals("none")) {
						String className=eElement.getElementsByTagName("depends-on").item(0).getTextContent();
						for(int k=0;k<len;k++) {
							if((((Element)nList.item(k)).getElementsByTagName("name").item(0).getTextContent()).equals(className)){
								al.add(((Element)nList.item(k)).getElementsByTagName("class").item(0).getTextContent());
							}
						}		
						hm.put(eElement.getElementsByTagName("class").item(0).getTextContent(),al);
					}
				}
			}
			
			Set<String> keys=hm.keySet();
			for(String s:keys) {
				Class n=Class.forName(s);
				ArrayList<String> dependents=hm.get(s);
				pool=new HashMap<String,Object>();
				for(int i=0;i<dependents.size();i++) {
					Class c=Class.forName(dependents.get(i));
					Object obj=n.getDeclaredConstructor(c).newInstance(c.newInstance());
					pool.put(s,obj);
				}
			}
			
			// 2nd Method using Collection of Api
			
//			HashMap<String,ArrayList<String>> hm=new HashMap<String,ArrayList<String>>();
//			ArrayList<String> al=new ArrayList<String>();
//			al.add("beans.MyClass");
//			hm.put("beans.Needy", al);
//			Set<String> keys=hm.keySet();
//			for(String s:keys) {
//				Class n=Class.forName(s);
//				ArrayList<String> dependents=hm.get(s);
//				pool=new HashMap<String,Object>();
//				for(int i=0;i<dependents.size();i++) {
//					Class c=Class.forName(dependents.get(i));
//					Object obj=n.getDeclaredConstructor(c).newInstance(c.newInstance());
//					pool.put(s,obj);
//				}
//			}
			
			// 1st Method using Resource Bundle
			
			
//			ResourceBundle bundle=ResourceBundle.getBundle(propertypath);
//			//beans.default
//			String subpath=propertypath.substring(0,propertypath.lastIndexOf('.'));
//			String cls=bundle.getString("class");
//			String dependent=bundle.getString(cls+".dependent");
//			Class n=Class.forName(cls);
//			Class c=Class.forName(dependent);
//			n.getDeclaredConstructor(c).newInstance(c.newInstance());
			//ioc.IocInterface iinterface=ioc.IocInterface.class.cast(n.getDeclaredConstructor(c).newInstance(c.newInstance()));
		
		}catch(Exception cnf){
			cnf.printStackTrace();
		}
		return pool;
	}
}
