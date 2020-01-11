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

SRCREV = "${AUTOREV}"
PV = "4.19.37+git${SRCPV}"
PR = "r1"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/Dangku/linux-sp.git;branch=master"

FILES_${KERNEL_PACKAGE_NAME}-base_append = " ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"
