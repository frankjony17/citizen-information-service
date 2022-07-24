/**
 * ArrayOfDadosOcorrencias.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosOcorrencias  implements java.io.Serializable {
    private DadosOcorrencias[] dadosOcorrencias;

    public ArrayOfDadosOcorrencias() {
    }

    public ArrayOfDadosOcorrencias(
           DadosOcorrencias[] dadosOcorrencias) {
           this.dadosOcorrencias = dadosOcorrencias;
    }


    /**
     * Gets the dadosOcorrencias value for this ArrayOfDadosOcorrencias.
     * 
     * @return dadosOcorrencias
     */
    public DadosOcorrencias[] getDadosOcorrencias() {
        return dadosOcorrencias;
    }


    /**
     * Sets the dadosOcorrencias value for this ArrayOfDadosOcorrencias.
     * 
     * @param dadosOcorrencias
     */
    public void setDadosOcorrencias(DadosOcorrencias[] dadosOcorrencias) {
        this.dadosOcorrencias = dadosOcorrencias;
    }

    public DadosOcorrencias getDadosOcorrencias(int i) {
        return this.dadosOcorrencias[i];
    }

    public void setDadosOcorrencias(int i, DadosOcorrencias _value) {
        this.dadosOcorrencias[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosOcorrencias)) return false;
        ArrayOfDadosOcorrencias other = (ArrayOfDadosOcorrencias) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosOcorrencias==null && other.getDadosOcorrencias()==null) || 
             (this.dadosOcorrencias!=null &&
              java.util.Arrays.equals(this.dadosOcorrencias, other.getDadosOcorrencias())));
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
        if (getDadosOcorrencias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosOcorrencias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosOcorrencias(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosOcorrencias.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosOcorrencias"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosOcorrencias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosOcorrencias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosOcorrencias"));
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
