
package model;


public class SanPham {
    private String maSP;
    private String tenSP;
    private LoaiSanPham loai; // Lấy dữ liệu của bảng 1 sang bảng nhiều

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, LoaiSanPham loai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loai = loai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public LoaiSanPham getLoai() {
        return loai;
    }

    public void setLoai(LoaiSanPham loai) {
        this.loai = loai;
    }
    
    public Object[] toDataRow(){
        return new Object[]{
            this.maSP,
            this.tenSP
        };
    }
}
