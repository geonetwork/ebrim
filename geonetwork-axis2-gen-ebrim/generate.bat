set AXIS2_HOME=..\geonetwork-axis2-home\axis2-1.4.1

#../geonetwork-axis2-home/axis2-1.4.1/bin/wsdl2java.bat -t -ss -sd -d jibx -pn OGCWebServicePort -o src\main\java  -p org.geonetwork.webservices.ebrim.csw202 -Ebindingfile ..\geonetwork-domain-ebrim\src\main\config\ebxml-jibx-binding.xml -uri ebrim.wsdl
../geonetwork-axis2-home/axis2-1.4.1/bin/wsdl2java.bat -t -ss -sd -d jibx -pn DiscoveryPort     -o src\main\java  -p org.geonetwork.webservices.ebrim.csw202 -Ebindingfile ..\geonetwork-domain-ebrim\src\main\config\ebxml-jibx-binding.xml -uri ebrim.wsdl
#../geonetwork-axis2-home/axis2-1.4.1/bin/wsdl2java.bat -t -ss -sd -d jibx -pn PublicationPort   -o src\main\java  -p org.geonetwork.webservices.ebrim.csw202 -Ebindingfile ..\geonetwork-domain-ebrim\src\main\config\ebxml-jibx-binding.xml -uri ebrim.wsdl


# While running the Axis generation of skeleton code for OGCWebServicePort, this message is given:  No mapping defined for element {http://www.opengis.net/cat/wrs/1.0}Capabilities
# While running the Axis generation of skeleton code for DiscoveryPort, all goes well.
# While running the Axis generation of skeleton code for PublicationPort, this message is given: No mapping defined for element {http://www.opengis.net/cat/csw/2.0.2}Harvest 