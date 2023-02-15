package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    public CatalogController() {
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Catalog> getAllCatalog(){
        return catalogService.findAll();
    }
    @GetMapping("/{catalogId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Catalog getCatalogById(@PathVariable("catalogId") int catalogId){
        return catalogService.findById(catalogId);
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Catalog createCatalog(@RequestBody Catalog catalog){
        return catalogService.saveOrUpdate(catalog);
    }
    @PutMapping("/{catalogId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Catalog updateCatalog(@PathVariable("catalogId") int catalogId, @RequestBody Catalog catalog){
        Catalog catalogUpDate = catalogService.findById(catalogId);
        catalogUpDate.setCatalogName(catalog.getCatalogName());
        catalogUpDate.setDescription(catalog.getDescription());
        catalogUpDate.setStatus(catalog.isStatus());
        return catalogService.saveOrUpdate(catalogUpDate);
    }
    @DeleteMapping("/{catalogId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCatalog (@PathVariable("catalogId") int catalogId){
        catalogService.delete(catalogId);
    }
    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Catalog> searchbyNameOrId(@RequestParam("catalogName")String catalogName, @RequestParam("catalogId") int catalogId){
        return this.catalogService.searchByName(catalogName, catalogId);

    }

}
