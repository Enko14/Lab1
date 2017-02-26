package onemore;

import java.io.File;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;



public class Main {
	
	public void ReadFile(String fileName) throws JAXBException, SAXException {
           File file = new File(fileName);

		JAXBContext jс = JAXBContext.newInstance(new Class[] { Authors.class, Author.class, Book.class });

		Unmarshaller jaxbUnmarshaller = jс.createUnmarshaller();

		Authors auth = (Authors) jaxbUnmarshaller.unmarshal(file);
		System.out.println(auth);
		 List<Author> bam = auth.getAuthor();
		for (Author author : bam) {
			System.out.println("[Автор "+author.getName() + "; ID Автора :" + author.getId() + "; Год рождения: " +author.getBirthdate() + "]");
		final List<Book> bom = author.getBooks();
		for (Book book : bom) {
				System.out.println("Книга: "+book.getBookname() + "\n (Id=" + book.getId() + ")\n Год издания: " + book.getYear()+ "; Тип:" +book.getType());
			}
      }
		 Marshaller marshaller = jс.createMarshaller();
		 SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
	     Schema schema = sf.newSchema(new File("src/NewXMLSchema1.xsd"));
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.setSchema(schema);
	        marshaller.marshal( auth , System.out);

	}

	
}

