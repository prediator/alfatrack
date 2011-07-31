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
    private Long id;
    private int minSpeed;
    private int minBusLoad;
    private boolean isdone;
    private Long userId;

    public BusApplication(int minSpeed, int minBusLoad, boolean isdone, Long userId) {
        this.minSpeed = minSpeed;
        this.minBusLoad = minBusLoad;
        this.isdone = isdone;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    public int getMinBusLoad() {
        return minBusLoad;
    }

    public void setMinBusLoad(int minBusLoad) {
        this.minBusLoad = minBusLoad;
    }

    public boolean isIsdone() {
        return isdone;
    }

    public void setIsdone(boolean isdone) {
        this.isdone = isdone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BusApplication{" + "id=" + id + ", minSpeed=" + minSpeed + ", minBusLoad=" + minBusLoad + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusApplication that = (BusApplication) o;

        if (isdone != that.isdone) return false;
        if (minBusLoad != that.minBusLoad) return false;
        if (minSpeed != that.minSpeed) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = minSpeed;
        result = 31 * result + minBusLoad;
        result = 31 * result + (isdone ? 1 : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
