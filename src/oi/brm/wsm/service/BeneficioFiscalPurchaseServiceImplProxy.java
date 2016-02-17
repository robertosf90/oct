package oi.brm.wsm.service;

public class BeneficioFiscalPurchaseServiceImplProxy implements oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImpl {
  private String _endpoint = null;
  private oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImpl beneficioFiscalPurchaseServiceImpl = null;
  
  public BeneficioFiscalPurchaseServiceImplProxy() {
    _initBeneficioFiscalPurchaseServiceImplProxy();
  }
  
  public BeneficioFiscalPurchaseServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initBeneficioFiscalPurchaseServiceImplProxy();
  }
  
  private void _initBeneficioFiscalPurchaseServiceImplProxy() {
    try {
      beneficioFiscalPurchaseServiceImpl = (new oi.brm.wsm.service.BeneficioFiscalPurchaseServiceLocator()).getBeneficioFiscalPurchaseServiceImplPort();
      if (beneficioFiscalPurchaseServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)beneficioFiscalPurchaseServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)beneficioFiscalPurchaseServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (beneficioFiscalPurchaseServiceImpl != null)
      ((javax.xml.rpc.Stub)beneficioFiscalPurchaseServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImpl getBeneficioFiscalPurchaseServiceImpl() {
    if (beneficioFiscalPurchaseServiceImpl == null)
      _initBeneficioFiscalPurchaseServiceImplProxy();
    return beneficioFiscalPurchaseServiceImpl;
  }
  
  public oi.brm.wsm.service.BeneficioFiscaloPurchaseFlistOut IG_OP_SCM_BENEFICIO_FISCAL_PURCHASE(oi.brm.wsm.service.BeneficioFiscalPurchaseFlistIn beneficioFiscalPurchaseInput) throws java.rmi.RemoteException{
    if (beneficioFiscalPurchaseServiceImpl == null)
      _initBeneficioFiscalPurchaseServiceImplProxy();
    return beneficioFiscalPurchaseServiceImpl.IG_OP_SCM_BENEFICIO_FISCAL_PURCHASE(beneficioFiscalPurchaseInput);
  }
  
  
}