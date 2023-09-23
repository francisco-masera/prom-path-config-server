FROM gradle:6.9.4-jdk11-alpine AS tmp_build_img
WORKDIR /usr/app/
COPY . .
RUN gradle build

FROM azul/zulu-openjdk-alpine:11.0.20
ENV artifact_name=prom-path-config-server-0.0.1-SNAPSHOT.jar
ENV app_home=/usr/app/

WORKDIR $app_home
COPY --from=tmp_build_img $app_home .

EXPOSE 8888

ENTRYPOINT exec java -jar ${artifact_name}