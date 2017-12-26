package ua.kpi.tef.entities;

import ua.kpi.tef.dao.Identified;

import java.time.LocalDate;
import java.util.Date;

public class Request implements Identified<Integer> {
    private Integer id;
    private Client client;
    private int clientId;
    private Date startDate;
    private Date endDate;
    private int hoursAmount;
    private Machine machine;
    private int idMachine;

    public Request() {
    }

    public Request(Client client, Date startDate, Date endDate,
                   int hoursAmount, Machine machine) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hoursAmount = hoursAmount;
        this.machine = machine;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getHoursAmount() {
        return hoursAmount;
    }

    public void setHoursAmount(int hoursAmount) {
        this.hoursAmount = hoursAmount;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public int getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(int idMachine) {
        this.idMachine = idMachine;
    }
}
