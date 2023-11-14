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

SRC_URI = "git://github.com/waelkarman/sensors-app.git;user=waelkarman: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;protocol=https;branch=ipc-integration"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "a4cce20747f452ac05af72a7e963565d5edab981"

S = "${WORKDIR}/git"

DEPENDS = " weston-init qtwayland zmqpp cppzmq zeromq"

inherit qmake5

do_install:append() {
    chown weston:weston ${D}/usr/bin/helloworldqml
}

python do_display_banner() {
    bb.plain("*  Install sensors-app ............    *");
}

addtask display_banner after do_install
