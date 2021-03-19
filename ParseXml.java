package test5;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;


public class ParseXml {

	public static void main(String[] args) {
		
		try {
			
		//String xmlDoc = "";
		XPath xPath = XPathFactory.newInstance().newXPath();
        Document doc = getDocumentFromFile("D:\\getcapabilities_1.3.0.xml");
		
		String name = xPath.evaluate("//Service//Name", doc);
		System.out.println(name);
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Document getDocument(String inputXMLString) throws IllegalArgumentException, Exception {
		if (inputXMLString == null) {
			throw new IllegalArgumentException("Input XML string cannot be null in XmlUtils.getDocument method");
		}
		DocumentBuilderFactory documentBuilderFactory = new DocumentBuilderFactoryImpl();

		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

		Document resultDocument = documentBuilder
				.parse(new InputSource(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(inputXMLString

						.getBytes())))));

		return resultDocument;
	}
	
	public static Document getDocumentFromFile(String filepath) throws IllegalArgumentException, Exception {
		
		DocumentBuilderFactory documentBuilderFactory = new DocumentBuilderFactoryImpl();

		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

		Document resultDocument = documentBuilder
				.parse(new File(filepath));

		return resultDocument;
	}
}
