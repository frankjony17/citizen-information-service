/**
 * ArrayOfFichaFinaceiraBeneficiario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ArrayOfFichaFinaceiraBeneficiario  implements java.io.Serializable {
    private FichaFinaceiraBeneficiario[] fichaFinaceiraBeneficiario;

    public ArrayOfFichaFinaceiraBeneficiario() {
    }

    public ArrayOfFichaFinaceiraBeneficiario(
           FichaFinaceiraBeneficiario[] fichaFinaceiraBeneficiario) {
           this.fichaFinaceiraBeneficiario = fichaFinaceiraBeneficiario;
    }


    /**
     * Gets the fichaFinaceiraBeneficiario value for this ArrayOfFichaFinaceiraBeneficiario.
     * 
     * @return fichaFinaceiraBeneficiario
     */
    public FichaFinaceiraBeneficiario[] getFichaFinaceiraBeneficiario() {
        return fichaFinaceiraBeneficiario;
    }


    /**
     * Sets the fichaFinaceiraBeneficiario value for this ArrayOfFichaFinaceiraBeneficiario.
     * 
     * @param fichaFinaceiraBeneficiario
     */
    public void setFichaFinaceiraBeneficiario(FichaFinaceiraBeneficiario[] fichaFinaceiraBeneficiario) {
        this.fichaFinaceiraBeneficiario = fichaFinaceiraBeneficiario;
    }

    public FichaFinaceiraBeneficiario getFichaFinaceiraBeneficiario(int i) {
        return this.fichaFinaceiraBeneficiario[i];
    }

    public void setFichaFinaceiraBeneficiario(int i, FichaFinaceiraBeneficiario _value) {
        this.fichaFinaceiraBeneficiario[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfFichaFinaceiraBeneficiario)) return false;
        ArrayOfFichaFinaceiraBeneficiario other = (ArrayOfFichaFinaceiraBeneficiario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fichaFinaceiraBeneficiario==null && other.getFichaFinaceiraBeneficiario()==null) || 
             (this.fichaFinaceiraBeneficiario!=null &&
              java.util.Arrays.equals(this.fichaFinaceiraBeneficiario, other.getFichaFinaceiraBeneficiario())));
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
        if (getFichaFinaceiraBeneficiario() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFichaFinaceiraBeneficiario());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFichaFinaceiraBeneficiario(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfFichaFinaceiraBeneficiario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfFichaFinaceiraBeneficiario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fichaFinaceiraBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "FichaFinaceiraBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "FichaFinaceiraBeneficiario"));
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
