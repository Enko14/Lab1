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
	    book3.setId(11);
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
	 Authors unmarshAuthors = fromXmlToObject(fileName);
     if (unmarshAuthors != null) {
         System.out.println(unmarshAuthors.toString()); }}
    
	
	  private static Authors fromXmlToObject(String fileName) {
	        try {
	            // создаем объект JAXBContext - точку входа для JAXB
	            JAXBContext jaxbContext = JAXBContext.newInstance(Authors.class);
	            Unmarshaller un = jaxbContext.createUnmarshaller();

	            return (Authors) un.unmarshal(new File(fileName));
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
	        return null;
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
	 

//	    public void showCategory(Author objAuthor) {
//	        if (objAuthor == null) {
//	            System.out.println("Автор не найден");
//	        } else {
//	            System.out.println("ID: " + objAuthor.id + " " + "Категория: " + objAuthor.name);

	  //Удалить книгу
//	    public void deleteBook(int id) {
//	        boolean flag = false;
//	       
//	       for(int i=0; i<newsList.size();i++){
//	        if(newsList.get(i).id == id){
//	          newsList.remove(i);
//	          System.out.println("Новость удалена");
//	          flag = true;
//	        }
//	       }
//	       if (flag == false){
//	          System.out.println("Новость не найдена");
//	       }
//	    }
//	    //Добавить новую категорию
//	    public void addCategory(int id, String name) {
//	        boolean flag = false;
//	        for (int i = 0; i < catList.size(); i++) {
//	            if (catList.get(i).id == id) {
//	                flag = true;
//	            }
//	        }
//	        if (flag == false) {
//	            catList.add(cat = new Category(id, name));
//	            System.out.println("Категория добавлена");
//	        } else {
//	            System.out.println("Категория с таким ID уже существует");
//	        }
//	    }
//	    //Добавить новую новость для заданной категории (по ID)
//	    public void addNewsForCategory(int id, String name, Category objCategory) {
//	        boolean flag = false;
//	       
//	        for (int i = 0; i < newsList.size(); i++) {
//	            if (newsList.get(i).id == id) {
//	                flag = true;
//	            }
//	        }
//	        if (objCategory != null) {
//	            if (flag == false) {
//	                for (int i = 0; i < catList.size(); i++) {
//	                    if (catList.get(i).id == objCategory.id) {
//	                        newsList.add(news = new News(id, name, objCategory));
//	                        System.out.println("Новость добавлена");
//	                    }
//	                }
//	            } else {
//	                System.out.println("Новость с таким ID уже существует");
//	            }
//	        } else {
//	            System.out.println("Новость не найдена");
//	        }
//
//	    }
//	    //Удаление категории
//	    public void deleteCategory(int id){
//	       boolean flag = false;
//	       for(int i=0; i<catList.size();i++){
//	        if(catList.get(i).id == id){
//	          for (int j = 0; j < newsList.size(); j++){
//	              if(catList.get(i).id == newsList.get(j).category.id)
//	              {
//	                 newsList.remove(j--);
//	                 
//	              }
//	             
//	          }
//	          catList.remove(i);
//	          System.out.println("Категория удалена");
//	          flag = true;
//	        }
//	       }
//	       if (flag == false){
//	          System.out.println("Категория не найдена");
//	       }
//	    }
//
//	   //Редактирование новости
//	    public void editNews(int id, String name, Category objCategory){
//	        boolean flag = false;
//	        for(int i=0; i<newsList.size(); i++){
//	            if(newsList.get(i).id == id){
//	                News objNews = new News(id, name, objCategory);
//	                this.newsList.set(i, objNews);
//	                flag = true;
//	            }
//	        }
//	        if(flag == false){
//	            System.out.println("Новость с таким ID не найдена");
//	        }
//
//	    }
//	    //Редактирование новости
//	    public void editCategory(int id, String name){
//	        boolean flag = false;
//	        for(int i=0; i<catList.size(); i++){
//	            if(newsList.get(i).id == id){
//	                Category objCategory = new Category(id, name);
//	                this.catList.set(i, objCategory);
//	                flag = true;
//	            }
//	        }
//	        if(flag == false){
//	            System.out.println("Категория с таким ID не найдена");
//	        }
//	    } 
//	}











//	 private static void(Authors authors, ) {
//	    
//	         JAXBContext context = JAXBContext.newInstance(Author.class);
//	         Marshaller marshaller = context.createMarshaller();
//	         // устанавливаем флаг для читабельного вывода XML в JAXB
//	         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//	         // маршаллинг объекта в файл
//	         marshaller.marshal(authors, new File(filePath));
//	    
//	 }}
	//
