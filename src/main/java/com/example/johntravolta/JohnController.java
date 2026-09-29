package com.example.johntravolta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JohnController {

    @GetMapping(value = "/john", produces = "text/plain")
    public String hitungGaji(
            @RequestParam double jamKerja,
            @RequestParam double rate,
            @RequestParam double pengeluaran) {

        double gaji;
        double jamNormal = 40;
        double rateLembur = rate * 1.5;

        if (jamKerja <= jamNormal) {
            gaji = jamKerja * rate;
        } else {
            double jamLembur = jamKerja - jamNormal;
            gaji = (jamNormal * rate) + (jamLembur * rateLembur);
        }

        double tabungan = gaji - pengeluaran;

        String hasil = "GAJI MR. JOHN TRAVOLTA\n";
        hasil += "Jam kerja    : " + jamKerja + " jam\n";
        hasil += "Rate normal  : Rp" + rate + "\n";
        hasil += "Pengeluaran  : Rp" + pengeluaran + "\n";
        hasil += "Gaji         : Rp" + gaji + "\n\n";

        if (tabungan > 0) {
            hasil += "Keterangan   : bisa menabung\n";
            hasil += "Tabungan     : Rp" + tabungan;
        } else if (tabungan == 0) {
            hasil += "Keterangan   : tidak bisa menabung";
        } else {
            hasil += "Keterangan   : cari tambahan\n";
            hasil += "Kekurangan   : Rp" + Math.abs(tabungan);
        }

        return hasil;
    }
}