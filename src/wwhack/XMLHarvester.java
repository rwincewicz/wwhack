/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wwhack;

import java.io.*;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author richie
 */
public class XMLHarvester {
    
    public String parseXML(String path) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        StringBuilder sb = new StringBuilder();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(path);
            Element rootElement = dom.getDocumentElement();
            NodeList nl = rootElement.getElementsByTagName("PlainText");
            System.out.println("Length: " + nl.getLength());
            for (int i = 0; i < nl.getLength(); i++) {
                Element lineElement = (Element) nl.item(i);
                sb.append(lineElement.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
