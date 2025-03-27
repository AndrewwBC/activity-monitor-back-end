package extension.extension.activity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, String> {

    Optional<Activity> findByUrl(String url);

}
