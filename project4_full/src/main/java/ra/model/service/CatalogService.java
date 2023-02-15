package ra.model.service;

import ra.model.entity.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> findAll();
    Catalog findById(int catalogId);

    Catalog saveOrUpdate(Catalog catalog);

    void delete(int catalogId);

    List<Catalog> searchByName(String catalogName, int catalogId);
}
