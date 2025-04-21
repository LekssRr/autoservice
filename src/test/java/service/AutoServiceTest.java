package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.autoservice.dto.AutoDto;
import ru.autoservice.entity.AutoEntity;
import ru.autoservice.entity.ServiceCompanyEntity;
import ru.autoservice.repository.AutoRepository;
import ru.autoservice.repository.ServiceCompanyRepository;
import ru.autoservice.service.AutoService;
import ru.autoservice.service.AutoServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutoServiceTest {

    @Mock
    private final AutoRepository autoRepositoryTest = Mockito.mock(AutoRepository.class);
    @Mock
    private final ServiceCompanyRepository serviceCompanyRepositoryTest = Mockito.mock(ServiceCompanyRepository.class);
    @InjectMocks
    private final AutoService autoServiceTest = new AutoServiceImpl(autoRepositoryTest, serviceCompanyRepositoryTest);

    @Test
    public void getServiceCompanyTest() {
        String vinCodeTest = "11111111111111111";
        String nameServiceCompanyTest = "SC-Test";
        AutoDto testAutoDto = new AutoDto(vinCodeTest, nameServiceCompanyTest);
        Assertions.assertEquals(autoServiceTest.getServiceCompany(testAutoDto), nameServiceCompanyTest);
    }
    @Test
    public void getAutoTest() {
        String vin = "00000000000000000";
        ServiceCompanyEntity serviceCompanyEntity = new ServiceCompanyEntity("SC-Test");
        AutoEntity testAutoEntity = new AutoEntity(vin, serviceCompanyEntity);
        AutoDto autoDto = new AutoDto(vin, serviceCompanyEntity.getNameServiceCompany());
        Optional<AutoEntity> optionalAutoEntity = Optional.ofNullable(testAutoEntity);
        Mockito.when(autoRepositoryTest.findById(vin)).thenReturn(optionalAutoEntity);
        Assertions.assertEquals(autoServiceTest.getAuto(vin), autoDto);
    }
    @Test
    public void getAllAutoTest() {
        List<AutoEntity> autoEntities = new ArrayList<>();
        List<AutoDto> autoDto = new ArrayList<>();
        String vin = "00000000000000000";
        String vin1 = "00000000000000001";
        String vin2 = "00000000000000002";
        ServiceCompanyEntity sc = new ServiceCompanyEntity("SC-1");
        ServiceCompanyEntity sc1 = new ServiceCompanyEntity("SC-2");
        ServiceCompanyEntity sc2 = new ServiceCompanyEntity("SC-3");
        AutoEntity test = new AutoEntity(vin, sc);
        AutoEntity test1 = new AutoEntity(vin1, sc1);
        AutoEntity test2 = new AutoEntity(vin2, sc2);
        autoEntities.add(test);
        autoEntities.add(test1);
        autoEntities.add(test2);
        for (int i =0; i<=autoEntities.size()-1;i++)
        {
            autoDto.add(new AutoDto(autoEntities.get(i).getVinCode(), autoEntities.get(i).getServiceCompany().getNameServiceCompany()));
        }
        Mockito.when(autoRepositoryTest.findAll()).thenReturn(autoEntities);
        Assertions.assertEquals(autoServiceTest.getAllAuto(), autoDto);
    }
    @Test
    public void getAllAutoToServiceCompanyTest() {
        List<AutoEntity> autoEntities = new ArrayList<>();
        List<AutoDto> autoDto = new ArrayList<>();
        String vin = "00000000000000000";
        String vin1 = "00000000000000001";
        String vin2 = "00000000000000002";
        ServiceCompanyEntity sc = new ServiceCompanyEntity("SC-1");
        ServiceCompanyEntity sc1 = new ServiceCompanyEntity("SC-2");
        AutoEntity test = new AutoEntity(vin, sc);
        AutoEntity test1 = new AutoEntity(vin1, sc1);
        AutoEntity test2 = new AutoEntity(vin2, sc);
        autoEntities.add(test);
        autoEntities.add(test1);
        autoEntities.add(test2);
        autoDto.add(new AutoDto(test.getVinCode(), test.getServiceCompany().getNameServiceCompany()));
        autoDto.add(new AutoDto(test2.getVinCode(), test2.getServiceCompany().getNameServiceCompany()));
        Mockito.when(autoRepositoryTest.findAll()).thenReturn(autoEntities);
        Assertions.assertEquals(autoServiceTest.getAllAutoToServiceCompany(sc.getNameServiceCompany()), autoDto);
    }
    @Test
    public void addAutoTest() {
        List<AutoEntity> autoEntities = new ArrayList<>();
        List<AutoDto> autoDto = new ArrayList<>();
        String vin = "00000000000000000";
        String vin1 = "00000000000000001";
        String vin2 = "00000000000000002";
        ServiceCompanyEntity sc = new ServiceCompanyEntity("SC-1");
        ServiceCompanyEntity sc1 = new ServiceCompanyEntity("SC-2");
        ServiceCompanyEntity sc2 = new ServiceCompanyEntity("SC-3");
        AutoEntity test = new AutoEntity(vin, sc);
        AutoEntity test1 = new AutoEntity(vin1, sc1);
        AutoEntity test2 = new AutoEntity(vin2, sc2);
        AutoEntity test3 = new AutoEntity("12121", new ServiceCompanyEntity("SC-4"));
        autoEntities.add(test);
        autoEntities.add(test1);
        autoEntities.add(test2);
        for (int i =0; i<=autoEntities.size()-1;i++)
        {
            autoDto.add(new AutoDto(autoEntities.get(i).getVinCode(), autoEntities.get(i).getServiceCompany().getNameServiceCompany()));
        }
        Mockito.when(autoRepositoryTest.findAll()).thenReturn(autoEntities);
        Assertions.assertEquals(autoServiceTest.addAuto(test.getVinCode(), test.getServiceCompany().getNameServiceCompany()), false);
        Assertions.assertEquals(autoServiceTest.addAuto(test3.getVinCode(), test3.getServiceCompany().getNameServiceCompany()), false);

    }
    @Test
    public void deleteAutoTest() {
        List<AutoEntity> autoEntities = new ArrayList<>();
        List<AutoDto> autoDto = new ArrayList<>();
        String vin = "00000000000000000";
        String vin1 = "00000000000000001";
        String vin2 = "00000000000000002";
        ServiceCompanyEntity sc = new ServiceCompanyEntity("SC-1");
        ServiceCompanyEntity sc1 = new ServiceCompanyEntity("SC-2");
        ServiceCompanyEntity sc2 = new ServiceCompanyEntity("SC-3");
        AutoEntity test = new AutoEntity(vin, sc);
        AutoEntity test1 = new AutoEntity(vin1, sc1);
        AutoEntity test2 = new AutoEntity(vin2, sc2);
        autoEntities.add(test);
        autoEntities.add(test1);
        autoEntities.add(test2);
        for (int i =0; i<=autoEntities.size()-1;i++)
        {
            autoDto.add(new AutoDto(autoEntities.get(i).getVinCode(), autoEntities.get(i).getServiceCompany().getNameServiceCompany()));
        }
        Mockito.when(autoRepositoryTest.findAll()).thenReturn(autoEntities);
        Assertions.assertEquals(autoServiceTest.deleteAuto(vin), true);
        Assertions.assertEquals(autoServiceTest.deleteAuto("2222"), false);
    }

    @Test
    public void updateAutoTest() {

    }
}
