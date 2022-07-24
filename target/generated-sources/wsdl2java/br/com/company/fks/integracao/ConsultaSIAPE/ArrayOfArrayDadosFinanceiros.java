/**
 * ArrayOfArrayDadosFinanceiros.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfArrayDadosFinanceiros  implements java.io.Serializable {
    private ArrayDadosFinanceiros[] arrayDadosFinanceiros;

    public ArrayOfArrayDadosFinanceiros() {
    }

    public ArrayOfArrayDadosFinanceiros(
           ArrayDadosFinanceiros[] arrayDadosFinanceiros) {
           this.arrayDadosFinanceiros = arrayDadosFinanceiros;
    }


    /**
     * Gets the arrayDadosFinanceiros value for this ArrayOfArrayDadosFinanceiros.
     * 
     * @return arrayDadosFinanceiros
     */
    public ArrayDadosFinanceiros[] getArrayDadosFinanceiros() {
        return arrayDadosFinanceiros;
    }


    /**
     * Sets the arrayDadosFinanceiros value for this ArrayOfArrayDadosFinanceiros.
     * 
     * @param arrayDadosFinanceiros
     */
    public void setArrayDadosFinanceiros(ArrayDadosFinanceiros[] arrayDadosFinanceiros) {
        this.arrayDadosFinanceiros = arrayDadosFinanceiros;
    }

    public ArrayDadosFinanceiros getArrayDadosFinanceiros(int i) {
        return this.arrayDadosFinanceiros[i];
    }

    public void setArrayDadosFinanceiros(int i, ArrayDadosFinanceiros _value) {
        this.arrayDadosFinanceiros[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfArrayDadosFinanceiros)) return false;
        ArrayOfArrayDadosFinanceiros other = (ArrayOfArrayDadosFinanceiros) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayDadosFinanceiros==null && other.getArrayDadosFinanceiros()==null) || 
             (this.arrayDadosFinanceiros!=null &&
              java.util.Arrays.equals(this.arrayDadosFinanceiros, other.getArrayDadosFinanceiros())));
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
        if (getArrayDadosFinanceiros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayDadosFinanceiros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayDadosFinanceiros(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfArrayDadosFinanceiros.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfArrayDadosFinanceiros"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayDadosFinanceiros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayDadosFinanceiros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayDadosFinanceiros"));
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
