package com.example.tugasakhir2;

import java.util.ArrayList;

public class ModelLaundry {
    private final String nama;
    private final String kaos;
    private final String jeans;
    private final String jaket;
    private final String bedcover;
    private final String total;

    public ModelLaundry(String nama,String kaos,String jeans, String jaket, String bedcover, String total){
        this.nama = nama;
        this.kaos = kaos;
        this.jeans = jeans;
        this.jaket = jaket;
        this.bedcover = bedcover;
        this.total = total;
    }

    public String getNama() {
        return nama;
    }

    public String getKaos() {
        return kaos;
    }

    public String getJeans() {
        return jeans;
    }

    public String getJaket() {
        return jaket;
    }

    public String getBedcover() {
        return bedcover;
    }

    public String getTotal() {
        return total;
    }

}
