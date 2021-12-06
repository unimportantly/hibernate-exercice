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

import java.util.HashSet;
import java.util.Set;

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
        Set<Subsidiary> subsidiaries = new HashSet<Subsidiary>();

        Subsidiary haribo = new Subsidiary();
        haribo.setName("Haribo");
        haribo.setCompany(company);
        subsidiaries.add(haribo);

        Subsidiary lutti = new Subsidiary();
        lutti.setName("lutti");
        lutti.setCompany(company);
        subsidiaries.add(lutti);

        Subsidiary ferrero = new Subsidiary();
        ferrero.setName("ferrero");
        ferrero.setCompany(company);
        subsidiaries.add(ferrero);

        Subsidiary cemoi = new Subsidiary();
        cemoi.setName("cemoi");
        cemoi.setCompany(company);
        subsidiaries.add(cemoi);

        Set<Sector> locationSet = new HashSet<Sector>();
        Set<Sector> productSet = new HashSet<Sector>();

        Sector chocolat = new Sector();
        Set<Subsidiary> chocolatSubsidiaries = new HashSet<Subsidiary>();
        Set<User> chocolatUser = new HashSet<User>();
        chocolat.setName("chocolat");
        chocolat.setLocation("Paris");
        productSet.add(chocolat);
        chocolatSubsidiaries.add(cemoi);
        chocolatSubsidiaries.add(ferrero);

        Sector confiserie = new Sector();
        Set<Subsidiary> confiserieSubsidiaries = new HashSet<Subsidiary>();
        Set<User> confiserieUser = new HashSet<User>();
        confiserie.setName("confiserie");
        confiserie.setLocation("Lille");
        productSet.add(chocolat);
        confiserieSubsidiaries.add(lutti);
        confiserieSubsidiaries.add(haribo);

        Sector france = new Sector();
        Set<Subsidiary> franceSubsidiaries = new HashSet<Subsidiary>();
        Set<User> franceUser = new HashSet<User>();
        france.setName("France");
        france.setLocation("France");
        locationSet.add(france);
        franceSubsidiaries.add(cemoi);
        franceSubsidiaries.add(lutti);

        Sector etranger = new Sector();
        Set<Subsidiary> etrangerSubsidiaries = new HashSet<Subsidiary>();
        Set<User> etrangerUser = new HashSet<User>();
        etranger.setName("Etranger");
        etranger.setLocation("Etranger");
        locationSet.add(etranger);
        etrangerSubsidiaries.add(ferrero);
        etrangerSubsidiaries.add(haribo);


        User user1 = new User();
        user1.setUsername("Paul");
        user1.setSector(chocolat);
        chocolatUser.add(user1);
        User user2 = new User();
        user2.setUsername("Pierre");
        user2.setSector(chocolat);
        chocolatUser.add(user2);
        User user3 = new User();
        user3.setUsername("Jacques");
        user3.setSector(confiserie);
        confiserieUser.add(user3);
        User user4 = new User();
        user4.setUsername("Henri");
        user4.setSector(confiserie);
        confiserieUser.add(user4);
        User user5 = new User();
        user5.setUsername("Marc");
        user5.setSector(france);
        franceUser.add(user5);
        User user6 = new User();
        user6.setUsername("Louis");
        user6.setSector(france);
        franceUser.add(user6);
        User user7 = new User();
        user7.setUsername("Maxime");
        user7.setSector(etranger);
        etrangerUser.add(user7);
        User user8 = new User();
        user8.setUsername("Auguste");
        user8.setSector(chocolat);
        chocolatUser.add(user8);
        User user9 = new User();
        user9.setUsername("Franc");
        user9.setSector(confiserie);
        confiserieUser.add(user9);



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
