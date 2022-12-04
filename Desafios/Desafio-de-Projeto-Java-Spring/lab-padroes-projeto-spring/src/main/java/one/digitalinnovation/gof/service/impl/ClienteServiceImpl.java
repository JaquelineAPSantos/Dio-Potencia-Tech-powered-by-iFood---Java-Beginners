package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> getAllClient() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getByIdClient(Long id) {
       Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()) {
           return cliente.get();
        } else {
            return null;
        }
    }
    @Override
    public void putClient(Cliente cliente) {
        clientCepExist(cliente);
    }

    @Override
    public void patchClient(Long id, Cliente cliente) {
        Optional<Cliente> clienteById = clienteRepository.findById(id);
        if (clienteById.isPresent()) {
            clientCepExist(cliente);
        }
    }

    @Override
    public void deleteClient(Long id) {
       clienteRepository.deleteById(id);
    }

    private void clientCepExist(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}
