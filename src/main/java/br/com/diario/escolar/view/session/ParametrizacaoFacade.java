/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.view.session;

import br.com.diario.escolar.model.entity.Parametrizacao;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Root;

/**
 *
 * @author AFONSO
 */
@Stateless
public class ParametrizacaoFacade extends AbstractFacade<Parametrizacao> {

    @PersistenceContext(unitName = "app_do_1.0PU")
    private EntityManager em;

    private static final String COD_PARAMETRO = "codParametro";
    private static final String SEQ_PARAMETRIZACAO_PAI = "seqParametrizacaoPai";

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParametrizacaoFacade() {
        super(Parametrizacao.class);
    }

    public List<Parametrizacao> findFilhosNivelEscolar() {
        return findFilhosPorParametro("ANO_VIGENTE", Parametrizacao.class);
    }

    public List<Parametrizacao> findStatusAlunoTurma() {
        return findFilhosPorParametro("STATUS_ALUNO_TURMA", Parametrizacao.class);
    }

    public List<Parametrizacao> findTipoAtividade() {
        return findFilhosPorParametro("TIPO_ATIVIDADE", Parametrizacao.class);
    }
    
    public Collection<Parametrizacao> findTipoNota() {
        return findFilhosPorParametro("TIPO_NOTA", Parametrizacao.class);
    }

    private List<Parametrizacao> findFilhosPorParametro(String parametro, Class c) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        //cq.select(cq.from(Parametrizacao.class));
        Root<Parametrizacao> root = cq.from(c);
        cq.where(root.get(SEQ_PARAMETRIZACAO_PAI).isNotNull(), root.get(COD_PARAMETRO).in(parametro));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
