SUMMARY = "configure weston env"
LICENSE = "CLOSED"

#FILESEXTRAPATHS:prepend := "${THISDIR}:"
DEPENDS += "weston weston-init"
SRC_URI += "file://gear.png \
            file://terminal1.png \
            file://folder.png \
            "

FILES:${PN} = "/usr \
  /usr/share \
  /usr/share/icons \
  /usr/share/icons/weston \
  "

do_install:append() {
    install -Dm 644 ${WORKDIR}/gear.png ${D}/usr/share/weston/gear.png
    install -Dm 644 ${WORKDIR}/terminal1.png ${D}/usr/share/weston/terminal1.png
    install -Dm 644 ${WORKDIR}/folder.png ${D}/usr/share/weston/folder.png
}
