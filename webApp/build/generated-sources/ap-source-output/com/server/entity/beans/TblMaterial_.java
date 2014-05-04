package com.server.entity.beans;

import com.server.entity.beans.Subfamilias;
import com.server.entity.beans.TblArea;
import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblTipomaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-01T19:50:03")
@StaticMetamodel(TblMaterial.class)
public class TblMaterial_ { 

    public static volatile SingularAttribute<TblMaterial, String> nombre;
    public static volatile SingularAttribute<TblMaterial, String> imagen;
    public static volatile SingularAttribute<TblMaterial, Integer> stock;
    public static volatile ListAttribute<TblMaterial, TblDetalleprestamo> tblDetalleprestamoList;
    public static volatile SingularAttribute<TblMaterial, String> noParte;
    public static volatile SingularAttribute<TblMaterial, TblArea> idArea;
    public static volatile SingularAttribute<TblMaterial, String> descripcion;
    public static volatile SingularAttribute<TblMaterial, Long> costo;
    public static volatile SingularAttribute<TblMaterial, Integer> idtblMaterial;
    public static volatile SingularAttribute<TblMaterial, TblTipomaterial> idTipomaterial;
    public static volatile SingularAttribute<TblMaterial, Subfamilias> subFamiliasidsubFam;

}