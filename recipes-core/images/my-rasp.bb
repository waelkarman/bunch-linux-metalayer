SUMMARY = "A very basic Wayland image with a terminal"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "splash dev-pkgs debug-tweaks package-management ssh-server-dropbear"

IMAGE_INSTALL:append = "helloworld helloworldqt"