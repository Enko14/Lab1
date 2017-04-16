package onemore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class AddElement {
	static Authors authors= new Authors();
	static List<Author> auth = new ArrayList<Author>();
	   
	public static void main(String[] args) throws JAXBException, SAXException {
	 String fileName = "NewFile2.xml";
	
//	 authors.setAuthor(new ArrayList<Author>());
	 Author author=new Author();
	  author.setId(1);
	  author.setBirthdate(1890);
	  author.setName("GG");
	  
	  Author author2=new Author();
	  author2.setId(2);
	  author2.setBirthdate(18999);
	  author2.setName("BB");
	  
	  
		Book book1 =new Book();
	    book1.setId(10);
	    book1.setBookname("Валерон");
	    book1.setYear(1890);
	    book1.setType("Novel");
	    
	    Book book2 =new Book();
	    book2.setId(11);
	    book2.setBookname("Бабайка");
	    book2.setYear(18550);
	    book2.setType("Novel");
	    
	    
	    Book book3 =new Book();
	    book3.setId(12);
	    book3.setBookname("Книга");
	    book3.setYear(18550);
	    book3.setType("Novel");
	    
	    
		
		List<Book> boo= new ArrayList<Book>();
		List<Book> boo2= new ArrayList<Book>();
		authors.setAuthor(auth);
		auth.add(author);
		auth.add(author2);
		author.setBooks(boo);
		author2.setBooks(boo2);
		boo.add(book1);
		boo2.add(book2);
		boo2.add(book3);
		
		 List<Book> allbooks = new ArrayList<Book>(boo);
		allbooks.addAll(boo2);
		System.out.println(allbooks);
	
		convertObjectToXml(authors, fileName);
		searchBook(10, allbooks);
//	 Authors unmarshAuthors = fromXmlToObject(fileName);
  //   if (unmarshAuthors != null) {
 ///        System.out.println(unmarshAuthors.toString()); }}
    
	
//	  private static Authors fromXmlToObject(String fileName) {
//	        try {
//	            // создаем объект JAXBContext - точку входа для JAXB
//	            JAXBContext jaxbContext = JAXBContext.newInstance(Authors.class);
//	            Unmarshaller un = jaxbContext.createUnmarshaller();
//
//	            return (Authors) un.unmarshal(new File(fileName));
//	        } catch (JAXBException e) {
//	            e.printStackTrace();
//	        }
//	        return null;
		}
	 private static void convertObjectToXml(Authors authors ,String fileName) throws JAXBException, SAXException
	 { try {
	     JAXBContext jaxbContext = JAXBContext.newInstance(Authors.class);
	     Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	     SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
	     Schema schema = sf.newSchema(new File("src/NewXMLSchema1.xsd"));
	     

	     jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	   jaxbMarshaller.setSchema(schema);
	     jaxbMarshaller.marshal(authors,new File(fileName)); 
	     jaxbMarshaller.marshal(authors,System.out); 
	     
	  } catch (JAXBException e) {
	         e.printStackTrace();
	     }}
	 
	 
	    public static void searchBook(int id,List<Book> allbooks) {
	        boolean flag = false;
	        for (int i = 0; i < allbooks.size(); i++) {
	            if (id == allbooks.get(i).id) {
	                System.out.println("Найдена книга: " + "id " + allbooks.get(i).id + ", "
	                        + allbooks.get(i).bookname);
	                flag = true;
	            }
	        }
	        if (!flag) {
	            System.out.println("Книга с заданным ID не найдена!");
	        }
	    }}
	 
