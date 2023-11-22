SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image
inherit populate_sdk_qt5

IMAGE_FEATURES += " weston ssh-server-openssh tools-sdk debug-tweaks package-management hwcodecs tools-debug"

IMAGE_INSTALL:remove = " cups"
IMAGE_INSTALL += " pi-bluetooth bluez5 iw wpa-supplicant linux-firmware-bcm43455 busybox-udhcpc rsync parted util-linux screen lsof wget"
IMAGE_INSTALL += " systemd tree i2c-tools nano rauc jq v4l-utils" 
IMAGE_INSTALL += " raspi-gpio pi-blaster libgpiod-dev rpi-gpio rpio"
IMAGE_INSTALL += " python3-pyzmq python3 python3-pip"
IMAGE_INSTALL += " zmqrequest zmqreply zmqpublish zmqsubscribe"
IMAGE_INSTALL += " helloworld hello-module"
IMAGE_INSTALL += " sensors-app systemdservices gpio-write-sysfs passivebuzzer-service gpio-read-sysfs-service networkchecker-service icon-weston"

IMAGE_INSTALL += " packagegroup-qt5-toolchain-target packagegroup-qt5-qtcreator-debug"

# nativesdk-packagegroup-qt5-toolchain-host  
# Default Targetq
# SYSTEMD_DEFAULT_TARGET = "bunch-linux.target"

# Manage rootfs extra space parted util-linux screen lsof wget
# IMAGE_ROOTFS_EXTRA_SPACE = "3643040"
#  