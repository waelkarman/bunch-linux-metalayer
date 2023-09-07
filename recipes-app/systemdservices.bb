SUMMARY = "Systemd service for sensors and info collector"
LICENSE = "CLOSED"

RDEPENDS:${PN} = " zmqread networkchecker-service"

inherit systemd

#FILES:${PN} += "${systemd_system_unitdir}/systemdservices.service"

SRC_URI = "\
    file://buttonreaderservices.service \
    file://networkcheckerservice.service \
"

do_install() {
    install -Dm 644 ${WORKDIR}/buttonreaderservices.service ${D}${systemd_system_unitdir}/buttonreaderservices.service
    install -Dm 644 ${WORKDIR}/networkcheckerservice.service ${D}${systemd_system_unitdir}/networkcheckerservice.service
}

SYSTEMD_SERVICE:${PN} = "buttonreaderservices.service \
                        networkcheckerservice.service\
                        "
SYSTEMD_AUTO_ENABLE = "enable"
