
package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;

public class LoaiSanPhamService {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<LoaiSanPham> getAll(){
        sql = "SELECT MALOAI, TENLOAI FROM LOAISANPHAM";
        List<LoaiSanPham> listLSP = new ArrayList();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(1), rs.getString(2));
                listLSP.add(lsp);
            }
            return listLSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
