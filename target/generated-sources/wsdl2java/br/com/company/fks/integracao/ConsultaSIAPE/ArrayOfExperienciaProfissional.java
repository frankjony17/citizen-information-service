/**
 * ArrayOfExperienciaProfissional.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfExperienciaProfissional  implements java.io.Serializable {
    private ExperienciaProfissional[] experienciaProfissional;

    public ArrayOfExperienciaProfissional() {
    }

    public ArrayOfExperienciaProfissional(
           ExperienciaProfissional[] experienciaProfissional) {
           this.experienciaProfissional = experienciaProfissional;
    }


    /**
     * Gets the experienciaProfissional value for this ArrayOfExperienciaProfissional.
     * 
     * @return experienciaProfissional
     */
    public ExperienciaProfissional[] getExperienciaProfissional() {
        return experienciaProfissional;
    }


    /**
     * Sets the experienciaProfissional value for this ArrayOfExperienciaProfissional.
     * 
     * @param experienciaProfissional
     */
    public void setExperienciaProfissional(ExperienciaProfissional[] experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

    public ExperienciaProfissional getExperienciaProfissional(int i) {
        return this.experienciaProfissional[i];
    }

    public void setExperienciaProfissional(int i, ExperienciaProfissional _value) {
        this.experienciaProfissional[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfExperienciaProfissional)) return false;
        ArrayOfExperienciaProfissional other = (ArrayOfExperienciaProfissional) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.experienciaProfissional==null && other.getExperienciaProfissional()==null) || 
             (this.experienciaProfissional!=null &&
              java.util.Arrays.equals(this.experienciaProfissional, other.getExperienciaProfissional())));
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
        if (getExperienciaProfissional() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExperienciaProfissional());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExperienciaProfissional(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfExperienciaProfissional.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfExperienciaProfissional"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("experienciaProfissional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ExperienciaProfissional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ExperienciaProfissional"));
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
