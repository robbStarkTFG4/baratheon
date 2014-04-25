package com.server.entity.beans;

import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblTipoprestarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-04-24T12:24:35")
@StaticMetamodel(TblPrestarios.class)
public class TblPrestarios_ { 

    public static volatile SingularAttribute<TblPrestarios, Integer> idPrestario;
    public static volatile SingularAttribute<TblPrestarios, String> nombre;
    public static volatile SingularAttribute<TblPrestarios, String> carrera;
    public static volatile SingularAttribute<TblPrestarios, String> amaterno;
    public static volatile SingularAttribute<TblPrestarios, TblTipoprestarios> idTipoprestarios;
    public static volatile SingularAttribute<TblPrestarios, String> email;
    public static volatile SingularAttribute<TblPrestarios, String> usuario;
    public static volatile SingularAttribute<TblPrestarios, String> apaterno;
    public static volatile SingularAttribute<TblPrestarios, String> tel;
    public static volatile ListAttribute<TblPrestarios, TblPrestamo> tblPrestamoList;

}