/**
 * PAYINFOIGCOBILLINGARRAY.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class PAYINFOIGCOBILLINGARRAY  implements java.io.Serializable {
    private java.lang.String IG_FLD_BRANCH;

    private java.lang.String IG_FLD_CONTRACT_NO;

    private java.lang.String IG_FLD_CPF_CNPJ;

    private java.lang.String SERVICE_ID;

    private java.lang.String IG_FLD_SERVICE_PROVIDER;

    private java.lang.String IG_FLD_TERMINAL_HOLDER;

    private java.lang.String IG_FLD_RELATIONSHIP;

    public PAYINFOIGCOBILLINGARRAY() {
    }

    public PAYINFOIGCOBILLINGARRAY(
           java.lang.String IG_FLD_BRANCH,
           java.lang.String IG_FLD_CONTRACT_NO,
           java.lang.String IG_FLD_CPF_CNPJ,
           java.lang.String SERVICE_ID,
           java.lang.String IG_FLD_SERVICE_PROVIDER,
           java.lang.String IG_FLD_TERMINAL_HOLDER,
           java.lang.String IG_FLD_RELATIONSHIP) {
           this.IG_FLD_BRANCH = IG_FLD_BRANCH;
           this.IG_FLD_CONTRACT_NO = IG_FLD_CONTRACT_NO;
           this.IG_FLD_CPF_CNPJ = IG_FLD_CPF_CNPJ;
           this.SERVICE_ID = SERVICE_ID;
           this.IG_FLD_SERVICE_PROVIDER = IG_FLD_SERVICE_PROVIDER;
           this.IG_FLD_TERMINAL_HOLDER = IG_FLD_TERMINAL_HOLDER;
           this.IG_FLD_RELATIONSHIP = IG_FLD_RELATIONSHIP;
    }


    /**
     * Gets the IG_FLD_BRANCH value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @return IG_FLD_BRANCH
     */
    public java.lang.String getIG_FLD_BRANCH() {
        return IG_FLD_BRANCH;
    }


    /**
     * Sets the IG_FLD_BRANCH value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @param IG_FLD_BRANCH
     */
    public void setIG_FLD_BRANCH(java.lang.String IG_FLD_BRANCH) {
        this.IG_FLD_BRANCH = IG_FLD_BRANCH;
    }


    /**
     * Gets the IG_FLD_CONTRACT_NO value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @return IG_FLD_CONTRACT_NO
     */
    public java.lang.String getIG_FLD_CONTRACT_NO() {
        return IG_FLD_CONTRACT_NO;
    }


    /**
     * Sets the IG_FLD_CONTRACT_NO value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @param IG_FLD_CONTRACT_NO
     */
    public void setIG_FLD_CONTRACT_NO(java.lang.String IG_FLD_CONTRACT_NO) {
        this.IG_FLD_CONTRACT_NO = IG_FLD_CONTRACT_NO;
    }


    /**
     * Gets the IG_FLD_CPF_CNPJ value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @return IG_FLD_CPF_CNPJ
     */
    public java.lang.String getIG_FLD_CPF_CNPJ() {
        return IG_FLD_CPF_CNPJ;
    }


    /**
     * Sets the IG_FLD_CPF_CNPJ value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @param IG_FLD_CPF_CNPJ
     */
    public void setIG_FLD_CPF_CNPJ(java.lang.String IG_FLD_CPF_CNPJ) {
        this.IG_FLD_CPF_CNPJ = IG_FLD_CPF_CNPJ;
    }


    /**
     * Gets the SERVICE_ID value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @return SERVICE_ID
     */
    public java.lang.String getSERVICE_ID() {
        return SERVICE_ID;
    }


    /**
     * Sets the SERVICE_ID value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @param SERVICE_ID
     */
    public void setSERVICE_ID(java.lang.String SERVICE_ID) {
        this.SERVICE_ID = SERVICE_ID;
    }


    /**
     * Gets the IG_FLD_SERVICE_PROVIDER value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @return IG_FLD_SERVICE_PROVIDER
     */
    public java.lang.String getIG_FLD_SERVICE_PROVIDER() {
        return IG_FLD_SERVICE_PROVIDER;
    }


    /**
     * Sets the IG_FLD_SERVICE_PROVIDER value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @param IG_FLD_SERVICE_PROVIDER
     */
    public void setIG_FLD_SERVICE_PROVIDER(java.lang.String IG_FLD_SERVICE_PROVIDER) {
        this.IG_FLD_SERVICE_PROVIDER = IG_FLD_SERVICE_PROVIDER;
    }


    /**
     * Gets the IG_FLD_TERMINAL_HOLDER value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @return IG_FLD_TERMINAL_HOLDER
     */
    public java.lang.String getIG_FLD_TERMINAL_HOLDER() {
        return IG_FLD_TERMINAL_HOLDER;
    }


    /**
     * Sets the IG_FLD_TERMINAL_HOLDER value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @param IG_FLD_TERMINAL_HOLDER
     */
    public void setIG_FLD_TERMINAL_HOLDER(java.lang.String IG_FLD_TERMINAL_HOLDER) {
        this.IG_FLD_TERMINAL_HOLDER = IG_FLD_TERMINAL_HOLDER;
    }


    /**
     * Gets the IG_FLD_RELATIONSHIP value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @return IG_FLD_RELATIONSHIP
     */
    public java.lang.String getIG_FLD_RELATIONSHIP() {
        return IG_FLD_RELATIONSHIP;
    }


    /**
     * Sets the IG_FLD_RELATIONSHIP value for this PAYINFOIGCOBILLINGARRAY.
     * 
     * @param IG_FLD_RELATIONSHIP
     */
    public void setIG_FLD_RELATIONSHIP(java.lang.String IG_FLD_RELATIONSHIP) {
        this.IG_FLD_RELATIONSHIP = IG_FLD_RELATIONSHIP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PAYINFOIGCOBILLINGARRAY)) return false;
        PAYINFOIGCOBILLINGARRAY other = (PAYINFOIGCOBILLINGARRAY) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.IG_FLD_BRANCH==null && other.getIG_FLD_BRANCH()==null) || 
             (this.IG_FLD_BRANCH!=null &&
              this.IG_FLD_BRANCH.equals(other.getIG_FLD_BRANCH()))) &&
            ((this.IG_FLD_CONTRACT_NO==null && other.getIG_FLD_CONTRACT_NO()==null) || 
             (this.IG_FLD_CONTRACT_NO!=null &&
              this.IG_FLD_CONTRACT_NO.equals(other.getIG_FLD_CONTRACT_NO()))) &&
            ((this.IG_FLD_CPF_CNPJ==null && other.getIG_FLD_CPF_CNPJ()==null) || 
             (this.IG_FLD_CPF_CNPJ!=null &&
              this.IG_FLD_CPF_CNPJ.equals(other.getIG_FLD_CPF_CNPJ()))) &&
            ((this.SERVICE_ID==null && other.getSERVICE_ID()==null) || 
             (this.SERVICE_ID!=null &&
              this.SERVICE_ID.equals(other.getSERVICE_ID()))) &&
            ((this.IG_FLD_SERVICE_PROVIDER==null && other.getIG_FLD_SERVICE_PROVIDER()==null) || 
             (this.IG_FLD_SERVICE_PROVIDER!=null &&
              this.IG_FLD_SERVICE_PROVIDER.equals(other.getIG_FLD_SERVICE_PROVIDER()))) &&
            ((this.IG_FLD_TERMINAL_HOLDER==null && other.getIG_FLD_TERMINAL_HOLDER()==null) || 
             (this.IG_FLD_TERMINAL_HOLDER!=null &&
              this.IG_FLD_TERMINAL_HOLDER.equals(other.getIG_FLD_TERMINAL_HOLDER()))) &&
            ((this.IG_FLD_RELATIONSHIP==null && other.getIG_FLD_RELATIONSHIP()==null) || 
             (this.IG_FLD_RELATIONSHIP!=null &&
              this.IG_FLD_RELATIONSHIP.equals(other.getIG_FLD_RELATIONSHIP())));
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
        if (getIG_FLD_BRANCH() != null) {
            _hashCode += getIG_FLD_BRANCH().hashCode();
        }
        if (getIG_FLD_CONTRACT_NO() != null) {
            _hashCode += getIG_FLD_CONTRACT_NO().hashCode();
        }
        if (getIG_FLD_CPF_CNPJ() != null) {
            _hashCode += getIG_FLD_CPF_CNPJ().hashCode();
        }
        if (getSERVICE_ID() != null) {
            _hashCode += getSERVICE_ID().hashCode();
        }
        if (getIG_FLD_SERVICE_PROVIDER() != null) {
            _hashCode += getIG_FLD_SERVICE_PROVIDER().hashCode();
        }
        if (getIG_FLD_TERMINAL_HOLDER() != null) {
            _hashCode += getIG_FLD_TERMINAL_HOLDER().hashCode();
        }
        if (getIG_FLD_RELATIONSHIP() != null) {
            _hashCode += getIG_FLD_RELATIONSHIP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PAYINFOIGCOBILLINGARRAY.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.wsm.brm.ig/", "PAYINFOIGCOBILLINGARRAY"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_BRANCH");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_BRANCH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_CONTRACT_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_CONTRACT_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_CPF_CNPJ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_CPF_CNPJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SERVICE_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SERVICE_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_SERVICE_PROVIDER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_SERVICE_PROVIDER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_TERMINAL_HOLDER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_TERMINAL_HOLDER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IG_FLD_RELATIONSHIP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IG_FLD_RELATIONSHIP"));
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
