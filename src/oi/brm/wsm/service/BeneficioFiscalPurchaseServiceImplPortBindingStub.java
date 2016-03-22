/**
 * BeneficioFiscalPurchaseServiceImplPortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;


public class BeneficioFiscalPurchaseServiceImplPortBindingStub extends org.apache.axis.client.Stub implements
        oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImpl {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc[] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[1];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1() {
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IG_OP_SCM_BENEFICIO_FISCAL_PURCHASE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("",
                "beneficioFiscalPurchaseInput"), org.apache.axis.description.ParameterDesc.IN,
                new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalPurchaseFlistIn"),
                oi.brm.wsm.service.BeneficioFiscalPurchaseFlistIn.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/",
                "BeneficioFiscaloPurchaseFlistOut"));
        oper.setReturnClass(oi.brm.wsm.service.BeneficioFiscaloPurchaseFlistOut.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "beneficioFiscalPurchaseOutput"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

    }

    public BeneficioFiscalPurchaseServiceImplPortBindingStub() throws org.apache.axis.AxisFault {
        this(null);
    }

    public BeneficioFiscalPurchaseServiceImplPortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service)
            throws org.apache.axis.AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
    }

    public BeneficioFiscalPurchaseServiceImplPortBindingStub(javax.xml.rpc.Service service)
            throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service) super.service).setTypeMappingVersion("1.2");
        java.lang.Class cls;
        javax.xml.namespace.QName qName;
        javax.xml.namespace.QName qName2;
        java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
        java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
        java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
        java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
        java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
        java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
        java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
        java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
        java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
        java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscaloPurchaseFlistOut");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.BeneficioFiscaloPurchaseFlistOut.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalPurchaseFlistIn");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.BeneficioFiscalPurchaseFlistIn.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "IG_FLD_CUST_PROFILE_ARRAY");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.IG_FLD_CUST_PROFILE_ARRAY.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "IG_FLD_EMAILS_ARRAY");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "NAMEINFO_ARRAY");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.NAMEINFO_ARRAY.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "PAYINFOIGCOBILLINGARRAY");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "PHONES_ARRAY");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.PHONES_ARRAY.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "PPRODUCTS_ARRAY");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.PPRODUCTS_ARRAY.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "SERVICES_ARRAY");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.SERVICES_ARRAY.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "SERVICES_ARRAY_BF_OUT");
        cachedSerQNames.add(qName);
        cls = oi.brm.wsm.service.SERVICES_ARRAY_BF_OUT.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class) cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class) cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        } else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
                                    .get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
                                    .get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        } catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public oi.brm.wsm.service.BeneficioFiscaloPurchaseFlistOut IG_OP_SCM_BENEFICIO_FISCAL_PURCHASE(
            oi.brm.wsm.service.BeneficioFiscalPurchaseFlistIn beneficioFiscalPurchaseInput)
            throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.wsm.brm.ig/",
                "IG_OP_SCM_BENEFICIO_FISCAL_PURCHASE"));

        setRequestHeaders(_call);
        setAttachments(_call);

        try {
            java.lang.Object _resp = _call.invoke(new java.lang.Object[] { beneficioFiscalPurchaseInput });

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return (oi.brm.wsm.service.BeneficioFiscaloPurchaseFlistOut) _resp;
                } catch (java.lang.Exception _exception) {
                    return (oi.brm.wsm.service.BeneficioFiscaloPurchaseFlistOut) org.apache.axis.utils.JavaUtils
                            .convert(_resp, oi.brm.wsm.service.BeneficioFiscaloPurchaseFlistOut.class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

}
