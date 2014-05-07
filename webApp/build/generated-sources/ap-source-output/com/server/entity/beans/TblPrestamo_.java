package com.server.entity.beans;

import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblUsuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-06T23:43:47")
@StaticMetamodel(TblPrestamo.class)
public class TblPrestamo_ { 

    public static volatile SingularAttribute<TblPrestamo, TblPrestarios> idPrestario;
    public static volatile SingularAttribute<TblPrestamo, String> fechaprestamo;
    public static volatile SingularAttribute<TblPrestamo, String> fecharetorno;
    public static volatile SingularAttribute<TblPrestamo, Integer> idPrestamo;
    public static volatile ListAttribute<TblPrestamo, TblDetalleprestamo> tblDetalleprestamoList;
    public static volatile SingularAttribute<TblPrestamo, TblUsuarios> idUsuarios;
    public static volatile SingularAttribute<TblPrestamo, Integer> statusprestamo;
    public static volatile SingularAttribute<TblPrestamo, String> horaprestamo;

}