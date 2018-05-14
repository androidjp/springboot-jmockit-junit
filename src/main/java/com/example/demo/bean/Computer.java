package com.example.demo.bean;

/**
 * User: androidjp
 * Date: 2018/5/12
 * Time: 下午3:56
 * Description:
 */
public class Computer implements Cloneable {
    private String cpu;
    private String gpu;
    private int memory;
    private double price;


    public Computer(String cpu, String gpu, int memory, double price) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.memory = memory;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public Computer clone() throws CloneNotSupportedException {
        return (Computer) super.clone();
    }
}
