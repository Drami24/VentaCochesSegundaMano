/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import empresasegundamano.HibernateUtil;
import empresasegundamano.NewHibernateUtil;
import java.net.URL;
import pojos.Cliente;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import mapeos.Proveedor;


/**
 *
 * @author a18franciscorm
 */
public class ControladorVentana implements Initializable{
    String vaciadorString="";
    LocalDate vaciadorAlta=null;
    //Atributos Proveedor:
    @FXML
    private TextField texNombreProveedor;
    
    @FXML
    private DatePicker fechaAltaProveedor;
    
    @FXML
    private TableView<Proveedor> tablaProveedores;
    
    @FXML
    private TableColumn idProveedor;
    
    @FXML
    private TableColumn nombreProveedor;
    
    @FXML
    private TableColumn fechaProveedor;
    private ObservableList <Proveedor>listaProveedores = FXCollections.observableArrayList();
    
    //Atributos Cliente
    @FXML
    private TableView<Cliente> tablaCliente;
    @FXML
    private TableColumn dniCliente;
    @FXML
    private TableColumn nombreCliente;
    @FXML
    private TableColumn apellido1Cliente;
    @FXML
    private TableColumn Apellido2Cliente;
    @FXML
    private TableColumn movilCliente;
    @FXML
    private TableColumn emailCliente;
    @FXML
    private TableColumn fechaCliente;
    @FXML
    private TextField texdniCliente;
    @FXML
    private TextField texnombreCliente;
    @FXML
    private TextField texapel1Cliente;
    @FXML
    private TextField texapel2Cliente;
    @FXML
    private TextField texmovilCliente;
    @FXML
    private TextField texemailCliente;
    @FXML
    private DatePicker entfechaCliente;
    
    
    
    
    private Session sesion;
    
    //Metodos Proveedor
    @FXML
    private void darAltaProveedor(ActionEvent event ){
        String auxname=null;
        Date auxfecha=null;
        System.out.println("Click en alta, datos: ");
        if(!texNombreProveedor.getText().isEmpty()){
            System.out.println(texNombreProveedor.getText());
            auxname=texNombreProveedor.getText();
            texNombreProveedor.setText(vaciadorString);
        }
        else{
            System.out.println("No tiene nombre");
        }
        try{
            System.out.println(fechaAltaProveedor.getValue().toString());
            int dia=fechaAltaProveedor.getValue().getDayOfMonth();
            int mes=fechaAltaProveedor.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
            int año=(fechaAltaProveedor.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha= new Date(año,mes,dia);
            fechaAltaProveedor.setValue(vaciadorAlta);
        }
        catch(RuntimeException rte1){
            System.out.println("Non se introdujo fecha");
        }
        
        Proveedor p=new Proveedor(auxname,auxfecha);
        
        guardarModificar(p);
        listaProveedores.add(p);
        refrescar(listaProveedores);
        //listaproveedores.add(p);
        //refrescar(listaProveedores);
    }
    @FXML
    private void darBajaProveedor(ActionEvent event){
        Proveedor p=(Proveedor) tablaProveedores.getSelectionModel().getSelectedItem();
        eliminar(p);
    }
    
    @FXML
    private void ModificarProveedor (ActionEvent event ){
//        ClienteP e=(ClienteP)tablaProveedores.getSelectionModel().getSelectedItem();
//        System.out.println(e.id);
        //Buscar e modificar no arrayList
        System.out.println("Click en modificar");
        
    }
    //Metodos Cliente
    @FXML
    public void darAltaCliente(ActionEvent event){
        texdniCliente.setText("Holiii");
        texnombreCliente.setText("Holiii");
        texapel1Cliente.setText("Holiii");
        texapel2Cliente.setText("Holiii");
        texmovilCliente.setText("Holiii");
        texemailCliente.setText("Holiii");
        //entfechaCliente.setValue("");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Buenas, me he iniciado.");
        idProveedor.setCellValueFactory(new PropertyValueFactory("id"));
        nombreProveedor.setCellValueFactory(new PropertyValueFactory("nombre"));
        fechaProveedor.setCellValueFactory(new PropertyValueFactory("fecha"));
        sesion=NewHibernateUtil.getSession();
    }
    public void refrescar(ObservableList ol){
        tablaProveedores.setItems(ol);
        
        
    }
    
    
    private void guardarModificar(Object objeto){
        sesion.beginTransaction();
        sesion.saveOrUpdate(objeto);
        sesion.getTransaction().commit();
        sesion.clear();
    }
    
    
    private void eliminar(Object objeto){
        sesion.beginTransaction();
        sesion.delete(objeto);
        sesion.getTransaction().commit();
        sesion.clear();
    }
    
    
    private void cargarDatos(){
        
    }
}
