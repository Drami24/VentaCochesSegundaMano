/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.net.URL;
import pojos.Cliente;
import java.time.LocalDate;
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

/**
 *
 * @author a18franciscorm
 */
public class ControladorVentana implements Initializable{
    String vaciadorString="";
    LocalDate vaciadorAlta=null;
    
    @FXML
    private TextField texId;
    
    @FXML
    private TextField texName;
    
    @FXML
    private DatePicker fechaAlta;
    
    @FXML
    private TableView tablaProveedores;
    
    @FXML
    private TableColumn id;
    
    @FXML
    private TableColumn nombre;
    
    @FXML
    private TableColumn fecha;
    private ObservableList <ClienteP>listaproveedores = FXCollections.observableArrayList();
    
    @FXML
    private void darAlta(ActionEvent event ){
        String auxid=null,auxname=null,auxdata=null;
        System.out.println("Click en alta, datos: ");
        if(!texId.getText().isEmpty()){
            System.out.println(texId.getText());
            auxid=texId.getText();
            texId.setText(vaciadorString);}
        else{
            System.out.println("No tiene id");
            auxid="nada";
        }
        if(!texName.getText().isEmpty()){
            System.out.println(texName.getText());
            auxname=texName.getText();
            texName.setText(vaciadorString);
        }
        else{
            System.out.println("No tiene nombre");
            auxname="nada";
        }
        try{
            System.out.println(fechaAlta.getValue().toString());
            auxdata=fechaAlta.getValue().toString();
            fechaAlta.setValue(vaciadorAlta);
        }
        catch(RuntimeException rte1){
            System.out.println("Non se introduxo Data");
            auxdata="nada";
        }
        
        ClienteP e=new ClienteP(auxid,auxname,auxdata);
        listaproveedores.add(e);
        refrescar(listaproveedores);
    }
    
    @FXML
    private void darBaja(ActionEvent event ){
        
        System.out.println("Click en Baja");
        
    }
    
    @FXML
    private void Modificar (ActionEvent event ){
        ClienteP e=(ClienteP)tablaProveedores.getSelectionModel().getSelectedItem();
        System.out.println(e.id);
        //Buscar e modificar no arrayList
        System.out.println("Click en modificar");
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Buenas, me he iniciado.");
        id.setCellValueFactory(new PropertyValueFactory("id"));
        nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
    }
    public void refrescar(ObservableList ol){
        tablaProveedores.setItems(ol);
    }
    
}
