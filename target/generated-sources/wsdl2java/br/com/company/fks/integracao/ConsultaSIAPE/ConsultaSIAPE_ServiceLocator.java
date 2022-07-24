/**
 * ConsultaSIAPE_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ConsultaSIAPE;

public class ConsultaSIAPE_ServiceLocator extends org.apache.axis.client.Service implements ConsultaSIAPE_Service {

    public ConsultaSIAPE_ServiceLocator() {
    }


    public ConsultaSIAPE_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConsultaSIAPE_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ConsultaSIAPEHttpPort
    private java.lang.String ConsultaSIAPEHttpPort_address = "https://www1.siapenet.gov.br/WSSiapenet/services/ConsultaSIAPE";

    public java.lang.String getConsultaSIAPEHttpPortAddress() {
        return ConsultaSIAPEHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConsultaSIAPEHttpPortWSDDServiceName = "ConsultaSIAPEHttpPort";

    public java.lang.String getConsultaSIAPEHttpPortWSDDServiceName() {
        return ConsultaSIAPEHttpPortWSDDServiceName;
    }

    public void setConsultaSIAPEHttpPortWSDDServiceName(java.lang.String name) {
        ConsultaSIAPEHttpPortWSDDServiceName = name;
    }

    public ConsultaSIAPE_PortType getConsultaSIAPEHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConsultaSIAPEHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConsultaSIAPEHttpPort(endpoint);
    }

    public ConsultaSIAPE_PortType getConsultaSIAPEHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ConsultaSIAPEHttpBindingStub _stub = new ConsultaSIAPEHttpBindingStub(portAddress, this);
            _stub.setPortName(getConsultaSIAPEHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConsultaSIAPEHttpPortEndpointAddress(java.lang.String address) {
        ConsultaSIAPEHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ConsultaSIAPE_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ConsultaSIAPEHttpBindingStub _stub = new ConsultaSIAPEHttpBindingStub(new java.net.URL(ConsultaSIAPEHttpPort_address), this);
                _stub.setPortName(getConsultaSIAPEHttpPortWSDDServiceName());
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
        if ("ConsultaSIAPEHttpPort".equals(inputPortName)) {
            return getConsultaSIAPEHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servico.wssiapenet", "ConsultaSIAPE");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servico.wssiapenet", "ConsultaSIAPEHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ConsultaSIAPEHttpPort".equals(portName)) {
            setConsultaSIAPEHttpPortEndpointAddress(address);
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
