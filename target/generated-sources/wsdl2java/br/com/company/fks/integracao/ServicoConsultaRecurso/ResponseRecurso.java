/**
 * ResponseRecurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ServicoConsultaRecurso;

public class ResponseRecurso  implements java.io.Serializable {
    private java.lang.String protocoloPedido;

    private int codInstancia;

    private java.lang.String instancia;

    private java.lang.String tipoRecurso;

    private java.util.Calendar dataAbertura;

    private java.util.Calendar prazoAtendimento;

    private java.lang.String situacao;

    private java.lang.String justificativa;

    private int qtdAnexos;

    private ResponseSolicitante solicitante;

    public ResponseRecurso() {
    }

    public ResponseRecurso(
           java.lang.String protocoloPedido,
           int codInstancia,
           java.lang.String instancia,
           java.lang.String tipoRecurso,
           java.util.Calendar dataAbertura,
           java.util.Calendar prazoAtendimento,
           java.lang.String situacao,
           java.lang.String justificativa,
           int qtdAnexos,
           ResponseSolicitante solicitante) {
           this.protocoloPedido = protocoloPedido;
           this.codInstancia = codInstancia;
           this.instancia = instancia;
           this.tipoRecurso = tipoRecurso;
           this.dataAbertura = dataAbertura;
           this.prazoAtendimento = prazoAtendimento;
           this.situacao = situacao;
           this.justificativa = justificativa;
           this.qtdAnexos = qtdAnexos;
           this.solicitante = solicitante;
    }


    /**
     * Gets the protocoloPedido value for this ResponseRecurso.
     * 
     * @return protocoloPedido
     */
    public java.lang.String getProtocoloPedido() {
        return protocoloPedido;
    }


    /**
     * Sets the protocoloPedido value for this ResponseRecurso.
     * 
     * @param protocoloPedido
     */
    public void setProtocoloPedido(java.lang.String protocoloPedido) {
        this.protocoloPedido = protocoloPedido;
    }


    /**
     * Gets the codInstancia value for this ResponseRecurso.
     * 
     * @return codInstancia
     */
    public int getCodInstancia() {
        return codInstancia;
    }


    /**
     * Sets the codInstancia value for this ResponseRecurso.
     * 
     * @param codInstancia
     */
    public void setCodInstancia(int codInstancia) {
        this.codInstancia = codInstancia;
    }


    /**
     * Gets the instancia value for this ResponseRecurso.
     * 
     * @return instancia
     */
    public java.lang.String getInstancia() {
        return instancia;
    }


    /**
     * Sets the instancia value for this ResponseRecurso.
     * 
     * @param instancia
     */
    public void setInstancia(java.lang.String instancia) {
        this.instancia = instancia;
    }


    /**
     * Gets the tipoRecurso value for this ResponseRecurso.
     * 
     * @return tipoRecurso
     */
    public java.lang.String getTipoRecurso() {
        return tipoRecurso;
    }


    /**
     * Sets the tipoRecurso value for this ResponseRecurso.
     * 
     * @param tipoRecurso
     */
    public void setTipoRecurso(java.lang.String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }


    /**
     * Gets the dataAbertura value for this ResponseRecurso.
     * 
     * @return dataAbertura
     */
    public java.util.Calendar getDataAbertura() {
        return dataAbertura;
    }


    /**
     * Sets the dataAbertura value for this ResponseRecurso.
     * 
     * @param dataAbertura
     */
    public void setDataAbertura(java.util.Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }


    /**
     * Gets the prazoAtendimento value for this ResponseRecurso.
     * 
     * @return prazoAtendimento
     */
    public java.util.Calendar getPrazoAtendimento() {
        return prazoAtendimento;
    }


    /**
     * Sets the prazoAtendimento value for this ResponseRecurso.
     * 
     * @param prazoAtendimento
     */
    public void setPrazoAtendimento(java.util.Calendar prazoAtendimento) {
        this.prazoAtendimento = prazoAtendimento;
    }


    /**
     * Gets the situacao value for this ResponseRecurso.
     * 
     * @return situacao
     */
    public java.lang.String getSituacao() {
        return situacao;
    }


    /**
     * Sets the situacao value for this ResponseRecurso.
     * 
     * @param situacao
     */
    public void setSituacao(java.lang.String situacao) {
        this.situacao = situacao;
    }


    /**
     * Gets the justificativa value for this ResponseRecurso.
     * 
     * @return justificativa
     */
    public java.lang.String getJustificativa() {
        return justificativa;
    }


    /**
     * Sets the justificativa value for this ResponseRecurso.
     * 
     * @param justificativa
     */
    public void setJustificativa(java.lang.String justificativa) {
        this.justificativa = justificativa;
    }


    /**
     * Gets the qtdAnexos value for this ResponseRecurso.
     * 
     * @return qtdAnexos
     */
    public int getQtdAnexos() {
        return qtdAnexos;
    }


    /**
     * Sets the qtdAnexos value for this ResponseRecurso.
     * 
     * @param qtdAnexos
     */
    public void setQtdAnexos(int qtdAnexos) {
        this.qtdAnexos = qtdAnexos;
    }


    /**
     * Gets the solicitante value for this ResponseRecurso.
     * 
     * @return solicitante
     */
    public ResponseSolicitante getSolicitante() {
        return solicitante;
    }


    /**
     * Sets the solicitante value for this ResponseRecurso.
     * 
     * @param solicitante
     */
    public void setSolicitante(ResponseSolicitante solicitante) {
        this.solicitante = solicitante;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseRecurso)) return false;
        ResponseRecurso other = (ResponseRecurso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.protocoloPedido==null && other.getProtocoloPedido()==null) || 
             (this.protocoloPedido!=null &&
              this.protocoloPedido.equals(other.getProtocoloPedido()))) &&
            this.codInstancia == other.getCodInstancia() &&
            ((this.instancia==null && other.getInstancia()==null) || 
             (this.instancia!=null &&
              this.instancia.equals(other.getInstancia()))) &&
            ((this.tipoRecurso==null && other.getTipoRecurso()==null) || 
             (this.tipoRecurso!=null &&
              this.tipoRecurso.equals(other.getTipoRecurso()))) &&
            ((this.dataAbertura==null && other.getDataAbertura()==null) || 
             (this.dataAbertura!=null &&
              this.dataAbertura.equals(other.getDataAbertura()))) &&
            ((this.prazoAtendimento==null && other.getPrazoAtendimento()==null) || 
             (this.prazoAtendimento!=null &&
              this.prazoAtendimento.equals(other.getPrazoAtendimento()))) &&
            ((this.situacao==null && other.getSituacao()==null) || 
             (this.situacao!=null &&
              this.situacao.equals(other.getSituacao()))) &&
            ((this.justificativa==null && other.getJustificativa()==null) || 
             (this.justificativa!=null &&
              this.justificativa.equals(other.getJustificativa()))) &&
            this.qtdAnexos == other.getQtdAnexos() &&
            ((this.solicitante==null && other.getSolicitante()==null) || 
             (this.solicitante!=null &&
              this.solicitante.equals(other.getSolicitante())));
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
        if (getProtocoloPedido() != null) {
            _hashCode += getProtocoloPedido().hashCode();
        }
        _hashCode += getCodInstancia();
        if (getInstancia() != null) {
            _hashCode += getInstancia().hashCode();
        }
        if (getTipoRecurso() != null) {
            _hashCode += getTipoRecurso().hashCode();
        }
        if (getDataAbertura() != null) {
            _hashCode += getDataAbertura().hashCode();
        }
        if (getPrazoAtendimento() != null) {
            _hashCode += getPrazoAtendimento().hashCode();
        }
        if (getSituacao() != null) {
            _hashCode += getSituacao().hashCode();
        }
        if (getJustificativa() != null) {
            _hashCode += getJustificativa().hashCode();
        }
        _hashCode += getQtdAnexos();
        if (getSolicitante() != null) {
            _hashCode += getSolicitante().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseRecurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ResponseRecurso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocoloPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ProtocoloPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codInstancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "CodInstancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Instancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "TipoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAbertura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "DataAbertura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prazoAtendimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "PrazoAtendimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("situacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Situacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("justificativa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Justificativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdAnexos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "QtdAnexos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("solicitante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Solicitante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ResponseSolicitante"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
