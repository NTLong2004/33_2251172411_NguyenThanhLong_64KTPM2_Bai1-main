public class BoNho {
    private String loai;
    private int dungLuong;

    public BoNho(String loai, int dungLuong) {
        this.loai = loai;
        this.dungLuong = dungLuong;
    }

    public String getLoai() {
        return loai;
    }

    public int getDungLuong() {
        return dungLuong;
    }

    public void hienThiThongTin() {
        System.out.println("Loại bộ nhớ: " + loai);
        System.out.println("Dung lượng: " + dungLuong + " GB");
    }
}
