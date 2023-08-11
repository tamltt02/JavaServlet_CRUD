package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	 private static EntityManagerFactory factory ;
	 public static EntityManager getEntity() {
		 if(factory == null || factory.isOpen()) {
			 factory = Persistence.createEntityManagerFactory("Thuu");
			
		 }
		 return factory.createEntityManager();
	 
	 }
	 public static  void shutdown () {
		 if(factory != null && factory.isOpen()) {
			 factory.close();
		 }
		 factory = null ; 
	 }
}
