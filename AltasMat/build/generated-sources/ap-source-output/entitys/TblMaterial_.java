package entitys;

import entitys.Almacen;
import entitys.Subfamilias;
import entitys.TblArea;
import entitys.TblTipomaterial;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-12T23:46:43")
@StaticMetamodel(TblMaterial.class)
public class TblMaterial_ { 

    public static volatile SingularAttribute<TblMaterial, String> responsable;
    public static volatile SingularAttribute<TblMaterial, String> numeroFactura;
    public static volatile SingularAttribute<TblMaterial, Long> costo;
    public static volatile SingularAttribute<TblMaterial, Almacen> almacenIdalmacen;
    public static volatile SingularAttribute<TblMaterial, String> nombre;
    public static volatile SingularAttribute<TblMaterial, Integer> stock;
    public static volatile SingularAttribute<TblMaterial, String> noParte;
    public static volatile SingularAttribute<TblMaterial, String> proveedor;
    public static volatile SingularAttribute<TblMaterial, TblTipomaterial> idTipomaterial;
    public static volatile SingularAttribute<TblMaterial, Subfamilias> subFamiliasidsubFam;
    public static volatile SingularAttribute<TblMaterial, String> codigoSip;
    public static volatile SingularAttribute<TblMaterial, String> ubicacionActual;
    public static volatile SingularAttribute<TblMaterial, String> descripcion;
    public static volatile SingularAttribute<TblMaterial, String> ordenCompra;
    public static volatile SingularAttribute<TblMaterial, String> marca;
    public static volatile SingularAttribute<TblMaterial, String> financiamiento;
    public static volatile SingularAttribute<TblMaterial, String> serie;
    public static volatile SingularAttribute<TblMaterial, Date> fechaRecepcion;
    public static volatile SingularAttribute<TblMaterial, String> imagen;
    public static volatile SingularAttribute<TblMaterial, String> estado;
    public static volatile SingularAttribute<TblMaterial, TblArea> idArea;
    public static volatile SingularAttribute<TblMaterial, String> tipoCompra;
    public static volatile SingularAttribute<TblMaterial, String> idUabc;
    public static volatile SingularAttribute<TblMaterial, Integer> idtblMaterial;
    public static volatile SingularAttribute<TblMaterial, String> unidadMedida;

}