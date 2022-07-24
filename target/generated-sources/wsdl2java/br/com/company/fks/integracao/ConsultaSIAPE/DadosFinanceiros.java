/**
 * DadosFinanceiros.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosFinanceiros  implements java.io.Serializable {
    private java.lang.String codRubrica;

    private java.lang.String dataAnoMesRubrica;

    private java.lang.String indicadorMovSupl;

    private java.lang.String indicadorRD;

    private java.lang.String nomeRubrica;

    private java.lang.String numeroSeq;

    private java.lang.String peRubrica;

    private java.lang.String pzRubrica;

    private java.lang.String valorRubrica;

    public DadosFinanceiros() {
    }

    public DadosFinanceiros(
           java.lang.String codRubrica,
           java.lang.String dataAnoMesRubrica,
           java.lang.String indicadorMovSupl,
           java.lang.String indicadorRD,
           java.lang.String nomeRubrica,
           java.lang.String numeroSeq,
           java.lang.String peRubrica,
           java.lang.String pzRubrica,
           java.lang.String valorRubrica) {
           this.codRubrica = codRubrica;
           this.dataAnoMesRubrica = dataAnoMesRubrica;
           this.indicadorMovSupl = indicadorMovSupl;
           this.indicadorRD = indicadorRD;
           this.nomeRubrica = nomeRubrica;
           this.numeroSeq = numeroSeq;
           this.peRubrica = peRubrica;
           this.pzRubrica = pzRubrica;
           this.valorRubrica = valorRubrica;
    }


    /**
     * Gets the codRubrica value for this DadosFinanceiros.
     * 
     * @return codRubrica
     */
    public java.lang.String getCodRubrica() {
        return codRubrica;
    }


    /**
     * Sets the codRubrica value for this DadosFinanceiros.
     * 
     * @param codRubrica
     */
    public void setCodRubrica(java.lang.String codRubrica) {
        this.codRubrica = codRubrica;
    }


    /**
     * Gets the dataAnoMesRubrica value for this DadosFinanceiros.
     * 
     * @return dataAnoMesRubrica
     */
    public java.lang.String getDataAnoMesRubrica() {
        return dataAnoMesRubrica;
    }


    /**
     * Sets the dataAnoMesRubrica value for this DadosFinanceiros.
     * 
     * @param dataAnoMesRubrica
     */
    public void setDataAnoMesRubrica(java.lang.String dataAnoMesRubrica) {
        this.dataAnoMesRubrica = dataAnoMesRubrica;
    }


    /**
     * Gets the indicadorMovSupl value for this DadosFinanceiros.
     * 
     * @return indicadorMovSupl
     */
    public java.lang.String getIndicadorMovSupl() {
        return indicadorMovSupl;
    }


    /**
     * Sets the indicadorMovSupl value for this DadosFinanceiros.
     * 
     * @param indicadorMovSupl
     */
    public void setIndicadorMovSupl(java.lang.String indicadorMovSupl) {
        this.indicadorMovSupl = indicadorMovSupl;
    }


    /**
     * Gets the indicadorRD value for this DadosFinanceiros.
     * 
     * @return indicadorRD
     */
    public java.lang.String getIndicadorRD() {
        return indicadorRD;
    }


    /**
     * Sets the indicadorRD value for this DadosFinanceiros.
     * 
     * @param indicadorRD
     */
    public void setIndicadorRD(java.lang.String indicadorRD) {
        this.indicadorRD = indicadorRD;
    }


    /**
     * Gets the nomeRubrica value for this DadosFinanceiros.
     * 
     * @return nomeRubrica
     */
    public java.lang.String getNomeRubrica() {
        return nomeRubrica;
    }


    /**
     * Sets the nomeRubrica value for this DadosFinanceiros.
     * 
     * @param nomeRubrica
     */
    public void setNomeRubrica(java.lang.String nomeRubrica) {
        this.nomeRubrica = nomeRubrica;
    }


    /**
     * Gets the numeroSeq value for this DadosFinanceiros.
     * 
     * @return numeroSeq
     */
    public java.lang.String getNumeroSeq() {
        return numeroSeq;
    }


    /**
     * Sets the numeroSeq value for this DadosFinanceiros.
     * 
     * @param numeroSeq
     */
    public void setNumeroSeq(java.lang.String numeroSeq) {
        this.numeroSeq = numeroSeq;
    }


    /**
     * Gets the peRubrica value for this DadosFinanceiros.
     * 
     * @return peRubrica
     */
    public java.lang.String getPeRubrica() {
        return peRubrica;
    }


    /**
     * Sets the peRubrica value for this DadosFinanceiros.
     * 
     * @param peRubrica
     */
    public void setPeRubrica(java.lang.String peRubrica) {
        this.peRubrica = peRubrica;
    }


    /**
     * Gets the pzRubrica value for this DadosFinanceiros.
     * 
     * @return pzRubrica
     */
    public java.lang.String getPzRubrica() {
        return pzRubrica;
    }


    /**
     * Sets the pzRubrica value for this DadosFinanceiros.
     * 
     * @param pzRubrica
     */
    public void setPzRubrica(java.lang.String pzRubrica) {
        this.pzRubrica = pzRubrica;
    }


    /**
     * Gets the valorRubrica value for this DadosFinanceiros.
     * 
     * @return valorRubrica
     */
    public java.lang.String getValorRubrica() {
        return valorRubrica;
    }


    /**
     * Sets the valorRubrica value for this DadosFinanceiros.
     * 
     * @param valorRubrica
     */
    public void setValorRubrica(java.lang.String valorRubrica) {
        this.valorRubrica = valorRubrica;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosFinanceiros)) return false;
        DadosFinanceiros other = (DadosFinanceiros) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codRubrica==null && other.getCodRubrica()==null) || 
             (this.codRubrica!=null &&
              this.codRubrica.equals(other.getCodRubrica()))) &&
            ((this.dataAnoMesRubrica==null && other.getDataAnoMesRubrica()==null) || 
             (this.dataAnoMesRubrica!=null &&
              this.dataAnoMesRubrica.equals(other.getDataAnoMesRubrica()))) &&
            ((this.indicadorMovSupl==null && other.getIndicadorMovSupl()==null) || 
             (this.indicadorMovSupl!=null &&
              this.indicadorMovSupl.equals(other.getIndicadorMovSupl()))) &&
            ((this.indicadorRD==null && other.getIndicadorRD()==null) || 
             (this.indicadorRD!=null &&
              this.indicadorRD.equals(other.getIndicadorRD()))) &&
            ((this.nomeRubrica==null && other.getNomeRubrica()==null) || 
             (this.nomeRubrica!=null &&
              this.nomeRubrica.equals(other.getNomeRubrica()))) &&
            ((this.numeroSeq==null && other.getNumeroSeq()==null) || 
             (this.numeroSeq!=null &&
              this.numeroSeq.equals(other.getNumeroSeq()))) &&
            ((this.peRubrica==null && other.getPeRubrica()==null) || 
             (this.peRubrica!=null &&
              this.peRubrica.equals(other.getPeRubrica()))) &&
            ((this.pzRubrica==null && other.getPzRubrica()==null) || 
             (this.pzRubrica!=null &&
              this.pzRubrica.equals(other.getPzRubrica()))) &&
            ((this.valorRubrica==null && other.getValorRubrica()==null) || 
             (this.valorRubrica!=null &&
              this.valorRubrica.equals(other.getValorRubrica())));
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
        if (getCodRubrica() != null) {
            _hashCode += getCodRubrica().hashCode();
        }
        if (getDataAnoMesRubrica() != null) {
            _hashCode += getDataAnoMesRubrica().hashCode();
        }
        if (getIndicadorMovSupl() != null) {
            _hashCode += getIndicadorMovSupl().hashCode();
        }
        if (getIndicadorRD() != null) {
            _hashCode += getIndicadorRD().hashCode();
        }
        if (getNomeRubrica() != null) {
            _hashCode += getNomeRubrica().hashCode();
        }
        if (getNumeroSeq() != null) {
            _hashCode += getNumeroSeq().hashCode();
        }
        if (getPeRubrica() != null) {
            _hashCode += getPeRubrica().hashCode();
        }
        if (getPzRubrica() != null) {
            _hashCode += getPzRubrica().hashCode();
        }
        if (getValorRubrica() != null) {
            _hashCode += getValorRubrica().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosFinanceiros.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosFinanceiros"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codRubrica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codRubrica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAnoMesRubrica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dataAnoMesRubrica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadorMovSupl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "indicadorMovSupl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicadorRD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "indicadorRD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeRubrica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeRubrica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "numeroSeq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peRubrica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "peRubrica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pzRubrica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "pzRubrica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorRubrica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "valorRubrica"));
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
