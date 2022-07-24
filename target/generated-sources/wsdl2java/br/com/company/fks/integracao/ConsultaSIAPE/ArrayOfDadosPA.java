/**
 * ArrayOfDadosPA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosPA  implements java.io.Serializable {
    private DadosPA[] dadosPA;

    public ArrayOfDadosPA() {
    }

    public ArrayOfDadosPA(
           DadosPA[] dadosPA) {
           this.dadosPA = dadosPA;
    }


    /**
     * Gets the dadosPA value for this ArrayOfDadosPA.
     * 
     * @return dadosPA
     */
    public DadosPA[] getDadosPA() {
        return dadosPA;
    }


    /**
     * Sets the dadosPA value for this ArrayOfDadosPA.
     * 
     * @param dadosPA
     */
    public void setDadosPA(DadosPA[] dadosPA) {
        this.dadosPA = dadosPA;
    }

    public DadosPA getDadosPA(int i) {
        return this.dadosPA[i];
    }

    public void setDadosPA(int i, DadosPA _value) {
        this.dadosPA[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosPA)) return false;
        ArrayOfDadosPA other = (ArrayOfDadosPA) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosPA==null && other.getDadosPA()==null) || 
             (this.dadosPA!=null &&
              java.util.Arrays.equals(this.dadosPA, other.getDadosPA())));
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
        if (getDadosPA() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosPA());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosPA(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosPA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosPA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosPA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosPA"));
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
