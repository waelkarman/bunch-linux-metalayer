SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image
inherit populate_sdk_qt5

IMAGE_FEATURES += " weston ssh-server-dropbear tools-sdk dev-pkgs debug-tweaks package-management hwcodecs"

IMAGE_INSTALL += " pi-bluetooth bluez5 iw wpa-supplicant linux-firmware-bcm43455 busybox-udhcpc"
IMAGE_INSTALL += " systemd tree i2c-tools nano rauc" 
IMAGE_INSTALL += " raspi-gpio pi-blaster libgpiod-dev rpi-gpio rpio"
IMAGE_INSTALL += " python3-pyzmq python3 python3-pip"
IMAGE_INSTALL += " zmqrequest zmqreply zmqpublish zmqsubscribe"
IMAGE_INSTALL += " helloworld hello-module"
IMAGE_INSTALL += " sensors-app systemdservices gpio-write-sysfs passivebuzzer-service gpio-read-sysfs-service networkchecker-service icon-weston"

