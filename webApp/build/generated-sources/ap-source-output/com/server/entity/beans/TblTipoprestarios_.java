package com.server.entity.beans;

import com.server.entity.beans.TblPrestarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-04-24T12:24:35")
@StaticMetamodel(TblTipoprestarios.class)
public class TblTipoprestarios_ { 

    public static volatile SingularAttribute<TblTipoprestarios, Integer> idTipoprestarios;
    public static volatile SingularAttribute<TblTipoprestarios, String> descripcion;
    public static volatile ListAttribute<TblTipoprestarios, TblPrestarios> tblPrestariosList;

}