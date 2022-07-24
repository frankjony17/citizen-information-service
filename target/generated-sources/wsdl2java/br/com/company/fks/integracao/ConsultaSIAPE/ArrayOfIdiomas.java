/**
 * ArrayOfIdiomas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfIdiomas  implements java.io.Serializable {
    private Idiomas[] idiomas;

    public ArrayOfIdiomas() {
    }

    public ArrayOfIdiomas(
           Idiomas[] idiomas) {
           this.idiomas = idiomas;
    }


    /**
     * Gets the idiomas value for this ArrayOfIdiomas.
     * 
     * @return idiomas
     */
    public Idiomas[] getIdiomas() {
        return idiomas;
    }


    /**
     * Sets the idiomas value for this ArrayOfIdiomas.
     * 
     * @param idiomas
     */
    public void setIdiomas(Idiomas[] idiomas) {
        this.idiomas = idiomas;
    }

    public Idiomas getIdiomas(int i) {
        return this.idiomas[i];
    }

    public void setIdiomas(int i, Idiomas _value) {
        this.idiomas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfIdiomas)) return false;
        ArrayOfIdiomas other = (ArrayOfIdiomas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idiomas==null && other.getIdiomas()==null) || 
             (this.idiomas!=null &&
              java.util.Arrays.equals(this.idiomas, other.getIdiomas())));
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
        if (getIdiomas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdiomas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdiomas(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfIdiomas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfIdiomas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Idiomas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Idiomas"));
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
