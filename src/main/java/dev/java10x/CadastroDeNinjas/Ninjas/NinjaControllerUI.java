package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; // Retorna a página de listagem
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar"; // Redireciona após deletar
    }

    @GetMapping("/listar/{id}")
    public String listarNinjasPorId(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasPorID(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesninja"; // Exibe os detalhes do ninja
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas"; // Se ninja não encontrado, retorna para a lista
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja"; // Exibe o formulário de adicionar ninja
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar"; // Redireciona para a lista de ninjas
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasPorID(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "alterarNinja"; // Exibe o formulário de alteração
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas"; // Caso o ninja não seja encontrado
        }
    }

    @PostMapping("/alterar/{id}")
    public String alterarNinjaPorId(@PathVariable Long id, @ModelAttribute NinjaDTO ninjatualizado, RedirectAttributes redirectAttributes) {
        NinjaDTO ninjaExistente = ninjaService.listarNinjasPorID(id);

        if (ninjaExistente != null) {
            ninjaService.atualizarNinja(id, ninjatualizado);
            redirectAttributes.addFlashAttribute("mensagem", "Ninja " + ninjatualizado.getNome() + " atualizado com sucesso!");
            return "redirect:/ninjas/ui/listar"; // Redireciona após a alteração
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja não encontrado!");
            return "redirect:/ninjas/ui/listar"; // Caso não encontrado, redireciona para a lista
        }
    }
}
