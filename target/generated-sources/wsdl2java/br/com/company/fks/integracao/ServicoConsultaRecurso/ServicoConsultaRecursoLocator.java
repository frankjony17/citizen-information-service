/**
 * ServicoConsultaRecursoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ServicoConsultaRecurso;

public class ServicoConsultaRecursoLocator extends org.apache.axis.client.Service implements ServicoConsultaRecurso {

    public ServicoConsultaRecursoLocator() {
    }


    public ServicoConsultaRecursoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoConsultaRecursoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoConsultaRecursoSoap
    private java.lang.String ServicoConsultaRecursoSoap_address = "http://www.acessoainformacao.gov.br/sistema/servicos/ServicoConsultaRecurso.asmx";

    public java.lang.String getServicoConsultaRecursoSoapAddress() {
        return ServicoConsultaRecursoSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoConsultaRecursoSoapWSDDServiceName = "ServicoConsultaRecursoSoap";

    public java.lang.String getServicoConsultaRecursoSoapWSDDServiceName() {
        return ServicoConsultaRecursoSoapWSDDServiceName;
    }

    public void setServicoConsultaRecursoSoapWSDDServiceName(java.lang.String name) {
        ServicoConsultaRecursoSoapWSDDServiceName = name;
    }

    public ServicoConsultaRecursoSoap_PortType getServicoConsultaRecursoSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoConsultaRecursoSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoConsultaRecursoSoap(endpoint);
    }

    public ServicoConsultaRecursoSoap_PortType getServicoConsultaRecursoSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ServicoConsultaRecursoSoap_BindingStub _stub = new ServicoConsultaRecursoSoap_BindingStub(portAddress, this);
            _stub.setPortName(getServicoConsultaRecursoSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoConsultaRecursoSoapEndpointAddress(java.lang.String address) {
        ServicoConsultaRecursoSoap_address = address;
    }


    // Use to get a proxy class for ServicoConsultaRecursoSoap12
    private java.lang.String ServicoConsultaRecursoSoap12_address = "http://www.acessoainformacao.gov.br/sistema/servicos/ServicoConsultaRecurso.asmx";

    public java.lang.String getServicoConsultaRecursoSoap12Address() {
        return ServicoConsultaRecursoSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoConsultaRecursoSoap12WSDDServiceName = "ServicoConsultaRecursoSoap12";

    public java.lang.String getServicoConsultaRecursoSoap12WSDDServiceName() {
        return ServicoConsultaRecursoSoap12WSDDServiceName;
    }

    public void setServicoConsultaRecursoSoap12WSDDServiceName(java.lang.String name) {
        ServicoConsultaRecursoSoap12WSDDServiceName = name;
    }

    public ServicoConsultaRecursoSoap_PortType getServicoConsultaRecursoSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoConsultaRecursoSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoConsultaRecursoSoap12(endpoint);
    }

    public ServicoConsultaRecursoSoap_PortType getServicoConsultaRecursoSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ServicoConsultaRecursoSoap12Stub _stub = new ServicoConsultaRecursoSoap12Stub(portAddress, this);
            _stub.setPortName(getServicoConsultaRecursoSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoConsultaRecursoSoap12EndpointAddress(java.lang.String address) {
        ServicoConsultaRecursoSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ServicoConsultaRecursoSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ServicoConsultaRecursoSoap_BindingStub _stub = new ServicoConsultaRecursoSoap_BindingStub(new java.net.URL(ServicoConsultaRecursoSoap_address), this);
                _stub.setPortName(getServicoConsultaRecursoSoapWSDDServiceName());
                return _stub;
            }
            if (ServicoConsultaRecursoSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ServicoConsultaRecursoSoap12Stub _stub = new ServicoConsultaRecursoSoap12Stub(new java.net.URL(ServicoConsultaRecursoSoap12_address), this);
                _stub.setPortName(getServicoConsultaRecursoSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicoConsultaRecursoSoap".equals(inputPortName)) {
            return getServicoConsultaRecursoSoap();
        }
        else if ("ServicoConsultaRecursoSoap12".equals(inputPortName)) {
            return getServicoConsultaRecursoSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ServicoConsultaRecurso");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ServicoConsultaRecursoSoap"));
            ports.add(new javax.xml.namespace.QName("http://acessoainformacao.gov.br", "ServicoConsultaRecursoSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoConsultaRecursoSoap".equals(portName)) {
            setServicoConsultaRecursoSoapEndpointAddress(address);
        }
        else 
if ("ServicoConsultaRecursoSoap12".equals(portName)) {
            setServicoConsultaRecursoSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
