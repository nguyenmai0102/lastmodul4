package ra.model.serviceIpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;
import ra.repository.CatalogRepository;

import java.util.List;
@Service
public class CatalogServiceIpm implements CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;
    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(int catalogId) {
        return catalogRepository.findById(catalogId).get();
    }

    @Override
    public Catalog saveOrUpdate(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void delete(int catalogId) {
        catalogRepository.deleteById(catalogId);
    }

    @Override
    public List<Catalog> searchByName(String catalogName, int catalogId) {
        return catalogRepository.findByCatalogNameOrCatalogId(catalogName,catalogId);
    }
}
