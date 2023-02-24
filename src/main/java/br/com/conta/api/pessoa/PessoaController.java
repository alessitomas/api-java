package br.com.conta.api.pessoa;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private List<Pessoa> pessoas = new ArrayList<>();


    // @RequestHeader passar info pelo header
    @GetMapping("")
    public List<Pessoa> getPessoas(@RequestParam(name = "idade", required = false) Integer idade){
        if (idade !=null ){
            List<Pessoa> filtradas = new ArrayList<>();
            for (Pessoa p : pessoas){
                if (p.getIdade().equals(idade)){
                    filtradas.add(p);
                }
            }
            return filtradas;
        }
        return pessoas;
    }

    @GetMapping("/{id}")
    public Pessoa getPessoa(@PathVariable Integer id){
        return pessoas.get(id);
    }
    
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pessoa salvarPessoa(@RequestBody @Valid Pessoa pessoa){
        pessoas.add(pessoa);
        return pessoa;
   }
} 