/**
 * DadosOcorrencias.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosOcorrencias  implements java.io.Serializable {
    private java.lang.String codDiplomaAfastamento;

    private java.lang.String codOcorrencia;

    private java.lang.String dataFim;

    private java.lang.String dataIni;

    private java.lang.String dataPublicacaoAfastamento;

    private java.lang.String descDiplomaAfastamento;

    private java.lang.String descOcorrencia;

    private java.lang.String numeroDiplomaAfastamento;

    public DadosOcorrencias() {
    }

    public DadosOcorrencias(
           java.lang.String codDiplomaAfastamento,
           java.lang.String codOcorrencia,
           java.lang.String dataFim,
           java.lang.String dataIni,
           java.lang.String dataPublicacaoAfastamento,
           java.lang.String descDiplomaAfastamento,
           java.lang.String descOcorrencia,
           java.lang.String numeroDiplomaAfastamento) {
           this.codDiplomaAfastamento = codDiplomaAfastamento;
           this.codOcorrencia = codOcorrencia;
           this.dataFim = dataFim;
           this.dataIni = dataIni;
           this.dataPublicacaoAfastamento = dataPublicacaoAfastamento;
           this.descDiplomaAfastamento = descDiplomaAfastamento;
           this.descOcorrencia = descOcorrencia;
           this.numeroDiplomaAfastamento = numeroDiplomaAfastamento;
    }


    /**
     * Gets the codDiplomaAfastamento value for this DadosOcorrencias.
     * 
     * @return codDiplomaAfastamento
     */
    public java.lang.String getCodDiplomaAfastamento() {
        return codDiplomaAfastamento;
    }


    /**
     * Sets the codDiplomaAfastamento value for this DadosOcorrencias.
     * 
     * @param codDiplomaAfastamento
     */
    public void setCodDiplomaAfastamento(java.lang.String codDiplomaAfastamento) {
        this.codDiplomaAfastamento = codDiplomaAfastamento;
    }


    /**
     * Gets the codOcorrencia value for this DadosOcorrencias.
     * 
     * @return codOcorrencia
     */
    public java.lang.String getCodOcorrencia() {
        return codOcorrencia;
    }


    /**
     * Sets the codOcorrencia value for this DadosOcorrencias.
     * 
     * @param codOcorrencia
     */
    public void setCodOcorrencia(java.lang.String codOcorrencia) {
        this.codOcorrencia = codOcorrencia;
    }


    /**
     * Gets the dataFim value for this DadosOcorrencias.
     * 
     * @return dataFim
     */
    public java.lang.String getDataFim() {
        return dataFim;
    }


    /**
     * Sets the dataFim value for this DadosOcorrencias.
     * 
     * @param dataFim
     */
    public void setDataFim(java.lang.String dataFim) {
        this.dataFim = dataFim;
    }


    /**
     * Gets the dataIni value for this DadosOcorrencias.
     * 
     * @return dataIni
     */
    public java.lang.String getDataIni() {
        return dataIni;
    }


    /**
     * Sets the dataIni value for this DadosOcorrencias.
     * 
     * @param dataIni
     */
    public void setDataIni(java.lang.String dataIni) {
        this.dataIni = dataIni;
    }


    /**
     * Gets the dataPublicacaoAfastamento value for this DadosOcorrencias.
     * 
     * @return dataPublicacaoAfastamento
     */
    public java.lang.String getDataPublicacaoAfastamento() {
        return dataPublicacaoAfastamento;
    }


    /**
     * Sets the dataPublicacaoAfastamento value for this DadosOcorrencias.
     * 
     * @param dataPublicacaoAfastamento
     */
    public void setDataPublicacaoAfastamento(java.lang.String dataPublicacaoAfastamento) {
        this.dataPublicacaoAfastamento = dataPublicacaoAfastamento;
    }


    /**
     * Gets the descDiplomaAfastamento value for this DadosOcorrencias.
     * 
     * @return descDiplomaAfastamento
     */
    public java.lang.String getDescDiplomaAfastamento() {
        return descDiplomaAfastamento;
    }


    /**
     * Sets the descDiplomaAfastamento value for this DadosOcorrencias.
     * 
     * @param descDiplomaAfastamento
     */
    public void setDescDiplomaAfastamento(java.lang.String descDiplomaAfastamento) {
        this.descDiplomaAfastamento = descDiplomaAfastamento;
    }


    /**
     * Gets the descOcorrencia value for this DadosOcorrencias.
     * 
     * @return descOcorrencia
     */
    public java.lang.String getDescOcorrencia() {
        return descOcorrencia;
    }


    /**
     * Sets the descOcorrencia value for this DadosOcorrencias.
     * 
     * @param descOcorrencia
     */
    public void setDescOcorrencia(java.lang.String descOcorrencia) {
        this.descOcorrencia = descOcorrencia;
    }


    /**
     * Gets the numeroDiplomaAfastamento value for this DadosOcorrencias.
     * 
     * @return numeroDiplomaAfastamento
     */
    public java.lang.String getNumeroDiplomaAfastamento() {
        return numeroDiplomaAfastamento;
    }


    /**
     * Sets the numeroDiplomaAfastamento value for this DadosOcorrencias.
     * 
     * @param numeroDiplomaAfastamento
     */
    public void setNumeroDiplomaAfastamento(java.lang.String numeroDiplomaAfastamento) {
        this.numeroDiplomaAfastamento = numeroDiplomaAfastamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosOcorrencias)) return false;
        DadosOcorrencias other = (DadosOcorrencias) obj;
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
            ((this.codOcorrencia==null && other.getCodOcorrencia()==null) || 
             (this.codOcorrencia!=null &&
              this.codOcorrencia.equals(other.getCodOcorrencia()))) &&
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
            ((this.descOcorrencia==null && other.getDescOcorrencia()==null) || 
             (this.descOcorrencia!=null &&
              this.descOcorrencia.equals(other.getDescOcorrencia()))) &&
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
        if (getCodOcorrencia() != null) {
            _hashCode += getCodOcorrencia().hashCode();
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
        if (getDescOcorrencia() != null) {
            _hashCode += getDescOcorrencia().hashCode();
        }
        if (getNumeroDiplomaAfastamento() != null) {
            _hashCode += getNumeroDiplomaAfastamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosOcorrencias.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosOcorrencias"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codDiplomaAfastamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codDiplomaAfastamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codOcorrencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codOcorrencia"));
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
        elemField.setFieldName("descOcorrencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "descOcorrencia"));
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
