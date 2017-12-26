package ua.kpi.tef.entities;

import ua.kpi.tef.dao.Identified;

public class Machine implements Identified<Integer>{
    private Integer id;
    private MachineType type;
    private int typeId;
    private String name;
    private int price;

    public Machine() {
    }

    public Machine(MachineType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MachineType getType() {
        return type;
    }

    public void setType(MachineType type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", type=" + type +
                ", typeId=" + typeId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
