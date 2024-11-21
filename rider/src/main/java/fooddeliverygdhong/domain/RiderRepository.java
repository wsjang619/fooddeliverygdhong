package fooddeliverygdhong.domain;

import fooddeliverygdhong.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "riders", path = "riders")
public interface RiderRepository
    extends PagingAndSortingRepository<Rider, Long> {}
