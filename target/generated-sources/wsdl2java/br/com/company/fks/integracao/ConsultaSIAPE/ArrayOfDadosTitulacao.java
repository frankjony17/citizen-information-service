/**
 * ArrayOfDadosTitulacao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosTitulacao  implements java.io.Serializable {
    private DadosTitulacao[] dadosTitulacao;

    public ArrayOfDadosTitulacao() {
    }

    public ArrayOfDadosTitulacao(
           DadosTitulacao[] dadosTitulacao) {
           this.dadosTitulacao = dadosTitulacao;
    }


    /**
     * Gets the dadosTitulacao value for this ArrayOfDadosTitulacao.
     * 
     * @return dadosTitulacao
     */
    public DadosTitulacao[] getDadosTitulacao() {
        return dadosTitulacao;
    }


    /**
     * Sets the dadosTitulacao value for this ArrayOfDadosTitulacao.
     * 
     * @param dadosTitulacao
     */
    public void setDadosTitulacao(DadosTitulacao[] dadosTitulacao) {
        this.dadosTitulacao = dadosTitulacao;
    }

    public DadosTitulacao getDadosTitulacao(int i) {
        return this.dadosTitulacao[i];
    }

    public void setDadosTitulacao(int i, DadosTitulacao _value) {
        this.dadosTitulacao[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosTitulacao)) return false;
        ArrayOfDadosTitulacao other = (ArrayOfDadosTitulacao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosTitulacao==null && other.getDadosTitulacao()==null) || 
             (this.dadosTitulacao!=null &&
              java.util.Arrays.equals(this.dadosTitulacao, other.getDadosTitulacao())));
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
        if (getDadosTitulacao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosTitulacao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosTitulacao(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosTitulacao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosTitulacao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosTitulacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosTitulacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosTitulacao"));
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
