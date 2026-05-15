package application;
import entities.Barbeiro;
import entities.Servico;
import services.BarbeiroService;
import services.ServicoService;
import services.AgendamentoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BarbeiroService barbeiroService = new BarbeiroService();
        ServicoService servicoService = new ServicoService();
        AgendamentoService agendamentoService = new AgendamentoService();

        Barbeiro barbeiro01 = new Barbeiro("João", "Degradê", "5521987256728");
        Barbeiro barbeiro02 = new Barbeiro("Alerrandro", "Social", "5521976547564");

        barbeiroService.cadastrarBarbeiro(barbeiro01);
        barbeiroService.cadastrarBarbeiro(barbeiro02);

        Servico servico01 = new Servico("Corte na tesoura", 30.00, 30);
        Servico servico02 = new Servico("Barba", 35.00, 30);
        Servico servico03 = new Servico("Corte + Barboterapia", 65.00, 45);
        Servico servico04 = new Servico("Corte + Sobrancelha", 45, 40);
        Servico servico05 = new Servico("Acabamento (pezinho)", 15.00, 15);

        servicoService.cadastrarServico(servico01);
        servicoService.cadastrarServico(servico02);
        servicoService.cadastrarServico(servico03);
        servicoService.cadastrarServico(servico04);
        servicoService.cadastrarServico(servico05);


    }
}
