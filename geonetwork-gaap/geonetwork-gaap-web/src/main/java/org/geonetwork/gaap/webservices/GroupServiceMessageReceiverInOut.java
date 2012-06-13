/**
 * GroupServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.geonetwork.gaap.webservices;

import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.GetGroupResponse;
import org.geonetwork.gaap.domain.web.response.GetGroupsResponse;
import org.geonetwork.gaap.domain.group.Group;

import java.util.List;

/**
 * GroupServiceMessageReceiverInOut message receiver
 */

public class GroupServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {

    public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
            throws org.apache.axis2.AxisFault {

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            GroupServiceSkeleton skel = (GroupServiceSkeleton) obj;
            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;
            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
            if (op == null) {
                throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;
            if ((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)) {


                if ("DeleteGroup".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.DeleteGroupResponse response = new org.geonetwork.gaap.domain.web.response.DeleteGroupResponse();
                    org.geonetwork.gaap.domain.web.request.DeleteGroup wrappedParam = (org.geonetwork.gaap.domain.web.request.DeleteGroup) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.DeleteGroup.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    skel.deleteGroup(wrappedParam.getGroupUuid(), wrappedParam.getAuthToken());
                    response.setStatus(ResponseStatusCode.OK);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if ("UpdateGroup".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.UpdateGroupResponse response = new org.geonetwork.gaap.domain.web.response.UpdateGroupResponse();
                    org.geonetwork.gaap.domain.web.request.UpdateGroup wrappedParam = (org.geonetwork.gaap.domain.web.request.UpdateGroup) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.UpdateGroup.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    skel.updateGroup(wrappedParam.getGroup(), wrappedParam.getAuthToken());
                    response.setStatus(ResponseStatusCode.OK);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if ("CreateGroup".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.CreateGroupResponse response = new org.geonetwork.gaap.domain.web.response.CreateGroupResponse();
                    org.geonetwork.gaap.domain.web.request.CreateGroup wrappedParam = (org.geonetwork.gaap.domain.web.request.CreateGroup) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.CreateGroup.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    skel.createGroup(wrappedParam.getGroup(), wrappedParam.getAuthToken());
                    response.setStatus(ResponseStatusCode.OK);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if ("GetGroup".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetGroupResponse response = new org.geonetwork.gaap.domain.web.response.GetGroupResponse();
                    org.geonetwork.gaap.domain.web.request.GetGroup wrappedParam = (org.geonetwork.gaap.domain.web.request.GetGroup) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetGroup.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    org.geonetwork.gaap.domain.group.Group group = skel.retrieveGroup(wrappedParam.getGroupUuid(), wrappedParam.getAuthToken());
                    response.setGroup(group);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if ("GetGroups".equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetGroupsResponse response = new org.geonetwork.gaap.domain.web.response.GetGroupsResponse();
                    org.geonetwork.gaap.domain.web.request.GetGroups wrappedParam = (org.geonetwork.gaap.domain.web.request.GetGroups) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetGroups.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));


                    List<Group> groups = skel.retrieveAllGroups(wrappedParam.getAuthToken());
                    response.setGroups(groups);

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else {
                    throw new java.lang.RuntimeException("method not found");
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

        catch (java.lang.Exception e) {
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

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.CreateGroupResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.CreateGroupResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.CreateGroupResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.UpdateGroupResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.UpdateGroupResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.UpdateGroupResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.DeleteGroupResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.DeleteGroupResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.DeleteGroupResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.GetGroupResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.GetGroupResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.GetGroupResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.GetGroupsResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.GetGroupsResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.GetGroupsResponse");
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.CreateGroupResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.UpdateGroupResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.DeleteGroupResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.GetGroupResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.GetGroupsResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }
}//end of class
