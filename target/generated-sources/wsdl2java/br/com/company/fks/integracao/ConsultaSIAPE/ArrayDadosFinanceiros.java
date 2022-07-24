/**
 * ArrayDadosFinanceiros.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayDadosFinanceiros  implements java.io.Serializable {
    private java.lang.Integer codigoOrgao;

    private ArrayOfDadosFinanceiros dadosFinanceiros;

    private java.lang.Integer matricula;

    private java.lang.String mesAnoPagamento;

    public ArrayDadosFinanceiros() {
    }

    public ArrayDadosFinanceiros(
           java.lang.Integer codigoOrgao,
           ArrayOfDadosFinanceiros dadosFinanceiros,
           java.lang.Integer matricula,
           java.lang.String mesAnoPagamento) {
           this.codigoOrgao = codigoOrgao;
           this.dadosFinanceiros = dadosFinanceiros;
           this.matricula = matricula;
           this.mesAnoPagamento = mesAnoPagamento;
    }


    /**
     * Gets the codigoOrgao value for this ArrayDadosFinanceiros.
     * 
     * @return codigoOrgao
     */
    public java.lang.Integer getCodigoOrgao() {
        return codigoOrgao;
    }


    /**
     * Sets the codigoOrgao value for this ArrayDadosFinanceiros.
     * 
     * @param codigoOrgao
     */
    public void setCodigoOrgao(java.lang.Integer codigoOrgao) {
        this.codigoOrgao = codigoOrgao;
    }


    /**
     * Gets the dadosFinanceiros value for this ArrayDadosFinanceiros.
     * 
     * @return dadosFinanceiros
     */
    public ArrayOfDadosFinanceiros getDadosFinanceiros() {
        return dadosFinanceiros;
    }


    /**
     * Sets the dadosFinanceiros value for this ArrayDadosFinanceiros.
     * 
     * @param dadosFinanceiros
     */
    public void setDadosFinanceiros(ArrayOfDadosFinanceiros dadosFinanceiros) {
        this.dadosFinanceiros = dadosFinanceiros;
    }


    /**
     * Gets the matricula value for this ArrayDadosFinanceiros.
     * 
     * @return matricula
     */
    public java.lang.Integer getMatricula() {
        return matricula;
    }


    /**
     * Sets the matricula value for this ArrayDadosFinanceiros.
     * 
     * @param matricula
     */
    public void setMatricula(java.lang.Integer matricula) {
        this.matricula = matricula;
    }


    /**
     * Gets the mesAnoPagamento value for this ArrayDadosFinanceiros.
     * 
     * @return mesAnoPagamento
     */
    public java.lang.String getMesAnoPagamento() {
        return mesAnoPagamento;
    }


    /**
     * Sets the mesAnoPagamento value for this ArrayDadosFinanceiros.
     * 
     * @param mesAnoPagamento
     */
    public void setMesAnoPagamento(java.lang.String mesAnoPagamento) {
        this.mesAnoPagamento = mesAnoPagamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayDadosFinanceiros)) return false;
        ArrayDadosFinanceiros other = (ArrayDadosFinanceiros) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoOrgao==null && other.getCodigoOrgao()==null) || 
             (this.codigoOrgao!=null &&
              this.codigoOrgao.equals(other.getCodigoOrgao()))) &&
            ((this.dadosFinanceiros==null && other.getDadosFinanceiros()==null) || 
             (this.dadosFinanceiros!=null &&
              this.dadosFinanceiros.equals(other.getDadosFinanceiros()))) &&
            ((this.matricula==null && other.getMatricula()==null) || 
             (this.matricula!=null &&
              this.matricula.equals(other.getMatricula()))) &&
            ((this.mesAnoPagamento==null && other.getMesAnoPagamento()==null) || 
             (this.mesAnoPagamento!=null &&
              this.mesAnoPagamento.equals(other.getMesAnoPagamento())));
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
        if (getCodigoOrgao() != null) {
            _hashCode += getCodigoOrgao().hashCode();
        }
        if (getDadosFinanceiros() != null) {
            _hashCode += getDadosFinanceiros().hashCode();
        }
        if (getMatricula() != null) {
            _hashCode += getMatricula().hashCode();
        }
        if (getMesAnoPagamento() != null) {
            _hashCode += getMesAnoPagamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayDadosFinanceiros.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayDadosFinanceiros"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codigoOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosFinanceiros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dadosFinanceiros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosFinanceiros"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matricula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "matricula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesAnoPagamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "mesAnoPagamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
