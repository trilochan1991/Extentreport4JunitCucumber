package iocucumber.base.filereader;

import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class ExcelReader {
	
	public static Map<String, String> getTestDatainMap(String excelfilename, String sheetname, String userstory)
	{
		try
		{
			String query = null;
			Fillo fillo = null;
			Connection connection = null;
			
			Map<String, String> map = new TreeMap<String, String>();
			query = String.format("Select * from %s where Flag='Y' and UserStory='%s'", sheetname, userstory );
			fillo = new Fillo();
			connection = fillo.getConnection(excelfilename);
			Recordset allrow = connection.executeQuery(query);
			
			while(allrow.next()){				
				for(String heaercolumnName : allrow.getFieldNames()){
					map.put(heaercolumnName, allrow.getField(heaercolumnName));
					
				}
			}			
			return map;
			
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
		
	}

}
