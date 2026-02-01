package org.prakash;

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

    public static  boolean createAlien(Alien alien) throws Exception{

        try {
            SessionFactory sf = new Configuration()
                    .addAnnotatedClass(org.prakash.Alien.class)
                    .addAnnotatedClass(org.prakash.Laptop.class)
                    .configure()
                    .buildSessionFactory();

            Session session = sf.openSession();

            Transaction tx = session.beginTransaction();

            for (Laptop laptop : alien.getLaptops()) {
                session.persist(laptop);
            }

            session.persist(alien);

            tx.commit();
            Alien res = session.getReference(Alien.class, alien.getAid());
            System.out.println(res);
            session.close();
            sf.close();

            return true;
        } catch (Exception e) {
            throw new MyExpception("Failed " + e.toString());
        }

    }

}
