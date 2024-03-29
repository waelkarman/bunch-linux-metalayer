SUMMARY = "Systemd service for sensors and info collector"
LICENSE = "CLOSED"

RDEPENDS:${PN} = " gpio-read-sysfs-service networkchecker-service passivebuzzer-service "

inherit systemd

SRC_URI = "\
    file://buttonreaderservices.service \
    file://networkcheckerservice.service \
    file://passivebuzzerservice.service \
"

do_install() {
    install -Dm 644 ${WORKDIR}/buttonreaderservices.service ${D}${systemd_system_unitdir}/buttonreaderservices.service
    install -Dm 644 ${WORKDIR}/networkcheckerservice.service ${D}${systemd_system_unitdir}/networkcheckerservice.service
    install -Dm 644 ${WORKDIR}/passivebuzzerservice.service ${D}${systemd_system_unitdir}/passivebuzzerservice.service
}

SYSTEMD_SERVICE:${PN} = "buttonreaderservices.service \
                        networkcheckerservice.service \
                        passivebuzzerservice.service \
                        "
SYSTEMD_AUTO_ENABLE = "enable"


python do_display_banner() {
    bb.plain("*  Install systemd services ............    *");
}

addtask display_banner after do_install