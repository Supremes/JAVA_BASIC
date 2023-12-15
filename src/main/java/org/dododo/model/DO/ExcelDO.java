package org.dododo.model.DO;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson2.JSON;
import org.dododo.entity.EatingData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelDO {
    public static final Logger logger = LoggerFactory.getLogger(ExcelDO.class);
    public static void parseExcel(String fileName) {
        EasyExcel.read(fileName, EatingData.class, new PageReadListener<EatingData>(dataList -> {
            for (EatingData demoData : dataList) {
                logger.debug("读取到一条数据{}", JSON.toJSONString(demoData));
            }
        })).sheet().doRead();
    }
}
