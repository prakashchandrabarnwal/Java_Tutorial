package org.prakash.manyToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class MyExpception extends Exception{
    public MyExpception(String msg){
        super(msg);
    }
}

public class AlienService {

    public static  boolean createAlien(List<Alien> aliens , List<Laptop> laptops) throws Exception{

        try {
            SessionFactory sf = new Configuration()
                    .addAnnotatedClass(org.prakash.manyToMany.Alien.class)
                    .addAnnotatedClass(org.prakash.manyToMany.Laptop.class)
                    .configure()
                    .buildSessionFactory();

            Session session = sf.openSession();

            Transaction tx = session.beginTransaction();

            for (Laptop laptop : laptops) {
                session.persist(laptop);
            }

            for(Alien alien : aliens){
                session.persist(alien);
            }

            

            tx.commit();
           
            session.close();
            sf.close();

            return true;
        } catch (Exception e) {
            throw new MyExpception("Failed " + e.toString());
        }

    }

}
