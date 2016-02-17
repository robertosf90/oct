/**
 * NAMEINFO_ARRAY.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class NAMEINFO_ARRAY  implements java.io.Serializable {
    private java.lang.String LAST_NAME;

    private java.lang.String MIDDLE_NAME;

    private java.lang.String FIRST_NAME;

    private java.lang.String CONTACT_TYPE;

    private java.lang.String ZIP;

    private java.lang.String STATE;

    private java.lang.String ADDRESS;

    private java.lang.String CITY;

    private java.lang.String COMPANY;

    private oi.brm.wsm.service.PHONES_ARRAY[] PHONES;

    public NAMEINFO_ARRAY() {
    }

    public NAMEINFO_ARRAY(
           java.lang.String LAST_NAME,
           java.lang.String MIDDLE_NAME,
           java.lang.String FIRST_NAME,
           java.lang.String CONTACT_TYPE,
           java.lang.String ZIP,
           java.lang.String STATE,
           java.lang.String ADDRESS,
           java.lang.String CITY,
           java.lang.String COMPANY,
           oi.brm.wsm.service.PHONES_ARRAY[] PHONES) {
           this.LAST_NAME = LAST_NAME;
           this.MIDDLE_NAME = MIDDLE_NAME;
           this.FIRST_NAME = FIRST_NAME;
           this.CONTACT_TYPE = CONTACT_TYPE;
           this.ZIP = ZIP;
           this.STATE = STATE;
           this.ADDRESS = ADDRESS;
           this.CITY = CITY;
           this.COMPANY = COMPANY;
           this.PHONES = PHONES;
    }


    /**
     * Gets the LAST_NAME value for this NAMEINFO_ARRAY.
     * 
     * @return LAST_NAME
     */
    public java.lang.String getLAST_NAME() {
        return LAST_NAME;
    }


    /**
     * Sets the LAST_NAME value for this NAMEINFO_ARRAY.
     * 
     * @param LAST_NAME
     */
    public void setLAST_NAME(java.lang.String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }


    /**
     * Gets the MIDDLE_NAME value for this NAMEINFO_ARRAY.
     * 
     * @return MIDDLE_NAME
     */
    public java.lang.String getMIDDLE_NAME() {
        return MIDDLE_NAME;
    }


    /**
     * Sets the MIDDLE_NAME value for this NAMEINFO_ARRAY.
     * 
     * @param MIDDLE_NAME
     */
    public void setMIDDLE_NAME(java.lang.String MIDDLE_NAME) {
        this.MIDDLE_NAME = MIDDLE_NAME;
    }


    /**
     * Gets the FIRST_NAME value for this NAMEINFO_ARRAY.
     * 
     * @return FIRST_NAME
     */
    public java.lang.String getFIRST_NAME() {
        return FIRST_NAME;
    }


    /**
     * Sets the FIRST_NAME value for this NAMEINFO_ARRAY.
     * 
     * @param FIRST_NAME
     */
    public void setFIRST_NAME(java.lang.String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }


    /**
     * Gets the CONTACT_TYPE value for this NAMEINFO_ARRAY.
     * 
     * @return CONTACT_TYPE
     */
    public java.lang.String getCONTACT_TYPE() {
        return CONTACT_TYPE;
    }


    /**
     * Sets the CONTACT_TYPE value for this NAMEINFO_ARRAY.
     * 
     * @param CONTACT_TYPE
     */
    public void setCONTACT_TYPE(java.lang.String CONTACT_TYPE) {
        this.CONTACT_TYPE = CONTACT_TYPE;
    }


    /**
     * Gets the ZIP value for this NAMEINFO_ARRAY.
     * 
     * @return ZIP
     */
    public java.lang.String getZIP() {
        return ZIP;
    }


    /**
     * Sets the ZIP value for this NAMEINFO_ARRAY.
     * 
     * @param ZIP
     */
    public void setZIP(java.lang.String ZIP) {
        this.ZIP = ZIP;
    }


    /**
     * Gets the STATE value for this NAMEINFO_ARRAY.
     * 
     * @return STATE
     */
    public java.lang.String getSTATE() {
        return STATE;
    }


    /**
     * Sets the STATE value for this NAMEINFO_ARRAY.
     * 
     * @param STATE
     */
    public void setSTATE(java.lang.String STATE) {
        this.STATE = STATE;
    }


    /**
     * Gets the ADDRESS value for this NAMEINFO_ARRAY.
     * 
     * @return ADDRESS
     */
    public java.lang.String getADDRESS() {
        return ADDRESS;
    }


    /**
     * Sets the ADDRESS value for this NAMEINFO_ARRAY.
     * 
     * @param ADDRESS
     */
    public void setADDRESS(java.lang.String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }


    /**
     * Gets the CITY value for this NAMEINFO_ARRAY.
     * 
     * @return CITY
     */
    public java.lang.String getCITY() {
        return CITY;
    }


    /**
     * Sets the CITY value for this NAMEINFO_ARRAY.
     * 
     * @param CITY
     */
    public void setCITY(java.lang.String CITY) {
        this.CITY = CITY;
    }


    /**
     * Gets the COMPANY value for this NAMEINFO_ARRAY.
     * 
     * @return COMPANY
     */
    public java.lang.String getCOMPANY() {
        return COMPANY;
    }


    /**
     * Sets the COMPANY value for this NAMEINFO_ARRAY.
     * 
     * @param COMPANY
     */
    public void setCOMPANY(java.lang.String COMPANY) {
        this.COMPANY = COMPANY;
    }


    /**
     * Gets the PHONES value for this NAMEINFO_ARRAY.
     * 
     * @return PHONES
     */
    public oi.brm.wsm.service.PHONES_ARRAY[] getPHONES() {
        return PHONES;
    }


    /**
     * Sets the PHONES value for this NAMEINFO_ARRAY.
     * 
     * @param PHONES
     */
    public void setPHONES(oi.brm.wsm.service.PHONES_ARRAY[] PHONES) {
        this.PHONES = PHONES;
    }

    public oi.brm.wsm.service.PHONES_ARRAY getPHONES(int i) {
        return this.PHONES[i];
    }

    public void setPHONES(int i, oi.brm.wsm.service.PHONES_ARRAY _value) {
        this.PHONES[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NAMEINFO_ARRAY)) return false;
        NAMEINFO_ARRAY other = (NAMEINFO_ARRAY) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LAST_NAME==null && other.getLAST_NAME()==null) || 
             (this.LAST_NAME!=null &&
              this.LAST_NAME.equals(other.getLAST_NAME()))) &&
            ((this.MIDDLE_NAME==null && other.getMIDDLE_NAME()==null) || 
             (this.MIDDLE_NAME!=null &&
              this.MIDDLE_NAME.equals(other.getMIDDLE_NAME()))) &&
            ((this.FIRST_NAME==null && other.getFIRST_NAME()==null) || 
             (this.FIRST_NAME!=null &&
              this.FIRST_NAME.equals(other.getFIRST_NAME()))) &&
            ((this.CONTACT_TYPE==null && other.getCONTACT_TYPE()==null) || 
             (this.CONTACT_TYPE!=null &&
              this.CONTACT_TYPE.equals(other.getCONTACT_TYPE()))) &&
            ((this.ZIP==null && other.getZIP()==null) || 
             (this.ZIP!=null &&
              this.ZIP.equals(other.getZIP()))) &&
            ((this.STATE==null && other.getSTATE()==null) || 
             (this.STATE!=null &&
              this.STATE.equals(other.getSTATE()))) &&
            ((this.ADDRESS==null && other.getADDRESS()==null) || 
             (this.ADDRESS!=null &&
              this.ADDRESS.equals(other.getADDRESS()))) &&
            ((this.CITY==null && other.getCITY()==null) || 
             (this.CITY!=null &&
              this.CITY.equals(other.getCITY()))) &&
            ((this.COMPANY==null && other.getCOMPANY()==null) || 
             (this.COMPANY!=null &&
              this.COMPANY.equals(other.getCOMPANY()))) &&
            ((this.PHONES==null && other.getPHONES()==null) || 
             (this.PHONES!=null &&
              java.util.Arrays.equals(this.PHONES, other.getPHONES())));
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
        if (getLAST_NAME() != null) {
            _hashCode += getLAST_NAME().hashCode();
        }
        if (getMIDDLE_NAME() != null) {
            _hashCode += getMIDDLE_NAME().hashCode();
        }
        if (getFIRST_NAME() != null) {
            _hashCode += getFIRST_NAME().hashCode();
        }
        if (getCONTACT_TYPE() != null) {
            _hashCode += getCONTACT_TYPE().hashCode();
        }
        if (getZIP() != null) {
            _hashCode += getZIP().hashCode();
        }
        if (getSTATE() != null) {
            _hashCode += getSTATE().hashCode();
        }
        if (getADDRESS() != null) {
            _hashCode += getADDRESS().hashCode();
        }
        if (getCITY() != null) {
            _hashCode += getCITY().hashCode();
        }
        if (getCOMPANY() != null) {
            _hashCode += getCOMPANY().hashCode();
        }
        if (getPHONES() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPHONES());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPHONES(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NAMEINFO_ARRAY.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "NAMEINFO_ARRAY"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LAST_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LAST_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MIDDLE_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MIDDLE_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FIRST_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FIRST_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTACT_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTACT_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ZIP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ZIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ADDRESS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ADDRESS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CITY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CITY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMPANY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMPANY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PHONES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PHONES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "PHONES_ARRAY"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
