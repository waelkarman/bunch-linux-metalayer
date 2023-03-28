SUMMARY = "configure weston env"
LICENSE = "CLOSED"

#FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += "file://environment"

do_install:append() {
    install -Dm755 ${WORKDIR}/environment ${D}/${sysconfdir}/environment
}