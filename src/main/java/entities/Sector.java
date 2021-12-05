package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sector")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sector_id")
    private long sectorId;
    private String name;
    private String location;
    @ManyToMany(mappedBy = "sectorSet")
    private Set<Subsidiary> subsidiarySet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sector")
    private Set<User> userSet = new HashSet<User>();

    public long getSectorId() {
        return sectorId;
    }

    public void setSectorId(long sectorId) {
        this.sectorId = sectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Subsidiary> getSubsidiarySet() {
        return subsidiarySet;
    }

    public void setSubsidiarySet(Set<Subsidiary> subsidiarySet) {
        this.subsidiarySet = subsidiarySet;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
