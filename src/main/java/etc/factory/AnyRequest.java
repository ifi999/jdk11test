package etc.factory;

import lombok.Getter;

@Getter
public class AnyRequest {

    private String email;
    private String addr;
    private MemberType memberType;

    public AnyRequest(String email, String addr, MemberType memberType) {
        this.email = email;
        this.addr = addr;
        this.memberType = memberType;
    }
}
