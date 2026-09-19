FROM eclipse-temurin:21-jre

WORKDIR /app

ARG OTEL_AGENT_VERSION=2.31.1

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v${OTEL_AGENT_VERSION}/opentelemetry-javaagent.jar /opt/opentelemetry-javaagent.jar

COPY build/libs/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=docker \
    JAVA_TOOL_OPTIONS=-javaagent:/opt/opentelemetry-javaagent.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
