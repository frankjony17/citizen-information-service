/**
 * DadosCurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosCurso  implements java.io.Serializable {
    private java.lang.String codCurso;

    private java.lang.String nomeCurso;

    public DadosCurso() {
    }

    public DadosCurso(
           java.lang.String codCurso,
           java.lang.String nomeCurso) {
           this.codCurso = codCurso;
           this.nomeCurso = nomeCurso;
    }


    /**
     * Gets the codCurso value for this DadosCurso.
     * 
     * @return codCurso
     */
    public java.lang.String getCodCurso() {
        return codCurso;
    }


    /**
     * Sets the codCurso value for this DadosCurso.
     * 
     * @param codCurso
     */
    public void setCodCurso(java.lang.String codCurso) {
        this.codCurso = codCurso;
    }


    /**
     * Gets the nomeCurso value for this DadosCurso.
     * 
     * @return nomeCurso
     */
    public java.lang.String getNomeCurso() {
        return nomeCurso;
    }


    /**
     * Sets the nomeCurso value for this DadosCurso.
     * 
     * @param nomeCurso
     */
    public void setNomeCurso(java.lang.String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosCurso)) return false;
        DadosCurso other = (DadosCurso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codCurso==null && other.getCodCurso()==null) || 
             (this.codCurso!=null &&
              this.codCurso.equals(other.getCodCurso()))) &&
            ((this.nomeCurso==null && other.getNomeCurso()==null) || 
             (this.nomeCurso!=null &&
              this.nomeCurso.equals(other.getNomeCurso())));
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
        if (getCodCurso() != null) {
            _hashCode += getCodCurso().hashCode();
        }
        if (getNomeCurso() != null) {
            _hashCode += getNomeCurso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosCurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosCurso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codCurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeCurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeCurso"));
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
