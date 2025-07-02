# Base image with Node.js
FROM node:18-bullseye

# Install system dependencies for building Electron apps for Windows
RUN dpkg --add-architecture i386 && \
    apt-get update && apt-get install -y \
    wine64 \
    wine32 \
    mono-complete \
    libgtk-3-dev \
    build-essential \
    python3 \
    curl \
    unzip \
    xvfb \
    && apt-get clean

# Optional: install electron-builder globally
RUN npm install -g electron electron-builder

# Set the working directory inside container
WORKDIR /workspace

# Default command to enter shell
CMD [ "bash" ]
