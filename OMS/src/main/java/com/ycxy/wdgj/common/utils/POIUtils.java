/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.dto.TradeOrderDto;

/**
 * @since 2018年3月7日 下午4:11:29
 * @author hjl
 *
 */
public class POIUtils {
    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK) - 1);
    }

    public static List<TradeOrderDto> readExcel(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            throw new OmsException("文件目录不存在请稍后重试");
        }
        Workbook workBook = null;
        if (path.endsWith(".xls")) {
            workBook = new HSSFWorkbook(new FileInputStream(file));
        } else if (path.endsWith(".xlsx")) {
            workBook = new XSSFWorkbook();
        } else {
            throw new OmsException("文件格式错误");
        }
        Iterator<Sheet> iterator = workBook.iterator();
        while (iterator.hasNext()) {
            Sheet sheet = iterator.next();
            for (int i = 0, j = sheet.getLastRowNum(); i <= j; i++) {
                Row row = sheet.getRow(i);
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    System.out.print(row.getCell(k));
                }
                System.out.println();
            }
        }
        return null;
    }

    public static void writeExcel(List<TradeOrderDto> tradeOrderDtoList, String path) throws OmsException {
        File file = new File(path);
        Workbook workBook = null;
        if (path.endsWith(".xls")) {
            workBook = new HSSFWorkbook();
        } else if (path.endsWith(".xlsx")) {
            workBook = new XSSFWorkbook();
        } else {
            throw new OmsException("文件格式错误");
        }
        Sheet sheet = null;
        for (int i = 0; i < tradeOrderDtoList.size(); i++) {
            if (i % 20 == 0) {
                sheet = workBook.createSheet();
            }
            Row row = null;
            for (int j = 0; j < 20; j++) {
                row = sheet.createRow(j);
                // TODO 给每一列赋值
            }
        }
    }
}
