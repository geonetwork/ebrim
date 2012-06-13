/**
 * CSWEBRIMSOAPServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.geonetwork.webservices.ebrim.csw202;

import org.apache.log4j.Logger;
import org.apache.axis2.AxisFault;
import org.apache.axiom.soap.*;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.impl.llom.OMElementImpl;

import org.geonetwork.domain.csw202.exception.ExceptionReport;
import org.geonetwork.services.ebrim.csw202.CSW202ExceptionReportGenerator;

import java.lang.Exception;
import java.util.Iterator;


/**
 * CSWEBRIMSOAPServiceMessageReceiverInOut message receiver
 * <p/>
 * Partly generated by Axis2. Partly handwritten.
 */
public class CSWEBRIMSOAPServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {

    private static Logger log = Logger.getLogger(CSWEBRIMSOAPServiceMessageReceiverInOut.class);

    public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext,
                                    org.apache.axis2.context.MessageContext newMsgContext) throws org.apache.axis2.AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = null;

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);
            String authToken = retrieveAuthToken(msgContext.getEnvelope().getHeader());

            CSWEBRIMSOAPServiceSkeleton skel = (CSWEBRIMSOAPServiceSkeleton) obj;
            // Out Envelop
            // Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                        "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;
            if ((op.getName() != null)
                    && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)) {

                if ("GetRepositoryItem".equals(methodName)) {

                    org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse GetRepositoryItemResponse = null;
                    org.geonetwork.domain.csw202.discovery.GetRepositoryItem wrappedParam = (org.geonetwork.domain.csw202.discovery.GetRepositoryItem) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.domain.csw202.discovery.GetRepositoryItem.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    //if (authToken != null) wrappedParam.setAuthToken(authToken);
                    GetRepositoryItemResponse =

                            skel.GetRepositoryItem(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext), GetRepositoryItemResponse, false);
                } else if ("GetRecords".equals(methodName)) {

                    org.geonetwork.domain.csw202.discovery.GetRecordsResponse GetRecordsResponse = null;
                    org.geonetwork.domain.csw202.discovery.GetRecords wrappedParam = (org.geonetwork.domain.csw202.discovery.GetRecords) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.domain.csw202.discovery.GetRecords.class, getEnvelopeNamespaces(msgContext
                                    .getEnvelope()));

                    if (authToken != null) wrappedParam.setAuthToken(authToken);
                    GetRecordsResponse =

                            skel.GetRecords(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext), GetRecordsResponse, false);
                } else if ("GetDomain".equals(methodName)) {

                    org.geonetwork.domain.csw202.discovery.GetDomainResponse GetDomainResponse = null;
                    org.geonetwork.domain.csw202.discovery.GetDomain wrappedParam = (org.geonetwork.domain.csw202.discovery.GetDomain) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.domain.csw202.discovery.GetDomain.class, getEnvelopeNamespaces(msgContext
                                    .getEnvelope()));

                    GetDomainResponse =

                            skel.GetDomain(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext), GetDomainResponse, false);
                } else if ("GetRecordById".equals(methodName)) {

                    org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse GetRecordByIdResponse = null;
                    org.geonetwork.domain.csw202.discovery.GetRecordById wrappedParam = (org.geonetwork.domain.csw202.discovery.GetRecordById) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.domain.csw202.discovery.GetRecordById.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    if (authToken != null) wrappedParam.setAuthToken(authToken);
                    GetRecordByIdResponse =

                            skel.GetRecordById(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext), GetRecordByIdResponse, false);
                } else if ("Transaction".equals(methodName)) {

                    org.geonetwork.domain.csw202.publication.TransactionResponse TransactionResponse = null;
                    org.geonetwork.domain.csw202.publication.Transaction wrappedParam = (org.geonetwork.domain.csw202.publication.Transaction) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.domain.csw202.publication.Transaction.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    TransactionResponse =

                            skel.Transaction(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext), TransactionResponse, false);
                } else if ("Harvest".equals(methodName)) {

                    org.geonetwork.domain.csw202.publication.HarvestResponse HarvestResponse = null;
                    org.geonetwork.domain.csw202.publication.Harvest wrappedParam = (org.geonetwork.domain.csw202.publication.Harvest) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.domain.csw202.publication.Harvest.class, getEnvelopeNamespaces(msgContext
                                    .getEnvelope()));

                    HarvestResponse =

                            skel.Harvest(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext), HarvestResponse, false);
                } else if ("GetCapabilities".equals(methodName)) {

                    org.geonetwork.domain.csw202.discovery.Capabilities GetCapabilitiesResponse = null;
                    org.geonetwork.domain.csw202.discovery.GetCapabilities wrappedParam = (org.geonetwork.domain.csw202.discovery.GetCapabilities) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.domain.csw202.discovery.GetCapabilities.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    GetCapabilitiesResponse =

                            skel.GetCapabilities(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext), GetCapabilitiesResponse, false);
                } else if ("DescribeRecord".equals(methodName)) {

                    org.geonetwork.domain.csw202.discovery.DescribeRecordResponse DescribeRecordResponse = null;
                    org.geonetwork.domain.csw202.discovery.DescribeRecord wrappedParam = (org.geonetwork.domain.csw202.discovery.DescribeRecord) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.domain.csw202.discovery.DescribeRecord.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    DescribeRecordResponse =

                            skel.DescribeRecord(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext), DescribeRecordResponse, false);

                } else {
                    log.error("method not found");
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }

        } catch (java.lang.Exception e) {
            log.error("CSWEBRIMSOAPServiceMessageReceiverInOut", e);
            // document: OGC 07-110r2: 7.9.2 Fault handling
            // In the event that an exception report is produced for any reason, a single SOAP Fault
            // element information
            // item shall be included as the only child element information item of the SOAP body
            // element (see SOAP12,
            // sec. 5.4). The elements of the SOAP Fault are constructed as follows:

            ExceptionReport rep = null;
            if (e instanceof MsgInvalidRequestFault)
                rep = ((MsgInvalidRequestFault) e).getFaultMessage();
            else
                rep = CSW202ExceptionReportGenerator.generateExceptionReportBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST, e.getMessage());

            SOAPFactory soapFactory = getSOAPFactory(msgContext);

            SOAPFaultCode soapFaultCode = soapFactory.createSOAPFaultCode();
            SOAPFaultValue soapFaultValue = soapFactory.createSOAPFaultValue(soapFaultCode);
            soapFaultValue.setText("soap:Server");
            newMsgContext.setProperty(SOAP12Constants.SOAP_FAULT_CODE_LOCAL_NAME, soapFaultCode);

            SOAPFaultReason soapFaultReason = soapFactory.createSOAPFaultReason();
            soapFaultReason.setText("A server exception was encountered.");


            newMsgContext.setProperty(SOAP12Constants.SOAP_FAULT_REASON_LOCAL_NAME, soapFaultReason);

            SOAPFaultDetail soapFaultDetail = soapFactory.createSOAPFaultDetail();
            soapFaultDetail.addChild(toOM(rep, soapFactory, false));

            newMsgContext.setProperty(SOAP12Constants.SOAP_FAULT_DETAIL_LOCAL_NAME, soapFaultDetail);

            throw new AxisFault(soapFaultCode, soapFaultReason, null, null, soapFaultDetail);
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
            log.error(bindingErrorMessage);
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

    private static Object fromOM(org.apache.axiom.om.OMElement param, Class<?> type,
                                 java.util.Map<String, String> extraNamespaces) throws org.apache.axis2.AxisFault {
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
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log.error("Cannot bind null value of type org.geonetwork.domain.csw202.discovery.DescribeRecordResponse");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.discovery.DescribeRecordResponse");
        } else {
            log
                    .error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.DescribeRecordResponse");
            throw new RuntimeException(
                    "No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.DescribeRecordResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(ExceptionReport param, org.apache.axiom.soap.SOAPFactory factory,
                                               boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log.error("Cannot bind null value of type ExceptionReport");
            throw new RuntimeException("Cannot bind null value of type ExceptionReport");
        } else {
            log.error("No JiBX <mapping> defined for class ExceptionReport");
            throw new RuntimeException("No JiBX <mapping> defined for class ExceptionReport");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.discovery.Capabilities param,
                                               org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log.error("Cannot bind null value of type org.geonetwork.domain.csw202.discovery.Capabilities");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.discovery.Capabilities");
        } else {
            log.error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.Capabilities");
            throw new RuntimeException(
                    "No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.Capabilities");
        }
    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.publication.TransactionResponse param,
                                               org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log.error("Cannot bind null value of type org.geonetwork.domain.csw202.publication.TransactionResponse ");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.publication.TransactionResponse ");
        } else {
            log
                    .error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.publication.TransactionResponse ");
            throw new RuntimeException(
                    "No JiBX <mapping> defined for class org.geonetwork.domain.csw202.publication.TransactionResponse ");
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

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          ExceptionReport param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.domain.csw202.publication.HarvestResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.publication.HarvestResponse param,
                                               org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log
                    .error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.publication.TransactionResponse ");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.publication.HarvestResponse");
        } else {
            log.error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.publication.HarvestResponse ");
            throw new RuntimeException(
                    "No JiBX <mapping> defined for class org.geonetwork.domain.csw202.publication.HarvestResponse");
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.domain.csw202.discovery.Capabilities param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.domain.csw202.publication.TransactionResponse param, boolean optimizeContent) {
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
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log.error("Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetDomainResponse");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetDomainResponse");
        } else {
            log.error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.GetDomainResponse");
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
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log.error("Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse");
        } else {
            log
                    .error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse");
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
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log.error("Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetRecordsResponse");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetRecordsResponse");
        } else {
            log.error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.GetRecordsResponse");
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

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse param,
                                               org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log
                    .error("Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse");
        } else {
            log
                    .error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse");
            throw new RuntimeException(
                    "No JiBX <mapping> defined for class org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.domain.csw202.exception.ExceptionReport param,
                                               boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                log.error(bindingErrorMessage);
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            log.error("Cannot bind null value of type org.geonetwork.domain.csw202.exception.ExceptionReport");
            throw new RuntimeException(
                    "Cannot bind null value of type org.geonetwork.domain.csw202.exception.ExceptionReport");
        } else {
            log.error("No JiBX <mapping> defined for class org.geonetwork.domain.csw202.exception.ExceptionReport");
            throw new RuntimeException(
                    "No JiBX <mapping> defined for class org.geonetwork.domain.csw202.exception.ExceptionReport");
        }

    }

    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map<String, String> getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map<String, String> returnMap = new java.util.HashMap<String, String>();
        java.util.Iterator<?> namespaceIterator = env.getAllDeclaredNamespaces();
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

    /**
     * Retrieves authToken from SOAP Header (if present)
     *
     * <wsse:Security xmlns="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"
     *   xmlns:saml="urn:oasis:names:tc:SAML:1.0:assertion"
     *   xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
     *   xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"
     *   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     *   xsi:schemaLocation="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd
     *   http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">
     *
     *   <authToken xmlns="http://geonetwork.org/gaap/services/AuthenticationService">XXXXXXXXXXXXXXXXXX</authToken>
     *
     *  </wsse:Security>
     *
     * @param header
     * @return
     */
    private String retrieveAuthToken(SOAPHeader header) {
        String authToken = null;

        if (header != null) {
            Iterator it = header.examineAllHeaderBlocks();

            while (it.hasNext()) {
                SOAPHeaderBlock n = (SOAPHeaderBlock) it.next();

                Iterator it2 = n.getChildrenWithLocalName("authToken");
                while (it2.hasNext()) {
                    OMNode n1 = (OMNode) it2.next();
                    if (n1 instanceof OMElementImpl) {
                        OMElementImpl el = (OMElementImpl) n1;
                        if (el.getLocalName() == "authToken") {
                            authToken = el.getText();
                        }
                    }
                }

            }
        }

        return authToken;
    }
}// end of class