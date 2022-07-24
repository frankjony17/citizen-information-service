/**
 * ArrayOfDadosReclusao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfDadosReclusao  implements java.io.Serializable {
    private DadosReclusao[] dadosReclusao;

    public ArrayOfDadosReclusao() {
    }

    public ArrayOfDadosReclusao(
           DadosReclusao[] dadosReclusao) {
           this.dadosReclusao = dadosReclusao;
    }


    /**
     * Gets the dadosReclusao value for this ArrayOfDadosReclusao.
     * 
     * @return dadosReclusao
     */
    public DadosReclusao[] getDadosReclusao() {
        return dadosReclusao;
    }


    /**
     * Sets the dadosReclusao value for this ArrayOfDadosReclusao.
     * 
     * @param dadosReclusao
     */
    public void setDadosReclusao(DadosReclusao[] dadosReclusao) {
        this.dadosReclusao = dadosReclusao;
    }

    public DadosReclusao getDadosReclusao(int i) {
        return this.dadosReclusao[i];
    }

    public void setDadosReclusao(int i, DadosReclusao _value) {
        this.dadosReclusao[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDadosReclusao)) return false;
        ArrayOfDadosReclusao other = (ArrayOfDadosReclusao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dadosReclusao==null && other.getDadosReclusao()==null) || 
             (this.dadosReclusao!=null &&
              java.util.Arrays.equals(this.dadosReclusao, other.getDadosReclusao())));
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
        if (getDadosReclusao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDadosReclusao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDadosReclusao(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfDadosReclusao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosReclusao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dadosReclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosReclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosReclusao"));
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
