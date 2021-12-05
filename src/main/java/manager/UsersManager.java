package manager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Category;
import entities.Group;
import entities.Post;
import entities.Product;
import entities.ProductDetail;
import entities.User;

public class UsersManager {

	public static void main(String[] args) {
		SessionFactory sessionFactory; 
		final StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure().build();	
		sessionFactory = new MetadataSources(registry)
						.buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	
		Group admin = new Group();
		admin.setName("admin");
		Group guest = new Group();
		guest.setName("guest");
		
		
		User antoine = new User();
		antoine.setUsername("Antoine");
		User toto = new User();
		toto.setUsername("Toto");
		
		admin.addUser(antoine);
		guest.addUser(toto);
		guest.addUser(antoine);
		
		antoine.addGroup(admin);
		antoine.addGroup(guest);
		toto.addGroup(guest);
		
		session.save(admin);
		session.save(guest);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
