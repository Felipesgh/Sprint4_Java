package br.com.fiap.challenge.main;

import br.com.fiap.challenge.bean.*;
import br.com.fiap.challenge.dao.*;
import br.com.fiap.challenge.service.ViaCepService;
import br.com.fiap.challenge.api.Endereco;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int opcaoMenu = 0;

        do {
            try {
                String entrada = JOptionPane.showInputDialog(
                        "===== MENU PRINCIPAL =====\n" +
                                "1 - Paciente\n" +
                                "2 - Consulta\n" +
                                "3 - Médico\n" +
                                "4 - Enfermeiro\n" +
                                "5 - Setor\n" +
                                "6 - Prontuário\n" +
                                "7 - Agendamento\n" +
                                "8 - Buscar CEP\n" +
                                "9 - Sair\n" +
                                "Escolha uma opção:"
                );

                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break; // sai do loop
                }

                opcaoMenu = Integer.parseInt(entrada);

                switch (opcaoMenu) {
                    case 1 -> menuPaciente();
                    case 2 -> menuConsulta();
                    case 3 -> menuMedico();
                    case 4 -> menuEnfermeiro();
                    case 5 -> menuSetor();
                    case 6 -> menuProntuario();
                    case 7 -> menuAgendamento();
                    case 8 -> menuCep();
                    case 9 -> JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } while (opcaoMenu != 9);
    }


    private static void menuPaciente() throws SQLException, ClassNotFoundException {
        PacienteDAO dao = new PacienteDAO();
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "--- Paciente ---\n1 - Inserir\n2 - Listar\n3 - Atualizar\n4 - Deletar\n5 - Voltar"
            ));
            switch (opc) {
                case 1 -> {
                    String cpf = JOptionPane.showInputDialog("CPF:");
                    String nome = JOptionPane.showInputDialog("Nome:");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));
                    String problema = JOptionPane.showInputDialog("Problema:");
                    String pront = JOptionPane.showInputDialog("Prontuário:");
                    dao.inserir(new br.com.fiap.challenge.bean.Paciente(cpf, nome, idade, problema, pront));
                    JOptionPane.showMessageDialog(null, "Paciente inserido!");
                }
                case 2 -> {
                    List<br.com.fiap.challenge.bean.Paciente> list = dao.selecionar();
                    StringBuilder sb = new StringBuilder("Pacientes:\n");
                    for (br.com.fiap.challenge.bean.Paciente p : list) sb.append(p).append("\n");
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    String cpf = JOptionPane.showInputDialog("CPF do paciente a atualizar:");
                    String nome = JOptionPane.showInputDialog("Novo nome:");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("Nova idade:"));
                    String problema = JOptionPane.showInputDialog("Novo problema:");
                    String pront = JOptionPane.showInputDialog("Novo prontuário:");
                    dao.atualizar(new br.com.fiap.challenge.bean.Paciente(cpf, nome, idade, problema, pront));
                    JOptionPane.showMessageDialog(null, "Paciente atualizado!");
                }
                case 4 -> {
                    String cpf = JOptionPane.showInputDialog("CPF do paciente a remover:");
                    dao.deletar(cpf);
                    JOptionPane.showMessageDialog(null, "Paciente removido!");
                }
            }
        } while (opc != 5);
    }

    private static void menuConsulta() throws SQLException, ClassNotFoundException {
        ConsultaDAO dao = new ConsultaDAO();
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "--- Consulta ---\n1 - Inserir\n2 - Listar\n3 - Atualizar\n4 - Deletar\n5 - Voltar"
            ));
            switch (opc) {
                case 1 -> {
                    String pacienteNome = JOptionPane.showInputDialog("Nome do paciente:");
                    String pacienteCpf = JOptionPane.showInputDialog("CPF do paciente:");
                    String medico = JOptionPane.showInputDialog("Nome do médico:");
                    String especialidade = JOptionPane.showInputDialog("Especialidade:");
                    String data = JOptionPane.showInputDialog("Data:");
                    String hora = JOptionPane.showInputDialog("Hora:");
                    String problema = JOptionPane.showInputDialog("Problema:");
                    dao.inserir(new Consulta(pacienteNome, pacienteCpf, medico, especialidade, data, hora, problema));
                    JOptionPane.showMessageDialog(null, "Consulta inserida!");
                }
                case 2 -> {
                    List<br.com.fiap.challenge.bean.Consulta> list = dao.selecionar();
                    StringBuilder sb = new StringBuilder("Consultas:\n");
                    for (br.com.fiap.challenge.bean.Consulta c : list) sb.append(c).append("\n");
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID da consulta:"));
                    String pacienteNome = JOptionPane.showInputDialog("Nome do paciente:");
                    String pacienteCpf = JOptionPane.showInputDialog("CPF do paciente:");
                    String medico = JOptionPane.showInputDialog("Nome do médico:");
                    String especialidade = JOptionPane.showInputDialog("Especialidade:");
                    String data = JOptionPane.showInputDialog("Data:");
                    String hora = JOptionPane.showInputDialog("Hora:");
                    String problema = JOptionPane.showInputDialog("Problema:");
                    dao.atualizar(new Consulta(id, pacienteNome, pacienteCpf, medico, especialidade, data, hora, problema));
                    JOptionPane.showMessageDialog(null, "Consulta atualizada!");
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID da consulta a remover:"));
                    dao.deletar(id);
                    JOptionPane.showMessageDialog(null, "Consulta removida!");
                }
            }
        } while (opc != 5);
    }

    private static void menuMedico() throws SQLException, ClassNotFoundException {
        MedicoDAO dao = new MedicoDAO();
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "--- Médico ---\n1 - Inserir\n2 - Listar\n3 - Atualizar\n4 - Deletar\n5 - Voltar"
            ));
            switch (opc) {
                case 1 -> {
                    String nome = JOptionPane.showInputDialog("Nome:");
                    String crm = JOptionPane.showInputDialog("CRM:");
                    String especialidade = JOptionPane.showInputDialog("Especialidade:");
                    dao.inserir(new Medico(nome, crm, especialidade));
                    JOptionPane.showMessageDialog(null, "Médico cadastrado!");
                }
                case 2 -> {
                    List<Medico> list = dao.selecionar();
                    StringBuilder sb = new StringBuilder("Médicos:\n");
                    for (Medico m : list) sb.append(m).append("\n");
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do médico:"));
                    String nome = JOptionPane.showInputDialog("Novo nome:");
                    String crm = JOptionPane.showInputDialog("Novo CRM:");
                    String especialidade = JOptionPane.showInputDialog("Nova especialidade:");
                    Medico m = new Medico(id, nome, crm, especialidade);
                    m.setCrm(crm);
                    dao.atualizar(m);
                    JOptionPane.showMessageDialog(null, "Médico atualizado!");
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do médico a remover:"));
                    dao.deletar(id);
                    JOptionPane.showMessageDialog(null, "Médico removido!");
                }
            }
        } while (opc != 5);
    }

    private static void menuEnfermeiro() throws SQLException, ClassNotFoundException {
        EnfermeiroDAO dao = new EnfermeiroDAO();
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "--- Enfermeiro ---\n1 - Inserir\n2 - Listar\n3 - Atualizar\n4 - Deletar\n5 - Voltar"
            ));
            switch (opc) {
                case 1 -> {
                    String nome = JOptionPane.showInputDialog("Nome:");
                    String coren = JOptionPane.showInputDialog("COREN:");
                    String setor = JOptionPane.showInputDialog("Setor:");
                    dao.inserir(new Enfermeiro(0, nome, coren, setor)); // <-- id = 0, pois o banco gera automaticamente
                    JOptionPane.showMessageDialog(null, "Enfermeiro cadastrado!");
                }
                case 2 -> {
                    List<Enfermeiro> list = dao.selecionar();
                    StringBuilder sb = new StringBuilder("Enfermeiros:\n");
                    for (Enfermeiro e : list) sb.append(e).append("\n");
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do enfermeiro:"));
                    String nome = JOptionPane.showInputDialog("Novo nome:");
                    String coren = JOptionPane.showInputDialog("Novo COREN:");
                    String setor = JOptionPane.showInputDialog("Novo setor:");
                    dao.atualizar(new Enfermeiro(id, nome, coren, setor)); //
                    JOptionPane.showMessageDialog(null, "Enfermeiro atualizado!");
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do enfermeiro a remover:"));
                    dao.deletar(id);
                    JOptionPane.showMessageDialog(null, "Enfermeiro removido!");
                }
            }
        } while (opc != 5);
    }
    
    private static void menuSetor() throws SQLException, ClassNotFoundException {
        SetorDAO dao = new SetorDAO();
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "--- Setor ---\n1 - Inserir\n2 - Listar\n3 - Atualizar\n4 - Deletar\n5 - Voltar"
            ));
            switch (opc) {
                case 1 -> {
                    String nome = JOptionPane.showInputDialog("Nome do setor:");
                    String andar = JOptionPane.showInputDialog("Andar:");
                    String responsavel = JOptionPane.showInputDialog("Responsável:");
                    Setor s = new Setor();
                    s.setNome(nome);
                    s.setAndar(andar);
                    s.setResponsavel(responsavel);
                    dao.inserir(s);
                    JOptionPane.showMessageDialog(null, "Setor cadastrado!");
                }
                case 2 -> {
                    List<Setor> list = dao.selecionar();
                    StringBuilder sb = new StringBuilder("Setores:\n");
                    for (Setor s : list) sb.append(s).append("\n");
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do setor:"));
                    String nome = JOptionPane.showInputDialog("Novo nome:");
                    String descricao = JOptionPane.showInputDialog("Nova descrição:");
                    Setor s = new Setor();
                    s.setId(id);
                    s.setNome(nome);
                    dao.atualizar(s);
                    JOptionPane.showMessageDialog(null, "Setor atualizado!");
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do setor a remover:"));
                    dao.deletar(id);
                    JOptionPane.showMessageDialog(null, "Setor removido!");
                }
            }
        } while (opc != 5);
    }

    private static void menuProntuario() throws SQLException, ClassNotFoundException {
        ProntuarioDAO dao = new ProntuarioDAO();
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "--- Prontuário ---\n1 - Inserir\n2 - Listar\n3 - Atualizar\n4 - Deletar\n5 - Voltar"
            ));
            switch (opc) {
                case 1 -> {
                    String pacienteNome = JOptionPane.showInputDialog("Nome do paciente:");
                    String observacoes = JOptionPane.showInputDialog("Observações:");
                    String medicoNome = JOptionPane.showInputDialog("Nome do médico:");
                    String cid = JOptionPane.showInputDialog("CID:");
                    dao.inserir(new Prontuario(pacienteNome, observacoes, medicoNome, cid));
                    JOptionPane.showMessageDialog(null, "Prontuário inserido com sucesso!");
                }
                case 2 -> {
                    List<Prontuario> list = dao.selecionar();
                    StringBuilder sb = new StringBuilder("Prontuários:\n");
                    for (Prontuario p : list) sb.append(p).append("\n");
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do prontuário:"));
                    String pacienteNome = JOptionPane.showInputDialog("Nome do paciente:");
                    String observacoes = JOptionPane.showInputDialog("Nova observação:");
                    String medicoNome = JOptionPane.showInputDialog("Nome do médico:");
                    String cid = JOptionPane.showInputDialog("CID:");
                    dao.atualizar(new Prontuario(id, pacienteNome, observacoes, medicoNome, cid));
                    JOptionPane.showMessageDialog(null, "Prontuário atualizado!");
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do prontuário a remover:"));
                    dao.deletar(id);
                    JOptionPane.showMessageDialog(null, "Prontuário removido!");
                }
            }
        } while (opc != 5);
    }

    private static void menuAgendamento() throws SQLException, ClassNotFoundException {
        AgendamentoDAO dao = new AgendamentoDAO();
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "--- Agendamento ---\n1 - Inserir\n2 - Listar\n3 - Atualizar\n4 - Deletar\n5 - Voltar"
            ));
            switch (opc) {
                case 1 -> {
                    int pacienteId = Integer.parseInt(JOptionPane.showInputDialog("ID do paciente:"));
                    String medicoNome = JOptionPane.showInputDialog("Nome do médico:");
                    String data = JOptionPane.showInputDialog("Data:");
                    String hora = JOptionPane.showInputDialog("Hora:");
                    String status = JOptionPane.showInputDialog("Status:");
                    dao.inserir(new Agendamento(pacienteId, medicoNome, data, hora, status));
                    JOptionPane.showMessageDialog(null, "Agendamento inserido!");
                }
                case 2 -> {
                    List<Agendamento> list = dao.selecionar();
                    StringBuilder sb = new StringBuilder("Agendamentos:\n");
                    for (Agendamento a : list) sb.append(a).append("\n");
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do agendamento:"));
                    String novaData = JOptionPane.showInputDialog("Nova data:");
                    String novaHora = JOptionPane.showInputDialog("Nova hora:");
                    Agendamento a = new Agendamento();
                    a.setId(id);
                    a.setData(novaData);
                    a.setHorario(novaHora);
                    dao.atualizar(a);
                    JOptionPane.showMessageDialog(null, "Agendamento atualizado!");
                }
                case 4 -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do agendamento a remover:"));
                    dao.deletar(id);
                    JOptionPane.showMessageDialog(null, "Agendamento removido!");
                }
            }
        } while (opc != 5);
    }
    private static void menuCep() {
        int opcaoCep = 0;
        ViaCepService viaCepService = new ViaCepService();

        do {
            try {
                String menu = "===== Buscar Endereço (ViaCEP) =====\n"
                        + "1 - Consultar CEP manualmente\n"
                        + "2 - Endereço da Clínica Central\n"
                        + "3 - Unidade Paulista\n"
                        + "4 - Unidade Vila Mariana\n"
                        + "5 - Voltar\n\n"
                        + "Escolha uma opção:";

                String entrada = JOptionPane.showInputDialog(menu);

                // Se o usuário cancelar (clicar em "Cancelar" ou fechar a janela)
                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                    break;
                }

                opcaoCep = Integer.parseInt(entrada);

                String cepEscolhido = null;

                switch (opcaoCep) {
                    case 1 -> cepEscolhido = JOptionPane.showInputDialog("Digite o CEP:");
                    case 2 -> cepEscolhido = "01001000"; // Clínica Central
                    case 3 -> cepEscolhido = "01310940"; // Paulista
                    case 4 -> cepEscolhido = "04101200"; // Vila Mariana
                    case 5 -> JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                    default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
                }

                if (cepEscolhido != null && !cepEscolhido.isBlank()) {
                    Endereco endereco = viaCepService.buscarPorCep(cepEscolhido);
                    JOptionPane.showMessageDialog(null, endereco.toString(),
                            "Endereço encontrado", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
                break; // sai do menuCep()
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar endereço: " + e.getMessage());
            }
        } while (opcaoCep != 5);
    }
}