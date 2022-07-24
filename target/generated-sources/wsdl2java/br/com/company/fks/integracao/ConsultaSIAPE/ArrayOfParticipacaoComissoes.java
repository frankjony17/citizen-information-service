/**
 * ArrayOfParticipacaoComissoes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfParticipacaoComissoes  implements java.io.Serializable {
    private ParticipacaoComissoes[] participacaoComissoes;

    public ArrayOfParticipacaoComissoes() {
    }

    public ArrayOfParticipacaoComissoes(
           ParticipacaoComissoes[] participacaoComissoes) {
           this.participacaoComissoes = participacaoComissoes;
    }


    /**
     * Gets the participacaoComissoes value for this ArrayOfParticipacaoComissoes.
     * 
     * @return participacaoComissoes
     */
    public ParticipacaoComissoes[] getParticipacaoComissoes() {
        return participacaoComissoes;
    }


    /**
     * Sets the participacaoComissoes value for this ArrayOfParticipacaoComissoes.
     * 
     * @param participacaoComissoes
     */
    public void setParticipacaoComissoes(ParticipacaoComissoes[] participacaoComissoes) {
        this.participacaoComissoes = participacaoComissoes;
    }

    public ParticipacaoComissoes getParticipacaoComissoes(int i) {
        return this.participacaoComissoes[i];
    }

    public void setParticipacaoComissoes(int i, ParticipacaoComissoes _value) {
        this.participacaoComissoes[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfParticipacaoComissoes)) return false;
        ArrayOfParticipacaoComissoes other = (ArrayOfParticipacaoComissoes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.participacaoComissoes==null && other.getParticipacaoComissoes()==null) || 
             (this.participacaoComissoes!=null &&
              java.util.Arrays.equals(this.participacaoComissoes, other.getParticipacaoComissoes())));
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
        if (getParticipacaoComissoes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParticipacaoComissoes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParticipacaoComissoes(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfParticipacaoComissoes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfParticipacaoComissoes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("participacaoComissoes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ParticipacaoComissoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ParticipacaoComissoes"));
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
