FROM jenkins/inbound-agent:latest-jdk11
RUN apk add --no-cache curl grep sed unzip nodejs npm
WORKDIR /root 
RUN set -x &&\
 curl --insecure -o ./sonarscanner.zip -L https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-$RELEASE-linux.zip &&\
 unzip sonarscanner.zip &&\
 rm sonarscanner.zip &&\
 rm sonar-scanner-$RELEASE-linux/jre -rf &&\
# ensure Sonar uses the provided Java for musl instead of a borked glibc one
 sed -i 's/use_embedded_jre=true/use_embedded_jre=false/g' /root/sonar-scanner-$RELEASE-linux/bin/sonar-scanner
 
ENV SONAR_RUNNER_HOME=/root/sonar-scanner-$RELEASE-linux
ENV PATH $PATH:/root/sonar-scanner-$RELEASE-linux/bin
RUN mkdir -p /opt/app
wORKDIR /opt/app
COPY *  /opt/app/
