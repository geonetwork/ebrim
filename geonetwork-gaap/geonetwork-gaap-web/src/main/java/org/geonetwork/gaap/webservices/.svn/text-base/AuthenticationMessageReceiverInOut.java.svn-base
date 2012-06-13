/**
 * GroupServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.geonetwork.gaap.webservices;

import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.AuthenticationResponse;

/**
 * AuthenticationMessageReceiverInOut message receiver
 */

public class AuthenticationMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {

    public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
            throws org.apache.axis2.AxisFault {

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            AuthenticationServiceSkeleton skel = (AuthenticationServiceSkeleton) obj;
            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;
            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
            if (op == null) {
                throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            String methodName;
            if ((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)) {

                if ("Authenticate".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.AuthenticationResponse authenticationResponse = new org.geonetwork.gaap.domain.web.response.AuthenticationResponse();
                    org.geonetwork.gaap.domain.web.request.Authenticate wrappedParam = (org.geonetwork.gaap.domain.web.request.Authenticate) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.Authenticate.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    String authToken = skel.authenticate(wrappedParam.getUserName(), wrappedParam.getPassword());
                    authenticationResponse.setAuthenticationToken(authToken);

                    envelope = toEnvelope(getSOAPFactory(msgContext), authenticationResponse, false);

                } else if ("Logout".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.LogoutResponse response = new org.geonetwork.gaap.domain.web.response.LogoutResponse();
                    org.geonetwork.gaap.domain.web.request.Logout wrappedParam = (org.geonetwork.gaap.domain.web.request.Logout) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.Logout.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    skel.logout(wrappedParam.getUserName(), wrappedParam.getAuthToken());
                    response.setStatus(ResponseStatusCode.OK);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if ("GetUserUuidByAuthToken".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetUserUuidByAuthTokenResponse response = new org.geonetwork.gaap.domain.web.response.GetUserUuidByAuthTokenResponse();
                    org.geonetwork.gaap.domain.web.request.GetUserUuidByAuthToken wrappedParam = (org.geonetwork.gaap.domain.web.request.GetUserUuidByAuthToken) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetUserUuidByAuthToken.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    String userUuid = skel.getUserUuidByAuthToken(wrappedParam.getAuthToken());
                    response.setStatus(ResponseStatusCode.OK);
                    response.setUserUuid(userUuid);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else {
                    throw new RuntimeException("method not found");
                }


                newMsgContext.setEnvelope(envelope);
            }
        } catch (GaapServiceFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME, "gaapService");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null) {
                f.setDetail(toOM(e.getFaultMessage(), false));
            }
            throw f;
        }

        catch (Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private static final org.jibx.runtime.IBindingFactory bindingFactory;
    private static final String bindingErrorMessage;


    static {
        org.jibx.runtime.IBindingFactory factory = null;
        String message = null;
        try {

            factory = org.jibx.runtime.BindingDirectory.getFactory(org.geonetwork.gaap.domain.web.request.GetGroup.class);

            message = null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        bindingFactory = factory;
        bindingErrorMessage = message;
    }

    private static org.jibx.runtime.impl.UnmarshallingContext getNewUnmarshalContext(org.apache.axiom.om.OMElement param)
            throws org.jibx.runtime.JiBXException {
        if (bindingFactory == null) {
            throw new RuntimeException(bindingErrorMessage);
        }
        org.jibx.runtime.impl.UnmarshallingContext ctx =
                (org.jibx.runtime.impl.UnmarshallingContext) bindingFactory.createUnmarshallingContext();
        org.jibx.runtime.IXMLReader reader = new org.jibx.runtime.impl.StAXReaderWrapper(param.getXMLStreamReaderWithoutCaching(), "SOAP-message", true);
        ctx.setDocument(reader);
        ctx.toTag();
        return ctx;
    }

    private org.apache.axiom.om.OMElement mappedChild(Object value, org.apache.axiom.om.OMFactory factory) {
        org.jibx.runtime.IMarshallable mrshable = (org.jibx.runtime.IMarshallable) value;
        org.apache.axiom.om.OMDataSource src = new org.apache.axis2.jibx.JiBXDataSource(mrshable, bindingFactory);
        int index = mrshable.JiBX_getIndex();
        org.apache.axiom.om.OMNamespace appns = factory.createOMNamespace(bindingFactory.getElementNamespaces()[index], "");
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


    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.services.exception.GaapExceptionData param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.services.exception.GaapExceptionData");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.services.exception.GaapExceptionData");
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

    private org.apache.axis2.AxisFault createAxisFault(Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.AuthenticationResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.AuthenticationResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.AuthenticationResponse");
        }

    }


    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.LogoutResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.LogoutResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.LogoutResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.GetUserUuidByAuthTokenResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.GetUserUuidByAuthTokenResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.GetUserUuidByAuthTokenResponse");
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.AuthenticationResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.LogoutResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.GetUserUuidByAuthTokenResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }
}//end of class