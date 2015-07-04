/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.controller.session;

import br.com.diario.escolar.model.entity.Funcionalidade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AFONSO
 */
@Stateless
public class FuncionalidadeFacade extends AbstractFacade<Funcionalidade> {
    @PersistenceContext(unitName = "app_do_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionalidadeFacade() {
        super(Funcionalidade.class);
    }
    
}
