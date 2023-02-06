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

SRC_URI = "git://git@github.com/waelkarman/helloworldqt.git;protocol=ssh;branch=master"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "2d7c28bd70eb0265045ca3d00332ab8e16016a49"

S = "${WORKDIR}/git"

DEPENDS = "qtbase"

inherit qmake5 

python do_display_banner() {
    bb.plain("*  Install Qt helloworld test application ............    *");
}

addtask display_banner before do_build
