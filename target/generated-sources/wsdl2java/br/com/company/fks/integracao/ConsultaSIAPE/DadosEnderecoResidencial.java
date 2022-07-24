/**
 * DadosEnderecoResidencial.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosEnderecoResidencial  implements java.io.Serializable {
    private java.lang.String bairro;

    private java.lang.String cep;

    private java.lang.String codMunicipio;

    private java.lang.String complemento;

    private java.lang.String dddTelefone;

    private java.lang.String logradouro;

    private java.lang.String nomeMunicipio;

    private java.lang.String numTelefone;

    private java.lang.String numero;

    private java.lang.String uf;

    public DadosEnderecoResidencial() {
    }

    public DadosEnderecoResidencial(
           java.lang.String bairro,
           java.lang.String cep,
           java.lang.String codMunicipio,
           java.lang.String complemento,
           java.lang.String dddTelefone,
           java.lang.String logradouro,
           java.lang.String nomeMunicipio,
           java.lang.String numTelefone,
           java.lang.String numero,
           java.lang.String uf) {
           this.bairro = bairro;
           this.cep = cep;
           this.codMunicipio = codMunicipio;
           this.complemento = complemento;
           this.dddTelefone = dddTelefone;
           this.logradouro = logradouro;
           this.nomeMunicipio = nomeMunicipio;
           this.numTelefone = numTelefone;
           this.numero = numero;
           this.uf = uf;
    }


    /**
     * Gets the bairro value for this DadosEnderecoResidencial.
     * 
     * @return bairro
     */
    public java.lang.String getBairro() {
        return bairro;
    }


    /**
     * Sets the bairro value for this DadosEnderecoResidencial.
     * 
     * @param bairro
     */
    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }


    /**
     * Gets the cep value for this DadosEnderecoResidencial.
     * 
     * @return cep
     */
    public java.lang.String getCep() {
        return cep;
    }


    /**
     * Sets the cep value for this DadosEnderecoResidencial.
     * 
     * @param cep
     */
    public void setCep(java.lang.String cep) {
        this.cep = cep;
    }


    /**
     * Gets the codMunicipio value for this DadosEnderecoResidencial.
     * 
     * @return codMunicipio
     */
    public java.lang.String getCodMunicipio() {
        return codMunicipio;
    }


    /**
     * Sets the codMunicipio value for this DadosEnderecoResidencial.
     * 
     * @param codMunicipio
     */
    public void setCodMunicipio(java.lang.String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }


    /**
     * Gets the complemento value for this DadosEnderecoResidencial.
     * 
     * @return complemento
     */
    public java.lang.String getComplemento() {
        return complemento;
    }


    /**
     * Sets the complemento value for this DadosEnderecoResidencial.
     * 
     * @param complemento
     */
    public void setComplemento(java.lang.String complemento) {
        this.complemento = complemento;
    }


    /**
     * Gets the dddTelefone value for this DadosEnderecoResidencial.
     * 
     * @return dddTelefone
     */
    public java.lang.String getDddTelefone() {
        return dddTelefone;
    }


    /**
     * Sets the dddTelefone value for this DadosEnderecoResidencial.
     * 
     * @param dddTelefone
     */
    public void setDddTelefone(java.lang.String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }


    /**
     * Gets the logradouro value for this DadosEnderecoResidencial.
     * 
     * @return logradouro
     */
    public java.lang.String getLogradouro() {
        return logradouro;
    }


    /**
     * Sets the logradouro value for this DadosEnderecoResidencial.
     * 
     * @param logradouro
     */
    public void setLogradouro(java.lang.String logradouro) {
        this.logradouro = logradouro;
    }


    /**
     * Gets the nomeMunicipio value for this DadosEnderecoResidencial.
     * 
     * @return nomeMunicipio
     */
    public java.lang.String getNomeMunicipio() {
        return nomeMunicipio;
    }


    /**
     * Sets the nomeMunicipio value for this DadosEnderecoResidencial.
     * 
     * @param nomeMunicipio
     */
    public void setNomeMunicipio(java.lang.String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }


    /**
     * Gets the numTelefone value for this DadosEnderecoResidencial.
     * 
     * @return numTelefone
     */
    public java.lang.String getNumTelefone() {
        return numTelefone;
    }


    /**
     * Sets the numTelefone value for this DadosEnderecoResidencial.
     * 
     * @param numTelefone
     */
    public void setNumTelefone(java.lang.String numTelefone) {
        this.numTelefone = numTelefone;
    }


    /**
     * Gets the numero value for this DadosEnderecoResidencial.
     * 
     * @return numero
     */
    public java.lang.String getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this DadosEnderecoResidencial.
     * 
     * @param numero
     */
    public void setNumero(java.lang.String numero) {
        this.numero = numero;
    }


    /**
     * Gets the uf value for this DadosEnderecoResidencial.
     * 
     * @return uf
     */
    public java.lang.String getUf() {
        return uf;
    }


    /**
     * Sets the uf value for this DadosEnderecoResidencial.
     * 
     * @param uf
     */
    public void setUf(java.lang.String uf) {
        this.uf = uf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosEnderecoResidencial)) return false;
        DadosEnderecoResidencial other = (DadosEnderecoResidencial) obj;
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
            ((this.codMunicipio==null && other.getCodMunicipio()==null) || 
             (this.codMunicipio!=null &&
              this.codMunicipio.equals(other.getCodMunicipio()))) &&
            ((this.complemento==null && other.getComplemento()==null) || 
             (this.complemento!=null &&
              this.complemento.equals(other.getComplemento()))) &&
            ((this.dddTelefone==null && other.getDddTelefone()==null) || 
             (this.dddTelefone!=null &&
              this.dddTelefone.equals(other.getDddTelefone()))) &&
            ((this.logradouro==null && other.getLogradouro()==null) || 
             (this.logradouro!=null &&
              this.logradouro.equals(other.getLogradouro()))) &&
            ((this.nomeMunicipio==null && other.getNomeMunicipio()==null) || 
             (this.nomeMunicipio!=null &&
              this.nomeMunicipio.equals(other.getNomeMunicipio()))) &&
            ((this.numTelefone==null && other.getNumTelefone()==null) || 
             (this.numTelefone!=null &&
              this.numTelefone.equals(other.getNumTelefone()))) &&
            ((this.numero==null && other.getNumero()==null) || 
             (this.numero!=null &&
              this.numero.equals(other.getNumero()))) &&
            ((this.uf==null && other.getUf()==null) || 
             (this.uf!=null &&
              this.uf.equals(other.getUf())));
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
        if (getCodMunicipio() != null) {
            _hashCode += getCodMunicipio().hashCode();
        }
        if (getComplemento() != null) {
            _hashCode += getComplemento().hashCode();
        }
        if (getDddTelefone() != null) {
            _hashCode += getDddTelefone().hashCode();
        }
        if (getLogradouro() != null) {
            _hashCode += getLogradouro().hashCode();
        }
        if (getNomeMunicipio() != null) {
            _hashCode += getNomeMunicipio().hashCode();
        }
        if (getNumTelefone() != null) {
            _hashCode += getNumTelefone().hashCode();
        }
        if (getNumero() != null) {
            _hashCode += getNumero().hashCode();
        }
        if (getUf() != null) {
            _hashCode += getUf().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosEnderecoResidencial.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosEnderecoResidencial"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bairro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "bairro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "cep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codMunicipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "codMunicipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complemento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "complemento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dddTelefone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "dddTelefone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logradouro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "logradouro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeMunicipio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeMunicipio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numTelefone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "numTelefone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "uf"));
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
