package edu.neu.csye7374;

public class Nvidia extends Stock {
    private static Stock instance;
    private double bid;

    private Nvidia() {
    	
    }

    public static Stock getInstance() {
        if (instance == null) {
            synchronized (Nvidia.class) {
                if (instance == null) {
                    instance = new Nvidia();
                }
            }
        }
        return instance;
    }

    @Override
    public void setBid(String bid) {
        try {
            this.bid = Double.parseDouble(bid);
            setPrice(this.bid); 
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format");
        }
    }

    @Override
    public int getMetric() {
        return (int) this.bid + 5;
    }
}
