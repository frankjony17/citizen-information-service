/**
 * RequestObterRecurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ServicoConsultaRecurso;

public class RequestObterRecurso  implements java.io.Serializable {
    private java.lang.String usuario;

    private java.lang.String senha;

    private java.lang.String protocolo;

    private java.util.Calendar dtAberturaInicio;

    private java.util.Calendar dtAberturaFim;

    private java.util.Calendar dtPrazoAtendimentoInicio;

    private java.util.Calendar dtPrazoAtendimentoFim;

    private java.lang.Integer instancia;

    private java.lang.Integer origemTerceiraInstancia;

    private int situacaoRecurso;

    private boolean retornarOrgaosVinculados;

    private java.lang.Integer orgao;

    public RequestObterRecurso() {
    }

    public RequestObterRecurso(
           java.lang.String usuario,
           java.lang.String senha,
           java.lang.String protocolo,
           java.util.Calendar dtAberturaInicio,
           java.util.Calendar dtAberturaFim,
           java.util.Calendar dtPrazoAtendimentoInicio,
           java.util.Calendar dtPrazoAtendimentoFim,
           java.lang.Integer instancia,
           java.lang.Integer origemTerceiraInstancia,
           int situacaoRecurso,
           boolean retornarOrgaosVinculados,
           java.lang.Integer orgao) {
           this.usuario = usuario;
           this.senha = senha;
           this.protocolo = protocolo;
           this.dtAberturaInicio = dtAberturaInicio;
           this.dtAberturaFim = dtAberturaFim;
           this.dtPrazoAtendimentoInicio = dtPrazoAtendimentoInicio;
           this.dtPrazoAtendimentoFim = dtPrazoAtendimentoFim;
           this.instancia = instancia;
           this.origemTerceiraInstancia = origemTerceiraInstancia;
           this.situacaoRecurso = situacaoRecurso;
           this.retornarOrgaosVinculados = retornarOrgaosVinculados;
           this.orgao = orgao;
    }


    /**
     * Gets the usuario value for this RequestObterRecurso.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this RequestObterRecurso.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the senha value for this RequestObterRecurso.
     * 
     * @return senha
     */
    public java.lang.String getSenha() {
        return senha;
    }


    /**
     * Sets the senha value for this RequestObterRecurso.
     * 
     * @param senha
     */
    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }


    /**
     * Gets the protocolo value for this RequestObterRecurso.
     * 
     * @return protocolo
     */
    public java.lang.String getProtocolo() {
        return protocolo;
    }


    /**
     * Sets the protocolo value for this RequestObterRecurso.
     * 
     * @param protocolo
     */
    public void setProtocolo(java.lang.String protocolo) {
        this.protocolo = protocolo;
    }


    /**
     * Gets the dtAberturaInicio value for this RequestObterRecurso.
     * 
     * @return dtAberturaInicio
     */
    public java.util.Calendar getDtAberturaInicio() {
        return dtAberturaInicio;
    }


    /**
     * Sets the dtAberturaInicio value for this RequestObterRecurso.
     * 
     * @param dtAberturaInicio
     */
    public void setDtAberturaInicio(java.util.Calendar dtAberturaInicio) {
        this.dtAberturaInicio = dtAberturaInicio;
    }


    /**
     * Gets the dtAberturaFim value for this RequestObterRecurso.
     * 
     * @return dtAberturaFim
     */
    public java.util.Calendar getDtAberturaFim() {
        return dtAberturaFim;
    }


    /**
     * Sets the dtAberturaFim value for this RequestObterRecurso.
     * 
     * @param dtAberturaFim
     */
    public void setDtAberturaFim(java.util.Calendar dtAberturaFim) {
        this.dtAberturaFim = dtAberturaFim;
    }


    /**
     * Gets the dtPrazoAtendimentoInicio value for this RequestObterRecurso.
     * 
     * @return dtPrazoAtendimentoInicio
     */
    public java.util.Calendar getDtPrazoAtendimentoInicio() {
        return dtPrazoAtendimentoInicio;
    }


    /**
     * Sets the dtPrazoAtendimentoInicio value for this RequestObterRecurso.
     * 
     * @param dtPrazoAtendimentoInicio
     */
    public void setDtPrazoAtendimentoInicio(java.util.Calendar dtPrazoAtendimentoInicio) {
        this.dtPrazoAtendimentoInicio = dtPrazoAtendimentoInicio;
    }


    /**
     * Gets the dtPrazoAtendimentoFim value for this RequestObterRecurso.
     * 
     * @return dtPrazoAtendimentoFim
     */
    public java.util.Calendar getDtPrazoAtendimentoFim() {
        return dtPrazoAtendimentoFim;
    }


    /**
     * Sets the dtPrazoAtendimentoFim value for this RequestObterRecurso.
     * 
     * @param dtPrazoAtendimentoFim
     */
    public void setDtPrazoAtendimentoFim(java.util.Calendar dtPrazoAtendimentoFim) {
        this.dtPrazoAtendimentoFim = dtPrazoAtendimentoFim;
    }


    /**
     * Gets the instancia value for this RequestObterRecurso.
     * 
     * @return instancia
     */
    public java.lang.Integer getInstancia() {
        return instancia;
    }


    /**
     * Sets the instancia value for this RequestObterRecurso.
     * 
     * @param instancia
     */
    public void setInstancia(java.lang.Integer instancia) {
        this.instancia = instancia;
    }


    /**
     * Gets the origemTerceiraInstancia value for this RequestObterRecurso.
     * 
     * @return origemTerceiraInstancia
     */
    public java.lang.Integer getOrigemTerceiraInstancia() {
        return origemTerceiraInstancia;
    }


    /**
     * Sets the origemTerceiraInstancia value for this RequestObterRecurso.
     * 
     * @param origemTerceiraInstancia
     */
    public void setOrigemTerceiraInstancia(java.lang.Integer origemTerceiraInstancia) {
        this.origemTerceiraInstancia = origemTerceiraInstancia;
    }


    /**
     * Gets the situacaoRecurso value for this RequestObterRecurso.
     * 
     * @return situacaoRecurso
     */
    public int getSituacaoRecurso() {
        return situacaoRecurso;
    }


    /**
     * Sets the situacaoRecurso value for this RequestObterRecurso.
     * 
     * @param situacaoRecurso
     */
    public void setSituacaoRecurso(int situacaoRecurso) {
        this.situacaoRecurso = situacaoRecurso;
    }


    /**
     * Gets the retornarOrgaosVinculados value for this RequestObterRecurso.
     * 
     * @return retornarOrgaosVinculados
     */
    public boolean isRetornarOrgaosVinculados() {
        return retornarOrgaosVinculados;
    }


    /**
     * Sets the retornarOrgaosVinculados value for this RequestObterRecurso.
     * 
     * @param retornarOrgaosVinculados
     */
    public void setRetornarOrgaosVinculados(boolean retornarOrgaosVinculados) {
        this.retornarOrgaosVinculados = retornarOrgaosVinculados;
    }


    /**
     * Gets the orgao value for this RequestObterRecurso.
     * 
     * @return orgao
     */
    public java.lang.Integer getOrgao() {
        return orgao;
    }


    /**
     * Sets the orgao value for this RequestObterRecurso.
     * 
     * @param orgao
     */
    public void setOrgao(java.lang.Integer orgao) {
        this.orgao = orgao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestObterRecurso)) return false;
        RequestObterRecurso other = (RequestObterRecurso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.senha==null && other.getSenha()==null) || 
             (this.senha!=null &&
              this.senha.equals(other.getSenha()))) &&
            ((this.protocolo==null && other.getProtocolo()==null) || 
             (this.protocolo!=null &&
              this.protocolo.equals(other.getProtocolo()))) &&
            ((this.dtAberturaInicio==null && other.getDtAberturaInicio()==null) || 
             (this.dtAberturaInicio!=null &&
              this.dtAberturaInicio.equals(other.getDtAberturaInicio()))) &&
            ((this.dtAberturaFim==null && other.getDtAberturaFim()==null) || 
             (this.dtAberturaFim!=null &&
              this.dtAberturaFim.equals(other.getDtAberturaFim()))) &&
            ((this.dtPrazoAtendimentoInicio==null && other.getDtPrazoAtendimentoInicio()==null) || 
             (this.dtPrazoAtendimentoInicio!=null &&
              this.dtPrazoAtendimentoInicio.equals(other.getDtPrazoAtendimentoInicio()))) &&
            ((this.dtPrazoAtendimentoFim==null && other.getDtPrazoAtendimentoFim()==null) || 
             (this.dtPrazoAtendimentoFim!=null &&
              this.dtPrazoAtendimentoFim.equals(other.getDtPrazoAtendimentoFim()))) &&
            ((this.instancia==null && other.getInstancia()==null) || 
             (this.instancia!=null &&
              this.instancia.equals(other.getInstancia()))) &&
            ((this.origemTerceiraInstancia==null && other.getOrigemTerceiraInstancia()==null) || 
             (this.origemTerceiraInstancia!=null &&
              this.origemTerceiraInstancia.equals(other.getOrigemTerceiraInstancia()))) &&
            this.situacaoRecurso == other.getSituacaoRecurso() &&
            this.retornarOrgaosVinculados == other.isRetornarOrgaosVinculados() &&
            ((this.orgao==null && other.getOrgao()==null) || 
             (this.orgao!=null &&
              this.orgao.equals(other.getOrgao())));
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
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getSenha() != null) {
            _hashCode += getSenha().hashCode();
        }
        if (getProtocolo() != null) {
            _hashCode += getProtocolo().hashCode();
        }
        if (getDtAberturaInicio() != null) {
            _hashCode += getDtAberturaInicio().hashCode();
        }
        if (getDtAberturaFim() != null) {
            _hashCode += getDtAberturaFim().hashCode();
        }
        if (getDtPrazoAtendimentoInicio() != null) {
            _hashCode += getDtPrazoAtendimentoInicio().hashCode();
        }
        if (getDtPrazoAtendimentoFim() != null) {
            _hashCode += getDtPrazoAtendimentoFim().hashCode();
        }
        if (getInstancia() != null) {
            _hashCode += getInstancia().hashCode();
        }
        if (getOrigemTerceiraInstancia() != null) {
            _hashCode += getOrigemTerceiraInstancia().hashCode();
        }
        _hashCode += getSituacaoRecurso();
        _hashCode += (isRetornarOrgaosVinculados() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getOrgao() != null) {
            _hashCode += getOrgao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestObterRecurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "RequestObterRecurso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Senha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Protocolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtAberturaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "DtAberturaInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtAberturaFim");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "DtAberturaFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtPrazoAtendimentoInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "DtPrazoAtendimentoInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtPrazoAtendimentoFim");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "DtPrazoAtendimentoFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Instancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origemTerceiraInstancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "OrigemTerceiraInstancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("situacaoRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "SituacaoRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retornarOrgaosVinculados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "RetornarOrgaosVinculados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Orgao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
