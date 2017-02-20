package onemore;

import java.util.List;
import javax.xml.bind.annotation.*;


//@XmlType(propOrder = {"id","name","year_of_birth","authors"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {
	@XmlAttribute (name="id")
	private int id;
	@XmlAttribute (name="name")
	private String name;
	@XmlAttribute (name="birthdate")
	public int birthdate;
	@XmlElementWrapper(name ="books")
	@XmlElement (name="book")
	 private List<Book> books;
	public int getId() {
		return id;
	}
	public void setIda(int id) {
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
	

}
