/**
 * ArrayOfDadosSICAJ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosSICAJ  implements java.io.Serializable {
    private DadosSICAJ[] dadosSICAJ;

    public ArrayOfDadosSICAJ() {
    }

    public ArrayOfDadosSICAJ(
           DadosSICAJ[] dadosSICAJ) {
           this.dadosSICAJ = dadosSICAJ;
    }


    /**
     * Gets the dadosSICAJ value for this ArrayOfDadosSICAJ.
     * 
     * @return dadosSICAJ
     */
    public DadosSICAJ[] getDadosSICAJ() {
        return dadosSICAJ;
    }


    /**
     * Sets the dadosSICAJ value for this ArrayOfDadosSICAJ.
     * 
     * @param dadosSICAJ
     */
    public void setDadosSICAJ(DadosSICAJ[] dadosSICAJ) {
        this.dadosSICAJ = dadosSICAJ;
    }

    public DadosSICAJ getDadosSICAJ(int i) {
        return this.dadosSICAJ[i];
    }

    public void setDadosSICAJ(int i, DadosSICAJ _value) {
        this.dadosSICAJ[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosSICAJ)) return false;
        ArrayOfDadosSICAJ other = (ArrayOfDadosSICAJ) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosSICAJ==null && other.getDadosSICAJ()==null) || 
             (this.dadosSICAJ!=null &&
              java.util.Arrays.equals(this.dadosSICAJ, other.getDadosSICAJ())));
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
        if (getDadosSICAJ() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosSICAJ());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosSICAJ(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosSICAJ.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosSICAJ"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosSICAJ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosSICAJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosSICAJ"));
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
