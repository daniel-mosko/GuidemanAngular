package guideman.storage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -2285222687317294861L;

  public EntityNotFoundException(String message) {
    super(message);
  }


}
