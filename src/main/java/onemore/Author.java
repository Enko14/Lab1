package onemore;

import java.util.List;
import javax.xml.bind.annotation.*;

//@XmlType(propOrder = {"id","name","year_of_birth","authors"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ Author.class })
public class Author {
	
	@XmlAttribute(name = "id")
	public int id;
	@XmlAttribute(name = "name")
	public String name;
	@XmlAttribute(name = "birthdate")
	public int birthdate;
	@XmlElementWrapper(name = "books")
	@XmlElement(name = "book")
	public List<Book> books;		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(int birthdate) {
		this.birthdate = birthdate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Author(int inId, String inName, int inBirthdate, List<Book> inBooks) {
		super();
		id = inId;
		name = inName;
		birthdate = inBirthdate;
		books = inBooks;
	}

	public Author() {
		// TODO Auto-generated constructor stub
	}

}
