# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://git@github.com/waelkarman/networkchecker-service.git;user=waelkarman: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;protocol=ssh;branch=master"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "3c6dd0aec295135ae365243eb7b55e55c3d79e2b"

S = "${WORKDIR}/git"

RDEPENDS:${PN} += "python3-pyzmq python3"

do_install:append() {
	install -Dm644 ${S}/publisher4PWM.py ${D}/${bindir}/publisher4PWM.py
}


python do_display_banner() {
    bb.plain("*  Install networkchecker-service ............    *");
}

addtask display_banner after do_install