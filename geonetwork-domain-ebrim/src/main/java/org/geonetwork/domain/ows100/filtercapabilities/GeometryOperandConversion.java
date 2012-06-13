package org.geonetwork.domain.ows100.filtercapabilities;

/**
 * For Jibx
 */

public class GeometryOperandConversion {
    public static GeometryOperand deserializeGeometryOperand (String str) {
        if (str == null) {
            return null;
        } else {
            return GeometryOperand.valueOf(str.replace(':','_'));
        }
    }

     public static String serializeGeometryOperand (GeometryOperand op) {
        if (op == null) {
            return null;
        } else {
            return op.toString().replace('_',':');
        }
    }
}