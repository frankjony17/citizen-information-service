/**
 * DadosCurriculo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosCurriculo  implements java.io.Serializable {
    private java.lang.String cpf;

    private java.lang.Integer identificUnica;

    private ArrayOfCurso listaCurso;

    private ArrayOfExperienciaProfissional listaExperienciaProfissional;

    private ArrayOfFormacaoAcademica listaFormacaoAcademica;

    private ArrayOfIdiomas listaIdiomas;

    private ArrayOfParticipacaoComissoes listaParticipacaoComissoes;

    public DadosCurriculo() {
    }

    public DadosCurriculo(
           java.lang.String cpf,
           java.lang.Integer identificUnica,
           ArrayOfCurso listaCurso,
           ArrayOfExperienciaProfissional listaExperienciaProfissional,
           ArrayOfFormacaoAcademica listaFormacaoAcademica,
           ArrayOfIdiomas listaIdiomas,
           ArrayOfParticipacaoComissoes listaParticipacaoComissoes) {
           this.cpf = cpf;
           this.identificUnica = identificUnica;
           this.listaCurso = listaCurso;
           this.listaExperienciaProfissional = listaExperienciaProfissional;
           this.listaFormacaoAcademica = listaFormacaoAcademica;
           this.listaIdiomas = listaIdiomas;
           this.listaParticipacaoComissoes = listaParticipacaoComissoes;
    }


    /**
     * Gets the cpf value for this DadosCurriculo.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this DadosCurriculo.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the identificUnica value for this DadosCurriculo.
     * 
     * @return identificUnica
     */
    public java.lang.Integer getIdentificUnica() {
        return identificUnica;
    }


    /**
     * Sets the identificUnica value for this DadosCurriculo.
     * 
     * @param identificUnica
     */
    public void setIdentificUnica(java.lang.Integer identificUnica) {
        this.identificUnica = identificUnica;
    }


    /**
     * Gets the listaCurso value for this DadosCurriculo.
     * 
     * @return listaCurso
     */
    public ArrayOfCurso getListaCurso() {
        return listaCurso;
    }


    /**
     * Sets the listaCurso value for this DadosCurriculo.
     * 
     * @param listaCurso
     */
    public void setListaCurso(ArrayOfCurso listaCurso) {
        this.listaCurso = listaCurso;
    }


    /**
     * Gets the listaExperienciaProfissional value for this DadosCurriculo.
     * 
     * @return listaExperienciaProfissional
     */
    public ArrayOfExperienciaProfissional getListaExperienciaProfissional() {
        return listaExperienciaProfissional;
    }


    /**
     * Sets the listaExperienciaProfissional value for this DadosCurriculo.
     * 
     * @param listaExperienciaProfissional
     */
    public void setListaExperienciaProfissional(ArrayOfExperienciaProfissional listaExperienciaProfissional) {
        this.listaExperienciaProfissional = listaExperienciaProfissional;
    }


    /**
     * Gets the listaFormacaoAcademica value for this DadosCurriculo.
     * 
     * @return listaFormacaoAcademica
     */
    public ArrayOfFormacaoAcademica getListaFormacaoAcademica() {
        return listaFormacaoAcademica;
    }


    /**
     * Sets the listaFormacaoAcademica value for this DadosCurriculo.
     * 
     * @param listaFormacaoAcademica
     */
    public void setListaFormacaoAcademica(ArrayOfFormacaoAcademica listaFormacaoAcademica) {
        this.listaFormacaoAcademica = listaFormacaoAcademica;
    }


    /**
     * Gets the listaIdiomas value for this DadosCurriculo.
     * 
     * @return listaIdiomas
     */
    public ArrayOfIdiomas getListaIdiomas() {
        return listaIdiomas;
    }


    /**
     * Sets the listaIdiomas value for this DadosCurriculo.
     * 
     * @param listaIdiomas
     */
    public void setListaIdiomas(ArrayOfIdiomas listaIdiomas) {
        this.listaIdiomas = listaIdiomas;
    }


    /**
     * Gets the listaParticipacaoComissoes value for this DadosCurriculo.
     * 
     * @return listaParticipacaoComissoes
     */
    public ArrayOfParticipacaoComissoes getListaParticipacaoComissoes() {
        return listaParticipacaoComissoes;
    }


    /**
     * Sets the listaParticipacaoComissoes value for this DadosCurriculo.
     * 
     * @param listaParticipacaoComissoes
     */
    public void setListaParticipacaoComissoes(ArrayOfParticipacaoComissoes listaParticipacaoComissoes) {
        this.listaParticipacaoComissoes = listaParticipacaoComissoes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosCurriculo)) return false;
        DadosCurriculo other = (DadosCurriculo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cpf==null && other.getCpf()==null) || 
             (this.cpf!=null &&
              this.cpf.equals(other.getCpf()))) &&
            ((this.identificUnica==null && other.getIdentificUnica()==null) || 
             (this.identificUnica!=null &&
              this.identificUnica.equals(other.getIdentificUnica()))) &&
            ((this.listaCurso==null && other.getListaCurso()==null) || 
             (this.listaCurso!=null &&
              this.listaCurso.equals(other.getListaCurso()))) &&
            ((this.listaExperienciaProfissional==null && other.getListaExperienciaProfissional()==null) || 
             (this.listaExperienciaProfissional!=null &&
              this.listaExperienciaProfissional.equals(other.getListaExperienciaProfissional()))) &&
            ((this.listaFormacaoAcademica==null && other.getListaFormacaoAcademica()==null) || 
             (this.listaFormacaoAcademica!=null &&
              this.listaFormacaoAcademica.equals(other.getListaFormacaoAcademica()))) &&
            ((this.listaIdiomas==null && other.getListaIdiomas()==null) || 
             (this.listaIdiomas!=null &&
              this.listaIdiomas.equals(other.getListaIdiomas()))) &&
            ((this.listaParticipacaoComissoes==null && other.getListaParticipacaoComissoes()==null) || 
             (this.listaParticipacaoComissoes!=null &&
              this.listaParticipacaoComissoes.equals(other.getListaParticipacaoComissoes())));
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
        if (getCpf() != null) {
            _hashCode += getCpf().hashCode();
        }
        if (getIdentificUnica() != null) {
            _hashCode += getIdentificUnica().hashCode();
        }
        if (getListaCurso() != null) {
            _hashCode += getListaCurso().hashCode();
        }
        if (getListaExperienciaProfissional() != null) {
            _hashCode += getListaExperienciaProfissional().hashCode();
        }
        if (getListaFormacaoAcademica() != null) {
            _hashCode += getListaFormacaoAcademica().hashCode();
        }
        if (getListaIdiomas() != null) {
            _hashCode += getListaIdiomas().hashCode();
        }
        if (getListaParticipacaoComissoes() != null) {
            _hashCode += getListaParticipacaoComissoes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosCurriculo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "DadosCurriculo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "cpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificUnica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "identificUnica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaCurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "listaCurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfCurso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaExperienciaProfissional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "listaExperienciaProfissional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfExperienciaProfissional"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaFormacaoAcademica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "listaFormacaoAcademica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfFormacaoAcademica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaIdiomas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "listaIdiomas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfIdiomas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaParticipacaoComissoes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "listaParticipacaoComissoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "ArrayOfParticipacaoComissoes"));
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
