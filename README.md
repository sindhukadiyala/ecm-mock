# ecm-mock
--------------------------------------
Service to mock CTEP messages for ctrp_ecm microservice.

System requirements
-------------------

All you need to build this project is Java 7.0 (Java SDK 1.7) or better, Maven 3.0 or better.

The application this project produces is designed to be run on JBoss Enterprise Application Platform 6. 

Build and Deploy ecm-mock
-------------------------

1. Set up env variables for M2_HOME, JAVA_HOME and add it to PATH
2. Clone git repo, https://github.com/CBIIT/ecm-mock.git
3. cd to &lt;ECM_MOCK_HOME&gt; dir
4. Run, "mvn clean package"
5. Create a root data dir for mock json data, &lt;ECM_MOCK_DATA_DIR&gt;
6. Create the following directories under &lt;ECM_MOCK_DATA_DIR&gt;,
	org/
	hcf/
	resorg/
	person/
	crs/
	hcp-player/
	hcp-role/
	idp/
	jms/

7. Respective mock json files can be copied over to these folders	
8. Download Jboss 6 EAP from https://s3.amazonaws.com/ctrp-repos/Installs/jboss-eap-6.2.0.zip
9. Unzip to &lt;JBOSS_HOME&gt; dir
10. Edit &lt;JBOSS_HOME&gt;/bin/standalone.conf or &lt;JBOSS_HOME&gt;/bin/standalone.sh
11. Copy &lt;ECM_MOCK_HOME&gt;/server-config/standalone.xml to &lt;JBOSS_HOME&gt;/standalone/configuration/
12. Set environment variable, LOGLEVEL=INFO
13. Add to JAVA_OPTS, -DECM_MOCK_DATA_DIR=&lt;ECM_MOCK_DATA_DIR&gt;
14. To start Jboss, run, &lt;JBOSS_HOME&gt;/bin/standalone.sh

Validate ECM Mock App is up
---------------------------

1. Hit the following url to get the build info (TODO: Right now, hardcoded info to be replaced with build or env specific info),

`http://<server-host-name>:39680/ecm-webservices/services/build-service/build`

Enqueue Mock JMS Message
------------------------

Make a GET call to the following URL:

http://&lt;server-host-name&gt;:39680/ecm-webservices/services/jms-service/createmsgs?id=&lt;id&gt;&amp;id=&lt;id&gt;

`curl -v http://ctrp-ecmmock-inttest-elb-142612445.us-east-1.elb.amazonaws.com:39680/ecm-webservices/services/jms-service/createmsgs?id=14352&id=509983`

Will enqueue &lt;ECM_MOCK_DATA_DIR&gt;/jms/14352.xml and 509983.xml as JMS messages.
