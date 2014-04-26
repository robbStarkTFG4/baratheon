package com.server.entity.beans;

import com.server.entity.beans.Map;
import com.server.entity.beans.TblMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-04-24T12:24:35")
@StaticMetamodel(Subfamilias.class)
public class Subfamilias_ { 

    public static volatile SingularAttribute<Subfamilias, String> nombre;
    public static volatile ListAttribute<Subfamilias, Map> mapList;
    public static volatile SingularAttribute<Subfamilias, Integer> idsubFam;
    public static volatile SingularAttribute<Subfamilias, String> descripcion;
    public static volatile ListAttribute<Subfamilias, TblMaterial> tblMaterialList;

}