/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.domain.bus;

/**
 *
 * @author elias
 */
public class Bus {
    private int id;
    private int busload;
    private int maxSpeed;
    private boolean workingOrder;

    //only for dispatcher's bus
    public Bus(){
        this.busload = 0;
        this.maxSpeed = 0;
        this.workingOrder = false;
    }
    
    public Bus(int id, int busload,
            int maxSpeed, boolean workingOrder) {
        this.id = id;
        this.busload = busload;
        this.maxSpeed = maxSpeed;
        this.workingOrder = workingOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getBusload() {
        return busload;
    }

    public void setBusload(int busload) {
        this.busload = busload;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isWorkingOrder() {
        return workingOrder;
    }

    public void setWorkingOrder(boolean workingOrder) {
        this.workingOrder = workingOrder;
    }
      @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bus other = (Bus) obj;
        if (this.busload != other.busload) {
            return false;
        }
        if (this.maxSpeed != other.maxSpeed) {
            return false;
        }
        if (this.workingOrder != other.workingOrder) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.busload;
        hash = 47 * hash + this.maxSpeed;
        hash = 47 * hash + (this.workingOrder ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Bus{" + "busload=" + busload + ", maxSpeed=" + maxSpeed + ", workingOrder=" + workingOrder + '}';
    }

}