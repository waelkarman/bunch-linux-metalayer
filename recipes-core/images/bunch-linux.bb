SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image

#DISTRO_FEATURES += " systemd opengl wayland"
IMAGE_FEATURES += " weston ssh-server-dropbear tools-sdk dev-pkgs debug-tweaks package-management hwcodecs"

IMAGE_INSTALL += " systemd tree i2c-tools nano" 
IMAGE_INSTALL += " raspi-gpio pi-blaster libgpiod-dev rpi-gpio rpio"
IMAGE_INSTALL += " python3-pyzmq python3 python3-pip"
IMAGE_INSTALL += " zmqrequest zmqreply zmqpublish zmqsubscribe"
IMAGE_INSTALL += " helloworld hello-module"
IMAGE_INSTALL += " sensors-app systemdservices gpio-write-sysfs passivebuzzer-service gpio-read-sysfs-service networkchecker-service icon-weston"
 
# Not needed anymore since the app is launched by weston directly and the env it's in the launching command into the weston.ini
# env-config

PACKAGECONFIG:append:pn-qtbase = " vulkan getentropy freetype harfbuzz jpeg libpng gif ico zlib pcre eglfs gl gles2 no-opengl tslib cups dbus xcb sql-ibase sql-mysql sql-psql sql-odbc sql-oci sql-tds sql-db2 sql-sqlite2 sql-sqlite iconv xkbcommon evdev mtdev lttng fontconfig gtk directfb linuxfb kms gbm icu udev openssl widgets libproxy libinput journald"
PACKAGECONFIG:append:pn-qtwayland = "wayland-client wayland-server xcomposite-egl xcomposite-glx wayland-egl wayland-brcm wayland-drm-egl-server-buffer wayland-libhybris-egl-server-buffer wayland-vulkan-server-buffer "
