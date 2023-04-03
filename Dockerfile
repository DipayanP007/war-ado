# FROM maven as builder

# WORKDIR /opt/servlet

# COPY . .

# RUN mvn clean package

# RUN cp target/simple-servlet-0.1.war target/ROOT.war


FROM tomcat:9.0.73-jdk8-corretto

ENV CATALINA_OPTS="${CATALINA_OPTS} -Dconfig=db.properties"

COPY ./target/simple-servlet-0.1.war /usr/local/tomcat/webapps/ROOT.war