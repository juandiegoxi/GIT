package Excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {

    // permitir leer el valor expecifico de una celda
    public String getCellValue(String sheetName,String filepath,int rowNumber, int cellNumber) throws IOException {
        //El camino donde va estar el fichero
        File file = new File(filepath);
        //Leer los datos del archivo
        FileInputStream inputStream = new FileInputStream(file);
        //Donde se guarda el libro de excel, el fichero como tal. el inputStream el archivo de los datos
        XSSFWorkbook newWorbook =new XSSFWorkbook(inputStream);
        //El objeto donde se guarda la hoja donde se trabaja
        XSSFSheet newSheet = newWorbook.getSheet(sheetName);
        //La informacion de una celda expecifica, el numero que estamos pasando Columna
        XSSFRow row = newSheet.getRow(rowNumber);
        //El numero que estamos pasando Numero
        XSSFCell cell = row.getCell(cellNumber);
        //Devolvemos la informacion
        return cell.getStringCellValue();
    }

}