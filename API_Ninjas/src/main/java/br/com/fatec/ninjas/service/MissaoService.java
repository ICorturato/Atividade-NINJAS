package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Missao;
import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.repository.MissaoRepository;
import br.com.fatec.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    public Missao cadastrarMissao(Missao missao){
        return missaoRepository.save(missao);
    }

    public List<Missao> listarMissao() {
        return missaoRepository.findAll();
    }

    public Optional<Missao> buscarPorId (Long id){
        return missaoRepository.findById(id);
    }

    public Missao buscarPorTitulo (String titulo) {
        return missaoRepository.findByTitulo(titulo);
    }

    public List<Missao> buscarPorDescricao (String descricao) {
        return missaoRepository.findByDescricaoContaining(descricao);
    }

    public Missao atualizarMissao (Long id, Missao missaoAtualizada) {
        Optional<Missao> missaoCadastrado = missaoRepository.findById(id);

        if(missaoCadastrado.isPresent()){
            Missao missao = missaoCadastrado.get();

            missao.setTitulo(missaoAtualizada.getTitulo());
            missao.setDescricao(missaoAtualizada.getDescricao());
            missao.setRank(missaoAtualizada.getRank());
            missao.setStatus(missaoAtualizada.getStatus());
            missao.setRecompensa(missaoAtualizada.getRecompensa());

            return missaoRepository.save(missao);
        }
        return null;
    }

    public void deletarMissao(Long id) {
        missaoRepository.deleteById(id);
    }
}
