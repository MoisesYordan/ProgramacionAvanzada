package ireport;
import java.io.File;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import java.sql.Connection;
import net.sf.jasperreports.view.*;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
/**
 * Este Gestor toma la fuente de datos tipo java.util.Collection seteada con anterioridad en la clase FuenteDeDatosCollection,
 * toma los los parametros necesarios con el metodo  agregarParametro(String nombreParametro,String valorParametro)
 * y lanza un hilo con el metodo run() donde arma el reporte con los parametros, el archivo jasper seleccionado 
 * en el constructor y la fuente de datos mencionada anteriormente. Una vez listo el reporte instancia un visor y lo muestra.
 *
 * @author Fernando Boiero
 */

public class GestorDeReportes  extends Thread {

    private String archivo;
    private Session session;
    private Map parametro = new HashMap();
    private FuenteDeDatosCollection fuenteDeDatos=new  FuenteDeDatosCollection();  
    private JasperReport masterReport;
    JasperPrint jasperPrint;
    
    /** Crea una nueva instancia del gestor pasandole como parametro el path del archivo .jasper del reporte.
     * este path es el path dentro del jar el directorio src es la raiz 
     * @param archivo 
     */

    
    public GestorDeReportes(String archivo, Session session,Map parametro) {
        this.archivo=archivo;
        this.session= session;
        this.parametro= parametro;
        
        
    }



    /** Setea la coleccion de datos del reporte, esta coleccion debe contener javaBeans que
     * coincidan sus atributos, encapsulados por sus accesores, con los fields usados en el 
     * reporte 
     * @param datos
     */
  public void setColeccionDeDatos(Collection datos){
      FuenteDeDatosCollection.setColeccionDeDatos(datos);
  }
  /** Agrega un parametro al reporte, este parametro debe coincidir con los parametros 
     * previamente creados en el reporte 
     * @param nombreParametro nombre del parametro definido en el reporte
     * @param valorParametro String con el valor del parametro
     */
  public void agregarParametro(String nombreParametro,String valorParametro){
                   getParametros().put(nombreParametro, valorParametro);
                        
  }
/** Agrega un parametro al reporte, este parametro debe coincidir con los parametros 
     * previamente creados en el reporte 
     * @param nombreParametro nombre del parametro definido en el reporte
     * @param valorParametro Object con el valor del parametro
     */
  public void agregarParametro(String nombreParametro,Object valorParametro){
                   getParametros().put(nombreParametro, valorParametro);                       
  }
  /**
   * Lanza un hilo con el metodo run() donde arma el reporte con los parametros, el archivo jasper seleccionado 
   * en el constructor y la fuente de datos mencionada anteriormente. Una vez listo el reporte instancia un visor y lo muestra.
   */
    public void imprimir(){
        try{
            this.run();
        }catch(Exception e){System.out.println(" "+e);}
    }
    

    @Override
    public void run(){
        SessionImplementor miSessionImplementor = (SessionImplementor) session;
        Connection conn = (Connection) miSessionImplementor.connection();
        try{ 
             JRDataSource jrd=null;
            if (jasperPrint==null){
//                URL url=this.getClass().getClassLoader().getResource(this.archivo);
                File arc = new File (this.archivo);
                setMasterReport((JasperReport) JRLoader.loadObject(arc));
                try{
                  jrd= fuenteDeDatos.createBeanCollectionDatasource();
                } catch (Exception ek) {
                 System.out.println("error 1");   
            ek.printStackTrace();
        }
               System.out.println("parametros="+this.getParametros().toString());
//              System.out.println("fuenteDeDatos: cantidad="+FuenteDeDatosCollection.getColeccionDeDatos().size()
//                      +" "+FuenteDeDatosCollection.getColeccionDeDatos().toString());
             
                jasperPrint= JasperFillManager.fillReport(masterReport,parametro,conn);
            }
             JasperViewer jviewer = new JasperViewer(jasperPrint,false);   
             jviewer.setTitle("Reporte");
            jviewer.setVisible(true); 
        } catch (Exception ek) {
            System.out.println("error 2");  
            ek.printStackTrace();
        }
           
    }

      public void generarImpresion(){

        try{
             JRDataSource jrd=null;
            if (jasperPrint==null){
                //URL url=this.getClass().getClassLoader().getResource(this.archivo);
                //URL url=this.archivo;
                setMasterReport((JasperReport) JRLoader.loadObject(this.archivo));
                try{
                  jrd= fuenteDeDatos.createBeanCollectionDatasource();
                } catch (Exception ek) {
                 System.out.println("error 1");
            ek.printStackTrace();
        }
               System.out.println("parametros="+this.getParametros().toString());
              System.out.println("fuenteDeDatos: cantidad="+FuenteDeDatosCollection.getColeccionDeDatos().size()
                      +" "+FuenteDeDatosCollection.getColeccionDeDatos().toString());
                jasperPrint= JasperFillManager.fillReport(masterReport,this.getParametros(),jrd);
            }
            // JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            // jviewer.setTitle("Reporte");
            //jviewer.setVisible(true);

             JasperPrintManager.printReport(jasperPrint, false);
        } catch (Exception ek) {
            System.out.println("error 2");
            ek.printStackTrace();
        }

    }


    public JasperReport getMasterReport() {
        return masterReport;
    }

    public void setMasterReport(JasperReport masterReport) {
        this.masterReport = masterReport;
    }

    public Map getParametros() {
        return parametro;
    }

    public void setParametros(Map parametros) {
        this.parametro = parametros;
    }   
    
  
}










