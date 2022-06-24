package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;

public class ChartService {
	
	CSVRepository cryptoDataCSVRepository;
	
	public ChartService(CSVRepository cryptoDataCSVRepository) {
		this.cryptoDataCSVRepository = cryptoDataCSVRepository;
	}
	
	List<Candle> candles;
	
	public CandleStickChart createChartFromCryptoData() {
		CandleStickChart candlestickchart = new CandleStickChart("BTC/USDT Chart");
		
		try {
			 candles = this.cryptoDataCSVRepository.readCSV( "Binance_BTCUSDT_d.csv");
		}
		catch(Exception e) {			
		}
		
		//read data and send to addCandle method
		for (Candle candle : candles) {
			candlestickchart.addCandle(candle.getTime(),
					candle.getOpen(),
					candle.getHigh(),
					candle.getLow(),
					candle.getClose(),
					candle.getVolume());
			System.out.println(candles);
		}
		
		return candlestickchart;
	}

}
