# Default to (primary) SD
rootdev=mmcblk1p2
setenv bootargs console=${console} console=tty1 root=/dev/${rootdev} rootwait panic=10 ${extra}
load mmc 1:1 ${fdt_addr_r} ${fdtfile}
load mmc 1:1 ${kernel_addr_r} Image
booti ${kernel_addr_r} - ${fdt_addr_r}
