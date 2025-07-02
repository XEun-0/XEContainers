FROM openjdk:21-slim

RUN apt-get update && apt-get install -y \
    git \
    maven \
    netcat-openbsd \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /workspace

CMD ["bash"]
