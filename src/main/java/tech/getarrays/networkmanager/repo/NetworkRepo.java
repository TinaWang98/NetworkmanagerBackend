package tech.getarrays.networkmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.networkmanager.model.Network;

import java.util.Optional;

public interface NetworkRepo extends JpaRepository<Network,Long> {
    void deleteNetworkById(Long id);

    Optional<Network> findNetworkById(Long id);
}
