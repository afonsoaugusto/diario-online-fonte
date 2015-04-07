/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.view.session;

import br.com.diario.escolar.model.entity.Acao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AFONSO
 */
@Stateless
public class AcaoFacade extends AbstractFacade<Acao> {
    @PersistenceContext(unitName = "app_do_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcaoFacade() {
        super(Acao.class);
    }
    
}
