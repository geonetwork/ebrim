<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	
	<!--	Extrinsic Objects -->
	
	<!--	OGC 07-038 Section D.2 CIM extrinsic objects -->
	
	<xsl:variable name="applicationObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:Application</xsl:text>
	</xsl:variable>

	<xsl:variable name="datasetCollectionObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:DatasetCollection</xsl:text>
	</xsl:variable>

	<xsl:variable name="elementaryDatasetObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ElementaryDataset</xsl:text>
	</xsl:variable>
		
	<xsl:variable name="resourceMetadataObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ResourceMetadata</xsl:text>
	</xsl:variable>

	<xsl:variable name="dataMetadataObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:DataMetadata</xsl:text>
	</xsl:variable>	
			
	<xsl:variable name="serviceMetadataObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ServiceMetadata</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="responsiblePartyObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ResponsibleParty</xsl:text>
	</xsl:variable>

	<xsl:variable name="metadataInformationObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:MetadataInformation</xsl:text>
	</xsl:variable>

	<xsl:variable name="legalConstraintsObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:LegalConstraints</xsl:text>
	</xsl:variable>	

	<xsl:variable name="securityConstraintsObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:SecurityConstraints</xsl:text>
	</xsl:variable>	
				
	<xsl:variable name="identifiedItemObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:IdentifiedItem</xsl:text>
	</xsl:variable>

	<xsl:variable name="serviceOperationObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ServiceOperation</xsl:text>
	</xsl:variable>

	<xsl:variable name="citedItemObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:ObjectType:CitedItem</xsl:text>
	</xsl:variable>
							

	<xsl:variable name="serviceObjectType">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:Service</xsl:text>
	</xsl:variable>
	
	<!--
			heikki: note that in 07-038 all mentions of DataSet are of type "urn:x-ogc:specification:csw-ebrim-cim:ObjectType:Dataset". However
			this type is not defined anywhere; so I'm preferring the type defined in the basic extension package (07-144r2).
	-->
	<xsl:variable name="datasetObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:Dataset</xsl:text>
	</xsl:variable>		

	<xsl:variable name="rightsObjectType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ObjectType:Rights</xsl:text>
	</xsl:variable>
		
	<!--	ClassificationSchemes -->
	
	<!--	OGC 07-038 section D.4 CIM classification schemes -->

	<xsl:variable name="topicCategoryCodeClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:TopicCategoryCode</xsl:text>
	</xsl:variable>	

	<xsl:variable name="spatialRepresentationTypeClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:SpatialRepresentationType</xsl:text>
	</xsl:variable>	

	<!--	in Frederic Houbert's files, it's urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet -->
	<!--	but that is not according to the spec ! TODO tell him -->
	<xsl:variable name="characterSetClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:CharacterSet</xsl:text>
	</xsl:variable>	

	

	<xsl:variable name="keywordTypeCodeClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:KeywordTypeCode</xsl:text>
	</xsl:variable>	

	<xsl:variable name="keywordSchemeClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:KeywordScheme</xsl:text>
	</xsl:variable>
			
	<xsl:variable name="restrictionCodeClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:RestrictionCode</xsl:text>
	</xsl:variable>	
	
	<xsl:variable name="restrictionTypeClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:RestrictionType</xsl:text>
	</xsl:variable>	

	<xsl:variable name="classificationCodeClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:ClassificationCode</xsl:text>
	</xsl:variable>

	<xsl:variable name="DCPListClassificationScheme">
		<xsl:text>urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:DCPList</xsl:text>
	</xsl:variable>
		
	
		
	<xsl:variable name="citedResponsiblePartyClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:CitedResponsibleParty</xsl:text>
	</xsl:variable>	

	<!-- ClassificationNodes -->

	<xsl:variable name="citedResponsiblePartyPointOfContactClassificationNode">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationNode:CitedResponsibleParty:PointOfContact</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="citedResponsiblePartyAuthorClassificationNode">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationNode:CitedResponsibleParty:Author</xsl:text>
	</xsl:variable>

	<xsl:variable name="citedResponsiblePartyPublisherClassificationNode">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationNode:CitedResponsibleParty:Publisher</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="citedResponsiblePartyOriginatorClassificationNode">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationNode:CitedResponsibleParty:Originator</xsl:text>
	</xsl:variable>	


	<!-- Associations -->

	<xsl:variable name="isClientOfAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:IsClientOf</xsl:text>
	</xsl:variable>	
	
	<xsl:variable name="accessesAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:Accesses</xsl:text>
	</xsl:variable>	
	
	<xsl:variable name="subsetAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:Subset</xsl:text>
	</xsl:variable>	
	
	<xsl:variable name="datasetDescriptionAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:DatasetDescription</xsl:text>
	</xsl:variable>	
		
	<xsl:variable name="serviceDescriptionAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:ServiceDescription</xsl:text>
	</xsl:variable>

	<xsl:variable name="applicationDescriptionAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:ApplicationDescription</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="resourceMetadataInformationAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:ResourceMetadataInformation</xsl:text>
	</xsl:variable>

	<xsl:variable name="parentMetadataInformationAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:ParentMetadataInformation</xsl:text>
	</xsl:variable>	
	
	<xsl:variable name="resourceReferenceSystemAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:ResourceReferenceSystem</xsl:text>
	</xsl:variable>

	<xsl:variable name="citedResponsiblePartyAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:CitedResponsibleParty</xsl:text>
	</xsl:variable>		

	<xsl:variable name="containsOperationAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:ContainsOperation</xsl:text>
	</xsl:variable>		
	
	<xsl:variable name="resourceConstraintsAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:ResourceConstraints</xsl:text>
	</xsl:variable>	

	<xsl:variable name="codeSpaceAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:CodeSpace</xsl:text>
	</xsl:variable>	

	<xsl:variable name="authorityAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:Authority</xsl:text>
	</xsl:variable>	
	
	<xsl:variable name="operatesOnAssociationType">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:AssociationType:OperatesOn</xsl:text>
	</xsl:variable>	

	<!--	Slots -->
	
	<!--	OGC 07-038 section D.6 CIM slots -->
	
	<xsl:variable name="createdSlotName">
		<xsl:text>http://purl.org/dc/terms/created</xsl:text>
	</xsl:variable>	

	<xsl:variable name="modifiedSlotName">
		<xsl:text>http://purl.org/dc/terms/modified</xsl:text>
	</xsl:variable>		
		
	<xsl:variable name="issuedSlotName">
		<xsl:text>http://purl.org/dc/terms/issued</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="resolutionSlotName">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:Slot:resolution</xsl:text>
	</xsl:variable>
		
	<xsl:variable name="scaleDenominatorSlotName">
		<xsl:text>urn:x-ogc:specification:csw-ebrim-cim:Slot:scaleDenominator</xsl:text>
	</xsl:variable>
	
	<!--	OGC 07-144r2 section 9 Slots -->

	<xsl:variable name="contributorSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/contributor</xsl:text>
	</xsl:variable>	

	<xsl:variable name="spatialSlotName">
		<xsl:text>http://purl.org/dc/terms/spatial</xsl:text>
	</xsl:variable>	

	<xsl:variable name="temporalSlotName">
		<xsl:text>http://purl.org/dc/terms/temporal</xsl:text>
	</xsl:variable>

	<xsl:variable name="creatorSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/creator</xsl:text>
	</xsl:variable>
					
	<xsl:variable name="dateSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/date</xsl:text>
	</xsl:variable>		

	<!--	slot Modified is re-defined (without changing it) in OGC 07-038 -->

	<xsl:variable name="languageSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/language</xsl:text>
	</xsl:variable>
		
	<xsl:variable name="rightsSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/rights</xsl:text>
	</xsl:variable>

	<xsl:variable name="sourceSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/source</xsl:text>
	</xsl:variable>

	<xsl:variable name="subjectSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/subject</xsl:text>
	</xsl:variable>
				
	<xsl:variable name="formatSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/format</xsl:text>
	</xsl:variable>		
			
	<xsl:variable name="coverageSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/coverage</xsl:text>
	</xsl:variable>	
	
	
	
	
							
	<xsl:variable name="conformsToSlotName">
		<xsl:text>http://purl.org/dc/terms/conformsTo</xsl:text>
	</xsl:variable>		

	<xsl:variable name="dateSlotType">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:DataType:Date</xsl:text>
	</xsl:variable>	

	<!--	"The slot ‘language’ is of type Language, defined in the ebRIM specification." -->
	<xsl:variable name="languageSlotType">
		<xsl:text>urn:ogc:def:dataType:RFC-4646:Language</xsl:text>
	</xsl:variable>	
		
	<xsl:variable name="titleSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/title</xsl:text>
	</xsl:variable>		

	<xsl:variable name="identifierSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/identifier</xsl:text>
	</xsl:variable>	
	
	<xsl:variable name="typeSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/type</xsl:text>
	</xsl:variable>	

	<xsl:variable name="envelopeSlotType">
		<xsl:text>urn:ogc:def:dataType:ISO-19107:GM_Envelope</xsl:text>
	</xsl:variable>	
	
	<xsl:variable name="dateTimeSlotType">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:DataType:DateTime</xsl:text>
	</xsl:variable>		
	
	<xsl:variable name="abstractSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/abstract</xsl:text>
	</xsl:variable>	
	

	
	<xsl:variable name="stringSlotType">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:DataType:String</xsl:text>
	</xsl:variable>		
</xsl:stylesheet>
