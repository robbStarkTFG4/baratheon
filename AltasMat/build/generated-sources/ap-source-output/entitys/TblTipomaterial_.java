package entitys;

import entitys.Map;
import entitys.TblArea;
import entitys.TblMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-12T23:46:43")
@StaticMetamodel(TblTipomaterial.class)
public class TblTipomaterial_ { 

    public static volatile ListAttribute<TblTipomaterial, Map> mapList;
    public static volatile SingularAttribute<TblTipomaterial, TblArea> tblAreaIdArea;
    public static volatile SingularAttribute<TblTipomaterial, String> descripcion;
    public static volatile ListAttribute<TblTipomaterial, TblMaterial> tblMaterialList;
    public static volatile SingularAttribute<TblTipomaterial, Integer> idTipomaterial;

}