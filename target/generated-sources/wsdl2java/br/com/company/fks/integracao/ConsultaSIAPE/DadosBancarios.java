/**
 * DadosBancarios.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosBancarios  implements java.io.Serializable {
    private java.lang.String agencia;

    private java.lang.String agenciaOutrosPagtos;

    private java.lang.String banco;

    private java.lang.String bancoOutrosPagtos;

    private java.lang.String codOrgao;

    private java.lang.String contaCorrente;

    private java.lang.String contaCorrenteOutrosPagtos;

    private java.lang.String matricula;

    public DadosBancarios() {
    }

    public DadosBancarios(
           java.lang.String agencia,
           java.lang.String agenciaOutrosPagtos,
           java.lang.String banco,
           java.lang.String bancoOutrosPagtos,
           java.lang.String codOrgao,
           java.lang.String contaCorrente,
           java.lang.String contaCorrenteOutrosPagtos,
           java.lang.String matricula) {
           this.agencia = agencia;
           this.agenciaOutrosPagtos = agenciaOutrosPagtos;
           this.banco = banco;
           this.bancoOutrosPagtos = bancoOutrosPagtos;
           this.codOrgao = codOrgao;
           this.contaCorrente = contaCorrente;
           this.contaCorrenteOutrosPagtos = contaCorrenteOutrosPagtos;
           this.matricula = matricula;
    }


    /**
     * Gets the agencia value for this DadosBancarios.
     * 
     * @return agencia
     */
    public java.lang.String getAgencia() {
        return agencia;
    }


    /**
     * Sets the agencia value for this DadosBancarios.
     * 
     * @param agencia
     */
    public void setAgencia(java.lang.String agencia) {
        this.agencia = agencia;
    }


    /**
     * Gets the agenciaOutrosPagtos value for this DadosBancarios.
     * 
     * @return agenciaOutrosPagtos
     */
    public java.lang.String getAgenciaOutrosPagtos() {
        return agenciaOutrosPagtos;
    }


    /**
     * Sets the agenciaOutrosPagtos value for this DadosBancarios.
     * 
     * @param agenciaOutrosPagtos
     */
    public void setAgenciaOutrosPagtos(java.lang.String agenciaOutrosPagtos) {
        this.agenciaOutrosPagtos = agenciaOutrosPagtos;
    }


    /**
     * Gets the banco value for this DadosBancarios.
     * 
     * @return banco
     */
    public java.lang.String getBanco() {
        return banco;
    }


    /**
     * Sets the banco value for this DadosBancarios.
     * 
     * @param banco
     */
    public void setBanco(java.lang.String banco) {
        this.banco = banco;
    }


    /**
     * Gets the bancoOutrosPagtos value for this DadosBancarios.
     * 
     * @return bancoOutrosPagtos
     */
    public java.lang.String getBancoOutrosPagtos() {
        return bancoOutrosPagtos;
    }


    /**
     * Sets the bancoOutrosPagtos value for this DadosBancarios.
     * 
     * @param bancoOutrosPagtos
     */
    public void setBancoOutrosPagtos(java.lang.String bancoOutrosPagtos) {
        this.bancoOutrosPagtos = bancoOutrosPagtos;
    }


    /**
     * Gets the codOrgao value for this DadosBancarios.
     * 
     * @return codOrgao
     */
    public java.lang.String getCodOrgao() {
        return codOrgao;
    }


    /**
     * Sets the codOrgao value for this DadosBancarios.
     * 
     * @param codOrgao
     */
    public void setCodOrgao(java.lang.String codOrgao) {
        this.codOrgao = codOrgao;
    }


    /**
     * Gets the contaCorrente value for this DadosBancarios.
     * 
     * @return contaCorrente
     */
    public java.lang.String getContaCorrente() {
        return contaCorrente;
    }


    /**
     * Sets the contaCorrente value for this DadosBancarios.
     * 
     * @param contaCorrente
     */
    public void setContaCorrente(java.lang.String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }


    /**
     * Gets the contaCorrenteOutrosPagtos value for this DadosBancarios.
     * 
     * @return contaCorrenteOutrosPagtos
     */
    public java.lang.String getContaCorrenteOutrosPagtos() {
        return contaCorrenteOutrosPagtos;
    }


    /**
     * Sets the contaCorrenteOutrosPagtos value for this DadosBancarios.
     * 
     * @param contaCorrenteOutrosPagtos
     */
    public void setContaCorrenteOutrosPagtos(java.lang.String contaCorrenteOutrosPagtos) {
        this.contaCorrenteOutrosPagtos = contaCorrenteOutrosPagtos;
    }


    /**
     * Gets the matricula value for this DadosBancarios.
     * 
     * @return matricula
     */
    public java.lang.String getMatricula() {
        return matricula;
    }


    /**
     * Sets the matricula value for this DadosBancarios.
     * 
     * @param matricula
     */
    public void setMatricula(java.lang.String matricula) {
        this.matricula = matricula;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosBancarios)) return false;
        DadosBancarios other = (DadosBancarios) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agencia==null && other.getAgencia()==null) || 
             (this.agencia!=null &&
              this.agencia.equals(other.getAgencia()))) &&
            ((this.agenciaOutrosPagtos==null && other.getAgenciaOutrosPagtos()==null) || 
             (this.agenciaOutrosPagtos!=null &&
              this.agenciaOutrosPagtos.equals(other.getAgenciaOutrosPagtos()))) &&
            ((this.banco==null && other.getBanco()==null) || 
             (this.banco!=null &&
              this.banco.equals(other.getBanco()))) &&
            ((this.bancoOutrosPagtos==null && other.getBancoOutrosPagtos()==null) || 
             (this.bancoOutrosPagtos!=null &&
              this.bancoOutrosPagtos.equals(other.getBancoOutrosPagtos()))) &&
            ((this.codOrgao==null && other.getCodOrgao()==null) || 
             (this.codOrgao!=null &&
              this.codOrgao.equals(other.getCodOrgao()))) &&
            ((this.contaCorrente==null && other.getContaCorrente()==null) || 
             (this.contaCorrente!=null &&
              this.contaCorrente.equals(other.getContaCorrente()))) &&
            ((this.contaCorrenteOutrosPagtos==null && other.getContaCorrenteOutrosPagtos()==null) || 
             (this.contaCorrenteOutrosPagtos!=null &&
              this.contaCorrenteOutrosPagtos.equals(other.getContaCorrenteOutrosPagtos()))) &&
            ((this.matricula==null && other.getMatricula()==null) || 
             (this.matricula!=null &&
              this.matricula.equals(other.getMatricula())));
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
        if (getAgencia() != null) {
            _hashCode += getAgencia().hashCode();
        }
        if (getAgenciaOutrosPagtos() != null) {
            _hashCode += getAgenciaOutrosPagtos().hashCode();
        }
        if (getBanco() != null) {
            _hashCode += getBanco().hashCode();
        }
        if (getBancoOutrosPagtos() != null) {
            _hashCode += getBancoOutrosPagtos().hashCode();
        }
        if (getCodOrgao() != null) {
            _hashCode += getCodOrgao().hashCode();
        }
        if (getContaCorrente() != null) {
            _hashCode += getContaCorrente().hashCode();
        }
        if (getContaCorrenteOutrosPagtos() != null) {
            _hashCode += getContaCorrenteOutrosPagtos().hashCode();
        }
        if (getMatricula() != null) {
            _hashCode += getMatricula().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosBancarios.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosBancarios"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "agencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agenciaOutrosPagtos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "agenciaOutrosPagtos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("banco");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "banco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bancoOutrosPagtos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "bancoOutrosPagtos"));
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
        elemField.setFieldName("contaCorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "contaCorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contaCorrenteOutrosPagtos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "contaCorrenteOutrosPagtos"));
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
