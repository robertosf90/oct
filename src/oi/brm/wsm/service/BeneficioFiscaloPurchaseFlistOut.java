/**
 * BeneficioFiscaloPurchaseFlistOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class BeneficioFiscaloPurchaseFlistOut  implements java.io.Serializable {
    private java.lang.String POID;

    private java.lang.String SERVICE_OBJ;

    private oi.brm.wsm.service.SERVICES_ARRAY_BF_OUT[] SERVICES;

    private oi.brm.wsm.service.PPRODUCTS_ARRAY[] IG_FLD_PURCHASED_PRODUCTS;

    private java.lang.String BILLINFO_OBJ;

    private java.lang.String PAYINFO_OBJ;

    private java.math.BigInteger STATUS_FLAGS;

    private java.lang.String STATUS_MSG;

    public BeneficioFiscaloPurchaseFlistOut() {
    }

    public BeneficioFiscaloPurchaseFlistOut(
           java.lang.String POID,
           java.lang.String SERVICE_OBJ,
           oi.brm.wsm.service.SERVICES_ARRAY_BF_OUT[] SERVICES,
           oi.brm.wsm.service.PPRODUCTS_ARRAY[] IG_FLD_PURCHASED_PRODUCTS,
           java.lang.String BILLINFO_OBJ,
           java.lang.String PAYINFO_OBJ,
           java.math.BigInteger STATUS_FLAGS,
           java.lang.String STATUS_MSG) {
           this.POID = POID;
           this.SERVICE_OBJ = SERVICE_OBJ;
           this.SERVICES = SERVICES;
           this.IG_FLD_PURCHASED_PRODUCTS = IG_FLD_PURCHASED_PRODUCTS;
           this.BILLINFO_OBJ = BILLINFO_OBJ;
           this.PAYINFO_OBJ = PAYINFO_OBJ;
           this.STATUS_FLAGS = STATUS_FLAGS;
           this.STATUS_MSG = STATUS_MSG;
    }


    /**
     * Gets the POID value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @return POID
     */
    public java.lang.String getPOID() {
        return POID;
    }


    /**
     * Sets the POID value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @param POID
     */
    public void setPOID(java.lang.String POID) {
        this.POID = POID;
    }


    /**
     * Gets the SERVICE_OBJ value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @return SERVICE_OBJ
     */
    public java.lang.String getSERVICE_OBJ() {
        return SERVICE_OBJ;
    }


    /**
     * Sets the SERVICE_OBJ value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @param SERVICE_OBJ
     */
    public void setSERVICE_OBJ(java.lang.String SERVICE_OBJ) {
        this.SERVICE_OBJ = SERVICE_OBJ;
    }


    /**
     * Gets the SERVICES value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @return SERVICES
     */
    public oi.brm.wsm.service.SERVICES_ARRAY_BF_OUT[] getSERVICES() {
        return SERVICES;
    }


    /**
     * Sets the SERVICES value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @param SERVICES
     */
    public void setSERVICES(oi.brm.wsm.service.SERVICES_ARRAY_BF_OUT[] SERVICES) {
        this.SERVICES = SERVICES;
    }

    public oi.brm.wsm.service.SERVICES_ARRAY_BF_OUT getSERVICES(int i) {
        return this.SERVICES[i];
    }

    public void setSERVICES(int i, oi.brm.wsm.service.SERVICES_ARRAY_BF_OUT _value) {
        this.SERVICES[i] = _value;
    }


    /**
     * Gets the IG_FLD_PURCHASED_PRODUCTS value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @return IG_FLD_PURCHASED_PRODUCTS
     */
    public oi.brm.wsm.service.PPRODUCTS_ARRAY[] getIG_FLD_PURCHASED_PRODUCTS() {
        return IG_FLD_PURCHASED_PRODUCTS;
    }


    /**
     * Sets the IG_FLD_PURCHASED_PRODUCTS value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @param IG_FLD_PURCHASED_PRODUCTS
     */
    public void setIG_FLD_PURCHASED_PRODUCTS(oi.brm.wsm.service.PPRODUCTS_ARRAY[] IG_FLD_PURCHASED_PRODUCTS) {
        this.IG_FLD_PURCHASED_PRODUCTS = IG_FLD_PURCHASED_PRODUCTS;
    }

    public oi.brm.wsm.service.PPRODUCTS_ARRAY getIG_FLD_PURCHASED_PRODUCTS(int i) {
        return this.IG_FLD_PURCHASED_PRODUCTS[i];
    }

    public void setIG_FLD_PURCHASED_PRODUCTS(int i, oi.brm.wsm.service.PPRODUCTS_ARRAY _value) {
        this.IG_FLD_PURCHASED_PRODUCTS[i] = _value;
    }


    /**
     * Gets the BILLINFO_OBJ value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @return BILLINFO_OBJ
     */
    public java.lang.String getBILLINFO_OBJ() {
        return BILLINFO_OBJ;
    }


    /**
     * Sets the BILLINFO_OBJ value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @param BILLINFO_OBJ
     */
    public void setBILLINFO_OBJ(java.lang.String BILLINFO_OBJ) {
        this.BILLINFO_OBJ = BILLINFO_OBJ;
    }


    /**
     * Gets the PAYINFO_OBJ value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @return PAYINFO_OBJ
     */
    public java.lang.String getPAYINFO_OBJ() {
        return PAYINFO_OBJ;
    }


    /**
     * Sets the PAYINFO_OBJ value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @param PAYINFO_OBJ
     */
    public void setPAYINFO_OBJ(java.lang.String PAYINFO_OBJ) {
        this.PAYINFO_OBJ = PAYINFO_OBJ;
    }


    /**
     * Gets the STATUS_FLAGS value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @return STATUS_FLAGS
     */
    public java.math.BigInteger getSTATUS_FLAGS() {
        return STATUS_FLAGS;
    }


    /**
     * Sets the STATUS_FLAGS value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @param STATUS_FLAGS
     */
    public void setSTATUS_FLAGS(java.math.BigInteger STATUS_FLAGS) {
        this.STATUS_FLAGS = STATUS_FLAGS;
    }


    /**
     * Gets the STATUS_MSG value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @return STATUS_MSG
     */
    public java.lang.String getSTATUS_MSG() {
        return STATUS_MSG;
    }


    /**
     * Sets the STATUS_MSG value for this BeneficioFiscaloPurchaseFlistOut.
     * 
     * @param STATUS_MSG
     */
    public void setSTATUS_MSG(java.lang.String STATUS_MSG) {
        this.STATUS_MSG = STATUS_MSG;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BeneficioFiscaloPurchaseFlistOut)) return false;
        BeneficioFiscaloPurchaseFlistOut other = (BeneficioFiscaloPurchaseFlistOut) obj;
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
            ((this.SERVICE_OBJ==null && other.getSERVICE_OBJ()==null) || 
             (this.SERVICE_OBJ!=null &&
              this.SERVICE_OBJ.equals(other.getSERVICE_OBJ()))) &&
            ((this.SERVICES==null && other.getSERVICES()==null) || 
             (this.SERVICES!=null &&
              java.util.Arrays.equals(this.SERVICES, other.getSERVICES()))) &&
            ((this.IG_FLD_PURCHASED_PRODUCTS==null && other.getIG_FLD_PURCHASED_PRODUCTS()==null) || 
             (this.IG_FLD_PURCHASED_PRODUCTS!=null &&
              java.util.Arrays.equals(this.IG_FLD_PURCHASED_PRODUCTS, other.getIG_FLD_PURCHASED_PRODUCTS()))) &&
            ((this.BILLINFO_OBJ==null && other.getBILLINFO_OBJ()==null) || 
             (this.BILLINFO_OBJ!=null &&
              this.BILLINFO_OBJ.equals(other.getBILLINFO_OBJ()))) &&
            ((this.PAYINFO_OBJ==null && other.getPAYINFO_OBJ()==null) || 
             (this.PAYINFO_OBJ!=null &&
              this.PAYINFO_OBJ.equals(other.getPAYINFO_OBJ()))) &&
            ((this.STATUS_FLAGS==null && other.getSTATUS_FLAGS()==null) || 
             (this.STATUS_FLAGS!=null &&
              this.STATUS_FLAGS.equals(other.getSTATUS_FLAGS()))) &&
            ((this.STATUS_MSG==null && other.getSTATUS_MSG()==null) || 
             (this.STATUS_MSG!=null &&
              this.STATUS_MSG.equals(other.getSTATUS_MSG())));
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
        if (getSERVICE_OBJ() != null) {
            _hashCode += getSERVICE_OBJ().hashCode();
        }
        if (getSERVICES() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSERVICES());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSERVICES(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIG_FLD_PURCHASED_PRODUCTS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIG_FLD_PURCHASED_PRODUCTS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIG_FLD_PURCHASED_PRODUCTS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBILLINFO_OBJ() != null) {
            _hashCode += getBILLINFO_OBJ().hashCode();
        }
        if (getPAYINFO_OBJ() != null) {
            _hashCode += getPAYINFO_OBJ().hashCode();
        }
        if (getSTATUS_FLAGS() != null) {
            _hashCode += getSTATUS_FLAGS().hashCode();
        }
        if (getSTATUS_MSG() != null) {
            _hashCode += getSTATUS_MSG().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BeneficioFiscaloPurchaseFlistOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscaloPurchaseFlistOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "POID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SERVICE_OBJ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SERVICE_OBJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SERVICES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SERVICES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "SERVICES_ARRAY_BF_OUT"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_PURCHASED_PRODUCTS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_PURCHASED_PRODUCTS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "PPRODUCTS_ARRAY"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BILLINFO_OBJ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BILLINFO_OBJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAYINFO_OBJ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PAYINFO_OBJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATUS_FLAGS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATUS_FLAGS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATUS_MSG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATUS_MSG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
