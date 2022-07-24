/**
 * DadosPA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosPA  implements java.io.Serializable {
    private java.lang.String agenciaBeneficiario;

    private ArrayOfAlimentadosPA arrayAlimentadosPA;

    private java.lang.String bancoBeneficiario;

    private java.lang.String codOrgao;

    private java.lang.String contaBeneficiario;

    private java.lang.String cpfBeneficiario;

    private java.lang.String matricula;

    private java.lang.String nomeBeneficiario;

    private java.lang.String valorUltimaPensao;

    public DadosPA() {
    }

    public DadosPA(
           java.lang.String agenciaBeneficiario,
           ArrayOfAlimentadosPA arrayAlimentadosPA,
           java.lang.String bancoBeneficiario,
           java.lang.String codOrgao,
           java.lang.String contaBeneficiario,
           java.lang.String cpfBeneficiario,
           java.lang.String matricula,
           java.lang.String nomeBeneficiario,
           java.lang.String valorUltimaPensao) {
           this.agenciaBeneficiario = agenciaBeneficiario;
           this.arrayAlimentadosPA = arrayAlimentadosPA;
           this.bancoBeneficiario = bancoBeneficiario;
           this.codOrgao = codOrgao;
           this.contaBeneficiario = contaBeneficiario;
           this.cpfBeneficiario = cpfBeneficiario;
           this.matricula = matricula;
           this.nomeBeneficiario = nomeBeneficiario;
           this.valorUltimaPensao = valorUltimaPensao;
    }


    /**
     * Gets the agenciaBeneficiario value for this DadosPA.
     * 
     * @return agenciaBeneficiario
     */
    public java.lang.String getAgenciaBeneficiario() {
        return agenciaBeneficiario;
    }


    /**
     * Sets the agenciaBeneficiario value for this DadosPA.
     * 
     * @param agenciaBeneficiario
     */
    public void setAgenciaBeneficiario(java.lang.String agenciaBeneficiario) {
        this.agenciaBeneficiario = agenciaBeneficiario;
    }


    /**
     * Gets the arrayAlimentadosPA value for this DadosPA.
     * 
     * @return arrayAlimentadosPA
     */
    public ArrayOfAlimentadosPA getArrayAlimentadosPA() {
        return arrayAlimentadosPA;
    }


    /**
     * Sets the arrayAlimentadosPA value for this DadosPA.
     * 
     * @param arrayAlimentadosPA
     */
    public void setArrayAlimentadosPA(ArrayOfAlimentadosPA arrayAlimentadosPA) {
        this.arrayAlimentadosPA = arrayAlimentadosPA;
    }


    /**
     * Gets the bancoBeneficiario value for this DadosPA.
     * 
     * @return bancoBeneficiario
     */
    public java.lang.String getBancoBeneficiario() {
        return bancoBeneficiario;
    }


    /**
     * Sets the bancoBeneficiario value for this DadosPA.
     * 
     * @param bancoBeneficiario
     */
    public void setBancoBeneficiario(java.lang.String bancoBeneficiario) {
        this.bancoBeneficiario = bancoBeneficiario;
    }


    /**
     * Gets the codOrgao value for this DadosPA.
     * 
     * @return codOrgao
     */
    public java.lang.String getCodOrgao() {
        return codOrgao;
    }


    /**
     * Sets the codOrgao value for this DadosPA.
     * 
     * @param codOrgao
     */
    public void setCodOrgao(java.lang.String codOrgao) {
        this.codOrgao = codOrgao;
    }


    /**
     * Gets the contaBeneficiario value for this DadosPA.
     * 
     * @return contaBeneficiario
     */
    public java.lang.String getContaBeneficiario() {
        return contaBeneficiario;
    }


    /**
     * Sets the contaBeneficiario value for this DadosPA.
     * 
     * @param contaBeneficiario
     */
    public void setContaBeneficiario(java.lang.String contaBeneficiario) {
        this.contaBeneficiario = contaBeneficiario;
    }


    /**
     * Gets the cpfBeneficiario value for this DadosPA.
     * 
     * @return cpfBeneficiario
     */
    public java.lang.String getCpfBeneficiario() {
        return cpfBeneficiario;
    }


    /**
     * Sets the cpfBeneficiario value for this DadosPA.
     * 
     * @param cpfBeneficiario
     */
    public void setCpfBeneficiario(java.lang.String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
    }


    /**
     * Gets the matricula value for this DadosPA.
     * 
     * @return matricula
     */
    public java.lang.String getMatricula() {
        return matricula;
    }


    /**
     * Sets the matricula value for this DadosPA.
     * 
     * @param matricula
     */
    public void setMatricula(java.lang.String matricula) {
        this.matricula = matricula;
    }


    /**
     * Gets the nomeBeneficiario value for this DadosPA.
     * 
     * @return nomeBeneficiario
     */
    public java.lang.String getNomeBeneficiario() {
        return nomeBeneficiario;
    }


    /**
     * Sets the nomeBeneficiario value for this DadosPA.
     * 
     * @param nomeBeneficiario
     */
    public void setNomeBeneficiario(java.lang.String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }


    /**
     * Gets the valorUltimaPensao value for this DadosPA.
     * 
     * @return valorUltimaPensao
     */
    public java.lang.String getValorUltimaPensao() {
        return valorUltimaPensao;
    }


    /**
     * Sets the valorUltimaPensao value for this DadosPA.
     * 
     * @param valorUltimaPensao
     */
    public void setValorUltimaPensao(java.lang.String valorUltimaPensao) {
        this.valorUltimaPensao = valorUltimaPensao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosPA)) return false;
        DadosPA other = (DadosPA) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agenciaBeneficiario==null && other.getAgenciaBeneficiario()==null) || 
             (this.agenciaBeneficiario!=null &&
              this.agenciaBeneficiario.equals(other.getAgenciaBeneficiario()))) &&
            ((this.arrayAlimentadosPA==null && other.getArrayAlimentadosPA()==null) || 
             (this.arrayAlimentadosPA!=null &&
              this.arrayAlimentadosPA.equals(other.getArrayAlimentadosPA()))) &&
            ((this.bancoBeneficiario==null && other.getBancoBeneficiario()==null) || 
             (this.bancoBeneficiario!=null &&
              this.bancoBeneficiario.equals(other.getBancoBeneficiario()))) &&
            ((this.codOrgao==null && other.getCodOrgao()==null) || 
             (this.codOrgao!=null &&
              this.codOrgao.equals(other.getCodOrgao()))) &&
            ((this.contaBeneficiario==null && other.getContaBeneficiario()==null) || 
             (this.contaBeneficiario!=null &&
              this.contaBeneficiario.equals(other.getContaBeneficiario()))) &&
            ((this.cpfBeneficiario==null && other.getCpfBeneficiario()==null) || 
             (this.cpfBeneficiario!=null &&
              this.cpfBeneficiario.equals(other.getCpfBeneficiario()))) &&
            ((this.matricula==null && other.getMatricula()==null) || 
             (this.matricula!=null &&
              this.matricula.equals(other.getMatricula()))) &&
            ((this.nomeBeneficiario==null && other.getNomeBeneficiario()==null) || 
             (this.nomeBeneficiario!=null &&
              this.nomeBeneficiario.equals(other.getNomeBeneficiario()))) &&
            ((this.valorUltimaPensao==null && other.getValorUltimaPensao()==null) || 
             (this.valorUltimaPensao!=null &&
              this.valorUltimaPensao.equals(other.getValorUltimaPensao())));
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
        if (getAgenciaBeneficiario() != null) {
            _hashCode += getAgenciaBeneficiario().hashCode();
        }
        if (getArrayAlimentadosPA() != null) {
            _hashCode += getArrayAlimentadosPA().hashCode();
        }
        if (getBancoBeneficiario() != null) {
            _hashCode += getBancoBeneficiario().hashCode();
        }
        if (getCodOrgao() != null) {
            _hashCode += getCodOrgao().hashCode();
        }
        if (getContaBeneficiario() != null) {
            _hashCode += getContaBeneficiario().hashCode();
        }
        if (getCpfBeneficiario() != null) {
            _hashCode += getCpfBeneficiario().hashCode();
        }
        if (getMatricula() != null) {
            _hashCode += getMatricula().hashCode();
        }
        if (getNomeBeneficiario() != null) {
            _hashCode += getNomeBeneficiario().hashCode();
        }
        if (getValorUltimaPensao() != null) {
            _hashCode += getValorUltimaPensao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosPA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosPA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agenciaBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "agenciaBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayAlimentadosPA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "arrayAlimentadosPA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfAlimentadosPA"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bancoBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "bancoBeneficiario"));
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
        elemField.setFieldName("contaBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "contaBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpfBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "cpfBeneficiario"));
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
        elemField.setFieldName("nomeBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "nomeBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorUltimaPensao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "valorUltimaPensao"));
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
