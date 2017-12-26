package ua.kpi.tef.entities;

import ua.kpi.tef.dao.Identified;

public class MachineType implements Identified<Integer>{
    private Integer id;
    private String name;

    public MachineType() {
    }

    public MachineType(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MachineTypes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
