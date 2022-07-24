/**
 * ResponseObterRecursoAnexo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ServicoConsultaRecurso;

public class ResponseObterRecursoAnexo  implements java.io.Serializable {
    private int codigoExecucao;

    private java.util.Calendar dataHoraProcessamento;

    private java.lang.String descricaoExecucao;

    private int quantidadeDeArquivo;

    private ArrayOfResponseArquivo arquivos;

    public ResponseObterRecursoAnexo() {
    }

    public ResponseObterRecursoAnexo(
           int codigoExecucao,
           java.util.Calendar dataHoraProcessamento,
           java.lang.String descricaoExecucao,
           int quantidadeDeArquivo,
           ArrayOfResponseArquivo arquivos) {
           this.codigoExecucao = codigoExecucao;
           this.dataHoraProcessamento = dataHoraProcessamento;
           this.descricaoExecucao = descricaoExecucao;
           this.quantidadeDeArquivo = quantidadeDeArquivo;
           this.arquivos = arquivos;
    }


    /**
     * Gets the codigoExecucao value for this ResponseObterRecursoAnexo.
     * 
     * @return codigoExecucao
     */
    public int getCodigoExecucao() {
        return codigoExecucao;
    }


    /**
     * Sets the codigoExecucao value for this ResponseObterRecursoAnexo.
     * 
     * @param codigoExecucao
     */
    public void setCodigoExecucao(int codigoExecucao) {
        this.codigoExecucao = codigoExecucao;
    }


    /**
     * Gets the dataHoraProcessamento value for this ResponseObterRecursoAnexo.
     * 
     * @return dataHoraProcessamento
     */
    public java.util.Calendar getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }


    /**
     * Sets the dataHoraProcessamento value for this ResponseObterRecursoAnexo.
     * 
     * @param dataHoraProcessamento
     */
    public void setDataHoraProcessamento(java.util.Calendar dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }


    /**
     * Gets the descricaoExecucao value for this ResponseObterRecursoAnexo.
     * 
     * @return descricaoExecucao
     */
    public java.lang.String getDescricaoExecucao() {
        return descricaoExecucao;
    }


    /**
     * Sets the descricaoExecucao value for this ResponseObterRecursoAnexo.
     * 
     * @param descricaoExecucao
     */
    public void setDescricaoExecucao(java.lang.String descricaoExecucao) {
        this.descricaoExecucao = descricaoExecucao;
    }


    /**
     * Gets the quantidadeDeArquivo value for this ResponseObterRecursoAnexo.
     * 
     * @return quantidadeDeArquivo
     */
    public int getQuantidadeDeArquivo() {
        return quantidadeDeArquivo;
    }


    /**
     * Sets the quantidadeDeArquivo value for this ResponseObterRecursoAnexo.
     * 
     * @param quantidadeDeArquivo
     */
    public void setQuantidadeDeArquivo(int quantidadeDeArquivo) {
        this.quantidadeDeArquivo = quantidadeDeArquivo;
    }


    /**
     * Gets the arquivos value for this ResponseObterRecursoAnexo.
     * 
     * @return arquivos
     */
    public ArrayOfResponseArquivo getArquivos() {
        return arquivos;
    }


    /**
     * Sets the arquivos value for this ResponseObterRecursoAnexo.
     * 
     * @param arquivos
     */
    public void setArquivos(ArrayOfResponseArquivo arquivos) {
        this.arquivos = arquivos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseObterRecursoAnexo)) return false;
        ResponseObterRecursoAnexo other = (ResponseObterRecursoAnexo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codigoExecucao == other.getCodigoExecucao() &&
            ((this.dataHoraProcessamento==null && other.getDataHoraProcessamento()==null) || 
             (this.dataHoraProcessamento!=null &&
              this.dataHoraProcessamento.equals(other.getDataHoraProcessamento()))) &&
            ((this.descricaoExecucao==null && other.getDescricaoExecucao()==null) || 
             (this.descricaoExecucao!=null &&
              this.descricaoExecucao.equals(other.getDescricaoExecucao()))) &&
            this.quantidadeDeArquivo == other.getQuantidadeDeArquivo() &&
            ((this.arquivos==null && other.getArquivos()==null) || 
             (this.arquivos!=null &&
              this.arquivos.equals(other.getArquivos())));
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
        _hashCode += getCodigoExecucao();
        if (getDataHoraProcessamento() != null) {
            _hashCode += getDataHoraProcessamento().hashCode();
        }
        if (getDescricaoExecucao() != null) {
            _hashCode += getDescricaoExecucao().hashCode();
        }
        _hashCode += getQuantidadeDeArquivo();
        if (getArquivos() != null) {
            _hashCode += getArquivos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseObterRecursoAnexo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ResponseObterRecursoAnexo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoExecucao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "CodigoExecucao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataHoraProcessamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "DataHoraProcessamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricaoExecucao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "DescricaoExecucao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidadeDeArquivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "QuantidadeDeArquivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arquivos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Arquivos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ArrayOfResponseArquivo"));
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
