package services;

import java.sql.*;
import java.util.Scanner;

public class EventService {
    private Connection connection;

    public EventService(Connection connection) {
        this.connection = connection;
    }

    // Menambahkan Event
    public void tambahEvent(Scanner scanner) {
        try {
            System.out.print("Masukkan ID Event: ");
            int idEvent = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Masukkan Nama Event: ");
            String namaEvent = scanner.nextLine();
            System.out.print("Masukkan Tanggal Event (yyyy-MM-dd): ");
            String tanggalEvent = scanner.nextLine();
            System.out.print("Masukkan Lokasi Event: ");
            String lokasiEvent = scanner.nextLine();
            System.out.print("Masukkan Status Event (belum dimulai/aktif/selesai/dibatalkan): ");
            String statusEvent = scanner.nextLine();
            System.out.print("Masukkan Waktu Mulai Event (yyyy-MM-dd HH:mm:ss): ");
            String waktuMulai = scanner.nextLine();
            System.out.print("Masukkan Waktu Selesai Event (yyyy-MM-dd HH:mm:ss): ");
            String waktuSelesai = scanner.nextLine();
            System.out.print("Masukkan Penyelenggara Event: ");
            String penyelenggaraEvent = scanner.nextLine();

            String query = "INSERT INTO event (id, nama_event, tanggal_event, lokasi_event, status_event, waktu_mulai, waktu_selesai, penyelenggara_event) "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, idEvent);
                stmt.setString(2, namaEvent);
                stmt.setString(3, tanggalEvent);
                stmt.setString(4, lokasiEvent);
                stmt.setString(5, statusEvent);
                stmt.setString(6, waktuMulai);
                stmt.setString(7, waktuSelesai);
                stmt.setString(8, penyelenggaraEvent);
                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Event berhasil ditambahkan!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Menampilkan Event
    public void tampilkanEvent() {
        try {
            String query = "SELECT * FROM event";
            try (Statement stmt = connection.createStatement();
                 ResultSet resultSet = stmt.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String namaEvent = resultSet.getString("nama_event");
                    Date tanggalEvent = resultSet.getDate("tanggal_event");
                    String lokasiEvent = resultSet.getString("lokasi_event");
                    String statusEvent = resultSet.getString("status_event");
                    Timestamp waktuMulai = resultSet.getTimestamp("waktu_mulai");
                    Timestamp waktuSelesai = resultSet.getTimestamp("waktu_selesai");
                    String penyelenggaraEvent = resultSet.getString("penyelenggara_event");

                    System.out.println("ID: " + id + ", Nama Event: " + namaEvent + ", Tanggal: " + tanggalEvent + ", Lokasi: " + lokasiEvent +
                                       ", Status: " + statusEvent + ", Waktu Mulai: " + waktuMulai + ", Waktu Selesai: " + waktuSelesai +
                                       ", Penyelenggara: " + penyelenggaraEvent);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Mengupdate Event
    public void updateEvent(Scanner scanner) {
        try {
            System.out.print("Masukkan ID Event yang akan diubah: ");
            int idEvent = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Masukkan Nama Event Baru: ");
            String namaEvent = scanner.nextLine();
            System.out.print("Masukkan Tanggal Event Baru (yyyy-MM-dd): ");
            String tanggalEvent = scanner.nextLine();
            System.out.print("Masukkan Lokasi Event Baru: ");
            String lokasiEvent = scanner.nextLine();
            System.out.print("Masukkan Status Event Baru (belum dimulai/aktif/selesai/dibatalkan): ");
            String statusEvent = scanner.nextLine();
            System.out.print("Masukkan Waktu Mulai Event Baru (yyyy-MM-dd HH:mm:ss): ");
            String waktuMulai = scanner.nextLine();
            System.out.print("Masukkan Waktu Selesai Event Baru (yyyy-MM-dd HH:mm:ss): ");
            String waktuSelesai = scanner.nextLine();
            System.out.print("Masukkan Penyelenggara Event Baru: ");
            String penyelenggaraEvent = scanner.nextLine();

            String query = "UPDATE event SET nama_event = ?, tanggal_event = ?, lokasi_event = ?, status_event = ?, "
                         + "waktu_mulai = ?, waktu_selesai = ?, penyelenggara_event = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, namaEvent);
                stmt.setString(2, tanggalEvent);
                stmt.setString(3, lokasiEvent);
                stmt.setString(4, statusEvent);
                stmt.setString(5, waktuMulai);
                stmt.setString(6, waktuSelesai);
                stmt.setString(7, penyelenggaraEvent);
                stmt.setInt(8, idEvent);
                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Event berhasil diperbarui!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Menghapus Event
    public void hapusEvent(Scanner scanner) {
        try {
            System.out.print("Masukkan ID Event yang akan dihapus: ");
            int idEvent = scanner.nextInt();

            String query = "DELETE FROM event WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, idEvent);
                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Event berhasil dihapus!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
