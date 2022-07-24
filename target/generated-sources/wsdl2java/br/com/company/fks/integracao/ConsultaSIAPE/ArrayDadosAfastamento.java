/**
 * ArrayDadosAfastamento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayDadosAfastamento  implements java.io.Serializable {
    private ArrayOfDadosAfastamentoPorCpf dadosAfastamentoPorCPF;

    private ArrayOfDadosAfastamentoPorMatricula dadosAfastamentoPorMatricula;

    public ArrayDadosAfastamento() {
    }

    public ArrayDadosAfastamento(
           ArrayOfDadosAfastamentoPorCpf dadosAfastamentoPorCPF,
           ArrayOfDadosAfastamentoPorMatricula dadosAfastamentoPorMatricula) {
           this.dadosAfastamentoPorCPF = dadosAfastamentoPorCPF;
           this.dadosAfastamentoPorMatricula = dadosAfastamentoPorMatricula;
    }


    /**
     * Gets the dadosAfastamentoPorCPF value for this ArrayDadosAfastamento.
     * 
     * @return dadosAfastamentoPorCPF
     */
    public ArrayOfDadosAfastamentoPorCpf getDadosAfastamentoPorCPF() {
        return dadosAfastamentoPorCPF;
    }


    /**
     * Sets the dadosAfastamentoPorCPF value for this ArrayDadosAfastamento.
     * 
     * @param dadosAfastamentoPorCPF
     */
    public void setDadosAfastamentoPorCPF(ArrayOfDadosAfastamentoPorCpf dadosAfastamentoPorCPF) {
        this.dadosAfastamentoPorCPF = dadosAfastamentoPorCPF;
    }


    /**
     * Gets the dadosAfastamentoPorMatricula value for this ArrayDadosAfastamento.
     * 
     * @return dadosAfastamentoPorMatricula
     */
    public ArrayOfDadosAfastamentoPorMatricula getDadosAfastamentoPorMatricula() {
        return dadosAfastamentoPorMatricula;
    }


    /**
     * Sets the dadosAfastamentoPorMatricula value for this ArrayDadosAfastamento.
     * 
     * @param dadosAfastamentoPorMatricula
     */
    public void setDadosAfastamentoPorMatricula(ArrayOfDadosAfastamentoPorMatricula dadosAfastamentoPorMatricula) {
        this.dadosAfastamentoPorMatricula = dadosAfastamentoPorMatricula;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayDadosAfastamento)) return false;
        ArrayDadosAfastamento other = (ArrayDadosAfastamento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosAfastamentoPorCPF==null && other.getDadosAfastamentoPorCPF()==null) || 
             (this.dadosAfastamentoPorCPF!=null &&
              this.dadosAfastamentoPorCPF.equals(other.getDadosAfastamentoPorCPF()))) &&
            ((this.dadosAfastamentoPorMatricula==null && other.getDadosAfastamentoPorMatricula()==null) || 
             (this.dadosAfastamentoPorMatricula!=null &&
              this.dadosAfastamentoPorMatricula.equals(other.getDadosAfastamentoPorMatricula())));
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
        if (getDadosAfastamentoPorCPF() != null) {
            _hashCode += getDadosAfastamentoPorCPF().hashCode();
        }
        if (getDadosAfastamentoPorMatricula() != null) {
            _hashCode += getDadosAfastamentoPorMatricula().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayDadosAfastamento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayDadosAfastamento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosAfastamentoPorCPF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dadosAfastamentoPorCPF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosAfastamentoPorCpf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosAfastamentoPorMatricula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dadosAfastamentoPorMatricula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosAfastamentoPorMatricula"));
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
