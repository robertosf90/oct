/**
 * SERVICES_ARRAY.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class SERVICES_ARRAY  implements java.io.Serializable {
    private java.lang.String PASSWD_CLEAR;

    private java.lang.String LOGIN;

    public SERVICES_ARRAY() {
    }

    public SERVICES_ARRAY(
           java.lang.String PASSWD_CLEAR,
           java.lang.String LOGIN) {
           this.PASSWD_CLEAR = PASSWD_CLEAR;
           this.LOGIN = LOGIN;
    }


    /**
     * Gets the PASSWD_CLEAR value for this SERVICES_ARRAY.
     * 
     * @return PASSWD_CLEAR
     */
    public java.lang.String getPASSWD_CLEAR() {
        return PASSWD_CLEAR;
    }


    /**
     * Sets the PASSWD_CLEAR value for this SERVICES_ARRAY.
     * 
     * @param PASSWD_CLEAR
     */
    public void setPASSWD_CLEAR(java.lang.String PASSWD_CLEAR) {
        this.PASSWD_CLEAR = PASSWD_CLEAR;
    }


    /**
     * Gets the LOGIN value for this SERVICES_ARRAY.
     * 
     * @return LOGIN
     */
    public java.lang.String getLOGIN() {
        return LOGIN;
    }


    /**
     * Sets the LOGIN value for this SERVICES_ARRAY.
     * 
     * @param LOGIN
     */
    public void setLOGIN(java.lang.String LOGIN) {
        this.LOGIN = LOGIN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SERVICES_ARRAY)) return false;
        SERVICES_ARRAY other = (SERVICES_ARRAY) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PASSWD_CLEAR==null && other.getPASSWD_CLEAR()==null) || 
             (this.PASSWD_CLEAR!=null &&
              this.PASSWD_CLEAR.equals(other.getPASSWD_CLEAR()))) &&
            ((this.LOGIN==null && other.getLOGIN()==null) || 
             (this.LOGIN!=null &&
              this.LOGIN.equals(other.getLOGIN())));
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
        if (getPASSWD_CLEAR() != null) {
            _hashCode += getPASSWD_CLEAR().hashCode();
        }
        if (getLOGIN() != null) {
            _hashCode += getLOGIN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SERVICES_ARRAY.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "SERVICES_ARRAY"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PASSWD_CLEAR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PASSWD_CLEAR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGIN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGIN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
