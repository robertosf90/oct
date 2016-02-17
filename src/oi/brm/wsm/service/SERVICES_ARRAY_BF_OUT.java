/**
 * SERVICES_ARRAY_BF_OUT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class SERVICES_ARRAY_BF_OUT  implements java.io.Serializable {
    private java.lang.String POID;

    private org.apache.axis.types.NonNegativeInteger elem;  // attribute

    public SERVICES_ARRAY_BF_OUT() {
    }

    public SERVICES_ARRAY_BF_OUT(
           java.lang.String POID,
           org.apache.axis.types.NonNegativeInteger elem) {
           this.POID = POID;
           this.elem = elem;
    }


    /**
     * Gets the POID value for this SERVICES_ARRAY_BF_OUT.
     * 
     * @return POID
     */
    public java.lang.String getPOID() {
        return POID;
    }


    /**
     * Sets the POID value for this SERVICES_ARRAY_BF_OUT.
     * 
     * @param POID
     */
    public void setPOID(java.lang.String POID) {
        this.POID = POID;
    }


    /**
     * Gets the elem value for this SERVICES_ARRAY_BF_OUT.
     * 
     * @return elem
     */
    public org.apache.axis.types.NonNegativeInteger getElem() {
        return elem;
    }


    /**
     * Sets the elem value for this SERVICES_ARRAY_BF_OUT.
     * 
     * @param elem
     */
    public void setElem(org.apache.axis.types.NonNegativeInteger elem) {
        this.elem = elem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SERVICES_ARRAY_BF_OUT)) return false;
        SERVICES_ARRAY_BF_OUT other = (SERVICES_ARRAY_BF_OUT) obj;
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
            ((this.elem==null && other.getElem()==null) || 
             (this.elem!=null &&
              this.elem.equals(other.getElem())));
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
        if (getElem() != null) {
            _hashCode += getElem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SERVICES_ARRAY_BF_OUT.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "SERVICES_ARRAY_BF_OUT"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("elem");
        attrField.setXmlName(new javax.xml.namespace.QName("", "elem"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "POID"));
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
