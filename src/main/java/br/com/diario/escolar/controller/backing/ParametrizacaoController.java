package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Parametrizacao;
import br.com.diario.escolar.view.session.ParametrizacaoFacade;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "parametrizacaoController")
@ViewScoped
public class ParametrizacaoController extends AbstractController<Parametrizacao> {

    @EJB
    private ParametrizacaoFacade ejbFacade;
    //private ParametrizacaoController seqParametrizacaoPaiController;

    /**
     * Initialize the concrete Parametrizacao controller bean. The
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
       // seqParametrizacaoPaiController = context.getApplication().evaluateExpressionGet(context, "#{parametrizacaoController}", ParametrizacaoController.class);
    }

    public ParametrizacaoController() {
        // Inform the Abstract parent controller of the concrete Parametrizacao?cap_first Entity
        super(Parametrizacao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
//        seqParametrizacaoPaiController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Parametrizacao entities
     * that are retrieved from Parametrizacao?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Parametrizacao page
     */
    public String navigateParametrizacaoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Parametrizacao_items", this.getSelected().getParametrizacaoList());
        }
        return "/pages/prime/parametrizacao/index";
    }

    /**
     * Sets the "selected" attribute of the Parametrizacao controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqParametrizacaoPai(ActionEvent event) {
      //  if (this.getSelected() != null && seqParametrizacaoPaiController.getSelected() == null) {
        //    seqParametrizacaoPaiController.setSelected(this.getSelected().getSeqParametrizacaoPai());
       // }
    }

    /**
     * Sets the "items" attribute with a collection of Atividade entities that
     * are retrieved from Parametrizacao?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Atividade page
     */
    public String navigateAtividadeList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Atividade_items", this.getSelected().getAtividadeList());
        }
        return "/pages/prime/atividade/index";
    }

    /**
     * Sets the "items" attribute with a collection of Ano entities that are
     * retrieved from Parametrizacao?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Ano page
     */
    public String navigateAnoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ano_items", this.getSelected().getAnoList());
        }
        return "/pages/prime/ano/index";
    }

    /**
     * Sets the "items" attribute with a collection of Notas entities that are
     * retrieved from Parametrizacao?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Notas page
     */
    public String navigateNotasList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Notas_items", this.getSelected().getNotasList());
        }
        return "/pages/prime/notas/index";
    }
    
    public Collection<Parametrizacao> getFilhosNivelEscolar() {
        if (super.items == null) {
            super.items = this.ejbFacade.findFilhosNivelEscolar();
        }
        return super.items;
    }
    
    public Collection<Parametrizacao> getStatusAlunoTurma() {
        if (super.items == null) {
            super.items = this.ejbFacade.findStatusAlunoTurma();
        }
        return super.items;
    }

}
