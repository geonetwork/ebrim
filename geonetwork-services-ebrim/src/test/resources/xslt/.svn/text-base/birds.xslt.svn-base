<?xml version="1.0"?>

  <!--
   * Licensed to the Apache Software Foundation (ASF) under one
   * or more contributor license agreements. See the NOTICE file
   * distributed with this work for additional information
   * regarding copyright ownership. The ASF licenses this file
   * to you under the Apache License, Version 2.0 (the  "License");
   * you may not use this file except in compliance with the License.
   * You may obtain a copy of the License at
   *
   *     http://www.apache.org/licenses/LICENSE-2.0
   *
   * Unless required by applicable law or agreed to in writing, software
   * distributed under the License is distributed on an "AS IS" BASIS,
   * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   * See the License for the specific language governing permissions and
   * limitations under the License.
  -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
  <xsl:output method="xml" indent="yes"/>

<xsl:template match="Class">
	<birdInfo>
		<xsl:apply-templates select="Order"/>
	</birdInfo>
</xsl:template>

<xsl:template match="Order">
	<order>
		<xsl:value-of select="@Name"/>
		<xsl:apply-templates select="Family"/>
	</order>
</xsl:template>

<xsl:template match="Family">
	<family>
		<xsl:value-of select="@Name"/>
		<xsl:apply-templates select="Species | SubFamily | text()"/>
	</family>
</xsl:template>

<xsl:template match="SubFamily">
	<subFamily>
		<xsl:value-of select="@Name"/>
    	<xsl:apply-templates select="Species | text()"/>
    </subFamily>
</xsl:template>

<xsl:template match="Species">
	<species>
	<xsl:choose>
	  <xsl:when test="name(..)='SubFamily'">
		<xsl:text>	</xsl:text><xsl:value-of select="."/><xsl:text> </xsl:text><xsl:value-of select="@Scientific_Name"/>
	  </xsl:when>
	  <xsl:otherwise>
		<xsl:value-of select="."/><xsl:text> </xsl:text><xsl:value-of select="@Scientific_Name"/>
	  </xsl:otherwise>
	</xsl:choose>
	</species>
</xsl:template>

</xsl:stylesheet>
