/**
 * ResponseObterRecurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ServicoConsultaRecurso;

public class ResponseObterRecurso  implements java.io.Serializable {
    private int codigoExecucao;

    private java.util.Calendar dataHoraProcessamento;

    private ArrayOfResponseRecurso recursos;

    public ResponseObterRecurso() {
    }

    public ResponseObterRecurso(
           int codigoExecucao,
           java.util.Calendar dataHoraProcessamento,
           ArrayOfResponseRecurso recursos) {
           this.codigoExecucao = codigoExecucao;
           this.dataHoraProcessamento = dataHoraProcessamento;
           this.recursos = recursos;
    }


    /**
     * Gets the codigoExecucao value for this ResponseObterRecurso.
     * 
     * @return codigoExecucao
     */
    public int getCodigoExecucao() {
        return codigoExecucao;
    }


    /**
     * Sets the codigoExecucao value for this ResponseObterRecurso.
     * 
     * @param codigoExecucao
     */
    public void setCodigoExecucao(int codigoExecucao) {
        this.codigoExecucao = codigoExecucao;
    }


    /**
     * Gets the dataHoraProcessamento value for this ResponseObterRecurso.
     * 
     * @return dataHoraProcessamento
     */
    public java.util.Calendar getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }


    /**
     * Sets the dataHoraProcessamento value for this ResponseObterRecurso.
     * 
     * @param dataHoraProcessamento
     */
    public void setDataHoraProcessamento(java.util.Calendar dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }


    /**
     * Gets the recursos value for this ResponseObterRecurso.
     * 
     * @return recursos
     */
    public ArrayOfResponseRecurso getRecursos() {
        return recursos;
    }


    /**
     * Sets the recursos value for this ResponseObterRecurso.
     * 
     * @param recursos
     */
    public void setRecursos(ArrayOfResponseRecurso recursos) {
        this.recursos = recursos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseObterRecurso)) return false;
        ResponseObterRecurso other = (ResponseObterRecurso) obj;
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
            ((this.recursos==null && other.getRecursos()==null) || 
             (this.recursos!=null &&
              this.recursos.equals(other.getRecursos())));
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
        if (getRecursos() != null) {
            _hashCode += getRecursos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseObterRecurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ResponseObterRecurso"));
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
        elemField.setFieldName("recursos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "Recursos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ArrayOfResponseRecurso"));
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
