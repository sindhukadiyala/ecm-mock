# Base image 
FROM maven:3.3.9-jdk-7
MAINTAINER Radu Robotin <radu.robotin@nih.gov>

# Install packages necessary to run EAP
#RUN yum update -y && yum -y install xmlstarlet saxon augeas bsdtar unzip postgresql && yum clean all

# Create a user and group used to launch processes
# The user ID 1000 is the default for the first "regular" user on Fedora/RHEL,
# so there is a high chance that this ID will be equal to the current user
# making it easier to use volumes (no permission issues)
RUN groupadd -r jboss -g 1000 && useradd -u 1000 -r -g jboss -m -d /opt/jboss -s /sbin/nologin -c "JBoss user" jboss && \
    chmod 755 /opt/jboss



# Set the working directory to jboss' user home directory
WORKDIR /opt/jboss

# Install necessary packages
#RUN yum -y install java-1.8.0-openjdk-devel && yum clean all
#RUN yum -y install java-1.7.0-openjdk-devel && yum clean all
RUN apt-get update && apt-get install -y && rm -rf /var/lib/apt/lists/* && mkdir -p /usr/src/app

ADD https://s3.amazonaws.com/ctrp-repos/Installs/jboss-eap-6.2.0.zip /opt/
RUN unzip /opt/jboss-eap-6.2.0.zip
RUN ln -s /opt/jboss /opt/jboss-eap-6.2

# Set the JAVA_HOME variable to make it clear where Java is located
#ENV JAVA_HOME /usr/lib/jvm/java
ENV EAP_HOME /opt/jboss/jboss-eap-6.2
ENV JBOSS_HOME /opt/jboss/jboss-eap-6.2
ENV LOGLEVEL INFO

COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package

COPY ./server-config/standalone.xml "$JBOSS_HOME/standalone/configuration/"

RUN cp  /usr/src/app/ear-module/target/ecm-mock.ear "$JBOSS_HOME/standalone/deployments/"
EXPOSE 39680
EXPOSE 31699
EXPOSE 5445
EXPOSE 5455

CMD $JBOSS_HOME/bin/standalone.sh
