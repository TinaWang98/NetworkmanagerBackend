package tech.getarrays.networkmanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.networkmanager.model.Network;
import tech.getarrays.networkmanager.service.NetworkService;

import java.util.List;

@RestController
@RequestMapping("/network")
public class NetworkResource {
    private final NetworkService networkService;


    public NetworkResource(NetworkService networkService) {
        this.networkService = networkService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Network>> getAllNetworks (){
        List<Network> networks = networkService.findAllNetworks();
        return new ResponseEntity<>(networks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Network> getNetworksById (@PathVariable("id") Long id){
        Network network = networkService.findNetworkById(id);
        return new ResponseEntity<>(network, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Network> addNetwork(@RequestBody Network network){
        Network newNetwork = networkService.addNetwork(network);
        return new ResponseEntity<>(newNetwork,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Network> updateNetwork(@RequestBody Network network){
        Network updateNetwork = networkService.updateNetwork(network);
        return new ResponseEntity<>(updateNetwork,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNetwork(@PathVariable("id") Long id){
        networkService.deleteNetwork(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
