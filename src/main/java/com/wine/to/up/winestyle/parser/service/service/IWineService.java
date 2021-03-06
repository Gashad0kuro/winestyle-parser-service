package com.wine.to.up.winestyle.parser.service.service;

import com.wine.to.up.winestyle.parser.service.domain.entity.Wine;

import java.math.BigDecimal;
import java.util.List;

/**
 * Интерфейс для бизнес-логики для работы с вином.
 */
public interface IWineService {
    /**
     * Добавляет вино.
     * @param wine сущность вина.
     * @return сущность винас с id.
     */
    Wine add(Wine wine);

    /**
     * Получить вино по имени.
     * @param name название вина.
     * @return сущность вина.
     */
    Wine getWineByName(String name);

    /**
     * Получить вино по ссылке.
     * @param url ссылка на вино.
     * @return сущность вина.
     */
    Wine getWineByUrl(String url);

    /**
     * Обновить цену вина.
     * @param price  новая цена вина.
     * @param url  ссылка на вино.
     * @return измененную сущность вина.
     */
    Wine updatePrice(BigDecimal price, String url);

    /**
     * Обновить рейтинг вина.
     * @param rating новый рейтинг вина. 
     * @param url ссылка на вино.
     * @return измененную сущность вина.
     */
    Wine updateRating(Double rating, String url);

    /**
     * 
     * @return Список всех вин.
     */
    List<Wine> getAllWines();
}
