/**
 * BeneficioFiscalCancelFlistOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class BeneficioFiscalCancelFlistOut  implements java.io.Serializable {
    private java.lang.String POID;

    private java.math.BigInteger STATUS_FLAGS;

    private java.lang.String STATUS_MSG;

    public BeneficioFiscalCancelFlistOut() {
    }

    public BeneficioFiscalCancelFlistOut(
           java.lang.String POID,
           java.math.BigInteger STATUS_FLAGS,
           java.lang.String STATUS_MSG) {
           this.POID = POID;
           this.STATUS_FLAGS = STATUS_FLAGS;
           this.STATUS_MSG = STATUS_MSG;
    }


    /**
     * Gets the POID value for this BeneficioFiscalCancelFlistOut.
     * 
     * @return POID
     */
    public java.lang.String getPOID() {
        return POID;
    }


    /**
     * Sets the POID value for this BeneficioFiscalCancelFlistOut.
     * 
     * @param POID
     */
    public void setPOID(java.lang.String POID) {
        this.POID = POID;
    }


    /**
     * Gets the STATUS_FLAGS value for this BeneficioFiscalCancelFlistOut.
     * 
     * @return STATUS_FLAGS
     */
    public java.math.BigInteger getSTATUS_FLAGS() {
        return STATUS_FLAGS;
    }


    /**
     * Sets the STATUS_FLAGS value for this BeneficioFiscalCancelFlistOut.
     * 
     * @param STATUS_FLAGS
     */
    public void setSTATUS_FLAGS(java.math.BigInteger STATUS_FLAGS) {
        this.STATUS_FLAGS = STATUS_FLAGS;
    }


    /**
     * Gets the STATUS_MSG value for this BeneficioFiscalCancelFlistOut.
     * 
     * @return STATUS_MSG
     */
    public java.lang.String getSTATUS_MSG() {
        return STATUS_MSG;
    }


    /**
     * Sets the STATUS_MSG value for this BeneficioFiscalCancelFlistOut.
     * 
     * @param STATUS_MSG
     */
    public void setSTATUS_MSG(java.lang.String STATUS_MSG) {
        this.STATUS_MSG = STATUS_MSG;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BeneficioFiscalCancelFlistOut)) return false;
        BeneficioFiscalCancelFlistOut other = (BeneficioFiscalCancelFlistOut) obj;
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
        new org.apache.axis.description.TypeDesc(BeneficioFiscalCancelFlistOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "BeneficioFiscalCancelFlistOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "POID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
