package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockAPI {
	
	private static List<Stock> stockList;
    private static StockAPI instance;
    
    private StockAPI() {}

    public static StockAPI getInstance() {
        if (instance == null) {
            synchronized (StockAPI.class) {
                if (instance == null) {
                    instance = new StockAPI();
                }
            }
        }
        return instance;
    }
    
    synchronized public static List<Stock> getStockList() {
        if(stockList == null) {
            stockList = new ArrayList<>();
        }

        return stockList;
    }

    public void demo() {
        String[] tcsBids = {"31.0", "35.0", "39.0", "45.0", "51.0", "59.0"};
        Stock tcs = TCS.getInstance();
        tcs.setName("TCS");
        tcs.setDescription("TCS Stock");
        System.out.println("TCS Bids:");
        for (String bid : tcsBids) {
            tcs.setBid(bid);
            System.out.printf("Bid: %s, Price: %.2f, Metric: %d%n", bid, tcs.getPrice(), tcs.getMetric());
        }
        
        System.out.println();

        String[] nvBids = {"21.0", "22.0", "23.0", "24.0", "25.0", "32.0"};
        Stock nv = Nvidia.getInstance();
        nv.setName("Nvidia");
        nv.setDescription("Nvidia Stock.");
        System.out.println("Nvidia Bids:");
        for (String bid : nvBids) {
            nv.setBid(bid);
            System.out.printf("Bid: %s, Price: %.2f, Metric: %d%n", bid, nv.getPrice(), nv.getMetric());
        }
        
        getStockList().add(nv);
        getStockList().add(tcs);
        System.out.println();
        System.out.println("Stock list: "+ getStockList());
    }
}
