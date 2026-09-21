package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja cadastrarNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }

    public List<Ninja> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public Optional<Ninja> pesquisarNinja (Long id){
        return ninjaRepository.findById(id);
    }

    public Ninja pesquisarNinjaPorNome (String nome) {
        return ninjaRepository.findByNome(nome);
    }

    public List<Ninja> pesquisarNinjaPorParteDoNome (String nome) {
        return ninjaRepository.findByNomeContaining(nome);
    }

    public Ninja atualizarNinja (Long id, Ninja ninjaAtualizado) {
        Optional<Ninja> ninjaCadastrado = ninjaRepository.findById(id);

        if(ninjaCadastrado.isPresent()){
            Ninja ninja = ninjaCadastrado.get();

            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setCpf(ninjaAtualizado.getCpf());
            ninja.setEmail(ninjaAtualizado.getEmail());

            return ninjaRepository.save(ninja);
        }
        return null;
    }

    public void deletarNinjar (Long id) {
        ninjaRepository.deleteById(id);
    }
}
