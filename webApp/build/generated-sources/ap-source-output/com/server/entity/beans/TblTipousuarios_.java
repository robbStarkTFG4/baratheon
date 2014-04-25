package com.server.entity.beans;

import com.server.entity.beans.TblUsuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-04-24T12:24:35")
@StaticMetamodel(TblTipousuarios.class)
public class TblTipousuarios_ { 

    public static volatile SingularAttribute<TblTipousuarios, String> idTipousuarios;
    public static volatile SingularAttribute<TblTipousuarios, String> descripcion;
    public static volatile ListAttribute<TblTipousuarios, TblUsuarios> tblUsuariosList;

}