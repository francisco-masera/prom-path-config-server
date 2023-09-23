FROM gradle:5.3.0-jdk-alpine AS tmp_build_img
ENV app_home=/usr/app/
WORKDIR $app_home
COPY build.gradle settings.gradle $app_home

COPY gradle $app_home/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src

RUN gradle build || return 0
COPY . .
RUN gradle clean build


FROM azul/zulu-openjdk-alpine:11.0.20
ENV artifact_name=prom-path-config-server-0.0.1-SNAPSHOT.jar
ENV app_home=/usr/app/

WORKDIR $app_home
COPY --from=tmp_build_img $app_home/build/libs/$artifact_name .

EXPOSE 8888

ENTRYPOINT exec java -jar ${artifact_name}