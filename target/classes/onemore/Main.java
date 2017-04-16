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



public class Main {
	public List<Author> author = new ArrayList<Author>();
	private Authors auth = new Authors();
	private Author author1 = new Author();
	public List<Book> allbooks = new ArrayList<Book>();

	// прочитать файл
	public void ReadFile(String fileName) throws JAXBException, SAXException {
		File file = new File(fileName);

		JAXBContext jс = JAXBContext.newInstance(Authors.class);

		Unmarshaller jaxbUnmarshaller = jс.createUnmarshaller();

		auth = (Authors) jaxbUnmarshaller.unmarshal(file);
		author = auth.getAuthor();
		for (Author author : author) {
			List<Book> bookes = new ArrayList<Book>();
			bookes = author.getBooks();
			if (bookes == null) {
				continue;
			} else {
				allbooks.addAll(bookes);
			}
		}
	}

	// получить весь список
	public void getAll() throws JAXBException, SAXException {
		System.out.println(auth);
		for (Author author : author) {
			System.out.println("[Автор " + author.getName() + "; ID Автора :" + author.getId() + "; Год рождения: "
					+ author.getBirthdate() + "]");
			List<Book> boook = new ArrayList<Book>();
			boook = author.getBooks();
			if (boook == null) {
				System.out.println("У автора нет книг");
				continue;
			} else {
				for (Book book : boook) {
					System.out.println("Книга: " + book.getBookname() + "\n (Id=" + book.getId() + ")\n Год издания: "
							+ book.getYear() + "; Тип:" + book.getType() + "\n");
				}
			}
		}
	}

	// получить список авторов
	public void AuthorsList() {

		for (int i = 0; i < author.size(); i++) {
			System.out.println("Автор: " + author.get(i).name + "  ID: " + author.get(i).id);
		}
	}

	// Получить список книг
	public void BooksList() {
		for (int i = 0; i < allbooks.size(); i++) {
			System.out.println("Книга: " + allbooks.get(i).bookname + "  ID: " + allbooks.get(i).id);
		}
	}
// Найти автора по айди
    public Author getAuthors(int id) {
        boolean flag = false;
        Author obj = new Author();
        for (Author auth2:author) {
            if (auth2.id == id) {
                flag = true;
                obj=auth2;
                System.out.println(auth2.getName()+ "    "+auth2.getId());
            }
        }
        if (!flag){
            return null; //Автор не найден
        }
        else return obj;
    }
   //вывести всю информацию о найденом авторе
    public void showAuthor(Author objAuthor) {
        if (objAuthor == null) {
            System.out.println("Новость не найдена");
        } else {
            System.out.println("ID: " + objAuthor.id + " " + "Автор : " + objAuthor.name +"\n"+objAuthor.birthdate + "\n"+objAuthor.getBooks());
        }
    }   
    
	// поиск автора
	public void searchAuthor(int id) {
		boolean flag = false;

		for (int i = 0; i < author.size(); i++) {
			if (id == author.get(i).id) {
				System.out.println("Найден автор: " + "id " + author.get(i).id + ", " + author.get(i).name);
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("Автор с заданным ID не найдена!");
		}
	}

	// поиск книги
	public void searchBook(int id) throws JAXBException, SAXException {
		boolean flag = false;

		for (int i = 0; i < allbooks.size(); i++) {
			if (id == allbooks.get(i).id) {
				System.out.println("Найдена книга: " + "id " + allbooks.get(i).id + ", " + allbooks.get(i).bookname);
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("Книга с заданным ID не найдена!");
		}
	}

	// Добавить автора
	public void addAuthor(int id, String name, int birthdate) throws JAXBException, SAXException {
		boolean flag = false;
		for (int i = 0; i < author.size(); i++) {
			if (author.get(i).id == id) {
				flag = true;
			}
		}
		if (flag == false) {
			author.add(author1 = new Author(id, name, birthdate, null));
			System.out.println("Категория добавлена");
		} else {
			System.out.println("Категория с таким ID уже существует");
		}
	}

	// public void getBooksByAuthor2(int id){
	// boolean flag = false;
	// List<Author> AuthorsList=auth.getAuthor();
	// for (int i = 0; i < AuthorsList.size(); i++) {
	// if (AuthorsList.get(i).id == id) {
	// System.out.println("Найден автор: " + "id " + author.get(i).id + ", " +
	// author.get(i).name);
	//
	// for (int j = 0; j < AuthorsList.size(); j++) {
	// if (allbooks.get(j).author.id == id) {
	// System.out.println("ID: " + allbooks.get(j).id + " " + "Новость: " +
	// allbooks.get(j).bookname
	// + " ID категории: " + allbooks.get(j).author.id);
	// }
	// }
	// flag = true;
	// }
	// }
	// if (!flag) {
	// System.out.println("Категория с кодом: " + id + " не найдена.");
	// }
	// }

	// Сохранить в файл с валидацией по XSD
	public void saveToFile(String filename) throws JAXBException, SAXException {
		JAXBContext jс = JAXBContext.newInstance(Authors.class);
		Marshaller marshaller = jс.createMarshaller();
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("src/NewXMLSchema1.xsd"));

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(auth, new File(filename));
		marshaller.setSchema(schema);
		marshaller.marshal(auth, System.out);

	}
}
