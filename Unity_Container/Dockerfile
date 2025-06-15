FROM ubuntu:22.04

# System dependencies
RUN apt update && apt install -y \
    wget \
    libgtk2.0-0 \
    libgconf-2-4 \
    libnss3 \
    libasound2 \
    libxss1 \
    libxtst6 \
    libcanberra-gtk-module \
    libgl1-mesa-glx \
    libx11-xcb1 \
    libxcomposite1 \
    libxcursor1 \
    libxdamage1 \
    libxi6 \
    libxrandr2 \
    libxrender1 \
    libxcb1 \
    libdbus-1-3 \
    libpulse0 \
    curl \
    ca-certificates \
    libglib2.0-0 \
    libglu1-mesa \
    unzip \
    xvfb \
    sudo \
    x11-xserver-utils

# Create user
RUN useradd -ms /bin/bash dev && usermod -aG sudo dev && echo "dev ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
USER dev
WORKDIR /home/dev

# Set DISPLAY env (will be overridden at runtime)
ENV DISPLAY=:0

# (Optional) Install Unity Hub via AppImage
RUN wget https://public-cdn.cloud.unity3d.com/hub/prod/UnityHub.AppImage -O UnityHub.AppImage && \
    chmod +x UnityHub.AppImage

CMD ["./UnityHub.AppImage"]
