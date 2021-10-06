package com.anahuac.calidad.app;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculadoraParametrizadaTest {
	private double arg1; //value1
	private double arg2; //value2
	private double arg3; //expected value
	private Calculadora miCalculadora;
	
	public CalculadoraParametrizadaTest(double arg1, double arg2, double arg3){
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{4,2,2}, //integers
			{6,-3,-2}, //negative integer
			{5,5,1}, //same number
			{5,2,2.5}, //decimal
			{5,-2,-2.5}, //negative decimal
			{10,0,Double.POSITIVE_INFINITY}, //infinty
			{0,0,Double.NaN} //not a number
		});
	}

	@Before
	public void setUp() throws Exception {
		miCalculadora = new Calculadora();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Divisiontest() {
		
		//El ejercicio del código a probar
		double resultadoEjecucion = miCalculadora.division(this.arg1, this.arg2);
		
		//Verificar
		//Assert.assertEquals(resultadoEsperado, resultadoEjecucion, .01);
		assertThat(this.arg3,is(resultadoEjecucion));
	}

}
