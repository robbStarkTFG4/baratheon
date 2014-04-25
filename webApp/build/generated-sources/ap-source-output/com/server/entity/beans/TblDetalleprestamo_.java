package com.server.entity.beans;

import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestamo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-04-24T12:24:35")
@StaticMetamodel(TblDetalleprestamo.class)
public class TblDetalleprestamo_ { 

    public static volatile SingularAttribute<TblDetalleprestamo, String> horaretorno;
    public static volatile SingularAttribute<TblDetalleprestamo, String> fecharetorno;
    public static volatile SingularAttribute<TblDetalleprestamo, TblPrestamo> idPrestamo;
    public static volatile SingularAttribute<TblDetalleprestamo, Integer> cantidad;
    public static volatile SingularAttribute<TblDetalleprestamo, Integer> idDetalleprestamo;
    public static volatile SingularAttribute<TblDetalleprestamo, TblMaterial> idMaterial;

}