/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Menu;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class MenuView {

    private MenuModel model;
    private List<Menu> listaMenu;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        generateMenu(listaMenu);
        
        //First submenu
        DefaultSubMenu cadastroSubmenu = new DefaultSubMenu("Cadastro");
        DefaultSubMenu segurancaSubmenu = new DefaultSubMenu("Segurança");
        DefaultSubMenu turmasSubmenu = new DefaultSubMenu("Turmas");

        DefaultMenuItem item = new DefaultMenuItem("External");
        //item.setUrl("http://www.primefaces.org");
        item.setOutcome("index.xhtml");
        item.setIcon("ui-icon-home");
        cadastroSubmenu.addElement(item);

        model.addElement(cadastroSubmenu);

        

        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
        item.setUpdate("messages");
        turmasSubmenu.addElement(item);

        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        turmasSubmenu.addElement(item);


        model.addElement(turmasSubmenu);
        model.addElement(segurancaSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void generateMenu(List<Menu> listaMenu) {
        listaMenu = new ArrayList<Menu>();

        Menu menuPaiCadastro = new Menu();
        menuPaiCadastro.setNumOrdem(1);
        menuPaiCadastro.setTxtTitulo("Cadastro");
        listaMenu.add(menuPaiCadastro);

        Menu menuPaiSeguranca = new Menu();
        menuPaiSeguranca.setNumOrdem(2);
        menuPaiSeguranca.setTxtTitulo("Segurança");
        listaMenu.add(menuPaiSeguranca);

        Menu menuFilhoCadastroAluno = new Menu();
        menuFilhoCadastroAluno.setNumOrdem(1);
        menuFilhoCadastroAluno.setTxtTitulo("Aluno");
        menuFilhoCadastroAluno.setSeqMenuPai(menuPaiCadastro);
        listaMenu.add(menuFilhoCadastroAluno);
    }
}
