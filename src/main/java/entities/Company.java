package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private long companyId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Subsidiary> subsidiaries = new HashSet<Subsidiary>();

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subsidiary> getSubsidiaries() {
        return subsidiaries;
    }

    public void setSubsidiaries(Set<Subsidiary> subsidiaries) {
        this.subsidiaries = subsidiaries;
    }
}
