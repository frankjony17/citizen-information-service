/**
 * ArrayOfDadosLpa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosLpa  implements java.io.Serializable {
    private DadosLpa[] dadosLpa;

    public ArrayOfDadosLpa() {
    }

    public ArrayOfDadosLpa(
           DadosLpa[] dadosLpa) {
           this.dadosLpa = dadosLpa;
    }


    /**
     * Gets the dadosLpa value for this ArrayOfDadosLpa.
     * 
     * @return dadosLpa
     */
    public DadosLpa[] getDadosLpa() {
        return dadosLpa;
    }


    /**
     * Sets the dadosLpa value for this ArrayOfDadosLpa.
     * 
     * @param dadosLpa
     */
    public void setDadosLpa(DadosLpa[] dadosLpa) {
        this.dadosLpa = dadosLpa;
    }

    public DadosLpa getDadosLpa(int i) {
        return this.dadosLpa[i];
    }

    public void setDadosLpa(int i, DadosLpa _value) {
        this.dadosLpa[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosLpa)) return false;
        ArrayOfDadosLpa other = (ArrayOfDadosLpa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosLpa==null && other.getDadosLpa()==null) || 
             (this.dadosLpa!=null &&
              java.util.Arrays.equals(this.dadosLpa, other.getDadosLpa())));
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
        if (getDadosLpa() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosLpa());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosLpa(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosLpa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosLpa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosLpa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosLpa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosLpa"));
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
