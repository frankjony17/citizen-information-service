/**
 * ArrayOfBeneficio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfBeneficio  implements java.io.Serializable {
    private Beneficio[] beneficio;

    public ArrayOfBeneficio() {
    }

    public ArrayOfBeneficio(
           Beneficio[] beneficio) {
           this.beneficio = beneficio;
    }


    /**
     * Gets the beneficio value for this ArrayOfBeneficio.
     * 
     * @return beneficio
     */
    public Beneficio[] getBeneficio() {
        return beneficio;
    }


    /**
     * Sets the beneficio value for this ArrayOfBeneficio.
     * 
     * @param beneficio
     */
    public void setBeneficio(Beneficio[] beneficio) {
        this.beneficio = beneficio;
    }

    public Beneficio getBeneficio(int i) {
        return this.beneficio[i];
    }

    public void setBeneficio(int i, Beneficio _value) {
        this.beneficio[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfBeneficio)) return false;
        ArrayOfBeneficio other = (ArrayOfBeneficio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.beneficio==null && other.getBeneficio()==null) || 
             (this.beneficio!=null &&
              java.util.Arrays.equals(this.beneficio, other.getBeneficio())));
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
        if (getBeneficio() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBeneficio());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBeneficio(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfBeneficio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfBeneficio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beneficio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "Beneficio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "Beneficio"));
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