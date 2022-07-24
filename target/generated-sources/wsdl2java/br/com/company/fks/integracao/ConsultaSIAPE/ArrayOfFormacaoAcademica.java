/**
 * ArrayOfFormacaoAcademica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfFormacaoAcademica  implements java.io.Serializable {
    private FormacaoAcademica[] formacaoAcademica;

    public ArrayOfFormacaoAcademica() {
    }

    public ArrayOfFormacaoAcademica(
           FormacaoAcademica[] formacaoAcademica) {
           this.formacaoAcademica = formacaoAcademica;
    }


    /**
     * Gets the formacaoAcademica value for this ArrayOfFormacaoAcademica.
     * 
     * @return formacaoAcademica
     */
    public FormacaoAcademica[] getFormacaoAcademica() {
        return formacaoAcademica;
    }


    /**
     * Sets the formacaoAcademica value for this ArrayOfFormacaoAcademica.
     * 
     * @param formacaoAcademica
     */
    public void setFormacaoAcademica(FormacaoAcademica[] formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public FormacaoAcademica getFormacaoAcademica(int i) {
        return this.formacaoAcademica[i];
    }

    public void setFormacaoAcademica(int i, FormacaoAcademica _value) {
        this.formacaoAcademica[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfFormacaoAcademica)) return false;
        ArrayOfFormacaoAcademica other = (ArrayOfFormacaoAcademica) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.formacaoAcademica==null && other.getFormacaoAcademica()==null) || 
             (this.formacaoAcademica!=null &&
              java.util.Arrays.equals(this.formacaoAcademica, other.getFormacaoAcademica())));
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
        if (getFormacaoAcademica() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFormacaoAcademica());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFormacaoAcademica(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfFormacaoAcademica.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfFormacaoAcademica"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formacaoAcademica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "FormacaoAcademica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "FormacaoAcademica"));
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
