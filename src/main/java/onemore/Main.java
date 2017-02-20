package onemore;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Main {

	public static void main(String[] args) throws JAXBException { 

		File file = new File("src/NewFile.xml");

		JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] {Authors.class,Author.class,Book.class});
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		Authors auth = (Authors)jaxbUnmarshaller.unmarshal(file);
		System.out.println(auth);
		List<Author> bam = auth.getAuthor();
		for(Author author: bam){
			System.out.println(author.getName() + "\n id= " + author.getId() + " birthdate= " + author.getBirthdate());
//			List<Book> bom= auth.getBooks();
//			for (Book book : bom){
//				System.out.println(book.getBookname());
			}
		}

		}

