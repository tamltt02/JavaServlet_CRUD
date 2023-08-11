package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	 private  static EntityManagerFactory factory ;
	 private static EntityManager em ;
	 
	 private static EntityManagerFactory getFactory() {
		 if(factory == null || factory.isOpen() == false) {
			factory = Persistence.createEntityManagerFactory("BaiTap"); 
		 }
		 return factory;
	 }
	 
	 public static EntityManager getEntity() {
		 if(em == null || em.isOpen() == false) {
			 em = getFactory().createEntityManager(); 
			 }
			 return em;
	 }
}
