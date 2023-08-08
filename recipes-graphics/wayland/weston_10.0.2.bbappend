FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

do_patch() {
    cp ${WORKDIR}/background.png ${S}/data/

    cd ${S}
    patch -p1 < ${WORKDIR}/0001-add-desktop-wallpaper.patch
}

SRC_URI += "file://0001-add-desktop-wallpaper.patch \
            file://background.png \
            "

