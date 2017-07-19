SUMMARY = "RTL8812AU kernel driver (wifi)"
DESCRIPTION = "RTL8812AU kernel driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Kconfig;md5=4b85004ff83dd932ff28f7f348fb2a28"

SRC_URI = "git://github.com/EmbeddedAndroid/rtl8812AU_8821AU_linux.git;protocol=https"
SRCREV = "e45578d34348a9f35cde6e56f163aa9311a318bf"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "dragonboard-410c"

PV = "1.0-git"

DEPENDS = "virtual/kernel"

inherit module

EXTRA_OEMAKE  = "ARCH=arm64"
EXTRA_OEMAKE += "KSRC=${STAGING_KERNEL_BUILDDIR}"

do_compile () {
    unset LDFLAGS
    oe_runmake
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}
    install -m 0755 ${B}/rtl8812au.ko ${D}/lib/modules/${KERNEL_VERSION}/rtl8812au.ko
}

