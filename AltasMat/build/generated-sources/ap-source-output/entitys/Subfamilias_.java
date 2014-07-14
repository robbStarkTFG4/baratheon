package entitys;

import entitys.Map;
import entitys.TblMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-12T23:46:43")
@StaticMetamodel(Subfamilias.class)
public class Subfamilias_ { 

    public static volatile SingularAttribute<Subfamilias, String> nombre;
    public static volatile ListAttribute<Subfamilias, Map> mapList;
    public static volatile SingularAttribute<Subfamilias, Integer> idsubFam;
    public static volatile SingularAttribute<Subfamilias, String> descripcion;
    public static volatile ListAttribute<Subfamilias, TblMaterial> tblMaterialList;

}