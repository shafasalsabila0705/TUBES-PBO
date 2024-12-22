package main;

import services.EventService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/eventunand_pbo";
        String user = "root";  
        String password = "";  

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {

            EventService eventService = new EventService(connection);  // Pass connection to EventService
            int choice;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Event");
                System.out.println("2. Tampilkan Event");
                System.out.println("3. Update Event");
                System.out.println("4. Hapus Event");
                System.out.println("5. Keluar");
                System.out.print("Pilih: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        eventService.tambahEvent(scanner);
                        break;
                    case 2:
                        eventService.tampilkanEvent();
                        break;
                    case 3:
                        eventService.updateEvent(scanner);
                        break;
                    case 4:
                        eventService.hapusEvent(scanner);
                        break;
                    case 5:
                        System.out.println("Keluar dari program.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } while (choice != 5);

        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
