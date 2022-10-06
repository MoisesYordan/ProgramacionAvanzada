package Hibernate;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil  {
    public static SessionFactory sessionFactory;
    public static Session session;

    public static void inicializar() {
        try {
           Configuration conf = new Configuration(); 
           try{
                conf.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
                conf.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");                 
                conf.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/PROGRAMACIONA");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de Base de Datos Nº 2001");
            }
            
            conf.setProperty("hibernate.connection.username","postgres");
            conf.setProperty("hibernate.connection.password","12");

            conf.setProperty("hibernate.connection.pool_size","10");                          
            conf.setProperty("hibernate.hbm2ddl.auto","update");

            conf.addPackage("Modelos.GestionProyecto");
          //  conf.addAnnotatedClass(Modelos.GestionProyecto.Proyecto.class);
           // conf.addAnnotatedClass(Modelos.GestionProyecto.TipoProyecto.class);
           // conf.addAnnotatedClass(Modelos.GestionProyecto.ItemProyecto.class);
            
            //clases del proyecto
            conf.addAnnotatedClass(Modelos.GestionProyecto.Pais.class);
            conf.addAnnotatedClass(Modelos.GestionProyecto.Modelo.class);
            conf.addAnnotatedClass(Modelos.GestionProyecto.Marca.class);
            conf.addAnnotatedClass(Modelos.GestionProyecto.Auto.class);
            conf.addAnnotatedClass(Modelos.GestionProyecto.Empleado.class);
            conf.addAnnotatedClass(Modelos.GestionProyecto.Cliente.class);
            conf.addAnnotatedClass(Modelos.GestionProyecto.Ventas.class);
            try {
                    sessionFactory = conf.buildSessionFactory();
                    session=sessionFactory.openSession();
                }
                catch(HibernateException e){
                    JOptionPane.showMessageDialog(null, e);
                }
        } catch (HeadlessException ex) {
            throw new ExceptionInInitializerError(ex);
        } catch (MappingException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession()
    throws HibernateException {
        return session;
    }
}
