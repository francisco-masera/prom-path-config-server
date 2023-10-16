FROM gradle:6.9.1-jdk11-alpine AS tmp_build_img
WORKDIR /app
COPY . .
RUN gradle build

FROM azul/zulu-openjdk-alpine:11.0.20
COPY --from=tmp_build_img . .
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/app/build/libs/app.jar"]