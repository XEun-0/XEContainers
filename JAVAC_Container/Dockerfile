##################################################################
# Docker Compose Configuration
#
# Description:
#       Dockerfile to build a java docker container to run and 
#       compile java, maven.
#
# File: Dockerfile
# Author: Edward King Fjura
# Last Updated: 7/2/2025
#
##################################################################

FROM openjdk:21-slim

RUN apt-get update && apt-get install -y \
    git \
    maven \
    netcat-openbsd \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /workspace

CMD ["bash"]
