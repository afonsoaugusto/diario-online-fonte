/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.view.session;

import br.com.diario.escolar.model.entity.Parametrizacao;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParametrizacaoFacade() {
        super(Parametrizacao.class);
    }

    public List<Parametrizacao> findFilhosNivelEscolar() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        //cq.select(cq.from(Parametrizacao.class));
        Root<Parametrizacao> root = cq.from(Parametrizacao.class);
        cq.where(root.get("seqParametrizacaoPai").isNotNull(),root.get("codParametro").in("ANO_VIGENTE"));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public List<Parametrizacao> findStatusAlunoTurma() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        //cq.select(cq.from(Parametrizacao.class));
        Root<Parametrizacao> root = cq.from(Parametrizacao.class);
        cq.where(root.get("seqParametrizacaoPai").isNotNull(),root.get("codParametro").in("STATUS_ALUNO_TURMA"));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
