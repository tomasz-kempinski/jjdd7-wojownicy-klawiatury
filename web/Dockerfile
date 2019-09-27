FROM jboss/wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#98765 --silent

ADD standalone.xml /opt/jboss/wildfly/standalone/configuration

ADD target/wojownicy-klawiatury.war /opt/jboss/wildfly/standalone/deployments/

ADD docker-config/wildfly/standalone/configuration/standalone.xml /opt/jboss/wildfly/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

