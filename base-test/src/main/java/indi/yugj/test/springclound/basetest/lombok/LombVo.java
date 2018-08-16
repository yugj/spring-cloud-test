package indi.yugj.test.springclound.basetest.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yugj
 * @date 18/8/16 10:30.
 */
@Getter
@Setter
@Accessors(chain = true)
public class LombVo {

    private String name;
    private Long id;

    public String getName() {
        return "hell:" + this.name;
    }
}
