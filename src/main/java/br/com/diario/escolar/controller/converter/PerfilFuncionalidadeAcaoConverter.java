package br.com.diario.escolar.controller.converter;

import br.com.diario.escolar.model.entity.PerfilFuncionalidadeAcao;
import br.com.diario.escolar.controller.session.PerfilFuncionalidadeAcaoFacade;
import br.com.diario.escolar.controller.backing.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "perfilFuncionalidadeAcaoConverter")
public class PerfilFuncionalidadeAcaoConverter implements Converter {

    @EJB
    private PerfilFuncionalidadeAcaoFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    java.math.BigDecimal getKey(String value) {
        java.math.BigDecimal key;
        key = new java.math.BigDecimal(value);
        return key;
    }

    String getStringKey(java.math.BigDecimal value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof PerfilFuncionalidadeAcao) {
            PerfilFuncionalidadeAcao o = (PerfilFuncionalidadeAcao) object;
            return getStringKey(o.getSeqPerfilFuncionalidadeAcao());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PerfilFuncionalidadeAcao.class.getName()});
            return null;
        }
    }

}
