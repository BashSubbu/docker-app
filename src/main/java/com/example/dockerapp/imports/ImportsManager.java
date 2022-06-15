package com.example.dockerapp.imports;

import com.example.dockerapp.exception.GeneralException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ImportsManager {

    /**
     * importProducts is used to import data from xl file
     * @param multipartFile
     * @return
     * @throws Exception
     */
    public List<String> importProducts(MultipartFile multipartFile)  {
        InputStream inputStream = null;
        List<String> digitalIdList = new ArrayList<>();
        String digitalId = null;
        DataFormatter dataFormatter = new DataFormatter();
        int cellNumber = 0;
        try {
            // converting file to buffered input stream
            if (multipartFile != null) {
                inputStream = new BufferedInputStream(multipartFile.getInputStream());
            }
            // getting fist sheet
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            // iterating over each row and cell
            Iterator<Row> rowIterator = firstSheet.iterator();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    digitalId = dataFormatter.formatCellValue(cell);
                    digitalIdList.add(digitalId);
                    cellNumber++;
                }
            }


        }catch (Exception exception){
            throw new GeneralException("import Product failed " + exception.getMessage());
        }

        return digitalIdList;
    }

}
