package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> getAllClient();

    Cliente getByIdClient(Long id);

    void putClient(Cliente cliente);

    void patchClient(Long id, Cliente cliente);

    void deleteClient(Long id);

}