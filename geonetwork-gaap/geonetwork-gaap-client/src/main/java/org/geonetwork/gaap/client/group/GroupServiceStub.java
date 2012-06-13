/**
 * GroupServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.geonetwork.gaap.client.group;

import org.geonetwork.gaap.client.group.GroupService;


/*
*  GroupServiceStub java implementation
*/


public class GroupServiceStub extends org.apache.axis2.client.Stub
        implements GroupService {
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }
        counter = counter + 1;
        return Long.toString(System.currentTimeMillis()) + "_" + counter;
    }


    private void populateAxisService() throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("GroupService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[5];

        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "UpdateGroup"));
        _service.addOperation(__operation);


        _operations[0] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "DeleteGroup"));
        _service.addOperation(__operation);


        _operations[1] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "CreateGroup"));
        _service.addOperation(__operation);


        _operations[2] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "GetGroups"));
        _service.addOperation(__operation);


        _operations[3] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "GetGroup"));
        _service.addOperation(__operation);


        _operations[4] = __operation;


    }

    //populates the faults
    private void populateFaults() {

        faultExceptionNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultMessageMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.services.exception.GaapExceptionData");

        faultExceptionNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultMessageMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.services.exception.GaapExceptionData");

        faultExceptionNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultMessageMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.services.exception.GaapExceptionData");

        faultExceptionNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultMessageMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.services.exception.GaapExceptionData");

        faultExceptionNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.client.GaapServiceFault");
        faultMessageMap.put(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService", "gaapService"), "org.geonetwork.gaap.services.exception.GaapExceptionData");


    }

    /**
     * Constructor that takes in a configContext
     */

    public GroupServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                            java.lang.String targetEndpoint)
            throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }


    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public GroupServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                            java.lang.String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);


        configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);


    }

    /**
     * Default Constructor
     */
    public GroupServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

        this(configurationContext, "http://localhost:8080/axis2/services/GroupService");

    }

    /**
     * Default Constructor
     */
    public GroupServiceStub() throws org.apache.axis2.AxisFault {

        this("http://localhost:8080/axis2/services/GroupService");

    }

    /**
     * Constructor taking the target endpoint
     */
    public GroupServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }


    /**
     * Auto generated method signature
     *
     * @param UpdateGroup
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     * @see org.geonetwork.gaap.client.group.GroupService#UpdateGroup
     */


    public org.geonetwork.gaap.domain.web.response.UpdateGroupResponse UpdateGroup(

            org.geonetwork.gaap.domain.web.request.UpdateGroup UpdateGroup)


            throws java.rmi.RemoteException


            , org.geonetwork.gaap.client.GaapServiceFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("urn:UpdateGroup");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    UpdateGroup,
                    optimizeContent(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService",
                            "UpdateGroup")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    org.geonetwork.gaap.domain.web.response.UpdateGroupResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (org.geonetwork.gaap.domain.web.response.UpdateGroupResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof org.geonetwork.gaap.client.GaapServiceFault) {
                            throw (org.geonetwork.gaap.client.GaapServiceFault) ex;
                        }


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     *
     * @param DeleteGroup
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     * @see org.geonetwork.gaap.client.group.GroupService#DeleteGroup
     */


    public org.geonetwork.gaap.domain.web.response.DeleteGroupResponse DeleteGroup(

            org.geonetwork.gaap.domain.web.request.DeleteGroup DeleteGroup)


            throws java.rmi.RemoteException


            , org.geonetwork.gaap.client.GaapServiceFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions().setAction("urn:DeleteGroup");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    DeleteGroup,
                    optimizeContent(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService",
                            "DeleteGroup")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    org.geonetwork.gaap.domain.web.response.DeleteGroupResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (org.geonetwork.gaap.domain.web.response.DeleteGroupResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof org.geonetwork.gaap.client.GaapServiceFault) {
                            throw (org.geonetwork.gaap.client.GaapServiceFault) ex;
                        }


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     *
     * @param CreateGroup
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     * @see org.geonetwork.gaap.client.group.GroupService#CreateGroup
     */


    public org.geonetwork.gaap.domain.web.response.CreateGroupResponse CreateGroup(

            org.geonetwork.gaap.domain.web.request.CreateGroup CreateGroup)


            throws java.rmi.RemoteException


            , org.geonetwork.gaap.client.GaapServiceFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
            _operationClient.getOptions().setAction("urn:CreateGroup");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    CreateGroup,
                    optimizeContent(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService",
                            "CreateGroup")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    org.geonetwork.gaap.domain.web.response.CreateGroupResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (org.geonetwork.gaap.domain.web.response.CreateGroupResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof org.geonetwork.gaap.client.GaapServiceFault) {
                            throw (org.geonetwork.gaap.client.GaapServiceFault) ex;
                        }


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     *
     * @param GetGroups
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     * @see org.geonetwork.gaap.client.group.GroupService#GetGroups
     */


    public org.geonetwork.gaap.domain.web.response.GetGroupsResponse GetGroups(

            org.geonetwork.gaap.domain.web.request.GetGroups GetGroups)


            throws java.rmi.RemoteException


            , org.geonetwork.gaap.client.GaapServiceFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
            _operationClient.getOptions().setAction("urn:GetGroups");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    GetGroups,
                    optimizeContent(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService",
                            "GetGroups")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    org.geonetwork.gaap.domain.web.response.GetGroupsResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (org.geonetwork.gaap.domain.web.response.GetGroupsResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof org.geonetwork.gaap.client.GaapServiceFault) {
                            throw (org.geonetwork.gaap.client.GaapServiceFault) ex;
                        }


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * Auto generated method signature
     *
     * @param GetGroup
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     * @see org.geonetwork.gaap.client.group.GroupService#GetGroup
     */


    public org.geonetwork.gaap.domain.web.response.GetGroupResponse GetGroup(

            org.geonetwork.gaap.domain.web.request.GetGroup GetGroup)


            throws java.rmi.RemoteException


            , org.geonetwork.gaap.client.GaapServiceFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
            _operationClient.getOptions().setAction("urn:GetGroup");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    GetGroup,
                    optimizeContent(new javax.xml.namespace.QName("http://geonetwork.org/gaap/services/GroupService",
                            "GetGroup")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    org.geonetwork.gaap.domain.web.response.GetGroupResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (org.geonetwork.gaap.domain.web.response.GetGroupResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex =
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof org.geonetwork.gaap.client.GaapServiceFault) {
                            throw (org.geonetwork.gaap.client.GaapServiceFault) ex;
                        }


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
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


    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName) {


        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }

    //http://localhost:8080/axis2/services/GroupService
    private static final org.jibx.runtime.IBindingFactory bindingFactory;
    private static final String bindingErrorMessage;
    private static final int[] bindingNamespaceIndexes;
    private static final String[] bindingNamespacePrefixes;

    static {
        org.jibx.runtime.IBindingFactory factory = null;
        String message = null;
        try {

            factory = org.jibx.runtime.BindingDirectory.getFactory(org.geonetwork.gaap.domain.web.request.UpdateGroup.class);

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
            while (--xsiindex >= 0 &&
                    !"http://www.w3.org/2001/XMLSchema-instance".equals(nsuris[xsiindex])) ;

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

    private static void addMappingNamespaces(org.apache.axiom.soap.SOAPFactory factory, org.apache.axiom.om.OMElement wrapper, String nsuri, String nspref) {
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


    private static Object fromOM(org.apache.axiom.om.OMElement param, Class type,
                                 java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {
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


    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.request.CreateGroup param, org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.request.CreateGroup");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.request.CreateGroup");
        }

    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.geonetwork.gaap.domain.web.request.CreateGroup param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }


    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.request.GetGroup param, org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.request.GetGroup");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.request.GetGroup");
        }

    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.geonetwork.gaap.domain.web.request.GetGroup param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }


    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.request.UpdateGroup param, org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.request.UpdateGroup");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.request.UpdateGroup");
        }

    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.geonetwork.gaap.domain.web.request.UpdateGroup param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }


    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.request.GetGroups param, org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.request.GetGroups");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.request.GetGroups");
        }

    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.geonetwork.gaap.domain.web.request.GetGroups param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }


    private org.apache.axiom.om.OMElement toOM(org.geonetwork.gaap.domain.web.request.DeleteGroup param, org.apache.axiom.soap.SOAPFactory factory, boolean optimizeContent) {

        if (param instanceof org.jibx.runtime.IMarshallable) {
            if (bindingFactory == null) {
                throw new RuntimeException(bindingErrorMessage);
            }
            return (mappedChild(param, factory));
        } else if (param == null) {
            throw new RuntimeException("Cannot bind null value of type org.geonetwork.gaap.domain.web.request.DeleteGroup");
        } else {
            throw new RuntimeException("No JiBX <mapping> defined for class org.geonetwork.gaap.domain.web.request.DeleteGroup");
        }

    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.geonetwork.gaap.domain.web.request.DeleteGroup param, boolean optimizeContent) {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        if (param != null) {
            envelope.getBody().addChild(toOM(param, factory, optimizeContent));
        }
        return envelope;
    }


    private Exception convertException(Exception ex) throws java.rmi.RemoteException {
        if (ex instanceof org.apache.axis2.AxisFault) {
            org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) ex;
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    try {

                        // first create the actual exception
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(faultElt.getQName());
                        Class exceptionClass = Class.forName(exceptionClassName);
                        Exception e = (Exception) exceptionClass.newInstance();

                        // build the message object from the details
                        String messageClassName = (String) faultMessageMap.get(faultElt.getQName());
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[]{messageClass});
                        m.invoke(e, new Object[]{messageObject});
                        return e;

                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }

        } else if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        } else if (ex instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException) ex;
        } else {
            throw org.apache.axis2.AxisFault.makeFault(ex);
        }
    }


}
   