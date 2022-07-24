/**
 * DadosTitulacao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosTitulacao  implements java.io.Serializable {
    private java.lang.String codMatricula;

    private java.lang.String codOrgao;

    private java.lang.String codTitulacao;

    private java.lang.String nomeTitulacao;

    public DadosTitulacao() {
    }

    public DadosTitulacao(
           java.lang.String codMatricula,
           java.lang.String codOrgao,
           java.lang.String codTitulacao,
           java.lang.String nomeTitulacao) {
           this.codMatricula = codMatricula;
           this.codOrgao = codOrgao;
           this.codTitulacao = codTitulacao;
           this.nomeTitulacao = nomeTitulacao;
    }


    /**
     * Gets the codMatricula value for this DadosTitulacao.
     * 
     * @return codMatricula
     */
    public java.lang.String getCodMatricula() {
        return codMatricula;
    }


    /**
     * Sets the codMatricula value for this DadosTitulacao.
     * 
     * @param codMatricula
     */
    public void setCodMatricula(java.lang.String codMatricula) {
        this.codMatricula = codMatricula;
    }


    /**
     * Gets the codOrgao value for this DadosTitulacao.
     * 
     * @return codOrgao
     */
    public java.lang.String getCodOrgao() {
        return codOrgao;
    }


    /**
     * Sets the codOrgao value for this DadosTitulacao.
     * 
     * @param codOrgao
     */
    public void setCodOrgao(java.lang.String codOrgao) {
        this.codOrgao = codOrgao;
    }


    /**
     * Gets the codTitulacao value for this DadosTitulacao.
     * 
     * @return codTitulacao
     */
    public java.lang.String getCodTitulacao() {
        return codTitulacao;
    }


    /**
     * Sets the codTitulacao value for this DadosTitulacao.
     * 
     * @param codTitulacao
     */
    public void setCodTitulacao(java.lang.String codTitulacao) {
        this.codTitulacao = codTitulacao;
    }


    /**
     * Gets the nomeTitulacao value for this DadosTitulacao.
     * 
     * @return nomeTitulacao
     */
    public java.lang.String getNomeTitulacao() {
        return nomeTitulacao;
    }


    /**
     * Sets the nomeTitulacao value for this DadosTitulacao.
     * 
     * @param nomeTitulacao
     */
    public void setNomeTitulacao(java.lang.String nomeTitulacao) {
        this.nomeTitulacao = nomeTitulacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosTitulacao)) return false;
        DadosTitulacao other = (DadosTitulacao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codMatricula==null && other.getCodMatricula()==null) || 
             (this.codMatricula!=null &&
              this.codMatricula.equals(other.getCodMatricula()))) &&
            ((this.codOrgao==null && other.getCodOrgao()==null) || 
             (this.codOrgao!=null &&
              this.codOrgao.equals(other.getCodOrgao()))) &&
            ((this.codTitulacao==null && other.getCodTitulacao()==null) || 
             (this.codTitulacao!=null &&
              this.codTitulacao.equals(other.getCodTitulacao()))) &&
            ((this.nomeTitulacao==null && other.getNomeTitulacao()==null) || 
             (this.nomeTitulacao!=null &&
              this.nomeTitulacao.equals(other.getNomeTitulacao())));
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
        if (getCodMatricula() != null) {
            _hashCode += getCodMatricula().hashCode();
        }
        if (getCodOrgao() != null) {
            _hashCode += getCodOrgao().hashCode();
        }
        if (getCodTitulacao() != null) {
            _hashCode += getCodTitulacao().hashCode();
        }
        if (getNomeTitulacao() != null) {
            _hashCode += getNomeTitulacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosTitulacao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosTitulacao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codMatricula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codMatricula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codTitulacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codTitulacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeTitulacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeTitulacao"));
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
