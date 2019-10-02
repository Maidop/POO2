package br.edu.utfpr.pb.maikon.pscheidt.avaliacao1.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory emf;
    
    public static EntityManager getEntityManager(){
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("avaliacao1");
        }
        return emf.createEntityManager();
    }
}
