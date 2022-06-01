package com.microsservice.shoppingapi.repository.impl;

import com.microsservice.shoppingapi.model.Shop;
import com.microsservice.shoppingapi.model.dto.ShopReportDTO;
import com.microsservice.shoppingapi.repository.ReportRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, BigDecimal valorMinimo) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select s ");
        stringBuilder.append("from shop s ");
        stringBuilder.append("where s.date >= :dataInicio ");

        if (dataFim != null) {
            stringBuilder.append("and s.date <= :dataFim");
        }

        if (valorMinimo != null) {
            stringBuilder.append("and s.total <= :valorMinimo");
        }

        Query query = entityManager.createQuery(stringBuilder.toString());
        query.setParameter("dataInicio", dataInicio);

        if (dataFim != null) {
            query.setParameter("dataFim", dataFim);
        }
        if (valorMinimo != null) {
            query.setParameter("valorMinimo", valorMinimo);
        }

        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        return null;
    }
}
