package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.TimeUtils;

public class CryptoDataCSVRepository implements CSVRepository {
	
	private final String COMMA_DELIMITER = ",";

	@Override
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		
		// read BTC table from CSV and file fill in candles
		try {
			br.readLine();
			while ((line = br.readLine()) != null ) 
			{  
				String[] btcValues = line.split(COMMA_DELIMITER);
				Candle candle = new Candle(Long.parseLong(btcValues[0]), Double.parseDouble(btcValues[3]), Double.parseDouble(btcValues[4]), Double.parseDouble(btcValues[5]), Double.parseDouble(btcValues[6]), Double.parseDouble(btcValues[7]));
				candles.add(candle);
			}  				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		
		return candles;
	}

}
