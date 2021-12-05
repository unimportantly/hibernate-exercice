package manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Book;

public class BookManager {
	protected SessionFactory sessionFactory; 
	
	protected void setup() {
		// Le code qui me permet de load une session Hibernate
		// On récupère la conf d'hibernate pour créer un registry 
		// ATTENTION : ICI ON NE SE CONNECTE PAS, DONC ON NE LANCE PAS 
		// 				DE SESSION AVEC LA BDD
		final StandardServiceRegistry registry = 
			new StandardServiceRegistryBuilder().configure().build();
		
		try {
			// ON ESSAYE DE SE CONNECTER À LA BDD 
			// On construit notre session 
			sessionFactory = new MetadataSources(registry)
					.buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			ex.getStackTrace();
		}		
	}
	
	protected void exit() {
		// Le code qui me permet de supprimer une session Hibernate
		sessionFactory.close();
	}

	protected void create() { // Je crée un enregistrement
		Book book = new Book();
		book.setTitle("ezfz");
		book.setAuthor("efzfez Sveistrup");
		book.setPrice(34.23f);
		Book book2 = new Book();
		book2.setTitle("Foundation");
		book2.setAuthor("Isaac Asimov");
		book2.setPrice(9.03f);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
	}
		
	protected Book read(long id) { // Je lis un enregistrement 
		Session session = sessionFactory.openSession();
		Book book = session.get(Book.class, id);
		System.out.println("Title : " + book.getTitle());
		System.out.println("Author : " + book.getAuthor());
		System.out.println("Price : " + book.getPrice() + "€");
		session.close();
		return book;
	}
	
	protected void update(long id, Book newBook) { // Je mets à jour un enregistrement 
		Book book = this.read(id);
		if (newBook.getTitle() != null) {
			book.setTitle(newBook.getTitle());
		}
		if (newBook.getAuthor() != null) {
			book.setAuthor(newBook.getAuthor());
		}
		if (newBook.getPrice() != book.getPrice()) {
			book.setPrice(newBook.getPrice());
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
		session.close();
	}
	
	protected void delete(Book book) { // Je supprime un enregistrement 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void main(String[] args) {
		BookManager manager = new BookManager();
		manager.setup();
	 	Book book = manager.read(4);
		manager.exit();
	}
}
