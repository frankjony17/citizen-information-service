/**
 * ArrayOfArrayDadosAfastamento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfArrayDadosAfastamento  implements java.io.Serializable {
    private ArrayDadosAfastamento[] arrayDadosAfastamento;

    public ArrayOfArrayDadosAfastamento() {
    }

    public ArrayOfArrayDadosAfastamento(
           ArrayDadosAfastamento[] arrayDadosAfastamento) {
           this.arrayDadosAfastamento = arrayDadosAfastamento;
    }


    /**
     * Gets the arrayDadosAfastamento value for this ArrayOfArrayDadosAfastamento.
     * 
     * @return arrayDadosAfastamento
     */
    public ArrayDadosAfastamento[] getArrayDadosAfastamento() {
        return arrayDadosAfastamento;
    }


    /**
     * Sets the arrayDadosAfastamento value for this ArrayOfArrayDadosAfastamento.
     * 
     * @param arrayDadosAfastamento
     */
    public void setArrayDadosAfastamento(ArrayDadosAfastamento[] arrayDadosAfastamento) {
        this.arrayDadosAfastamento = arrayDadosAfastamento;
    }

    public ArrayDadosAfastamento getArrayDadosAfastamento(int i) {
        return this.arrayDadosAfastamento[i];
    }

    public void setArrayDadosAfastamento(int i, ArrayDadosAfastamento _value) {
        this.arrayDadosAfastamento[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfArrayDadosAfastamento)) return false;
        ArrayOfArrayDadosAfastamento other = (ArrayOfArrayDadosAfastamento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayDadosAfastamento==null && other.getArrayDadosAfastamento()==null) || 
             (this.arrayDadosAfastamento!=null &&
              java.util.Arrays.equals(this.arrayDadosAfastamento, other.getArrayDadosAfastamento())));
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
        if (getArrayDadosAfastamento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayDadosAfastamento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayDadosAfastamento(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfArrayDadosAfastamento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfArrayDadosAfastamento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayDadosAfastamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayDadosAfastamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayDadosAfastamento"));
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
