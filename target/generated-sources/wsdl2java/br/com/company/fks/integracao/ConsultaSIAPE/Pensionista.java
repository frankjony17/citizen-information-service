/**
 * Pensionista.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class Pensionista  implements java.io.Serializable {
    private java.lang.String bairro;

    private java.lang.String cep;

    private java.lang.String cidade;

    private java.lang.String faixaEtaria;

    private java.lang.String logradouro;

    private java.lang.String matriculaBeneficiario;

    private java.lang.String nome;

    private java.lang.String numero;

    private ArrayOfString orgao;

    private java.lang.String sexo;

    private java.lang.String uf;

    private ArrayOfString upag;

    public Pensionista() {
    }

    public Pensionista(
           java.lang.String bairro,
           java.lang.String cep,
           java.lang.String cidade,
           java.lang.String faixaEtaria,
           java.lang.String logradouro,
           java.lang.String matriculaBeneficiario,
           java.lang.String nome,
           java.lang.String numero,
           ArrayOfString orgao,
           java.lang.String sexo,
           java.lang.String uf,
           ArrayOfString upag) {
           this.bairro = bairro;
           this.cep = cep;
           this.cidade = cidade;
           this.faixaEtaria = faixaEtaria;
           this.logradouro = logradouro;
           this.matriculaBeneficiario = matriculaBeneficiario;
           this.nome = nome;
           this.numero = numero;
           this.orgao = orgao;
           this.sexo = sexo;
           this.uf = uf;
           this.upag = upag;
    }


    /**
     * Gets the bairro value for this Pensionista.
     * 
     * @return bairro
     */
    public java.lang.String getBairro() {
        return bairro;
    }


    /**
     * Sets the bairro value for this Pensionista.
     * 
     * @param bairro
     */
    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }


    /**
     * Gets the cep value for this Pensionista.
     * 
     * @return cep
     */
    public java.lang.String getCep() {
        return cep;
    }


    /**
     * Sets the cep value for this Pensionista.
     * 
     * @param cep
     */
    public void setCep(java.lang.String cep) {
        this.cep = cep;
    }


    /**
     * Gets the cidade value for this Pensionista.
     * 
     * @return cidade
     */
    public java.lang.String getCidade() {
        return cidade;
    }


    /**
     * Sets the cidade value for this Pensionista.
     * 
     * @param cidade
     */
    public void setCidade(java.lang.String cidade) {
        this.cidade = cidade;
    }


    /**
     * Gets the faixaEtaria value for this Pensionista.
     * 
     * @return faixaEtaria
     */
    public java.lang.String getFaixaEtaria() {
        return faixaEtaria;
    }


    /**
     * Sets the faixaEtaria value for this Pensionista.
     * 
     * @param faixaEtaria
     */
    public void setFaixaEtaria(java.lang.String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }


    /**
     * Gets the logradouro value for this Pensionista.
     * 
     * @return logradouro
     */
    public java.lang.String getLogradouro() {
        return logradouro;
    }


    /**
     * Sets the logradouro value for this Pensionista.
     * 
     * @param logradouro
     */
    public void setLogradouro(java.lang.String logradouro) {
        this.logradouro = logradouro;
    }


    /**
     * Gets the matriculaBeneficiario value for this Pensionista.
     * 
     * @return matriculaBeneficiario
     */
    public java.lang.String getMatriculaBeneficiario() {
        return matriculaBeneficiario;
    }


    /**
     * Sets the matriculaBeneficiario value for this Pensionista.
     * 
     * @param matriculaBeneficiario
     */
    public void setMatriculaBeneficiario(java.lang.String matriculaBeneficiario) {
        this.matriculaBeneficiario = matriculaBeneficiario;
    }


    /**
     * Gets the nome value for this Pensionista.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Pensionista.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the numero value for this Pensionista.
     * 
     * @return numero
     */
    public java.lang.String getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this Pensionista.
     * 
     * @param numero
     */
    public void setNumero(java.lang.String numero) {
        this.numero = numero;
    }


    /**
     * Gets the orgao value for this Pensionista.
     * 
     * @return orgao
     */
    public ArrayOfString getOrgao() {
        return orgao;
    }


    /**
     * Sets the orgao value for this Pensionista.
     * 
     * @param orgao
     */
    public void setOrgao(ArrayOfString orgao) {
        this.orgao = orgao;
    }


    /**
     * Gets the sexo value for this Pensionista.
     * 
     * @return sexo
     */
    public java.lang.String getSexo() {
        return sexo;
    }


    /**
     * Sets the sexo value for this Pensionista.
     * 
     * @param sexo
     */
    public void setSexo(java.lang.String sexo) {
        this.sexo = sexo;
    }


    /**
     * Gets the uf value for this Pensionista.
     * 
     * @return uf
     */
    public java.lang.String getUf() {
        return uf;
    }


    /**
     * Sets the uf value for this Pensionista.
     * 
     * @param uf
     */
    public void setUf(java.lang.String uf) {
        this.uf = uf;
    }


    /**
     * Gets the upag value for this Pensionista.
     * 
     * @return upag
     */
    public ArrayOfString getUpag() {
        return upag;
    }


    /**
     * Sets the upag value for this Pensionista.
     * 
     * @param upag
     */
    public void setUpag(ArrayOfString upag) {
        this.upag = upag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pensionista)) return false;
        Pensionista other = (Pensionista) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bairro==null && other.getBairro()==null) || 
             (this.bairro!=null &&
              this.bairro.equals(other.getBairro()))) &&
            ((this.cep==null && other.getCep()==null) || 
             (this.cep!=null &&
              this.cep.equals(other.getCep()))) &&
            ((this.cidade==null && other.getCidade()==null) || 
             (this.cidade!=null &&
              this.cidade.equals(other.getCidade()))) &&
            ((this.faixaEtaria==null && other.getFaixaEtaria()==null) || 
             (this.faixaEtaria!=null &&
              this.faixaEtaria.equals(other.getFaixaEtaria()))) &&
            ((this.logradouro==null && other.getLogradouro()==null) || 
             (this.logradouro!=null &&
              this.logradouro.equals(other.getLogradouro()))) &&
            ((this.matriculaBeneficiario==null && other.getMatriculaBeneficiario()==null) || 
             (this.matriculaBeneficiario!=null &&
              this.matriculaBeneficiario.equals(other.getMatriculaBeneficiario()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.numero==null && other.getNumero()==null) || 
             (this.numero!=null &&
              this.numero.equals(other.getNumero()))) &&
            ((this.orgao==null && other.getOrgao()==null) || 
             (this.orgao!=null &&
              this.orgao.equals(other.getOrgao()))) &&
            ((this.sexo==null && other.getSexo()==null) || 
             (this.sexo!=null &&
              this.sexo.equals(other.getSexo()))) &&
            ((this.uf==null && other.getUf()==null) || 
             (this.uf!=null &&
              this.uf.equals(other.getUf()))) &&
            ((this.upag==null && other.getUpag()==null) || 
             (this.upag!=null &&
              this.upag.equals(other.getUpag())));
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
        if (getBairro() != null) {
            _hashCode += getBairro().hashCode();
        }
        if (getCep() != null) {
            _hashCode += getCep().hashCode();
        }
        if (getCidade() != null) {
            _hashCode += getCidade().hashCode();
        }
        if (getFaixaEtaria() != null) {
            _hashCode += getFaixaEtaria().hashCode();
        }
        if (getLogradouro() != null) {
            _hashCode += getLogradouro().hashCode();
        }
        if (getMatriculaBeneficiario() != null) {
            _hashCode += getMatriculaBeneficiario().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getNumero() != null) {
            _hashCode += getNumero().hashCode();
        }
        if (getOrgao() != null) {
            _hashCode += getOrgao().hashCode();
        }
        if (getSexo() != null) {
            _hashCode += getSexo().hashCode();
        }
        if (getUf() != null) {
            _hashCode += getUf().hashCode();
        }
        if (getUpag() != null) {
            _hashCode += getUpag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pensionista.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Pensionista"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bairro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "bairro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "cep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "cidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faixaEtaria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "faixaEtaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logradouro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "logradouro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matriculaBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "matriculaBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "orgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servico.wssiapenet", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sexo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "sexo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "uf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "upag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servico.wssiapenet", "ArrayOfString"));
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
