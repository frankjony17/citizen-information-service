/**
 * Curso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class Curso  implements java.io.Serializable {
    private Area area;

    private java.lang.Short cargaHoraria;

    private java.lang.Integer codCurso;

    private java.lang.String dataConclusao;

    private java.lang.String instituicao;

    private java.lang.String nomeCurso;

    private TipoEvento tipoEvento;

    public Curso() {
    }

    public Curso(
           Area area,
           java.lang.Short cargaHoraria,
           java.lang.Integer codCurso,
           java.lang.String dataConclusao,
           java.lang.String instituicao,
           java.lang.String nomeCurso,
           TipoEvento tipoEvento) {
           this.area = area;
           this.cargaHoraria = cargaHoraria;
           this.codCurso = codCurso;
           this.dataConclusao = dataConclusao;
           this.instituicao = instituicao;
           this.nomeCurso = nomeCurso;
           this.tipoEvento = tipoEvento;
    }


    /**
     * Gets the area value for this Curso.
     * 
     * @return area
     */
    public Area getArea() {
        return area;
    }


    /**
     * Sets the area value for this Curso.
     * 
     * @param area
     */
    public void setArea(Area area) {
        this.area = area;
    }


    /**
     * Gets the cargaHoraria value for this Curso.
     * 
     * @return cargaHoraria
     */
    public java.lang.Short getCargaHoraria() {
        return cargaHoraria;
    }


    /**
     * Sets the cargaHoraria value for this Curso.
     * 
     * @param cargaHoraria
     */
    public void setCargaHoraria(java.lang.Short cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }


    /**
     * Gets the codCurso value for this Curso.
     * 
     * @return codCurso
     */
    public java.lang.Integer getCodCurso() {
        return codCurso;
    }


    /**
     * Sets the codCurso value for this Curso.
     * 
     * @param codCurso
     */
    public void setCodCurso(java.lang.Integer codCurso) {
        this.codCurso = codCurso;
    }


    /**
     * Gets the dataConclusao value for this Curso.
     * 
     * @return dataConclusao
     */
    public java.lang.String getDataConclusao() {
        return dataConclusao;
    }


    /**
     * Sets the dataConclusao value for this Curso.
     * 
     * @param dataConclusao
     */
    public void setDataConclusao(java.lang.String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }


    /**
     * Gets the instituicao value for this Curso.
     * 
     * @return instituicao
     */
    public java.lang.String getInstituicao() {
        return instituicao;
    }


    /**
     * Sets the instituicao value for this Curso.
     * 
     * @param instituicao
     */
    public void setInstituicao(java.lang.String instituicao) {
        this.instituicao = instituicao;
    }


    /**
     * Gets the nomeCurso value for this Curso.
     * 
     * @return nomeCurso
     */
    public java.lang.String getNomeCurso() {
        return nomeCurso;
    }


    /**
     * Sets the nomeCurso value for this Curso.
     * 
     * @param nomeCurso
     */
    public void setNomeCurso(java.lang.String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }


    /**
     * Gets the tipoEvento value for this Curso.
     * 
     * @return tipoEvento
     */
    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }


    /**
     * Sets the tipoEvento value for this Curso.
     * 
     * @param tipoEvento
     */
    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Curso)) return false;
        Curso other = (Curso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.cargaHoraria==null && other.getCargaHoraria()==null) || 
             (this.cargaHoraria!=null &&
              this.cargaHoraria.equals(other.getCargaHoraria()))) &&
            ((this.codCurso==null && other.getCodCurso()==null) || 
             (this.codCurso!=null &&
              this.codCurso.equals(other.getCodCurso()))) &&
            ((this.dataConclusao==null && other.getDataConclusao()==null) || 
             (this.dataConclusao!=null &&
              this.dataConclusao.equals(other.getDataConclusao()))) &&
            ((this.instituicao==null && other.getInstituicao()==null) || 
             (this.instituicao!=null &&
              this.instituicao.equals(other.getInstituicao()))) &&
            ((this.nomeCurso==null && other.getNomeCurso()==null) || 
             (this.nomeCurso!=null &&
              this.nomeCurso.equals(other.getNomeCurso()))) &&
            ((this.tipoEvento==null && other.getTipoEvento()==null) || 
             (this.tipoEvento!=null &&
              this.tipoEvento.equals(other.getTipoEvento())));
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
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getCargaHoraria() != null) {
            _hashCode += getCargaHoraria().hashCode();
        }
        if (getCodCurso() != null) {
            _hashCode += getCodCurso().hashCode();
        }
        if (getDataConclusao() != null) {
            _hashCode += getDataConclusao().hashCode();
        }
        if (getInstituicao() != null) {
            _hashCode += getInstituicao().hashCode();
        }
        if (getNomeCurso() != null) {
            _hashCode += getNomeCurso().hashCode();
        }
        if (getTipoEvento() != null) {
            _hashCode += getTipoEvento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Curso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Curso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "Area"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargaHoraria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "cargaHoraria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "codCurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataConclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "dataConclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instituicao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "instituicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeCurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "nomeCurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entidade.wssiapenet", "tipoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entidade.wssiapenet", "TipoEvento"));
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
