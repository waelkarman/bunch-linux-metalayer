SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image

DISTRO_FEATURES += "systemd wayland directfb opengl" 

IMAGE_FEATURES += "weston empty-root-password allow-empty-password allow-root-login ssh-server-dropbear tools-sdk dev-pkgs debug-tweaks package-management hwcodecs"

IMAGE_INSTALL += "nano helloworld helloworldqt helloworldqml hello-module env-config"