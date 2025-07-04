SUMMARY = "Linux embedded for RasPi Car Device"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image


IMAGE_INSTALL += "\
    packagegroup-core-boot \
    packagegroup-core-x11-base \
    packagegroup-core-x11-xserver \
    qtbase \
    qtbase-plugins \
    qtdeclarative \
    qtwayland \
    qttools \
    qttools-tools \
    qtsvg \
    qtimageformats \
    qtmultimedia \
    qtconnectivity \
    qtshadertools \
    tslib \
    evtest \
    xinput-calibrator \
    matchbox-terminal \
    xterm \
    readtemperature \
    matchbox-terminal \
    alsa-utils \
    packagegroup-base-bluetooth \
    bluez5 \
    wpa-supplicant \
    iw \
    rfkill \
    networkmanager \
    chromium-x11 \
"

IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_SIZE ?= "204800"

