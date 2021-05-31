package package2;


public class MENU{
	private String kode, nama, harga, stok;
	

	public MENU(String nama, String harga, String stok) {
		super();
		this.nama = nama;
		this.harga = harga;
		this.stok = stok;
	}

	public String getNama() {
		return nama;
	}

	public String getHarga() {
		return harga;
	}

	public String getStok() {
		return stok;
	}

	

}
