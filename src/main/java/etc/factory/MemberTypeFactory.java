package etc.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class MemberTypeFactory {
    private final Set<MemberTypeInterface> memberTypeInterfaces;

    public MemberTypeInterface getMemberTypeInterface(MemberType memberType) {
        return memberTypeInterfaces.stream()
                .filter(memberTypeInterface -> memberTypeInterface.support(memberType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(memberType.name()));
    }

}
