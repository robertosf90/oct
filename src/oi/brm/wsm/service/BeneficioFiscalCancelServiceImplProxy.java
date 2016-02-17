package oi.brm.wsm.service;

public class BeneficioFiscalCancelServiceImplProxy implements oi.brm.wsm.service.BeneficioFiscalCancelServiceImpl {
  private String _endpoint = null;
  private oi.brm.wsm.service.BeneficioFiscalCancelServiceImpl beneficioFiscalCancelServiceImpl = null;
  
  public BeneficioFiscalCancelServiceImplProxy() {
    _initBeneficioFiscalCancelServiceImplProxy();
  }
  
  public BeneficioFiscalCancelServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initBeneficioFiscalCancelServiceImplProxy();
  }
  
  private void _initBeneficioFiscalCancelServiceImplProxy() {
    try {
      beneficioFiscalCancelServiceImpl = (new oi.brm.wsm.service.BeneficioFiscalCancelServiceLocator()).getBeneficioFiscalCancelServiceImplPort();
      if (beneficioFiscalCancelServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)beneficioFiscalCancelServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)beneficioFiscalCancelServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (beneficioFiscalCancelServiceImpl != null)
      ((javax.xml.rpc.Stub)beneficioFiscalCancelServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public oi.brm.wsm.service.BeneficioFiscalCancelServiceImpl getBeneficioFiscalCancelServiceImpl() {
    if (beneficioFiscalCancelServiceImpl == null)
      _initBeneficioFiscalCancelServiceImplProxy();
    return beneficioFiscalCancelServiceImpl;
  }
  
  public oi.brm.wsm.service.BeneficioFiscalCancelFlistOut IG_OP_SCM_BENEFICIO_FISCAL_CANCEL(oi.brm.wsm.service.BeneficioFiscalCancelFlistIn beneficioFiscalCancelInput) throws java.rmi.RemoteException{
    if (beneficioFiscalCancelServiceImpl == null)
      _initBeneficioFiscalCancelServiceImplProxy();
    return beneficioFiscalCancelServiceImpl.IG_OP_SCM_BENEFICIO_FISCAL_CANCEL(beneficioFiscalCancelInput);
  }
  
  
}