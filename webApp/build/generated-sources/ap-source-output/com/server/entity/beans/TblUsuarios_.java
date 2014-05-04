package com.server.entity.beans;

import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblTipousuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-01T19:50:03")
@StaticMetamodel(TblUsuarios.class)
public class TblUsuarios_ { 

    public static volatile SingularAttribute<TblUsuarios, String> nombre;
    public static volatile SingularAttribute<TblUsuarios, String> apellidop;
    public static volatile SingularAttribute<TblUsuarios, String> email;
    public static volatile SingularAttribute<TblUsuarios, String> usuario;
    public static volatile SingularAttribute<TblUsuarios, String> tel;
    public static volatile SingularAttribute<TblUsuarios, TblTipousuarios> idTipousuarios;
    public static volatile SingularAttribute<TblUsuarios, String> contraseña;
    public static volatile SingularAttribute<TblUsuarios, Integer> idUsuarios;
    public static volatile SingularAttribute<TblUsuarios, String> apellidom;
    public static volatile ListAttribute<TblUsuarios, TblPrestamo> tblPrestamoList;

}