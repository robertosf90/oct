/**
 * IG_FLD_EMAILS_ARRAY.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class IG_FLD_EMAILS_ARRAY  implements java.io.Serializable {
    private java.lang.String IG_FLD_EMAIL_TYPE;

    private java.lang.String IG_FLD_EMAIL;

    private org.apache.axis.types.NonNegativeInteger elem;  // attribute

    public IG_FLD_EMAILS_ARRAY() {
    }

    public IG_FLD_EMAILS_ARRAY(
           java.lang.String IG_FLD_EMAIL_TYPE,
           java.lang.String IG_FLD_EMAIL,
           org.apache.axis.types.NonNegativeInteger elem) {
           this.IG_FLD_EMAIL_TYPE = IG_FLD_EMAIL_TYPE;
           this.IG_FLD_EMAIL = IG_FLD_EMAIL;
           this.elem = elem;
    }


    /**
     * Gets the IG_FLD_EMAIL_TYPE value for this IG_FLD_EMAILS_ARRAY.
     * 
     * @return IG_FLD_EMAIL_TYPE
     */
    public java.lang.String getIG_FLD_EMAIL_TYPE() {
        return IG_FLD_EMAIL_TYPE;
    }


    /**
     * Sets the IG_FLD_EMAIL_TYPE value for this IG_FLD_EMAILS_ARRAY.
     * 
     * @param IG_FLD_EMAIL_TYPE
     */
    public void setIG_FLD_EMAIL_TYPE(java.lang.String IG_FLD_EMAIL_TYPE) {
        this.IG_FLD_EMAIL_TYPE = IG_FLD_EMAIL_TYPE;
    }


    /**
     * Gets the IG_FLD_EMAIL value for this IG_FLD_EMAILS_ARRAY.
     * 
     * @return IG_FLD_EMAIL
     */
    public java.lang.String getIG_FLD_EMAIL() {
        return IG_FLD_EMAIL;
    }


    /**
     * Sets the IG_FLD_EMAIL value for this IG_FLD_EMAILS_ARRAY.
     * 
     * @param IG_FLD_EMAIL
     */
    public void setIG_FLD_EMAIL(java.lang.String IG_FLD_EMAIL) {
        this.IG_FLD_EMAIL = IG_FLD_EMAIL;
    }


    /**
     * Gets the elem value for this IG_FLD_EMAILS_ARRAY.
     * 
     * @return elem
     */
    public org.apache.axis.types.NonNegativeInteger getElem() {
        return elem;
    }


    /**
     * Sets the elem value for this IG_FLD_EMAILS_ARRAY.
     * 
     * @param elem
     */
    public void setElem(org.apache.axis.types.NonNegativeInteger elem) {
        this.elem = elem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IG_FLD_EMAILS_ARRAY)) return false;
        IG_FLD_EMAILS_ARRAY other = (IG_FLD_EMAILS_ARRAY) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.IG_FLD_EMAIL_TYPE==null && other.getIG_FLD_EMAIL_TYPE()==null) || 
             (this.IG_FLD_EMAIL_TYPE!=null &&
              this.IG_FLD_EMAIL_TYPE.equals(other.getIG_FLD_EMAIL_TYPE()))) &&
            ((this.IG_FLD_EMAIL==null && other.getIG_FLD_EMAIL()==null) || 
             (this.IG_FLD_EMAIL!=null &&
              this.IG_FLD_EMAIL.equals(other.getIG_FLD_EMAIL()))) &&
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
        if (getIG_FLD_EMAIL_TYPE() != null) {
            _hashCode += getIG_FLD_EMAIL_TYPE().hashCode();
        }
        if (getIG_FLD_EMAIL() != null) {
            _hashCode += getIG_FLD_EMAIL().hashCode();
        }
        if (getElem() != null) {
            _hashCode += getElem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IG_FLD_EMAILS_ARRAY.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "IG_FLD_EMAILS_ARRAY"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("elem");
        attrField.setXmlName(new javax.xml.namespace.QName("", "elem"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_EMAIL_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_EMAIL_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_EMAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_EMAIL"));
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
