SECTION = "kernel"
DESCRIPTION = "Sunplus Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
COMPATIBLE_MACHINE = "(sp7021)"

inherit kernel
require linux.inc

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "master"

DEPENDS += "rsync-native"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

#KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

PV = "4.19.37"
PR = "r1"
S = "${WORKDIR}/git"

# local test
#S = "${WORKDIR}/linux-sp"
#SRC_URI[md5sum] = "c82681d3d6a2cb74b785466d983a6acd"
#SRC_URI[sha256sum] = "5175e47af246a37ab51ddcb5abf95406a66e74fb9df9075cdc6b2d8ad2399adc"
#SRC_URI = "ftp://dangku:123456@localhost/linux-sp.tar.xz"

SRCREV = "eb071d79590a5895204d2a267fdf990cb521cb68"
SRC_URI = "git://github.com/Dangku/linux-sp.git;branch=master"

FILES_${KERNEL_PACKAGE_NAME}-base_append = " ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"
