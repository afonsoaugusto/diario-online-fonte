package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.AlunoTurma;
import br.com.diario.escolar.model.entity.Presenca;
import br.com.diario.escolar.model.entity.Turma;
import br.com.diario.escolar.controller.session.PresencaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import org.primefaces.event.CellEditEvent;

@ManagedBean(name = "presencaController")
@ViewScoped
public class PresencaController extends AbstractController<Presenca> {

    @EJB
    private PresencaFacade ejbFacade;

    private DisciplinaController seqDisciplinaController;
    private AlunoController seqAlunoController;
    private AlunoTurmaController alunoTurmaController;
    private TurmaController seqTurmaController;
    private List<Presenca> listPresenca;
    private List<String> options;

    /**
     * Initialize the concrete Presenca controller bean. The AbstractController
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
        seqDisciplinaController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaController}", DisciplinaController.class);
        seqAlunoController = context.getApplication().evaluateExpressionGet(context, "#{alunoController}", AlunoController.class);
        alunoTurmaController = context.getApplication().evaluateExpressionGet(context, "#{alunoTurmaController}", AlunoTurmaController.class);
        seqTurmaController = context.getApplication().evaluateExpressionGet(context, "#{turmaController}", TurmaController.class);
        initListaPresenca();
    }

    public List<Presenca> getListPresenca() {
        return listPresenca;
    }

    public void setListPresenca(List<Presenca> listPresenca) {
        this.listPresenca = listPresenca;
    }

    public PresencaController() {
        super(Presenca.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqDisciplinaController.setSelected(null);
        seqAlunoController.setSelected(null);
        alunoTurmaController.setSelected(null);
        seqTurmaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Disciplina controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqDisciplina(ActionEvent event) {
        if (this.getSelected() != null && seqDisciplinaController.getSelected() == null) {
            seqDisciplinaController.setSelected(this.getSelected().getSeqDisciplina());
        }
    }

    public void prepareSeqTurma(Turma seqTurmaItem) {
        System.out.println("Chegou aqui....");
        if (this.getSelected() != null && seqTurmaController.getSelected() == null) {
            seqTurmaController.setSelected(seqTurmaItem);
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

    public Presenca prepareCreatePresencaTurma(ActionEvent event) {
        
        return super.prepareCreate(event); //To change body of generated methods, choose Tools | Templates.
    }

    public void saveTurma(ActionEvent event) {
        for (Presenca item : listPresenca) {
            this.ejbFacade.create(item);
        }
        if (!isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
        }
    }

    public List<Presenca> prepareCreatePresenca(ActionEvent event) {
        return listPresenca;
    }

    public void populaListaPresenca() {
        alunoTurmaController.getAlunosTurma(seqTurmaController.getSelected().getSeqTurma());
        initListaPresenca();
        for (AlunoTurma alunoTurma : alunoTurmaController.getItems()) {
            Presenca presenca = new Presenca(null, "S", super.getSelected().getDatDataPresenca());
            presenca.setSeqAluno(alunoTurma.getSeqAluno());
            presenca.setSeqDisciplina(seqDisciplinaController.getSelected());
            listPresenca.add(presenca);
        }
    }

    private void initListaPresenca() {
        listPresenca = new ArrayList<Presenca>();
        options = new ArrayList<String>();
        options.add("S");
        options.add("N");
    }

    public void onCellEdit(CellEditEvent event) {
        Object newValue = event.getNewValue();
        listPresenca.get(event.getRowIndex()).setFlgPresente(newValue.toString());
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
     
}
