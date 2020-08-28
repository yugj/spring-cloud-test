package indi.yugj.test.springcloud.basetest.randomobj;

import com.alibaba.fastjson.JSON;
import org.jeasy.random.EasyRandom;

/**
 * @author yugj
 * @date 2020/8/28 8:46 上午.
 */
public class Person {

    private String name;

    private int age;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void main(String[] args) {
        EasyRandom easyRandom = new EasyRandom();
        Person person = easyRandom.nextObject(Person.class);

        System.out.println(
                JSON
                        .toJSONString(person)
        );
        //output
        //{"age":-1188957731,"email":"yedUsFwdkelQbxeTeQOvaScfqIOOmaa","name":"eOMtThyhVNLWUZNRcBaQKxI"}
    }
}
