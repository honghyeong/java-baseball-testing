package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {


    @Test

    public void setName() {

        Member member = new Member("dfdf", 10);

        member.setName("aa");

        Assertions.assertEquals("aa",member.getName());

    }
}