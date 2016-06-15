/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.service;

import fr.utbm.formation.entity.Client;
import fr.utbm.formation.repository.ClientDAO;
import fr.utbm.formation.repository.CourseSessionDAO;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Cyntia KEMAMEN
 */
public class FormationServiceTest {
    
    @Mock
    private ClientDAO clientDAOMock;
            
    @InjectMocks
    private FormationService service;
    
    public FormationServiceTest() {
    }
        
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        clientDAOMock = Mockito.mock(ClientDAO.class);
        service = new FormationService();
        service.setClientDAO(clientDAOMock);
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of manageClient method, of class FormationService.
     */
    @Test
    public void testGetAllClient() {
        System.out.println("manageClient");
        CourseSessionDAO cs = new CourseSessionDAO();
        
        List<Client> all = new LinkedList();
        try{
            all.add(new Client(1,"MVENG","Hervé","7 avenue wilson, 90000 Belfort","06123456","herve.m@kbm.fr",cs.getCourseSession(1)));
            all.add(new Client(2,"KONDE","Jacques",	"7 avenue wilson, 90000 Belfort","06123456","jacques.konde@kbm.fr",cs.getCourseSession(2)));
            all.add(new Client(3,"KEMAMEN","Cynthia","7 avenue wilson, 90000 Belfort","06123456","cynthia.kemamen@kbm.fr",cs.getCourseSession(4)));
            all.add(new Client(4,"ZEUFACK","Arnel Jaja","28 rue Thiers, 90000 Belfort","06123456","xxxx.yyyy@kbm.fr",cs.getCourseSession(2)));
        }catch(NullPointerException e){
                
                }
        
        //MOCK ALERT: return mocked result set on find
        when(clientDAOMock.getAllClient()).thenReturn(all); 

        List<Client> result;
        result = service.getAllClient();

        //MOCK ALERT: verify the method was called
        verify(clientDAOMock).getAllClient();
                
        assertEquals("Test équivalent", result, all);
        
    }

    
}
