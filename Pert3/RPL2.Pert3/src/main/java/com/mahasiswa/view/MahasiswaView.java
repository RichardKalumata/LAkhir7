package com.mahasiswa.view;

import com.mahasiswa.controller.MahasiswaController;
import com.mahasiswa.model.MahasiswaDAO;
import java.util.Scanner;

public class MahasiswaView {
    public static void main(String[] args) {
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaDAO);
        
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
        while(true){
            System.out.println("Menu: ");
            System.out.println("1. Tampilkan Seluruh mahasiswa");
            System.out.println("2. Tambahkan Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Cek Koneksi");
            System.out.println("6. Keluar");
            System.out.println("PILIH OPSI: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
        
        
        switch(pilihan){
            case 1:
                mahasiswaController.displayAllMahasiswa();
                break;
                
            case 2:
                System.out.println("Masukkan NPM: ");
                String NPM = scanner.next();
                System.out.println("Masukkan Nama: ");
                String nama = scanner.next();
                System.out.println("Masukkan Semester: ");
                int semester = scanner.nextInt();
                System.out.println("Masukkan IPK: ");
                float ipk = scanner.nextFloat();
                
                System.out.println(NPM + nama + semester + ipk);
                mahasiswaController.addMahasiswa(NPM, nama, semester, ipk);
                break;
                
            case 3:
                System.out.println("Masukkan Id Mahasiswa: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Masukkan NPM: ");
                String NPMBaru = scanner.next();
                System.out.println("Masukkan Nama: ");
                String namaBaru = scanner.next();
                System.out.println("Masukkan Semester: ");
                int semesterBaru = scanner.nextInt();
                System.out.println("Masukkan IPK: ");
                float ipkBaru = scanner.nextFloat();
                
                System.out.println(id + NPMBaru + namaBaru + semesterBaru + ipkBaru);
                mahasiswaController.updateMahasiswa(id, NPMBaru, namaBaru, semesterBaru, ipkBaru);
                break;
            
            case 4:
                System.out.println("Masukkan Id Mahasiswa: ");
                int idHapus = scanner.nextInt();
                mahasiswaController.deleteMahasiswa(idHapus);
                break;
                
            case 5:
                mahasiswaController.checkDatabaseConnection();
                break;
                
            case 6:
                mahasiswaController.closeConnection();
                System.out.println("Program Selesai");
                return;
                
            default:
                System.out.println(" Input tidak valid");
        }
        }
        
    }
}
