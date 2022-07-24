/**
 * ArrayOfDadosFuncionais.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosFuncionais  implements java.io.Serializable {
    private DadosFuncionais[] dadosFuncionais;

    public ArrayOfDadosFuncionais() {
    }

    public ArrayOfDadosFuncionais(
           DadosFuncionais[] dadosFuncionais) {
           this.dadosFuncionais = dadosFuncionais;
    }


    /**
     * Gets the dadosFuncionais value for this ArrayOfDadosFuncionais.
     * 
     * @return dadosFuncionais
     */
    public DadosFuncionais[] getDadosFuncionais() {
        return dadosFuncionais;
    }


    /**
     * Sets the dadosFuncionais value for this ArrayOfDadosFuncionais.
     * 
     * @param dadosFuncionais
     */
    public void setDadosFuncionais(DadosFuncionais[] dadosFuncionais) {
        this.dadosFuncionais = dadosFuncionais;
    }

    public DadosFuncionais getDadosFuncionais(int i) {
        return this.dadosFuncionais[i];
    }

    public void setDadosFuncionais(int i, DadosFuncionais _value) {
        this.dadosFuncionais[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosFuncionais)) return false;
        ArrayOfDadosFuncionais other = (ArrayOfDadosFuncionais) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosFuncionais==null && other.getDadosFuncionais()==null) || 
             (this.dadosFuncionais!=null &&
              java.util.Arrays.equals(this.dadosFuncionais, other.getDadosFuncionais())));
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
        if (getDadosFuncionais() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosFuncionais());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosFuncionais(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosFuncionais.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosFuncionais"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosFuncionais");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosFuncionais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosFuncionais"));
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
