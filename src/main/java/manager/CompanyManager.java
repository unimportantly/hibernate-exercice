package manager;

import entities.Company;
import entities.Sector;
import entities.Subsidiary;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CompanyManager {

    public static void main(String[] args) {
        SessionFactory sessionFactory;
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Company company = new Company();
        company.setName("company");

        Subsidiary haribo = new Subsidiary();
        haribo.setName("Haribo");
        haribo.setCompany(company);

        Subsidiary lutti = new Subsidiary();
        lutti.setName("lutti");
        lutti.setCompany(company);

        Subsidiary ferrero = new Subsidiary();
        ferrero.setName("ferrero");
        ferrero.setCompany(company);


        Subsidiary cemoi = new Subsidiary();
        cemoi.setName("cemoi");
        cemoi.setCompany(company);


        Sector chocolat = new Sector();
        chocolat.setName("chocolat");
        chocolat.setLocation("Paris");

        Sector confiserie = new Sector();
        confiserie.setName("confiserie");
        confiserie.setLocation("Lille");

        Sector france = new Sector();
        france.setName("France");
        france.setLocation("France");

        Sector etranger = new Sector();
        etranger.setName("Etranger");
        etranger.setLocation("Etranger");

        User user1 = new User();
        user1.setUsername("Paul");
        User user2 = new User();
        user2.setUsername("Pierre");
        User user3 = new User();
        user3.setUsername("Jacques");
        User user4 = new User();
        user4.setUsername("Henri");
        User user5 = new User();
        user5.setUsername("Marc");
        User user6 = new User();
        user6.setUsername("Louis");
        User user7 = new User();
        user7.setUsername("Maxime");
        User user8 = new User();
        user8.setUsername("Auguste");
        User user9 = new User();
        user9.setUsername("Franc");

        session.save(company);
        session.save(haribo);
        session.save(cemoi);
        session.save(ferrero);
        session.save(lutti);
        session.save(chocolat);
        session.save(confiserie);
        session.save(france);
        session.save(etranger);
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        session.save(user6);
        session.save(user7);
        session.save(user8);
        session.save(user9);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
