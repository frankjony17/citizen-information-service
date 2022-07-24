/**
 * ParticipacaoComissoes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ParticipacaoComissoes  implements java.io.Serializable {
    private java.lang.Integer codigo;

    private java.lang.String dataFim;

    private java.lang.String dataInicio;

    private java.lang.String identificUnica;

    private java.lang.String infoAdicionais;

    private java.lang.String tipoDesc;

    private TipoParticipacaoComissoes tipoParticipacaoComissoes;

    public ParticipacaoComissoes() {
    }

    public ParticipacaoComissoes(
           java.lang.Integer codigo,
           java.lang.String dataFim,
           java.lang.String dataInicio,
           java.lang.String identificUnica,
           java.lang.String infoAdicionais,
           java.lang.String tipoDesc,
           TipoParticipacaoComissoes tipoParticipacaoComissoes) {
           this.codigo = codigo;
           this.dataFim = dataFim;
           this.dataInicio = dataInicio;
           this.identificUnica = identificUnica;
           this.infoAdicionais = infoAdicionais;
           this.tipoDesc = tipoDesc;
           this.tipoParticipacaoComissoes = tipoParticipacaoComissoes;
    }


    /**
     * Gets the codigo value for this ParticipacaoComissoes.
     * 
     * @return codigo
     */
    public java.lang.Integer getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this ParticipacaoComissoes.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.Integer codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the dataFim value for this ParticipacaoComissoes.
     * 
     * @return dataFim
     */
    public java.lang.String getDataFim() {
        return dataFim;
    }


    /**
     * Sets the dataFim value for this ParticipacaoComissoes.
     * 
     * @param dataFim
     */
    public void setDataFim(java.lang.String dataFim) {
        this.dataFim = dataFim;
    }


    /**
     * Gets the dataInicio value for this ParticipacaoComissoes.
     * 
     * @return dataInicio
     */
    public java.lang.String getDataInicio() {
        return dataInicio;
    }


    /**
     * Sets the dataInicio value for this ParticipacaoComissoes.
     * 
     * @param dataInicio
     */
    public void setDataInicio(java.lang.String dataInicio) {
        this.dataInicio = dataInicio;
    }


    /**
     * Gets the identificUnica value for this ParticipacaoComissoes.
     * 
     * @return identificUnica
     */
    public java.lang.String getIdentificUnica() {
        return identificUnica;
    }


    /**
     * Sets the identificUnica value for this ParticipacaoComissoes.
     * 
     * @param identificUnica
     */
    public void setIdentificUnica(java.lang.String identificUnica) {
        this.identificUnica = identificUnica;
    }


    /**
     * Gets the infoAdicionais value for this ParticipacaoComissoes.
     * 
     * @return infoAdicionais
     */
    public java.lang.String getInfoAdicionais() {
        return infoAdicionais;
    }


    /**
     * Sets the infoAdicionais value for this ParticipacaoComissoes.
     * 
     * @param infoAdicionais
     */
    public void setInfoAdicionais(java.lang.String infoAdicionais) {
        this.infoAdicionais = infoAdicionais;
    }


    /**
     * Gets the tipoDesc value for this ParticipacaoComissoes.
     * 
     * @return tipoDesc
     */
    public java.lang.String getTipoDesc() {
        return tipoDesc;
    }


    /**
     * Sets the tipoDesc value for this ParticipacaoComissoes.
     * 
     * @param tipoDesc
     */
    public void setTipoDesc(java.lang.String tipoDesc) {
        this.tipoDesc = tipoDesc;
    }


    /**
     * Gets the tipoParticipacaoComissoes value for this ParticipacaoComissoes.
     * 
     * @return tipoParticipacaoComissoes
     */
    public TipoParticipacaoComissoes getTipoParticipacaoComissoes() {
        return tipoParticipacaoComissoes;
    }


    /**
     * Sets the tipoParticipacaoComissoes value for this ParticipacaoComissoes.
     * 
     * @param tipoParticipacaoComissoes
     */
    public void setTipoParticipacaoComissoes(TipoParticipacaoComissoes tipoParticipacaoComissoes) {
        this.tipoParticipacaoComissoes = tipoParticipacaoComissoes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParticipacaoComissoes)) return false;
        ParticipacaoComissoes other = (ParticipacaoComissoes) obj;
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
            ((this.dataFim==null && other.getDataFim()==null) || 
             (this.dataFim!=null &&
              this.dataFim.equals(other.getDataFim()))) &&
            ((this.dataInicio==null && other.getDataInicio()==null) || 
             (this.dataInicio!=null &&
              this.dataInicio.equals(other.getDataInicio()))) &&
            ((this.identificUnica==null && other.getIdentificUnica()==null) || 
             (this.identificUnica!=null &&
              this.identificUnica.equals(other.getIdentificUnica()))) &&
            ((this.infoAdicionais==null && other.getInfoAdicionais()==null) || 
             (this.infoAdicionais!=null &&
              this.infoAdicionais.equals(other.getInfoAdicionais()))) &&
            ((this.tipoDesc==null && other.getTipoDesc()==null) || 
             (this.tipoDesc!=null &&
              this.tipoDesc.equals(other.getTipoDesc()))) &&
            ((this.tipoParticipacaoComissoes==null && other.getTipoParticipacaoComissoes()==null) || 
             (this.tipoParticipacaoComissoes!=null &&
              this.tipoParticipacaoComissoes.equals(other.getTipoParticipacaoComissoes())));
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
        if (getDataFim() != null) {
            _hashCode += getDataFim().hashCode();
        }
        if (getDataInicio() != null) {
            _hashCode += getDataInicio().hashCode();
        }
        if (getIdentificUnica() != null) {
            _hashCode += getIdentificUnica().hashCode();
        }
        if (getInfoAdicionais() != null) {
            _hashCode += getInfoAdicionais().hashCode();
        }
        if (getTipoDesc() != null) {
            _hashCode += getTipoDesc().hashCode();
        }
        if (getTipoParticipacaoComissoes() != null) {
            _hashCode += getTipoParticipacaoComissoes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParticipacaoComissoes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ParticipacaoComissoes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFim");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "dataFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "dataInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("infoAdicionais");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "infoAdicionais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "tipoDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoParticipacaoComissoes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "tipoParticipacaoComissoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "TipoParticipacaoComissoes"));
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
