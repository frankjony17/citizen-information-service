/**
 * ArrayPensaoRecebida.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayPensaoRecebida  implements java.io.Serializable {
    private ArrayOfPensaoRecebida pensaoRecebida;

    public ArrayPensaoRecebida() {
    }

    public ArrayPensaoRecebida(
           ArrayOfPensaoRecebida pensaoRecebida) {
           this.pensaoRecebida = pensaoRecebida;
    }


    /**
     * Gets the pensaoRecebida value for this ArrayPensaoRecebida.
     * 
     * @return pensaoRecebida
     */
    public ArrayOfPensaoRecebida getPensaoRecebida() {
        return pensaoRecebida;
    }


    /**
     * Sets the pensaoRecebida value for this ArrayPensaoRecebida.
     * 
     * @param pensaoRecebida
     */
    public void setPensaoRecebida(ArrayOfPensaoRecebida pensaoRecebida) {
        this.pensaoRecebida = pensaoRecebida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayPensaoRecebida)) return false;
        ArrayPensaoRecebida other = (ArrayPensaoRecebida) obj;
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
              this.pensaoRecebida.equals(other.getPensaoRecebida())));
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
            _hashCode += getPensaoRecebida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayPensaoRecebida.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayPensaoRecebida"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pensaoRecebida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "pensaoRecebida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfPensaoRecebida"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
