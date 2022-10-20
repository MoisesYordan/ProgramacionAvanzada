package Vistas;
import Modelos.GestionProyecto.*;
import javax.swing.JDesktopPane;

public class GestorVistaPrincipal extends GestorVista{
    public FrmPrincipal frmPrincipal;

    public void abrirPrincipal() {
        FrmPrincipal frmPrincipal = new FrmPrincipal(this);
        frmPrincipal.setVisible(true);
    }
    
    public  void abrirMarca(JDesktopPane escritorio) {
        GestorVistaMarca gestor= new GestorVistaMarca();
        gestor.openFormulario(escritorio); 
    }
    
    public  void abrirModelo(JDesktopPane escritorio) {
        GestorVistaModelo gestor= new GestorVistaModelo();
        gestor.openFormulario(escritorio); 
    }
    public  void abrirAuto(JDesktopPane escritorio) {
        GestorVistaAuto gestor= new GestorVistaAuto();
        gestor.openFormulario(escritorio); 
    }
     public  void abrirEmpleado(JDesktopPane escritorio) {
        GestorVistaEmpleado gestor= new GestorVistaEmpleado();
        gestor.openFormulario(escritorio); 
    }
    public  void abrirCliente(JDesktopPane escritorio) {
        GestorVistaCliente gestor= new GestorVistaCliente();
        gestor.openFormulario(escritorio); 
        }
    public  void abrirVentas(JDesktopPane escritorio) {
        GestorVistaVentas gestor= new GestorVistaVentas();
        gestor.openFormulario(escritorio); 
    }
    public  void abrirPais(JDesktopPane escritorio) {
        GestorVistaPais gestor= new GestorVistaPais();
        gestor.openFormulario(escritorio); 
    }
}
