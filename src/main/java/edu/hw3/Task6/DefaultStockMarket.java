package edu.hw3.Task6;

import java.util.PriorityQueue;

public class DefaultStockMarket implements StockMarket {
    private final PriorityQueue<Stock> stockQueue = new PriorityQueue<>();

    @Override
    public void add(Stock stock) {
        stockQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        if (stockQueue.isEmpty()) {
            throw new RuntimeException("Incorrect query: stockQueue is null");
        }

        return stockQueue.peek();
    }
}
