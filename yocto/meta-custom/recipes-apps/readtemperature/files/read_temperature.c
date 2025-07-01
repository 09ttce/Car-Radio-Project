#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    FILE *fp = fopen("/sys/bus/w1/devices/w1_bus_master1/w1_master_slaves", "r");
    if (!fp) {
        perror("Nie znaleziono urządzeń 1-Wire");
        return 1;
    }

    char sensor[32];
    fgets(sensor, sizeof(sensor), fp);
    fclose(fp);

    char path[128];
    snprintf(path, sizeof(path), "/sys/bus/w1/devices/%s/w1_slave", strtok(sensor, "\n"));

    fp = fopen(path, "r");
    if (!fp) {
        perror("Nie można otworzyć pliku czujnika");
        return 1;
    }

    char buf[256];
    fread(buf, 1, sizeof(buf), fp);
    fclose(fp);

    char *t_pos = strstr(buf, "t=");
    if (t_pos) {
        int temp_millic = atoi(t_pos + 2);
        float temp = temp_millic / 1000.0;
        printf("Temperatura: %.2f°C\n", temp);
    } else {
        printf("Nie udało się odczytać temperatury\n");
    }

    return 0;
}

