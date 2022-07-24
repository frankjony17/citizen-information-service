/**
 * DadosEscolares.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosEscolares  implements java.io.Serializable {
    private ArrayOfDadosCurso arrayCursos;

    private ArrayOfDadosTitulacao arrayTitulacao;

    private java.lang.String codEscolaridade;

    private java.lang.String nomeEscolaridade;

    public DadosEscolares() {
    }

    public DadosEscolares(
           ArrayOfDadosCurso arrayCursos,
           ArrayOfDadosTitulacao arrayTitulacao,
           java.lang.String codEscolaridade,
           java.lang.String nomeEscolaridade) {
           this.arrayCursos = arrayCursos;
           this.arrayTitulacao = arrayTitulacao;
           this.codEscolaridade = codEscolaridade;
           this.nomeEscolaridade = nomeEscolaridade;
    }


    /**
     * Gets the arrayCursos value for this DadosEscolares.
     * 
     * @return arrayCursos
     */
    public ArrayOfDadosCurso getArrayCursos() {
        return arrayCursos;
    }


    /**
     * Sets the arrayCursos value for this DadosEscolares.
     * 
     * @param arrayCursos
     */
    public void setArrayCursos(ArrayOfDadosCurso arrayCursos) {
        this.arrayCursos = arrayCursos;
    }


    /**
     * Gets the arrayTitulacao value for this DadosEscolares.
     * 
     * @return arrayTitulacao
     */
    public ArrayOfDadosTitulacao getArrayTitulacao() {
        return arrayTitulacao;
    }


    /**
     * Sets the arrayTitulacao value for this DadosEscolares.
     * 
     * @param arrayTitulacao
     */
    public void setArrayTitulacao(ArrayOfDadosTitulacao arrayTitulacao) {
        this.arrayTitulacao = arrayTitulacao;
    }


    /**
     * Gets the codEscolaridade value for this DadosEscolares.
     * 
     * @return codEscolaridade
     */
    public java.lang.String getCodEscolaridade() {
        return codEscolaridade;
    }


    /**
     * Sets the codEscolaridade value for this DadosEscolares.
     * 
     * @param codEscolaridade
     */
    public void setCodEscolaridade(java.lang.String codEscolaridade) {
        this.codEscolaridade = codEscolaridade;
    }


    /**
     * Gets the nomeEscolaridade value for this DadosEscolares.
     * 
     * @return nomeEscolaridade
     */
    public java.lang.String getNomeEscolaridade() {
        return nomeEscolaridade;
    }


    /**
     * Sets the nomeEscolaridade value for this DadosEscolares.
     * 
     * @param nomeEscolaridade
     */
    public void setNomeEscolaridade(java.lang.String nomeEscolaridade) {
        this.nomeEscolaridade = nomeEscolaridade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosEscolares)) return false;
        DadosEscolares other = (DadosEscolares) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayCursos==null && other.getArrayCursos()==null) || 
             (this.arrayCursos!=null &&
              this.arrayCursos.equals(other.getArrayCursos()))) &&
            ((this.arrayTitulacao==null && other.getArrayTitulacao()==null) || 
             (this.arrayTitulacao!=null &&
              this.arrayTitulacao.equals(other.getArrayTitulacao()))) &&
            ((this.codEscolaridade==null && other.getCodEscolaridade()==null) || 
             (this.codEscolaridade!=null &&
              this.codEscolaridade.equals(other.getCodEscolaridade()))) &&
            ((this.nomeEscolaridade==null && other.getNomeEscolaridade()==null) || 
             (this.nomeEscolaridade!=null &&
              this.nomeEscolaridade.equals(other.getNomeEscolaridade())));
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
        if (getArrayCursos() != null) {
            _hashCode += getArrayCursos().hashCode();
        }
        if (getArrayTitulacao() != null) {
            _hashCode += getArrayTitulacao().hashCode();
        }
        if (getCodEscolaridade() != null) {
            _hashCode += getCodEscolaridade().hashCode();
        }
        if (getNomeEscolaridade() != null) {
            _hashCode += getNomeEscolaridade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosEscolares.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosEscolares"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayCursos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "arrayCursos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosCurso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayTitulacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "arrayTitulacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosTitulacao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codEscolaridade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codEscolaridade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeEscolaridade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeEscolaridade"));
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
