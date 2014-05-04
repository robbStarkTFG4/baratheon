package com.server.entity.beans;

import com.server.entity.beans.TblPrestarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-01T19:50:03")
@StaticMetamodel(TblTipoprestarios.class)
public class TblTipoprestarios_ { 

    public static volatile SingularAttribute<TblTipoprestarios, Integer> idTipoprestarios;
    public static volatile SingularAttribute<TblTipoprestarios, String> descripcion;
    public static volatile ListAttribute<TblTipoprestarios, TblPrestarios> tblPrestariosList;

}