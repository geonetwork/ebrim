/**
 * GroupServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.geonetwork.gaap.webservices;

import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;

import java.util.List;
import java.util.ArrayList;

/**
 * MetadataPermissionsMessageReceiverInOut message receiver
 */

public class MetadataPermissionsMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    private static final String METHOD_FILTERMETADATA = "FilterMetadata";
    private static final String METHOD_FILTERMETADATABYGROUPS = "FilterMetadataByGroups";
    private static final String METHOD_SAVEPERMISSIONS = "SavePermissions";
    private static final String METHOD_SAVEMETATADAPERMISSION = "SaveMetadataPermission";
    private static final String METHOD_DELETEMETATADAPERMISSION = "DeleteMetadataPermission";
    private static final String METHOD_GETPERMISSIONS = "GetPermissions";
    private static final String METHOD_GETOPERATION = "GetOperation";
    private static final String METHOD_GETOPERATIONS = "GetOperations";
    private static final String METHOD_UPDATEOPERATION = "UpdateOperation";

    public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
            throws org.apache.axis2.AxisFault {

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            MetadataPermissionsServiceSkeleton skel = (MetadataPermissionsServiceSkeleton) obj;
            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;
            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
            if (op == null) {
                throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            String methodName;
            if ((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)) {

                if (METHOD_FILTERMETADATA.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.FilterMetadataResponse response = new org.geonetwork.gaap.domain.web.response.FilterMetadataResponse();
                    org.geonetwork.gaap.domain.web.request.FilterMetadata wrappedParam = (org.geonetwork.gaap.domain.web.request.FilterMetadata) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.FilterMetadata.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        List<String> filteredMetadata = skel.filterMetadata(wrappedParam.getMetadataUuids(), wrappedParam.getUserName(), wrappedParam.getAuthToken());
                        response.setMetadataUuids(filteredMetadata);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if (METHOD_FILTERMETADATABYGROUPS.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.FilterMetadataByGroupsResponse response = new org.geonetwork.gaap.domain.web.response.FilterMetadataByGroupsResponse();
                    org.geonetwork.gaap.domain.web.request.FilterMetadataByGroups wrappedParam = (org.geonetwork.gaap.domain.web.request.FilterMetadataByGroups) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.FilterMetadataByGroups.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        List<String> filteredMetadata = skel.filterMetadataByGroups(wrappedParam.getGroupUuids(), wrappedParam.getAuthToken());
                        response.setMetadataUuids(filteredMetadata);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                /*} else if (METHOD_SAVEPERMISSIONS.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.ResponseReport response = new org.geonetwork.gaap.domain.web.response.ResponseReport();
                    org.geonetwork.gaap.domain.web.request.SaveMetadataPermissions wrappedParam = (org.geonetwork.gaap.domain.web.request.SaveMetadataPermissions) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.SaveMetadataPermissions.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        skel.savePermissions(wrappedParam.getPermissions(), wrappedParam.getAuthToken());
                        response.setStatus(ResponseStatusCode.OK);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);*/

                } else if (METHOD_GETOPERATION.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetOperationResponse response = new org.geonetwork.gaap.domain.web.response.GetOperationResponse();
                    org.geonetwork.gaap.domain.web.request.GetOperation wrappedParam = (org.geonetwork.gaap.domain.web.request.GetOperation) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetOperation.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        Operation operation = skel.getOperation(wrappedParam.getOperationName(), wrappedParam.getAuthToken());
                        response.setStatus(ResponseStatusCode.OK);
                        response.setOperation(operation);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if (METHOD_GETOPERATIONS.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetOperationsResponse response = new org.geonetwork.gaap.domain.web.response.GetOperationsResponse();
                    org.geonetwork.gaap.domain.web.request.GetOperations wrappedParam = (org.geonetwork.gaap.domain.web.request.GetOperations) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetOperations.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        List<Operation> operations = skel.getOperations(wrappedParam.getAuthToken());
                        response.setStatus(ResponseStatusCode.OK);
                        response.setOperations(operations);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if (METHOD_GETPERMISSIONS.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.GetMetadataPermissionsResponse response = new org.geonetwork.gaap.domain.web.response.GetMetadataPermissionsResponse();
                    org.geonetwork.gaap.domain.web.request.GetMetadataPermissions wrappedParam = (org.geonetwork.gaap.domain.web.request.GetMetadataPermissions) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.GetMetadataPermissions.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        MetadataPermissions permissions = skel.getPermissions(wrappedParam.getMetadataUuid(), wrappedParam.getAuthToken());
                        response.setStatus(ResponseStatusCode.OK);
                        response.setMetadataPermissions(permissions);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if (METHOD_UPDATEOPERATION.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.UpdateOperationResponse response = new org.geonetwork.gaap.domain.web.response.UpdateOperationResponse();
                    org.geonetwork.gaap.domain.web.request.UpdateOperation wrappedParam = (org.geonetwork.gaap.domain.web.request.UpdateOperation) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.UpdateOperation.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        skel.updateOperation(wrappedParam.getOperation(), wrappedParam.getAuthToken());
                        response.setStatus(ResponseStatusCode.OK);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if (METHOD_SAVEMETATADAPERMISSION.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.SaveMetadataPermissionResponse response = new org.geonetwork.gaap.domain.web.response.SaveMetadataPermissionResponse();
                    org.geonetwork.gaap.domain.web.request.SaveMetadataPermission wrappedParam = (org.geonetwork.gaap.domain.web.request.SaveMetadataPermission) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.SaveMetadataPermission.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        skel.saveMetadataPermission(wrappedParam.getMetadataUuid(), wrappedParam.getGroupUuid(), wrappedParam.getOperationName(), wrappedParam.getAuthToken());
                        response.setStatus(ResponseStatusCode.OK);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);

                } else if (METHOD_DELETEMETATADAPERMISSION.equals(methodName)) {
                    org.geonetwork.gaap.domain.web.response.DeleteMetadataPermissionResponse response = new org.geonetwork.gaap.domain.web.response.DeleteMetadataPermissionResponse();
                    org.geonetwork.gaap.domain.web.request.DeleteMetadataPermission wrappedParam = (org.geonetwork.gaap.domain.web.request.DeleteMetadataPermission) fromOM(
                            msgContext.getEnvelope().getBody().getFirstElement(),
                            org.geonetwork.gaap.domain.web.request.DeleteMetadataPermission.class,
                            getEnvelopeNamespaces(msgContext.getEnvelope()));

                    try {
                        skel.deleteMetadataPermission(wrappedParam.getMetadataUuid(), wrappedParam.getGroupUuid(), wrappedParam.getOperationName(), wrappedParam.getAuthToken());
                        response.setStatus(ResponseStatusCode.OK);
                    }
                    catch (GaapServiceFault e) {
                        response.setStatus(ResponseStatusCode.ERROR);
                        List<String> exceptionList = new ArrayList<String>();
                        exceptionList.add(e.getMessage());
                        response.setExceptionList(exceptionList);
                    }

                    envelope = toEnvelope(getSOAPFactory(msgContext), response, false);
                } else {
                    throw new RuntimeException("method not found");
                }


                newMsgContext.setEnvelope(envelope);
            }
            /*} catch (GaapServiceFault e) {

          msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME, "gaapService");
          org.apache.axis2.AxisFault f = createAxisFault(e);
          if (e.getFaultMessage() != null) {
              f.setDetail(toOM(e.getFaultMessage(), false));
          }
          throw f; */
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

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.FilterMetadataResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.FilterMetadataResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.FilterMetadataResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.GetOperationResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.GetOperationResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.GetOperationResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.GetOperationsResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.GetOperationsResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.GetOperationsResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.FilterMetadataByGroupsResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.FilterMetadataByGroupsResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.FilterMetadataByGroupsResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.GetMetadataPermissionsResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.GetPermissionsResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.GetPermissionsResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.UpdateOperationResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.UpdateOperationResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.UpdateOperationResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.SaveMetadataPermissionResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.SaveMetadataPermissionResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.SaveMetadataPermissionResponse");
        }

    }

    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.response.DeleteMetadataPermissionResponse param, boolean optimizeContent) {
        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.response.DeleteMetadataPermissionResponse");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.response.DeleteMetadataPermissionResponse");
        }

    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.FilterMetadataResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.GetOperationResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.GetOperationsResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.FilterMetadataByGroupsResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.GetMetadataPermissionsResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.UpdateOperationResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.SaveMetadataPermissionResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                                          org.geonetwork.gaap.domain.web.response.DeleteMetadataPermissionResponse param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }
        return envelope;
    }

}//end of class