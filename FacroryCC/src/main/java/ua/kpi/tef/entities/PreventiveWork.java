package ua.kpi.tef.entities;

import ua.kpi.tef.dao.Identified;

import java.time.LocalDate;
import java.util.Date;

public class PreventiveWork implements Identified<Integer> {
    private Integer id;
    private PreventiveWorkType type;
    private Date date;
    private int hoursAmount;
    private Machine machine;
    private int machineID;

    public PreventiveWork() {
    }

    public PreventiveWork(PreventiveWorkType type, Date date, int hoursAmount, Machine machine) {
        this.type = type;
        this.date = date;
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

    public PreventiveWorkType getType() {
        return type;
    }

    public void setType(PreventiveWorkType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
