package pojos;
// Generated Jul 23, 2020 10:20:11 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hoinghi generated by hbm2java
 */
public class Hoinghi  implements java.io.Serializable {


     private Integer ma;
     private Diadiem diadiem;
     private Taikhoan taikhoan;
     private String ten;
     private String motangangon;
     private String motachitiet;
     private Integer soluongyeucau;
     private String hinhanh;
     private Date thoigiantochuc;
     private Integer dsnguoithamgia;
     private Integer dsnguoidangky;
     private Integer dsnguoiquantam;
     private Set thamgiahoinghis = new HashSet(0);

    public Hoinghi() {
    }

	
    public Hoinghi(Taikhoan taikhoan, String ten) {
        this.taikhoan = taikhoan;
        this.ten = ten;
    }
    public Hoinghi(Diadiem diadiem, Taikhoan taikhoan, String ten, String motangangon, String motachitiet, Integer soluongyeucau, String hinhanh, Date thoigiantochuc, Integer dsnguoithamgia, Integer dsnguoidangky, Integer dsnguoiquantam, Set thamgiahoinghis) {
       this.diadiem = diadiem;
       this.taikhoan = taikhoan;
       this.ten = ten;
       this.motangangon = motangangon;
       this.motachitiet = motachitiet;
       this.soluongyeucau = soluongyeucau;
       this.hinhanh = hinhanh;
       this.thoigiantochuc = thoigiantochuc;
       this.dsnguoithamgia = dsnguoithamgia;
       this.dsnguoidangky = dsnguoidangky;
       this.dsnguoiquantam = dsnguoiquantam;
       this.thamgiahoinghis = thamgiahoinghis;
    }
   
    public Integer getMa() {
        return this.ma;
    }
    
    public void setMa(Integer ma) {
        this.ma = ma;
    }
    public Diadiem getDiadiem() {
        return this.diadiem;
    }
    
    public void setDiadiem(Diadiem diadiem) {
        this.diadiem = diadiem;
    }
    public Taikhoan getTaikhoan() {
        return this.taikhoan;
    }
    
    public void setTaikhoan(Taikhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
    public String getTen() {
        return this.ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getMotangangon() {
        return this.motangangon;
    }
    
    public void setMotangangon(String motangangon) {
        this.motangangon = motangangon;
    }
    public String getMotachitiet() {
        return this.motachitiet;
    }
    
    public void setMotachitiet(String motachitiet) {
        this.motachitiet = motachitiet;
    }
    public Integer getSoluongyeucau() {
        return this.soluongyeucau;
    }
    
    public void setSoluongyeucau(Integer soluongyeucau) {
        this.soluongyeucau = soluongyeucau;
    }
    public String getHinhanh() {
        return this.hinhanh;
    }
    
    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
    public Date getThoigiantochuc() {
        return this.thoigiantochuc;
    }
    
    public void setThoigiantochuc(Date thoigiantochuc) {
        this.thoigiantochuc = thoigiantochuc;
    }
    public Integer getDsnguoithamgia() {
        return this.dsnguoithamgia;
    }
    
    public void setDsnguoithamgia(Integer dsnguoithamgia) {
        this.dsnguoithamgia = dsnguoithamgia;
    }
    public Integer getDsnguoidangky() {
        return this.dsnguoidangky;
    }
    
    public void setDsnguoidangky(Integer dsnguoidangky) {
        this.dsnguoidangky = dsnguoidangky;
    }
    public Integer getDsnguoiquantam() {
        return this.dsnguoiquantam;
    }
    
    public void setDsnguoiquantam(Integer dsnguoiquantam) {
        this.dsnguoiquantam = dsnguoiquantam;
    }
    public Set getThamgiahoinghis() {
        return this.thamgiahoinghis;
    }
    
    public void setThamgiahoinghis(Set thamgiahoinghis) {
        this.thamgiahoinghis = thamgiahoinghis;
    }

    @Override
    public String toString() {
        return ten; //To change body of generated methods, choose Tools | Templates.
    }


    


}


