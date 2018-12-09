package vista;
import empresasegundamano.NewHibernateUtil;
import java.awt.Color;
import java.net.URL;
import pojos.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
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
    
    
    //Atributos Taller 
    private ObservableList <Taller>listaTalleres = FXCollections.observableArrayList();
    @FXML
    private  TableView<Taller>tablaTaller;
    @FXML
    private  TableColumn<Taller,Integer>idTaller;
    @FXML
    private  TableColumn<Taller,String>nombreTaller;
    @FXML
    private  TextField texNombreTaller;
    private Taller tallerSeleccionado;
    
    
    //Atributos Exposicion
    private ObservableList <Exposicion>listaExpos = FXCollections.observableArrayList();
    @FXML
    private TableView<Exposicion> tablaExpo;
    @FXML 
    private TableColumn<Exposicion,Integer> idExpo;
    @FXML 
    private TableColumn<Exposicion,String> nombreExpo;
    @FXML 
    private TableColumn<Exposicion,String> lugarExpo;
    @FXML 
    private TextField texNombreExpo;
    @FXML 
    private TextField texLugarExpo;
    private Exposicion exposicionSeleccionada;
    
    
    //Atrubtos Vendedor
    private Vendedor vendedorSeleccionado;
    private ObservableList <Vendedor>listaVendedores = FXCollections.observableArrayList();
    private ObservableList opcionesVendedores = FXCollections.observableArrayList();
    @FXML
    private TableView<Vendedor>tablaVendedor;
    @FXML
    private TableColumn<Vendedor,String>dniVendedor;
    @FXML
    private TableColumn<Vendedor,String>nombreVendedor;
    @FXML
    private TableColumn<Vendedor,String>apellido1Vendedor;
    @FXML
    private TableColumn<Vendedor,String>apellido2Vendedor;
    @FXML
    private TableColumn<Vendedor,String>movilVendedor;
    @FXML
    private TableColumn<Vendedor,String>emailVendedor;
    @FXML
    private TableColumn<Vendedor,String>salarioVendedor;
    @FXML
    private TableColumn<Vendedor,String>comisionVendedor;
    @FXML
    private TableColumn<Vendedor,LocalDate>fechaVendedor;
    @FXML 
    private TextField texDniVendedor;
    @FXML 
    private TextField texNombreVendedor;
    @FXML 
    private TextField texApel1Vendedor;
    @FXML 
    private TextField texApel2Vendedor;
    @FXML 
    private TextField texMovilVendedor;
    @FXML 
    private TextField texEmailVendedor;
    @FXML
    private ComboBox texCondicionVendedor;
    @FXML 
    private TextField texCantidadVendedor;
    
    @FXML 
    private DatePicker altaVendedor;
    
    
    //Atributos Reparacion
    private Reparacion reparacionSeleccionada;
    private ObservableList <Reparacion>listaReparaciones = FXCollections.observableArrayList();
    private ObservableList opcionReparacion = FXCollections.observableArrayList();
    @FXML
    private TableView<Reparacion>tablaReparacion;
    @FXML
    private TableColumn<Reparacion,Integer>idReparacion;
    @FXML
    private TableColumn<Reparacion,Date>fechaReparacion;
    @FXML
    private TableColumn<Reparacion,String>descripcionReparacion;
    @FXML
    private TableColumn<Reparacion,Taller>tallerReparacion;
    @FXML
    private TableColumn<Reparacion,String>chapaReparacion;
    @FXML
    private TableColumn<Reparacion,String>electricaReparacion;
    @FXML
    private TableColumn<Reparacion,String>mecanicaReparacion;
    @FXML
    private DatePicker entfechaReparacion;
    @FXML
    private ComboBox comboReparacion;
    @FXML
    private TextField entDescripcionReparacion;
    @FXML
    private TextField entTallerReparacion;
    @FXML
    private TextField valorReparacion;
    
    
    //Atributos Coche
    private Coche cocheSeleccionado;
    private ObservableList <Coche>listaCoches = FXCollections.observableArrayList();
    private ObservableList opcionCoche = FXCollections.observableArrayList();
    @FXML
    private TableView<Coche> tablaCoches;
    @FXML
    private TableColumn<Coche,Integer> idCoche;
    @FXML
    private TableColumn<Coche,String> marcaCoche;
    @FXML
    private TableColumn<Coche,String> modeloCoche;
    @FXML
    private TableColumn<Coche,String> matriculaCoche;
    @FXML
    private TableColumn<Coche,Enum> tipoCoche;
    @FXML
    private TableColumn<Coche,String> precioVentaCoche;
    @FXML
    private TableColumn<Coche,String> precioCompraCoche;
    @FXML
    private TableColumn<Coche,Date> fechaAltaCoche;
    @FXML
    private TableColumn<Coche,Date> fechaBajaCoche;
    @FXML
    private TableColumn<Coche,Boolean> reparacionCoche;
    @FXML
    private TableColumn<Coche,Proveedor> proveedorCoche;
    @FXML
    private TableColumn<Coche,Exposicion> exposicionCoche;
    @FXML
    private TableColumn<Coche,Vendedor> vendedorCoche;
    @FXML
    private TableColumn<Coche,Cliente> clienteCoche;
    @FXML
    private TextField entMarcaCoche;
    @FXML
    private TextField entModeloCoche;
    @FXML
    private TextField entMatriculaCoche;
    @FXML
    private TextField entPrecioCompraCoche;
    @FXML
    private TextField entPrecioVentaCoche;
    @FXML
    private TextField entProveedorCoche;
    @FXML
    private TextField entExposicionCoche;
    @FXML
    private TextField entVendedorCoche;
    @FXML
    private TextField entClienteCoche;
    @FXML
    private ComboBox comboCoche;
    @FXML
    private CheckBox checkCoche;
    @FXML
    private DatePicker entFechaAlta;
    @FXML
    private DatePicker entFechaBaja;
    
    
    //Atributos Consultas
    @FXML
    private TableView<Coche> tablaCoches1;
    
    @FXML
    private TableColumn<Coche,Integer> idCoche1;
    @FXML
    private TableColumn<Coche,String> marcaCoche1;
    @FXML
    private TableColumn<Coche,String> modeloCoche1;
    @FXML
    private TableColumn<Coche,String> matriculaCoche1;
    @FXML
    private TableColumn<Coche,Enum> tipoCoche1;
    @FXML
    private TableColumn<Coche,String> precioVentaCoche1;
    @FXML
    private TableColumn<Coche,String> precioCompraCoche1;
    @FXML
    private TableColumn<Coche,Date> fechaAltaCoche1;
    @FXML
    private TableColumn<Coche,Date> fechaBajaCoche1;
    @FXML
    private TableColumn<Coche,Boolean> reparacionCoche1;
    @FXML
    private TableColumn<Coche,Proveedor> proveedorCoche1;
    @FXML
    private TableColumn<Coche,Exposicion> exposicionCoche1;
    @FXML
    private TableColumn<Coche,Vendedor> vendedorCoche1;
    @FXML
    private TableColumn<Coche,Cliente> clienteCoche1;
    @FXML 
    private TextField codCoche;
    @FXML 
    private TextArea textArea;
    
    
    //Metodos Proveedor
    @FXML
    private void darAltaProveedor(ActionEvent event ){
        String auxname=null;
        Date auxfecha=null;
        try{
            System.out.println(fechaAltaProveedor.getValue().toString());
            int dia=fechaAltaProveedor.getValue().getDayOfMonth();
            int mes=fechaAltaProveedor.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
            int año=(fechaAltaProveedor.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha= new Date(año,mes,dia);
            fechaAltaProveedor.setValue(vaciadorAlta);
            if(!texNombreProveedor.getText().isEmpty()){
            System.out.println(texNombreProveedor.getText());
            auxname=texNombreProveedor.getText();
            texNombreProveedor.setText(vaciadorString);
            Proveedor p=new Proveedor(auxname,auxfecha);
            listaProveedores.add(p);
            refrescarProveedores();
            guardarModificar(p);
        }
        else{
            System.out.println("No tiene nombre");
        }
        }
        catch(RuntimeException rte1){
            System.out.println("Non se introdujo fecha");
        } 
    }
    @FXML
    private void darBajaProveedor(ActionEvent event){
        Proveedor p=(Proveedor) tablaProveedores.getSelectionModel().getSelectedItem();
        listaProveedores.remove(p);
        refrescarProveedores();
        eliminar(p);
    }
    
    @FXML
    private void ModificarProveedor (ActionEvent event ){
        
        String auxname=null;
        Date auxfecha=null;
        try{
            Proveedor p=(Proveedor)tablaProveedores.getSelectionModel().getSelectedItem();
            int aux =tablaProveedores.getSelectionModel().getSelectedIndex();
            int dia=fechaAltaProveedor.getValue().getDayOfMonth();
            int mes=fechaAltaProveedor.getValue().getMonthValue(); //se resta 1 mes para cuadrar la fecha
            int año=(fechaAltaProveedor.getValue().getYear()); //se resta 1900 años para cuadrar la fecha
            auxfecha= new Date(año,mes,dia);
            fechaAltaProveedor.setValue(vaciadorAlta);
            if(!texNombreProveedor.getText().isEmpty()){
            System.out.println(texNombreProveedor.getText());
            auxname=texNombreProveedor.getText();
            texNombreProveedor.setText(vaciadorString);
            p=new Proveedor(auxname,auxfecha);
            listaProveedores.set(aux, p);
            refrescarProveedores();
            fechaAltaProveedor.setValue(vaciadorAlta);
            guardarModificar(p);
        }
        else{
            System.out.println("No tiene nombre");
        }
        }
        catch(RuntimeException rte1){
            System.out.println("Non se introdujo fecha");
        }
    }
    
    
    //Metodos Cliente
    @FXML
    public void darAltaCliente(ActionEvent event){
         Date auxfecha= null;
        if(texdniCliente.getText().isEmpty() || texnombreCliente.getText().isEmpty() ||
                texapel1Cliente.getText().isEmpty() || texapel2Cliente.getText().isEmpty() ||
                texmovilCliente.getText().isEmpty() || texmovilCliente.getText().isEmpty()){
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
            c = new Cliente(texdniCliente.getText(),texnombreCliente.getText(),
                    texapel1Cliente.getText(),texapel2Cliente.getText(),
                    texmovilCliente.getText(),texemailCliente.getText(),auxfecha);
            listaClientes.add(c);
            guardarModificar(c);
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
        Cliente c=(Cliente)tablaClientes.getSelectionModel().getSelectedItem();
        listaClientes.remove(c);
        System.out.println("Eliminado cliente "+c.getDni());
        texdniCliente.setText(vaciadorString);
        texnombreCliente.setText(vaciadorString);
        texapel1Cliente.setText(vaciadorString);
        texapel2Cliente.setText(vaciadorString);
        texmovilCliente.setText(vaciadorString);
        texemailCliente.setText(vaciadorString);
        entfechaCliente.setValue(vaciadorAlta);
        
        
        
        eliminar(c);
    }
    
    @FXML
    private void ModificarCliente (ActionEvent event ){
        Date auxfecha= null;
        Cliente e=(Cliente)tablaClientes.getSelectionModel().getSelectedItem();
        int aux=tablaClientes.getSelectionModel().getSelectedIndex();
        if(texdniCliente.getText().isEmpty() || texnombreCliente.getText().isEmpty() || 
                texapel1Cliente.getText().isEmpty() || texapel2Cliente.getText().isEmpty() || 
                texmovilCliente.getText().isEmpty() || texmovilCliente.getText().isEmpty()){
            System.out.println("Faltan datos, insercion cancelada");
        }else{
            try{
                int dia=entfechaCliente.getValue().getDayOfMonth();
                int mes=entfechaCliente.getValue().getMonthValue();
                int año=(entfechaCliente.getValue().getYear());
            auxfecha= new Date(año,mes,dia);
            }catch(RuntimeException rte1){
            System.out.println("Non se introdujo fecha");}
        
            e = new Cliente(texdniCliente.getText(),texnombreCliente.getText(),
            texapel1Cliente.getText(),texapel2Cliente.getText(),
            texmovilCliente.getText(),texemailCliente.getText(),auxfecha);
            listaClientes.set(aux, e);
            refrescarClientes();
            System.out.println("Editado cliente "+e.getDni());
            texdniCliente.setText(vaciadorString);
            texnombreCliente.setText(vaciadorString);
            texapel1Cliente.setText(vaciadorString);
            texapel2Cliente.setText(vaciadorString);
            texmovilCliente.setText(vaciadorString);
            texemailCliente.setText(vaciadorString);
            entfechaCliente.setValue(vaciadorAlta);
            guardarModificar(e);
        }
    }
    
    
    //Metodos Taller
    @FXML
    private void altaTaller(ActionEvent event){
        if(texNombreTaller.getText().isEmpty()){
            System.out.println("Falta el nombre.");
        }else{
            Taller t=new Taller(texNombreTaller.getText());
            listaTalleres.add(t);
            refrescarTalleres();
            texNombreTaller.setText(vaciadorString);
            guardarModificar(t);
        }
    }
    @FXML
    private void bajaTaller(ActionEvent event){
        Taller t= (Taller)tablaTaller.getSelectionModel().getSelectedItem();
        listaTalleres.remove(t);
        refrescarTalleres();
        texNombreTaller.setText(vaciadorString);
        eliminar(t);
    }
    @FXML
    private void modificacionTaller(ActionEvent event){
        Taller t= (Taller)tablaTaller.getSelectionModel().getSelectedItem();
        int aux = tablaTaller.getSelectionModel().getSelectedIndex();
        if(texNombreTaller.getText().isEmpty()){
            System.out.println("Falta nombre");
        }else{
            t.setNombre(texNombreTaller.getText());
            listaTalleres.set(aux, t);
            refrescarTalleres();
            texNombreTaller.setText(vaciadorString);
            guardarModificar(t);
        }

    }
    
    
    //Metodos Exposicion
    @FXML
    private void altaExpo (ActionEvent event){
        if(texNombreExpo.getText().isEmpty() || texLugarExpo.getText().isEmpty()){
            System.out.println("Faltan datos");
        }else{
            Exposicion e= new Exposicion();
            e.setNombre(texNombreExpo.getText());
            e.setLugar(texLugarExpo.getText());
            listaExpos.add(e);
            texNombreExpo.setText(vaciadorString);
            texLugarExpo.setText(vaciadorString);
            refresarExposiciones();
            guardarModificar(e);
        }
    }
    @FXML
    private void baixaExpo (ActionEvent event){
        Exposicion e= (Exposicion)tablaExpo.getSelectionModel().getSelectedItem();
        listaExpos.remove(e);
        texNombreExpo.setText(vaciadorString);
        texLugarExpo.setText(vaciadorString);
        refresarExposiciones();
        eliminar(e);
    }
    @FXML
    private void modificacionExpo (ActionEvent event){
        Exposicion e= (Exposicion)tablaExpo.getSelectionModel().getSelectedItem();
        int aux=tablaExpo.getSelectionModel().getSelectedIndex();
        if(texNombreExpo.getText().isEmpty() || texLugarExpo.getText().isEmpty()){
            System.out.println("Faltan datos");
        }else{
            e.setNombre(texNombreExpo.getText());
            e.setLugar(texLugarExpo.getText());
            listaExpos.set(aux, e);
            texNombreExpo.setText(vaciadorString);
            texLugarExpo.setText(vaciadorString);
            refresarExposiciones();
            guardarModificar(e);
        }
    }
    
    
    //Metodos Vendedor
    @FXML
    private void altaVendedor(ActionEvent event){
        Date auxfecha;
        try{
            int dia=altaVendedor.getValue().getDayOfMonth();
            int mes=altaVendedor.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
            int año=(altaVendedor.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha= new Date(año,mes,dia);
            if(texDniVendedor.getText().isEmpty() || texNombreVendedor.getText().isEmpty() || texApel1Vendedor.getText().isEmpty() || texApel2Vendedor.getText().isEmpty() || texMovilVendedor.getText().isEmpty() || texEmailVendedor.getText().isEmpty() || texCondicionVendedor.getSelectionModel().isEmpty() || texCantidadVendedor.getText().isEmpty()){
                System.out.println("Faltan datos, asegurese de llenar todos los campos.");
            }else{
                Vendedor v;
                if(texCondicionVendedor.getSelectionModel().getSelectedItem().equals("Asalariado")){
                    v =new VendedorAsalariado(Double.parseDouble(texCantidadVendedor.getText()),texDniVendedor.getText(),texNombreVendedor.getText(),texApel1Vendedor.getText(),texApel2Vendedor.getText(),texMovilVendedor.getText(),texEmailVendedor.getText(),auxfecha);
                }else{
                    v =new VendedorComision(Double.parseDouble(texCantidadVendedor.getText()),texDniVendedor.getText(),texNombreVendedor.getText(),texApel1Vendedor.getText(),texApel2Vendedor.getText(),texMovilVendedor.getText(),texEmailVendedor.getText(),auxfecha);
                }
                listaVendedores.add(v);
                refrescarVendedores();
                texDniVendedor.setText(vaciadorString);
                texNombreVendedor.setText(vaciadorString);
                texApel1Vendedor.setText(vaciadorString);
                texApel2Vendedor.setText(vaciadorString);
                texMovilVendedor.setText(vaciadorString);
                texCondicionVendedor.getSelectionModel().select(null);
                texCantidadVendedor.setText(vaciadorString);
                altaVendedor.setValue(vaciadorAlta);
                guardarModificar(v);
            }
            }catch(RuntimeException rte1){
                System.out.println("Non se introdujo fecha");
            }
        
    }
    @FXML
    private void bajaVendedor(ActionEvent event){
        Vendedor v=(Vendedor)tablaVendedor.getSelectionModel().getSelectedItem();
        listaVendedores.remove(v);
        refrescarVendedores();
        texDniVendedor.setText(vaciadorString);
        texNombreVendedor.setText(vaciadorString);
        texApel1Vendedor.setText(vaciadorString);
        texApel2Vendedor.setText(vaciadorString);
        texMovilVendedor.setText(vaciadorString);
        texCondicionVendedor.getSelectionModel().select(null);
        texCantidadVendedor.setText(vaciadorString);
        altaVendedor.setValue(vaciadorAlta);
        eliminar(v);
    }
    
    @FXML
    private void modificacionVendedor (ActionEvent event){
        Vendedor v=(Vendedor)tablaVendedor.getSelectionModel().getSelectedItem();
        int aux=tablaVendedor.getSelectionModel().getSelectedIndex();
        Date auxfecha;
        try{
            int dia=altaVendedor.getValue().getDayOfMonth();
            int mes=altaVendedor.getValue().getMonthValue(); //se resta 1 mes para cuadrar la fecha
            int año=(altaVendedor.getValue().getYear()); //se resta 1900 años para cuadrar la fecha
            auxfecha= new Date(año,mes,dia);
            if(texDniVendedor.getText().isEmpty() || texNombreVendedor.getText().isEmpty() || texApel1Vendedor.getText().isEmpty() || texApel2Vendedor.getText().isEmpty() || texMovilVendedor.getText().isEmpty() || texEmailVendedor.getText().isEmpty() || texCondicionVendedor.getSelectionModel().isEmpty() || texCantidadVendedor.getText().isEmpty()){
                System.out.println("Faltan datos, asegurese de llenar todos los campos.");
            }else{
                
                if(texCondicionVendedor.getSelectionModel().getSelectedItem().equals("Asalariado")){
                    v =new VendedorAsalariado(Double.parseDouble(texCantidadVendedor.getText()),texDniVendedor.getText(),texNombreVendedor.getText(),texApel1Vendedor.getText(),texApel2Vendedor.getText(),texMovilVendedor.getText(),texEmailVendedor.getText(),auxfecha);
                }else{
                    v =new VendedorComision(Double.parseDouble(texCantidadVendedor.getText()),texDniVendedor.getText(),texNombreVendedor.getText(),texApel1Vendedor.getText(),texApel2Vendedor.getText(),texMovilVendedor.getText(),texEmailVendedor.getText(),auxfecha);
                }
                listaVendedores.set(aux, v);
                refrescarVendedores();
                texDniVendedor.setText(vaciadorString);
                texNombreVendedor.setText(vaciadorString);
                texApel1Vendedor.setText(vaciadorString);
                texApel2Vendedor.setText(vaciadorString);
                texMovilVendedor.setText(vaciadorString);
                texCondicionVendedor.getSelectionModel().select(null);
                texCantidadVendedor.setText(vaciadorString);
                altaVendedor.setValue(vaciadorAlta);
                guardarModificar(v);
            }
            }catch(RuntimeException rte1){
                System.out.println("Non se introdujo fecha");
            }
    }
    
    
    //Metodos Reparacion
    @FXML
    private void altaReparacion(ActionEvent event){
        Date auxfecha;
        try{
            int dia=entfechaReparacion.getValue().getDayOfMonth();
            int mes=entfechaReparacion.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
            int año=(entfechaReparacion.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha = new Date(año,mes,dia);
            if(entDescripcionReparacion.getText().isEmpty() || entTallerReparacion.getText().isEmpty() || comboReparacion.getSelectionModel().isEmpty() || valorReparacion.getText().isEmpty()){
                System.out.println("Faltan datos, asegurese de llenar todos los campos.");
            }else{
                Reparacion c;
                if(comboReparacion.getSelectionModel().getSelectedItem().equals("Chapa")){
                    //OLLO COA TRAMPA
                    Taller t=new Taller("Pepito");
                    t.setIdTaller(Integer.parseInt(entTallerReparacion.getText()));
                    c =new ReparacionChapa(Color.BLACK,auxfecha,entDescripcionReparacion.getText(),t);
                    
                }else{
                    if(comboReparacion.getSelectionModel().getSelectedItem().equals("Eléctrica")){
                        //OLLO COA TRAMPA
                        Taller t=new Taller("Pepito");
                    t.setIdTaller(Integer.parseInt(entTallerReparacion.getText()));
                        c =new ReparacionElectrica(valorReparacion.getText(),auxfecha,entDescripcionReparacion.getText(),t);
                    }else{
                        //OLLO COA TRAMPA
                        Taller t=new Taller("Pepito");
                    t.setIdTaller(Integer.parseInt(entTallerReparacion.getText()));
                        c =new ReparacionMecanica(valorReparacion.getText(),auxfecha,entDescripcionReparacion.getText(),t);
                    }
                }
                listaReparaciones.add(c);
                refrescarReparaciones();
                entDescripcionReparacion.setText(vaciadorString);
                entTallerReparacion.setText(vaciadorString);
                texApel2Vendedor.setText(vaciadorString);
                valorReparacion.setText(vaciadorString);
                comboReparacion.getSelectionModel().select(null);
                texCantidadVendedor.setText(vaciadorString);
                entfechaReparacion.setValue(vaciadorAlta);
                guardarModificar(c);
            }
            }catch(RuntimeException rte1){
                System.out.println("Non se introdujo fecha");
            }
    }
    @FXML
    private void bajaReparacion(ActionEvent event){
        Reparacion r=(Reparacion)tablaReparacion.getSelectionModel().getSelectedItem();
        listaReparaciones.remove(r);
        refrescarReparaciones();
        entDescripcionReparacion.setText(vaciadorString);
        entTallerReparacion.setText(vaciadorString);
        texApel2Vendedor.setText(vaciadorString);
        valorReparacion.setText(vaciadorString);
        comboReparacion.getSelectionModel().select(null);
        texCantidadVendedor.setText(vaciadorString);
        entfechaReparacion.setValue(vaciadorAlta);
        eliminar(r);
    } 
    @FXML
    private void modificacionReparacion(ActionEvent event){
        Date auxfecha;
        int aux=tablaReparacion.getSelectionModel().getSelectedIndex();
        
        try{
            int dia=entfechaReparacion.getValue().getDayOfMonth();
            int mes=entfechaReparacion.getValue().getMonthValue(); //se resta 1 mes para cuadrar la fecha
            int año=(entfechaReparacion.getValue().getYear()); //se resta 1900 años para cuadrar la fecha
            auxfecha = new Date(año,mes,dia);
            if(entDescripcionReparacion.getText().isEmpty() || entTallerReparacion.getText().isEmpty() || comboReparacion.getSelectionModel().isEmpty() || valorReparacion.getText().isEmpty()){
                System.out.println("Faltan datos, asegurese de llenar todos los campos.");
            }else{
                Reparacion c;
                if(comboReparacion.getSelectionModel().getSelectedItem().equals("Chapa")){
                    //OLLO COA TRAMPA
                    Taller t=new Taller("Pepito");
                    t.setIdTaller(Integer.parseInt(entTallerReparacion.getText()));
                    c = new ReparacionChapa(Color.BLACK,auxfecha,entDescripcionReparacion.getText(),t);
                }else{
                    if(comboReparacion.getSelectionModel().getSelectedItem().equals("Eléctrica")){
                        //OLLO COA TRAMPA
                        Taller t=new Taller("Pepito");
                    t.setIdTaller(Integer.parseInt(entTallerReparacion.getText()));
                        c =new ReparacionElectrica(valorReparacion.getText(),auxfecha,entDescripcionReparacion.getText(),t);
                    }else{
                        //OLLO COA TRAMPA
                        Taller t=new Taller("Pepito");
                    t.setIdTaller(Integer.parseInt(entTallerReparacion.getText()));
                        c =new ReparacionMecanica(valorReparacion.getText(),auxfecha,entDescripcionReparacion.getText(),t);
                    }
                }
                listaReparaciones.set(aux,c);
                refrescarReparaciones();
                entDescripcionReparacion.setText(vaciadorString);
                entTallerReparacion.setText(vaciadorString);
                texApel2Vendedor.setText(vaciadorString);
                valorReparacion.setText(vaciadorString);
                comboReparacion.getSelectionModel().select(null);
                texCantidadVendedor.setText(vaciadorString);
                entfechaReparacion.setValue(vaciadorAlta);
                guardarModificar(c);
            }
            }catch(RuntimeException rte1){
                System.out.println("Non se introdujo fecha");
            }
    }
    
    
    //Metodos Coche
     @FXML
    private void altaCoche(ActionEvent event){
        Date auxfecha1;
        Date auxfecha2;
        Proveedor proveedor = new Proveedor();//OLLO COA TRAMPA
        Exposicion expo = new Exposicion();//OLLO COA TRAMPA
        Vendedor vendedor = new VendedorAsalariado();//OLLO COA TRAMPA
        Cliente cliente= new Cliente();//OLLO COA TRAMPA
        try{
            int dia=entFechaAlta.getValue().getDayOfMonth();
            int mes=entFechaAlta.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
            int año=(entFechaAlta.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha1 = new Date(año,mes,dia);
            dia=entFechaBaja.getValue().getDayOfMonth();
            mes=entFechaBaja.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
            año=(entFechaBaja.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha2 = new Date(año,mes,dia);
        if(entMarcaCoche.getText().isEmpty() || entModeloCoche.getText().isEmpty() || entMatriculaCoche.getText().isEmpty() || 
                comboCoche.getSelectionModel().getSelectedItem().toString().isEmpty() || entPrecioCompraCoche.getText().isEmpty() || 
                entPrecioVentaCoche.getText().isEmpty() || entProveedorCoche.getText().isEmpty() || entExposicionCoche.getText().isEmpty() || 
                entVendedorCoche.getText().isEmpty() || entClienteCoche.getText().isEmpty()){
            System.out.println("Faltan datos, rellene todos los campos");
        }else{
            proveedor.setIdProveedor(Integer.parseInt(entProveedorCoche.getText()));
            expo.setIdExposicion(Integer.parseInt(entExposicionCoche.getText()));
            vendedor.setDni(entVendedorCoche.getText());
            cliente.setDni(entClienteCoche.getText());
            double compra=Double.parseDouble(entPrecioCompraCoche.getText());
            double venta=Double.parseDouble(entPrecioVentaCoche.getText());
            //OLLO COA TRAMPA
            Coche c= new Coche(entMarcaCoche.getText(), entModeloCoche.getText(), entMatriculaCoche.getText(),compra, venta, checkCoche.isSelected(), auxfecha1, auxfecha2, proveedor, expo, vendedor, cliente);
            listaCoches.add(c);
            refrescarCoches();
            entMarcaCoche.setText(vaciadorString);
            entModeloCoche.setText(vaciadorString);
            entMatriculaCoche.setText(vaciadorString);
            entPrecioCompraCoche.setText(vaciadorString);
            entPrecioVentaCoche.setText(vaciadorString);
            checkCoche.setSelected(false);
            entFechaAlta.setValue(vaciadorAlta);
            entFechaBaja.setValue(vaciadorAlta);
            entProveedorCoche.setText(vaciadorString);
            entExposicionCoche.setText(vaciadorString);
            entVendedorCoche.setText(vaciadorString);
            entClienteCoche.setText(vaciadorString);
            guardarModificar(c);
                    }
        
            }catch(RuntimeException rte1){
                System.out.println("Non se introdujo fecha");
            }
    }
    @FXML
    private void bajaCoche(ActionEvent event){
        Coche c=(Coche)tablaCoches.getSelectionModel().getSelectedItem();
        listaCoches.remove(c);
        refrescarCoches();
        entDescripcionReparacion.setText(vaciadorString);
        entTallerReparacion.setText(vaciadorString);
        texApel2Vendedor.setText(vaciadorString);
        valorReparacion.setText(vaciadorString);
        comboReparacion.getSelectionModel().select(null);
        texCantidadVendedor.setText(vaciadorString);
        entfechaReparacion.setValue(vaciadorAlta);
        eliminar(c);
    }
    @FXML
    private void modificacionCoche(ActionEvent event){
        Coche c;
        int aux=tablaCoches.getSelectionModel().getSelectedIndex();
        Date auxfecha1;
        Date auxfecha2;
        Proveedor proveedor = new Proveedor();//OLLO COA TRAMPA
        Exposicion expo = new Exposicion();//OLLO COA TRAMPA
        Vendedor vendedor = new VendedorAsalariado();//OLLO COA TRAMPA
        Cliente cliente= new Cliente();//OLLO COA TRAMPA
        try{
            int dia=entFechaAlta.getValue().getDayOfMonth();
            int mes=entFechaAlta.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
            int año=(entFechaAlta.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha1 = new Date(año,mes,dia);
            dia=entFechaBaja.getValue().getDayOfMonth();
            mes=entFechaBaja.getValue().getMonthValue()-1; //se resta 1 mes para cuadrar la fecha
            año=(entFechaBaja.getValue().getYear()-1900); //se resta 1900 años para cuadrar la fecha
            auxfecha2 = new Date(año,mes,dia);
        if(entMarcaCoche.getText().isEmpty() || entModeloCoche.getText().isEmpty() || entMatriculaCoche.getText().isEmpty() || 
                comboCoche.getSelectionModel().getSelectedItem().toString().isEmpty() || entPrecioCompraCoche.getText().isEmpty() || 
                entPrecioVentaCoche.getText().isEmpty() || entProveedorCoche.getText().isEmpty() || entExposicionCoche.getText().isEmpty() || 
                entVendedorCoche.getText().isEmpty() || entClienteCoche.getText().isEmpty()){
            System.out.println("Faltan datos, rellene todos los campos");
        }else{
            proveedor.setIdProveedor(Integer.parseInt(entProveedorCoche.getText()));
            expo.setIdExposicion(Integer.parseInt(entExposicionCoche.getText()));
            vendedor.setDni(entVendedorCoche.getText());
            cliente.setDni(entClienteCoche.getText());
            double compra=Double.parseDouble(entPrecioCompraCoche.getText());
            double venta=Double.parseDouble(entPrecioVentaCoche.getText());
            //OLLO COA TRAMPA
            c= new Coche(entMarcaCoche.getText(), entModeloCoche.getText(), entMatriculaCoche.getText(),compra, venta, checkCoche.isSelected(), auxfecha1, auxfecha2, proveedor, expo, vendedor, cliente);
            listaCoches.set(aux,c);
            refrescarCoches();
            entMarcaCoche.setText(vaciadorString);
            entModeloCoche.setText(vaciadorString);
            entMatriculaCoche.setText(vaciadorString);
            entPrecioCompraCoche.setText(vaciadorString);
            entPrecioVentaCoche.setText(vaciadorString);
            checkCoche.setSelected(false);
            entFechaAlta.setValue(vaciadorAlta);
            entFechaBaja.setValue(vaciadorAlta);
            entProveedorCoche.setText(vaciadorString);
            entExposicionCoche.setText(vaciadorString);
            entVendedorCoche.setText(vaciadorString);
            entClienteCoche.setText(vaciadorString);
            guardarModificar(c);
            }
            }catch(RuntimeException rte1){
                System.out.println("Non se introdujo fecha");
            }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        sesion=NewHibernateUtil.getSession();
        
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
        
        idTaller.setCellValueFactory(new PropertyValueFactory("idTaller"));
        nombreTaller.setCellValueFactory(new PropertyValueFactory("nombre"));
        
        nombreExpo.setCellValueFactory(new PropertyValueFactory("nombre"));
        lugarExpo.setCellValueFactory(new PropertyValueFactory("lugar"));
        idExpo.setCellValueFactory(new PropertyValueFactory("idExposicion"));
        
        dniVendedor.setCellValueFactory(new PropertyValueFactory("dni"));
        nombreVendedor.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellido1Vendedor.setCellValueFactory(new PropertyValueFactory("apellido1"));
        apellido2Vendedor.setCellValueFactory(new PropertyValueFactory("apellido2"));
        movilVendedor.setCellValueFactory(new PropertyValueFactory("movil"));
        emailVendedor.setCellValueFactory(new PropertyValueFactory("email"));
        fechaVendedor.setCellValueFactory(new PropertyValueFactory("fechaAlta"));
        salarioVendedor.setCellValueFactory(new PropertyValueFactory("salario"));
        comisionVendedor.setCellValueFactory(new PropertyValueFactory("comision"));
        
        idReparacion.setCellValueFactory(new PropertyValueFactory("idReparacion"));
        fechaReparacion.setCellValueFactory(new PropertyValueFactory("fecha"));
        descripcionReparacion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        tallerReparacion.setCellValueFactory(new PropertyValueFactory("Taller"));
        chapaReparacion.setCellValueFactory(new PropertyValueFactory("colorChapa"));
        electricaReparacion.setCellValueFactory(new PropertyValueFactory("componente"));
        mecanicaReparacion.setCellValueFactory(new PropertyValueFactory("parte"));
        
        idCoche.setCellValueFactory(new PropertyValueFactory("idCoche"));
        marcaCoche.setCellValueFactory(new PropertyValueFactory("marca"));
        modeloCoche.setCellValueFactory(new PropertyValueFactory("modelo"));
        matriculaCoche.setCellValueFactory(new PropertyValueFactory("matricula"));
        tipoCoche.setCellValueFactory(new PropertyValueFactory("tipo"));
        precioCompraCoche.setCellValueFactory(new PropertyValueFactory("precioCompra"));
        precioVentaCoche.setCellValueFactory(new PropertyValueFactory("precioVenta"));
        fechaAltaCoche.setCellValueFactory(new PropertyValueFactory("fechaAlta"));
        fechaBajaCoche.setCellValueFactory(new PropertyValueFactory("fechaVenta"));
        reparacionCoche.setCellValueFactory(new PropertyValueFactory("reparado"));
        proveedorCoche.setCellValueFactory(new PropertyValueFactory("proveedor"));
        exposicionCoche.setCellValueFactory(new PropertyValueFactory("exposicion"));
        vendedorCoche.setCellValueFactory(new PropertyValueFactory("vendedor"));
        clienteCoche.setCellValueFactory(new PropertyValueFactory("cliente"));
        
        idCoche1.setCellValueFactory(new PropertyValueFactory("idCoche"));
        marcaCoche1.setCellValueFactory(new PropertyValueFactory("marca"));
        modeloCoche1.setCellValueFactory(new PropertyValueFactory("modelo"));
        matriculaCoche1.setCellValueFactory(new PropertyValueFactory("matricula"));
        tipoCoche1.setCellValueFactory(new PropertyValueFactory("tipo"));
        precioCompraCoche1.setCellValueFactory(new PropertyValueFactory("precioCompra"));
        precioVentaCoche1.setCellValueFactory(new PropertyValueFactory("precioVenta"));
        fechaAltaCoche1.setCellValueFactory(new PropertyValueFactory("fechaAlta"));
        fechaBajaCoche1.setCellValueFactory(new PropertyValueFactory("fechaVenta"));
        reparacionCoche1.setCellValueFactory(new PropertyValueFactory("reparado"));
        proveedorCoche1.setCellValueFactory(new PropertyValueFactory("proveedor"));
        exposicionCoche1.setCellValueFactory(new PropertyValueFactory("exposicion"));
        vendedorCoche1.setCellValueFactory(new PropertyValueFactory("vendedor"));
        clienteCoche1.setCellValueFactory(new PropertyValueFactory("cliente"));
        
        
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
            texNombreProveedor.setText(proveedorSeleccionado.getNombre());
        });
        tablaTaller.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Taller> observable, Taller oldValue, Taller newValue) ->{
           tallerSeleccionado=null;
            tallerSeleccionado=newValue;
            texNombreTaller.setText(tallerSeleccionado.getNombre());
        });
        
        tablaExpo.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Exposicion> observable, Exposicion oldValue, Exposicion newValue) ->{
           exposicionSeleccionada=null;
            exposicionSeleccionada=newValue;
            texNombreExpo.setText(exposicionSeleccionada.getNombre());
            texLugarExpo.setText(exposicionSeleccionada.getLugar());
        });
        
        opcionesVendedores.add("Asalariado");
        opcionesVendedores.add("Comisionista");
        texCondicionVendedor.setItems(opcionesVendedores);
        
        tablaVendedor.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Object> observable, Object oldValue, Object newValue) ->{
            vendedorSeleccionado=null;
            if(newValue.getClass().getCanonicalName().equalsIgnoreCase("pojos.VendedorAsalariado")){
                VendedorAsalariado v =(VendedorAsalariado)newValue;
                vendedorSeleccionado=v;
                texDniVendedor.setText(v.getDni());
                texNombreVendedor.setText(v.getNombre());
                texApel1Vendedor.setText(v.getApellido1());
                texApel2Vendedor.setText(v.getApellido2());
                texMovilVendedor.setText(v.getMovil());
                texEmailVendedor.setText(v.getEmail());
                LocalDate ld=LocalDate.of(v.getFechaAlta().getYear(), v.getFechaAlta().getMonth(), v.getFechaAlta().getDate());
                altaVendedor.setValue(ld);
                texCantidadVendedor.setText(String.valueOf(v.getSalario()));
                texCondicionVendedor.getSelectionModel().select("Asalariado");
            }else{
                VendedorComision v =(VendedorComision)newValue;
                vendedorSeleccionado=v;
                texDniVendedor.setText(v.getDni());
                texNombreVendedor.setText(v.getNombre());
                texApel1Vendedor.setText(v.getApellido1());
                texApel2Vendedor.setText(v.getApellido2());
                texMovilVendedor.setText(v.getMovil());
                texEmailVendedor.setText(v.getEmail());
                LocalDate ld=LocalDate.of(v.getFechaAlta().getYear(), v.getFechaAlta().getMonth(), v.getFechaAlta().getDate());
                altaVendedor.setValue(ld);
                texCantidadVendedor.setText(String.valueOf(v.getComision()));
                texCondicionVendedor.getSelectionModel().select("Comisionista");
            }
        });
        opcionReparacion.add("Chapa");
        opcionReparacion.add("Eléctrica");
        opcionReparacion.add("Mecánica");
        comboReparacion.setItems(opcionReparacion);
        
        tablaReparacion.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Object> observable, Object oldValue, Object newValue) ->{
            reparacionSeleccionada=null;
            if(newValue.getClass().getCanonicalName().equalsIgnoreCase("pojos.ReparacionChapa")){
                ReparacionChapa rc =(ReparacionChapa)newValue;
                reparacionSeleccionada=rc;
                LocalDate ld=LocalDate.of(rc.getFecha().getYear(), rc.getFecha().getMonth(), rc.getFecha().getDate());
                entfechaReparacion.setValue(ld);
                entDescripcionReparacion.setText(rc.getDescripcion());
                entTallerReparacion.setText(String.valueOf(rc.getTaller().getIdTaller()));
                comboReparacion.getSelectionModel().select("Chapa");
                valorReparacion.setText(rc.getColorChapa().toString());
            }else{
                if(newValue.getClass().getCanonicalName().equalsIgnoreCase("pojos.ReparacionElectrica")){
                ReparacionElectrica rc =(ReparacionElectrica)newValue;
                reparacionSeleccionada=rc;
                LocalDate ld=LocalDate.of(rc.getFecha().getYear(), rc.getFecha().getMonth(), rc.getFecha().getDate());
                entfechaReparacion.setValue(ld);
                entDescripcionReparacion.setText(rc.getDescripcion());
                entTallerReparacion.setText(String.valueOf(rc.getTaller().getIdTaller()));
                comboReparacion.getSelectionModel().select("Eléctrica");
                valorReparacion.setText(rc.getComponente());
                }else{
                    if(newValue.getClass().getCanonicalName().equalsIgnoreCase("pojos.ReparacionMecanica")){
                ReparacionMecanica rc =(ReparacionMecanica)newValue;
                reparacionSeleccionada=rc;
                LocalDate ld=LocalDate.of(rc.getFecha().getYear(), rc.getFecha().getMonth(), rc.getFecha().getDate());
                entfechaReparacion.setValue(ld);
                entDescripcionReparacion.setText(rc.getDescripcion());
                entTallerReparacion.setText(String.valueOf(rc.getTaller().getIdTaller()));
                comboReparacion.getSelectionModel().select("Mecanica");
                valorReparacion.setText(rc.getParte());
                }}
            }
            });
        opcionCoche.add("TURISMO");
        opcionCoche.add("INDUSTRIAL");
        opcionCoche.add("TODOTERRENO");
        comboCoche.setItems(opcionCoche);
        tablaCoches.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends Coche> observable, Coche oldValue, Coche newValue) -> {
            cocheSeleccionado= null;
            cocheSeleccionado= newValue;
            entMarcaCoche.setText(cocheSeleccionado.getMarca());
            entModeloCoche.setText(cocheSeleccionado.getModelo());
            entMatriculaCoche.setText(cocheSeleccionado.getMatricula());
            entPrecioCompraCoche.setText(String.valueOf(cocheSeleccionado.getPrecioCompra()));
            entPrecioVentaCoche.setText(String.valueOf(cocheSeleccionado.getPrecioVenta()));
            LocalDate ld=LocalDate.of(cocheSeleccionado.getFechaAlta().getYear(),cocheSeleccionado.getFechaAlta().getMonth(), cocheSeleccionado.getFechaAlta().getDate());
            entFechaAlta.setValue(ld);
            LocalDate la=LocalDate.of(cocheSeleccionado.getFechaVenta().getYear(),cocheSeleccionado.getFechaVenta().getMonth(), cocheSeleccionado.getFechaVenta().getDate());
            entFechaBaja.setValue(la);
            if(cocheSeleccionado.isReparado()){
                checkCoche.setSelected(true);
            }else{
                checkCoche.setSelected(false);
            }
            entProveedorCoche.setText(String.valueOf(cocheSeleccionado.getProveedor().getIdProveedor()));
            entExposicionCoche.setText(String.valueOf(cocheSeleccionado.getExposicion().getIdExposicion()));
            entVendedorCoche.setText(cocheSeleccionado.getVendedor().getDni());
            entClienteCoche.setText(cocheSeleccionado.getCliente().getDni());
        });
        
    }
    
    public void refrescarProveedores(){
        tablaProveedores.setItems(listaProveedores);
    }
    
    public void refrescarClientes(){
        tablaClientes.setItems(listaClientes);
    }
    
    public void refrescarTalleres(){
        tablaTaller.setItems(listaTalleres);
    }
    
    public void refresarExposiciones(){
        tablaExpo.setItems(listaExpos);
    }
    
    public void refrescarVendedores(){
        tablaVendedor.setItems(listaVendedores);
    }
    
     public void refrescarReparaciones(){
        tablaReparacion.setItems(listaReparaciones);
    }
     
      public void refrescarCoches(){
        tablaCoches.setItems(listaCoches);
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
    
    
    
    @FXML
    private void buscarCliente(ActionEvent event){
        //Introducir aqui o codigo para que mediante este codigo:
       if(codCoche.getText().isEmpty()){
           System.out.println("Falta o codigo para realizar a busqueda.");
       }else{
        //Atope o cliente que o ten, e devolva varios dos seus datos aqui, por ejemplo estes:
        textArea.setText("O coche de codigo "+codCoche.getText()+" é propiedade de mendanito, con codigo tal.\nE se non existe, pois que nn existe");
       }
        
    }
    @FXML
    private void listarCoches(ActionEvent event){
        tablaCoches1.setItems(listaCoches);
        //se queres asegurarte de que funciona, mete coches mediante a interfaz e dalle a listar.
        
    }
}
