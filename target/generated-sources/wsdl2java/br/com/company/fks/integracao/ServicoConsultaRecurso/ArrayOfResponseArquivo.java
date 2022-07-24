/**
 * ArrayOfResponseArquivo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ServicoConsultaRecurso;

public class ArrayOfResponseArquivo  implements java.io.Serializable {
    private ResponseArquivo[] responseArquivo;

    public ArrayOfResponseArquivo() {
    }

    public ArrayOfResponseArquivo(
           ResponseArquivo[] responseArquivo) {
           this.responseArquivo = responseArquivo;
    }


    /**
     * Gets the responseArquivo value for this ArrayOfResponseArquivo.
     * 
     * @return responseArquivo
     */
    public ResponseArquivo[] getResponseArquivo() {
        return responseArquivo;
    }


    /**
     * Sets the responseArquivo value for this ArrayOfResponseArquivo.
     * 
     * @param responseArquivo
     */
    public void setResponseArquivo(ResponseArquivo[] responseArquivo) {
        this.responseArquivo = responseArquivo;
    }

    public ResponseArquivo getResponseArquivo(int i) {
        return this.responseArquivo[i];
    }

    public void setResponseArquivo(int i, ResponseArquivo _value) {
        this.responseArquivo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfResponseArquivo)) return false;
        ArrayOfResponseArquivo other = (ArrayOfResponseArquivo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.responseArquivo==null && other.getResponseArquivo()==null) || 
             (this.responseArquivo!=null &&
              java.util.Arrays.equals(this.responseArquivo, other.getResponseArquivo())));
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
        if (getResponseArquivo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResponseArquivo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResponseArquivo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayOfResponseArquivo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ArrayOfResponseArquivo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ResponseArquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ResponseArquivo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
