package com.anahuac.calidad.tareaUnitTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.anahuac.calidad.doubles.Dependency;
import com.anahuac.calidad.doublesDAO.Alumno;
import com.anahuac.calidad.doublesDAO.FakeOracleDAO;

public class AccountTest {

	
	private AlertListener interfaceAccount;
	private HashMap<String, Account> accounts;

	@Before
	public void setUp() throws Exception {
		interfaceAccount = Mockito.mock(AccountDAO.class);
		accounts = new HashMap<String, Account>();
		
	}
	

	@Test
	public void testAgregar() {
		int cuantosAntes = accounts.size();
		
		Account accountAdd = new Account("marisol",  20,20,1, this.interfaceAccount);
		interfaceAccount.addAccount(accountAdd);
		
		doAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) {
				Account arg = (Account) invocation.getArguments()[0];
				accounts.put(anyString(), arg);	
				return null;
			}})
		.when(interfaceAccount).addAccount(accountAdd);
		interfaceAccount.addAccount(accountAdd);
		
		int cuantosDesp = accounts.size();
		assertThat(cuantosAntes+1,is(cuantosDesp));
		
	}
	
	
	


	@Test
	public void alert() {
		
		
		Account mockedList = mock(Account.class);
		 
		//utilizando el mock object
		mockedList.credit(100);
		//mockedList.clear();
		mockedList.getBalance();
		//verificacion
		verify(mockedList).credit(100);
		verify(mockedList).getBalance();
		
	
		
	}
	
	@Test
	public void pruebaAnswer() {
		
		Account mocked = mock(Account.class);
		
        Hashtable<Integer, String> ht1 = new Hashtable<>();

		
		//when(mocked.getBalance()).thenReturn(100);
	

		// or..
		doAnswer(new Answer() {
		    @Override
		    public Object answer(InvocationOnMock invocation) throws Throwable {
		        return 100;
		    }
		}).when(mocked).getBalance();
		
		doAnswer(new Answer() {
		    @Override
		    public Object answer(InvocationOnMock invocation) throws Throwable {
		        return 100;
		    }
		}).when(mocked).getDeposito();
		
		doAnswer(new Answer() {
		    @Override
		    public Object answer(InvocationOnMock invocation) throws Throwable {
		        return 3;
		    }
		}).when(mocked).getZona();
		
		int total=mocked.getZona()*mocked.getDeposito();
		
		
	      assertSame(3,mocked.getZona());

		
		//assertEquals("java", spy.get(0));

		
		//assert(3,miCuenta.consultarComisiones)
		
	}
	
	  
    private static void p(String text) {
        System.out.println(text);
    }
}
