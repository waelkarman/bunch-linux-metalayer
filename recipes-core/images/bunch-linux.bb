SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image
inherit populate_sdk_qt5
inherit extrausers

# To generate a valid pass: printf "%q" $(mkpasswd -m sha256crypt admin-nosexinthechurch)
PASSWD = "\$5\$YA7nDY0J\$th7S4jEgsrMeq45QCksPT6.gKk0Wqu3kO9xCgt7Yj43"

EXTRA_USERS_PARAMS = " \
    usermod -p '${PASSWD}' weston; \
"

IMAGE_FEATURES += " weston ssh-server-openssh tools-sdk debug-tweaks package-management hwcodecs tools-debug"

IMAGE_INSTALL += " weston-xwayland xwayland pi-bluetooth bluez5 iw wpa-supplicant linux-firmware-bcm43455 busybox-udhcpc rsync parted util-linux screen lsof wget net-tools ntp u-boot-fw-utils u-boot base-files"
IMAGE_INSTALL += " systemd tree i2c-tools nano rauc jq v4l-utils" 
IMAGE_INSTALL += " raspi-gpio pi-blaster libgpiod-dev rpi-gpio rpio"
IMAGE_INSTALL += " python3-pyzmq python3 python3-pip"
IMAGE_INSTALL += " zmqrequest zmqreply zmqpublish zmqsubscribe"
IMAGE_INSTALL += " helloworld hello-module"
IMAGE_INSTALL += " sensors-app systemdservices gpio-write-sysfs passivebuzzer-service gpio-read-sysfs-service networkchecker-service nautilus icon-weston"
IMAGE_INSTALL += " wlan-enabler bunch-update curl packagegroup-qt5-toolchain-target packagegroup-qt5-qtcreator-debug neatvnc"
IMAGE_INSTALL += " pipewire pipewire-modules-rt pipewire-alsa pipewire-v4l2 pipewire-dev pipewire-tools pipewire-spa-plugins-meta pipewire-spa-tools pipewire-modules-meta"

do_deploy_to_rasp() {
    # Codice personalizzato da eseguire alla fine della creazione del pacchetto
    # L'output è visibile al path: build/tmp/work/bunch_raspberrypi4_64-poky-linux/bunch-linux/1.0-r0/temp/log.do_deploy_to_rasp
    echo "Custom deploy task."
    echo "- current path: $(pwd)"
    #scp $(pwd)/tmp/deploy/images/bunch-raspberrypi4-64/bunch-linux-bundle-bunch-raspberrypi4-64.raucb root@192.168.1.28:~/
    #dd if=$(pwd)/tmp/deploy/images/bunch-raspberrypi4-64/bunch-linux-bundle-bunch-raspberrypi4-64.raucb of=/dev/sda bs=4M
}

addtask deploy_to_rasp after do_image_complete