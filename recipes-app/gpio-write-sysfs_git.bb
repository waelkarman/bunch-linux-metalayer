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

SRC_URI = "git://git@github.com/waelkarman/gpio-write-sysfs.git;user=waelkarman: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;protocol=ssh;branch=master"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "0190c5690a97bb4c7d4fce320dee10f5cca23d99"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: sysfsgpio
inherit cmake

DEPENDS = "sysfsgpio"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

python do_display_banner() {
    bb.plain("*  Install gpio-write-sysfs ............    *");
}

addtask display_banner after do_install