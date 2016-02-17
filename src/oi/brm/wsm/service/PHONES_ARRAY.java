/**
 * PHONES_ARRAY.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package oi.brm.wsm.service;

public class PHONES_ARRAY implements java.io.Serializable {
	private java.math.BigInteger TYPE;

	private java.lang.String PHONE;

	private org.apache.axis.types.NonNegativeInteger elem; // attribute

	public PHONES_ARRAY() {
	}

	public PHONES_ARRAY(java.math.BigInteger TYPE, java.lang.String PHONE,
			org.apache.axis.types.NonNegativeInteger elem) {
		this.TYPE = TYPE;
		this.PHONE = PHONE;
		this.elem = elem;
	}

	/**
	 * Gets the TYPE value for this PHONES_ARRAY.
	 * 
	 * @return TYPE
	 */
	public java.math.BigInteger getTYPE() {
		return TYPE;
	}

	/**
	 * Sets the TYPE value for this PHONES_ARRAY.
	 * 
	 * @param TYPE
	 */
	public void setTYPE(java.math.BigInteger TYPE) {
		this.TYPE = TYPE;
	}

	/**
	 * Gets the PHONE value for this PHONES_ARRAY.
	 * 
	 * @return PHONE
	 */
	public java.lang.String getPHONE() {
		return PHONE;
	}

	/**
	 * Sets the PHONE value for this PHONES_ARRAY.
	 * 
	 * @param PHONE
	 */
	public void setPHONE(java.lang.String PHONE) {
		this.PHONE = PHONE;
	}

	/**
	 * Gets the elem value for this PHONES_ARRAY.
	 * 
	 * @return elem
	 */
	public org.apache.axis.types.NonNegativeInteger getElem() {
		return elem;
	}

	/**
	 * Sets the elem value for this PHONES_ARRAY.
	 * 
	 * @param elem
	 */
	public void setElem(org.apache.axis.types.NonNegativeInteger elem) {
		this.elem = elem;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof PHONES_ARRAY))
			return false;
		PHONES_ARRAY other = (PHONES_ARRAY) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.TYPE == null && other.getTYPE() == null) || (this.TYPE != null && this.TYPE
						.equals(other.getTYPE())))
				&& ((this.PHONE == null && other.getPHONE() == null) || (this.PHONE != null && this.PHONE
						.equals(other.getPHONE())))
				&& ((this.elem == null && other.getElem() == null) || (this.elem != null && this.elem
						.equals(other.getElem())));
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
		if (getTYPE() != null) {
			_hashCode += getTYPE().hashCode();
		}
		if (getPHONE() != null) {
			_hashCode += getPHONE().hashCode();
		}
		if (getElem() != null) {
			_hashCode += getElem().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			PHONES_ARRAY.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"http://service.wsm.brm.ig/", "PHONES_ARRAY"));
		org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
		attrField.setFieldName("elem");
		attrField.setXmlName(new javax.xml.namespace.QName("", "elem"));
		attrField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "nonNegativeInteger"));
		typeDesc.addFieldDesc(attrField);
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("TYPE");
		elemField.setXmlName(new javax.xml.namespace.QName("", "TYPE"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "integer"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("PHONE");
		elemField.setXmlName(new javax.xml.namespace.QName("", "PHONE"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
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
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType,
				_xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType,
				_xmlType, typeDesc);
	}

}
