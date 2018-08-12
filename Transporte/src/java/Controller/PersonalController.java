package Controller;

import Dao.PersonalDao;
import Model.PersonalModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "PersonalController")
@SessionScoped
public class PersonalController implements Serializable {

    List<PersonalModel> LstPers = new ArrayList();
    PersonalModel personalModel = new PersonalModel();

    @PostConstruct
    public void start() {
        try {
            listMantenimiento();
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(PersonalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroyWorld() {
        addMessage("System Error", "Please try again later.");
    }

    public void addMessage(String summary, String datail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, datail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void listMantenimiento() throws Exception {
        PersonalDao dao;
        try {
            dao = new PersonalDao();
            LstPers = dao.listarA();
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresar() throws Exception {
        PersonalDao dao;
        try {
            dao = new PersonalDao();
            dao.ingresar(personalModel);
            listMantenimiento();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ingreso correctamente"));
            limpiar();
        } catch (Exception e) {
            throw e;
        }

    }
     
    public void  actualizar() throws Exception{
    PersonalDao dao;
        try {
            dao = new  PersonalDao();
            dao.actualizar(personalModel);
            listMantenimiento();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    
    
    public void eliminar() throws Exception{
    PersonalDao dao;
        try {
            dao = new  PersonalDao();
            dao.eliminar(personalModel);
            listMantenimiento();
        } catch (Exception e) {
           throw e;
        }
    
    
    }
            

    public void limpiar() {
      personalModel = new PersonalModel();
    }

    public PersonalModel getPersonalModel() {
        return personalModel;
    }

    public void setPersonalModel(PersonalModel personalModel) {
        this.personalModel = personalModel;
    }

    public List<PersonalModel> getLstPers() {
        return LstPers;
    }

    public void setLstPers(List<PersonalModel> LstPers) {
        this.LstPers = LstPers;
    }

}
