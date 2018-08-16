package indi.yugj.test.springclound.basetest.lombok;

/**
 * @author yugj
 * @date 18/8/16 11:08.
 */
public class BaseVo {

    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
