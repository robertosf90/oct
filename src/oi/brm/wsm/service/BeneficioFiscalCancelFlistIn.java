/**
 * BeneficioFiscalCancelFlistIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class BeneficioFiscalCancelFlistIn  implements java.io.Serializable {
    private java.lang.String POID;

    private java.lang.String IG_FLD_CPF_CNPJ;

    private oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY IG_FLD_COBILLING_INFO;

    public BeneficioFiscalCancelFlistIn() {
    }

    public BeneficioFiscalCancelFlistIn(
           java.lang.String POID,
           java.lang.String IG_FLD_CPF_CNPJ,
           oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY IG_FLD_COBILLING_INFO) {
           this.POID = POID;
           this.IG_FLD_CPF_CNPJ = IG_FLD_CPF_CNPJ;
           this.IG_FLD_COBILLING_INFO = IG_FLD_COBILLING_INFO;
    }


    /**
     * Gets the POID value for this BeneficioFiscalCancelFlistIn.
     * 
     * @return POID
     */
    public java.lang.String getPOID() {
        return POID;
    }


    /**
     * Sets the POID value for this BeneficioFiscalCancelFlistIn.
     * 
     * @param POID
     */
    public void setPOID(java.lang.String POID) {
        this.POID = POID;
    }


    /**
     * Gets the IG_FLD_CPF_CNPJ value for this BeneficioFiscalCancelFlistIn.
     * 
     * @return IG_FLD_CPF_CNPJ
     */
    public java.lang.String getIG_FLD_CPF_CNPJ() {
        return IG_FLD_CPF_CNPJ;
    }


    /**
     * Sets the IG_FLD_CPF_CNPJ value for this BeneficioFiscalCancelFlistIn.
     * 
     * @param IG_FLD_CPF_CNPJ
     */
    public void setIG_FLD_CPF_CNPJ(java.lang.String IG_FLD_CPF_CNPJ) {
        this.IG_FLD_CPF_CNPJ = IG_FLD_CPF_CNPJ;
    }


    /**
     * Gets the IG_FLD_COBILLING_INFO value for this BeneficioFiscalCancelFlistIn.
     * 
     * @return IG_FLD_COBILLING_INFO
     */
    public oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY getIG_FLD_COBILLING_INFO() {
        return IG_FLD_COBILLING_INFO;
    }


    /**
     * Sets the IG_FLD_COBILLING_INFO value for this BeneficioFiscalCancelFlistIn.
     * 
     * @param IG_FLD_COBILLING_INFO
     */
    public void setIG_FLD_COBILLING_INFO(oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY IG_FLD_COBILLING_INFO) {
        this.IG_FLD_COBILLING_INFO = IG_FLD_COBILLING_INFO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BeneficioFiscalCancelFlistIn)) return false;
        BeneficioFiscalCancelFlistIn other = (BeneficioFiscalCancelFlistIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.POID==null && other.getPOID()==null) || 
             (this.POID!=null &&
              this.POID.equals(other.getPOID()))) &&
            ((this.IG_FLD_CPF_CNPJ==null && other.getIG_FLD_CPF_CNPJ()==null) || 
             (this.IG_FLD_CPF_CNPJ!=null &&
              this.IG_FLD_CPF_CNPJ.equals(other.getIG_FLD_CPF_CNPJ()))) &&
            ((this.IG_FLD_COBILLING_INFO==null && other.getIG_FLD_COBILLING_INFO()==null) || 
             (this.IG_FLD_COBILLING_INFO!=null &&
              this.IG_FLD_COBILLING_INFO.equals(other.getIG_FLD_COBILLING_INFO())));
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
        if (getPOID() != null) {
            _hashCode += getPOID().hashCode();
        }
        if (getIG_FLD_CPF_CNPJ() != null) {
            _hashCode += getIG_FLD_CPF_CNPJ().hashCode();
        }
        if (getIG_FLD_COBILLING_INFO() != null) {
            _hashCode += getIG_FLD_COBILLING_INFO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BeneficioFiscalCancelFlistIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalCancelFlistIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "POID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_CPF_CNPJ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_CPF_CNPJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_COBILLING_INFO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_COBILLING_INFO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "PAYINFOIGCOBILLINGARRAY"));
        elemField.setNillable(false);
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
