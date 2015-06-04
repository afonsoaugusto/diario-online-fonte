package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.PlanoEnsino;
import br.com.diario.escolar.view.session.PlanoEnsinoFacade;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

@ManagedBean(name = "planoEnsinoController")
@ViewScoped
public class PlanoEnsinoController extends AbstractController<PlanoEnsino> {

    @EJB
    private PlanoEnsinoFacade ejbFacade;
    private TurmaController seqTurmaController;
    private DisciplinaProfessorController seqDisciplinaProfessorController;
    private javax.servlet.http.Part file;

    /**
     * Initialize the concrete PlanoEnsino controller bean. The
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
        seqTurmaController = context.getApplication().evaluateExpressionGet(context, "#{turmaController}", TurmaController.class);
        seqDisciplinaProfessorController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaProfessorController}", DisciplinaProfessorController.class);
    }

    @Override
    public void saveNew(ActionEvent event) {
        //upload();
        super.saveNew(event);
    }

    private void upload() {
        try {
            InputStream is = file.getInputStream();
            byte[] bytes = IOUtils.toByteArray(is);
            super.getSelected().setDesAnexo(bytes);
        } catch (IOException e) {
// tratar exceção
        }
    }

    @Override
    public void save(ActionEvent event) {
        //upload();
        super.save(event);
    }

    public PlanoEnsinoController() {
        // Inform the Abstract parent controller of the concrete PlanoEnsino?cap_first Entity
        super(PlanoEnsino.class
        );
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqTurmaController.setSelected(null);
        seqDisciplinaProfessorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Turma controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqTurma(ActionEvent event) {
        if (this.getSelected() != null && seqTurmaController.getSelected() == null) {
            seqTurmaController.setSelected(this.getSelected().getSeqTurma());
        }
    }

    /**
     * Sets the "selected" attribute of the DisciplinaProfessor controller in
     * order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqDisciplinaProfessor(ActionEvent event) {
        if (this.getSelected() != null && seqDisciplinaProfessorController.getSelected() == null) {
            seqDisciplinaProfessorController.setSelected(this.getSelected().getSeqDisciplinaProfessor());
        }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
