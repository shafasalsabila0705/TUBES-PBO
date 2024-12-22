USE eventunand_pbo;

CREATE TABLE IF NOT EXISTS event(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama_event VARCHAR(100),
    tanggal_event DATE,
    lokasi_event VARCHAR(100),
    status_event ENUM('belum dimulai', 'aktif', 'selesai', 'dibatalkan'),
    waktu_mulai DATETIME,
    waktu_selesai DATETIME,
    penyelenggara_event VARCHAR(100)
);
