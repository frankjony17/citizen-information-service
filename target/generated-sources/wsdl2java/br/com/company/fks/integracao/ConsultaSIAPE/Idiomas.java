/**
 * Idiomas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class Idiomas  implements java.io.Serializable {
    private java.lang.Integer codigo;

    private java.lang.String identificUnica;

    private IdiomasDesc idiomasDesc;

    private IdiomasDominio idiomasEscreve;

    private IdiomasDominio idiomasFala;

    private IdiomasDominio idiomasLe;

    public Idiomas() {
    }

    public Idiomas(
           java.lang.Integer codigo,
           java.lang.String identificUnica,
           IdiomasDesc idiomasDesc,
           IdiomasDominio idiomasEscreve,
           IdiomasDominio idiomasFala,
           IdiomasDominio idiomasLe) {
           this.codigo = codigo;
           this.identificUnica = identificUnica;
           this.idiomasDesc = idiomasDesc;
           this.idiomasEscreve = idiomasEscreve;
           this.idiomasFala = idiomasFala;
           this.idiomasLe = idiomasLe;
    }


    /**
     * Gets the codigo value for this Idiomas.
     * 
     * @return codigo
     */
    public java.lang.Integer getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this Idiomas.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.Integer codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the identificUnica value for this Idiomas.
     * 
     * @return identificUnica
     */
    public java.lang.String getIdentificUnica() {
        return identificUnica;
    }


    /**
     * Sets the identificUnica value for this Idiomas.
     * 
     * @param identificUnica
     */
    public void setIdentificUnica(java.lang.String identificUnica) {
        this.identificUnica = identificUnica;
    }


    /**
     * Gets the idiomasDesc value for this Idiomas.
     * 
     * @return idiomasDesc
     */
    public IdiomasDesc getIdiomasDesc() {
        return idiomasDesc;
    }


    /**
     * Sets the idiomasDesc value for this Idiomas.
     * 
     * @param idiomasDesc
     */
    public void setIdiomasDesc(IdiomasDesc idiomasDesc) {
        this.idiomasDesc = idiomasDesc;
    }


    /**
     * Gets the idiomasEscreve value for this Idiomas.
     * 
     * @return idiomasEscreve
     */
    public IdiomasDominio getIdiomasEscreve() {
        return idiomasEscreve;
    }


    /**
     * Sets the idiomasEscreve value for this Idiomas.
     * 
     * @param idiomasEscreve
     */
    public void setIdiomasEscreve(IdiomasDominio idiomasEscreve) {
        this.idiomasEscreve = idiomasEscreve;
    }


    /**
     * Gets the idiomasFala value for this Idiomas.
     * 
     * @return idiomasFala
     */
    public IdiomasDominio getIdiomasFala() {
        return idiomasFala;
    }


    /**
     * Sets the idiomasFala value for this Idiomas.
     * 
     * @param idiomasFala
     */
    public void setIdiomasFala(IdiomasDominio idiomasFala) {
        this.idiomasFala = idiomasFala;
    }


    /**
     * Gets the idiomasLe value for this Idiomas.
     * 
     * @return idiomasLe
     */
    public IdiomasDominio getIdiomasLe() {
        return idiomasLe;
    }


    /**
     * Sets the idiomasLe value for this Idiomas.
     * 
     * @param idiomasLe
     */
    public void setIdiomasLe(IdiomasDominio idiomasLe) {
        this.idiomasLe = idiomasLe;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Idiomas)) return false;
        Idiomas other = (Idiomas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.identificUnica==null && other.getIdentificUnica()==null) || 
             (this.identificUnica!=null &&
              this.identificUnica.equals(other.getIdentificUnica()))) &&
            ((this.idiomasDesc==null && other.getIdiomasDesc()==null) || 
             (this.idiomasDesc!=null &&
              this.idiomasDesc.equals(other.getIdiomasDesc()))) &&
            ((this.idiomasEscreve==null && other.getIdiomasEscreve()==null) || 
             (this.idiomasEscreve!=null &&
              this.idiomasEscreve.equals(other.getIdiomasEscreve()))) &&
            ((this.idiomasFala==null && other.getIdiomasFala()==null) || 
             (this.idiomasFala!=null &&
              this.idiomasFala.equals(other.getIdiomasFala()))) &&
            ((this.idiomasLe==null && other.getIdiomasLe()==null) || 
             (this.idiomasLe!=null &&
              this.idiomasLe.equals(other.getIdiomasLe())));
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
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getIdentificUnica() != null) {
            _hashCode += getIdentificUnica().hashCode();
        }
        if (getIdiomasDesc() != null) {
            _hashCode += getIdiomasDesc().hashCode();
        }
        if (getIdiomasEscreve() != null) {
            _hashCode += getIdiomasEscreve().hashCode();
        }
        if (getIdiomasFala() != null) {
            _hashCode += getIdiomasFala().hashCode();
        }
        if (getIdiomasLe() != null) {
            _hashCode += getIdiomasLe().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Idiomas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Idiomas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificUnica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "identificUnica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomasDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "idiomasDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "IdiomasDesc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomasEscreve");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "idiomasEscreve"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "IdiomasDominio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomasFala");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "idiomasFala"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "IdiomasDominio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomasLe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "idiomasLe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "IdiomasDominio"));
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
