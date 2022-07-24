/**
 * ArrayFichaFinanceira.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayFichaFinanceira  implements java.io.Serializable {
    private java.lang.String data;

    private ArrayOfFichaFinaceiraBeneficiario fichaFinaceiraBeneficiario;

    public ArrayFichaFinanceira() {
    }

    public ArrayFichaFinanceira(
           java.lang.String data,
           ArrayOfFichaFinaceiraBeneficiario fichaFinaceiraBeneficiario) {
           this.data = data;
           this.fichaFinaceiraBeneficiario = fichaFinaceiraBeneficiario;
    }


    /**
     * Gets the data value for this ArrayFichaFinanceira.
     * 
     * @return data
     */
    public java.lang.String getData() {
        return data;
    }


    /**
     * Sets the data value for this ArrayFichaFinanceira.
     * 
     * @param data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }


    /**
     * Gets the fichaFinaceiraBeneficiario value for this ArrayFichaFinanceira.
     * 
     * @return fichaFinaceiraBeneficiario
     */
    public ArrayOfFichaFinaceiraBeneficiario getFichaFinaceiraBeneficiario() {
        return fichaFinaceiraBeneficiario;
    }


    /**
     * Sets the fichaFinaceiraBeneficiario value for this ArrayFichaFinanceira.
     * 
     * @param fichaFinaceiraBeneficiario
     */
    public void setFichaFinaceiraBeneficiario(ArrayOfFichaFinaceiraBeneficiario fichaFinaceiraBeneficiario) {
        this.fichaFinaceiraBeneficiario = fichaFinaceiraBeneficiario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayFichaFinanceira)) return false;
        ArrayFichaFinanceira other = (ArrayFichaFinanceira) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.fichaFinaceiraBeneficiario==null && other.getFichaFinaceiraBeneficiario()==null) || 
             (this.fichaFinaceiraBeneficiario!=null &&
              this.fichaFinaceiraBeneficiario.equals(other.getFichaFinaceiraBeneficiario())));
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
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getFichaFinaceiraBeneficiario() != null) {
            _hashCode += getFichaFinaceiraBeneficiario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayFichaFinanceira.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayFichaFinanceira"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fichaFinaceiraBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "fichaFinaceiraBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfFichaFinaceiraBeneficiario"));
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
