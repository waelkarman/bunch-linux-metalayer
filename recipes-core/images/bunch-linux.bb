SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image

DISTRO_FEATURES:append = " wayland systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""

CORE_IMAGE_EXTRA_INSTALL += "wayland weston"

IMAGE_FEATURES += "splash dev-pkgs debug-tweaks package-management ssh-server-dropbear"

IMAGE_INSTALL:append = "helloworld helloworldqt nano smart-house"