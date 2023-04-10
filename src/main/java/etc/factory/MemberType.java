package etc.factory;

public enum MemberType {
    A {
        @Override
        void memberTypeHandle() {
            //
        }
    },
    B {
        @Override
        void memberTypeHandle() {
            //
        }
    },
    C {
        @Override
        void memberTypeHandle() {
            //
        }
    },
    D {
        @Override
        void memberTypeHandle() {
            //
        }
    },
    E {
        @Override
        void memberTypeHandle() {
            //
        }
    },
    ADMIN {
        @Override
        void memberTypeHandle() {
            //
        }
    };

    abstract void memberTypeHandle();
}
