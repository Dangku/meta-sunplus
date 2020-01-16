SOC_FAMILY ??= ""
include conf/machine/include/soc-family.inc

#xf86-video-fbturbo
XSERVER = "xserver-xorg \
           xf86-video-fbdev \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-input-keyboard"

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-sp"
PREFERRED_PROVIDER_u-boot ?= "u-boot-sp"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-sp"

KERNEL_IMAGETYPE ?= "uImage"

IMAGE_CLASSES += "sdcard_image-sunplus"
IMAGE_FSTYPES += "ext3 tar.gz sunplus-sdimg"

MACHINE_EXTRA_RRECOMMENDS = "kernel-modules"

UBOOT_ENTRYPOINT ?= "0x00308000"

SPL_BINARY="ISPBOOOT.BIN"
UBOOT_BINARY="u-boot.img"

SERIAL_CONSOLE ?= "115200 ttyS0"
MACHINE_FEATURES ?= "alsa apm keyboard rtc serial screen usbgadget usbhost vfat"
