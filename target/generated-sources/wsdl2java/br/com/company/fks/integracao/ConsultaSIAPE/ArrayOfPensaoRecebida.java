/**
 * ArrayOfPensaoRecebida.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfPensaoRecebida  implements java.io.Serializable {
    private PensaoRecebida[] pensaoRecebida;

    public ArrayOfPensaoRecebida() {
    }

    public ArrayOfPensaoRecebida(
           PensaoRecebida[] pensaoRecebida) {
           this.pensaoRecebida = pensaoRecebida;
    }


    /**
     * Gets the pensaoRecebida value for this ArrayOfPensaoRecebida.
     * 
     * @return pensaoRecebida
     */
    public PensaoRecebida[] getPensaoRecebida() {
        return pensaoRecebida;
    }


    /**
     * Sets the pensaoRecebida value for this ArrayOfPensaoRecebida.
     * 
     * @param pensaoRecebida
     */
    public void setPensaoRecebida(PensaoRecebida[] pensaoRecebida) {
        this.pensaoRecebida = pensaoRecebida;
    }

    public PensaoRecebida getPensaoRecebida(int i) {
        return this.pensaoRecebida[i];
    }

    public void setPensaoRecebida(int i, PensaoRecebida _value) {
        this.pensaoRecebida[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfPensaoRecebida)) return false;
        ArrayOfPensaoRecebida other = (ArrayOfPensaoRecebida) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pensaoRecebida==null && other.getPensaoRecebida()==null) || 
             (this.pensaoRecebida!=null &&
              java.util.Arrays.equals(this.pensaoRecebida, other.getPensaoRecebida())));
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
        if (getPensaoRecebida() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPensaoRecebida());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPensaoRecebida(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfPensaoRecebida.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfPensaoRecebida"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pensaoRecebida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "PensaoRecebida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "PensaoRecebida"));
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
