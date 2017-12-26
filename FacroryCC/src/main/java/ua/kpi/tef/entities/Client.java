package ua.kpi.tef.entities;

import ua.kpi.tef.dao.Identified;

public class Client  implements Identified<Integer>{
    private Integer id;
    private String name;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
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
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
