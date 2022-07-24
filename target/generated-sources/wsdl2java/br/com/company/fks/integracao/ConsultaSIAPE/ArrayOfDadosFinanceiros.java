/**
 * ArrayOfDadosFinanceiros.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosFinanceiros  implements java.io.Serializable {
    private DadosFinanceiros[] dadosFinanceiros;

    public ArrayOfDadosFinanceiros() {
    }

    public ArrayOfDadosFinanceiros(
           DadosFinanceiros[] dadosFinanceiros) {
           this.dadosFinanceiros = dadosFinanceiros;
    }


    /**
     * Gets the dadosFinanceiros value for this ArrayOfDadosFinanceiros.
     * 
     * @return dadosFinanceiros
     */
    public DadosFinanceiros[] getDadosFinanceiros() {
        return dadosFinanceiros;
    }


    /**
     * Sets the dadosFinanceiros value for this ArrayOfDadosFinanceiros.
     * 
     * @param dadosFinanceiros
     */
    public void setDadosFinanceiros(DadosFinanceiros[] dadosFinanceiros) {
        this.dadosFinanceiros = dadosFinanceiros;
    }

    public DadosFinanceiros getDadosFinanceiros(int i) {
        return this.dadosFinanceiros[i];
    }

    public void setDadosFinanceiros(int i, DadosFinanceiros _value) {
        this.dadosFinanceiros[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosFinanceiros)) return false;
        ArrayOfDadosFinanceiros other = (ArrayOfDadosFinanceiros) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosFinanceiros==null && other.getDadosFinanceiros()==null) || 
             (this.dadosFinanceiros!=null &&
              java.util.Arrays.equals(this.dadosFinanceiros, other.getDadosFinanceiros())));
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
        if (getDadosFinanceiros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosFinanceiros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosFinanceiros(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosFinanceiros.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosFinanceiros"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosFinanceiros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosFinanceiros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosFinanceiros"));
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
