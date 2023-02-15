package ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Catalog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CatalogId")
    private int catalogId;
    @Column(name = "CatalogName", columnDefinition = "nvarchar(50)", nullable = false, unique = true)
    private String catalogName;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "Description", columnDefinition = "nvarchar(225)")
    private String description;
    @OneToMany(mappedBy = "catalog")
    private List<Product> listProduct = new ArrayList<>();
}
