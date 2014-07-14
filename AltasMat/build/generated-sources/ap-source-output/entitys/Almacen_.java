package entitys;

import entitys.TblMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-12T23:46:43")
@StaticMetamodel(Almacen.class)
public class Almacen_ { 

    public static volatile SingularAttribute<Almacen, Integer> idalmacen;
    public static volatile SingularAttribute<Almacen, String> descripcion;
    public static volatile ListAttribute<Almacen, TblMaterial> tblMaterialList;

}