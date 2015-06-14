/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.view.session;

import br.com.diario.escolar.model.entity.Aluno;
import br.com.diario.escolar.model.entity.AlunoTurma;
import br.com.diario.escolar.model.entity.Parametrizacao;
import java.math.BigDecimal;
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
public class AlunoTurmaFacade extends AbstractFacade<AlunoTurma> {
    @PersistenceContext(unitName = "app_do_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlunoTurmaFacade() {
        super(AlunoTurma.class);
    }
    
    public List<AlunoTurma> findByTurma(BigDecimal seqTurma){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        //cq.select(cq.from(Parametrizacao.class));
        Root<AlunoTurma> root = cq.from(AlunoTurma.class);
        cq.where(root.get("seqTurma").in(seqTurma),root.get("flgTurmaAtual").in("S"));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    
}
