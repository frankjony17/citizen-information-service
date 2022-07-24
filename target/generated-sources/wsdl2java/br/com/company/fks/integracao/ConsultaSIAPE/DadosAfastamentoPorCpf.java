/**
 * DadosAfastamentoPorCpf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosAfastamentoPorCpf  implements java.io.Serializable {
    private ArrayOfDadosOcorrencias ocorrencias;

    private ArrayOfDadosReclusao reclusao;

    public DadosAfastamentoPorCpf() {
    }

    public DadosAfastamentoPorCpf(
           ArrayOfDadosOcorrencias ocorrencias,
           ArrayOfDadosReclusao reclusao) {
           this.ocorrencias = ocorrencias;
           this.reclusao = reclusao;
    }


    /**
     * Gets the ocorrencias value for this DadosAfastamentoPorCpf.
     * 
     * @return ocorrencias
     */
    public ArrayOfDadosOcorrencias getOcorrencias() {
        return ocorrencias;
    }


    /**
     * Sets the ocorrencias value for this DadosAfastamentoPorCpf.
     * 
     * @param ocorrencias
     */
    public void setOcorrencias(ArrayOfDadosOcorrencias ocorrencias) {
        this.ocorrencias = ocorrencias;
    }


    /**
     * Gets the reclusao value for this DadosAfastamentoPorCpf.
     * 
     * @return reclusao
     */
    public ArrayOfDadosReclusao getReclusao() {
        return reclusao;
    }


    /**
     * Sets the reclusao value for this DadosAfastamentoPorCpf.
     * 
     * @param reclusao
     */
    public void setReclusao(ArrayOfDadosReclusao reclusao) {
        this.reclusao = reclusao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosAfastamentoPorCpf)) return false;
        DadosAfastamentoPorCpf other = (DadosAfastamentoPorCpf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ocorrencias==null && other.getOcorrencias()==null) || 
             (this.ocorrencias!=null &&
              this.ocorrencias.equals(other.getOcorrencias()))) &&
            ((this.reclusao==null && other.getReclusao()==null) || 
             (this.reclusao!=null &&
              this.reclusao.equals(other.getReclusao())));
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
        if (getOcorrencias() != null) {
            _hashCode += getOcorrencias().hashCode();
        }
        if (getReclusao() != null) {
            _hashCode += getReclusao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DadosAfastamentoPorCpf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosAfastamentoPorCpf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ocorrencias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ocorrencias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosOcorrencias"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "reclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosReclusao"));
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
