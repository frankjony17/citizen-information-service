/**
 * ArrayOfDadosVinculo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosVinculo  implements java.io.Serializable {
    private DadosVinculo[] dadosVinculo;

    public ArrayOfDadosVinculo() {
    }

    public ArrayOfDadosVinculo(
           DadosVinculo[] dadosVinculo) {
           this.dadosVinculo = dadosVinculo;
    }


    /**
     * Gets the dadosVinculo value for this ArrayOfDadosVinculo.
     * 
     * @return dadosVinculo
     */
    public DadosVinculo[] getDadosVinculo() {
        return dadosVinculo;
    }


    /**
     * Sets the dadosVinculo value for this ArrayOfDadosVinculo.
     * 
     * @param dadosVinculo
     */
    public void setDadosVinculo(DadosVinculo[] dadosVinculo) {
        this.dadosVinculo = dadosVinculo;
    }

    public DadosVinculo getDadosVinculo(int i) {
        return this.dadosVinculo[i];
    }

    public void setDadosVinculo(int i, DadosVinculo _value) {
        this.dadosVinculo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosVinculo)) return false;
        ArrayOfDadosVinculo other = (ArrayOfDadosVinculo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosVinculo==null && other.getDadosVinculo()==null) || 
             (this.dadosVinculo!=null &&
              java.util.Arrays.equals(this.dadosVinculo, other.getDadosVinculo())));
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
        if (getDadosVinculo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosVinculo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosVinculo(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosVinculo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosVinculo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosVinculo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosVinculo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosVinculo"));
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
