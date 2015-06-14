package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.AlunoTurma;
import br.com.diario.escolar.model.entity.Notas;
import br.com.diario.escolar.model.entity.Presenca;
import br.com.diario.escolar.view.session.NotasFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import org.primefaces.event.CellEditEvent;

@ManagedBean(name = "notasController")
@ViewScoped
public class NotasController extends AbstractController<Notas> {

    @EJB
    private NotasFacade ejbFacade;
    private PessoaController seqPessoaController;
    private ParametrizacaoController seqParamePeriodoController;
    private AtividadeController seqAtividadeController;
    private AnoController seqAnoController;
    private AlunoController seqAlunoController;
    private AlunoTurmaController alunoTurmaController;
    private TurmaController seqTurmaController;
    private List<Notas> listNotas;
    private List<String> options;
    

    /**
     * Initialize the concrete Notas controller bean. The AbstractController
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
        seqParamePeriodoController = context.getApplication().evaluateExpressionGet(context, "#{parametrizacaoController}", ParametrizacaoController.class);
        seqAtividadeController = context.getApplication().evaluateExpressionGet(context, "#{atividadeController}", AtividadeController.class);
        seqAnoController = context.getApplication().evaluateExpressionGet(context, "#{anoController}", AnoController.class);
        seqAlunoController = context.getApplication().evaluateExpressionGet(context, "#{alunoController}", AlunoController.class);
        alunoTurmaController = context.getApplication().evaluateExpressionGet(context, "#{alunoTurmaController}", AlunoTurmaController.class);
        seqTurmaController = context.getApplication().evaluateExpressionGet(context, "#{turmaController}", TurmaController.class);
        initListaPresenca();
    }
    
    public List<Notas> getListPresenca() {
        return listNotas;
    }

    public void setListPresenca(List<Notas> listNotas) {
        this.listNotas = listNotas;
    }

    public NotasController() {
        // Inform the Abstract parent controller of the concrete Notas?cap_first Entity
        super(Notas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqPessoaController.setSelected(null);
        seqParamePeriodoController.setSelected(null);
        seqAtividadeController.setSelected(null);
        seqAnoController.setSelected(null);
        seqAlunoController.setSelected(null);
        alunoTurmaController.setSelected(null);
        seqTurmaController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Parametrizacao controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqParamePeriodo(ActionEvent event) {
        if (this.getSelected() != null && seqParamePeriodoController.getSelected() == null) {
            seqParamePeriodoController.setSelected(this.getSelected().getSeqParamePeriodo());
        }
    }

    /**
     * Sets the "selected" attribute of the Atividade controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqAtividade(ActionEvent event) {
        if (this.getSelected() != null && seqAtividadeController.getSelected() == null) {
            seqAtividadeController.setSelected(this.getSelected().getSeqAtividade());
        }
    }

    /**
     * Sets the "selected" attribute of the Ano controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqAno(ActionEvent event) {
        if (this.getSelected() != null && seqAnoController.getSelected() == null) {
            seqAnoController.setSelected(this.getSelected().getSeqAno());
        }
    }

    /**
     * Sets the "selected" attribute of the Aluno controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqAluno(ActionEvent event) {
        if (this.getSelected() != null && seqAlunoController.getSelected() == null) {
            seqAlunoController.setSelected(this.getSelected().getSeqAluno());
        }
    }
     
    
    public Notas prepareCreateNotas(ActionEvent event) {
        return super.prepareCreate(event); //To change body of generated methods, choose Tools | Templates.
    }

    public void saveTurma(ActionEvent event) {
        for (Notas item : listNotas) {
            this.ejbFacade.create(item);
        }
        if (!isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
        }
    }

    public List<Notas> prepareCreatePresenca(ActionEvent event) {
        return listNotas;
    }

    public void populaListaPresenca() {
        alunoTurmaController.getAlunosTurma(seqTurmaController.getSelected().getSeqTurma());
        initListaPresenca();
        for (AlunoTurma alunoTurma : alunoTurmaController.getItems()) {
            Notas presenca = new Notas(null,super.getSelected().getDatLancamento());
            presenca.setSeqAluno(alunoTurma.getSeqAluno());
            listNotas.add(presenca);
        }
    }
    
    
    private void initListaPresenca() {
        listNotas = new ArrayList<Notas>();
        options = new ArrayList<String>();
        options.add("S");
        options.add("N");
    }

    public void onCellEdit(CellEditEvent event) {
        Object newValue = event.getNewValue();
        //listNotas.get(event.getRowIndex()).setFlgPresente(newValue.toString());
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
     
}
