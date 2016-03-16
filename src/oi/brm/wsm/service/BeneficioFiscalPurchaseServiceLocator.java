/**
 * BeneficioFiscalPurchaseServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class BeneficioFiscalPurchaseServiceLocator extends org.apache.axis.client.Service implements oi.brm.wsm.service.BeneficioFiscalPurchaseService {

    public BeneficioFiscalPurchaseServiceLocator() {
    }


    public BeneficioFiscalPurchaseServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BeneficioFiscalPurchaseServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BeneficioFiscalPurchaseServiceImplPort
    private java.lang.String BeneficioFiscalPurchaseServiceImplPort_address = "http://hanoi-brm-services-oct.dev.infra:80/infranetwebsvc/beneficioFiscalPurchase";
    // HOMOLOGACAO private java.lang.String BeneficioFiscalPurchaseServiceImplPort_address = "http://10.145.0.179:80/infranetwebsvc/beneficioFiscalPurchase";
    

    public java.lang.String getBeneficioFiscalPurchaseServiceImplPortAddress() {
        return BeneficioFiscalPurchaseServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BeneficioFiscalPurchaseServiceImplPortWSDDServiceName = "BeneficioFiscalPurchaseServiceImplPort";

    public java.lang.String getBeneficioFiscalPurchaseServiceImplPortWSDDServiceName() {
        return BeneficioFiscalPurchaseServiceImplPortWSDDServiceName;
    }

    public void setBeneficioFiscalPurchaseServiceImplPortWSDDServiceName(java.lang.String name) {
        BeneficioFiscalPurchaseServiceImplPortWSDDServiceName = name;
    }

    public oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImpl getBeneficioFiscalPurchaseServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BeneficioFiscalPurchaseServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBeneficioFiscalPurchaseServiceImplPort(endpoint);
    }

    public oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImpl getBeneficioFiscalPurchaseServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImplPortBindingStub _stub = new oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getBeneficioFiscalPurchaseServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBeneficioFiscalPurchaseServiceImplPortEndpointAddress(java.lang.String address) {
        BeneficioFiscalPurchaseServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImplPortBindingStub _stub = new oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImplPortBindingStub(new java.net.URL(BeneficioFiscalPurchaseServiceImplPort_address), this);
                _stub.setPortName(getBeneficioFiscalPurchaseServiceImplPortWSDDServiceName());
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
        if ("BeneficioFiscalPurchaseServiceImplPort".equals(inputPortName)) {
            return getBeneficioFiscalPurchaseServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalPurchaseService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalPurchaseServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BeneficioFiscalPurchaseServiceImplPort".equals(portName)) {
            setBeneficioFiscalPurchaseServiceImplPortEndpointAddress(address);
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
