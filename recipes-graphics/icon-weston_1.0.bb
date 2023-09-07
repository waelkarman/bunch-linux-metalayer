SUMMARY = "configure weston env"
LICENSE = "CLOSED"

#FILESEXTRAPATHS:prepend := "${THISDIR}:"
DEPENDS += "weston weston-init"
SRC_URI += "file://gear.png \
            file://terminal.png \
            "

FILES:${PN} = "/usr \
  /usr/share \
  /usr/share/icons \
  /usr/share/icons/hicolor \
  /usr/share/icons/hicolor/24x24 \
  /usr/share/icons/hicolor/24x24/gear.png \
  "

do_install:append() {
    install -d ${D}/usr/share/icons/hicolor/24x24
    install -Dm 644 ${WORKDIR}/gear.png ${D}/usr/share/icons/hicolor/24x24/gear.png
    install -Dm 644 ${WORKDIR}/gear.png ${D}/usr/share/icons/hicolor/24x24/terminal.png
}
