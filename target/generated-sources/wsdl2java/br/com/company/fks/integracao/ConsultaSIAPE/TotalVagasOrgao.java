/**
 * TotalVagasOrgao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class TotalVagasOrgao  implements java.io.Serializable {
    private java.lang.String codNatJuridica;

    private java.lang.String nomeNatJuridica;

    private ArrayOfVagasOrgao vagasPorOrgao;

    public TotalVagasOrgao() {
    }

    public TotalVagasOrgao(
           java.lang.String codNatJuridica,
           java.lang.String nomeNatJuridica,
           ArrayOfVagasOrgao vagasPorOrgao) {
           this.codNatJuridica = codNatJuridica;
           this.nomeNatJuridica = nomeNatJuridica;
           this.vagasPorOrgao = vagasPorOrgao;
    }


    /**
     * Gets the codNatJuridica value for this TotalVagasOrgao.
     * 
     * @return codNatJuridica
     */
    public java.lang.String getCodNatJuridica() {
        return codNatJuridica;
    }


    /**
     * Sets the codNatJuridica value for this TotalVagasOrgao.
     * 
     * @param codNatJuridica
     */
    public void setCodNatJuridica(java.lang.String codNatJuridica) {
        this.codNatJuridica = codNatJuridica;
    }


    /**
     * Gets the nomeNatJuridica value for this TotalVagasOrgao.
     * 
     * @return nomeNatJuridica
     */
    public java.lang.String getNomeNatJuridica() {
        return nomeNatJuridica;
    }


    /**
     * Sets the nomeNatJuridica value for this TotalVagasOrgao.
     * 
     * @param nomeNatJuridica
     */
    public void setNomeNatJuridica(java.lang.String nomeNatJuridica) {
        this.nomeNatJuridica = nomeNatJuridica;
    }


    /**
     * Gets the vagasPorOrgao value for this TotalVagasOrgao.
     * 
     * @return vagasPorOrgao
     */
    public ArrayOfVagasOrgao getVagasPorOrgao() {
        return vagasPorOrgao;
    }


    /**
     * Sets the vagasPorOrgao value for this TotalVagasOrgao.
     * 
     * @param vagasPorOrgao
     */
    public void setVagasPorOrgao(ArrayOfVagasOrgao vagasPorOrgao) {
        this.vagasPorOrgao = vagasPorOrgao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TotalVagasOrgao)) return false;
        TotalVagasOrgao other = (TotalVagasOrgao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codNatJuridica==null && other.getCodNatJuridica()==null) || 
             (this.codNatJuridica!=null &&
              this.codNatJuridica.equals(other.getCodNatJuridica()))) &&
            ((this.nomeNatJuridica==null && other.getNomeNatJuridica()==null) || 
             (this.nomeNatJuridica!=null &&
              this.nomeNatJuridica.equals(other.getNomeNatJuridica()))) &&
            ((this.vagasPorOrgao==null && other.getVagasPorOrgao()==null) || 
             (this.vagasPorOrgao!=null &&
              this.vagasPorOrgao.equals(other.getVagasPorOrgao())));
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
        if (getCodNatJuridica() != null) {
            _hashCode += getCodNatJuridica().hashCode();
        }
        if (getNomeNatJuridica() != null) {
            _hashCode += getNomeNatJuridica().hashCode();
        }
        if (getVagasPorOrgao() != null) {
            _hashCode += getVagasPorOrgao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TotalVagasOrgao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "TotalVagasOrgao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codNatJuridica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codNatJuridica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeNatJuridica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeNatJuridica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vagasPorOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "vagasPorOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfVagasOrgao"));
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
