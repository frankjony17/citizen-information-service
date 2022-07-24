/**
 * VagasOrgao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class VagasOrgao  implements java.io.Serializable {
    private java.lang.String funcoesOrgao;

    private java.lang.String quantVagaFuncaoLivre;

    private java.lang.String quantVagaFuncaoOcupada;

    public VagasOrgao() {
    }

    public VagasOrgao(
           java.lang.String funcoesOrgao,
           java.lang.String quantVagaFuncaoLivre,
           java.lang.String quantVagaFuncaoOcupada) {
           this.funcoesOrgao = funcoesOrgao;
           this.quantVagaFuncaoLivre = quantVagaFuncaoLivre;
           this.quantVagaFuncaoOcupada = quantVagaFuncaoOcupada;
    }


    /**
     * Gets the funcoesOrgao value for this VagasOrgao.
     * 
     * @return funcoesOrgao
     */
    public java.lang.String getFuncoesOrgao() {
        return funcoesOrgao;
    }


    /**
     * Sets the funcoesOrgao value for this VagasOrgao.
     * 
     * @param funcoesOrgao
     */
    public void setFuncoesOrgao(java.lang.String funcoesOrgao) {
        this.funcoesOrgao = funcoesOrgao;
    }


    /**
     * Gets the quantVagaFuncaoLivre value for this VagasOrgao.
     * 
     * @return quantVagaFuncaoLivre
     */
    public java.lang.String getQuantVagaFuncaoLivre() {
        return quantVagaFuncaoLivre;
    }


    /**
     * Sets the quantVagaFuncaoLivre value for this VagasOrgao.
     * 
     * @param quantVagaFuncaoLivre
     */
    public void setQuantVagaFuncaoLivre(java.lang.String quantVagaFuncaoLivre) {
        this.quantVagaFuncaoLivre = quantVagaFuncaoLivre;
    }


    /**
     * Gets the quantVagaFuncaoOcupada value for this VagasOrgao.
     * 
     * @return quantVagaFuncaoOcupada
     */
    public java.lang.String getQuantVagaFuncaoOcupada() {
        return quantVagaFuncaoOcupada;
    }


    /**
     * Sets the quantVagaFuncaoOcupada value for this VagasOrgao.
     * 
     * @param quantVagaFuncaoOcupada
     */
    public void setQuantVagaFuncaoOcupada(java.lang.String quantVagaFuncaoOcupada) {
        this.quantVagaFuncaoOcupada = quantVagaFuncaoOcupada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VagasOrgao)) return false;
        VagasOrgao other = (VagasOrgao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.funcoesOrgao==null && other.getFuncoesOrgao()==null) || 
             (this.funcoesOrgao!=null &&
              this.funcoesOrgao.equals(other.getFuncoesOrgao()))) &&
            ((this.quantVagaFuncaoLivre==null && other.getQuantVagaFuncaoLivre()==null) || 
             (this.quantVagaFuncaoLivre!=null &&
              this.quantVagaFuncaoLivre.equals(other.getQuantVagaFuncaoLivre()))) &&
            ((this.quantVagaFuncaoOcupada==null && other.getQuantVagaFuncaoOcupada()==null) || 
             (this.quantVagaFuncaoOcupada!=null &&
              this.quantVagaFuncaoOcupada.equals(other.getQuantVagaFuncaoOcupada())));
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
        if (getFuncoesOrgao() != null) {
            _hashCode += getFuncoesOrgao().hashCode();
        }
        if (getQuantVagaFuncaoLivre() != null) {
            _hashCode += getQuantVagaFuncaoLivre().hashCode();
        }
        if (getQuantVagaFuncaoOcupada() != null) {
            _hashCode += getQuantVagaFuncaoOcupada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VagasOrgao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "VagasOrgao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("funcoesOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "funcoesOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantVagaFuncaoLivre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "quantVagaFuncaoLivre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantVagaFuncaoOcupada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "quantVagaFuncaoOcupada"));
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
