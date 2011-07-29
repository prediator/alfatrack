/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.domain;

/**
 *
 * @author elias
 */
public class BusApplication {
    private int id;
    private int minSpeed;
    private int busLoad;

    public BusApplication(int id, int minSpeed, int busLoad) {
        this.minSpeed = minSpeed;
        this.busLoad = busLoad;
    }

    public int getBusLoad() {
        return busLoad;
    }

    public void setBusLoad(int busLoad) {
        this.busLoad = busLoad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    @Override
    public String toString() {
        return "BusApplication{" + "id=" + id + ", minSpeed=" + minSpeed + ", busLoad=" + busLoad + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BusApplication other = (BusApplication) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.minSpeed != other.minSpeed) {
            return false;
        }
        if (this.busLoad != other.busLoad) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.minSpeed;
        return hash;
    }
   
}
