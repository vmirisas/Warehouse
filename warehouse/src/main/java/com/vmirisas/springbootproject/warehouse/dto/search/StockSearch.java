package com.vmirisas.springbootproject.warehouse.dto.search;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class StockSearch {

    private String barcode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

}
