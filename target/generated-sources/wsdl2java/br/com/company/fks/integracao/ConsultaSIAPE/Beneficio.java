/**
 * Beneficio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class Beneficio  implements java.io.Serializable {
    private java.lang.String codBeneficio;

    private java.lang.String dataFim;

    private java.lang.String dataInicio;

    private java.lang.String nomeBeneficio;

    public Beneficio() {
    }

    public Beneficio(
           java.lang.String codBeneficio,
           java.lang.String dataFim,
           java.lang.String dataInicio,
           java.lang.String nomeBeneficio) {
           this.codBeneficio = codBeneficio;
           this.dataFim = dataFim;
           this.dataInicio = dataInicio;
           this.nomeBeneficio = nomeBeneficio;
    }


    /**
     * Gets the codBeneficio value for this Beneficio.
     * 
     * @return codBeneficio
     */
    public java.lang.String getCodBeneficio() {
        return codBeneficio;
    }


    /**
     * Sets the codBeneficio value for this Beneficio.
     * 
     * @param codBeneficio
     */
    public void setCodBeneficio(java.lang.String codBeneficio) {
        this.codBeneficio = codBeneficio;
    }


    /**
     * Gets the dataFim value for this Beneficio.
     * 
     * @return dataFim
     */
    public java.lang.String getDataFim() {
        return dataFim;
    }


    /**
     * Sets the dataFim value for this Beneficio.
     * 
     * @param dataFim
     */
    public void setDataFim(java.lang.String dataFim) {
        this.dataFim = dataFim;
    }


    /**
     * Gets the dataInicio value for this Beneficio.
     * 
     * @return dataInicio
     */
    public java.lang.String getDataInicio() {
        return dataInicio;
    }


    /**
     * Sets the dataInicio value for this Beneficio.
     * 
     * @param dataInicio
     */
    public void setDataInicio(java.lang.String dataInicio) {
        this.dataInicio = dataInicio;
    }


    /**
     * Gets the nomeBeneficio value for this Beneficio.
     * 
     * @return nomeBeneficio
     */
    public java.lang.String getNomeBeneficio() {
        return nomeBeneficio;
    }


    /**
     * Sets the nomeBeneficio value for this Beneficio.
     * 
     * @param nomeBeneficio
     */
    public void setNomeBeneficio(java.lang.String nomeBeneficio) {
        this.nomeBeneficio = nomeBeneficio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Beneficio)) return false;
        Beneficio other = (Beneficio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codBeneficio==null && other.getCodBeneficio()==null) || 
             (this.codBeneficio!=null &&
              this.codBeneficio.equals(other.getCodBeneficio()))) &&
            ((this.dataFim==null && other.getDataFim()==null) || 
             (this.dataFim!=null &&
              this.dataFim.equals(other.getDataFim()))) &&
            ((this.dataInicio==null && other.getDataInicio()==null) || 
             (this.dataInicio!=null &&
              this.dataInicio.equals(other.getDataInicio()))) &&
            ((this.nomeBeneficio==null && other.getNomeBeneficio()==null) || 
             (this.nomeBeneficio!=null &&
              this.nomeBeneficio.equals(other.getNomeBeneficio())));
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
        if (getCodBeneficio() != null) {
            _hashCode += getCodBeneficio().hashCode();
        }
        if (getDataFim() != null) {
            _hashCode += getDataFim().hashCode();
        }
        if (getDataInicio() != null) {
            _hashCode += getDataInicio().hashCode();
        }
        if (getNomeBeneficio() != null) {
            _hashCode += getNomeBeneficio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Beneficio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "Beneficio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codBeneficio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codBeneficio"));
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
        elemField.setFieldName("dataInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dataInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeBeneficio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeBeneficio"));
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
