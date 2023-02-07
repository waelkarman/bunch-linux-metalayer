SUMMARY = "BunchLinux is an embedded OS image where to integrate any possible software"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "splash dev-pkgs debug-tweaks package-management ssh-server-dropbear"

IMAGE_INSTALL:append = "helloworld helloworldqt nano"