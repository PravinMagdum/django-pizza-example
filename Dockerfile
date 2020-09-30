FROM python:3.7-buster
RUN mkdir -p /opt/app
wORKDIR /opt/app
COPY *  /opt/app/
