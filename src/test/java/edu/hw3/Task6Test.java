package edu.hw3;

import edu.hw3.Task6.DefaultStockMarket;
import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Add, add, mostValuable")
    public void test1() {
        StockMarket market = new DefaultStockMarket();
        market.add(new Stock(5, "Bitcoin"));
        market.add(new Stock(10, "GG"));
        assertThat(market.mostValuableStock()).isEqualTo(new Stock(10, "GG"));
    }

    @Test
    @DisplayName("Add the same twice, delete, then mostValuable")
    public void testAddTheSameThenDelete() {
        StockMarket market = new DefaultStockMarket();
        market.add(new Stock(5, "Bitcoin"));
        market.add(new Stock(5, "Bitcoin"));

        market.remove(new Stock(5, "Bitcoin"));

        assertThat(market.mostValuableStock()).isEqualTo(new Stock(5, "Bitcoin"));
    }
}
