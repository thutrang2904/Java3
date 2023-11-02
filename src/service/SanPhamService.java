
package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;
import model.SanPham;

public class SanPhamService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<SanPham> getAll(){
        sql = "SELECT MASANPHAM, TENSANPHAM, LOAISANPHAM.MALOAI, TENLOAI FROM SANPHAM JOIN LOAISANPHAM ON SANPHAM.MALOAI = LOAISANPHAM.MALOAI";
        List<SanPham> listSP = new ArrayList();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);
                
                // public SanPham(String maSP, String tenSP, LoaiSanPham loai)
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(3), rs.getString(4));
                SanPham sp = new SanPham(maSP, tenSP, lsp);
                listSP.add(sp);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<SanPham> getSPBYMaLoai(String maLoai){
        sql = "SELECT MASANPHAM, TENSANPHAM, LOAISANPHAM.MALOAI, TENLOAI FROM SANPHAM JOIN LOAISANPHAM ON SANPHAM.MALOAI = LOAISANPHAM.MALOAI WHERE LOAISANPHAM.MALOAI = ?";
        List<SanPham> listSP = new ArrayList();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maLoai);
            rs = ps.executeQuery();
            while(rs.next()){
                String maSP = rs.getString(1);
                String tenSP = rs.getString(2);
                
                // public SanPham(String maSP, String tenSP, LoaiSanPham loai)
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(3), rs.getString(4));
                SanPham sp = new SanPham(maSP, tenSP, lsp);
                listSP.add(sp);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
