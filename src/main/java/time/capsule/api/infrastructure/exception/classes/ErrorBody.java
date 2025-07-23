package time.capsule.api.infrastructure.exception.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorBody implements Serializable {

    private Date timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

}
