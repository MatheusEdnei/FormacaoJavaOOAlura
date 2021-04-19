package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTest {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,250.0));
        leilao.propoe(new Lance(joao,300.0));
        leilao.propoe(new Lance(jose,400.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        double maiorEsperado = 400;
        double menorEsperado = 250;

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
    }
    
    @Test
    public void deveCalcularAMedia() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,300.0));
        leilao.propoe(new Lance(joao,400.0));
        leilao.propoe(new Lance(jose,500.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        Assert.assertEquals(400, leiloeiro.getMedia(), 0.0001);
    }

    @Test
    public void testaMediaDeZeroLance(){

        // cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Leilao leilao = new Leilao("Iphone 7");

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        //validacao
        assertEquals(0, avaliador.getMedia(), 0.0001);

    }
    
    @Test
    public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));
        leilao.propoe(new Lance(jose, 2000.0));
        leilao.propoe(new Lance(maria, 3000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        Assert.assertEquals(3000.0, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
    }
    
    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Usuario joao = new Usuario("João"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
    }
    
    @Test
    public void deveEncontrarOsTresMaioresLances() {
    	Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
        assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
    }
    
    @Test
    public void deveEntenderLancesEmOrdemAleatoria() {
    	
    	Usuario joao = new Usuario("João");
    	Usuario jose = new Usuario("José");
    	Usuario joaquim = new Usuario("Joaquim");
    	Usuario maria = new Usuario("Maria");
    	Usuario Lara = new Usuario("Lara");
    	Usuario Diego = new Usuario("Diego");
    	
    	Leilao leilao = new Leilao("Máquina do tempo");
    	
    	leilao.propoe(new Lance(joao, 200.0));
    	leilao.propoe(new Lance(jose, 450.0));
    	leilao.propoe(new Lance(joaquim, 120.0));
    	leilao.propoe(new Lance(maria, 700.0));
    	leilao.propoe(new Lance(Lara, 630.0));
    	leilao.propoe(new Lance(Diego, 230.0));
    	
    	Avaliador leiloeiro = new Avaliador();
    	leiloeiro.avalia(leilao);
    	
    	assertEquals(120.0, leiloeiro.getMenorLance(), 0.00001);
    	assertEquals(700.0, leiloeiro.getMaiorLance(), 0.00001);
    	
    }
    
    @Test
    public void deveEntenderLancesEmOrdemDescrescente() {
    	
    	Usuario joao = new Usuario("João");
    	Usuario jose = new Usuario("José");
    	Usuario joaquim = new Usuario("Joaquim");
    	Usuario maria = new Usuario("Maria");
    	
    	Leilao leilao = new Leilao("Máquina do tempo");
    	
    	leilao.propoe(new Lance(joao, 400.0));
    	leilao.propoe(new Lance(jose, 300.0));
    	leilao.propoe(new Lance(joaquim, 200.0));
    	leilao.propoe(new Lance(maria, 100.0));
    	
    	Avaliador leiloeiro = new Avaliador();
    	leiloeiro.avalia(leilao);
    	
    	assertEquals(100.0, leiloeiro.getMenorLance(), 0.00001);
    	assertEquals(400.0, leiloeiro.getMaiorLance(), 0.00001);
    	
    }
    
    @Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLances() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(0, maiores.size());
    }
}
