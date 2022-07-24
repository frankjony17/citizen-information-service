/**
 * ArrayOfDadosDependentes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosDependentes  implements java.io.Serializable {
    private DadosDependentes[] dadosDependentes;

    public ArrayOfDadosDependentes() {
    }

    public ArrayOfDadosDependentes(
           DadosDependentes[] dadosDependentes) {
           this.dadosDependentes = dadosDependentes;
    }


    /**
     * Gets the dadosDependentes value for this ArrayOfDadosDependentes.
     * 
     * @return dadosDependentes
     */
    public DadosDependentes[] getDadosDependentes() {
        return dadosDependentes;
    }


    /**
     * Sets the dadosDependentes value for this ArrayOfDadosDependentes.
     * 
     * @param dadosDependentes
     */
    public void setDadosDependentes(DadosDependentes[] dadosDependentes) {
        this.dadosDependentes = dadosDependentes;
    }

    public DadosDependentes getDadosDependentes(int i) {
        return this.dadosDependentes[i];
    }

    public void setDadosDependentes(int i, DadosDependentes _value) {
        this.dadosDependentes[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosDependentes)) return false;
        ArrayOfDadosDependentes other = (ArrayOfDadosDependentes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosDependentes==null && other.getDadosDependentes()==null) || 
             (this.dadosDependentes!=null &&
              java.util.Arrays.equals(this.dadosDependentes, other.getDadosDependentes())));
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
        if (getDadosDependentes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosDependentes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosDependentes(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosDependentes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosDependentes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosDependentes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosDependentes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosDependentes"));
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
