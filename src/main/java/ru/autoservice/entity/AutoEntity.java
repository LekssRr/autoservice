package ru.autoservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Auto")
public class AutoEntity {
    @Id
    private String vinCode;
    @ManyToOne
    private ServiceCompanyEntity serviceCompany;

    public AutoEntity(String newVinCode, ServiceCompanyEntity newServiceCompany) {
        this.vinCode = newVinCode;
        this.serviceCompany = newServiceCompany;
    }

    public AutoEntity() {

    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String newVin) {
        this.vinCode = newVin;
    }

    public ServiceCompanyEntity getServiceCompany() {
        return serviceCompany;
    }

    public void setServiceCompany(ServiceCompanyEntity serviceCompany) {
        this.serviceCompany = serviceCompany;
    }

    @Override
    public String toString() {
        return vinCode;
    }
}
