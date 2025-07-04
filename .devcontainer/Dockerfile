FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Instala Java 21
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk && \
    apt-get clean

# Configura Java 21 como predeterminado
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"