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
import entities.Post;
import entities.Product;
import entities.ProductDetail;

public class PostsManager {

	public static void main(String[] args) {
		SessionFactory sessionFactory; 
		final StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure().build();	
		sessionFactory = new MetadataSources(registry)
						.buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	
		Category category = new Category(); 
		category.setTitle("Bierercolage");
		
		Post post1 = new Post(); 
		post1.setTitle("Apprendre à monter un meuble Ikea avec 4g dans le sang");
		post1.setCategory(category);
		
		Post post2 = new Post(); 
		post2.setTitle("Faire un trou alcoolisé sans se faire mal");
		post2.setCategory(category);
		
		Set<Post> posts = new HashSet<Post>();
		posts.add(post2);
		posts.add(post1);
		
		category.setPosts(posts);
		
		session.save(category);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
