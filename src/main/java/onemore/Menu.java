package onemore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Menu {
    public static void main(String[] args) throws SAXException, TransformerException, JAXBException {
    	Main main = new Main();
    	AddElement main2 = new AddElement();
    	main.ReadFile("src/NewFile.xml");
//		AddElement.searchBook(10, AddElement.allbooks);
}}
