package entities;

import java.util.Date;

public class Event {
    private int id;
    private String namaEvent;
    private Date tanggalEvent;

    public Event(int id, String namaEvent, Date tanggalEvent) {
        this.id = id;
        this.namaEvent = namaEvent;
        this.tanggalEvent = tanggalEvent;
    }

    public int getId() {
        return id;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public Date getTanggalEvent() {
        return tanggalEvent;
    }

    @Override
    public String toString() {
        return "Event ID: " + id + ", Nama Event: " + namaEvent + ", Tanggal Event: " + tanggalEvent;
    }
}
