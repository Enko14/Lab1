package onemore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Menu {
    public static void main(String[] args) throws SAXException, TransformerException, JAXBException {
    	Main main = new Main();
//    	AddElement main2 = new AddElement();
    	main.ReadFile("src/NewFile.xml");
		//		AddElement.searchBook(10, AddElement.allbooks);
    	main.getAll(); 
    	System.out.println( "\n----------------");
    	main.searchAuthor(2);
    	System.out.println( "\n----------------");
    	main.searchBook(1); 
    	System.out.println( "\n----------------");
    	main.addAuthor(3, "Алексей", 1807);
    	System.out.println( "\n----------------");
//    		main.getBooksByAuthor2(2);
    	main.showAuthor(main.getAuthors(1));
    	System.out.println( "\n----------------");
    	main.BooksList();
    	System.out.println( "\n----------------");
    	main.AuthorsList();
    	System.out.println( "\n----------------");
    	main.saveToFile("src/NewFile.xml");
    	System.out.println( "\n----------------");
    
}}
