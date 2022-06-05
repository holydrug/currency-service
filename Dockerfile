
ARG BUILD_HOME=./

FROM gradle:jdk8 as build-image

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

ADD --chown=gradle:gradle build.gradle settings.gradle $APP_HOME/
ADD --chown=gradle:gradle src $APP_HOME/src

RUN gradle

FROM openjdk:8-alpine

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME

ENTRYPOINT java -jar alfabank-test-wallet-course-0.0.1-SNAPSHOT.jar