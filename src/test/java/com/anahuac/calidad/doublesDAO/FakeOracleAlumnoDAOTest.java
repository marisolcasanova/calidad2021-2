package com.anahuac.calidad.doublesDAO;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;

public class FakeOracleAlumnoDAOTest {
	
	private FakeOracleDAO dao;
	private HashMap<String, Alumno> alumnos;
	

	@Before
	public void setUp() throws Exception {
		dao = Mockito.mock(FakeOracleDAO.class);
		alumnos = new HashMap<String, Alumno>();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addAlumnoTest() {
		
		int cuantosAntes = alumnos.size();
		
		Alumno alumno1 = new Alumno("nombre", "001", 20, "micorreo@hola.com");
		dao.addAlumno(alumno1);
		
		/*when(dao.addAlumno(any(Alumno.class))).thenAnswer(
				new Answer<Boolean>() {
					public Boolean answer(InvocationOnMock invocation) throws Throwable {
						Alumno arg = (Alumno) invocation.getArguments()[0];
						alumnos.put(anyString(), arg);
					
						return true;
					}
				}
				);
		*/
		doAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) {
				Alumno arg = (Alumno) invocation.getArguments()[0];
				alumnos.put(anyString(), arg);	
				return null;
			}})
		.when(dao).addAlumno(any(Alumno.class));
		dao.addAlumno(alumno1);
		
		int cuantosDesp = alumnos.size();
		assertThat(cuantosAntes+1,is(cuantosDesp));
	}

}
