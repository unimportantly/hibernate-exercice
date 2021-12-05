package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="subsidiary")
public class Subsidiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subsidiary_id")
    private long subsidiaryId;
    private String name;
    private int employeeNumber;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany
    @JoinTable (joinColumns = @JoinColumn(name = "subsidiary_id"),
                    inverseJoinColumns = @JoinColumn(name = "sector_id"))
    private Set<Sector> sectorSet = new HashSet<Sector>();

    public long getSubsidiaryId() {
        return subsidiaryId;
    }

    public void setSubsidiaryId(long subsidiaryId) {
        this.subsidiaryId = subsidiaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Sector> getSectorSet() {
        return sectorSet;
    }

    public void setSectorSet(Set<Sector> sectorSet) {
        this.sectorSet = sectorSet;
    }
}
