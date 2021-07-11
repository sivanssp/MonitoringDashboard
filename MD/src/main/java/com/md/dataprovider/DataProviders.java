/**
 * 
 */
package com.md.dataprovider;

import org.testng.annotations.DataProvider;

import com.md.utility.NewExcelLibrary;

/**
 * @author Test
 *
 */
public class DataProviders {
	NewExcelLibrary obj_excellib= new NewExcelLibrary();
	
	@DataProvider(name = "LoginData")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj_excellib.getRowCount("LoginData");
		// Total Columns
		int column = obj_excellib.getColumnCount("LoginData");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj_excellib.getCellData("LoginData", j, i + 2);
			}
		}
		return data;
	}


}
