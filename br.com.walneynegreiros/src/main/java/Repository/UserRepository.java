package Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import Entidades.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
