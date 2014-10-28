/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;
/**
 *
 * @author Tomas
 */
@CsvDataType()
public class SensorData implements Serializable{
    @CsvField(pos = 1)
    private double x;
    @CsvField(pos = 2)
    private double y;
    @CsvField(pos = 3)
    private double z;
    @CsvField(pos = 4)
    private long timestamp;
    @CsvField(pos = 5)
    private long runId;
    @CsvField(pos = 6)
    private long id;

    /**
     *
     */
    public SensorData() {
    }

    /**
     *
     * @param x
     * @param y
     * @param z
     * @param timestamp
     * @param runId
     * @param id
     */
    public SensorData(double x, double y, double z, long timestamp, long runId, long id) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.timestamp = timestamp;
        this.runId = runId;
        this.id = id;
    } 

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "SensorData{" + "x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ", timestamp=" + getTimestamp() + ", runId=" + getRunId() + ", id=" + getId() + '}';
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public double getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the runId
     */
    public long getRunId() {
        return runId;
    }

    /**
     * @param runId the runId to set
     */
    public void setRunId(long runId) {
        this.runId = runId;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
}
