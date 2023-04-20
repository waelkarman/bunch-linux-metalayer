SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += " weston empty-root-password allow-empty-password allow-root-login ssh-server-dropbear tools-sdk dev-pkgs debug-tweaks package-management hwcodecs"

IMAGE_INSTALL += "nano helloworld helloworldqt helloworldqml hello-module env-config"



PACKAGECONFIG:append:pn-qtbase = " vulkan getentropy freetype harfbuzz jpeg libpng gif ico zlib pcre eglfs gl gles2 no-opengl tslib cups dbus xcb sql-ibase sql-mysql sql-psql sql-odbc sql-oci sql-tds sql-db2 sql-sqlite2 sql-sqlite iconv xkbcommon evdev mtdev lttng fontconfig gtk directfb linuxfb kms gbm icu udev openssl widgets libproxy libinput journald"
PACKAGECONFIG:append:pn-qtwayland = "wayland-client wayland-server xcomposite-egl xcomposite-glx wayland-egl wayland-brcm wayland-drm-egl-server-buffer wayland-libhybris-egl-server-buffer wayland-vulkan-server-buffer "
