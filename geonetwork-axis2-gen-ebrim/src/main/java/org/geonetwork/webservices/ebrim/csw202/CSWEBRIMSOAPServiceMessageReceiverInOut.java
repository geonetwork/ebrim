/**
 * CSWEBRIMSOAPServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.geonetwork.webservices.ebrim.csw202;

/**
 * CSWEBRIMSOAPServiceMessageReceiverInOut message receiver
 */

public class CSWEBRIMSOAPServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {

	public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext,
			org.apache.axis2.context.MessageContext newMsgContext) throws org.apache.axis2.AxisFault {

		try {

			// get the implementation class for the Web Service
			Object obj = getTheImplementationObject(msgContext);

			CSWEBRIMSOAPServiceSkeleton skel = (CSWEBRIMSOAPServiceSkeleton) obj;
			// Out Envelop
			org.apache.axiom.soap.SOAPEnvelope envelope = null;
			// Find the axisOperation that has been set by the Dispatch phase.
			org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
			if (op == null) {
				throw new org.apache.axis2.AxisFault(
						"Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
			}

			java.lang.String methodName;
			if ((op.getName() != null)
					&& ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)) {

				if ("GetRecords".equals(methodName)) {

					org.geonetwork.domain.csw202.discovery.GetRecordsResponse GetRecordsResponse = null;
					org.geonetwork.domain.csw202.discovery.GetRecords wrappedParam = (org.geonetwork.domain.csw202.discovery.GetRecords) fromOM(
							msgContext.getEnvelope().getBody().getFirstElement(),
							org.geonetwork.domain.csw202.discovery.GetRecords.class, getEnvelopeNamespaces(msgContext
									.getEnvelope()));

					GetRecordsResponse =

					skel.GetRecords(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext), GetRecordsResponse, false);
				} else

				if ("GetDomain".equals(methodName)) {

					org.geonetwork.domain.csw202.discovery.GetDomainResponse GetDomainResponse = null;
					org.geonetwork.domain.csw202.discovery.GetDomain wrappedParam = (org.geonetwork.domain.csw202.discovery.GetDomain) fromOM(
							msgContext.getEnvelope().getBody().getFirstElement(),
							org.geonetwork.domain.csw202.discovery.GetDomain.class, getEnvelopeNamespaces(msgContext
									.getEnvelope()));

					GetDomainResponse =

					skel.GetDomain(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext), GetDomainResponse, false);
				} else

				if ("GetRecordByIdXml".equals(methodName)) {

					org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse GetRecordByIdResponse = null;
					org.geonetwork.domain.csw202.discovery.GetRecordById wrappedParam = (org.geonetwork.domain.csw202.discovery.GetRecordById) fromOM(
							msgContext.getEnvelope().getBody().getFirstElement(),
							org.geonetwork.domain.csw202.discovery.GetRecordById.class,
							getEnvelopeNamespaces(msgContext.getEnvelope()));

					GetRecordByIdResponse =

					skel.GetRecordByIdXml(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext), GetRecordByIdResponse, false);
				} else

				if ("DescribeRecord".equals(methodName)) {

					org.geonetwork.domain.csw202.discovery.DescribeRecordResponse DescribeRecordResponse = null;
					org.geonetwork.domain.csw202.discovery.DescribeRecord wrappedParam = (org.geonetwork.domain.csw202.discovery.DescribeRecord) fromOM(
							msgContext.getEnvelope().getBody().getFirstElement(),
							org.geonetwork.domain.csw202.discovery.DescribeRecord.class,
							getEnvelopeNamespaces(msgContext.getEnvelope()));

					DescribeRecordResponse =

					skel.DescribeRecord(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext), DescribeRecordResponse, false);

				} else {
					throw new java.lang.RuntimeException("method not found");
				}

				newMsgContext.setEnvelope(envelope);
			}
		} catch (MsgInvalidRequestFault e) {

			msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME, "ExceptionReport");
			org.apache.axis2.AxisFault f = createAxisFault(e);
			if (e.getFaultMessage() != null) {
				f.setDetail(toOM(e.getFaultMessage(), false));
			}
			throw f;
		}

		catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	//
	private static final org.jibx.runtime.IBindingFactory bindingFactory;
	private static final String bindingErrorMessage;
	private static final int[] bindingNamespaceIndexes;
	private static final String[] bindingNamespacePrefixes;

	static {
		org.jibx.runtime.IBindingFactory factory = null;
		String message = null;
		try {

			factory = org.jibx.runtime.BindingDirectory
					.getFactory(org.geonetwork.domain.csw202.discovery.GetRecordById.class);

			message = null;
		} catch (Exception e) {
			message = e.getMessage();
		}
		bindingFactory = factory;
		bindingErrorMessage = message;

		int[] indexes = null;
		String[] prefixes = null;
		if (factory != null) {

			// check for xsi namespace included
			String[] nsuris = factory.getNamespaces();
			int xsiindex = nsuris.length;
			while (--xsiindex >= 0 && !"http://www.w3.org/2001/XMLSchema-instance".equals(nsuris[xsiindex]))
				;

			// get actual size of index and prefix arrays to be allocated
			int nscount = 0;
			int usecount = nscount;
			if (xsiindex >= 0) {
				usecount++;
			}

			// allocate and initialize the arrays
			indexes = new int[usecount];
			prefixes = new String[usecount];

			if (xsiindex >= 0) {
				indexes[nscount] = xsiindex;
				prefixes[nscount] = "xsi";
			}

		}
		bindingNamespaceIndexes = indexes;
		bindingNamespacePrefixes = prefixes;
	}

	private static int nsIndex(String uri, String[] uris) {
		for (int i = 0; i < uris.length; i++) {
			if (uri.equals(uris[i])) {
				return i;
			}
		}
		throw new IllegalArgumentException("Namespace " + uri + " not found in binding directory information");
	}

	private static void addMappingNamespaces(org.apache.axiom.soap.SOAPFactory factory,
			org.apache.axiom.om.OMElement wrapper, String nsuri, String nspref) {
		String[] nss = bindingFactory.getNamespaces();
		for (int i = 0; i < bindingNamespaceIndexes.length; i++) {
			int index = bindingNamespaceIndexes[i];
			String uri = nss[index];
			String prefix = bindingNamespacePrefixes[i];
			if (!nsuri.equals(uri) || !nspref.equals(prefix)) {
				wrapper.declareNamespace(factory.createOMNamespace(uri, prefix));
			}
		}
	}

	private static org.jibx.runtime.impl.UnmarshallingContext getNewUnmarshalContext(org.apache.axiom.om.OMElement param)
			throws org.jibx.runtime.JiBXException {
		if (bindingFactory == null) {
			throw new RuntimeException(bindingErrorMessage);
		}
		org.jibx.runtime.impl.UnmarshallingContext ctx = (org.jibx.runtime.impl.UnmarshallingContext) bindingFactory
				.createUnmarshallingContext();
		org.jibx.runtime.IXMLReader reader = new org.jibx.runtime.impl.StAXReaderWrapper(param
				.getXMLStreamReaderWithoutCaching(), "SOAP-message", true);
		ctx.setDocument(reader);
		ctx.toTag();
		return ctx;
	}

	private org.apache.axiom.om.OMElement mappedChild(Object value, org.apache.axiom.om.OMFactory factory) {
		org.jibx.runtime.IMarshallable mrshable = (org.jibx.runtime.IMarshallable) value;
		org.apache.axiom.om.OMDataSource src = new org.apache.axis2.jibx.JiBXDataSource(mrshable, bindingFactory);
		int index = mrshable.JiBX_getIndex();
		org.apache.axiom.om.OMNamespace appns = factory.createOMNamespace(bindingFactory.getElementNamespaces()[index],
				"");
		return factory.createOMElement(src, bindingFactory.getElementNames()[index], appns);
	}

	private static Object fromOM(org.apache.axiom.om.OMElement param, Class type, java.util.Map extraNamespaces)
			throws org.apache.axis2.AxisFault {
		try {
			org.jibx.runtime.impl.UnmarshallingContext ctx = getNewUnmarshalContext(param);
			return ctx.unmarshalElement(type);
		} catch (Exception e) {
			throw new org.apache.axis2.AxisFault(e.getMessage());
		}
	}

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.discovery.DescribeRecordResponse param,
			org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

		if (param instanceof org.jibx.runtime.IMarshallable) {
			if (bindingFactory == null) {
				throw new RuntimeException(bindingErrorMessage);
			}
			return (mappedChild(param, factory));
		} else if (param == null) {
			throw new RuntimeException(
					"Cannot bind null value of type org.geonetwork.domain.csw202.discovery.DescribeRecordResponse");
		} else {
			throw new RuntimeException(
					"No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.DescribeRecordResponse");
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
			org.geonetwork.domain.csw202.discovery.DescribeRecordResponse param, boolean optimizeContent) {
		org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null) {
			envelope.getBody().addChild(toOM(param, factory, optimizeContent));
		}
		return envelope;
	}

	private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.discovery.GetDomainResponse param,
			org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

		if (param instanceof org.jibx.runtime.IMarshallable) {
			if (bindingFactory == null) {
				throw new RuntimeException(bindingErrorMessage);
			}
			return (mappedChild(param, factory));
		} else if (param == null) {
			throw new RuntimeException(
					"Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetDomainResponse");
		} else {
			throw new RuntimeException(
					"No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.GetDomainResponse");
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
			org.geonetwork.domain.csw202.discovery.GetDomainResponse param, boolean optimizeContent) {
		org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null) {
			envelope.getBody().addChild(toOM(param, factory, optimizeContent));
		}
		return envelope;
	}

	private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse param,
			org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

		if (param instanceof org.jibx.runtime.IMarshallable) {
			if (bindingFactory == null) {
				throw new RuntimeException(bindingErrorMessage);
			}
			return (mappedChild(param, factory));
		} else if (param == null) {
			throw new RuntimeException(
					"Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse");
		} else {
			throw new RuntimeException(
					"No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse");
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
			org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse param, boolean optimizeContent) {
		org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null) {
			envelope.getBody().addChild(toOM(param, factory, optimizeContent));
		}
		return envelope;
	}

	private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.discovery.GetRecordsResponse param,
			org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

		if (param instanceof org.jibx.runtime.IMarshallable) {
			if (bindingFactory == null) {
				throw new RuntimeException(bindingErrorMessage);
			}
			return (mappedChild(param, factory));
		} else if (param == null) {
			throw new RuntimeException(
					"Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetRecordsResponse");
		} else {
			throw new RuntimeException(
					"No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.GetRecordsResponse");
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
			org.geonetwork.domain.csw202.discovery.GetRecordsResponse param, boolean optimizeContent) {
		org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null) {
			envelope.getBody().addChild(toOM(param, factory, optimizeContent));
		}
		return envelope;
	}

	private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.exception.ExceptionReport param,
			boolean optimizeContent) {
		org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

		if (param instanceof org.jibx.runtime.IMarshallable) {
			if (bindingFactory == null) {
				throw new RuntimeException(bindingErrorMessage);
			}
			return (mappedChild(param, factory));
		} else if (param == null) {
			throw new RuntimeException(
					"Cannot bind null value of type org.geonetwork.domain.csw202.exception.ExceptionReport");
		} else {
			throw new RuntimeException(
					"No JiBX <mapping> defined for class org.geonetwork.domain.csw202.exception.ExceptionReport");
		}

	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
		org.apache.axis2.AxisFault f;
		Throwable cause = e.getCause();
		if (cause != null) {
			f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
		} else {
			f = new org.apache.axis2.AxisFault(e.getMessage());
		}

		return f;
	}

}// end of class
