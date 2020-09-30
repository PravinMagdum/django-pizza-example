FROM python:3.7-buster
RUN mkdir -p /opt/app
COPY sonar-project.properties  /opt/app/
