DESCRIPTION = "U-Boot port for sunplus"

require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += " bc-native dtc-native swig-native python3-native flex-native bison-native "

COMPATIBLE_MACHINE = "(sp7021)"
DEFAULT_PREFERENCE_sp7021="1"

# local test
#SRC_URI[md5sum] = "7ca5f301f1e0c8ede2789235ea734e78"
#SRC_URI[sha256sum] = "1451fc03ade8ca73e95d07cf050c380a728a4738128ed524d62ed27123053aba"
#ftp://dangku:123456@localhost/u-boot-sp.tar.xz
#S = "${WORKDIR}/u-boot-sp"

SRCREV = "0333ae5cb44a5e6bc651466be5168d4febcd2d1a"

SRC_URI = " \
	git://github.com/Dangku/u-boot-sp.git;branch=master \
	file://boot.cmd \
	file://ISPBOOOT.BIN \
	"

PV = "2019.04"
PR = "r1"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
    cp ${WORKDIR}/${SPL_BINARY} ${B}
}
