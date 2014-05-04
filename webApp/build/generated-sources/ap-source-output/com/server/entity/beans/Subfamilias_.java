package com.server.entity.beans;

import com.server.entity.beans.Map;
import com.server.entity.beans.TblMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-01T19:50:03")
@StaticMetamodel(Subfamilias.class)
public class Subfamilias_ { 

    public static volatile SingularAttribute<Subfamilias, String> nombre;
    public static volatile ListAttribute<Subfamilias, Map> mapList;
    public static volatile SingularAttribute<Subfamilias, Integer> idsubFam;
    public static volatile SingularAttribute<Subfamilias, String> descripcion;
    public static volatile ListAttribute<Subfamilias, TblMaterial> tblMaterialList;

}