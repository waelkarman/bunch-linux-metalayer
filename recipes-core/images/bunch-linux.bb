SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image
inherit populate_sdk_qt5

IMAGE_FEATURES += " weston ssh-server-openssh tools-sdk debug-tweaks package-management hwcodecs tools-debug"

IMAGE_INSTALL += " weston-xwayland xwayland pi-bluetooth bluez5 iw wpa-supplicant linux-firmware-bcm43455 busybox-udhcpc rsync parted util-linux screen lsof wget net-tools ntp u-boot-fw-utils u-boot base-files"
IMAGE_INSTALL += " systemd tree i2c-tools nano rauc jq v4l-utils" 
IMAGE_INSTALL += " raspi-gpio pi-blaster libgpiod-dev rpi-gpio rpio"
IMAGE_INSTALL += " python3-pyzmq python3 python3-pip"
IMAGE_INSTALL += " zmqrequest zmqreply zmqpublish zmqsubscribe"
IMAGE_INSTALL += " helloworld hello-module"
IMAGE_INSTALL += " sensors-app systemdservices gpio-write-sysfs passivebuzzer-service gpio-read-sysfs-service networkchecker-service nautilus icon-weston"
IMAGE_INSTALL += " wlan-enabler bunch-update curl packagegroup-qt5-toolchain-target packagegroup-qt5-qtcreator-debug tigervnc"
