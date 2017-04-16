package onemore;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="authors")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Authors.class})
public class Authors {
	@XmlElement (name="author")
	public List<Author> author;

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	public Authors(List<Author> author) {
		super();
		this.author = author;
	}

	public Authors() {
		// TODO Auto-generated constructor stub
	}
	
	}
