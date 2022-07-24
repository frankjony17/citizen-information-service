/**
 * DadosDependentes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosDependentes  implements java.io.Serializable {
    private ArrayOfBeneficio arrayBeneficios;

    private java.lang.String codCondicao;

    private java.lang.String codGrauParentesco;

    private java.lang.String codOrgao;

    private java.lang.String cpf;

    private java.lang.String matricula;

    private java.lang.String nome;

    private java.lang.String nomeCondicao;

    private java.lang.String nomeGrauParentesco;

    public DadosDependentes() {
    }

    public DadosDependentes(
           ArrayOfBeneficio arrayBeneficios,
           java.lang.String codCondicao,
           java.lang.String codGrauParentesco,
           java.lang.String codOrgao,
           java.lang.String cpf,
           java.lang.String matricula,
           java.lang.String nome,
           java.lang.String nomeCondicao,
           java.lang.String nomeGrauParentesco) {
           this.arrayBeneficios = arrayBeneficios;
           this.codCondicao = codCondicao;
           this.codGrauParentesco = codGrauParentesco;
           this.codOrgao = codOrgao;
           this.cpf = cpf;
           this.matricula = matricula;
           this.nome = nome;
           this.nomeCondicao = nomeCondicao;
           this.nomeGrauParentesco = nomeGrauParentesco;
    }


    /**
     * Gets the arrayBeneficios value for this DadosDependentes.
     * 
     * @return arrayBeneficios
     */
    public ArrayOfBeneficio getArrayBeneficios() {
        return arrayBeneficios;
    }


    /**
     * Sets the arrayBeneficios value for this DadosDependentes.
     * 
     * @param arrayBeneficios
     */
    public void setArrayBeneficios(ArrayOfBeneficio arrayBeneficios) {
        this.arrayBeneficios = arrayBeneficios;
    }


    /**
     * Gets the codCondicao value for this DadosDependentes.
     * 
     * @return codCondicao
     */
    public java.lang.String getCodCondicao() {
        return codCondicao;
    }


    /**
     * Sets the codCondicao value for this DadosDependentes.
     * 
     * @param codCondicao
     */
    public void setCodCondicao(java.lang.String codCondicao) {
        this.codCondicao = codCondicao;
    }


    /**
     * Gets the codGrauParentesco value for this DadosDependentes.
     * 
     * @return codGrauParentesco
     */
    public java.lang.String getCodGrauParentesco() {
        return codGrauParentesco;
    }


    /**
     * Sets the codGrauParentesco value for this DadosDependentes.
     * 
     * @param codGrauParentesco
     */
    public void setCodGrauParentesco(java.lang.String codGrauParentesco) {
        this.codGrauParentesco = codGrauParentesco;
    }


    /**
     * Gets the codOrgao value for this DadosDependentes.
     * 
     * @return codOrgao
     */
    public java.lang.String getCodOrgao() {
        return codOrgao;
    }


    /**
     * Sets the codOrgao value for this DadosDependentes.
     * 
     * @param codOrgao
     */
    public void setCodOrgao(java.lang.String codOrgao) {
        this.codOrgao = codOrgao;
    }


    /**
     * Gets the cpf value for this DadosDependentes.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this DadosDependentes.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the matricula value for this DadosDependentes.
     * 
     * @return matricula
     */
    public java.lang.String getMatricula() {
        return matricula;
    }


    /**
     * Sets the matricula value for this DadosDependentes.
     * 
     * @param matricula
     */
    public void setMatricula(java.lang.String matricula) {
        this.matricula = matricula;
    }


    /**
     * Gets the nome value for this DadosDependentes.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this DadosDependentes.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the nomeCondicao value for this DadosDependentes.
     * 
     * @return nomeCondicao
     */
    public java.lang.String getNomeCondicao() {
        return nomeCondicao;
    }


    /**
     * Sets the nomeCondicao value for this DadosDependentes.
     * 
     * @param nomeCondicao
     */
    public void setNomeCondicao(java.lang.String nomeCondicao) {
        this.nomeCondicao = nomeCondicao;
    }


    /**
     * Gets the nomeGrauParentesco value for this DadosDependentes.
     * 
     * @return nomeGrauParentesco
     */
    public java.lang.String getNomeGrauParentesco() {
        return nomeGrauParentesco;
    }


    /**
     * Sets the nomeGrauParentesco value for this DadosDependentes.
     * 
     * @param nomeGrauParentesco
     */
    public void setNomeGrauParentesco(java.lang.String nomeGrauParentesco) {
        this.nomeGrauParentesco = nomeGrauParentesco;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosDependentes)) return false;
        DadosDependentes other = (DadosDependentes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayBeneficios==null && other.getArrayBeneficios()==null) || 
             (this.arrayBeneficios!=null &&
              this.arrayBeneficios.equals(other.getArrayBeneficios()))) &&
            ((this.codCondicao==null && other.getCodCondicao()==null) || 
             (this.codCondicao!=null &&
              this.codCondicao.equals(other.getCodCondicao()))) &&
            ((this.codGrauParentesco==null && other.getCodGrauParentesco()==null) || 
             (this.codGrauParentesco!=null &&
              this.codGrauParentesco.equals(other.getCodGrauParentesco()))) &&
            ((this.codOrgao==null && other.getCodOrgao()==null) || 
             (this.codOrgao!=null &&
              this.codOrgao.equals(other.getCodOrgao()))) &&
            ((this.cpf==null && other.getCpf()==null) || 
             (this.cpf!=null &&
              this.cpf.equals(other.getCpf()))) &&
            ((this.matricula==null && other.getMatricula()==null) || 
             (this.matricula!=null &&
              this.matricula.equals(other.getMatricula()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.nomeCondicao==null && other.getNomeCondicao()==null) || 
             (this.nomeCondicao!=null &&
              this.nomeCondicao.equals(other.getNomeCondicao()))) &&
            ((this.nomeGrauParentesco==null && other.getNomeGrauParentesco()==null) || 
             (this.nomeGrauParentesco!=null &&
              this.nomeGrauParentesco.equals(other.getNomeGrauParentesco())));
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
        if (getArrayBeneficios() != null) {
            _hashCode += getArrayBeneficios().hashCode();
        }
        if (getCodCondicao() != null) {
            _hashCode += getCodCondicao().hashCode();
        }
        if (getCodGrauParentesco() != null) {
            _hashCode += getCodGrauParentesco().hashCode();
        }
        if (getCodOrgao() != null) {
            _hashCode += getCodOrgao().hashCode();
        }
        if (getCpf() != null) {
            _hashCode += getCpf().hashCode();
        }
        if (getMatricula() != null) {
            _hashCode += getMatricula().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getNomeCondicao() != null) {
            _hashCode += getNomeCondicao().hashCode();
        }
        if (getNomeGrauParentesco() != null) {
            _hashCode += getNomeGrauParentesco().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosDependentes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosDependentes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayBeneficios");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "arrayBeneficios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfBeneficio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCondicao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codCondicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codGrauParentesco");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codGrauParentesco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codOrgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codOrgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "cpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matricula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "matricula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeCondicao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeCondicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeGrauParentesco");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeGrauParentesco"));
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
