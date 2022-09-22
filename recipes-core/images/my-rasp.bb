SUMMARY = "A very basic Wayland image with a terminal"

IMAGE_FEATURES += "splash debug-tweaks package-management ssh-server-dropbear hwcodecs weston dev-pkgs"

LICENSE = "MIT"

inherit core-image populate_sdk_qt6_base

IMAGE_INSTALL += " \
    libstdc++ \
    coreutils \
    mtd-utils \
    packagegroup-core-full-cmdline \
    packagegroup-core-buildessential \
    packagegroup-qt6-modules \
    gtk+3-demo \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
"

QB_MEM = "-m 512"
