/**
 * ArrayOfPensoesInstituidas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfPensoesInstituidas  implements java.io.Serializable {
    private PensoesInstituidas[] pensoesInstituidas;

    public ArrayOfPensoesInstituidas() {
    }

    public ArrayOfPensoesInstituidas(
           PensoesInstituidas[] pensoesInstituidas) {
           this.pensoesInstituidas = pensoesInstituidas;
    }


    /**
     * Gets the pensoesInstituidas value for this ArrayOfPensoesInstituidas.
     * 
     * @return pensoesInstituidas
     */
    public PensoesInstituidas[] getPensoesInstituidas() {
        return pensoesInstituidas;
    }


    /**
     * Sets the pensoesInstituidas value for this ArrayOfPensoesInstituidas.
     * 
     * @param pensoesInstituidas
     */
    public void setPensoesInstituidas(PensoesInstituidas[] pensoesInstituidas) {
        this.pensoesInstituidas = pensoesInstituidas;
    }

    public PensoesInstituidas getPensoesInstituidas(int i) {
        return this.pensoesInstituidas[i];
    }

    public void setPensoesInstituidas(int i, PensoesInstituidas _value) {
        this.pensoesInstituidas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfPensoesInstituidas)) return false;
        ArrayOfPensoesInstituidas other = (ArrayOfPensoesInstituidas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pensoesInstituidas==null && other.getPensoesInstituidas()==null) || 
             (this.pensoesInstituidas!=null &&
              java.util.Arrays.equals(this.pensoesInstituidas, other.getPensoesInstituidas())));
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
        if (getPensoesInstituidas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPensoesInstituidas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPensoesInstituidas(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfPensoesInstituidas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfPensoesInstituidas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pensoesInstituidas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "PensoesInstituidas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "PensoesInstituidas"));
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
