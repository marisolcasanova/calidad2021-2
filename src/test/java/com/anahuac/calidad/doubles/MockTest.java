package com.anahuac.calidad.doubles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class MockTest {
	
	Dependency dependency;

	@Before
	public void setUp() throws Exception {
		dependency = Mockito.mock(Dependency.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//System.out.println("Resultado = " + dependency.addTwo(5));
		assertThat(dependency.getClassName(),is(nullValue()));
		//fail("Not yet implemented");
	}
	
	private void setearComportamientoValue() {
		//Definir el comportamiento esperado
		when(dependency.getClassName()).thenReturn("Nombre de la clase");
	}
	
	@Test
	public void mockValueTest() {
		String resultadoEsperado = "Nombre de la clase";
		//Definir el comportamiento esperado
		//when(dependency.getClassName()).thenReturn(resultadoEsperado);
		setearComportamientoValue();
		//ejercitar el código
		String resultadoEjecucion = dependency.getClassName();
		//Verificar
		assertThat(resultadoEsperado,is(resultadoEjecucion));
	}
	
	@Test
	public void mockRealTest() {
		when(dependency.getClassName()).thenCallRealMethod();
		
		assertThat(dependency.getClassName(),is(dependency.getClass().getSimpleName()));
		
	}
	
	@Test
	public void mockArgumentoTest() {
		int resultadoEsperado = 10;
		when(dependency.addTwo(anyInt())).thenReturn(10);
	
		//ejercitar el código
		int resultadoEjecucion = dependency.addTwo(0);
		//Verificar
		assertThat(resultadoEsperado,is(resultadoEjecucion));
		assertThat(10,is(dependency.addTwo(59)));
	}
	
	@Test
	public void mockAnswerTest() {
		
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				int arg = (Integer) invocation.getArguments()[0];
				return arg + 10;
			}
		}
		);
	
		//ejercitar el código
		
		//Verificar
		assertThat(69,is(dependency.addTwo(59)));
		assertThat(39,is(dependency.addTwo(29)));
	}
	

}
