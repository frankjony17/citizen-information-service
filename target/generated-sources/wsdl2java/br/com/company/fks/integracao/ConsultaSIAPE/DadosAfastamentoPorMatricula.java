/**
 * DadosAfastamentoPorMatricula.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class DadosAfastamentoPorMatricula  implements java.io.Serializable {
    private ArrayOfDadosFerias ferias;

    private java.lang.String grMatricula;

    private ArrayOfDadosLpa lpa;

    private ArrayOfDadosOcorrencias ocorrencias;

    private ArrayOfDadosReclusao reclusao;

    public DadosAfastamentoPorMatricula() {
    }

    public DadosAfastamentoPorMatricula(
           ArrayOfDadosFerias ferias,
           java.lang.String grMatricula,
           ArrayOfDadosLpa lpa,
           ArrayOfDadosOcorrencias ocorrencias,
           ArrayOfDadosReclusao reclusao) {
           this.ferias = ferias;
           this.grMatricula = grMatricula;
           this.lpa = lpa;
           this.ocorrencias = ocorrencias;
           this.reclusao = reclusao;
    }


    /**
     * Gets the ferias value for this DadosAfastamentoPorMatricula.
     * 
     * @return ferias
     */
    public ArrayOfDadosFerias getFerias() {
        return ferias;
    }


    /**
     * Sets the ferias value for this DadosAfastamentoPorMatricula.
     * 
     * @param ferias
     */
    public void setFerias(ArrayOfDadosFerias ferias) {
        this.ferias = ferias;
    }


    /**
     * Gets the grMatricula value for this DadosAfastamentoPorMatricula.
     * 
     * @return grMatricula
     */
    public java.lang.String getGrMatricula() {
        return grMatricula;
    }


    /**
     * Sets the grMatricula value for this DadosAfastamentoPorMatricula.
     * 
     * @param grMatricula
     */
    public void setGrMatricula(java.lang.String grMatricula) {
        this.grMatricula = grMatricula;
    }


    /**
     * Gets the lpa value for this DadosAfastamentoPorMatricula.
     * 
     * @return lpa
     */
    public ArrayOfDadosLpa getLpa() {
        return lpa;
    }


    /**
     * Sets the lpa value for this DadosAfastamentoPorMatricula.
     * 
     * @param lpa
     */
    public void setLpa(ArrayOfDadosLpa lpa) {
        this.lpa = lpa;
    }


    /**
     * Gets the ocorrencias value for this DadosAfastamentoPorMatricula.
     * 
     * @return ocorrencias
     */
    public ArrayOfDadosOcorrencias getOcorrencias() {
        return ocorrencias;
    }


    /**
     * Sets the ocorrencias value for this DadosAfastamentoPorMatricula.
     * 
     * @param ocorrencias
     */
    public void setOcorrencias(ArrayOfDadosOcorrencias ocorrencias) {
        this.ocorrencias = ocorrencias;
    }


    /**
     * Gets the reclusao value for this DadosAfastamentoPorMatricula.
     * 
     * @return reclusao
     */
    public ArrayOfDadosReclusao getReclusao() {
        return reclusao;
    }


    /**
     * Sets the reclusao value for this DadosAfastamentoPorMatricula.
     * 
     * @param reclusao
     */
    public void setReclusao(ArrayOfDadosReclusao reclusao) {
        this.reclusao = reclusao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DadosAfastamentoPorMatricula)) return false;
        DadosAfastamentoPorMatricula other = (DadosAfastamentoPorMatricula) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ferias==null && other.getFerias()==null) || 
             (this.ferias!=null &&
              this.ferias.equals(other.getFerias()))) &&
            ((this.grMatricula==null && other.getGrMatricula()==null) || 
             (this.grMatricula!=null &&
              this.grMatricula.equals(other.getGrMatricula()))) &&
            ((this.lpa==null && other.getLpa()==null) || 
             (this.lpa!=null &&
              this.lpa.equals(other.getLpa()))) &&
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
        if (getFerias() != null) {
            _hashCode += getFerias().hashCode();
        }
        if (getGrMatricula() != null) {
            _hashCode += getGrMatricula().hashCode();
        }
        if (getLpa() != null) {
            _hashCode += getLpa().hashCode();
        }
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
        new org.apache.axis.description.TypeDesc(DadosAfastamentoPorMatricula.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "DadosAfastamentoPorMatricula"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ferias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ferias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosFerias"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grMatricula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "grMatricula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lpa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "lpa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tipo.servico.wssiapenet", "ArrayOfDadosLpa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
