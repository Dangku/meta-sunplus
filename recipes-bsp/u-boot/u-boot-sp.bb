DESCRIPTION = "U-Boot port for sunplus"

require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += " bc-native dtc-native swig-native python3-native flex-native bison-native "

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(sp7021)"
DEFAULT_PREFERENCE_sp7021="1"

SRCREV = "${AUTOREV}"
PV = "2019.04+git${SRCPV}"
PR = "r1"
S = "${WORKDIR}/git"

SRC_URI = " \
	git://github.com/Dangku/u-boot-sp.git;branch=master \
	file://boot.cmd \
	file://ISPBOOOT.BIN \
	"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
    cp ${WORKDIR}/${SPL_BINARY} ${B}
}
