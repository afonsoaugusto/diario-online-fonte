package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Usuario;
import br.com.diario.escolar.controller.session.UsuarioFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @EJB
    private UsuarioFacade ejbFacade;
    private PessoaController seqPessoaController;

    /**
     * Initialize the concrete Usuario controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     * <p>
     * In addition, this controller also requires references to controllers for
     * parent entities in order to display their information from a context
     * menu.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
        FacesContext context = FacesContext.getCurrentInstance();
        seqPessoaController = context.getApplication().evaluateExpressionGet(context, "#{pessoaController}", PessoaController.class);
    }

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario?cap_first Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqPessoaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of UsuarioPerfil entities
     * that are retrieved from Usuario?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for UsuarioPerfil page
     */
    public String navigateUsuarioPerfilList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UsuarioPerfil_items", this.getSelected().getUsuarioPerfilList());
        }
        return "/pages/prime/usuarioPerfil/index";
    }

    /**
     * Sets the "selected" attribute of the Pessoa controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqPessoa(ActionEvent event) {
        if (this.getSelected() != null && seqPessoaController.getSelected() == null) {
            seqPessoaController.setSelected(this.getSelected().getSeqPessoa());
        }
    }
}
