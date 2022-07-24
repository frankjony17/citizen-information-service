/**
 * ArrayOfServidor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfServidor  implements java.io.Serializable {
    private Servidor[] servidor;

    public ArrayOfServidor() {
    }

    public ArrayOfServidor(
           Servidor[] servidor) {
           this.servidor = servidor;
    }


    /**
     * Gets the servidor value for this ArrayOfServidor.
     * 
     * @return servidor
     */
    public Servidor[] getServidor() {
        return servidor;
    }


    /**
     * Sets the servidor value for this ArrayOfServidor.
     * 
     * @param servidor
     */
    public void setServidor(Servidor[] servidor) {
        this.servidor = servidor;
    }

    public Servidor getServidor(int i) {
        return this.servidor[i];
    }

    public void setServidor(int i, Servidor _value) {
        this.servidor[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfServidor)) return false;
        ArrayOfServidor other = (ArrayOfServidor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.servidor==null && other.getServidor()==null) || 
             (this.servidor!=null &&
              java.util.Arrays.equals(this.servidor, other.getServidor())));
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
        if (getServidor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServidor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServidor(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfServidor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfServidor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("servidor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Servidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Servidor"));
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
