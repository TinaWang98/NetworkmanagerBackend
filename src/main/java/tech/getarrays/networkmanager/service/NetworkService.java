package tech.getarrays.networkmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.networkmanager.exception.UserNotFoundException;
import tech.getarrays.networkmanager.model.Network;
import tech.getarrays.networkmanager.repo.NetworkRepo;

import java.util.List;
import java.util.UUID;

@Service
public class NetworkService {
    private final NetworkRepo networkRepo;

    @Autowired
    public NetworkService(NetworkRepo networkRepo) {
        this.networkRepo = networkRepo;
    }

    public Network addNetwork(Network network){
        network.setNetworkCode(UUID.randomUUID().toString());
        return networkRepo.save(network);
    }

    public List<Network> findAllNetworks(){
        return networkRepo.findAll();
    }

    public Network updateNetwork(Network network){
        return networkRepo.save(network);
    }

    public Network findNetworkById(Long id){
        return networkRepo.findNetworkById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + "was not found"));
    }

    public void deleteNetwork(Long id){
        networkRepo.deleteNetworkById(id);
    }
}
