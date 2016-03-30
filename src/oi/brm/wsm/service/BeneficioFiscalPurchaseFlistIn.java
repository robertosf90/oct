/**
 * BeneficioFiscalPurchaseFlistIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class BeneficioFiscalPurchaseFlistIn  implements java.io.Serializable {
    private java.lang.String POID;

    private org.apache.axis.types.NonNegativeInteger BUSINESS_TYPE;

    private oi.brm.wsm.service.IG_FLD_CUST_PROFILE_ARRAY IG_FLD_CUST_PROFILE;

    private oi.brm.wsm.service.NAMEINFO_ARRAY NAMEINFO;

    private oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY[] IG_FLD_EMAILS;

    private oi.brm.wsm.service.SERVICES_ARRAY SERVICES;

    private oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY IG_FLD_COBILLING_INFO;

    private java.math.BigInteger IG_FLD_SERVICE1;

    private java.math.BigInteger IG_FLD_SERVICE2;

    public BeneficioFiscalPurchaseFlistIn() {
    }

    public BeneficioFiscalPurchaseFlistIn(
           java.lang.String POID,
           org.apache.axis.types.NonNegativeInteger BUSINESS_TYPE,
           oi.brm.wsm.service.IG_FLD_CUST_PROFILE_ARRAY IG_FLD_CUST_PROFILE,
           oi.brm.wsm.service.NAMEINFO_ARRAY NAMEINFO,
           oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY[] IG_FLD_EMAILS,
           oi.brm.wsm.service.SERVICES_ARRAY SERVICES,
           oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY IG_FLD_COBILLING_INFO,
           java.math.BigInteger IG_FLD_SERVICE1,
           java.math.BigInteger IG_FLD_SERVICE2) {
           this.POID = POID;
           this.BUSINESS_TYPE = BUSINESS_TYPE;
           this.IG_FLD_CUST_PROFILE = IG_FLD_CUST_PROFILE;
           this.NAMEINFO = NAMEINFO;
           this.IG_FLD_EMAILS = IG_FLD_EMAILS;
           this.SERVICES = SERVICES;
           this.IG_FLD_COBILLING_INFO = IG_FLD_COBILLING_INFO;
           this.IG_FLD_SERVICE1 = IG_FLD_SERVICE1;
           this.IG_FLD_SERVICE2 = IG_FLD_SERVICE2;
    }


    /**
     * Gets the POID value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return POID
     */
    public java.lang.String getPOID() {
        return POID;
    }


    /**
     * Sets the POID value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param POID
     */
    public void setPOID(java.lang.String POID) {
        this.POID = POID;
    }


    /**
     * Gets the BUSINESS_TYPE value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return BUSINESS_TYPE
     */
    public org.apache.axis.types.NonNegativeInteger getBUSINESS_TYPE() {
        return BUSINESS_TYPE;
    }


    /**
     * Sets the BUSINESS_TYPE value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param BUSINESS_TYPE
     */
    public void setBUSINESS_TYPE(org.apache.axis.types.NonNegativeInteger BUSINESS_TYPE) {
        this.BUSINESS_TYPE = BUSINESS_TYPE;
    }


    /**
     * Gets the IG_FLD_CUST_PROFILE value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return IG_FLD_CUST_PROFILE
     */
    public oi.brm.wsm.service.IG_FLD_CUST_PROFILE_ARRAY getIG_FLD_CUST_PROFILE() {
        return IG_FLD_CUST_PROFILE;
    }


    /**
     * Sets the IG_FLD_CUST_PROFILE value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param IG_FLD_CUST_PROFILE
     */
    public void setIG_FLD_CUST_PROFILE(oi.brm.wsm.service.IG_FLD_CUST_PROFILE_ARRAY IG_FLD_CUST_PROFILE) {
        this.IG_FLD_CUST_PROFILE = IG_FLD_CUST_PROFILE;
    }


    /**
     * Gets the NAMEINFO value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return NAMEINFO
     */
    public oi.brm.wsm.service.NAMEINFO_ARRAY getNAMEINFO() {
        return NAMEINFO;
    }


    /**
     * Sets the NAMEINFO value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param NAMEINFO
     */
    public void setNAMEINFO(oi.brm.wsm.service.NAMEINFO_ARRAY NAMEINFO) {
        this.NAMEINFO = NAMEINFO;
    }


    /**
     * Gets the IG_FLD_EMAILS value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return IG_FLD_EMAILS
     */
    public oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY[] getIG_FLD_EMAILS() {
        return IG_FLD_EMAILS;
    }


    /**
     * Sets the IG_FLD_EMAILS value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param IG_FLD_EMAILS
     */
    public void setIG_FLD_EMAILS(oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY[] IG_FLD_EMAILS) {
        this.IG_FLD_EMAILS = IG_FLD_EMAILS;
    }

    public oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY getIG_FLD_EMAILS(int i) {
        return this.IG_FLD_EMAILS[i];
    }

    public void setIG_FLD_EMAILS(int i, oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY _value) {
        this.IG_FLD_EMAILS[i] = _value;
    }


    /**
     * Gets the SERVICES value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return SERVICES
     */
    public oi.brm.wsm.service.SERVICES_ARRAY getSERVICES() {
        return SERVICES;
    }


    /**
     * Sets the SERVICES value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param SERVICES
     */
    public void setSERVICES(oi.brm.wsm.service.SERVICES_ARRAY SERVICES) {
        this.SERVICES = SERVICES;
    }


    /**
     * Gets the IG_FLD_COBILLING_INFO value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return IG_FLD_COBILLING_INFO
     */
    public oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY getIG_FLD_COBILLING_INFO() {
        return IG_FLD_COBILLING_INFO;
    }


    /**
     * Sets the IG_FLD_COBILLING_INFO value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param IG_FLD_COBILLING_INFO
     */
    public void setIG_FLD_COBILLING_INFO(oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY IG_FLD_COBILLING_INFO) {
        this.IG_FLD_COBILLING_INFO = IG_FLD_COBILLING_INFO;
    }


    /**
     * Gets the IG_FLD_SERVICE1 value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return IG_FLD_SERVICE1
     */
    public java.math.BigInteger getIG_FLD_SERVICE1() {
        return IG_FLD_SERVICE1;
    }


    /**
     * Sets the IG_FLD_SERVICE1 value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param IG_FLD_SERVICE1
     */
    public void setIG_FLD_SERVICE1(java.math.BigInteger IG_FLD_SERVICE1) {
        this.IG_FLD_SERVICE1 = IG_FLD_SERVICE1;
    }


    /**
     * Gets the IG_FLD_SERVICE2 value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @return IG_FLD_SERVICE2
     */
    public java.math.BigInteger getIG_FLD_SERVICE2() {
        return IG_FLD_SERVICE2;
    }


    /**
     * Sets the IG_FLD_SERVICE2 value for this BeneficioFiscalPurchaseFlistIn.
     * 
     * @param IG_FLD_SERVICE2
     */
    public void setIG_FLD_SERVICE2(java.math.BigInteger IG_FLD_SERVICE2) {
        this.IG_FLD_SERVICE2 = IG_FLD_SERVICE2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BeneficioFiscalPurchaseFlistIn)) return false;
        BeneficioFiscalPurchaseFlistIn other = (BeneficioFiscalPurchaseFlistIn) obj;
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
            ((this.BUSINESS_TYPE==null && other.getBUSINESS_TYPE()==null) || 
             (this.BUSINESS_TYPE!=null &&
              this.BUSINESS_TYPE.equals(other.getBUSINESS_TYPE()))) &&
            ((this.IG_FLD_CUST_PROFILE==null && other.getIG_FLD_CUST_PROFILE()==null) || 
             (this.IG_FLD_CUST_PROFILE!=null &&
              this.IG_FLD_CUST_PROFILE.equals(other.getIG_FLD_CUST_PROFILE()))) &&
            ((this.NAMEINFO==null && other.getNAMEINFO()==null) || 
             (this.NAMEINFO!=null &&
              this.NAMEINFO.equals(other.getNAMEINFO()))) &&
            ((this.IG_FLD_EMAILS==null && other.getIG_FLD_EMAILS()==null) || 
             (this.IG_FLD_EMAILS!=null &&
              java.util.Arrays.equals(this.IG_FLD_EMAILS, other.getIG_FLD_EMAILS()))) &&
            ((this.SERVICES==null && other.getSERVICES()==null) || 
             (this.SERVICES!=null &&
              this.SERVICES.equals(other.getSERVICES()))) &&
            ((this.IG_FLD_COBILLING_INFO==null && other.getIG_FLD_COBILLING_INFO()==null) || 
             (this.IG_FLD_COBILLING_INFO!=null &&
              this.IG_FLD_COBILLING_INFO.equals(other.getIG_FLD_COBILLING_INFO()))) &&
            ((this.IG_FLD_SERVICE1==null && other.getIG_FLD_SERVICE1()==null) || 
             (this.IG_FLD_SERVICE1!=null &&
              this.IG_FLD_SERVICE1.equals(other.getIG_FLD_SERVICE1()))) &&
            ((this.IG_FLD_SERVICE2==null && other.getIG_FLD_SERVICE2()==null) || 
             (this.IG_FLD_SERVICE2!=null &&
              this.IG_FLD_SERVICE2.equals(other.getIG_FLD_SERVICE2())));
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
        if (getBUSINESS_TYPE() != null) {
            _hashCode += getBUSINESS_TYPE().hashCode();
        }
        if (getIG_FLD_CUST_PROFILE() != null) {
            _hashCode += getIG_FLD_CUST_PROFILE().hashCode();
        }
        if (getNAMEINFO() != null) {
            _hashCode += getNAMEINFO().hashCode();
        }
        if (getIG_FLD_EMAILS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIG_FLD_EMAILS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIG_FLD_EMAILS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSERVICES() != null) {
            _hashCode += getSERVICES().hashCode();
        }
        if (getIG_FLD_COBILLING_INFO() != null) {
            _hashCode += getIG_FLD_COBILLING_INFO().hashCode();
        }
        if (getIG_FLD_SERVICE1() != null) {
            _hashCode += getIG_FLD_SERVICE1().hashCode();
        }
        if (getIG_FLD_SERVICE2() != null) {
            _hashCode += getIG_FLD_SERVICE2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BeneficioFiscalPurchaseFlistIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalPurchaseFlistIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "POID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUSINESS_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUSINESS_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_CUST_PROFILE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_CUST_PROFILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "IG_FLD_CUST_PROFILE_ARRAY"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NAMEINFO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NAMEINFO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "NAMEINFO_ARRAY"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_EMAILS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_EMAILS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "IG_FLD_EMAILS_ARRAY"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SERVICES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SERVICES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "SERVICES_ARRAY"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_COBILLING_INFO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_COBILLING_INFO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "PAYINFOIGCOBILLINGARRAY"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_SERVICE1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_SERVICE1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_SERVICE2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_SERVICE2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
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
