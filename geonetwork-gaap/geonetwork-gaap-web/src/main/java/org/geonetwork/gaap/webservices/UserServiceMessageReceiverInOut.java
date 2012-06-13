/**
 * GroupServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.geonetwork.gaap.webservices;

import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.DeleteUserResponse;
import org.geonetwork.gaap.domain.user.User;

import java.util.List;

/**
 * UserServiceMessageReceiverInOut message receiver
 */

public class UserServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {

    public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
            throws org.apache.axis2.AxisFault {

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            UserServiceSkeleton skel = (UserServiceSkeleton) obj;
            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;
            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
            if (op == null) {
                throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            String methodName;
            if ((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)) {

                if ("DeleteUser".equals(methodName)) {
                    DeleteUserResponse response = new org.geonetwork.gaap.domain.web.response.DeleteUserResponse();
                    org.geonetwork.gaap.domain.web.request.DeleteUser wrappedParam = (org.geonetwork.gaap.domain.web.request.DeleteUser) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.DeleteUser.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    skel.deleteUser(wrappedParam.getUserUuid(), wrappedParam.getAuthToken());
                    response.setStatus(ResponseStatusCode.OK);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if ("UpdateUser".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.UpdateUserResponse response = new org.geonetwork.gaap.domain.web.response.UpdateUserResponse();
                    org.geonetwork.gaap.domain.web.request.UpdateUser wrappedParam = (org.geonetwork.gaap.domain.web.request.UpdateUser) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.UpdateUser.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    skel.updateUser(wrappedParam.getUser(), wrappedParam.getAuthToken());
                    response.setStatus(ResponseStatusCode.OK);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if ("CreateUser".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.CreateUserResponse response = new org.geonetwork.gaap.domain.web.response.CreateUserResponse();
                    org.geonetwork.gaap.domain.web.request.CreateUser wrappedParam = (org.geonetwork.gaap.domain.web.request.CreateUser) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.CreateUser.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    skel.createUser(wrappedParam.getUser(), wrappedParam.getAuthToken());
                    response.setStatus(ResponseStatusCode.OK);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if ("GetUser".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetUserResponse GetUserResponse = new org.geonetwork.gaap.domain.web.response.GetUserResponse();
                    org.geonetwork.gaap.domain.web.request.GetUser wrappedParam = (org.geonetwork.gaap.domain.web.request.GetUser) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetUser.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    org.geonetwork.gaap.domain.user.User user = skel.retrieveUser(wrappedParam.getUserUuid(), wrappedParam.getAuthToken());
                    GetUserResponse.setUser(user);

                    envelope = toEnvelope(getSOAPFactory(msgContext), GetUserResponse, false);

                } else if ("GetUserByUsername".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetUserResponse GetUserResponse = new org.geonetwork.gaap.domain.web.response.GetUserResponse();
                    org.geonetwork.gaap.domain.web.request.GetUserByUsername wrappedParam = (org.geonetwork.gaap.domain.web.request.GetUserByUsername) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetUserByUsername.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    org.geonetwork.gaap.domain.user.User user = skel.retrieveUserByUsername(wrappedParam.getUsername());
                    GetUserResponse.setUser(user);

                    envelope = toEnvelope(getSOAPFactory(msgContext), GetUserResponse, false);

                } else if ("GetUsers".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetUsersResponse GetUsersResponse = new org.geonetwork.gaap.domain.web.response.GetUsersResponse();
                    org.geonetwork.gaap.domain.web.request.GetUsers wrappedParam = (org.geonetwork.gaap.domain.web.request.GetUsers) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetUsers.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    List<User> users = skel.retrieveAllUsers(wrappedParam.getAuthToken());
                    GetUsersResponse.setUsers(users);

                    envelope = toEnvelope(getSOAPFactory(msgContext), GetUsersResponse, false);


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

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.DeleteUserResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.DeleteUserResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.DeleteUserResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.GetUserResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.GetUserResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.GetUserResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.GetUsersResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.GetUsersResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.GetUsersResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.UpdateUserResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.UpdateUserResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.UpdateUserResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.CreateUserResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.CreateUserResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.CreateUserResponse");
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.DeleteUserResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.GetUserResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.GetUsersResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.UpdateUserResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.CreateUserResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }
}//end of class