package com.server.entity.beans;

import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestamo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-01T19:50:03")
@StaticMetamodel(TblDetalleprestamo.class)
public class TblDetalleprestamo_ { 

    public static volatile SingularAttribute<TblDetalleprestamo, String> horaretorno;
    public static volatile SingularAttribute<TblDetalleprestamo, String> fecharetorno;
    public static volatile SingularAttribute<TblDetalleprestamo, TblPrestamo> idPrestamo;
    public static volatile SingularAttribute<TblDetalleprestamo, Integer> cantidad;
    public static volatile SingularAttribute<TblDetalleprestamo, Integer> idDetalleprestamo;
    public static volatile SingularAttribute<TblDetalleprestamo, TblMaterial> idMaterial;

}