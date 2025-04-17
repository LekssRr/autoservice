package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.autoservice.entity.AutoEntity;
import ru.autoservice.entity.ServiceCompanyEntity;

public class AutoEntityTest {
    private String vinCodeTest = "3333333";
    private String nameServiceCompanyTest = "SC-Test";
    private ServiceCompanyEntity serviceCompanyEntityTest = new ServiceCompanyEntity(nameServiceCompanyTest);
    private AutoEntity autoEntityTest = new AutoEntity(vinCodeTest, serviceCompanyEntityTest);

    @Test
    void getVinCodeTest() {
        Assertions.assertEquals(autoEntityTest.getVinCode(), vinCodeTest);
    }

    @Test
    void getServiceCompanyTest() {
        Assertions.assertEquals(autoEntityTest.getServiceCompany().getNameServiceCompany(), nameServiceCompanyTest);
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals(autoEntityTest.toString(), vinCodeTest);
    }

}
