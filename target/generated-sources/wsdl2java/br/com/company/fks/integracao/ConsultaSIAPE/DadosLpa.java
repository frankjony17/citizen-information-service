/**
 * DadosLpa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosLpa  implements java.io.Serializable {
    private java.lang.String codDiplomaAfastamento;

    private java.lang.String dataFim;

    private java.lang.String dataIni;

    private java.lang.String dataPublicacaoAfastamento;

    private java.lang.String descDiplomaAfastamento;

    private java.lang.String numeroDiplomaAfastamento;

    public DadosLpa() {
    }

    public DadosLpa(
           java.lang.String codDiplomaAfastamento,
           java.lang.String dataFim,
           java.lang.String dataIni,
           java.lang.String dataPublicacaoAfastamento,
           java.lang.String descDiplomaAfastamento,
           java.lang.String numeroDiplomaAfastamento) {
           this.codDiplomaAfastamento = codDiplomaAfastamento;
           this.dataFim = dataFim;
           this.dataIni = dataIni;
           this.dataPublicacaoAfastamento = dataPublicacaoAfastamento;
           this.descDiplomaAfastamento = descDiplomaAfastamento;
           this.numeroDiplomaAfastamento = numeroDiplomaAfastamento;
    }


    /**
     * Gets the codDiplomaAfastamento value for this DadosLpa.
     * 
     * @return codDiplomaAfastamento
     */
    public java.lang.String getCodDiplomaAfastamento() {
        return codDiplomaAfastamento;
    }


    /**
     * Sets the codDiplomaAfastamento value for this DadosLpa.
     * 
     * @param codDiplomaAfastamento
     */
    public void setCodDiplomaAfastamento(java.lang.String codDiplomaAfastamento) {
        this.codDiplomaAfastamento = codDiplomaAfastamento;
    }


    /**
     * Gets the dataFim value for this DadosLpa.
     * 
     * @return dataFim
     */
    public java.lang.String getDataFim() {
        return dataFim;
    }


    /**
     * Sets the dataFim value for this DadosLpa.
     * 
     * @param dataFim
     */
    public void setDataFim(java.lang.String dataFim) {
        this.dataFim = dataFim;
    }


    /**
     * Gets the dataIni value for this DadosLpa.
     * 
     * @return dataIni
     */
    public java.lang.String getDataIni() {
        return dataIni;
    }


    /**
     * Sets the dataIni value for this DadosLpa.
     * 
     * @param dataIni
     */
    public void setDataIni(java.lang.String dataIni) {
        this.dataIni = dataIni;
    }


    /**
     * Gets the dataPublicacaoAfastamento value for this DadosLpa.
     * 
     * @return dataPublicacaoAfastamento
     */
    public java.lang.String getDataPublicacaoAfastamento() {
        return dataPublicacaoAfastamento;
    }


    /**
     * Sets the dataPublicacaoAfastamento value for this DadosLpa.
     * 
     * @param dataPublicacaoAfastamento
     */
    public void setDataPublicacaoAfastamento(java.lang.String dataPublicacaoAfastamento) {
        this.dataPublicacaoAfastamento = dataPublicacaoAfastamento;
    }


    /**
     * Gets the descDiplomaAfastamento value for this DadosLpa.
     * 
     * @return descDiplomaAfastamento
     */
    public java.lang.String getDescDiplomaAfastamento() {
        return descDiplomaAfastamento;
    }


    /**
     * Sets the descDiplomaAfastamento value for this DadosLpa.
     * 
     * @param descDiplomaAfastamento
     */
    public void setDescDiplomaAfastamento(java.lang.String descDiplomaAfastamento) {
        this.descDiplomaAfastamento = descDiplomaAfastamento;
    }


    /**
     * Gets the numeroDiplomaAfastamento value for this DadosLpa.
     * 
     * @return numeroDiplomaAfastamento
     */
    public java.lang.String getNumeroDiplomaAfastamento() {
        return numeroDiplomaAfastamento;
    }


    /**
     * Sets the numeroDiplomaAfastamento value for this DadosLpa.
     * 
     * @param numeroDiplomaAfastamento
     */
    public void setNumeroDiplomaAfastamento(java.lang.String numeroDiplomaAfastamento) {
        this.numeroDiplomaAfastamento = numeroDiplomaAfastamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosLpa)) return false;
        DadosLpa other = (DadosLpa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codDiplomaAfastamento==null && other.getCodDiplomaAfastamento()==null) || 
             (this.codDiplomaAfastamento!=null &&
              this.codDiplomaAfastamento.equals(other.getCodDiplomaAfastamento()))) &&
            ((this.dataFim==null && other.getDataFim()==null) || 
             (this.dataFim!=null &&
              this.dataFim.equals(other.getDataFim()))) &&
            ((this.dataIni==null && other.getDataIni()==null) || 
             (this.dataIni!=null &&
              this.dataIni.equals(other.getDataIni()))) &&
            ((this.dataPublicacaoAfastamento==null && other.getDataPublicacaoAfastamento()==null) || 
             (this.dataPublicacaoAfastamento!=null &&
              this.dataPublicacaoAfastamento.equals(other.getDataPublicacaoAfastamento()))) &&
            ((this.descDiplomaAfastamento==null && other.getDescDiplomaAfastamento()==null) || 
             (this.descDiplomaAfastamento!=null &&
              this.descDiplomaAfastamento.equals(other.getDescDiplomaAfastamento()))) &&
            ((this.numeroDiplomaAfastamento==null && other.getNumeroDiplomaAfastamento()==null) || 
             (this.numeroDiplomaAfastamento!=null &&
              this.numeroDiplomaAfastamento.equals(other.getNumeroDiplomaAfastamento())));
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
        if (getCodDiplomaAfastamento() != null) {
            _hashCode += getCodDiplomaAfastamento().hashCode();
        }
        if (getDataFim() != null) {
            _hashCode += getDataFim().hashCode();
        }
        if (getDataIni() != null) {
            _hashCode += getDataIni().hashCode();
        }
        if (getDataPublicacaoAfastamento() != null) {
            _hashCode += getDataPublicacaoAfastamento().hashCode();
        }
        if (getDescDiplomaAfastamento() != null) {
            _hashCode += getDescDiplomaAfastamento().hashCode();
        }
        if (getNumeroDiplomaAfastamento() != null) {
            _hashCode += getNumeroDiplomaAfastamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosLpa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosLpa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codDiplomaAfastamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codDiplomaAfastamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFim");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dataFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataIni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dataIni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataPublicacaoAfastamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dataPublicacaoAfastamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descDiplomaAfastamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "descDiplomaAfastamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDiplomaAfastamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "numeroDiplomaAfastamento"));
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
