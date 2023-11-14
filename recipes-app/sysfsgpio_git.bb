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

SRC_URI = "git://git@github.com/waelkarman/Raspberry-Pi-Sysfs-GPIO-C-Library.git;user=waelkarman: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;protocol=ssh;branch=master"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "0f6bf8f250730072ae9ecd2e97dcc41053e8699b"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""
FILES_SOLIBSDEV = ""
FILES:${PN} = "/usr/lib/libsysfsgpio.so"

do_install:append() {
    install -d ${D}${includedir}/
    cp -r ${S}/*.h ${D}${includedir}/
}

python do_display_banner() {
    bb.plain("*  Install sysfsgpio ............    *");
}

addtask display_banner after do_install