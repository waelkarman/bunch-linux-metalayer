inherit bundle

RAUC_KEY_FILE_PREFIX = "${THISDIR}/files/"
RAUC_CERT_NAME_PREFIX ?= "development-1"


RAUC_BUNDLE_COMPATIBLE = "bunch-linux-image"
RAUC_BUNDLE_DESCRIPTION = "Bunch Linux SYSTEM RAUC UPDATE"

LICENSE = "CLOSED"

RAUC_BUNDLE_SLOTS ?= "rootfs"

RAUC_SLOT_rootfs = "bunch-linux-image"
#RAUC_SLOT_rootfs[type] = "image"
#RAUC_SLOT_rootfs[fstype] = "tar"

RAUC_KEY_FILE  = "/${RAUC_KEY_FILE_PREFIX}/${RAUC_CERT_NAME_PREFIX}.key.pem"
RAUC_CERT_FILE = "/${RAUC_KEY_FILE_PREFIX}/${RAUC_CERT_NAME_PREFIX}.cert.pem"
