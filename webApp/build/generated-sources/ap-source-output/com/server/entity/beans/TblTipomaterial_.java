package com.server.entity.beans;

import com.server.entity.beans.Map;
import com.server.entity.beans.TblArea;
import com.server.entity.beans.TblMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-01T19:50:03")
@StaticMetamodel(TblTipomaterial.class)
public class TblTipomaterial_ { 

    public static volatile ListAttribute<TblTipomaterial, Map> mapList;
    public static volatile SingularAttribute<TblTipomaterial, TblArea> tblAreaIdArea;
    public static volatile SingularAttribute<TblTipomaterial, String> descripcion;
    public static volatile ListAttribute<TblTipomaterial, TblMaterial> tblMaterialList;
    public static volatile SingularAttribute<TblTipomaterial, Integer> idTipomaterial;

}