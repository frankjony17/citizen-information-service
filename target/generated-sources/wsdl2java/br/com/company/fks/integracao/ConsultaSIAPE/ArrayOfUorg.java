/**
 * ArrayOfUorg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfUorg  implements java.io.Serializable {
    private Uorg[] uorg;

    public ArrayOfUorg() {
    }

    public ArrayOfUorg(
           Uorg[] uorg) {
           this.uorg = uorg;
    }


    /**
     * Gets the uorg value for this ArrayOfUorg.
     * 
     * @return uorg
     */
    public Uorg[] getUorg() {
        return uorg;
    }


    /**
     * Sets the uorg value for this ArrayOfUorg.
     * 
     * @param uorg
     */
    public void setUorg(Uorg[] uorg) {
        this.uorg = uorg;
    }

    public Uorg getUorg(int i) {
        return this.uorg[i];
    }

    public void setUorg(int i, Uorg _value) {
        this.uorg[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfUorg)) return false;
        ArrayOfUorg other = (ArrayOfUorg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.uorg==null && other.getUorg()==null) || 
             (this.uorg!=null &&
              java.util.Arrays.equals(this.uorg, other.getUorg())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getUorg() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUorg());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUorg(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayOfUorg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfUorg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uorg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Uorg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Uorg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
