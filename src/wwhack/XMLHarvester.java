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
    
    private String path;
    private String play;
    private String newPlay;
    
    public XMLHarvester(String path) {
        this.path = path;
        newPlay = parseXML();
    }
    
    private String parseXML() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        StringBuilder sb = new StringBuilder();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(path);
            Element rootElement = dom.getDocumentElement();
            NodeList nl = rootElement.getElementsByTagName("PlainText");
            for (int i = 0; i < nl.getLength(); i++) {
                Element lineElement = (Element) nl.item(i);
                sb.append(searchWords(lineElement.getTextContent()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    
    private String searchWords(String line) {
        StringBuilder newLine = new StringBuilder();
        String[] lineArray = line.split(" ");
        for (String word : lineArray) {
            newLine.append(word);
            newLine.append("-");
        }
        return newLine.toString();
    }
    
    public String getResult() {
        return newPlay;
    }
}
