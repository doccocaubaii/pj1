package edu.hust.project1.dto;

public class XeDTO {
    private Integer id;
    private String name;
    private Integer price;
    private String bienSo;
    private Integer idDaiLy;
    private Boolean status;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBienSo() {
        return this.bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public Integer getIdDaiLy() {
        return this.idDaiLy;
    }

    public void setIdDaiLy(Integer idDaiLy) {
        this.idDaiLy = idDaiLy;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
