package vista;
import empresasegundamano.HibernateUtil;
import empresasegundamano.NewHibernateUtil;
import java.net.URL;
import pojos.Cliente;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
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

public class ControladorVentana implements Initializable{
    Cliente clienteSeleccionado= null;
    Proveedor proveedorSeleccionado= null;
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
    private TableColumn<Proveedor,Integer> idProveedor;
    @FXML
    private TableColumn<Proveedor,String> nombreProveedor;
    @FXML
    private TableColumn<Proveedor,Date> fechaProveedor;
    private ObservableList <Proveedor>listaProveedores = FXCollections.observableArrayList();
    
    //Atributos Cliente
    @FXML
    private TableView<Cliente> tablaClientes;
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
    
    private ObservableList <Cliente>listaClientes = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Cliente,String>dniCliente;
    @FXML
    private TableColumn<Cliente,String>nombreCliente;
    @FXML
    private TableColumn<Cliente,String>apellido1Cliente;
    @FXML
    private TableColumn<Cliente,String>apellido2Cliente;
    @FXML
    private TableColumn<Cliente,String>movilCliente;
    @FXML
    private TableColumn<Cliente,String>emailCliente;
    @FXML
    private TableColumn<Cliente,Date>fechaCliente;
    private Session sesion;
    
    //Metodos Proveedor
    @FXML
    private void darAltaProveedor(ActionEvent event ){
        String auxname=null;
        Date auxfecha=null;
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
        System.out.println(p.getIdproveedor()+","+p.getFechaalta());
        //guardarModificar(p);
        listaProveedores.add(p);
        refrescarProveedores();
    }
    @FXML
    private void darBajaProveedor(ActionEvent event){
        Proveedor p=(Proveedor) tablaProveedores.getSelectionModel().getSelectedItem();
        listaProveedores.remove(p);
        refrescarProveedores();
        
        //eliminar(p);
    }
    
    @FXML
    private void ModificarProveedor (ActionEvent event ){
        Proveedor p=(Proveedor)tablaProveedores.getSelectionModel().getSelectedItem();
        int aux =tablaProveedores.getSelectionModel().getSelectedIndex();
        p.setIdproveedor(25);
        listaProveedores.remove(aux);
        listaProveedores.add(aux, p);
        refrescarProveedores();
        
        System.out.println("Click en modificar");
        
    }
    //Metodos Cliente
    
    @FXML
    public void darAltaCliente(ActionEvent event){
         Date auxfecha= null;
        if(texdniCliente.getText().isEmpty() || texnombreCliente.getText().isEmpty() || texapel1Cliente.getText().isEmpty() || texapel2Cliente.getText().isEmpty() || texmovilCliente.getText().isEmpty() || texmovilCliente.getText().isEmpty()){
            System.out.println("Faltan datos, insercion cancelada");
        }else{
            try{
                int dia=entfechaCliente.getValue().getDayOfMonth();
                int mes=entfechaCliente.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
                int año=(entfechaCliente.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
                auxfecha= new Date(año,mes,dia);
            }catch(RuntimeException rte1){
                System.out.println("Non se introdujo fecha");
            }
            Cliente c;
            c = new Cliente(texdniCliente.getText(),texnombreCliente.getText(),texapel1Cliente.getText(),texapel2Cliente.getText(),texmovilCliente.getText(),texemailCliente.getText(),auxfecha);
            listaClientes.add(c);
            refrescarClientes();
            texdniCliente.setText(vaciadorString);
            texnombreCliente.setText(vaciadorString);
            texapel1Cliente.setText(vaciadorString);
            texapel2Cliente.setText(vaciadorString);
            texmovilCliente.setText(vaciadorString);
            texemailCliente.setText(vaciadorString);
            entfechaCliente.setValue(vaciadorAlta);
        }
    }
    @FXML
    private void darBajaCliente(ActionEvent event){
        Cliente e=(Cliente)tablaClientes.getSelectionModel().getSelectedItem();
        listaClientes.remove(e);
        System.out.println("Eliminado cliente "+e.getDni());
        texdniCliente.setText(vaciadorString);
        texnombreCliente.setText(vaciadorString);
        texapel1Cliente.setText(vaciadorString);
        texapel2Cliente.setText(vaciadorString);
        texmovilCliente.setText(vaciadorString);
        texemailCliente.setText(vaciadorString);
        entfechaCliente.setValue(vaciadorAlta);
        
        //eliminar(c);
    }
    
    @FXML
    private void ModificarCliente (ActionEvent event ){
        Date auxfecha= null;
        Cliente e=(Cliente)tablaClientes.getSelectionModel().getSelectedItem();
        int aux=tablaClientes.getSelectionModel().getSelectedIndex();
        if(texdniCliente.getText().isEmpty() || texnombreCliente.getText().isEmpty() || texapel1Cliente.getText().isEmpty() || texapel2Cliente.getText().isEmpty() || texmovilCliente.getText().isEmpty() || texmovilCliente.getText().isEmpty()){
            System.out.println("Faltan datos, insercion cancelada");
        }else{
            try{
                int dia=entfechaCliente.getValue().getDayOfMonth();
                int mes=entfechaCliente.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
                int año=(entfechaCliente.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha= new Date(año,mes,dia);
            }catch(RuntimeException rte1){
            System.out.println("Non se introdujo fecha");}
        
            e = new Cliente(texdniCliente.getText(),texnombreCliente.getText(),texapel1Cliente.getText(),texapel2Cliente.getText(),texmovilCliente.getText(),texemailCliente.getText(),auxfecha);
            listaClientes.remove(aux);
            listaClientes.add(aux, e);
            refrescarClientes();
            System.out.println("Editado cliente "+e.getDni());
            texdniCliente.setText(vaciadorString);
            texnombreCliente.setText(vaciadorString);
            texapel1Cliente.setText(vaciadorString);
            texapel2Cliente.setText(vaciadorString);
            texmovilCliente.setText(vaciadorString);
            texemailCliente.setText(vaciadorString);
            entfechaCliente.setValue(vaciadorAlta);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Buenas, me he iniciado.");
        idProveedor.setCellValueFactory(new PropertyValueFactory("idProveedor"));
        nombreProveedor.setCellValueFactory(new PropertyValueFactory("nombre"));
        fechaProveedor.setCellValueFactory(new PropertyValueFactory<Proveedor,Date>("fechaAlta"));
        
        dniCliente.setCellValueFactory(new PropertyValueFactory("dni"));
        nombreCliente.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellido1Cliente.setCellValueFactory(new PropertyValueFactory("apellido1"));
        apellido2Cliente.setCellValueFactory(new PropertyValueFactory("apellido2"));
        movilCliente.setCellValueFactory(new PropertyValueFactory("movil"));
        emailCliente.setCellValueFactory(new PropertyValueFactory("email"));
        fechaCliente.setCellValueFactory(new PropertyValueFactory("fechaAlta"));
        sesion=NewHibernateUtil.getSession();
        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Cliente> observable, Cliente oldValue, Cliente newValue) -> {
            clienteSeleccionado= null;
            clienteSeleccionado= newValue;
            texdniCliente.setText(clienteSeleccionado.getDni());
            texnombreCliente.setText(clienteSeleccionado.getNombre());
            texapel1Cliente.setText(clienteSeleccionado.getApellido1());
            texapel2Cliente.setText(clienteSeleccionado.getApellido2());
            texmovilCliente.setText(clienteSeleccionado.getMovil());
            texemailCliente.setText(clienteSeleccionado.getEmail());
            entfechaCliente.setValue(vaciadorAlta);
        });
        tablaProveedores.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Proveedor> observable, Proveedor oldValue, Proveedor newValue) ->{
            proveedorSeleccionado=null;
            proveedorSeleccionado=newValue;
            System.out.println(proveedorSeleccionado.getIdproveedor());
        });
    }
    
    public void refrescarProveedores(){
        tablaProveedores.setItems(listaProveedores);
    }
    
    public void refrescarClientes(){
        tablaClientes.setItems(listaClientes);
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
