package pojos;
// Generated Jul 23, 2020 10:20:11 AM by Hibernate Tools 4.3.1



/**
 * Thamgiahoinghi generated by hbm2java
 */
public class Thamgiahoinghi  implements java.io.Serializable {


     private int ma;
     private Hoinghi hoinghi;
     private Taikhoan taikhoan;
     private String tinhtrang;
     private Integer quantam;
     private String ten;
     private String sdt;
     private String email;

    public Thamgiahoinghi() {
    }

	
    public Thamgiahoinghi(int ma) {
        this.ma = ma;
    }
    public Thamgiahoinghi(int ma, Hoinghi hoinghi, Taikhoan taikhoan, String tinhtrang, Integer quantam, String ten, String sdt, String email) {
       this.ma = ma;
       this.hoinghi = hoinghi;
       this.taikhoan = taikhoan;
       this.tinhtrang = tinhtrang;
       this.quantam = quantam;
       this.ten = ten;
       this.sdt = sdt;
       this.email = email;
    }
     public Thamgiahoinghi(  Hoinghi hoinghi, Taikhoan taikhoan, String tinhtrang , String ten, String sdt, String email) {
   
       this.hoinghi = hoinghi;
       this.taikhoan = taikhoan;
       this.tinhtrang = tinhtrang;
   
       this.ten = ten;
       this.sdt = sdt;
       this.email = email;
    }
   
    public int getMa() {
        return this.ma;
    }
    
    public void setMa(int ma) {
        this.ma = ma;
    }
    public Hoinghi getHoinghi() {
        return this.hoinghi;
    }
    
    public void setHoinghi(Hoinghi hoinghi) {
        this.hoinghi = hoinghi;
    }
    public Taikhoan getTaikhoan() {
        return this.taikhoan;
    }
    
    public void setTaikhoan(Taikhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
    public String getTinhtrang() {
        return this.tinhtrang;
    }
    
    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    public Integer getQuantam() {
        return this.quantam;
    }
    
    public void setQuantam(Integer quantam) {
        this.quantam = quantam;
    }
    public String getTen() {
        return this.ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getSdt() {
        return this.sdt;
    }
    
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


