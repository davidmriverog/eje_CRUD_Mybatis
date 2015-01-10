package com.mybatis.beans;

import com.mybatis.dao.TcontactosDAO;
import com.mybatis.models.Tcontactos;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named(value="mbContactos")
@ViewScoped
public class mbContactos implements Serializable{

    private Tcontactos tcontactos;
    private List<Tcontactos> listarcontactos;
    
    private int valorID;
    
    private boolean disabledRegistro;
    private boolean disabledActualizacion;

    
    public mbContactos() {
        tcontactos = new Tcontactos();
        
        this.disabledRegistro = true;
        this.disabledActualizacion = true;
    }
    
    public Tcontactos getTcontactos() {
        return tcontactos;
    }

    public void setTcontactos(Tcontactos tcontactos) {
        this.tcontactos = tcontactos;
    }
    
    public List<Tcontactos> getListarcontactos() {
        return listarcontactos;
    }

    public void setListarcontactos(List<Tcontactos> listarcontactos) {
        this.listarcontactos = listarcontactos;
    }
    public int getValorID() {
        return valorID;
    }

    public void setValorID(int valorID) {
        this.valorID = valorID;
    }
    public boolean isDisabledRegistro() {
        return disabledRegistro;
    }

    public void setDisabledRegistro(boolean disabledRegistro) {
        this.disabledRegistro = disabledRegistro;
    }

    public boolean isDisabledActualizacion() {
        return disabledActualizacion;
    }

    public void setDisabledActualizacion(boolean disabledActualizacion) {
        this.disabledActualizacion = disabledActualizacion;
    }
    
    
    // Metodos a Emplear en el Bean desde la Vista
    public void buscarContactosById(){
        
        try {
              TcontactosDAO daoContact = new TcontactosDAO();
              
              this.tcontactos = daoContact.selectById(this.valorID);
              
            if(this.tcontactos!=null){
                                
                 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Tu nombre es:"+this.tcontactos.getNombres()));
                 
                 this.disabledActualizacion = false;
                 
            }else{
                
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:","No Existe en Nuestra BD"));
               
               this.disabledRegistro = false;
               
            }
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal Error: Al Parecer algo Salio Mal", e.getMessage()));
        }
        
       
        
        RequestContext.getCurrentInstance().update("frmContactos:panelbusqueda");
        RequestContext.getCurrentInstance().update("frmContactos:panelContactos");
        RequestContext.getCurrentInstance().update("frmContactos:mensajeGeneral");
    }
           
    
    public List<Tcontactos> getAllContactos(){
        
        // LLamamos el Dao donde Implementamos Nuestros Procesos
        TcontactosDAO daoContact = new TcontactosDAO();
        
        this.listarcontactos = daoContact.selectAll();
        
        return this.listarcontactos;
    }
       
}
