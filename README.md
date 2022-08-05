# Java

Thus, annotations allow you to store extra information about your program in a format that is tested and verified by the compiler.

reusing
Initializing the base class
In addition, the call to the base-class constructor must be the first thing you do in the derived-class constructor.
Delegation
The final keyword
Java’s final keyword has slightly different meanings depending on the context, but in general it says “This cannot be changed.”
that is, the calculation can be performed at compile time, eliminating some run-time overhead.

Polymorphism is the third essential feature of an object-oriented programming language, after data abstraction and inheritance.
It provides another dimension of separation of interface from implementation, to decouple what from how
Polymorphism is a feature that cannot be viewed in isolation (like a switch statement can, for example), but instead works only in concert, as part of the larger picture of class relationships.
The classic example in OOP is the “shape” example. This is commonly used because it is easy to visualize, but unfortunately it can confuse novice programmers into thinking that OOP is just for graphics programming, which is of course not the case.
Now let’s return to the musical instrument example.
A general guideline is “Use inheritance to express differences in behavior, and fields to express variations in state.”
When a Sub object is upcast to a Super reference, any field accesses are resolved by the compiler, and are thus not polymorphic.
If a method is static, it doesn’t behave polymorphically:

it’s important to understand the way constructors work in complex hierarchies and with polymorphism.

A better approach is to choose composition first, especially when it’s not obvious which one you should use.

Polymorphism means “different forms.” In object-oriented programming, you have the same interface from the base class, and different forms using that interface:

Intefaces
Although your first impulse will be to create an interface, the abstract class is an important and necessary tool for building classes that have some unimplemented methods. You can’t always use a pure interface.

Only some of the methods will be abstract, since making a class abstract doesn’t force you to make all the methods abstract.

Abstract classes are also useful refactoring tolls, since they allow you to easily move common methods up the inheritance hierarchy.

An interface provides only a form, but no implementation.

Thus, any code that uses a particular interface knows what methods might be called for that interface

So when you implement an interface, the methods from the interface must be defined as public. Otherwise, they would default to package access, and you’d be reducing the accessibility of a method during inheritance, which is not allowed by the Java compiler.

Completely Decoupling
If you would like to apply the method to a class that isn’t in that hierarchy, you’re out of luck. An interface relaxes this constraint considerably. As a result, it allows you to write more reusable code.

In this case, the Processor subtypes modify String objects (note that the return types can be covariant, but not the argument types):

Creating a method that behaves differently depending on the argument object that you pass it is called the Strategy design pattern. The method contains the fixed part of the algorithm to be performed, and the Strategy contains the part that varies.

Basically, the coupling between Apply.process( ) and Processor is stronger than it needs to be, and this prevents the Apply.process( ) code from being reused when it ought to be.
If Processor is an interface, however, the constraints are loosened enough that you can reuse an Apply.process( ) that takes that interface.

In the case of the electronic filters, for example, the library was discovered rather than created. In these cases, you can use the Adapter design pattern.

the FilterAdapter constructor takes the interface that you have—Filter—and produces an object that has the Processor interface that you need.

Decoupling interface from implementation allows an interface to be applied to multiple different implementations, and thus your code is more reusable.

“Multiple inheritance” in Java
In C++, this act of combining multiple class interfaces is called multiple inheritance, and it carries some rather sticky baggage because each class can have an implementation. In Java, you can perform the same act, but only one of the classes can have an implementation, so the C++ problems do not occur with Java when combining multiple interfaces:

If you do inherit from a non-interface, you can inherit from only one. All the rest of the base elements must be interfaces.

When you combine a concrete class with interfaces this way, the concrete class must come first, then the interfaces.

Normally, you can use extends with only a single class, but extends can refer to multiple base interfaces when building a new interface.

When you want to create an object, all the definitions must first exist.

Keep in mind that one of the core reasons for interfaces is shown in the preceding example: to upcast to more than one base type. However, a second reason for using interfaces is the same as using an abstract base class: to prevent the client programmer from making an object of this class and to establish that it is only an interface.

If it’s possible to create your base class without any method definitions or member variables, you should always prefer interfaces to abstract classes.


Extending an interface
with inheritance
Normally, you can use extends with only a single class, but extends can refer to multiple base interfaces when building a new interface. As you can see, the interface names are simply separated with commas.

You can easily add new method declarations to an interface by using inheritance, and you can also combine several interfaces into a new interface with inheritance. In both cases you get a new interface

Name collisions when combining
Interfaces

Also, overloaded methods cannot differ only by return type.
Also, overloaded methods cannot differ only by return type.

Using the same method names in different interfaces that are intended to be combined generally causes confusion in the readability of the code, as well. Strive to avoid it.


Adapting to an interface
In simple cases this is in the form of a method that accepts an interface, leaving it up to you to implement that interface and pass your object to the method.

One of the most compelling reasons for interfaces is to allow multiple implementations for the same interface

Thus, a common use for interfaces is the aforementioned Strategy design pattern.

Because you can add an interface onto any existing class in this way, it means that a method that takes an interface provides a way for any class to be adapted to work with that method. This is the power of using interfaces instead of classes.

Fields in interfaces
Because any fields you put into an interface are automatically static and final, the interface is a convenient tool for creating groups of constant values.

Initializing fields in interfaces
Fields defined in interfaces cannot be "blank finals," but they can be initialized with non-constant expressions.
0.


Nesting interfaces
The syntax for nesting an interface within a class is reasonably obvious.

It is tempting to decide that interfaces are good, and therefore you should always choose interfaces over concrete classes. Of course, almost anytime you create a class, you could instead create an interface and a factory.

Interfaces should be something you refactor to when necessary, rather than installing the extra level of indirection everywhere, along with the extra complexity.
Interfaces and factories


Inner Classes
 It’s possible to place a class definition within another class definition. This is called an inner class.
Initially, inner classes may seem odd, and it will take some time to become comfortable using them in your designs. The need for inner classes isn’t always obvious

The need for inner classes isn’t always obvious, but after the basic syntax and semantics of inner classes have been described, the section "Why inner classes?" should begin to make clear the benefits of inner classes.

you must specify the type of that object as OuterClassName.InnerClassName, as seen in main( ).

To fetch each of the objects in a Sequence, there’s an interface called Selector. This is an example of the Iterator design pattern that you shall learn more about later in the book.

Here, the SequenceSelector is a private class that provides Selector functionality.

So far, it appears that inner classes are just a name-hiding and code organization scheme, which is helpful but not totally compelling.
This is an example of the Iterator design pattern that you shall learn more about later in the book.

However, the inner class can access methods and fields from the enclosing class as if it owned them. This turns out to be very convenient, as you can see in the preceding example.

So an inner class has automatic access to the members of the enclosing class.

If you need to produce the reference to the outer-class object, you name the outer class followed by a dot and this.

Sometimes you want to tell some other object to create an object of one of its inner classes. To do this you must provide a reference to the other outer-class object in the new expression, using the .new syntax

This also resolves the name scoping issues for the inner class, so you don’t say (indeed, you can’t say) dn.new DotNew.Inner( )

It’s not possible to create an object of the inner class unless you already have an object of the outer class. However, if you make a nested class (a static inner class), then it doesn’t need a reference to the outer-class object.

All you get back is a reference to the base class or the interface.

Inner classes and upcasting
Normal (non-inner) classes cannot be made private or protected; they may only be given public or package access.

Thus, the private inner class provides a way for the class designer to completely prevent any type-coding dependencies and to completely hide details about implementation.

PDestination is protected, so nothing but Parcel4, classes in the same package (since protected also gives package access), and the inheritors of Parcel4 can access PDestination.

Thus, the private inner class provides a way for the class designer to completely prevent any type-coding dependencies and to completely hide details about implementation.

In addition, extension of an interface is useless from the client programmer’s perspective since the client programmer cannot access any additional methods that aren’t part of the public interface.

Inner classes in methods and scopes

Anonymous inner classes
So in effect, an instance initializer is the constructor for an anonymous inner class.

Why did the Java designers go to so much trouble to add this fundamental language feature?
So you could say that an inner class provides a kind of window into the outer class.

So the most compelling reason for inner classes is, Each inner class can independently inherit from an implementation. Thus, the inner class is not limited by whether the outer class is already inheriting from an implementation.

However, if you have abstract or concrete classes instead of interfaces, you are suddenly limited to using inner classes if your class must somehow implement both of the others

Interfaces solve part of the problem, but inner classes effectively allow "multiple implementation inheritance." That is, inner classes effectively allow you to inherit from more than one non-interface.

you can see that an inner class is an object-oriented closure. One of the most compelling arguments made to include some kind of pointer mechanism in Java was to allow callbacks. As you’ve seen by now, Java tends to be more careful than that, so pointers were not included in the language. The closure provided by the inner class is a good solution—more flexible and far safer than a pointer.
Here you can see how interfaces allow for a complete separation of interface from implementation.

The benefit of this will become more evident in the Graphical User Interfaces chapter, where callbacks are used everywhere to implement GUI functionality.

Note that so far in this design you know nothing about exactly what an Event does. And this is the crux of the design—how it "separates the things that change from the things that stay the same."
The following class configures the system by creating a GreenhouseControls object and adding various kinds of Event objects. This is an example of the Command design pattern

arrays

concurrency
By serializing tasks, you can eliminate the need to serialize the objects.
TaskWithResult

Instead of allowing each thread to process whichever job is at the head of the
queue, the master thread controls job assignment
by placing the ID of the thread that
should process the job in each job structure.

On processor architectures in
which the modification takes more than one memory cycle,
this can happen when the
memory read is interleaved between the memory write cycles.

arrays.fill()
arrays.toString()
arrays.toDeepString()

$ echo "# Java" >> README.md
$ git init
 Initialized empty Git repository in D:/ideaworkspace/untitled/src/.git/

$ git add README.md
$  git config --global user.email "806030341@qq.com"
$  git commit -m "first commit"
[master (root-commit) c5cb7f7] first commit
 1 file changed, 1 insertion(+)
 create mode 100644 README.md
$ git branch -M main
$ git remote add origin https://github.com/chenxuguo/Java.git
$ git push -u origin main