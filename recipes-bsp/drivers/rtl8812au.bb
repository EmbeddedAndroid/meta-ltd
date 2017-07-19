SUMMARY = "RTL8812AU kernel driver (wifi + bluetooth)"
DESCRIPTION = "RTL8812AU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=e6402a1e8edc484c8a4cd7d18753fb5f"

SRC_URI = "git://github.com/gnab/rtl8812au.git;protocol=https"
SRCREV = "8de9cbf66acf46f259f8b6b4be1ac5142cd446ab"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "dragonboard-410c"

PV = "1.0-git"

DEPENDS = "virtual/kernel"

inherit module

EXTRA_OEMAKE  = "ARCH=arm64"
EXTRA_OEMAKE += "KSRC=${STAGING_KERNEL_BUILDDIR}"

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}
    install -m 0755 ${B}/8812au.ko ${D}/lib/modules/${KERNEL_VERSION}/8812au.ko
}

