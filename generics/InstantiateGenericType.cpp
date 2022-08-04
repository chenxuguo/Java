template<clas T> class Foo {
    T x;
    T* y;
public :
    // Initialize the pointer:
    Foo() { y = bew T(); }
};

class Bar {};

int main() {
    Foo<bar> fb;
    Foo<int> fi;    // ... and it works with primitives
}
