package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.autoservice.entity.AutoEntity;
import ru.autoservice.entity.ServiceCompanyEntity;

import java.util.ArrayList;
import java.util.List;

public class ServiceCompanyEntityTest {
    private String vinCodeTest = "3333333";
    private String nameServiceCompanyTest = "SC-Test";
    private ServiceCompanyEntity serviceCompanyEntityTest = new ServiceCompanyEntity(nameServiceCompanyTest);
    private AutoEntity autoEntityTest = new AutoEntity(vinCodeTest, serviceCompanyEntityTest);
    private AutoEntity autoEntityTest1 = new AutoEntity(vinCodeTest + "1", serviceCompanyEntityTest);
    private List<AutoEntity> autoEntitiesTest = new ArrayList<>();

    @Test
    void getNameServiceCompany() {
        Assertions.assertEquals(serviceCompanyEntityTest.getNameServiceCompany(), nameServiceCompanyTest);
    }

    @Test
    void addAutoToServiceCompany() {
        Assertions.assertEquals(serviceCompanyEntityTest.addAutoToServiceCompany(autoEntityTest), true);
        Assertions.assertEquals(serviceCompanyEntityTest.addAutoToServiceCompany(autoEntityTest), false);
    }

    @Test
    void getAutoEntities() {
        serviceCompanyEntityTest.addAutoToServiceCompany(autoEntityTest);
        serviceCompanyEntityTest.addAutoToServiceCompany(autoEntityTest1);
        autoEntitiesTest.add(autoEntityTest);
        autoEntitiesTest.add(autoEntityTest1);
        Assertions.assertEquals(serviceCompanyEntityTest.getAutoEntities(), autoEntitiesTest);
    }

    @Test
    void deleteAutoToServiceCompany() {
        serviceCompanyEntityTest.addAutoToServiceCompany(autoEntityTest);
        Assertions.assertEquals(serviceCompanyEntityTest.deleteAutoToServiceCompany(autoEntityTest), true);
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals(serviceCompanyEntityTest.toString(), nameServiceCompanyTest);
    }

}
