package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.UsuarioPerfil;
import br.com.diario.escolar.view.session.UsuarioPerfilFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "usuarioPerfilController")
@ViewScoped
public class UsuarioPerfilController extends AbstractController<UsuarioPerfil> {

    @EJB
    private UsuarioPerfilFacade ejbFacade;
    private UsuarioController seqUsuarioController;
    private PerfilController seqPerfilController;

    /**
     * Initialize the concrete UsuarioPerfil controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
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
        seqUsuarioController = context.getApplication().evaluateExpressionGet(context, "#{usuarioController}", UsuarioController.class);
        seqPerfilController = context.getApplication().evaluateExpressionGet(context, "#{perfilController}", PerfilController.class);
    }

    public UsuarioPerfilController() {
        // Inform the Abstract parent controller of the concrete UsuarioPerfil?cap_first Entity
        super(UsuarioPerfil.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqUsuarioController.setSelected(null);
        seqPerfilController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqUsuario(ActionEvent event) {
        if (this.getSelected() != null && seqUsuarioController.getSelected() == null) {
            seqUsuarioController.setSelected(this.getSelected().getSeqUsuario());
        }
    }

    /**
     * Sets the "selected" attribute of the Perfil controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqPerfil(ActionEvent event) {
        if (this.getSelected() != null && seqPerfilController.getSelected() == null) {
            seqPerfilController.setSelected(this.getSelected().getSeqPerfil());
        }
    }
}
