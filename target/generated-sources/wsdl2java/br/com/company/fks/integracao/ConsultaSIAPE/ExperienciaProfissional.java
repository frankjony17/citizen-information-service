/**
 * ExperienciaProfissional.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ExperienciaProfissional  implements java.io.Serializable {
    private Area area;

    private java.lang.String cargo;

    private java.lang.Integer codigo;

    private java.lang.String dataFim;

    private java.lang.String dataInicio;

    private java.lang.String identificUnica;

    private java.lang.String nomeOrgaoEmpresa;

    private java.lang.String projeto;

    private TipoAtuacao tipoAtuacao;

    public ExperienciaProfissional() {
    }

    public ExperienciaProfissional(
           Area area,
           java.lang.String cargo,
           java.lang.Integer codigo,
           java.lang.String dataFim,
           java.lang.String dataInicio,
           java.lang.String identificUnica,
           java.lang.String nomeOrgaoEmpresa,
           java.lang.String projeto,
           TipoAtuacao tipoAtuacao) {
           this.area = area;
           this.cargo = cargo;
           this.codigo = codigo;
           this.dataFim = dataFim;
           this.dataInicio = dataInicio;
           this.identificUnica = identificUnica;
           this.nomeOrgaoEmpresa = nomeOrgaoEmpresa;
           this.projeto = projeto;
           this.tipoAtuacao = tipoAtuacao;
    }


    /**
     * Gets the area value for this ExperienciaProfissional.
     * 
     * @return area
     */
    public Area getArea() {
        return area;
    }


    /**
     * Sets the area value for this ExperienciaProfissional.
     * 
     * @param area
     */
    public void setArea(Area area) {
        this.area = area;
    }


    /**
     * Gets the cargo value for this ExperienciaProfissional.
     * 
     * @return cargo
     */
    public java.lang.String getCargo() {
        return cargo;
    }


    /**
     * Sets the cargo value for this ExperienciaProfissional.
     * 
     * @param cargo
     */
    public void setCargo(java.lang.String cargo) {
        this.cargo = cargo;
    }


    /**
     * Gets the codigo value for this ExperienciaProfissional.
     * 
     * @return codigo
     */
    public java.lang.Integer getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this ExperienciaProfissional.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.Integer codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the dataFim value for this ExperienciaProfissional.
     * 
     * @return dataFim
     */
    public java.lang.String getDataFim() {
        return dataFim;
    }


    /**
     * Sets the dataFim value for this ExperienciaProfissional.
     * 
     * @param dataFim
     */
    public void setDataFim(java.lang.String dataFim) {
        this.dataFim = dataFim;
    }


    /**
     * Gets the dataInicio value for this ExperienciaProfissional.
     * 
     * @return dataInicio
     */
    public java.lang.String getDataInicio() {
        return dataInicio;
    }


    /**
     * Sets the dataInicio value for this ExperienciaProfissional.
     * 
     * @param dataInicio
     */
    public void setDataInicio(java.lang.String dataInicio) {
        this.dataInicio = dataInicio;
    }


    /**
     * Gets the identificUnica value for this ExperienciaProfissional.
     * 
     * @return identificUnica
     */
    public java.lang.String getIdentificUnica() {
        return identificUnica;
    }


    /**
     * Sets the identificUnica value for this ExperienciaProfissional.
     * 
     * @param identificUnica
     */
    public void setIdentificUnica(java.lang.String identificUnica) {
        this.identificUnica = identificUnica;
    }


    /**
     * Gets the nomeOrgaoEmpresa value for this ExperienciaProfissional.
     * 
     * @return nomeOrgaoEmpresa
     */
    public java.lang.String getNomeOrgaoEmpresa() {
        return nomeOrgaoEmpresa;
    }


    /**
     * Sets the nomeOrgaoEmpresa value for this ExperienciaProfissional.
     * 
     * @param nomeOrgaoEmpresa
     */
    public void setNomeOrgaoEmpresa(java.lang.String nomeOrgaoEmpresa) {
        this.nomeOrgaoEmpresa = nomeOrgaoEmpresa;
    }


    /**
     * Gets the projeto value for this ExperienciaProfissional.
     * 
     * @return projeto
     */
    public java.lang.String getProjeto() {
        return projeto;
    }


    /**
     * Sets the projeto value for this ExperienciaProfissional.
     * 
     * @param projeto
     */
    public void setProjeto(java.lang.String projeto) {
        this.projeto = projeto;
    }


    /**
     * Gets the tipoAtuacao value for this ExperienciaProfissional.
     * 
     * @return tipoAtuacao
     */
    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }


    /**
     * Sets the tipoAtuacao value for this ExperienciaProfissional.
     * 
     * @param tipoAtuacao
     */
    public void setTipoAtuacao(TipoAtuacao tipoAtuacao) {
        this.tipoAtuacao = tipoAtuacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExperienciaProfissional)) return false;
        ExperienciaProfissional other = (ExperienciaProfissional) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.cargo==null && other.getCargo()==null) || 
             (this.cargo!=null &&
              this.cargo.equals(other.getCargo()))) &&
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
            ((this.nomeOrgaoEmpresa==null && other.getNomeOrgaoEmpresa()==null) || 
             (this.nomeOrgaoEmpresa!=null &&
              this.nomeOrgaoEmpresa.equals(other.getNomeOrgaoEmpresa()))) &&
            ((this.projeto==null && other.getProjeto()==null) || 
             (this.projeto!=null &&
              this.projeto.equals(other.getProjeto()))) &&
            ((this.tipoAtuacao==null && other.getTipoAtuacao()==null) || 
             (this.tipoAtuacao!=null &&
              this.tipoAtuacao.equals(other.getTipoAtuacao())));
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
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getCargo() != null) {
            _hashCode += getCargo().hashCode();
        }
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
        if (getNomeOrgaoEmpresa() != null) {
            _hashCode += getNomeOrgaoEmpresa().hashCode();
        }
        if (getProjeto() != null) {
            _hashCode += getProjeto().hashCode();
        }
        if (getTipoAtuacao() != null) {
            _hashCode += getTipoAtuacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExperienciaProfissional.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ExperienciaProfissional"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Area"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "cargo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("nomeOrgaoEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "nomeOrgaoEmpresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projeto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "projeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAtuacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "tipoAtuacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "TipoAtuacao"));
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
