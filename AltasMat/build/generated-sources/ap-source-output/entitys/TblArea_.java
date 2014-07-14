package entitys;

import entitys.TblMaterial;
import entitys.TblTipomaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-12T23:46:43")
@StaticMetamodel(TblArea.class)
public class TblArea_ { 

    public static volatile SingularAttribute<TblArea, Integer> idArea;
    public static volatile SingularAttribute<TblArea, String> descripcion;
    public static volatile ListAttribute<TblArea, TblTipomaterial> tblTipomaterialList;
    public static volatile ListAttribute<TblArea, TblMaterial> tblMaterialList;

}