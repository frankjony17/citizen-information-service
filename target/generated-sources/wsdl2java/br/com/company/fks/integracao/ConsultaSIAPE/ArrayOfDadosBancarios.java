/**
 * ArrayOfDadosBancarios.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosBancarios  implements java.io.Serializable {
    private DadosBancarios[] dadosBancarios;

    public ArrayOfDadosBancarios() {
    }

    public ArrayOfDadosBancarios(
           DadosBancarios[] dadosBancarios) {
           this.dadosBancarios = dadosBancarios;
    }


    /**
     * Gets the dadosBancarios value for this ArrayOfDadosBancarios.
     * 
     * @return dadosBancarios
     */
    public DadosBancarios[] getDadosBancarios() {
        return dadosBancarios;
    }


    /**
     * Sets the dadosBancarios value for this ArrayOfDadosBancarios.
     * 
     * @param dadosBancarios
     */
    public void setDadosBancarios(DadosBancarios[] dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public DadosBancarios getDadosBancarios(int i) {
        return this.dadosBancarios[i];
    }

    public void setDadosBancarios(int i, DadosBancarios _value) {
        this.dadosBancarios[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosBancarios)) return false;
        ArrayOfDadosBancarios other = (ArrayOfDadosBancarios) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosBancarios==null && other.getDadosBancarios()==null) || 
             (this.dadosBancarios!=null &&
              java.util.Arrays.equals(this.dadosBancarios, other.getDadosBancarios())));
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
        if (getDadosBancarios() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosBancarios());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosBancarios(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosBancarios.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosBancarios"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosBancarios");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosBancarios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosBancarios"));
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
