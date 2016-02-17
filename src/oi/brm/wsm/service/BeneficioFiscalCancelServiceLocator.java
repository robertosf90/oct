/**
 * BeneficioFiscalCancelServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class BeneficioFiscalCancelServiceLocator extends org.apache.axis.client.Service implements oi.brm.wsm.service.BeneficioFiscalCancelService {

    public BeneficioFiscalCancelServiceLocator() {
    }


    public BeneficioFiscalCancelServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BeneficioFiscalCancelServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BeneficioFiscalCancelServiceImplPort
    
    private java.lang.String BeneficioFiscalCancelServiceImplPort_address = "http://vip-brm-services-batch.oi.infra:80/infranetwebsvc/beneficioFiscalCancel";
    
    //HOMOLOGACAO private java.lang.String BeneficioFiscalCancelServiceImplPort_address = "http://10.145.0.179:80/infranetwebsvc/beneficioFiscalCancel";

    public java.lang.String getBeneficioFiscalCancelServiceImplPortAddress() {
        return BeneficioFiscalCancelServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BeneficioFiscalCancelServiceImplPortWSDDServiceName = "BeneficioFiscalCancelServiceImplPort";

    public java.lang.String getBeneficioFiscalCancelServiceImplPortWSDDServiceName() {
        return BeneficioFiscalCancelServiceImplPortWSDDServiceName;
    }

    public void setBeneficioFiscalCancelServiceImplPortWSDDServiceName(java.lang.String name) {
        BeneficioFiscalCancelServiceImplPortWSDDServiceName = name;
    }

    public oi.brm.wsm.service.BeneficioFiscalCancelServiceImpl getBeneficioFiscalCancelServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BeneficioFiscalCancelServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBeneficioFiscalCancelServiceImplPort(endpoint);
    }

    public oi.brm.wsm.service.BeneficioFiscalCancelServiceImpl getBeneficioFiscalCancelServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            oi.brm.wsm.service.BeneficioFiscalCancelServiceImplPortBindingStub _stub = new oi.brm.wsm.service.BeneficioFiscalCancelServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getBeneficioFiscalCancelServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBeneficioFiscalCancelServiceImplPortEndpointAddress(java.lang.String address) {
        BeneficioFiscalCancelServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (oi.brm.wsm.service.BeneficioFiscalCancelServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                oi.brm.wsm.service.BeneficioFiscalCancelServiceImplPortBindingStub _stub = new oi.brm.wsm.service.BeneficioFiscalCancelServiceImplPortBindingStub(new java.net.URL(BeneficioFiscalCancelServiceImplPort_address), this);
                _stub.setPortName(getBeneficioFiscalCancelServiceImplPortWSDDServiceName());
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
        if ("BeneficioFiscalCancelServiceImplPort".equals(inputPortName)) {
            return getBeneficioFiscalCancelServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalCancelService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalCancelServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BeneficioFiscalCancelServiceImplPort".equals(portName)) {
            setBeneficioFiscalCancelServiceImplPortEndpointAddress(address);
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
