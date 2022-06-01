package com.microsservice.shoppingapi.repository;

import com.microsservice.shoppingapi.model.Shop;
import com.microsservice.shoppingapi.model.dto.ShopReportDTO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, BigDecimal valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}
