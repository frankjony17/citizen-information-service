/**
 * FormacaoAcademica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class FormacaoAcademica  implements java.io.Serializable {
    private java.lang.Integer codigo;

    private Curso curso;

    private java.lang.String dataConclusao;

    private java.lang.String identificUnica;

    private java.lang.String instituicao;

    private NivelEscolaridade nivelEscolaridade;

    private Situacao situacao;

    public FormacaoAcademica() {
    }

    public FormacaoAcademica(
           java.lang.Integer codigo,
           Curso curso,
           java.lang.String dataConclusao,
           java.lang.String identificUnica,
           java.lang.String instituicao,
           NivelEscolaridade nivelEscolaridade,
           Situacao situacao) {
           this.codigo = codigo;
           this.curso = curso;
           this.dataConclusao = dataConclusao;
           this.identificUnica = identificUnica;
           this.instituicao = instituicao;
           this.nivelEscolaridade = nivelEscolaridade;
           this.situacao = situacao;
    }


    /**
     * Gets the codigo value for this FormacaoAcademica.
     * 
     * @return codigo
     */
    public java.lang.Integer getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this FormacaoAcademica.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.Integer codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the curso value for this FormacaoAcademica.
     * 
     * @return curso
     */
    public Curso getCurso() {
        return curso;
    }


    /**
     * Sets the curso value for this FormacaoAcademica.
     * 
     * @param curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }


    /**
     * Gets the dataConclusao value for this FormacaoAcademica.
     * 
     * @return dataConclusao
     */
    public java.lang.String getDataConclusao() {
        return dataConclusao;
    }


    /**
     * Sets the dataConclusao value for this FormacaoAcademica.
     * 
     * @param dataConclusao
     */
    public void setDataConclusao(java.lang.String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }


    /**
     * Gets the identificUnica value for this FormacaoAcademica.
     * 
     * @return identificUnica
     */
    public java.lang.String getIdentificUnica() {
        return identificUnica;
    }


    /**
     * Sets the identificUnica value for this FormacaoAcademica.
     * 
     * @param identificUnica
     */
    public void setIdentificUnica(java.lang.String identificUnica) {
        this.identificUnica = identificUnica;
    }


    /**
     * Gets the instituicao value for this FormacaoAcademica.
     * 
     * @return instituicao
     */
    public java.lang.String getInstituicao() {
        return instituicao;
    }


    /**
     * Sets the instituicao value for this FormacaoAcademica.
     * 
     * @param instituicao
     */
    public void setInstituicao(java.lang.String instituicao) {
        this.instituicao = instituicao;
    }


    /**
     * Gets the nivelEscolaridade value for this FormacaoAcademica.
     * 
     * @return nivelEscolaridade
     */
    public NivelEscolaridade getNivelEscolaridade() {
        return nivelEscolaridade;
    }


    /**
     * Sets the nivelEscolaridade value for this FormacaoAcademica.
     * 
     * @param nivelEscolaridade
     */
    public void setNivelEscolaridade(NivelEscolaridade nivelEscolaridade) {
        this.nivelEscolaridade = nivelEscolaridade;
    }


    /**
     * Gets the situacao value for this FormacaoAcademica.
     * 
     * @return situacao
     */
    public Situacao getSituacao() {
        return situacao;
    }


    /**
     * Sets the situacao value for this FormacaoAcademica.
     * 
     * @param situacao
     */
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FormacaoAcademica)) return false;
        FormacaoAcademica other = (FormacaoAcademica) obj;
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
            ((this.curso==null && other.getCurso()==null) || 
             (this.curso!=null &&
              this.curso.equals(other.getCurso()))) &&
            ((this.dataConclusao==null && other.getDataConclusao()==null) || 
             (this.dataConclusao!=null &&
              this.dataConclusao.equals(other.getDataConclusao()))) &&
            ((this.identificUnica==null && other.getIdentificUnica()==null) || 
             (this.identificUnica!=null &&
              this.identificUnica.equals(other.getIdentificUnica()))) &&
            ((this.instituicao==null && other.getInstituicao()==null) || 
             (this.instituicao!=null &&
              this.instituicao.equals(other.getInstituicao()))) &&
            ((this.nivelEscolaridade==null && other.getNivelEscolaridade()==null) || 
             (this.nivelEscolaridade!=null &&
              this.nivelEscolaridade.equals(other.getNivelEscolaridade()))) &&
            ((this.situacao==null && other.getSituacao()==null) || 
             (this.situacao!=null &&
              this.situacao.equals(other.getSituacao())));
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
        if (getCurso() != null) {
            _hashCode += getCurso().hashCode();
        }
        if (getDataConclusao() != null) {
            _hashCode += getDataConclusao().hashCode();
        }
        if (getIdentificUnica() != null) {
            _hashCode += getIdentificUnica().hashCode();
        }
        if (getInstituicao() != null) {
            _hashCode += getInstituicao().hashCode();
        }
        if (getNivelEscolaridade() != null) {
            _hashCode += getNivelEscolaridade().hashCode();
        }
        if (getSituacao() != null) {
            _hashCode += getSituacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FormacaoAcademica.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "FormacaoAcademica"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "curso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Curso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataConclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "dataConclusao"));
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
        elemField.setFieldName("instituicao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "instituicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivelEscolaridade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "nivelEscolaridade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "NivelEscolaridade"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("situacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "situacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Situacao"));
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
