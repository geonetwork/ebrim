<?xml version="1.0" encoding="UTF-8"?>
<!--
	Implementation of the mapping between ISO19139 to ebRIM as described in OGC 07-038 Section F2 Registration of
	a metadata record.

	@author Heikki Doeleman

	Section F.2 Registration of a metadata record

	A metadata record is an instance of the class MD_Metadata or one of its subclasses. Each metadata record will require:

		- the creation of a Registry Object based on the MetadataInformation Extrinsic Object to handle the information related to the
		metadata record itself: file identifier, language used and date of creation, as defined in Table (heikki: they mean table F.1);

		- the creation of a Registry Object based on the DataMetadata or ServiceMetadata Extrinsic Objects for each instance
		of MD_Metadata.identificationInfo to handle among other things some of the properties of MD_Metadata:hierarchylevel information
		and possibly links to the metadata record and parent metadata record information stored in two instances of the MetadataInformation
		Extrinsic Object. Table (heikki: TODO which table) defines the mapping of this information to DataMetadata and/or ServiceMetadata. The mapping of the actual
		content of MD_Metadata.identificationInfo to DataMetadata and ServiceMetadata is defined in clause F.3.

		- when the parentIdentifier attribute is instantiated, a second instance of MetadataInformation will be created, along with an instance
		of the ParentMetadataInformation association between ResourceMetadata and MetadataInformation.

-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:rim="urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0" xmlns:wrs="http://www.opengis.net/cat/wrs/1.0" xmlns:gco="http://www.isotc211.org/2005/gco" xmlns:gmx="http://www.isotc211.org/2005/gmx" xmlns:srv="http://www.isotc211.org/2005/srv" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<!-- Ideally this include should be used, but Xalan does not seem to find the included stylesheet ?!
	<xsl:include href="ISO19139toCIM.Constants.xslt"/>
-->
	<!--	Extrinsic Objects -->
	<!--	OGC 07-038r3 Classification nodes > Object types -->
	<xsl:variable name="applicationObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:Application</xsl:text>
	</xsl:variable>
	<xsl:variable name="datasetCollectionObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:DatasetCollection</xsl:text>
	</xsl:variable>
	<xsl:variable name="elementaryDatasetObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:ElementaryDataset</xsl:text>
	</xsl:variable>
	<xsl:variable name="resourceMetadataObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:ResourceMetadata</xsl:text>
	</xsl:variable>
	<xsl:variable name="dataMetadataObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:DataMetadata</xsl:text>
	</xsl:variable>
	<xsl:variable name="serviceMetadataObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:ServiceMetadata</xsl:text>
	</xsl:variable>
	<xsl:variable name="responsiblePartyObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:ResponsibleParty</xsl:text>
	</xsl:variable>
	<xsl:variable name="metadataInformationObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:MetadataInformation</xsl:text>
	</xsl:variable>
	<xsl:variable name="legalConstraintsObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:LegalConstraints</xsl:text>
	</xsl:variable>
	<xsl:variable name="securityConstraintsObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:SecurityConstraints</xsl:text>
	</xsl:variable>
	<xsl:variable name="identifiedItemObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:IdentifiedItem</xsl:text>
	</xsl:variable>
	<xsl:variable name="serviceOperationObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:ServiceOperation</xsl:text>
	</xsl:variable>
	<xsl:variable name="citedItemObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:CitedItem</xsl:text>
	</xsl:variable>
	<xsl:variable name="serviceObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:Service</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="referenceSpecificationObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:ReferenceSpecification</xsl:text>
	</xsl:variable>


	<xsl:variable name="organizationObjectType">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:Organization</xsl:text>
	</xsl:variable>

	<!--
			heikki: note that in 07-038 all mentions of DataSet are of type "urn:x-ogc:specification:csw-ebrim-cim:ObjectType:Dataset". However
			this type is not defined anywhere; so I'm preferring the type defined in the basic extension package (07-144r2).
	-->
	<xsl:variable name="datasetObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:Dataset</xsl:text>
	</xsl:variable>
	<xsl:variable name="rightsObjectType">
		<xsl:text>urn:ogc:def:ebRIM-ObjectType:OGC:Rights</xsl:text>
	</xsl:variable>
	<!--	ClassificationSchemes -->
	<!--	basic extension package	-->
	<xsl:variable name="servicesClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:Services</xsl:text>
	</xsl:variable>
	<!--	OGC 07-038 section D.4 CIM classification schemes -->
	<xsl:variable name="topicCategoryCodeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:TopicCategory</xsl:text>
	</xsl:variable>
	<xsl:variable name="spatialRepresentationTypeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:SpatialRepresentation</xsl:text>
	</xsl:variable>
	<!--	in Frederic Houbert's files, it's urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet -->
	<!--	but that is not according to the spec ! TODO tell him -->
	<xsl:variable name="characterSetClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet</xsl:text>
	</xsl:variable>
	<xsl:variable name="keywordTypeCodeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:KeywordType</xsl:text>
	</xsl:variable>
	<xsl:variable name="keywordSchemeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:KeywordScheme</xsl:text>
	</xsl:variable>
	<xsl:variable name="restrictionCodeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:RestrictionCode</xsl:text>
	</xsl:variable>
	<xsl:variable name="restrictionTypeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:RestrictionType</xsl:text>
	</xsl:variable>
	<xsl:variable name="classificationCodeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:ClassificationCode</xsl:text>
	</xsl:variable>
	<xsl:variable name="DCPListClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:DCPList</xsl:text>
	</xsl:variable>
	<xsl:variable name="citedResponsiblePartyClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:CitedResponsibleParty</xsl:text>
	</xsl:variable>
	<xsl:variable name="couplingTypeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:CouplingType</xsl:text>
	</xsl:variable>
	<xsl:variable name="metadataStandardNameAndVersionClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:MetadataStandardNameAndVersion</xsl:text>
	</xsl:variable>
	<xsl:variable name="formatNameAndVersionClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:FormatNameAndVersion</xsl:text>
	</xsl:variable>
	<xsl:variable name="dateTypeClassificationScheme">
		<xsl:text>urn:ogc:def:ebRIM-ClassificationScheme:DateType</xsl:text>
	</xsl:variable>
	<xsl:variable name="objectTypeClassificationScheme">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:classificationScheme:ObjectType</xsl:text>
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
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:IsClientOf</xsl:text>
	</xsl:variable>
	<xsl:variable name="accessesAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:Accesses</xsl:text>
	</xsl:variable>
	<xsl:variable name="subsetAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:Subset</xsl:text>
	</xsl:variable>
	<xsl:variable name="datasetDescriptionAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:DatasetDescription</xsl:text>
	</xsl:variable>
	<xsl:variable name="serviceDescriptionAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:ServiceDescription</xsl:text>
	</xsl:variable>
	<xsl:variable name="applicationDescriptionAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:ApplicationDescription</xsl:text>
	</xsl:variable>
	<xsl:variable name="resourceMetadataInformationAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:ResourceMetadataInformation</xsl:text>
	</xsl:variable>
	<xsl:variable name="parentMetadataInformationAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:ParentMetadataInformation</xsl:text>
	</xsl:variable>
	<xsl:variable name="resourceReferenceSystemAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:ResourceReferenceSystem</xsl:text>
	</xsl:variable>
	<xsl:variable name="citedResponsiblePartyAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:CitedResponsibleParty</xsl:text>
	</xsl:variable>
	<xsl:variable name="containsOperationAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:ContainsOperation</xsl:text>
	</xsl:variable>
	<xsl:variable name="resourceConstraintsAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:ResourceConstraints</xsl:text>
	</xsl:variable>
	<xsl:variable name="codeSpaceAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:CodeSpace</xsl:text>
	</xsl:variable>
	<xsl:variable name="authorityAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:Authority</xsl:text>
	</xsl:variable>
	<xsl:variable name="operatesOnAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:OperatesOn</xsl:text>
	</xsl:variable>
	<xsl:variable name="specificationAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:Specification</xsl:text>
	</xsl:variable>
	<xsl:variable name="metadataPointOfContactAssociationType">
		<xsl:text>urn:ogc:def:ebRIM-AssociationType:OGC:MetadataPointOfContact</xsl:text>
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
	<xsl:variable name="referencesSlotType">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:DataType:URI</xsl:text>
	</xsl:variable>
	<!--	"The slot ‘language’ is of type Language, defined in the ebRIM specification." -->
	<xsl:variable name="languageSlotType">
		<xsl:text>urn:ogc:def:dataType:RFC-4646:LanguageTag</xsl:text>
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
	<xsl:variable name="temporalSlotType">
		<xsl:text>urn:ogc:def:dataType:ISO-19108:2002:TM_Period</xsl:text>
	</xsl:variable>
	<xsl:variable name="abstractSlotName">
		<xsl:text>http://purl.org/dc/elements/1.1/abstract</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="conformanceSlotName">
		<xsl:text>Conformance</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="stringSlotType">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:DataType:String</xsl:text>
	</xsl:variable>
	
	<xsl:variable name="internationalStringSlotType">
		<xsl:text>urn:oasis:names:tc:ebxml-regrep:DataType:InternationalString</xsl:text>
	</xsl:variable>
	
	<!--	end of part that should have been xsl:included -->
	<xsl:template match="gmd:MD_Metadata">
		<rim:RegistryObjectList>
			<xsl:attribute name="iso19139Id"><xsl:value-of select="./gmd:fileIdentifier/gco:CharacterString"/></xsl:attribute>
			<!--
				Table F.1 - Metadata Information	(MetadataInformation Extrinsic Object)
				ISO 19115/ ISO 19119						CIM														Comments

				fileIdentifier										<<slot>> identifier
				language											<<slot>> language
				characterSet										<<classification>> CharacterSet				For each character set
				parentIdentifier									<<slot>> identifier									Concerns the second instance of
																																	MetadataInformation, when parentIdentifier
																																	is instantiated in the metadata
				hierarchyLevel									-															See Table
				hierarchyLevelName							-															Ignored
				contact												-															Ignored
				dateStamp										<<slot>> date
				metadataStandardName						<<slot>> conformsTo								Slot type is a two-level classification that
																																	handles both standard name and standard
																																	version
				metadataStandardVersion					<<slot>> conformsTo								Slot type is a two-level classification that
																																	handles both standard name and standard
																																	version
				datasetURI										-															Ignored
				locale												-															Ignored
				spatialRepresentationInfo					-															Ignored
				referenceSystemInfo							-															See Table F.2
				metadataExtensionInfo						-															Ignored
				identificationInfo									-															See Table F.2
				contentInfo										-															Ignored
				distributionInfo									-															See Table F.2
				dataQualityInfo									-															See Table 2
				portrayalCatalogueInfo						-															Ignored
				metadataConstraints							-															Ignored
				applicationSchemaInfo						-															Ignored
				metadataMaintenance						-															Ignored
		-->
			<!--	objectType from CIM extension package. "Metadata related to the record containing the resource metadata." -->
			<xsl:variable name="metadataInformationId" select="concat('metadataInformationId-', generate-id(.))"/>
			
					<rim:ExtrinsicObject id="{$metadataInformationId}" objectType="{$metadataInformationObjectType}">
						<!-- 	From fileIdentifier to <<slot>> identifier -->
						<xsl:call-template name="slot-identifier">
							<xsl:with-param name="identifier" select="./gmd:fileIdentifier/gco:CharacterString"/>
						</xsl:call-template>
						<!--	From language to <<slot>> language -->
						<xsl:choose>
							<xsl:when test="./gmd:language/gmd:LanguageCode">
								<xsl:call-template name="slot-language">
									<xsl:with-param name="language" select="./gmd:language/gmd:LanguageCode/@codeListValue"/>
									<!--xsl:with-param name="language" select="./gmd:language/gco:CharacterString"/-->
								</xsl:call-template>
							</xsl:when>
							<xsl:when test="./gmd:language/gco:CharacterString">
								<xsl:call-template name="slot-language">
									<xsl:with-param name="language" select="./gmd:language/gco:CharacterString"/>
								</xsl:call-template>
							</xsl:when>
						</xsl:choose>
						<!--	parentIdentifier : if present, another MetadataInformation Extrinsic Object is instantiated and a ParentMetadataInformation
					association. See below. -->
						<!--	hierarchyLevel : See Table ??  -->
						<!--	hierarchyLevelName, contact : Ignored -->
						<!--	From dateStamp to <<slot>> date -->
						<!--    Support Date and DateTime formats -->
						<xsl:if test="./gmd:dateStamp/gco:Date">
							<xsl:call-template name="slot-date">
								<xsl:with-param name="dateStamp" select="./gmd:dateStamp/gco:Date"/>
							</xsl:call-template>
						</xsl:if>
						<xsl:if test="./gmd:dateStamp/gco:DateTime">
							<xsl:call-template name="slot-date">
								<xsl:with-param name="dateStamp" select="./gmd:dateStamp/gco:DateTime"/>
							</xsl:call-template>
						</xsl:if>
						<!-- From metadataStandardName and metadataStandardVersion to <<slot>> conformsTo -->
						<xsl:call-template name="slot-conformsTo">
							<xsl:with-param name="metadataStandardName" select="./gmd:metadataStandardName/gco:CharacterString"/>
							<xsl:with-param name="metadataStandardVersion" select="./gmd:metadataStandardVersion/gco:CharacterString"/>
						</xsl:call-template>
						<!--	For each character set : <<classification>> CharacterSet -->
						<!-- heikki: spec says "For each", but only 1 is allowed. Whatever : -->
						<xsl:for-each select="gmd:characterSet">
							<xsl:variable name="charset" select="gmd:MD_CharacterSetCode/@codeListValue"/>
							<xsl:call-template name="classification-characterSet">
								<xsl:with-param name="characterSet" select="$charset"/>
								<xsl:with-param name="classifiedObjectId" select="$metadataInformationId"/>
							</xsl:call-template>
						</xsl:for-each>
						<!--	datasetURI, locale, spatialRepresentationInfo :	Ignored -->
						<!--	referenceSystemInfo 			See Table F.2 -->
						<!--	metadataExtensionInfo : Ignored	-->
						<!--	identificationInfo	: handled in resourcemetadata, see below  -->
						<!--	contentInfo : Ignored -->
						<!--	distributionInfo, dataQualityInfo	See Table F.2 -->
						<!--	portrayalCatalogueInfo, metadataConstraints, applicationSchemaInfo, metadataMaintenance : Ignored -->
					</rim:ExtrinsicObject>
			
			<!--	OGC 07-038 : "In this profile, the cardinality of this property is restricted to 1..1 for the ISO 19139 metadata files stored in the ebRIM Repository."
				This transformation does not use that restriction and relies on the caller of this transformation to not send non-compliant ISO metadata here. -->
			<xsl:for-each select="gmd:identificationInfo">
				<xsl:call-template name="resourceMetadata">
					<xsl:with-param name="metadataInformationId" select="$metadataInformationId"/>
				</xsl:call-template>
			</xsl:for-each>
			
			<!--	if parentIdentifier is present, a second instance of MetadataInformation will be created, along with an instance of the
				ParentMetadataInformation association between ResourceMetadata and MetadataInformation. -->
			<xsl:variable name="parentIdentifier" select="gmd:parentIdentifier/gco:CharacterString"/>
			<xsl:if test="$parentIdentifier">
				<xsl:call-template name="parentIdentifierMetadataInformation">
					<xsl:with-param name="childIdentifier" select="$metadataInformationId"/>
					<xsl:with-param name="parentIdentifier" select="$parentIdentifier"/>
				</xsl:call-template>
			</xsl:if>
		</rim:RegistryObjectList>
	</xsl:template>
	<xsl:template name="parentIdentifierMetadataInformation">
		<xsl:param name="childIdentifier"/>
		<xsl:param name="parentIdentifier"/>
		<xsl:variable name="parentMetadataInformationId" select="concat('parentMetadataInformationId-', generate-id(.))"/>
		<rim:ExtrinsicObject id="{$parentMetadataInformationId}" objectType="{$metadataInformationObjectType}">
			<xsl:call-template name="slot-identifier">
				<xsl:with-param name="identifier" select="$parentIdentifier"/>
			</xsl:call-template>
		</rim:ExtrinsicObject>
		<!-- associationType from OGC 07-038 table D.2 -->
		<xsl:variable name="parentMetadataInformationAssociationId" select="concat('parentMetadataInformationAssociationId-', generate-id(.))"/>
		<rim:Association id="{$parentMetadataInformationAssociationId}" associationType="{$parentMetadataInformationAssociationType}" sourceObject="{$childIdentifier}" targetObject="{$parentMetadataInformationId}"/>
	</xsl:template>
	<!--
	- - -
	Table F.2
	Some properties of MD_Metadata are mapped to the Extrinsic Object ResourceMetadata. An instance of DataMetadata
	or ServiceMetadata is created for each instance of MD_Metadata.identificationInfo. This implies to duplicate some pieces
	of information of MD_Metadata in each of the instance of DataMetadata and ServiceMetadata pertaining to a unique
	metadata record. This mapping is defined in Table F.2.

	Table F.2 - Metadata Information (ResourceMetadata Extrinsic Object)

	ISO 19115/ ISO 19119						CIM												Comments

	fileIdentifier										-													See Table F.1
	language											-													See Table F.1
	characterSet										-													Ignored
	parentIdentifier									-													See Table F.1
	hierarchyLevel									<<slot>>type								For each instance of the property.
																												Each ‘type’ slot contains a reference to a node of
																												the ObjectType classification scheme. This concerns
																												the nodes: Dataset, Service and Application.
	hierarchyLevelName							-													Ignored
	Contact												-													Ignored
	dateStamp										-													Ignored
	metadataStandardName						-													Ignored
	metadataStandardVersion					-													Ignored
	datasetURI										-													Ignored
	locale												-													Ignored
	spatialRepresentationInfo					-													Ignored
	referenceSystemInfo							See Clause F.5								For each instance of the property
	metadataExtensionInfo						-													Ignored
	identificationInfo									See Clause F.3								For each instance of the property
	contentInfo										-													Ignored
	distributionInfo									See Clause F.6								For each instance of the property distributionFormat of
																												the instance of MD_Distribution corresponding to the
																												distributionInfo property
	dataQualityInfo									-													Ignored
	portrayalCatalogueInfo						-													Ignored
	metadataConstraints							-													Ignored
	applicationSchemaInfo						-													Ignored
	metadataMaintenance						-													Ignored

	-->
	
	<xsl:template name="resourceMetadata">
		<xsl:param name="metadataInformationId"/>
		<xsl:variable name="resourceMetadataId" select="concat('resourceMetadataId-', generate-id(.))"/>
		
		<xsl:choose>
			<xsl:when test="/gmd:MD_Metadata/gmd:fileIdentifier/gco:CharacterString">
					<wrs:ExtrinsicObject id="{$resourceMetadataId}" objectType="urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ResourceMetadata">
						<xsl:call-template name="specifyTypeOfResourceMetadata"/>						
						<xsl:call-template name="resourceMetadataContent">
							<xsl:with-param name="metadataInformationId"  select="$metadataInformationId"/>
							<xsl:with-param name="resourceMetadataId" select="$resourceMetadataId"/>
						</xsl:call-template>
						
						<wrs:repositoryItemRef xlink:type="simple" xlink:href="{$resourceMetadataId}" />
					</wrs:ExtrinsicObject>
			</xsl:when>
			<xsl:otherwise>
					<rim:ExtrinsicObject id="{$resourceMetadataId}" objectType="urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ResourceMetadata">
					   <xsl:call-template name="specifyTypeOfResourceMetadata"/>
						<xsl:call-template name="resourceMetadataContent">
							<xsl:with-param name="metadataInformationId"  select="$metadataInformationId"/>
							<xsl:with-param name="resourceMetadataId" select="$resourceMetadataId"/>
						</xsl:call-template>
					</rim:ExtrinsicObject>				
			</xsl:otherwise>
		</xsl:choose>
		
		<xsl:call-template name="resourceMetadataContent2">
			<xsl:with-param name="metadataInformationId"  select="$metadataInformationId"/>
			<xsl:with-param name="resourceMetadataId" select="$resourceMetadataId"/>
		</xsl:call-template>
	</xsl:template>
	
	<xsl:template name="resourceMetadataContent">
		<xsl:param name="metadataInformationId"/>
		<xsl:param name="resourceMetadataId"/>
		<!--xsl:variable name="resourceMetadataId" select="concat('resourceMetadataId-', generate-id(.))"/-->	
	
		<!--rim:ExtrinsicObject id="{$resourceMetadataId}" objectType="urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ResourceMetadata"-->
			<!--	the objectType is either DataMetadata or ServiceMetadata. This is determined in Section F.3 -->
			<!--xsl:call-template name="specifyTypeOfResourceMetadata"/-->
			<!--
			<rim:Name>
				<xsl:variable name="name" select="child::node()/gmd:citation/gmd:CI_Citation/gmd:title/gco:CharacterString"/>
				<rim:LocalizedString value="{$name}"/>
			</rim:Name>


			<rim:Description>
				<xsl:variable name="abstract" select="child::node()/gmd:abstract/gco:CharacterString"/>
				<rim:LocalizedString value="{$abstract}"/>
			</rim:Description>
			-->
			<xsl:call-template name="slot-identifier">
				<xsl:with-param name="identifier" select="/gmd:MD_Metadata/gmd:fileIdentifier/gco:CharacterString"/>
			</xsl:call-template>
			<!--	From language to <<slot>> language -->
			<xsl:choose>
				<xsl:when test="/gmd:MD_Metadata/gmd:language/gmd:LanguageCode">
					<xsl:call-template name="slot-language">
						<xsl:with-param name="language" select="/gmd:MD_Metadata/gmd:language/gmd:LanguageCode/@codeListValue"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="/gmd:MD_Metadata/gmd:language/gco:CharacterString">
					<xsl:call-template name="slot-language">
						<xsl:with-param name="language" select="/gmd:MD_Metadata/gmd:language/gco:CharacterString"/>
					</xsl:call-template>
				</xsl:when>
			</xsl:choose>
			<!--	characterSet :	Ignored	-->
			<!--	For each instance of the property. Each ‘type’ slot contains a reference to a node of the ObjectType classification
					scheme. This concerns the nodes: Dataset, Service and Application-->
			<!--xsl:for-each select="/gmd:MD_Metadata/gmd:hierarchyLevel">
				<xsl:call-template name="slot-hierarchyLevel">
					<xsl:with-param name="hierarchyLevel" select="gmd:MD_ScopeCode/@codeListValue"/>
				</xsl:call-template>
			</xsl:for-each-->



			<!-- hierarchyLevelName to <<slot>> type -->
			<xsl:for-each select="/gmd:MD_Metadata/gmd:hierarchyLevelName">
				<rim:Slot name="{$typeSlotName}" slotType="xsd:string">
					<rim:ValueList>
						<rim:Value>
							<xsl:value-of select="gco:CharacterString"/>
						</rim:Value>
					</rim:ValueList>
				</rim:Slot>
			</xsl:for-each>

			<!--	alternateTitle to <<slot>> title -->
			<!--	heikki : alternateTitle has cardinality 0..n. I'm assuming spec writer means "for each". -->
			<xsl:for-each select="child::node()/gmd:citation/gmd:CI_Citation/gmd:alternateTitle">
				<xsl:variable name="alternateTitle" select="gco:CharacterString"/>
				<xsl:call-template name="slot-title">
					<xsl:with-param name="title" select="$alternateTitle"/>
				</xsl:call-template>
			</xsl:for-each>
			<!--	date. heikki : spec writer does not say how to distinguish between created, modified or issued. I am assuming it
					 maps to DateTypeCode values creation, revision and publication. -->
			<!--	heikki : date has cardinality 1..n. I'm assuming spec writer means "for each". -->
			<xsl:for-each select="child::node()/gmd:citation/gmd:CI_Citation/gmd:date">
				<xsl:call-template name="slot-date-with-type">
					<xsl:with-param name="date" select="gmd:CI_Date/gmd:date"/>
					<xsl:with-param name="dateType" select="gmd:CI_Date/gmd:dateType"/>
				</xsl:call-template>
			</xsl:for-each>
			<!--	hierarchyLevelName, Contact, dateStamp, metadataStandardName, metadataStandardVersion,
					datasetURI, locale, spatialRepresentationInfo, metadataExtensionInfo : Ignored, contentInfo : Ignored -->
			<!--	distributionInfo : See Clause F.6.  "For each instance of the property distributionFormat of the instance of MD_Distribution
					corresponding to the distributionInfo property".  heikki : Clause F.6 is Table F.11 -->
			<xsl:for-each select="/gmd:MD_Metadata/gmd:distributionInfo/gmd:MD_Distribution/gmd:distributionFormat">
				<!--
					Each instance of MD_Metadata.distributionInfo.MD_Distribution.distributionFormat implies to create an instance of Format as defined in
					Table F.11 and an instance of the association between ResourceMetadata and Format.

					Table F.11 - From MD_Format to Format
					ISO 19115/ ISO 19119				CIM					Comments

					name										name
					version										-						Ignored
					amendmentNumber					-						Ignored
					specification								-						Ignored
					fileDecompressionTechnique		-						Ignored
					formatDistributor						-						Ignored

					ResourceMetadata. <<slot>> format (http://purl.org/dc/elements/1.1/format slot defined in the Basic Package). The slot type is
					a two-level classification that handles format name and format version.
				-->
				<!-- Check no empty values -->
				<xsl:variable name="format_name" select="./gmd:MD_Format/gmd:name/gco:CharacterString"/>
				<xsl:if test="$format_name">
					<rim:Slot name="{$formatSlotName}" slotType="{$stringSlotType}">
						<rim:ValueList>
							<rim:Value>
								<xsl:value-of select="./gmd:MD_Format/gmd:name/gco:CharacterString"/>
							</rim:Value>
							<rim:Value>
								<xsl:value-of select="./gmd:MD_Format/gmd:version/gco:CharacterString"/>
							</rim:Value>
						</rim:ValueList>
					</rim:Slot>
				</xsl:if>
			</xsl:for-each>
			<xsl:call-template name="resourceConstraints-slot-rights"/>
			<xsl:if test="gmd:MD_DataIdentification">
				<xsl:call-template name="datametadata">
					<xsl:with-param name="dataset-id" select="$resourceMetadataId"/>
				</xsl:call-template>
			</xsl:if>
			<xsl:if test="gmd:MD_ServiceIdentification">
				<xsl:call-template name="datametadata">
					<xsl:with-param name="dataset-id" select="$resourceMetadataId"/>
				</xsl:call-template>
			</xsl:if>
			<xsl:if test="srv:SV_ServiceIdentification">
				<xsl:call-template name="servicemetadata">
					<xsl:with-param name="servicemetadata-id" select="$resourceMetadataId"/>
				</xsl:call-template>
			</xsl:if>
		<!--/rim:ExtrinsicObject-->	
	</xsl:template>
	
	<xsl:template name="resourceMetadataContent2">
		<xsl:param name="metadataInformationId"/>
		<xsl:param name="resourceMetadataId"/>
			
		<xsl:if test="srv:SV_ServiceIdentification">
			<xsl:call-template name="serviceoperation">
				<xsl:with-param name="servicemetadata-id" select="$resourceMetadataId"/>
			</xsl:call-template>
		</xsl:if>
		<xsl:call-template name="resourceConstraints">
			<xsl:with-param name="resourceConstraints-id" select="$resourceMetadataId"/>
		</xsl:call-template>
		<xsl:call-template name="citedResponsibleParty">
			<xsl:with-param name="citedResponsibleParty-id" select="$resourceMetadataId"/>
			<xsl:with-param name="metadataInformationId" select="$metadataInformationId"/>
		</xsl:call-template>
		<xsl:call-template name="pointOfContact">
			<xsl:with-param name="pointOfContact-id" select="$resourceMetadataId"/>
			<xsl:with-param name="metadataInformationId" select="$metadataInformationId"/>
		</xsl:call-template>
		
		<xsl:call-template name="dataQuality">				
			<xsl:with-param name="dataQuality-id" select="$resourceMetadataId"/>
			<xsl:with-param name="metadataInformationId" select="$metadataInformationId"/>
		</xsl:call-template>
	
		<!--	referenceSystemInfo : See Clause F.5	For each instance of the property -->
		<xsl:for-each select="/gmd:MD_Metadata/gmd:referenceSystemInfo">
			<xsl:call-template name="referenceSystemInfo">
				<xsl:with-param name="referenceSystemInfo_id" select="$resourceMetadataId"/>
				<xsl:with-param name="metadataInformationId" select="$metadataInformationId"/>
			</xsl:call-template>
		</xsl:for-each>
		<xsl:variable name="resourceMetadataInformationAssociationTypeId" select="concat('resourceMetadataInformationAssociationType-', generate-id(.))"/>
		<rim:Association id="{$resourceMetadataInformationAssociationTypeId}" associationType="{$resourceMetadataInformationAssociationType}" sourceObject="{$resourceMetadataId}" targetObject="{$metadataInformationId}"/>

		<xsl:for-each select="/gmd:MD_Metadata/gmd:hierarchyLevel">
				<xsl:call-template name="classification-hierarchyLevel">
					<xsl:with-param name="hierarchyLevel" select="gmd:MD_ScopeCode/@codeListValue"/>
					<xsl:with-param name="resourceMetadataId" select="$resourceMetadataId"/>
				</xsl:call-template>
	    </xsl:for-each>
	</xsl:template>
	<xsl:template name="serviceoperation">
		<xsl:param name="servicemetadata-id"/>
		<!--
			Table F.6 - From SV_OperationMetadata to ServiceOperation
			ISO 19115/ ISO 19119								CIM										Comments
			operationName											name
			DCP															<<classification>>DCPList		For each DCP
			operationDescription									-											Ignored
			invocationName											-											Ignored
			connectPoint.CI_OnlineResource.linkage		<<slot>> references				For each instance of the property
		-->
		<xsl:for-each select="srv:SV_ServiceIdentification/srv:containsOperations">
			<xsl:variable name="serviceOperationId" select="concat('serviceOperationId-', generate-id(.))"/>
			<rim:ExtrinsicObject id="{$serviceOperationId}" objectType="{$serviceOperationObjectType}">
				<xsl:for-each select="srv:SV_OperationMetadata/srv:connectPoint/gmd:CI_OnlineResource/gmd:linkage">
					<xsl:variable name="url" select="gmd:URL"/>
					<rim:Slot name="References" slotType="urn:oasis:names:tc:ebxml-regrep:DataType:URI">
						<rim:ValueList>
							<rim:Value>
								<xsl:value-of select="$url"/>
							</rim:Value>
						</rim:ValueList>
					</rim:Slot>
				</xsl:for-each>
				<rim:Name>
					<xsl:variable name="name" select="srv:SV_OperationMetadata/srv:operationName/gco:CharacterString"/>
					<rim:LocalizedString value="{$name}"/>
				</rim:Name>
				<xsl:for-each select="srv:SV_OperationMetadata/srv:DCP">
					<xsl:variable name="dcpListValue" select="srv:DCPList/@codeListValue"/>
					<!--	TODO heikki: classificaitonnode -->
					<xsl:variable name="dcpListClassificationId" select="concat('dcpListClassificationId-', generate-id(.))"/>
					<rim:Classification id="{$dcpListClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$DCPListClassificationScheme}" classificationNode="{$dcpListValue}"/>
				</xsl:for-each>
			</rim:ExtrinsicObject>
			<xsl:variable name="containsOperationAssociationTypeId" select="concat('containsOperationAssociationType-', generate-id(.))"/>
			<rim:Association id="{$containsOperationAssociationTypeId}" associationType="{$containsOperationAssociationType}" sourceObject="{$servicemetadata-id}" targetObject="{$serviceOperationId}"/>
		</xsl:for-each>
	</xsl:template>
	<xsl:template name="resourceConstraints-slot-rights">
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:resourceConstraints/gmd:MD_LegalConstraints">
			<xsl:if test="gmd:otherConstraints/gco:CharacterString">
				<rim:Slot name="{$rightsSlotName}" slotType="xsd:string">
					<rim:ValueList>
						<rim:Value>
							<xsl:value-of select="gmd:otherConstraints/gco:CharacterString"/>
						</rim:Value>
					</rim:ValueList>
				</rim:Slot>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template name="dataQuality">
		<xsl:param name="dataQuality-id"/>		
		<xsl:param name="metadataInformationId"/>	

		<xsl:for-each select="/gmd:MD_Metadata/gmd:dataQualityInfo/gmd:DQ_DataQuality/gmd:report/gmd:DQ_DomainConsistency/gmd:result/gmd:DQ_ConformanceResult">
			<xsl:variable name="referenceSpecificationId" select="concat('referenceSpecificationId-', generate-id(.))"/>
		
			<rim:ExtrinsicObject id="{$referenceSpecificationId}" objectType="{$referenceSpecificationObjectType}">
				<xsl:for-each select="gmd:specification/gmd:CI_Citation/gmd:date">
					<xsl:call-template name="slot-date-with-type">
						<xsl:with-param name="date" select="gmd:CI_Date/gmd:date"/>
						<xsl:with-param name="dateType" select="gmd:CI_Date/gmd:dateType"/>
					</xsl:call-template>				
				</xsl:for-each>	
							
				<rim:Slot name="{$conformanceSlotName}" slotType="{$internationalStringSlotType}">
					<rim:ValueList>
						<rim:Value>
							<xsl:value-of select="gmd:pass/gco:Boolean"/>
						</rim:Value>
					</rim:ValueList>
				</rim:Slot>
			
				<rim:Name>
					<xsl:variable name="name" select="gmd:specification/gmd:CI_Citation/gmd:title/gco:CharacterString"/>
					<rim:LocalizedString value="{$name}"/>
				</rim:Name>
			</rim:ExtrinsicObject>
			
			<xsl:variable name="specificationAssociationTypeId" select="concat('specificationAssociationType-', generate-id(.))"/>
			<rim:Association id="{$specificationAssociationTypeId}" associationType="{$specificationAssociationType}" sourceObject="{$dataQuality-id}" targetObject="{$referenceSpecificationId}"/>
			
		</xsl:for-each>
	
	</xsl:template>
	
	<xsl:template name="pointOfContact">
		<xsl:param name="pointOfContact-id"/>
		<xsl:param name="metadataInformationId"/>
		<!--	citedResponsibleParty : For each instance of citedResponsibleParty. -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:pointOfContact">
			<!--
				Association CitedResponsibleParty + an instance of Organization as defined in Table F.16.
				The role of the responsible party classifies the association CitedResponsibleParty (CitedResponsibleParty classification).

				Table F.16 - From CI_ResponsibleParty to Organization
				ISO 19115/ ISO 19119					CIM													Comments
				individualName								-														Ignored
																															If needed, it is possible to provide this information
																															through the Organization.primaryContact property,
																															which contains a reference to an instance of Person.
				organizationName							name
				positionName								-														Ignored
				contactInfo									-														Ignored
				role												Handled through the
																	CitedResponsibleParty classification
																	on the CitedResponsibleParty
																	association.
			-->
			<!-- heikki : this way an organization is created everytime, not re-used. Does not make any sense.. -->
			<xsl:variable name="organizationId" select="concat('organizationId-', generate-id(.))"/>
			<rim:Organization id="{$organizationId}" objectType="{$organizationObjectType}">
				<!--	individualName : Ignored. heikki : what now "if needed", is it ignored or not ?? I'm ignoring it. -->
				<!--	organizationName  -->
				<!-- heikki : it is organisationName with an 's' not a 'z' ! -->
				<!-- heikki : what if organisationName is absent ? ? -->
				<rim:Name>
					<xsl:variable name="name" select="gmd:CI_ResponsibleParty/gmd:organisationName/gco:CharacterString"/>
					<rim:LocalizedString value="{$name}"/>
				</rim:Name>
				<!--	positionName, contactInfo : Ignored -->
			</rim:Organization>
			<!--	role : CitedResponsibleParty association -->
			<!-- 	"Name and position information for an individual or organization that is responsible for the resource. The association Type
					has a set of subtypes operating to the same object types: PointOfCOntact, Author, Originator, Publisher."-->
			<!--	heikki : that's not true, no such subtypes are defined. This stuff is handled by classifying the association I believe -->
			<xsl:variable name="citedResponsiblePartyAssociationId" select="concat('citedResponsiblePartyAssociationId-', generate-id(.))"/>
			<rim:Association id="{$citedResponsiblePartyAssociationId}" associationType="{$citedResponsiblePartyAssociationType}" sourceObject="{$pointOfContact-id}" targetObject="{$organizationId}"/>
			<xsl:variable name="role" select="gmd:CI_ResponsibleParty/gmd:role/gmd:CI_RoleCode/@codeListValue"/>
			<!-- heikki : the codelist for rolecode has *many* more options than just PointOfCOntact, Author, Originator, Publisher.
				 If it is not one of those 4, I ignore it so no classification will be created. Does not make any sense. -->
			<xsl:variable name="citedResponsiblePartyAssociationClassificationId" select="concat('citedResponsiblePartyAssociationClassificationId-', generate-id(.))"/>
			<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyPointOfContactClassificationNode}"/>
			<xsl:variable name="metadataPointOfContactAssociationId" select="concat('metadataPointOfContactAssociationId-', generate-id(.))"/>
			<rim:Association id="{$metadataPointOfContactAssociationId}" associationType="{$metadataPointOfContactAssociationType}" sourceObject="{$metadataInformationId}" targetObject="{$organizationId}"/>
		</xsl:for-each>
	</xsl:template>
	<xsl:template name="citedResponsibleParty">
		<xsl:param name="citedResponsibleParty-id"/>
		<xsl:param name="metadataInformationId"/>
		<!--	citedResponsibleParty to Association CitedResponsibleParty, Organization, See table F.16 -->
		<!-- citedResponsibleParty : For each instance of citedResponsibleParty. -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:citation/gmd:CI_Citation/gmd:citedResponsibleParty">
			<!--
						Association CitedResponsibleParty + an instance of Organization as defined in Table F.16.
						The role of the responsible party classifies the association CitedResponsibleParty (CitedResponsibleParty classification).

						Table F.16 - From CI_ResponsibleParty to Organization
						ISO 19115/ ISO 19119					CIM													Comments
						individualName								-														Ignored
																																	If needed, it is possible to provide this information
																																	through the Organization.primaryContact property,
																																	which contains a reference to an instance of Person.
						organizationName							name
						positionName								-														Ignored
						contactInfo									-														Ignored
						role												Handled through the
																			CitedResponsibleParty classification
																			on the CitedResponsibleParty
																			association.
					-->
			<!-- heikki : this way an organization is created everytime, not re-used. Does not make any sense.. -->
			<xsl:variable name="organizationId" select="concat('organizationId-', generate-id(.))"/>
			<rim:Organization id="{$organizationId}" objectType="{$organizationObjectType}">
				<!--	individualName : Ignored. heikki : what now "if needed", is it ignored or not ?? I'm ignoring it. -->
				<!--	organizationName  -->
				<!-- heikki : it is organisationName with an 's' not a 'z' ! -->
				<!-- heikki : what if organisationName is absent ? ? -->
				<rim:Name>
					<xsl:variable name="name" select="gmd:CI_ResponsibleParty/gmd:organisationName/gco:CharacterString"/>
					<rim:LocalizedString value="{$name}"/>
				</rim:Name>
				<!--	positionName, contactInfo : Ignored -->
			</rim:Organization>
			<!--	role : CitedResponsibleParty association -->
			<!-- 	"Name and position information for an individual or organization that is responsible for the resource. The association Type
							has a set of subtypes operating to the same object types: PointOfCOntact, Author, Originator, Publisher."-->
			<!--	heikki : that's not true, no such subtypes are defined. This stuff is handled by classifying the association I believe -->
			<xsl:variable name="citedResponsiblePartyAssociationId" select="concat('citedResponsiblePartyAssociationId-', generate-id(.))"/>
			<rim:Association id="{$citedResponsiblePartyAssociationId}" associationType="{$citedResponsiblePartyAssociationType}" sourceObject="{$citedResponsibleParty-id}" targetObject="{$organizationId}"/>
			<!--xsl:variable name="metadataPointOfContactAssociationId" select="concat('metadataPointOfContactAssociationId-', generate-id(.))"/>
                    <rim:Association id="{$metadataPointOfContactAssociationId}" associationType="{$metadataPointOfContactAssociationType}" sourceObject="{$metadataInformationId}" targetObject="{$organizationId}"/-->
			<xsl:variable name="role" select="gmd:CI_ResponsibleParty/gmd:role/gmd:CI_RoleCode/@codeListValue"/>
			<!-- heikki : the codelist for rolecode has *many* more options than just PointOfCOntact, Author, Originator, Publisher.
						 If it is not one of those 4, I ignore it so no classification will be created. Does not make any sense. -->
			<xsl:variable name="citedResponsiblePartyAssociationClassificationId" select="concat('citedResponsiblePartyAssociationClassificationId-', generate-id(.))"/>
			<xsl:if test="$role = 'pointOfContact'">
				<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyPointOfContactClassificationNode}"/>
			</xsl:if>
			<xsl:if test="$role = 'author'">
				<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyAuthorClassificationNode}"/>
			</xsl:if>
			<xsl:if test="$role = 'publisher'">
				<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyPublisherClassificationNode}"/>
			</xsl:if>
			<xsl:if test="$role = 'originator'">
				<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyOriginatorClassificationNode}"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	<xsl:template name="resourceConstraints">
		<xsl:param name="resourceConstraints-id"/>
		<!--	resourceConstraints to An association ResourceConstraints targeting an instance of Rights as defined in Clause F.4 -->
		<!--
				Section F.4 Registration of Constraint Information
				Unique instances of Rights, LegalConstraints or SecurityConstraints are created based on the properties of the instance of
				MD_Constraints, MD_LegalConstraints and/or MD_SecurityConstraints. An instance of the association ResourceConstraints from an
				instance of ResourceMetadata to Rights and/or one of its subclass must be created for each instance of the association between
				MD_Identification and MD_Constraints.
				Each instance of MD_Identification.resourceConstraints of type MD_Constraints, MD_LegalConstraints or MD_SecurityConstraints
				implies to create an instance of Rights as defined in Table F.7.

				Table F.7 - From MD_Constraints to Rights
				ISO 19115/ ISO 19119							CIM										Comments
				useLimitation											<<slot>>abstract

				Each instance of MD_Identification.resourceConstraints of type MD_LegalConstraints implies to create an instance of Rights
				(cf. Table ) and of LegalConstraints as defined in Table F.8.

				Table F.8 - From MD_LegalConstraints to LegalConstraints
				ISO 19115/ ISO 19119							CIM														Comments
				accessConstraints									<<classification>> RestrictionCode			Access and use constraints are managed through the classification
																																		RestrictionType, which is itself classified with the values of the
																																		RestrictionCode classification. RestrictionType identifies the constraint
																																		type: access or use; RestrictionCode identifies the precise access or
																																		use restriction (e.g copyright, patent…).
				useConstraints										<<classification>> RestrictionCode			Access and use constraints are managed through the classification
																																		RestrictionType, which is itself classified with the values of the
																																		RestrictionCode classification. RestrictionType identifies the constraint
																																		type: access or use; RestrictionCode identifies the precise access or
																																		use restriction (e.g copyright, patent…).
				otherConstraints									<<slot>> rights

				Each instance of MD_Identification.resourceConstraints of type MD_SecurityConstraints implies to create an instance of Rights (cf.Table F.7) and
				of SecurityConstraints as defined in Table F.9.

				Table F.9 - From MD_SecurityConstraints to SecurityConstraints
				ISO 19115/ ISO 19119						CIM															Comments
				classification										<<classification>> ClassificationCode
				useNote											-																Ignored
				classificationSystem							-																Ignored
				handlingDescription							-																Ignored

		-->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:resourceConstraints">
			<xsl:if test="gmd:MD_Constraints">
				<xsl:call-template name="rights">
					<xsl:with-param name="rights-id" select="$resourceConstraints-id"/>
				</xsl:call-template>
			</xsl:if>
			<xsl:if test="gmd:MD_LegalConstraints">
				<xsl:call-template name="rights">
					<xsl:with-param name="rights-id" select="$resourceConstraints-id"/>
				</xsl:call-template>
				<xsl:if test="gmd:MD_LegalConstraints/gmd:useConstraints or gmd:MD_LegalConstraints/gmd:accessConstraints">
					<xsl:variable name="legalConstraintsId" select="concat('legalConstraintsId-', generate-id(.))"/>
					<rim:ExtrinsicObject id="{$legalConstraintsId}" objectType="{$legalConstraintsObjectType}">
                        <xsl:variable name="restrictionTypeClassificationId" select="concat('restrictionTypeClassificationId-', generate-id(.))"/>
                        <!-- access or use ? -->
                        <!-- TODO what are the IDs of classificationNodes "access" and "use" ?-->
                        <xsl:if test="gmd:MD_LegalConstraints/gmd:useConstraints">
                            <rim:Classification id="{$restrictionTypeClassificationId}" classifiedObject="{$legalConstraintsId}" classificationScheme="{$restrictionTypeClassificationScheme}" classificationNode="use"/>
                        </xsl:if>
                        <xsl:if test="gmd:MD_LegalConstraints/gmd:accessConstraints">
                            <rim:Classification id="{$restrictionTypeClassificationId}" classifiedObject="{$legalConstraintsId}" classificationScheme="{$restrictionTypeClassificationScheme}" classificationNode="access"/>
                        </xsl:if>
                        <xsl:variable name="restrictionCodeClassificationId" select="concat('restrictionCodeClassificationId-', generate-id(.))"/>
                        <xsl:variable name="restrictionCode" select="gmd:MD_LegalConstraints/*/gmd:MD_RestrictionCode/@codeListValue"/>
                        <!-- TODO what are the IDs of the restrictionCode classificationnodes ? -->
                        <rim:Classification id="{$restrictionCodeClassificationId}" classifiedObject="{$restrictionTypeClassificationId}" classificationScheme="{$restrictionCodeClassificationScheme}" classificationNode="{$restrictionCode}"/>
					</rim:ExtrinsicObject>
				</xsl:if>
			</xsl:if>
			<xsl:if test="gmd:MD_SecurityConstraints">
				<xsl:call-template name="rights">
					<xsl:with-param name="rights-id" select="$resourceConstraints-id"/>
				</xsl:call-template>
				<xsl:variable name="securityConstraintsId" select="concat('securityConstraintsId-', generate-id(.))"/>
				<rim:ExtrinsicObject id="{$securityConstraintsId}" objectType="{$securityConstraintsObjectType}">
                    <xsl:variable name="classificationCodeClassificationId" select="concat('classificationCodeClassificationId-', generate-id(.))"/>
                    <xsl:variable name="classificationCode" select="gmd:MD_SecurityConstraints/gmd:classification/gmd:MD_ClassificationCode/@codeListValue"/>
                    <rim:Classification id="{$classificationCodeClassificationId}" classifiedObject="{$securityConstraintsId}" classificationScheme="{$classificationCodeClassificationScheme}" classificationNode="{$classificationCode}"/>
                </rim:ExtrinsicObject>
            </xsl:if>
		</xsl:for-each>
	</xsl:template>
	<xsl:template name="rights">
		<xsl:param name="rights-id"/>
		<xsl:if test="gmd:MD_Constraints/gmd:useLimitation/gco:CharacterString">
			<xsl:variable name="rightsId" select="concat('rightsId-', generate-id(.))"/>
			<rim:ExtrinsicObject id="{$rightsId}" objectType="{$rightsObjectType}">
				<rim:Slot name="{$abstractSlotName}" slotType="xsd:string">
					<rim:ValueList>
						<rim:Value>
							<xsl:value-of select="gmd:MD_Constraints/gmd:useLimitation/gco:CharacterString"/>
						</rim:Value>
					</rim:ValueList>
				</rim:Slot>
			</rim:ExtrinsicObject>
			<xsl:variable name="resourceConstraintsAssociationId" select="concat('resourceConstraintsAssociationId-', generate-id(.))"/>
			<rim:Association id="{$resourceConstraintsAssociationId}" associationType="{$resourceConstraintsAssociationType}" sourceObject="{$rights-id}" targetObject="{$rightsId}"/>
		</xsl:if>
	</xsl:template>
	<!--	identificationInfo  -->
	<!--	heikki : Clause F.3 is Tables F.3, F.4, F.5 and F.6 -->
	<!--	Section F.3. Registration of the information 	resources.

		F.3.1 Preamble

		Each instance of MD_Metadata.identificationInfo describes an information resource concerned by the metadata record. In this profile,
		the cardinality of this property is restricted to 1..1 for the ISO 19139 metadata files stored in the ebRIM Repository. The restriction on
		this cardinality makes it easier to manage the associations between the registry objects and repository items. Besides, it is compliant
		with the ISO 19115/19119 Application Profile of CS-W and does not prevent metadata producers to store internally metadata files with
		multiple MD_Metadata.identificationInfo properties in a single MD_Metadata element.

		The information resource will be:
			- a Dataset or Dataset Collection if MD_Metadata.hierarchyLevel is set to ‘dataset’. In this case, the metadata record will contain
			one property Metadata.identificationInfo of type MD_DataIdentification or one of its subtypes;
			- a Service if MD_Metadata.hierarchyLevel is set to ‘service’. In this case, the metadata record will contain one property
			Metadata.identificationInfo of type SV_ServiceIdentification or one of its subtypes;
			- an Application if MD_Metadata.hierarchyLevel is set to ‘application’. In this case, the metadata record will contain one property
			Metadata.identificationInfo of type MD_DataIdentificarion or SV_ServiceIdentification or one of their subtypes;

		There are many possible ways to defined whether the information resource if a dataset or a dataset collection:
			- if the value of MD_Metadata.hierarchyLevel is series, then it is a dataset collection;
			- in the case of an ISO 19139 compliant metadata record, the value of the MD_Metadata.hierarchyLevel property may serve as a
			discriminator since ISO 19139 extends the MD_ScopeCode codelist to add specific values for aggregation;
			heikki: TODO : understand that ? which *are* the specific codelist values for aggregation ??

			- the instance of MD_DataIdentification may aggregate instances of MD_AggregateInformation defining whether the resource is an
			aggregate or a dataset;
			- the instance of MD_Metadata may be associated with or aggregated to an instance of DS_Dataset, DS_Aggregate or one of their
			subclasses allowing the discrimination.
			- MD_Metadata.parentIdentifier may be used to access the information resources aggregating the information resources of the
			current metadata record.

		Whatever the context is, it is then possible to instantiate also the Subset association type between the generated instances of Dataset
		and Dataset Collection.

		An application resource can only be identified through the value of MD_Metadata.hierarchyLevel (set to ‘application’). It is then possible
		to instantiate the IsClientOf and OperatesOn association types between Application and Service and Application and Dataset.

		A service resource is identified through the value of MD_Metadata.hierarchyLevel (set to ‘service’) and the existence of at least one
		instance of Metadata.identificationInfo of type SV_ServiceIdentification. It is then possible to instantiate the OperatesOn association
		type between Service and Dataset.

		Dataset, DatasetCollection, Application and Service along with the associations that connect them are part of the Metadata Context of
		the CIM. Instantiating these classes is optional. A valid catalogue service can only implement the classes defined in the Resource
		Metadata, Data Metadata, Service Metadata, Constraint Information, Reference System Information, Graphic Overview and Citation
		sections of the CIM.


		F.3.2 Registration of a Dataset, a Dataset Collection or an Application

		A information resource of type dataset or dataset collection, identified as such as described in F.3.1 implies to create an instance of
		the Dataset Extrinsic Object or the DatasetCollection Extrinsic Object. An instance of MD_Metadata.identificationInfo of type
		MD_DataIdentification in the metadata record implies to create an instance of DataMetadata based on the properties of the instance
		of MD_DataIdentification.

		A value of ‘application’ for the MD_Metadata.hierarchyLevel attribute implies to create an instance of the Application Extrinsic Object.
		An instance of MD_Metadata.identificationInfo of type MD_DataIdentification in the metadata record implies to create an instance of
		DataMetadata based on the properties of the instance of MD_DataIdentification.

		Application, Dataset and DatasetCollection instances are part of the metadata context and do not have any attributes. An
		MD_Metadata.identificationInfo instance of type MD_DataIdentification is mapped to an instance of the DataMetadata Extrinsic Object,
		as defined in Table F.3.

		Table F.3 - From MD_DataIdentification to DataMetadata

		ISO 19115/ ISO 19119									CIM														Comments
		citation															See Table F.4
		abstract														description
		purpose														-															Ignored
		credit															-															Ignored
		status															-															Ignored
		pointOfContact												Association CitedResponsibleParty
																			targeting an instance of Organization. The
																			association is classified with the value
																			‘PointOfContact’ from the
																			CitedResponsibleParty classification.
		resourceMaintenance										-															Ignored
		graphicOverview												-															Ignored
		resourceFormat												-															Ignored
		descriptiveKeywords										<<classification>> KeywordScheme		The classification defines both the
																																		keyword type, the keyword and its
																																		thesaurus.
		resourceSpecificUsage									-															Ignored
		resourceConstraints										An association ResourceConstraints		For each resourceConstraints
																																		targeting an instance of Rights as
																																		defined in Clause F.4
		aggregateInformation										-															Ignored
		spatialRepresentationType								<<classification>> 								For each spatialRepresentationType
																			SpatialRepresentationType
		spatialResolution											<<slot>> resolution or <<slot>> 				For each spatialResolution
																			scaleDenominator depending on the
																			type of spatial resolution.
		language														<<slot>> language									For each language
																																		The slot ‘language’ is of type Language,
																																		defined in the ebRIM specification.
		characterSet													<<classification>> CharacterSet				For each characterSet
		topicCategory												<<classification>> TopicCategoryCode	For each topicCategory
		environmentDescription									-															Ignored
		extent															See Clause F.7										For each extent
		supplementalInformation									-															Ignored

	-->
	<!--	replaces the attribute ObjectType with a concrete subtype of ResourceMetadata: either DataMetadata or ServiceMetadata -->
	<xsl:template name="specifyTypeOfResourceMetadata">
		<!--	An instance of MD_Metadata.identificationInfo of type MD_DataIdentification in the metadata record implies to create an instance of DataMetadata based
			on the properties of the instance of MD_DataIdentification -->
		<xsl:if test="gmd:MD_DataIdentification">
			<xsl:attribute name="objectType"><xsl:value-of select="$dataMetadataObjectType"/></xsl:attribute>
		</xsl:if>
		<xsl:if test="gmd:MD_ServiceIdentification">
			<xsl:attribute name="objectType"><xsl:value-of select="$dataMetadataObjectType"/></xsl:attribute>
		</xsl:if>
		<xsl:if test="srv:SV_ServiceIdentification">
			<xsl:attribute name="objectType"><xsl:value-of select="$serviceMetadataObjectType"/></xsl:attribute>
		</xsl:if>
	</xsl:template>
	<!--	Table F.5 - From SV_ServiceIdentification to ServiceMetadata
			ISO 19115/ ISO 19119							CIM																Comments
			citation													See Table F.4
			abstract												description
			purpose												-																	Ignored
			credit													-																	Ignored
			status													-																	Ignored
			pointOfContact										Association CitedResponsibleParty targeting
																		an instance of Organization. The association
																		is classified with the value ‘PointOfContact’
																		from the CitedResponsibleParty classification.
			resourceMaintenance								-																	Ignored
			graphicOverview										-																	Ignored
			resourceFormat										-																	Ignored
			descriptiveKeywords								<<classification>> KeywordScheme				The classification defines both the keyword type, the keyword and
																																			its thesaurus.
			resourceSpecificUsage							-																	Ignored
			resourceConstraints								An association ResourceConstraints targeting	For each resourceConstraints
																		an instance of Rights as defined in Clause F.4
			aggregateInformation								-																	Ignored
			serviceType											<<classification>> Services							Extends the classification defined in the Basic Extension Package
																																			with version information.
			serviceTypeVersion								<<classification>> Services							Extends the classification defined in the Basic Extension Package
																																			with version information.
			accessProperties									-																	Ignored
			restrictions											-																	Ignored
			extent													-																	Ignored
			couplingType											<<classification>> CouplingType
			coupledResource									-																	Ignored
			containsOperations								See Table F.6												For each containsOperation
			operatesOn											ServiceDescription assoctaion between			For each operatesOn
																		ServiceMetadata and Service, OperatesOn
																		association between Service and Dataset and
																		DatasetDescription association between
																		Dataset and DataMetadata
-->
	<xsl:template name="servicemetadata">
		<xsl:param name="servicemetadata-id"/>
		<!--	TODO heikki : describe bullshit-ness -->
		<!-- Updated using identifiers described in 07-144r2 8.4 clause.
		     Not all are specified: OGC:WCTS, OGC:WPS, website, download
		     OGC:WCTS, OGC:WPS are managed using a similar syntax as OGC:WMS and OGC:WFS -->
		<xsl:variable name="serviceType" select="srv:SV_ServiceIdentification/srv:serviceType/gco:ScopedName"/>
		<xsl:variable name="servicesClassificationId" select="concat('servicesClassificationId-', generate-id(.))"/>
		<xsl:choose>
			<xsl:when test="$serviceType = 'OGC:CSW'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:ogc:serviceType:ISO-19109:CatalogueService"/>
			</xsl:when>
			<xsl:when test="$serviceType = 'OGC:WMS'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:ogc:serviceType:WebMapService"/>
			</xsl:when>
			<xsl:when test="$serviceType = 'OGC:WFS'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:ogc:serviceType:WebFeatureService"/>
			</xsl:when>
			<xsl:when test="$serviceType = 'OGC:WCS'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:ogc:serviceType:WebCoverageService"/>
			</xsl:when>
			<xsl:when test="$serviceType = 'OGC:WCTS'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:ogc:serviceType:WebCoordinateTransformationService"/>
			</xsl:when>
			<xsl:when test="$serviceType = 'OGC:WPS'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:ogc:serviceType:WebProcessingService"/>
			</xsl:when>
			<xsl:when test="$serviceType = 'website'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:x-ogc:specification:csw-ebrim:Service:Human-Interaction"/>
			</xsl:when>
			<xsl:when test="$serviceType = 'download'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:x-ogc:specification:csw-ebrim:Service:Product-Access"/>
			</xsl:when>
			<xsl:when test="$serviceType = 'OGC:CSW-ebRIM'">
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="urn:ogc:serviceType:CatalogueService-ebRIM"/>
			</xsl:when>
			<xsl:otherwise>
				<rim:Classification id="{$servicesClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$servicesClassificationScheme}" classificationNode="{$serviceType}"/>
			</xsl:otherwise>

			<!-- TODO operatesOn association(s) -->
		</xsl:choose>
		<!--	TODO classificationnodes for these -->
		<xsl:variable name="couplingTypeClassificationId" select="concat('couplingTypeClassificationId-', generate-id(.))"/>
		<xsl:variable name="couplingType" select="srv:SV_ServiceIdentification/srv:couplingType/srv:SV_CouplingType/@codeListValue"/>
		<xsl:choose>
			<xsl:when test="$couplingType='loose'">
				<rim:Classification id="{$couplingTypeClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$couplingTypeClassificationScheme}" classificationNode="loose"/>
			</xsl:when>
			<xsl:when test="$couplingType='mixed'">
				<rim:Classification id="{$couplingTypeClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$couplingTypeClassificationScheme}" classificationNode="mixed"/>
			</xsl:when>
			<xsl:when test="$couplingType='tight'">
				<rim:Classification id="{$couplingTypeClassificationId}" classifiedObject="{$servicemetadata-id}" classificationScheme="{$couplingTypeClassificationScheme}" classificationNode="tight"/>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="datametadata">
		<xsl:param name="dataset-id"/>
		<!--	spatialResolution to <<slot>> resolution or <<slot>> scaleDenominator depending on the type of spatial resolution. For each spatialResolution -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:spatialResolution">
			<xsl:choose>
				<xsl:when test="gmd:MD_Resolution/gmd:equivalentScale">
					<xsl:call-template name="slot-scaledenominator">
						<xsl:with-param name="scaleDenominator" select="gmd:MD_Resolution/gmd:equivalentScale/gmd:MD_RepresentativeFraction/gmd:denominator/gco:Integer"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="slot-resolution">
						<xsl:with-param name="uom" select="gmd:MD_Resolution/gmd:distance/gco:Distance/@uom"/>
						<xsl:with-param name="distance" select="gmd:MD_Resolution/gmd:distance/gco:Distance"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
		<!--	language to <<slot>> language, For each language. The slot ‘language’ is of type Language, defined in the ebRIM specification. -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:language">
			<xsl:choose>
				<xsl:when test="gmd:LanguageCode">
					<xsl:call-template name="slot-language">
						<xsl:with-param name="language" select="gmd:LanguageCode/@codeListValue"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="gco:CharacterString">
					<xsl:call-template name="slot-language">
						<xsl:with-param name="language" select="gco:CharacterString"/>
					</xsl:call-template>
				</xsl:when>
			</xsl:choose>
		</xsl:for-each>
		<!--	citation	See Table F.4	-->
		<!--
			The instance of MD_DataIdentification.citation is used to instantiate other attributes of the same instance of DataMetadata as defined
			in Table F.4.

			Table F.4 - From CI_Citation to DataMetadata

			ISO 19115/ ISO 19119								CIM															Comments
			title															name
			alternateTitle												<<slot>>title
			date														 	- <<slot>> created for creation
																			- <<slot>> modified for revision
																			- <<slot>> issued for publication
			edition														-																Ignored
			editionDate												-																Ignored
			identifier.MD_Identifier.code						externalIdentifier										Identifiers with no codespace do not
																																			carry sufficient information and are
																																			not mapped to externalIdentifier, for
																																			which the codespace is required.
			citedResponsibleParty								Association CitedResponsibleParty + an 	For each instance of
																			instance of Organization as defined in 			citedResponsibleParty.
																			Table F.16													The role of the responsible
																																			party classifies the association
																																			CitedResponsibleParty
																																			(CitedResponsibleParty classification)
			presentationForm										-																Ignored
			series														-																Ignored
			otherCitationDetails									-																Ignored
			collectiveTitle												-																Ignored
			ISBN														-																Ignored
			ISSN														-																Ignored

		-->
		<!--	extent : 	See Clause F.7		For each extent -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:extent">
			<!--
					F.7 Registration of Geographic and Temporal Extent Information

					Each instance of MD_DataIdentification.extent implies to create instance(s) of the slots temporal and/or envelope and/or coverage for
					the DataMetadata instance.

					Each instance EX_Extent.geographicElement of type EX_GeographicBoundingBox implies to create an instance of the slot envelope in
					the DataMetadata instance, as defined in Table F.12.

					Table F.12 - From EX_GeographicBoundingBox to <<slot>> envelope
					ISO 19115/ ISO 19119									CIM																	Comments
					eventTypeCode												-																		Ignored
					westBoundLongitude										<<slot>> envelope (of type gml:Envelope)			The WestBoundLongitude corresponds to
																																								the longitude of “lowerCorner” in gml:Envelope.
					eastBoundLongitude										<<slot>>envelope (of type gml:Envelope)				The EastBoundLongitude corresponds to the
																																								longitude of “upperCorner” in gml:Envelope
					southBoundLatitude										<<slot>> envelope (of type gml:Envelope)			The SouthBoundLatitude corresponds to the latitude
																																								of “lowerCorner” in gml:Envelope.
					northBoundLatitude										<<slot>> envelope (of type gml:Envelope)			The NorthBoundLongitude corresponds to the latitude
																																								of “upperCorner” in gml:Envelope

					Each instance EX_Extent.geographicElement of type EX_GeographicDescription implies to create an instance of the slot coverage in
					the DataMetadata 	instance, as defined in Table F.13.

					Table F.132 - From EX_GeographicDescription to <<slot>> coverage
					ISO 19115/ ISO 19119									CIM																	Comments
					eventTypeCode												-																		Ignored
					geographicIdentifier										<<slot>> coverage (of type IdentifiedItem)

					Each instance EX_Extent.temporalElement of type EX_GeographicBoundingBox implies to create an instance of the slot temporal in
					the DataMetadata instance, as defined in Table F.14.

					Table F.14 - From EX_TemporalExtent to <<slot>> temporal
					ISO 19115/ ISO 19119									CIM																	Comments
					extent															<<slot>> temporal												-

			-->
			<xsl:variable name="boundingBox" select="gmd:EX_Extent/gmd:geographicElement/gmd:EX_GeographicBoundingBox"/>
			<xsl:if test="$boundingBox">
				<!--	what is slot name ? 07-038 suggests "http://purl.org/dc/elements/1.1/Envelope" but also refers to 07-144r2 where it
						is "http://purl.org/dc/terms/spatial". Likewise for slot type, o7-038 says "gmd:envelope". I'm using the 07-144r2 definitions. -->
				<rim:Slot name="{$spatialSlotName}" slotType="{$envelopeSlotType}">
					<wrs:ValueList>
						<wrs:AnyValue>
							<gml:Envelope srsName="urn:ogc:def:crs:EPSG:4326">
								<gml:lowerCorner>
									<xsl:value-of select="$boundingBox/gmd:southBoundLatitude/gco:Decimal"/>
									<xsl:text> </xsl:text>
									<xsl:value-of select="$boundingBox/gmd:westBoundLongitude/gco:Decimal"/>
								</gml:lowerCorner>
								<gml:upperCorner>
									<xsl:value-of select="$boundingBox/gmd:northBoundLatitude/gco:Decimal"/>
									<xsl:text> </xsl:text>
									<xsl:value-of select="$boundingBox/gmd:eastBoundLongitude/gco:Decimal"/>
								</gml:upperCorner>
							</gml:Envelope>
						</wrs:AnyValue>
					</wrs:ValueList>
				</rim:Slot>
			</xsl:if>
			<xsl:variable name="geographicDescription" select="gmd:EX_Extent/gmd:geographicElement/gmd:EX_GeographicDescription"/>
			<xsl:if test="$geographicDescription">
				<rim:Slot name="{$coverageSlotName}" slotType="xsd:string">
					<rim:ValueList>
						<rim:Value>
							<xsl:value-of select="$geographicDescription/gmd:geographicIdentifier/gmd:MD_Identifier/gmd:code/gco:CharacterString"/>
						</rim:Value>
					</rim:ValueList>
				</rim:Slot>
			</xsl:if>
			<xsl:variable name="temporalElement" select="gmd:EX_Extent/gmd:temporalElement"/>
			<!-- 	the spec neglects to mention that temporalExtent has a begin and end, whereas slot temporal is a single datetime. I'm using
					a multivalued slot with arbitrarily, the begin first, then the end. -->
			<xsl:if test="$temporalElement">
				<rim:Slot name="{$temporalSlotName}" slotType="{$temporalSlotType}">
					<rim:ValueList>
						<rim:Value>
							<xsl:value-of select="$temporalElement/gmd:EX_TemporalExtent/gmd:extent/child::*/child::*[1]"/>
						</rim:Value>
						<rim:Value>
							<xsl:value-of select="$temporalElement/gmd:EX_TemporalExtent/gmd:extent/child::*/child::*[2]"/>
						</rim:Value>
					</rim:ValueList>
				</rim:Slot>
			</xsl:if>
		</xsl:for-each>
		<!--	title to name -->
		<rim:Name>
			<xsl:variable name="name" select="gmd:MD_DataIdentification/gmd:citation/gmd:CI_Citation/gmd:title/gco:CharacterString"/>
			<rim:LocalizedString value="{$name}"/>
		</rim:Name>
		<!--	edition, editionDate : Ignored -->
		<!--	presentationForm, series, otherCitationDetails, collectiveTitle, ISBN, ISSN : Ignored -->
		<!-- end of table F.4, continuing with table F.3 -->
		<!--	abstract to description	-->
		<rim:Description>
			<xsl:variable name="abstract" select="gmd:MD_DataIdentification/gmd:abstract/gco:CharacterString"/>
			<!-- heikki : the specs create invalid ebRIM if the abstract is longer than 1024 (which they often are). -->
			<rim:LocalizedString value="{$abstract}"/>
		</rim:Description>
		<!--	purpose, credit, status : Ignored -->
		<!--	pointOfContact to Association CitedResponsibleParty targeting an instance of Organization.  -->
		<!--	pointOfContact to Association CitedResponsibleParty, Organization, See table F.16 -->
		<!--	resourceMaintenance, graphicOverview, resourceFormat : Ignored -->
		<!--	descriptiveKeywords to <<classification>> KeywordScheme. The classification defines both the keyword type, the keyword and its thesaurus. -->
		<!--	KeywordScheme... (node to be defined on the fly) ! -->
		<!--	Empty classification of keywords to be expanded by a user community, classifying each node as a KeywordTypeCode-->
		<!--	heikki : no clue what to do here. Ignoring it for now. TODO find out what to do ! -->
		<!--
		<xsl:variable name="descriptiveKeywordsClassificationId" select="concat('descriptiveKeywordsClassificationId-', generate-id(.))"/>
		<rim:Classification id="{$descriptiveKeywordsClassificationId}" classifiedObject="{$externalIdentifierId}" classificationScheme="{$keywordSchemeClassificationScheme}" classificationNode="whatever?" />
		-->
		<!--	resourceSpecificUsage : Ignored -->
		<!--	aggregateInformation : Ignored -->
		<!--	spatialRepresentationType to <<classification>> SpatialRepresentationType, For each spatialRepresentationType -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:spatialRepresentationType">
			<xsl:variable name="spatialRepresentationTypeClassificationId" select="concat('spatialRepresentationTypeClassificationId-', generate-id(.))"/>
			<xsl:variable name="spatialRepresentationType" select="gmd:MD_SpatialRepresentationTypeCode/@codeListValue"/>
			<!-- TODO what is the ID of the spatialRepresentationType classificationNode ? -->
			<rim:Classification id="{$spatialRepresentationTypeClassificationId}" classifiedObject="{$dataset-id}" classificationScheme="{$spatialRepresentationTypeClassificationScheme}" classificationNode="{$spatialRepresentationType}"/>
		</xsl:for-each>
		<!--	characterSet to <<classification>> CharacterSet -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:characterSet">
			<xsl:variable name="charset" select="gmd:MD_CharacterSetCode/@codeListValue"/>
			<xsl:call-template name="classification-characterSet">
				<xsl:with-param name="characterSet" select="$charset"/>
				<xsl:with-param name="classifiedObjectId" select="$dataset-id"/>
			</xsl:call-template>
		</xsl:for-each>
		<!--	topicCategory to <<classification>> TopicCategoryCode, For each topicCategory -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:topicCategory">
			<xsl:variable name="topicCategoryClassificationId" select="concat('topicCategoryClassificationId-', generate-id(.))"/>
			<xsl:variable name="topicCategory" select="gmd:MD_TopicCategoryCode/@codeListValue"/>
			
			<xsl:choose>
				<xsl:when test="gmd:MD_TopicCategoryCode/@codeListValue">
						<xsl:variable name="topicCategory" select="gmd:MD_TopicCategoryCode/@codeListValue"/>	
						<rim:Classification id="{$topicCategoryClassificationId}" classifiedObject="{$dataset-id}" classificationScheme="{$topicCategoryCodeClassificationScheme}" classificationNode="{$topicCategory}"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:variable name="topicCategory" select="gmd:MD_TopicCategoryCode"/>
					<rim:Classification id="{$topicCategoryClassificationId}" classifiedObject="{$dataset-id}" classificationScheme="{$topicCategoryCodeClassificationScheme}" classificationNode="{$topicCategory}"/>
				</xsl:otherwise>
			</xsl:choose>
			<!-- TODO what is the ID of the topicCategory classificationNode ? -->
		</xsl:for-each>
		<!--	environmentDescription : Ignored -->
		<!--	supplementalInformation : Ignored -->
		<!--	identifier.MD_Identifier.code to externalIdentifier : "Identifiers with no codespace do not carry sufficient information
				and are not mapped to externalIdentifier, for which the codespace is required." -->
		<!--	heikki: spec writer did not realize that MD_Identifier *never* has a codespace. Only its substitutiongroup
				RS_Identifier may have a codespace. I'm assuming they intended to say, RS_Identifier .. -->
		<!--	heikki : gmd:identifier has cardinality 0..n. I'm assuming spec writer meant "for each". -->
		<xsl:for-each select="gmd:MD_DataIdentification/gmd:citation/gmd:CI_Citation/gmd:identifier/gmd:MD_Identifier">
			<xsl:variable name="codespace" select="gmd:code/gmd:CI_DateTypeCode/@codeSpace"/>
			<xsl:variable name="codevalue" select="gmd:code/gmd:CI_DateTypeCode/@codeListValue"/>
			<xsl:if test="string-length($codespace) > 0">
				<xsl:variable name="externalIdentifierId" select="concat('externalIdentifierId-', generate-id(.))"/>
				<rim:ExternalIdentifier id="{$externalIdentifierId}" registryObject="{$dataset-id}" identificationScheme="{$codespace}" value="{$codevalue}"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	<!--	referenceSystemInfo : heikki : Clause F.5 is Table F.10 -->
	<!--
			Each instance of MD_Metadata.referenceSystemInfo implies to create an instance of IdentifiedItem as defined in Table F.10 along with an
			instance of the association ReferenceSystem between an instance of ResourceMetadata and the IdentifiedItem instance.

			The existence of an instance of MD_Metadata.referenceSystemInfo will possibly imply to create an instance of CitedItem along with an instance
			of the association Auhority between IdentifiedItem and CitedItem.

			Table F.10 - From RS_Identifier to IdentifiedItem
			ISO 19115/ ISO 19119		CIM																								Comments
			authority							Authority association between IdentifiedItem and CitedItem. 				See Table F.15 for a description of CitedItem.
			code									name
			codeSpace						Codespace association to another instance of IdentifiedItem
			version																																	Currently not handled

			heikki: see Table F.15 for the Authority association.

	-->
	<xsl:template name="referenceSystemInfo">
		<xsl:param name="referenceSystemInfo_id"/>
		<xsl:param name="metadataInformationId"/>
		<xsl:variable name="identifiedItemId" select="concat('identifiedItemId-', generate-id(.))"/>
		<rim:ExtrinsicObject id="{$identifiedItemId}" objectType="{$identifiedItemObjectType}">
			<rim:Name>
				<xsl:variable name="name" select="gmd:MD_ReferenceSystem/gmd:referenceSystemIdentifier/gmd:RS_Identifier/gmd:code/gco:CharacterString"/>
				<rim:LocalizedString value="{$name}"/>
			</rim:Name>
		</rim:ExtrinsicObject>
		<!-- resourcereferencesystem association -->
		<xsl:variable name="resourceReferenceSystemAssociationId" select="concat('resourceReferenceSystemAssociationId-', generate-id(.))"/>
		<rim:Association id="{$resourceReferenceSystemAssociationId}" associationType="{$resourceReferenceSystemAssociationType}" sourceObject="{$referenceSystemInfo_id}" targetObject="{$identifiedItemId}"/>
		<!-- codespace association -->
		<xsl:variable name="codeSpace" select="gmd:MD_ReferenceSystem/gmd:referenceSystemIdentifier/gmd:RS_Identifier/gmd:codeSpace/gco:CharacterString"/>

		<xsl:variable name="identifiedItemIdTarget" select="concat('identifiedItemIdTarget-', generate-id(.))"/>
		<rim:ExtrinsicObject id="{$identifiedItemIdTarget}" objectType="{$identifiedItemObjectType}">
		    <rim:Name>
		        <xsl:variable name="gmd_codespace" select="gmd:codeSpace"/>
				<rim:LocalizedString value="gmd:codeSpace"/>
			</rim:Name>
		</rim:ExtrinsicObject>
		<!-- heikki : post-processing must look up the *ID* for that codespace ? -->
		<xsl:variable name="codeSpaceAssociationId" select="concat('codeSpaceAssociationId-', generate-id(.))"/>
		<rim:Association id="{$codeSpaceAssociationId}" associationType="{$codeSpaceAssociationType}" sourceObject="{$identifiedItemId}" targetObject="{$identifiedItemIdTarget}"/>
		<!--  "The existence of an instance of MD_Metadata.referenceSystemInfo will possibly imply to create an instance of CitedItem along with an
					instance of the association Auhority between IdentifiedItem and CitedItem."

					heikki : *possibly* ? what is that supposed to mean ? I assume : if there is an authority element in referenceSystemInfo.

					The type CI_Citation is mapped to the Extrinsic Object CitedItem in the CIM as defined in Table F.15.

					Table F.15 - From CI_Citation to CitedItem

					ISO 19115/ ISO 19119						CIM												Comments

					title													name
					alternateTitle										<<slot>>title
					date												- <<slot>> created for creation
																		- <<slot>> modified for revision
																		- <<slot>> issued for publication
					edition											-														Ignored
					editionDate									-														Ignored
					identifier.MD_Identifier.code			externalIdentifier								Identifiers with no codespace do not carry sufficient
																																information and are not mapped to externalIdentifier, for
																																which the codespace is required.
					citedResponsibleParty					Association CitedResponsibleParty 	For each instance of citedResponsibleParty.
																		+ an instance of Organization as 		The role of the responsible party classifies the
																																association CitedResponsibleParty
																		defined in Table F.16.							(CitedResponsibleParty classification)
					presentationForm							-														Ignored
					series											-														Ignored
					otherCitationDetails						-														Ignored
					collectiveTitle									-														Ignored
					ISBN											-														Ignored
					ISSN											-														Ignored
				-->
		<xsl:if test="gmd:MD_ReferenceSystem/gmd:referenceSystemIdentifier/gmd:RS_Identifier/gmd:authority">
			<xsl:variable name="citedItemId" select="concat('citedItemId-', generate-id(.))"/>
			<rim:ExtrinsicObject id="{$citedItemId}" objectType="{$citedItemObjectType}">
				<!--	heikki : alternateTitle has cardinality 0..n. I'm assuming spec writer means "for each". -->
				<xsl:for-each select="gmd:MD_ReferenceSystem/gmd:referenceSystemIdentifier/gmd:RS_Identifier/gmd:authority/gmd:CI_Citation/gmd:alternateTitle">
					<xsl:variable name="alternateTitle" select="./gco:CharacterString"/>
					<xsl:call-template name="slot-title">
						<xsl:with-param name="title" select="$alternateTitle"/>
					</xsl:call-template>
				</xsl:for-each>
				<!--	date. heikki : spec writer does not say how to distinguish between created, modified or issued. I am assuming it
								 maps to DateTypeCode values creation, revision and publication. -->
				<!--	heikki : date has cardinality 1..n. I'm assuming spec writer means "for each". -->
				<xsl:for-each select="gmd:MD_ReferenceSystem/gmd:referenceSystemIdentifier/gmd:RS_Identifier/gmd:authority/gmd:CI_Citation/gmd:date">
					<xsl:call-template name="slot-date-with-type">
						<xsl:with-param name="date" select="./gmd:CI_Date/gmd:date"/>
						<xsl:with-param name="dateType" select="./gmd:CI_Date/gmd:dateType"/>
					</xsl:call-template>
				</xsl:for-each>
				<!--	title -->
				<rim:Name>
					<xsl:variable name="name" select="gmd:MD_ReferenceSystem/gmd:referenceSystemIdentifier/gmd:RS_Identifier/gmd:authority/gmd:CI_Citation/gmd:title/gco:CharacterString"/>
					<rim:LocalizedString value="{$name}"/>
				</rim:Name>
				<!--	edition, editionDate : Ignored -->
				<!--	identifier.MD_Identifier.code to externalIdentifier : "Identifiers with no codespace do not carry sufficient information
								and are not mapped to externalIdentifier, for which the codespace is required." -->
				<!--	heikki: spec writer did not realize that MD_Identifier *never* has a codespace. Only its substitutiongroup
								RS_Identifier may have a codespace. I'm assuming they intended to say, RS_Identifier .. -->
				<!--	heikki : gmd:identifier has cardinality 0..n. I'm assuming spec writer meant "for each". -->
				<xsl:for-each select="gmd:MD_ReferenceSystem/gmd:referenceSystemIdentifier/gmd:RS_Identifier/gmd:authority/gmd:CI_Citation/gmd:identifier">
					<xsl:variable name="codespace" select="gmd:RS_Identifier/gmd:codeSpace/gco:CharacterString"/>
					<xsl:variable name="codevalue" select="gmd:RS_Identifier/gmd:code/child::*/@codeListValue"/>
					<xsl:if test="$codespace">
						<xsl:variable name="externalIdentifierId" select="concat('externalIdentifierId-', generate-id(.))"/>
						<rim:ExternalIdentifier id="{$externalIdentifierId}" registryObject="{$citedItemId}" identificationScheme="{$codespace}" value="{$codevalue}"/>
					</xsl:if>
				</xsl:for-each>
				<!-- citedResponsibleParty : For each instance of citedResponsibleParty. Creates new association, organization. See below.-->
				<!--	presentationForm, series, otherCitationDetails, collectiveTitle, ISBN, ISSN : Ignored -->
			</rim:ExtrinsicObject>
			<!-- citedResponsibleParty : For each instance of citedResponsibleParty. -->
			<xsl:for-each select="gmd:MD_ReferenceSystem/gmd:referenceSystemIdentifier/gmd:RS_Identifier/gmd:authority/gmd:CI_Citation/gmd:citedResponsibleParty">
				<!--
							Association CitedResponsibleParty + an instance of Organization as defined in Table F.16.
							The role of the responsible party classifies the association CitedResponsibleParty (CitedResponsibleParty classification).

							Table F.16 - From CI_ResponsibleParty to Organization
							ISO 19115/ ISO 19119					CIM													Comments
							individualName								-														Ignored
																																		If needed, it is possible to provide this information
																																		through the Organization.primaryContact property,
																																		which contains a reference to an instance of Person.
							organizationName							name
							positionName								-														Ignored
							contactInfo									-														Ignored
							role												Handled through the
																				CitedResponsibleParty classification
																				on the CitedResponsibleParty
																				association.
						-->
				<!-- heikki : this way an organization is created everytime, not re-used. Does not make any sense.. -->
				<xsl:variable name="organizationId" select="concat('organizationId-', generate-id(.))"/>
				<rim:Organization id="{$organizationId}" objectType="{$organizationObjectType}">
					<!--	individualName : Ignored. heikki : what now "if needed", is it ignored or not ?? I'm ignoring it. -->
					<!--	organizationName  -->
					<!-- heikki : it is organisationName with an 's' not a 'z' ! -->
					<!-- heikki : what if organisationName is absent ? ? -->
					<rim:Name>
						<xsl:variable name="name" select="gmd:CI_ResponsibleParty/gmd:organisationName/gco:CharacterString"/>
						<rim:LocalizedString value="{$name}"/>
					</rim:Name>
					<!--	positionName, contactInfo : Ignored -->
				</rim:Organization>
				<!--	role : CitedResponsibleParty association -->
				<!-- 	"Name and position information for an individual or organization that is responsible for the resource. The association Type
								has a set of subtypes operating to the same object types: PointOfCOntact, Author, Originator, Publisher."-->
				<!--	heikki : that's not true, no such subtypes are defined. This stuff is handled by classifying the association I believe -->
				<xsl:variable name="citedResponsiblePartyAssociationId" select="concat('citedResponsiblePartyAssociationId-', generate-id(.))"/>
				<rim:Association id="{$citedResponsiblePartyAssociationId}" associationType="{$citedResponsiblePartyAssociationType}" sourceObject="{$citedItemId}" targetObject="{$organizationId}"/>
				<!--xsl:variable name="metadataPointOfContactAssociationId" select="concat('metadataPointOfContactAssociationId-', generate-id(.))"/>
                        <rim:Association id="{$metadataPointOfContactAssociationId}" associationType="{$metadataPointOfContactAssociationType}" sourceObject="{$metadataInformationId}" targetObject="{$organizationId}"/-->
				<xsl:variable name="role" select="./gmd:CI_ResponsibleParty/gmd:role/gmd:CI_RoleCode/@codeListValue"/>
				<!-- heikki : the codelist for rolecode has *many* more options than just PointOfCOntact, Author, Originator, Publisher.
							 If it is not one of those 4, I ignore it so no classification will be created. Does not make any sense. -->
				<xsl:variable name="citedResponsiblePartyAssociationClassificationId" select="concat('citedResponsiblePartyAssociationClassificationId-', generate-id(.))"/>
				<xsl:if test="$role = 'pointOfContact'">
					<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyPointOfContactClassificationNode}"/>
				</xsl:if>
				<xsl:if test="$role = 'author'">
					<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyAuthorClassificationNode}"/>
				</xsl:if>
				<xsl:if test="$role = 'publisher'">
					<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyPublisherClassificationNode}"/>
				</xsl:if>
				<xsl:if test="$role = 'originator'">
					<rim:Classification id="{$citedResponsiblePartyAssociationClassificationId}" classifiedObject="{$citedResponsiblePartyAssociationId}" classificationScheme="{$citedResponsiblePartyClassificationScheme}" classificationNode="{$citedResponsiblePartyOriginatorClassificationNode}"/>
				</xsl:if>
			</xsl:for-each>
			<!-- authority association -->
			<xsl:variable name="authorityAssociationId" select="concat('authorityAssociationId-', generate-id(.))"/>
			<rim:Association id="{$authorityAssociationId}" associationType="{$authorityAssociationType}" sourceObject="{$identifiedItemId}" targetObject="{$citedItemId}"/>
		</xsl:if>
	</xsl:template>
	<xsl:template name="slot-date-with-type">
		<xsl:param name="date"/>
		<xsl:param name="dateType"/>
		<!-- the date can be either gco:Date or gco:DateTime -->
		<xsl:if test="$date/gco:Date">
			<!-- the dateType can be either creation, revision or publication -->
			<xsl:if test="$dateType/gmd:CI_DateTypeCode/@codeListValue = 'creation'">
				<xsl:call-template name="slot-typed-datetime">
					<xsl:with-param name="date" select="$date/gco:Date"/>
					<xsl:with-param name="slotname">
						<xsl:value-of select="$createdSlotName"/>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:if>
			<xsl:if test="$dateType/gmd:CI_DateTypeCode/@codeListValue = 'revision'">
				<xsl:call-template name="slot-typed-datetime">
					<xsl:with-param name="date" select="$date/gco:Date"/>
					<xsl:with-param name="slotname">
						<xsl:value-of select="$modifiedSlotName"/>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:if>
			<xsl:if test="$dateType/gmd:CI_DateTypeCode/@codeListValue = 'publication'">
				<xsl:call-template name="slot-typed-datetime">
					<xsl:with-param name="date" select="$date/gco:Date"/>
					<xsl:with-param name="slotname">
						<xsl:value-of select="$issuedSlotName"/>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:if>
		</xsl:if>
		<xsl:if test="$date/gco:DateTime">
			<!-- the dateType can be either creation, revision or publication -->
			<xsl:if test="$dateType/gmd:CI_DateTypeCode/@codeListValue = 'creation'">
				<xsl:call-template name="slot-typed-datetime">
					<xsl:with-param name="date" select="$date/gco:DateTime"/>
					<xsl:with-param name="slotname">
						<xsl:value-of select="$createdSlotName"/>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:if>
			<xsl:if test="$dateType/gmd:CI_DateTypeCode/@codeListValue = 'revision'">
				<xsl:call-template name="slot-typed-datetime">
					<xsl:with-param name="date" select="$date/gco:DateTime"/>
					<xsl:with-param name="slotname">
						<xsl:value-of select="$modifiedSlotName"/>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:if>
			<xsl:if test="$dateType/gmd:CI_DateTypeCode/@codeListValue = 'publication'">
				<xsl:call-template name="slot-typed-datetime">
					<xsl:with-param name="date" select="$date/gco:DateTime"/>
					<xsl:with-param name="slotname">
						<xsl:value-of select="$issuedSlotName"/>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<xsl:template name="slot-typed-date">
		<xsl:param name="date"/>
		<xsl:param name="slotname"/>
		<rim:Slot name="{$slotname}" slotType="{$dateSlotType}">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$date"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<xsl:template name="slot-typed-datetime">
		<xsl:param name="date"/>
		<xsl:param name="slotname"/>
		<rim:Slot name="{$slotname}" slotType="{$dateTimeSlotType}">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$date"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<!--
			"For each instance of the property. Each ‘type’ slot contains a reference to a node of the ObjectType classification scheme. This
			concerns the nodes: Dataset, Service and Application." -->
	<!--
			heikki: thanks, spec writer, for being so specific. I take it you mean the following ObjectTypes :

			urn:x-ogc:specification:csw-ebrim-cim:ObjectType:Application (from CIM extension package)
			urn:ogc:def:ebRIM-ObjectType:OGC:Dataset (from basic extension package)
			urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:Service (from canonical ebrim)

			heikki: also thanks for not specifying *how* hierarchyLevel is mapped to those ObjectTypes. I assume the conditions below. And
			what if the hierarchyLevel is not one of those 3 ??
	 -->
	 <xsl:template name="classification-hierarchyLevel">
		<xsl:param name="hierarchyLevel"/>
		<xsl:param name="resourceMetadataId"/>
		<xsl:variable name="classificationHierarchyLevelId" select="concat('classificationHierarchyLevelId-', generate-id(.))"/>

		<xsl:if test="$hierarchyLevel = 'dataset'">
				<rim:Classification id="{$classificationHierarchyLevelId}" classifiedObject="{$resourceMetadataId}" classificationScheme="{$objectTypeClassificationScheme}" classificationNode="{$datasetObjectType}"/>

            <xsl:variable name="datasetId" select="concat('seriesId-', generate-id(.))"/>
            <rim:ExtrinsicObject id="{$datasetId}" objectType="{$datasetObjectType}" />

            <xsl:variable name="datasetDescriptionAssociationId" select="concat('datasetDescriptionAssociationId-', generate-id(.))"/>
            <rim:Association id="{$datasetDescriptionAssociationId}" associationType="{$datasetDescriptionAssociationType}" sourceObject="{$resourceMetadataId}" targetObject="{$datasetId}" />
		</xsl:if>

		<xsl:if test="$hierarchyLevel = 'service'">
			<rim:Classification id="{$classificationHierarchyLevelId}" classifiedObject="{$resourceMetadataId}" classificationScheme="{$objectTypeClassificationScheme}" classificationNode="{$serviceObjectType}"/>

            <xsl:variable name="serviceId" select="concat('serviceId-', generate-id(.))"/>
            <rim:ExtrinsicObject id="{$serviceId}" objectType="{$serviceObjectType}" />

            <xsl:variable name="serviceDescriptionAssociationId" select="concat('serviceDescriptionAssociationId-', generate-id(.))"/>
            <rim:Association id="{$serviceDescriptionAssociationId}" associationType="{$serviceDescriptionAssociationType}" sourceObject="{$resourceMetadataId}" targetObject="{$serviceId}" />
		</xsl:if>

		<xsl:if test="$hierarchyLevel = 'application'">
		    <rim:Classification id="{$classificationHierarchyLevelId}" classifiedObject="{$resourceMetadataId}" classificationScheme="{$objectTypeClassificationScheme}" classificationNode="{$applicationObjectType}"/>

            <xsl:variable name="applicationId" select="concat('applicationId-', generate-id(.))"/>
		    <rim:ExtrinsicObject id="{$applicationId}" objectType="{$applicationObjectType}" />

            <xsl:variable name="applicationDescriptionAssociationId" select="concat('applicationDescriptionAssociationId-', generate-id(.))"/>
            <rim:Association id="{$applicationDescriptionAssociationId}" associationType="{$applicationDescriptionAssociationType}" sourceObject="{$resourceMetadataId}" targetObject="{$applicationId}" />
		</xsl:if>
		
		<xsl:if test="$hierarchyLevel = 'series'">
    		<rim:Classification id="{$classificationHierarchyLevelId}" classifiedObject="{$resourceMetadataId}" classificationScheme="{$objectTypeClassificationScheme}" classificationNode="{$datasetCollectionObjectType}"/>

            <xsl:variable name="seriesId" select="concat('seriesId-', generate-id(.))"/>
            <rim:ExtrinsicObject id="{$seriesId}" objectType="{$datasetCollectionObjectType}" />

            <xsl:variable name="datasetDescriptionAssociationId" select="concat('datasetDescriptionAssociationId-', generate-id(.))"/>
            <rim:Association id="{$datasetDescriptionAssociationId}" associationType="{$datasetDescriptionAssociationType}" sourceObject="{$resourceMetadataId}" targetObject="{$seriesId}" />
		</xsl:if>

	</xsl:template>

	<xsl:template name="slot-hierarchyLevel">
		<xsl:param name="hierarchyLevel"/>
		<xsl:if test="$hierarchyLevel = 'dataset'">
			<!--	heikki : what should slotType be ? xsd:string ? -->
			<rim:Slot name="{$typeSlotName}" slotType="xsd:string">
				<rim:ValueList>
					<rim:Value>
						<xsl:value-of select="$datasetObjectType"/>
					</rim:Value>
				</rim:ValueList>
			</rim:Slot>
		</xsl:if>
		<xsl:if test="$hierarchyLevel = 'service'">
			<!--	heikki : what should slotType be ? xsd:string ? -->
			<rim:Slot name="{$typeSlotName}" slotType="xsd:string">
				<rim:ValueList>
					<rim:Value>
						<xsl:value-of select="$serviceObjectType"/>
					</rim:Value>
				</rim:ValueList>
			</rim:Slot>
		</xsl:if>
		<xsl:if test="$hierarchyLevel = 'application'">
			<!--	heikki : what should slotType be ? xsd:string ? -->
			<rim:Slot name="{$typeSlotName}" slotType="xsd:string">
				<rim:ValueList>
					<rim:Value>
						<xsl:value-of select="$applicationObjectType"/>
					</rim:Value>
				</rim:ValueList>
			</rim:Slot>
		</xsl:if>
		<xsl:if test="$hierarchyLevel = 'series'">
			<!--	heikki : what should slotType be ? xsd:string ? -->
			<rim:Slot name="{$typeSlotName}" slotType="xsd:string">
				<rim:ValueList>
					<rim:Value>
						<xsl:value-of select="$datasetCollectionObjectType"/>
					</rim:Value>
				</rim:ValueList>
			</rim:Slot>
		</xsl:if>
	</xsl:template>
	<xsl:template name="slot-identifier">
		<xsl:param name="identifier"/>
		<!--	heikki : what should slotType be ? xsd:string ? xsd:anyURI ? -->
		<rim:Slot name="{$identifierSlotName}" slotType="xsd:string">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$identifier"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<xsl:template name="slot-title">
		<xsl:param name="title"/>
		<!--	heikki : what should slotType be ? xsd:string ?  -->
		<rim:Slot name="{$titleSlotName}" slotType="xsd:string">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$title"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<xsl:template name="slot-language">
		<xsl:param name="language"/>
		<rim:Slot name="{$languageSlotName}" slotType="{$languageSlotType}">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$language"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<!--	used in table F.1 -->
	<xsl:template name="slot-date">
		<xsl:param name="dateStamp"/>
		<rim:Slot name="{$dateSlotName}" slotType="{$dateTimeSlotType}">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$dateStamp"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<xsl:template name="slot-conformsTo">
		<xsl:param name="metadataStandardName"/>
		<xsl:param name="metadataStandardVersion"/>
		<!--	"Slot type is a two-level classification that handles both standard name and standard version"  :
				heikki : what does that mean ?? something like this ? -->
		<rim:Slot name="{$conformsToSlotName}" slotType="xsd:string">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$metadataStandardName"/>
				</rim:Value>
				<rim:Value>
					<xsl:value-of select="$metadataStandardVersion"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<xsl:template name="slot-resolution">
		<xsl:param name="uom"/>
		<xsl:param name="distance"/>
		<!--	heikki : what should slot type be ? -->
		<!--	heikki : I put uom and distance both in here, but I made that up myself. No specs about this ?? -->
		<rim:Slot name="{$resolutionSlotName}" slotType="xsd:string">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$uom"/>
				</rim:Value>
				<rim:Value>
					<xsl:value-of select="$distance"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<xsl:template name="slot-scaledenominator">
		<xsl:param name="scaleDenominator"/>
		<!--	heikki : what should slot type be ? -->
		<rim:Slot name="{$scaleDenominatorSlotName}" slotType="xsd:string">
			<rim:ValueList>
				<rim:Value>
					<xsl:value-of select="$scaleDenominator"/>
				</rim:Value>
			</rim:ValueList>
		</rim:Slot>
	</xsl:template>
	<xsl:template name="classification-characterSet">
		<xsl:param name="characterSet"/>
		<xsl:param name="classifiedObjectId"/>
		<!--	classificationscheme id from OGC 07-038 table D.3 -->
		<!--	in Frederic Houbert's files, it's urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet -->
		<!--	but that is not according to the spec ! TODO tell him -->
		<xsl:variable name="classificationId" select="concat('classificationId-', generate-id(.))"/>
		<rim:Classification id="{$classificationId}" classifiedObject="{$classifiedObjectId}" classificationScheme="{$characterSetClassificationScheme}" classificationNode="{$characterSet}"/>
		<!--	TODO this charset must be post-processed to pick up the classificationnode *ID* (this is *Code*) -->
		<!--	see also OGC 07-038 section C.4.1 -->
	</xsl:template>
</xsl:stylesheet>
