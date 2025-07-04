FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Instala Java 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean

# Configura Java 17 como predeterminado
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"