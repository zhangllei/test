package hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class HibernateUtil {
		
	public static final SessionFactory SESSION_FACTROY = buildFactroy();
	private static SessionFactory buildFactroy(){
		
		Configuration con = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory  factory = con.buildSessionFactory(sr);
		return factory;
		
	}
	
	public static SessionFactory getSessionFactory(){
		return SESSION_FACTROY;
	}
}
