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
3. cd to <ECM_MOCK_HOME> dir
4. Run, "mvn clean package"
5. Create a root data dir for mock json data, <ECM_MOCK_DATA_DIR>
6. Create the following directories under <ECM_MOCK_DATA_DIR>,
	org/
	hcf/
	resorg/
	person/
	crs/
	hcp-player/
	hcp-role/
	idp/

7. Respective mock json files can be copied over to these folders	
8. Download Jboss 6 EAP from https://s3.amazonaws.com/ctrp-repos/Installs/jboss-eap-6.2.0.zip
9. Unzip to <JBOSS_HOME> dir
10. Edit <JBOSS_HOME>/bin/standalone.conf or <JBOSS_HOME>/bin/standalone.sh
11. Add to JAVA_OPTS, -DECM_MOCK_DATA_DIR=<ECM_MOCK_DATA_DIR>
12. To start Jboss, run, 
<JBOSS_HOME>/bin/standalone.sh

Validate ECM Mock App is up
---------------------------

1. Hit the following url to get the build info (TODO: Right now, hardcoded info to be replaced with build or env specific info),

http://<server-host-name>:39680/ecm-webservices/services/build-service/build
