/**
 * ResponseArquivo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ServicoConsultaRecurso;

public class ResponseArquivo  implements java.io.Serializable {
    private java.lang.String nomeArquivo;

    private java.lang.String arquivoZipAndBase64;

    public ResponseArquivo() {
    }

    public ResponseArquivo(
           java.lang.String nomeArquivo,
           java.lang.String arquivoZipAndBase64) {
           this.nomeArquivo = nomeArquivo;
           this.arquivoZipAndBase64 = arquivoZipAndBase64;
    }


    /**
     * Gets the nomeArquivo value for this ResponseArquivo.
     * 
     * @return nomeArquivo
     */
    public java.lang.String getNomeArquivo() {
        return nomeArquivo;
    }


    /**
     * Sets the nomeArquivo value for this ResponseArquivo.
     * 
     * @param nomeArquivo
     */
    public void setNomeArquivo(java.lang.String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }


    /**
     * Gets the arquivoZipAndBase64 value for this ResponseArquivo.
     * 
     * @return arquivoZipAndBase64
     */
    public java.lang.String getArquivoZipAndBase64() {
        return arquivoZipAndBase64;
    }


    /**
     * Sets the arquivoZipAndBase64 value for this ResponseArquivo.
     * 
     * @param arquivoZipAndBase64
     */
    public void setArquivoZipAndBase64(java.lang.String arquivoZipAndBase64) {
        this.arquivoZipAndBase64 = arquivoZipAndBase64;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseArquivo)) return false;
        ResponseArquivo other = (ResponseArquivo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nomeArquivo==null && other.getNomeArquivo()==null) || 
             (this.nomeArquivo!=null &&
              this.nomeArquivo.equals(other.getNomeArquivo()))) &&
            ((this.arquivoZipAndBase64==null && other.getArquivoZipAndBase64()==null) || 
             (this.arquivoZipAndBase64!=null &&
              this.arquivoZipAndBase64.equals(other.getArquivoZipAndBase64())));
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
        if (getNomeArquivo() != null) {
            _hashCode += getNomeArquivo().hashCode();
        }
        if (getArquivoZipAndBase64() != null) {
            _hashCode += getArquivoZipAndBase64().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseArquivo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ResponseArquivo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "NomeArquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arquivoZipAndBase64");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ArquivoZipAndBase64"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
