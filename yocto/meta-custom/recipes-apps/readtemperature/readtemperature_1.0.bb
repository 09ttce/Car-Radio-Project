SUMMARY = "Prosty program do odczytu temperatury z DS18B20"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://read_temperature.c"
S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} read_temperature.c -o read_temperature
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 read_temperature ${D}${bindir}
}

