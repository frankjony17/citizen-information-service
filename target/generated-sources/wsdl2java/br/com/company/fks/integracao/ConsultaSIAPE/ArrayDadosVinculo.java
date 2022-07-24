/**
 * ArrayDadosVinculo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayDadosVinculo  implements java.io.Serializable {
    private ArrayOfDadosVinculo dadosVinculos;

    public ArrayDadosVinculo() {
    }

    public ArrayDadosVinculo(
           ArrayOfDadosVinculo dadosVinculos) {
           this.dadosVinculos = dadosVinculos;
    }


    /**
     * Gets the dadosVinculos value for this ArrayDadosVinculo.
     * 
     * @return dadosVinculos
     */
    public ArrayOfDadosVinculo getDadosVinculos() {
        return dadosVinculos;
    }


    /**
     * Sets the dadosVinculos value for this ArrayDadosVinculo.
     * 
     * @param dadosVinculos
     */
    public void setDadosVinculos(ArrayOfDadosVinculo dadosVinculos) {
        this.dadosVinculos = dadosVinculos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayDadosVinculo)) return false;
        ArrayDadosVinculo other = (ArrayDadosVinculo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosVinculos==null && other.getDadosVinculos()==null) || 
             (this.dadosVinculos!=null &&
              this.dadosVinculos.equals(other.getDadosVinculos())));
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
        if (getDadosVinculos() != null) {
            _hashCode += getDadosVinculos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayDadosVinculo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayDadosVinculo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosVinculos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dadosVinculos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosVinculo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
