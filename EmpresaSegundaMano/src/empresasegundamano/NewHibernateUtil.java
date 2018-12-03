package empresasegundamano;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author a16xianadm
 */
public class NewHibernateUtil {
    
    private static SessionFactory sessionFactory = buildSessionFactory();
 
    private static SessionFactory buildSessionFactory(){
       try{    
          if (sessionFactory == null){
             Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
             StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
             serviceRegistryBuilder.applySettings(configuration.getProperties());
             ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
          }
          return sessionFactory;
       } catch (HibernateException ex){
          System.err.println("Initial SessionFactory creation failed." + ex);
          throw new ExceptionInInitializerError(ex);
       }
    }

    public static SessionFactory getSessionFactory(){
       if(sessionFactory == null){
           buildSessionFactory();
       }
        return sessionFactory;
    }

    public static void closeSessionFactory(){
       if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) {
             sessionFactory.close();
        }
    }
    
    public static Session getSession(){   
        if(sessionFactory == null){
           buildSessionFactory();
       }
        return sessionFactory.openSession();
    }    
}
