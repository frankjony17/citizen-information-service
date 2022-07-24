/**
 * AlimentadosPA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class AlimentadosPA  implements java.io.Serializable {
    private java.lang.String codVinculoServidor;

    private java.lang.String nomeAlimentado;

    private java.lang.String nomeVinculoServidor;

    public AlimentadosPA() {
    }

    public AlimentadosPA(
           java.lang.String codVinculoServidor,
           java.lang.String nomeAlimentado,
           java.lang.String nomeVinculoServidor) {
           this.codVinculoServidor = codVinculoServidor;
           this.nomeAlimentado = nomeAlimentado;
           this.nomeVinculoServidor = nomeVinculoServidor;
    }


    /**
     * Gets the codVinculoServidor value for this AlimentadosPA.
     * 
     * @return codVinculoServidor
     */
    public java.lang.String getCodVinculoServidor() {
        return codVinculoServidor;
    }


    /**
     * Sets the codVinculoServidor value for this AlimentadosPA.
     * 
     * @param codVinculoServidor
     */
    public void setCodVinculoServidor(java.lang.String codVinculoServidor) {
        this.codVinculoServidor = codVinculoServidor;
    }


    /**
     * Gets the nomeAlimentado value for this AlimentadosPA.
     * 
     * @return nomeAlimentado
     */
    public java.lang.String getNomeAlimentado() {
        return nomeAlimentado;
    }


    /**
     * Sets the nomeAlimentado value for this AlimentadosPA.
     * 
     * @param nomeAlimentado
     */
    public void setNomeAlimentado(java.lang.String nomeAlimentado) {
        this.nomeAlimentado = nomeAlimentado;
    }


    /**
     * Gets the nomeVinculoServidor value for this AlimentadosPA.
     * 
     * @return nomeVinculoServidor
     */
    public java.lang.String getNomeVinculoServidor() {
        return nomeVinculoServidor;
    }


    /**
     * Sets the nomeVinculoServidor value for this AlimentadosPA.
     * 
     * @param nomeVinculoServidor
     */
    public void setNomeVinculoServidor(java.lang.String nomeVinculoServidor) {
        this.nomeVinculoServidor = nomeVinculoServidor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlimentadosPA)) return false;
        AlimentadosPA other = (AlimentadosPA) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codVinculoServidor==null && other.getCodVinculoServidor()==null) || 
             (this.codVinculoServidor!=null &&
              this.codVinculoServidor.equals(other.getCodVinculoServidor()))) &&
            ((this.nomeAlimentado==null && other.getNomeAlimentado()==null) || 
             (this.nomeAlimentado!=null &&
              this.nomeAlimentado.equals(other.getNomeAlimentado()))) &&
            ((this.nomeVinculoServidor==null && other.getNomeVinculoServidor()==null) || 
             (this.nomeVinculoServidor!=null &&
              this.nomeVinculoServidor.equals(other.getNomeVinculoServidor())));
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
        if (getCodVinculoServidor() != null) {
            _hashCode += getCodVinculoServidor().hashCode();
        }
        if (getNomeAlimentado() != null) {
            _hashCode += getNomeAlimentado().hashCode();
        }
        if (getNomeVinculoServidor() != null) {
            _hashCode += getNomeVinculoServidor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlimentadosPA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "AlimentadosPA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codVinculoServidor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codVinculoServidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeAlimentado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeAlimentado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeVinculoServidor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeVinculoServidor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
