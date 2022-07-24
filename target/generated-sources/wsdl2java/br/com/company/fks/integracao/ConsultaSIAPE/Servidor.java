/**
 * Servidor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class Servidor  implements java.io.Serializable {
    private java.lang.String cpf;

    private java.lang.String dataUltimaTransacao;

    public Servidor() {
    }

    public Servidor(
           java.lang.String cpf,
           java.lang.String dataUltimaTransacao) {
           this.cpf = cpf;
           this.dataUltimaTransacao = dataUltimaTransacao;
    }


    /**
     * Gets the cpf value for this Servidor.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this Servidor.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the dataUltimaTransacao value for this Servidor.
     * 
     * @return dataUltimaTransacao
     */
    public java.lang.String getDataUltimaTransacao() {
        return dataUltimaTransacao;
    }


    /**
     * Sets the dataUltimaTransacao value for this Servidor.
     * 
     * @param dataUltimaTransacao
     */
    public void setDataUltimaTransacao(java.lang.String dataUltimaTransacao) {
        this.dataUltimaTransacao = dataUltimaTransacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Servidor)) return false;
        Servidor other = (Servidor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cpf==null && other.getCpf()==null) || 
             (this.cpf!=null &&
              this.cpf.equals(other.getCpf()))) &&
            ((this.dataUltimaTransacao==null && other.getDataUltimaTransacao()==null) || 
             (this.dataUltimaTransacao!=null &&
              this.dataUltimaTransacao.equals(other.getDataUltimaTransacao())));
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
        if (getCpf() != null) {
            _hashCode += getCpf().hashCode();
        }
        if (getDataUltimaTransacao() != null) {
            _hashCode += getDataUltimaTransacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Servidor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Servidor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "cpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataUltimaTransacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "dataUltimaTransacao"));
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
