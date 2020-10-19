package test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.Test;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Admins;
import domain.Event;
import domain.Question;
import domain.User;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FacadeMockTest {
	
     DataAccess dataAccess=Mockito.mock(DataAccess.class);
     
     Admins mockedAdmin=Mockito.mock(Admins.class);
     
     User mockedUser=Mockito.mock(User.class);
	
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dataAccess);

	@Test
	public void testa1LoginAdmin() {
		try {	

			Mockito.doReturn(true).when(dataAccess).adminetandago(Mockito.any(String.class));
			
			Mockito.doReturn(mockedAdmin).when(dataAccess).getadmin(Mockito.any(String.class));
			
			Mockito.doReturn("ibon").when(mockedAdmin).getPasahitza();
			
			sut.login("ibon@gmail.com","ibon");
			
			assertTrue(true);
			
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testaLoginUser() {
		try {
			
			Mockito.doReturn(false).when(dataAccess).adminetandago(Mockito.any(String.class));
			
			Mockito.doReturn(mockedUser).when(dataAccess).getUser(Mockito.any(String.class));
			
			Mockito.doReturn("ibon").when(mockedUser).getPasahitza();
			
			sut.login("ibon@gmail.com","ibon");
			
			assertTrue(true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaEzLoginUser() {
		try {
			
			Mockito.doReturn(false).when(dataAccess).adminetandago(Mockito.any(String.class));
			
			Mockito.doReturn(mockedUser).when(dataAccess).getUser(Mockito.any(String.class));
			
			Mockito.doReturn("mikel").when(mockedUser).getPasahitza();
			
			sut.login("ibon@gmail.com","ibon");
			
			assertTrue(true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testa1EzLoginAdmin() {
		try {
			

			Mockito.doReturn(true).when(dataAccess).adminetandago(Mockito.any(String.class));
			
			Mockito.doReturn(mockedAdmin).when(dataAccess).getadmin(Mockito.any(String.class));
			
			Mockito.doReturn("mikel").when(mockedAdmin).getPasahitza();
			
			sut.login("ibon@gmail.com","ibon");
			
			assertTrue(true);
			
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testaUserEz() {
		try {
			
			
			Mockito.doReturn(false).when(dataAccess).adminetandago(Mockito.any(String.class));
			
			Mockito.doReturn(null).when(dataAccess).getUser(Mockito.any(String.class));
			
			Mockito.doReturn("ibon").when(mockedUser).getPasahitza();
			
			sut.login("ibon@gmail.com","ibon");
			
			fail();
			
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	
	
//	@Test
//	public void test1() {
//		try {
//			//define paramaters
//			String queryText="proba galdera";
//			Float betMinimum=new Float(2);
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Date oneDate=null;;
//			try {
//				oneDate = sdf.parse("05/10/2022");
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
//			
//			//configure Mock
//			Mockito.doReturn(oneDate).when(mockedEvent).getEventDate();
//			Mockito.when(dataAccess.createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class))).thenThrow(QuestionAlreadyExist.class);
//			
//
//			//invoke System Under Test (sut) 
//			sut.createQuestion(mockedEvent, queryText, betMinimum);
//			
//			//if the program continues fail
//		    fail();
//		   } catch (QuestionAlreadyExist e) {
//			// TODO Auto-generated catch block
//			   
//			// if the program goes to this point OK
//			assertTrue(true);
//			} catch (EventFinished e) {
//				// if the program goes to this point fail
//			    fail();
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		   }
//	
//	
//	
//	@Test
//	//sut.createQuestion:  The event has NOT a question with a queryText.
//	public void test2() {
//			try {
//				//define paramaters
//				String queryText="proba galdera";
//				Float betMinimum=new Float(2);
//				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//				Date oneDate=null;;
//				try {
//					oneDate = sdf.parse("05/10/2022");
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}	
//				
//				//configure Mock
//				Mockito.doReturn(oneDate).when(mockedEvent).getEventDate();
//				Mockito.doReturn(new Question(queryText, betMinimum,mockedEvent)).when(dataAccess).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
//
//				
//
//				//invoke System Under Test (sut) 
//				Question q=sut.createQuestion(mockedEvent, queryText, betMinimum);
//				
//				//verify the results
//				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
//				
//				
//				ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
//				ArgumentCaptor<String> questionStringCaptor = ArgumentCaptor.forClass(String.class);
//				ArgumentCaptor<Float> betMinimunCaptor = ArgumentCaptor.forClass(Float.class);
//				
//				Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(eventCaptor.capture(),questionStringCaptor.capture(), betMinimunCaptor.capture());
//				Float f=betMinimunCaptor.getValue();
//
//				assertEquals(eventCaptor.getValue(),mockedEvent);
//				assertEquals(questionStringCaptor.getValue(),queryText);
//				assertEquals(betMinimunCaptor.getValue(),betMinimum);
//
//			   } catch (QuestionAlreadyExist e) {
//				// TODO Auto-generated catch block
//				assertTrue(true);
//				} catch (EventFinished e) {
//				    fail();
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			   }
//		
}
