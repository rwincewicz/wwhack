/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wwhack;

import java.io.IOException;
import java.util.logging.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author richie
 */
public class Wwhack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XMLHarvester harvester = new XMLHarvester();
        String playString = harvester.parseXML("http://wwsrv.edina.ac.uk/wworld/static/plays/Alls_Well_That_Ends_Well.xml");
    }
}
